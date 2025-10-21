#!/usr/bin/env bash
# realistic-backdate-commits.sh
# Adds realistic-looking backdated commits to the current git repo.
# Usage: ./realistic-backdate-commits.sh [--start YYYY-MM-DD] [--end YYYY-MM-DD] [--file FILENAME] [--dry-run]

set -e

# --- Defaults ---
START_DATE="2020-01-01"
END_DATE="$(date +%Y-%m-%d)"
TARGET_FILE="activity.log"
DRY_RUN=false

# --- Helper: date compatibility (supports macOS + Linux) ---
# date_add DAYS DATE -> prints DATE + DAYS days (ISO YYYY-MM-DD)
date_add() {
  local days=$1; shift
  local d=$1; shift
  if date -d "$d + $days day" >/dev/null 2>&1; then
    date -d "$d + $days day" +%Y-%m-%d
  else
    # macOS: try gdate (from coreutils). If not found, exit with helpful error.
    if command -v gdate >/dev/null 2>&1; then
      gdate -d "$d + $days day" +%Y-%m-%d
    else
      echo "ERROR: your system's date doesn't support '-d'. Install coreutils (gdate) or run on Linux." >&2
      exit 1
    fi
  fi
}

# date_diff_days DATE1 DATE2 -> returns number of days from DATE1 to DATE2 (inclusive start)
date_diff_days() {
  local d1=$1; local d2=$2
  if date -d "$d1" >/dev/null 2>&1; then
    local s1=$(date -d "$d1" +%s)
    local s2=$(date -d "$d2" +%s)
  else
    if command -v gdate >/dev/null 2>&1; then
      local s1=$(gdate -d "$d1" +%s)
      local s2=$(gdate -d "$d2" +%s)
    else
      echo "ERROR: need GNU date (or gdate)." >&2
      exit 1
    fi
  fi
  echo $(( (s2 - s1) / 86400 ))
}

# --- Parse args ---
while [[ $# -gt 0 ]]; do
  case "$1" in
    --start) START_DATE="$2"; shift 2;;
    --end) END_DATE="$2"; shift 2;;
    --file) TARGET_FILE="$2"; shift 2;;
    --dry-run) DRY_RUN=true; shift;;
    *) echo "Unknown arg: $1"; exit 1;;
  esac
done

# validate git repo
if [ ! -d .git ]; then
  echo "ERROR: This folder is not a git repository. Run 'git init' (or cd into your repo) first." >&2
  exit 1
fi

# safety: ensure working tree is clean
if [ -n "$(git status --porcelain)" ] && [ "$DRY_RUN" = false ]; then
  echo "ERROR: Working tree is not clean. Commit or stash changes before running (unless --dry-run)." >&2
  exit 1
fi

# compute days
total_days=$(date_diff_days "$START_DATE" "$END_DATE")
if [ "$total_days" -lt 0 ]; then
  echo "ERROR: start date is after end date." >&2
  exit 1
fi

echo "Starting realistic backdated commits:"
echo "  From: $START_DATE  To: $END_DATE  File: $TARGET_FILE  Dry run: $DRY_RUN"
echo "  Total days to consider: $((total_days + 1))"

# configuration for realism
WEEKDAY_MIN=0
WEEKDAY_MAX=3    # typical commits on weekdays: 0-3
WEEKEND_MIN=0
WEEKEND_MAX=1    # fewer commits on weekends
VACATION_PROB=0.02  # chance to start a vacation streak
MAX_VACATION_DAYS=14
MIN_GAP_PROB=0.12   # chance for a single-day gap (no commits)

# random commit messages choices
MESSAGES=(
  "refactor: small cleanup"
  "docs: update notes"
  "fix: minor bugfix"
  "chore: update config"
  "feat: incremental change"
  "style: formatting"
  "test: add small test"
  "perf: small improvement"
  "ci: tweak workflow"
  "wip: save work"
)

# helper to get day of week (1..7, Mon..Sun)
day_of_week() {
  local d=$1
  if date -d "$d" +%u >/dev/null 2>&1; then
    date -d "$d" +%u
  else
    gdate -d "$d" +%u
  fi
}

# helper to generate ISO timestamp for a given date and random time
random_time_on_date() {
  local d=$1
  # active hours skew: more activity 9-20, fewer at night
  # generate hour with weighted distribution toward daytime
  hour=$(( RANDOM % 12 + 8 ))  # 8..19
  minute=$(( RANDOM % 60 ))
  second=$(( RANDOM % 60 ))
  printf "%sT%02d:%02d:%02d" "$d" "$hour" "$minute" "$second"
}

# main loop
current="$START_DATE"
vacation_days_left=0

while [ "$(date -d "$current" +%s 2>/dev/null || gdate -d "$current" +%s)" -le "$(date -d "$END_DATE" +%s 2>/dev/null || gdate -d "$END_DATE" +%s)" ]; do
  dow=$(day_of_week "$current") # 1..7
  is_weekend=false
  if [ "$dow" -ge 6 ]; then
    is_weekend=true
  fi

  # decide if a vacation/gap starts
  if [ "$vacation_days_left" -eq 0 ]; then
    r=$(( RANDOM % 100 ))
    # small chance to start a vacation
    if [ $r -lt $(echo "$VACATION_PROB * 100" | bc | cut -d. -f1) ]; then
      vacation_days_left=$(( RANDOM % MAX_VACATION_DAYS + 3 ))  # 3..(MAX_VACATION_DAYS+2)
      # on vacation day we skip commits
    fi
  fi

  # optionally create a single-day gap even if not vacation
  gap_today=false
  r2=$(( RANDOM % 100 ))
  if [ $r2 -lt $(echo "$MIN_GAP_PROB * 100" | bc | cut -d. -f1) ]; then
    gap_today=true
  fi

  if [ "$vacation_days_left" -gt 0 ]; then
    # skip commits this day
    if [ "$DRY_RUN" = true ]; then
      echo "[SKIP vacation] $current"
    fi
    vacation_days_left=$((vacation_days_left - 1))
    current=$(date_add 1 "$current")
    continue
  fi

  if [ "$gap_today" = true ]; then
    if [ "$DRY_RUN" = true ]; then
      echo "[SKIP gap] $current"
    fi
    current=$(date_add 1 "$current")
    continue
  fi

  # choose commit count based on weekend/weekday
  if [ "$is_weekend" = true ]; then
    minc=$WEEKEND_MIN; maxc=$WEEKEND_MAX
  else
    minc=$WEEKDAY_MIN; maxc=$WEEKDAY_MAX
  fi

  # small randomness: some weekdays have 0 commits
  range=$((maxc - minc + 1))
  if [ "$range" -le 0 ]; then
    commits_today=0
  else
    commits_today=$(( RANDOM % range + minc ))
  fi

  # realistic tweak: occasionally have productive days with more commits
  if [ $((RANDOM % 100)) -lt 2 ]; then
    commits_today=$((commits_today + RANDOM % 3 + 1))
  fi

  if [ "$DRY_RUN" = true ]; then
    if [ "$commits_today" -gt 0 ]; then
      echo "[DRY] $current -> $commits_today commits"
    fi
  else
    for ((c=1; c<=commits_today; c++)); do
      ts=$(random_time_on_date "$current")
      echo "[$ts] Commit $c on $current" >> "$TARGET_FILE"

      git add "$TARGET_FILE"

      # pick a message
      msg="${MESSAGES[$RANDOM % ${#MESSAGES[@]}]}"

      GIT_AUTHOR_DATE="$ts" GIT_COMMITTER_DATE="$ts" git commit -m "$msg ($ts)" >/dev/null 2>&1
    done
  fi

  current=$(date_add 1 "$current")
done

echo "Done. (dry-run=$DRY_RUN)"
echo "If not dry-run, don't forget to push: git push origin HEAD:main"
