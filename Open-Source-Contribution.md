# 🌍 Open Source Contribution Cheat Sheet

A concise guide to find projects, make contributions, and grow as a developer.

---

## 🔎 Finding projects
- Browse GitHub Explore: https://github.com/explore  
- Search sites: Good First Issue (https://goodfirstissue.dev), Up-for-Grabs (https://up-for-grabs.net)  
- Look for labels: `good first issue`, `help wanted`, `beginner-friendly`  
- Join community channels: Discord, Gitter, Slack, mailing lists

---

## 🛠️ Getting started
1. Fork the repository to your GitHub account.  
2. Clone your fork:
```bash
git clone <your-fork-url>
```
3. (Optional) Add upstream to keep your fork in sync:
```bash
git remote add upstream <original-repo-url>
git fetch upstream
git checkout main
git merge upstream/main
```
4. Install dependencies — follow the repository README.

---

## 💻 Making contributions
- Create a feature branch:
```bash
git checkout -b my-feature
```
- Make changes, stage, and commit:
```bash
git add .
git commit -m "Short, descriptive message"
```
- Keep commits focused and atomic.

---

## 🚀 Submitting your changes
- Push your branch to your fork:
```bash
git push origin my-feature
```
- Open a Pull Request (PR) against the original repository.  
- Fill the PR template, describe the problem and your solution, and include testing steps.  
- Respond to reviews and update your branch as requested.

---

## 👍 Best practices
- Read `CONTRIBUTING.md`, `README.md`, and `CODE_OF_CONDUCT.md`.  
- Write clear commit messages and PR descriptions.  
- Respect project style and tests.  
- Be patient, polite, and open to feedback.  
- Ask maintainers or the community when unsure.

---

## ⭐ Helpful resources
- How to Contribute to Open Source — https://opensource.guide/how-to-contribute/  
- First Contributions tutorial — https://github.com/firstcontributions/first-contributions  
- Good First Issues / Up-for-Grabs — links above

Open source is for everyone — learn, collaborate, and make an impact!

---

## 🧭 Additional beginner resources

Here are curated resources to help beginners get started quickly. They include step-by-step tutorials, places to find easy issues, and quick checklists for your first PR.

- Open Source Guides (GitHub) — https://opensource.guide/ (how to contribute, community, licensing)  
- First Contributions — https://github.com/firstcontributions/first-contributions (hands-on first-PR tutorial)  
- Good First Issues — https://goodfirstissue.dev/ (find beginner-friendly issues across GitHub)  
- Up For Grabs — https://up-for-grabs.net/ (projects that tag beginner-friendly tasks)  
- CodeTriage — https://www.codetriage.com/ (get issues to triage and practice)  
- First Timers Only — https://www.firsttimersonly.com/ (encouragement and links for first contributions)  
- How to Contribute to Open Source (guide) — https://opensource.guide/how-to-contribute/  
- freeCodeCamp contributor guides and tutorials — https://www.freecodecamp.org/news/tag/open-source/  

## 🔎 Where to find beginner-friendly issues

- Search repositories for labels: `good first issue`, `good-first-issue`, `help wanted`, `beginner-friendly`.  
- Explore topic pages: `https://github.com/topics/good-first-issue`  
- Use issue aggregators: Good First Issues, Up For Grabs, and CodeTriage above.  

## 🧰 Quick Git & GitHub essentials (cheat sheet)

- Clone your fork: `git clone <your-fork-url>`  
- Create a branch: `git checkout -b my-fix`  
- Stage & commit: `git add .` then `git commit -m "Short descriptive message"`  
- Keep your branch up-to-date with upstream:  

- Full git cheat sheet: [GIT-CHEAT-SHEET.md](./GIT-CHEAT-SHEET.md)  

	Keep your branch up-to-date with upstream:  
	`git remote add upstream <original-repo>`  
	`git fetch upstream`  
	`git rebase upstream/main` (or `git merge upstream/main`)  
- Push and open PR: `git push origin my-fix` → Open PR on GitHub  

## ✅ First PR checklist (quick)

1. Did you read `CONTRIBUTING.md`, `README.md`, and `CODE_OF_CONDUCT.md`?  
2. Is there an open issue you are addressing? Link it in the PR.  
3. Small, focused commits and a clear commit message.  
4. Follow the project's coding style and run linters locally.  
5. Run the test suite and ensure all tests pass.  
6. Update docs or changelog if behavior changed.  
7. Add screenshots or logs for UI/UX changes.  
8. Check if the project requires a Contributor License Agreement (CLA).  
9. Keep your PR description clear: what, why, and how to test.  

## 🤝 Communication & etiquette

- Be polite and patient — maintainers are often volunteers.  
- Ask clarifying questions in the issue/PR if something is unclear.  
- If a reviewer requests changes, make them in the same branch and push — CI will re-run.  
- If you need help, mention a friendly maintainer or ask in project chat channels.  

## 🧑‍🏫 Learning paths (short suggestions)

- Start with small docs fixes or typo corrections to learn the repo structure.  
- Tackle a tiny bug or add tests — this teaches project conventions and CI.  
- Pair with other contributors (many projects have mentorship or pairing programs).  

## 🔗 Communities & mentorship

- Look for project chat (Discord, Gitter, Zulip, Slack) and introduce yourself.  
- Join wider communities: GitHub Community Forum, freeCodeCamp forums, or language-specific groups.  

---

Happy contributing — start small, stay curious, and iterate. Your first contribution can be just the beginning of many more!