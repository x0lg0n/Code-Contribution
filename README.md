# 🌟Hacktoberfest 2025 & Hacksquad 2025 🎉

Welcome to **Code-Contribution**!  
This repo is your entry point to **Hacktoberfest & Hacksquad** — a month-long celebration of open-source and community collaboration 💻🌍.  

Whether you're a beginner writing your first **Hello World** 🐣 or an experienced developer adding new features, **you belong here**.  
Contribute, learn, and earn **cool swag like T-shirts & stickers** 👕🎁.  

👉 Don’t forget to ⭐ star this repository to show support!

---

## 🚀 What is Hacktoberfest?

Hacktoberfest is an annual event that encourages contributions to open-source projects on GitHub.  
Throughout October, developers across the globe collaborate, contribute, and celebrate open source.  

**Rewards**: Contribute 4+ valid pull requests and earn **limited edition swag** 🎁.  

---

## 🤝 What is Hacksquad?

HackSquad lets you **team up with friends or other devs** to contribute together.  
Instead of competing alone, you collaborate as a squad and climb the leaderboard 🏆.  

A fun way to **learn, grow, and win together** ✨.  

---

## 🎯 Why Participate?

✅ Learn new programming languages  
✅ Improve your Git & GitHub skills  
✅ Contribute to real-world projects  
✅ Network with a global dev community 🌍  
✅ Earn **swag, stickers, T-shirts & recognition**  

---

## 🛠️ How to Participate

### 1️⃣ Register

- [👉 Hacktoberfest Registration](https://hacktoberfest.com/)  
- [👉 Hacksquad Registration](https://www.hacksquad.dev/) 

### 2️⃣ Fork This Repository
Click the <kbd>Fork</kbd> button to create your copy of [this repository](https://github.com/x0lg0n/Code-Contribution).


### 3️⃣ Add Your "Hello World"
- Navigate to the folder for your language.  
- If it doesn’t exist, create it (e.g. `python/`, `cpp/`).  
- Add your file (`hello_world.py`, `hello_world.cpp`, etc.). 

### 4️⃣ Commit & Push
```bash
git add .
git commit -m "✨ Added Hello World in Python"
git push origin my-branch
```

### 5️⃣ Open a Pull Request
- Go to your fork on GitHub.
- Click Compare & Pull Request.
- Submit your PR 📨.

---

## 🔧 Steps to Contribute Using Git

### Cloning the Repository

1. Open a terminal window.
2. Use the `git clone` command with the URL of your forked repository:

   ```bash
   git clone https://github.com/your-username/Code-Contribution.git
   cd Code-Contribution
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

## 📚 Code Documentation Standards

### Why Documentation Matters

Good documentation is essential for:
- **Onboarding:** Helps new contributors understand the codebase quickly
- **Maintenance:** Makes code easier to maintain and debug
- **Collaboration:** Enables effective teamwork
- **Learning:** Serves as a learning resource for others
- **Professionalism:** Demonstrates coding maturity and best practices

### Documentation Requirements

All code contributions must include:

1. **File-level documentation** - Brief description of the file's purpose
2. **Function/method documentation** - Parameters, return values, and examples
3. **Inline comments** - Explanation of complex logic (the "why", not the "what")
4. **Usage examples** - At least one working example demonstrating the code
5. **README updates** - Add your contribution to the relevant directory README

### Language-Specific Standards

We follow industry-standard documentation practices:

| Language | Standard | Example |
|----------|----------|---------|
| **Python** | PEP 257 Docstrings | `"""Brief description.\n\nArgs:\n    param: Description\n"""` |
| **Java** | JavaDoc | `/** @param name Description */` |
| **JavaScript** | JSDoc | `/** @param {string} name - Description */` |
| **C/C++** | Doxygen | `/** @brief Description\n@param name Description */` |
| **C#** | XML Documentation | `/// <summary>Description</summary>` |

### Quick Examples

#### Python Documentation
```python
def calculate_average(numbers: list) -> float:
    """
    Calculate the arithmetic mean of a list of numbers.
    
    Args:
        numbers (list): List of numeric values
    
    Returns:
        float: The average value
    
    Example:
        >>> calculate_average([1, 2, 3, 4, 5])
        3.0
    """
    return sum(numbers) / len(numbers)
```

#### Java Documentation
```java
/**
 * Sorts an array using the bubble sort algorithm.
 * 
 * @param arr Array to be sorted (modified in-place)
 * @throws NullPointerException if array is null
 * 
 * @example
 * <pre>{@code
 * int[] nums = {5, 2, 8, 1};
 * bubbleSort(nums);
 * // nums is now {1, 2, 5, 8}
 * }</pre>
 */
public static void bubbleSort(int[] arr) {
    // implementation
}
```

#### JavaScript Documentation
```javascript
/**
 * Debounces a function call.
 * 
 * @param {Function} func - Function to debounce
 * @param {number} delay - Delay in milliseconds
 * @returns {Function} Debounced function
 * 
 * @example
 * const debouncedSearch = debounce(search, 300);
 * debouncedSearch('query');
 */
function debounce(func, delay) {
    // implementation
}
```

### Resources

- 📖 **[CONTRIBUTING.md](CONTRIBUTING.md)** - Full contribution guidelines with detailed coding standards
- 🐍 **[Python/README.md](Python/README.md)** - Python-specific documentation standards
- ☕ **[Java/README.md](Java/README.md)** - Java JavaDoc guidelines
- 📜 **[Javascript/README.md](Javascript/README.md)** - JSDoc standards for JavaScript
- 🔧 **[C/README.md](C/README.md)** - Doxygen standards for C code

### Tools & Best Practices

#### Using GitHub Copilot

GitHub Copilot can help improve your documentation:
- **Generate docstrings:** Ask Copilot to add documentation to your functions
- **Code review:** Use Copilot to identify missing documentation
- **Examples:** Request example usage code
- **Best practices:** Ask about language-specific documentation standards

Learn more: [Configuring GitHub Copilot for code review](https://docs.github.com/en/copilot/customizing-copilot/adding-custom-instructions-for-github-copilot)

#### Enhancing Your GitHub Profile

Your contributions here can boost your professional profile:
- ✨ **Showcase quality code** with excellent documentation
- 📊 **Build your portfolio** with diverse language examples
- 🤝 **Demonstrate collaboration** through meaningful PRs
- 📝 **Highlight on resume** as open-source experience

Read more: [Using your GitHub profile to enhance your resume](https://docs.github.com/en/account-and-profile/setting-up-and-managing-your-github-profile/customizing-your-profile/about-your-profile)

---

## 🗂️ Repository Structure

```
Code-Contribution/
├── .github/              # GitHub templates and workflows
├── _includes/            # Jekyll includes
├── _layouts/             # Jekyll layouts
├── Bash/                 # Bash scripts with examples
├── C/                    # C programs with Doxygen docs
├── C#/                   # C# programs with XML docs
├── C++/                  # C++ programs with Doxygen docs
├── Dart/                 # Dart programs
├── Fortran/              # Fortran programs
├── Java/                 # Java programs with JavaDoc
├── Javascript/           # JavaScript with JSDoc
├── Kotlin/               # Kotlin programs
├── Perl/                 # Perl scripts
├── PHP/                  # PHP scripts
├── Python/               # Python with docstrings
├── R/                    # R scripts
├── Ruby/                 # Ruby programs
├── Rust/                 # Rust programs
├── Scala/                # Scala programs
├── Swift/                # Swift programs
├── CONTRIBUTING.md       # Detailed contribution guidelines
├── LICENSE               # Project license
└── README.md             # This file
```

Each language directory contains:
- 📄 **README.md** - Language-specific coding standards and examples
- 💻 **Code files** - Fully documented example programs
- 📝 **Documentation** - Following language conventions

---

## Purpose of the Repository

This repository serves as a beginner-friendly gateway to open-source.
By contributing here, you can:
1. Practice Git & GitHub workflows
2. Explore different programming languages
3. Make your first open-source PR
4. Join the Hacktoberfest & Hacksquad celebration 🎉

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

### 🎨 Make It Fun — Add Creativity!

You can also:
 - Add fun "Hello World" in different languages
- Use ASCII art, emojis, or creative formatting 🎭
- Share your experience in PR description

## 🧑‍💻 Jekyll Theme

This repository uses the Jekyll theme `minima`. To run locally:

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

More information on Jekyll, visit the [Jekyll documentation](https://jekyllrb.com/docs/).

---


❤️ Thank You

Hacktoberfest is about community, learning, and fun.
Let’s make 2025 the biggest and most engaging yet 🥳.

Happy Contributing 🚀
