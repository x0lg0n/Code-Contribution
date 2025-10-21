#!/bin/bash

# Script to generate daily fake commits from 2020 to today

git init
echo "Starting fake daily history..." > history.txt
git add history.txt
git commit -m "Initialize fake history" >/dev/null 2>&1

# Loop through every day from Jan 1, 2020 to today
# Note : you can change the start_date to any date you want
start_date="2020-01-01"
end_date=$(date +%Y-%m-%d)

current_date="$start_date"
while [ "$(date -d "$current_date" +%s)" -le "$(date -d "$end_date" +%s)" ]; do
  # Random number of commits for the day (1–5)
  num_commits=$((RANDOM % 5 + 1))

  for ((i=1; i<=num_commits; i++)); do
    hour=$((RANDOM % 24))
    minute=$((RANDOM % 60))
    second=$((RANDOM % 60))

    commit_time="${current_date}T$(printf "%02d" $hour):$(printf "%02d" $minute):$(printf "%02d" $second)"

    echo "Commit on $commit_time" >> history.txt
    git add history.txt
    GIT_AUTHOR_DATE="$commit_time" GIT_COMMITTER_DATE="$commit_time" git commit -m "Commit on $commit_time" >/dev/null 2>&1
  done

  # Move to the next day
  current_date=$(date -I -d "$current_date + 1 day")
done

echo "✅ Finished generating daily commits from 2020 to today!"
