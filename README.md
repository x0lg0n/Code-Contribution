# Hacktoberfest 2024 & Hacksquad 2024

## Join the Fun and Get Free Swag!

Hacktoberfest is here, and so is Hacksquad 2024! Contribute to open-source projects, learn new programming languages, and earn amazing goodies by simply writing a 'Hello World' program. Fork this repository, add your 'Hello World' program, and send a Pull Request to participate!

### Don't forget to star this repository!

---

## What is Hacksquad?

HackSquad allows contributors to join forces and contribute code as a team instead of as individual contributors. Engage in a friendly competition with the community throughout October.

## What is Hacktoberfest?

Hacktoberfest is an annual event that encourages contributions to open-source projects on platforms like GitHub. It takes place throughout October, promoting open-source collaboration and community participation. Contributors are rewarded with limited-edition swag, such as t-shirts and stickers, for making a certain number of valid pull requests to open-source repositories.

---

## How to Participate

### 1. Register for Hacktoberfest and Hacksquad 2024

- [Hacktoberfest Registration](https://hacktoberfest.digitalocean.com/)
- [Hacksquad Registration](https://www.hacksquad.dev/)

### 2. Fork this Repository

Click the <kbd><b>Fork</b></kbd> button to create your own copy of [this repository](https://github.com/shivaylamba/Hacktoberfest).

### 3. Add a 'Hello World' Program

- Add your program in the appropriate language folder in the main branch.
- If the language folder doesn't exist, create one and add your program.

### 4. Ready, Set, Go!

- Check our `Help Wanted` issues and create [pull requests](https://github.com/x0lg0n/Code-Contribution/pulls).

### 5. Star the Repository

If you enjoyed contributing, please star this repository and share it with others to help spread the word and support open-source contributions.

---

## Steps to Contribute Using Git

### Cloning the Repository

1. Open a terminal window.
2. Use the `git clone` command with the URL of your forked repository:

   ```bash
   git clone https://github.com/your-username/Code-Contribution.git
   ```

### Creating a New Branch

1. Change into the repository directory:

   ```bash
   cd Code-Contribution
   ```

2. Create a new branch:

   ```bash
   git branch new-branch
   ```

3. Switch to the new branch:

   ```bash
   git checkout new-branch
   ```

### Making Changes

1. Add your changes to the staging area:

   ```bash
   git add -A
   ```

2. Commit your changes with a descriptive message:

   ```bash
   git commit -m "Add Hello World in [Language]"
   ```

3. Push your branch to your forked repository:

   ```bash
   git push origin new-branch
   ```

### Syncing Your Fork

1. Add the upstream repository:

   ```bash
   git remote add upstream https://github.com/x0lg0n/Code-Contribution.git
   ```

2. Fetch the latest changes:

   ```bash
   git fetch upstream
   ```

3. Merge the changes into your local master branch:

   ```bash
   git checkout master
   git merge upstream/master
   ```

### Creating a Pull Request

1. Navigate to your forked repository on GitHub.
2. Click the "New pull request" button.
3. Provide a descriptive title and summary of your changes.
4. Submit the pull request.

---

## Purpose of the Repository

This repository serves as a platform for developers to contribute to open-source projects during Hacktoberfest and Hacksquad 2024. By adding a 'Hello World' program in any programming language, contributors can participate in these events, learn new languages, and collaborate with the community.

## Example Contributions

Here are some examples of 'Hello World' programs in different programming languages:

### Python

```python
print("Hello, World!")
```

### JavaScript

```javascript
console.log("Hello, World!");
```

### C++

```cpp
#include <iostream>
int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
```

Feel free to explore the repository and see more examples in various languages. Happy contributing!

---

## Jekyll Theme

This repository uses the Jekyll theme `minima`. To run the site locally, follow these steps:

1. **Install Jekyll**: Make sure you have Ruby and Bundler installed. Then install Jekyll with the following command:

   ```bash
   gem install jekyll bundler
   ```

2. **Clone the repository**: If you haven't already, clone the repository to your local machine:

   ```bash
   git clone https://github.com/your-username/Code-Contribution.git
   ```

3. **Navigate to the repository directory**:

   ```bash
   cd Code-Contribution
   ```

4. **Install dependencies**: Install the required dependencies using Bundler:

   ```bash
   bundle install
   ```

5. **Run the Jekyll site**: Use the following command to build and serve the site locally:

   ```bash
   bundle exec jekyll serve
   ```

6. **Open your browser**: Open your web browser and go to `http://localhost:4000` to see the site.

For more information on Jekyll, visit the [Jekyll documentation](https://jekyllrb.com/docs/).

---

Thank you for contributing to Hacktoberfest and Hacksquad 2024! Let's make open-source better together.
