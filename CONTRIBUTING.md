# Contributing to Code-Contribution

Thank you for your interest in contributing to Code-Contribution! We appreciate your efforts to improve the project. Please take a moment to review this guide to make the contribution process smooth and effective for everyone.

## Table of Contents
1. [Getting Started](#getting-started)
2. [Reporting Bugs](#reporting-bugs)
3. [Suggesting Enhancements](#suggesting-enhancements)
4. [Contributing Code](#contributing-code)
5. [Coding Guidelines](#coding-guidelines)
6. [Documentation Standards](#documentation-standards)
7. [Code Review Process](#code-review-process)
8. [License](#license)

## Getting Started

1. **Fork the repository** to your own GitHub account.
2. **Clone your forked repository** to your local machine:

   ```bash
   git clone https://github.com/your-username/Code-Contribution.git
4. **Install dependencies** if any are specified in the README.md.
5. Create a new branch for each feature or bug fix:
   
   ```bash
    git checkout -b feature/your-feature-name
## Reporting Bugs
If you find a bug, please open an issue. Include details such as:

- A clear and descriptive title
- Steps to reproduce the issue
- Expected behavior and actual behavior
- Screenshots, if applicable
- Environment (OS, language version, etc.)

## Suggesting Enhancements
Enhancement suggestions can be submitted as issues. Include:

- A descriptive title
- The motivation and benefits of the enhancement
- Relevant examples, links, or code snippets
## Contributing Code
1. Ensure your code is well-documented and adheres to the Coding Guidelines.
2. Write clear commit messages.
3. Add test cases for any new functionality, if applicable.
4. Push your branch to GitHub:
 
   ```bash
   git push origin feature/your-feature-name

6. Open a Pull Request (PR) to the main branch of Code-Contribution with:
- A descriptive title and summary
- A link to any related issues
- A list of changes made
## Coding Guidelines

### General Principles
- **Code Style:** Follow consistent and readable code conventions for your language.
- **Documentation:** All code must include proper documentation (see language-specific guidelines below).
- **Tests:** Run existing tests and add tests for new features where applicable.
- **Naming Conventions:** Use descriptive, meaningful names for variables, functions, and classes.
- **DRY Principle:** Don't Repeat Yourself - avoid code duplication.
- **KISS Principle:** Keep It Simple, Stupid - favor simplicity over complexity.

### Language-Specific Guidelines

#### Python
- **Style Guide:** Follow [PEP 8](https://pep8.org/) style guide.
- **Docstrings:** Use triple-quoted docstrings for all functions, classes, and modules.
  ```python
  def function_name(param1: str, param2: int) -> bool:
      """
      Brief description of what the function does.
      
      Args:
          param1 (str): Description of param1
          param2 (int): Description of param2
      
      Returns:
          bool: Description of return value
      
      Raises:
          ValueError: When param2 is negative
      
      Example:
          >>> function_name("test", 5)
          True
      """
      pass
  ```
- **Type Hints:** Use type hints for function parameters and return values.
- **Naming:** Use `snake_case` for functions and variables, `PascalCase` for classes.

#### Java
- **Style Guide:** Follow [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).
- **JavaDoc:** Use JavaDoc comments for all public classes and methods.
  ```java
  /**
   * Brief description of what the class/method does.
   * 
   * @param param1 Description of param1
   * @param param2 Description of param2
   * @return Description of return value
   * @throws IllegalArgumentException When param2 is negative
   * 
   * @example
   * <pre>
   * MyClass obj = new MyClass();
   * boolean result = obj.methodName("test", 5);
   * </pre>
   */
  public boolean methodName(String param1, int param2) {
      // implementation
  }
  ```
- **Naming:** Use `camelCase` for methods and variables, `PascalCase` for classes.
- **Constants:** Use `UPPER_SNAKE_CASE` for constants.

#### JavaScript/TypeScript
- **Style Guide:** Follow [Airbnb JavaScript Style Guide](https://github.com/airbnb/javascript).
- **JSDoc:** Use JSDoc comments for all functions.
  ```javascript
  /**
   * Brief description of what the function does.
   * 
   * @param {string} param1 - Description of param1
   * @param {number} param2 - Description of param2
   * @returns {boolean} Description of return value
   * @throws {TypeError} When param2 is not a number
   * 
   * @example
   * const result = functionName('test', 5);
   * console.log(result); // true
   */
  function functionName(param1, param2) {
      // implementation
  }
  ```
- **Naming:** Use `camelCase` for functions and variables, `PascalCase` for classes.
- **Modern Syntax:** Prefer `const`/`let` over `var`, use arrow functions where appropriate.

#### C/C++
- **Style Guide:** Follow [Google C++ Style Guide](https://google.github.io/styleguide/cppguide.html).
- **Doxygen Comments:** Use Doxygen-style comments for functions and classes.
  ```cpp
  /**
   * @brief Brief description of what the function does.
   * 
   * @param param1 Description of param1
   * @param param2 Description of param2
   * @return Description of return value
   * 
   * @note Any important notes about the function
   * 
   * @example
   * @code
   * int result = functionName(5, 10);
   * printf("%d", result);
   * @endcode
   */
  int functionName(int param1, int param2) {
      // implementation
  }
  ```
- **Naming:** Use `snake_case` for functions and variables (C) or `camelCase` (C++).
- **Memory Management:** Always free allocated memory, check for NULL pointers.

### Documentation Requirements

#### For All Code Contributions
1. **File Header:** Include a header comment with:
   - Brief description of the file's purpose
   - Author information (optional)
   - License information (if applicable)

2. **Function/Method Documentation:**
   - Clear description of what it does
   - All parameters explained
   - Return value described
   - Exceptions/errors documented
   - At least one usage example

3. **Inline Comments:**
   - Explain complex logic or algorithms
   - Use comments for "why" not "what"
   - Keep comments up-to-date with code changes

4. **Examples:**
   - Include working examples that demonstrate usage
   - Cover common use cases
   - Show edge cases where applicable

### Code Quality Checklist

Before submitting your PR, ensure:
- [ ] All functions have proper documentation
- [ ] Code follows language-specific style guides
- [ ] Examples are included and tested
- [ ] Variable/function names are descriptive
- [ ] No commented-out code (remove or explain why it's there)
- [ ] Error handling is implemented where needed
- [ ] Code is formatted consistently
- [ ] No unnecessary console.log/print statements in production code

## Documentation Standards

Comprehensive documentation is **required** for all code contributions. This helps new contributors understand the project and makes the codebase more maintainable.

### Quick Reference

All code must include:
- ✅ File-level documentation explaining purpose
- ✅ Function/method documentation with parameters and return values
- ✅ At least one working usage example
- ✅ Inline comments for complex logic
- ✅ Updated README in the relevant language directory

### Detailed Documentation Guide

For comprehensive documentation standards, examples, and best practices, see:

📚 **[DOCUMENTATION_GUIDE.md](DOCUMENTATION_GUIDE.md)** - Complete guide with examples for all languages

### Language-Specific Standards

- **Python:** [Python/README.md](Python/README.md) - PEP 257 docstring standards
- **Java:** [Java/README.md](Java/README.md) - JavaDoc guidelines
- **JavaScript:** [Javascript/README.md](Javascript/README.md) - JSDoc standards
- **C:** [C/README.md](C/README.md) - Doxygen standards
- **C++:** [C++/README.md](C++/README.md) - Doxygen standards for C++

### Documentation Template Example

Here's a quick template for documenting a function (language-specific formats in the guide):

```
Function/Method Documentation:
├── Brief one-line description
├── Detailed explanation (if needed)
├── Parameters with types and descriptions
├── Return value with type and description
├── Exceptions/errors that may be raised
├── At least one usage example
└── Notes about edge cases or performance
```

### Before Submitting Your PR

Use this checklist to ensure your documentation meets standards:

- [ ] All functions have complete documentation
- [ ] Parameters and return types are documented
- [ ] At least one working example is included
- [ ] Complex algorithms are explained
- [ ] Edge cases and limitations are noted
- [ ] Language-specific format is followed (JavaDoc, JSDoc, etc.)
- [ ] README in language directory is updated

### Getting Help with Documentation

If you're unsure about documentation:

1. Check **[DOCUMENTATION_GUIDE.md](DOCUMENTATION_GUIDE.md)** for examples
2. Look at well-documented files in the repository
3. Use GitHub Copilot to generate documentation templates
4. Ask maintainers in your PR for guidance

Remember: **Good documentation is as important as good code!** 📚
## Code Review Process
1. Pull requests will be reviewed by the maintainers. Be prepared to make revisions based on feedback.
2. Once approved, your code will be merged into the main branch.
3. If your contribution adds substantial changes, ensure that they are well-tested and documented.

### Using GitHub Copilot for Code Review

GitHub Copilot can assist in the code review process:

1. **Before Submitting:**
   - Use Copilot to generate documentation for undocumented functions
   - Ask Copilot to review your code for potential issues
   - Request suggestions for improving code readability

2. **Configuring Copilot for Code Review:**
   - Enable [GitHub Copilot code review](https://docs.github.com/en/copilot/customizing-copilot/adding-custom-instructions-for-github-copilot) features
   - Set up custom instructions for your coding standards
   - Use Copilot Chat to explain complex code sections

3. **Best Practices:**
   - Review Copilot suggestions carefully before accepting
   - Use Copilot to generate test cases
   - Ask Copilot to identify potential bugs or security issues

### Leveraging Your GitHub Profile

Your contributions to this project can enhance your professional profile:

- **Showcase Your Work:** Pin this repository to your GitHub profile
- **Build Your Portfolio:** Quality contributions demonstrate your skills
- **Resume Enhancement:** Include your open-source contributions
- **Professional Network:** Connect with other contributors
- **Learn More:** [Using your GitHub profile to enhance your resume](https://docs.github.com/en/account-and-profile/setting-up-and-managing-your-github-profile/customizing-your-profile/about-your-profile)
## License
By contributing, you agree that your contributions will be licensed under the same license as Code-Contribution.

### Thank you for helping improve Code-Contribution!
