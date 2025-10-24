
# Git Cheat Sheet — quick commands for beginners

This is a compact, beginner-friendly git cheat sheet to help with common workflows when contributing to open-source projects.

---

## Setup (one-time)

- Configure your identity:
  ```bash
  git config --global user.name "Your Name"
  git config --global user.email "you@example.com"
  ```
- Enable helpful defaults (optional):
  ```bash
  git config --global core.editor "code --wait"    # VS Code as editor
  git config --global pull.rebase false             # merge on pull by default
  git config --global color.ui auto
  ```

## Clone a repo

- Clone your fork or a repo:
  ```bash
  git clone https://github.com/your-username/repo.git
  ```

## Branching workflow (recommended for PRs)

- Create a feature branch:
  ```bash
  git checkout -b my-fix-name
  ```
- See branches:
  ```bash
  git branch        # local
  git branch -r     # remote
  git branch -a     # all
  ```

## Make changes, stage, and commit

- Stage changed files:
  ```bash
  git add file1 file2
  git add .          # stage everything (be careful)
  ```
- Commit with a message:
  ```bash
  git commit -m "Short, descriptive message"
  ```
- Amend last commit (if not pushed):
  ```bash
  git commit --amend -m "Refined message"
  ```

## Keep your branch up-to-date with upstream

- Add upstream (one-time per repo):
  ```bash
  git remote add upstream https://github.com/original-owner/repo.git
  ```
- Fetch upstream updates and rebase your branch (clean history):
  ```bash
  git fetch upstream
  git checkout main
  git fetch upstream
  git merge upstream/main    # or: git rebase upstream/main
  git checkout my-fix-name
  git rebase main            # replay your commits on top of updated main
  ```
- If rebase causes conflicts, resolve them, then:
  ```bash
  git add <resolved-files>
  git rebase --continue
  ```

## Push and open a PR

- Push branch to your fork:
  ```bash
  git push origin my-fix-name
  ```
- Open a Pull Request on GitHub, link the issue, and include testing steps.

## Updating a PR branch after review

- Make more commits and push; the PR updates automatically:
  ```bash
  git add .
  git commit -m "Address review: ..."
  git push origin my-fix-name
  ```
- If you rebased locally, force-push (use with care):
  ```bash
  git push --force-with-lease origin my-fix-name
  ```

## Undo mistakes (safe first)

- Unstage a file:
  ```bash
  git restore --staged file.txt   # Git 2.23+
  ```
- Discard local working changes (danger: irreversible):
  ```bash
  git restore file.txt
  ```
- Revert a commit that has been pushed (creates a new commit):
  ```bash
  git revert <commit-hash>
  ```

## Useful inspection commands

- See commit history:
  ```bash
  git log --oneline --graph --decorate --all
  ```
- Show changes in working tree:
  ```bash
  git status
  git diff          # unstaged changes
  git diff --staged # staged changes
  ```

## Stash (temporarily shelve changes)

- Save work-in-progress:
  ```bash
  git stash push -m "WIP: short note"
  ```
- Apply the latest stash and keep it:
  ```bash
  git stash apply
  ```
- Pop the latest stash (apply + drop):
  ```bash
  git stash pop
  ```

## Config & shortcuts (optional)

- Set useful aliases:
  ```bash
  git config --global alias.co checkout
  git config --global alias.br branch
  git config --global alias.ci commit
  git config --global alias.st status
  ```

## Safety tips

- Use `--force-with-lease` instead of `--force` to avoid clobbering others' work.  
- Run tests locally before opening PRs.  
- Keep PRs small and focused.

---

