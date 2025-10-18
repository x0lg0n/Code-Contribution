# Contributing to Code-Contribution 🚀

Thank you for your interest in contributing to Code-Contribution! We appreciate your efforts to improve the project. Please take a moment to review this guide to make the contribution process smooth and effective for everyone.

## Table of Contents
1. [Getting Started](#getting-started)
2. [Reporting Bugs](#reporting-bugs)
3. [Suggesting Enhancements](#suggesting-enhancements)
4. [Contributing Code](#contributing-code)
5. [Coding Guidelines](#coding-guidelines)
6. [Documentation Standards](#documentation-standards)
7. [Code Review Process](#code-review-process)
8. [Best Practices](#best-practices)
9. [License](#license)

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
- **Code Style:** Follow consistent and readable code conventions for your programming language.
- **Naming Conventions:** Use descriptive variable and function names.
- **Keep It Simple:** Write clear, maintainable code that others can understand.
- **DRY Principle:** Don't Repeat Yourself - avoid code duplication.
- **Error Handling:** Include proper error handling and validation.

### Language-Specific Guidelines

#### Python
- Follow [PEP 8](https://pep8.org/) style guide
- Use meaningful variable names (snake_case)
- Maximum line length: 79 characters
- Use type hints where appropriate
- Include docstrings for all functions and classes

#### Java
- Follow [Oracle's Java Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)
- Use camelCase for variables and methods
- Use PascalCase for class names
- Include Javadoc comments for public methods and classes
- Proper exception handling with try-catch blocks

#### JavaScript
- Follow [Airbnb JavaScript Style Guide](https://github.com/airbnb/javascript)
- Use camelCase for variables and functions
- Use const/let instead of var
- Include JSDoc comments for functions
- Handle errors with try-catch or Promise rejection

#### C/C++
- Follow [Google C++ Style Guide](https://google.github.io/styleguide/cppguide.html)
- Use meaningful variable names
- Include header guards in .h files
- Document complex algorithms
- Proper memory management

## Documentation Standards

Good documentation is crucial for helping others understand your code. Follow these standards:

### 1. File-Level Documentation

Every code file should include a header comment explaining:
- **Purpose**: What the file/program does
- **Author** (optional): Your name or GitHub username
- **Date** (optional): When it was created
- **Description**: Brief explanation of the algorithm or functionality

**Example (Python):**
```python
"""
Bubble Sort Algorithm

This module implements the bubble sort algorithm for sorting arrays in ascending order.
Bubble sort repeatedly steps through the list, compares adjacent elements, and swaps
them if they are in the wrong order.

Time Complexity: O(n²) in worst case, O(n) in best case
Space Complexity: O(1)

Author: YourName
Date: October 2025
"""
```

**Example (Java):**
```java
/**
 * Binary Search Algorithm
 * 
 * This class implements binary search on a sorted array.
 * Binary search is an efficient algorithm for finding an item in a sorted list.
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * @author YourName
 * @version 1.0
 * @since 2025-10-19
 */
```

### 2. Function/Method Documentation

Every function should include:
- **Purpose**: What the function does
- **Parameters**: Description of each parameter
- **Return Value**: What the function returns
- **Exceptions**: Any exceptions that might be thrown
- **Example Usage**: How to use the function

**Example (Python):**
```python
def binary_search(arr, target):
    """
    Perform binary search on a sorted array.
    
    Args:
        arr (list): A sorted list of elements to search through
        target: The element to search for
    
    Returns:
        int: The index of the target element if found, -1 otherwise
    
    Raises:
        TypeError: If arr is not a list
        ValueError: If arr is empty
    
    Example:
        >>> arr = [1, 2, 3, 4, 5]
        >>> binary_search(arr, 3)
        2
    """
    # Implementation here
```

**Example (Java):**
```java
/**
 * Performs binary search on a sorted array.
 * 
 * @param arr The sorted array to search through
 * @param target The element to find
 * @return The index of the target element, or -1 if not found
 * @throws IllegalArgumentException if the array is null or empty
 * 
 * @example
 * <pre>
 * int[] arr = {1, 2, 3, 4, 5};
 * int index = binarySearch(arr, 3); // Returns 2
 * </pre>
 */
public static int binarySearch(int[] arr, int target) {
    // Implementation here
}
```

### 3. Inline Comments

Use inline comments to explain:
- **Complex Logic**: Why you chose a particular approach
- **Important Variables**: What they represent
- **Edge Cases**: How special cases are handled
- **Algorithm Steps**: Break down complex algorithms

**Guidelines:**
- Write comments that explain "why", not "what"
- Keep comments concise and relevant
- Update comments when you update code
- Avoid obvious comments

**Good Example:**
```python
# Use binary search since the array is already sorted
# This reduces time complexity from O(n) to O(log n)
mid = left + (right - left) // 2  # Avoids integer overflow
```

**Bad Example:**
```python
# Set x to 5
x = 5
# Print x
print(x)
```

### 4. README Files in Language Folders

Each language folder should have a README.md with:
- Brief introduction to the language
- List of algorithms/programs in the folder
- How to compile/run the programs
- Prerequisites (compilers, interpreters, libraries)
- Resources for learning

### 5. Code Examples

When documenting, include practical examples:
- **Input/Output Examples**: Show what goes in and what comes out
- **Use Cases**: Real-world applications
- **Edge Cases**: How the code handles special situations

## Code Review Process

### What to Expect
1. **Initial Review**: Pull requests will be reviewed by maintainers within 2-5 days.
2. **Feedback**: Be prepared to make revisions based on feedback. This is normal and helps improve code quality.
3. **Documentation Check**: Ensure your code includes proper comments and documentation.
4. **Testing**: If applicable, verify your code works as expected.
5. **Approval**: Once approved, your code will be merged into the main branch.

### Review Checklist
Before submitting your PR, ensure:
- ✅ Code follows the style guidelines for your language
- ✅ All functions/classes have proper documentation
- ✅ Inline comments explain complex logic
- ✅ File includes header documentation
- ✅ Code is tested and works correctly
- ✅ No unnecessary files or dependencies added
- ✅ Commit messages are clear and descriptive

## Best Practices

### Git Commit Messages
Write clear, descriptive commit messages:
- Use present tense ("Add feature" not "Added feature")
- Start with a capital letter
- Keep the first line under 50 characters
- Use the imperative mood ("Fix bug" not "Fixes bug")

**Good Examples:**
```
✨ Add bubble sort implementation in Python
📝 Update README with installation instructions
🐛 Fix off-by-one error in binary search
♻️ Refactor quicksort for better readability
```

### Pull Request Guidelines
- Use a descriptive title that summarizes your changes
- Reference any related issues (e.g., "Fixes #123")
- Describe what you changed and why
- Include screenshots for UI changes
- List any breaking changes

**PR Template:**
```markdown
## Description
Brief description of changes

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Documentation update
- [ ] Code refactoring

## Checklist
- [ ] My code follows the style guidelines
- [ ] I have commented my code where necessary
- [ ] I have updated the documentation
- [ ] My changes generate no new warnings
```

### Code Quality Tips
1. **Write Self-Documenting Code**: Use clear variable and function names
2. **Keep Functions Small**: Each function should do one thing well
3. **Avoid Magic Numbers**: Use named constants instead
4. **Handle Edge Cases**: Consider empty inputs, null values, etc.
5. **Test Your Code**: Verify it works with different inputs

### Communication
- Be respectful and constructive in discussions
- Ask questions if something is unclear
- Help other contributors when possible
- Thank reviewers for their feedback

## License
By contributing, you agree that your contributions will be licensed under the same license as Code-Contribution.

### Thank you for helping improve Code-Contribution!
