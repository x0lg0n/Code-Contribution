# 📚 Code Documentation Guide

## Table of Contents
- [Introduction](#introduction)
- [Why Document Code?](#why-document-code)
- [General Documentation Principles](#general-documentation-principles)
- [Language-Specific Guidelines](#language-specific-guidelines)
  - [Python](#python-documentation)
  - [Java](#java-documentation)
  - [JavaScript](#javascript-documentation)
  - [C/C++](#cc-documentation)
  - [C#](#c-documentation)
- [Best Practices](#best-practices)
- [Common Mistakes to Avoid](#common-mistakes-to-avoid)
- [Tools and Resources](#tools-and-resources)

---

## Introduction

This guide provides comprehensive standards for documenting code in the Code-Contribution repository. Good documentation makes code accessible, maintainable, and valuable to the community.

## Why Document Code?

### Benefits of Good Documentation

1. **Knowledge Transfer** - New team members can understand code quickly
2. **Future Maintenance** - Easier to modify and debug code months/years later
3. **API Usage** - Clear documentation shows how to use functions/classes
4. **Bug Prevention** - Well-documented edge cases prevent bugs
5. **Professional Growth** - Demonstrates maturity and attention to detail
6. **Community Value** - Makes open-source projects more accessible

### What Good Documentation Looks Like

✅ **Good Documentation:**
- Explains *why* something is done, not just *what*
- Includes practical examples
- Documents parameters, return values, and exceptions
- Notes edge cases and limitations
- Uses clear, concise language

❌ **Poor Documentation:**
- States the obvious ("increments counter by 1")
- Missing parameter descriptions
- No examples provided
- Outdated or contradictory information
- Overly verbose or confusing

---

## General Documentation Principles

### The Documentation Pyramid

```
┌─────────────────────────────┐
│    High-Level Overview      │  README, Architecture Docs
├─────────────────────────────┤
│    Module/File Docs         │  Purpose, Dependencies, Usage
├─────────────────────────────┤
│    Class/Function Docs      │  API Documentation
├─────────────────────────────┤
│    Inline Comments          │  Complex Logic Explanation
└─────────────────────────────┘
```

### Key Components

Every well-documented code file should include:

1. **File Header**
   - Brief description of purpose
   - Author (optional)
   - Version and date
   - License information

2. **Module/Class Documentation**
   - What the module/class does
   - Key features or algorithms
   - Dependencies
   - Usage examples

3. **Function/Method Documentation**
   - Brief description
   - Parameters with types and descriptions
   - Return value and type
   - Exceptions/errors that may be raised
   - At least one usage example

4. **Inline Comments**
   - Explain complex algorithms
   - Note important edge cases
   - Clarify non-obvious design decisions

---

## Language-Specific Guidelines

### Python Documentation

#### Standard: PEP 257 (Docstring Conventions)

#### Module Docstring
```python
"""
Module Name: Brief Description

This module provides [functionality]. It includes [key features]
and is designed for [use case].

Example:
    >>> from module import function
    >>> result = function(arg)
    >>> print(result)

Author: Your Name
License: MIT
"""
```

#### Function/Method Docstring
```python
def function_name(param1: str, param2: int = 0) -> bool:
    """
    Brief one-line description of the function.
    
    More detailed explanation of what the function does,
    including algorithm details if relevant.
    
    Args:
        param1 (str): Description of the first parameter
        param2 (int, optional): Description of second parameter.
            Defaults to 0.
    
    Returns:
        bool: Description of return value
    
    Raises:
        ValueError: When param1 is empty
        TypeError: When param2 is not an integer
    
    Example:
        >>> function_name("test", 5)
        True
        
        >>> function_name("example")
        False
    
    Note:
        Any important notes about the function's behavior,
        performance characteristics, or limitations.
    
    See Also:
        related_function(): For related functionality
    """
    pass
```

#### Class Docstring
```python
class MyClass:
    """
    Brief description of the class.
    
    Detailed description of what the class represents,
    its purpose, and main functionality.
    
    Attributes:
        attribute1 (type): Description of attribute1
        attribute2 (type): Description of attribute2
    
    Example:
        >>> obj = MyClass(param1, param2)
        >>> result = obj.method()
        >>> print(result)
    """
    
    def __init__(self, param1: str, param2: int):
        """
        Initialize MyClass.
        
        Args:
            param1 (str): Description of param1
            param2 (int): Description of param2
        """
        self.attribute1 = param1
        self.attribute2 = param2
```

---

### Java Documentation

#### Standard: JavaDoc

#### Class JavaDoc
```java
/**
 * ClassName - Brief one-line description
 * 
 * <p>Detailed description of the class purpose and functionality.
 * Explain what the class does and when to use it.</p>
 * 
 * <h2>Key Features:</h2>
 * <ul>
 *   <li>Feature 1: Description</li>
 *   <li>Feature 2: Description</li>
 * </ul>
 * 
 * <h2>Usage Example:</h2>
 * <pre>{@code
 * MyClass obj = new MyClass();
 * obj.doSomething();
 * }</pre>
 * 
 * @author Your Name
 * @version 1.0
 * @since 2025-10-15
 * 
 * @see RelatedClass
 */
public class MyClass {
    // implementation
}
```

#### Method JavaDoc
```java
/**
 * Brief description of what the method does.
 * 
 * <p>Detailed explanation including algorithm description,
 * complexity analysis, and important implementation notes.</p>
 * 
 * @param param1 Description of the first parameter
 * @param param2 Description of the second parameter
 * @return Description of what is returned
 * @throws IllegalArgumentException when param1 is null
 * @throws IOException when file operations fail
 * 
 * @example
 * <pre>{@code
 * int result = methodName("test", 5);
 * System.out.println(result); // Output: 10
 * }</pre>
 * 
 * @see #relatedMethod(String)
 */
public int methodName(String param1, int param2) 
    throws IllegalArgumentException, IOException {
    // implementation
    return 0;
}
```

---

### JavaScript Documentation

#### Standard: JSDoc

#### File Documentation
```javascript
/**
 * @fileoverview Brief description of the file
 * 
 * Detailed description of what this module provides,
 * its main features, and usage patterns.
 * 
 * @author Your Name
 * @version 1.0
 * @license MIT
 */
```

#### Function Documentation
```javascript
/**
 * Brief description of what the function does.
 * 
 * Detailed explanation including algorithm details,
 * performance characteristics, or important notes.
 * 
 * @param {string} param1 - Description of param1
 * @param {number} [param2=0] - Optional param with default
 * @param {Object} options - Configuration options
 * @param {boolean} options.enabled - Whether feature is enabled
 * @param {string} options.mode - Operation mode
 * 
 * @returns {Promise<boolean>} Description of return value
 * 
 * @throws {TypeError} When param1 is not a string
 * @throws {RangeError} When param2 is negative
 * 
 * @example
 * const result = await myFunction('test', 5, { enabled: true });
 * console.log(result); // true
 * 
 * @example
 * // Error handling
 * try {
 *   myFunction(123, -1);
 * } catch (error) {
 *   console.error(error.message);
 * }
 * 
 * @see {@link relatedFunction}
 * @since 1.0.0
 */
async function myFunction(param1, param2 = 0, options = {}) {
    // implementation
}
```

#### Type Definitions
```javascript
/**
 * @typedef {Object} User
 * @property {string} name - User's full name
 * @property {number} age - User's age in years
 * @property {boolean} isActive - Whether user is active
 * @property {string[]} roles - User's assigned roles
 */

/**
 * @type {User}
 */
const user = {
    name: 'Alice',
    age: 30,
    isActive: true,
    roles: ['admin', 'user']
};
```

---

### C/C++ Documentation

#### Standard: Doxygen

#### File Documentation
```c
/**
 * @file filename.c
 * @brief Brief description of the file
 * 
 * Detailed description of what this file contains,
 * its purpose, and main functionality.
 * 
 * @author Your Name
 * @version 1.0
 * @date 2025-10-15
 * @copyright MIT License
 * 
 * @details
 * Additional implementation details, algorithms used,
 * or important notes about the code.
 */
```

#### Function Documentation
```c
/**
 * @brief Brief description of the function
 * 
 * Detailed description including algorithm explanation,
 * complexity analysis, and important notes.
 * 
 * @param param1 Description of first parameter
 * @param param2 Description of second parameter
 * @return Description of return value
 * @retval 0 Success
 * @retval -1 Error occurred
 * 
 * @warning Important warnings about usage or edge cases
 * @note Additional notes or implementation details
 * 
 * @code
 * // Example usage:
 * int result = my_function(10, 20);
 * if (result == 0) {
 *     printf("Success!\n");
 * }
 * @endcode
 * 
 * @see related_function()
 */
int my_function(int param1, int param2) {
    // implementation
    return 0;
}
```

#### Struct/Class Documentation
```c
/**
 * @struct Point
 * @brief Represents a point in 2D space
 * 
 * @var Point::x
 * X coordinate
 * 
 * @var Point::y
 * Y coordinate
 */
struct Point {
    int x;  /**< X coordinate */
    int y;  /**< Y coordinate */
};
```

---

### C# Documentation

#### Standard: XML Documentation Comments

```csharp
/// <summary>
/// Brief description of the class or method.
/// </summary>
/// <remarks>
/// Detailed explanation of functionality, algorithms,
/// or important implementation details.
/// </remarks>
/// <param name="param1">Description of param1</param>
/// <param name="param2">Description of param2</param>
/// <returns>Description of return value</returns>
/// <exception cref="ArgumentNullException">
/// Thrown when param1 is null
/// </exception>
/// <example>
/// <code>
/// var obj = new MyClass();
/// int result = obj.Method("test", 5);
/// Console.WriteLine(result);
/// </code>
/// </example>
public int Method(string param1, int param2) {
    // implementation
    return 0;
}
```

---

## Best Practices

### 1. Write Documentation First (TDD for Docs)

Before writing code, write the documentation:
- Clarifies what you're building
- Helps design better APIs
- Ensures you don't forget to document

### 2. Use Meaningful Examples

```python
# ❌ Bad: Trivial example
def add(a, b):
    """Add two numbers.
    
    Example:
        >>> add(1, 2)
        3
    """
    return a + b

# ✅ Good: Realistic use case
def calculate_discount(price, discount_percent):
    """Calculate final price after applying discount.
    
    Example:
        >>> # 20% off a $100 item
        >>> calculate_discount(100.00, 20)
        80.00
    """
    return price * (1 - discount_percent / 100)
```

### 3. Document Edge Cases

```python
def divide(a, b):
    """
    Divide a by b.
    
    Args:
        a (float): Numerator
        b (float): Denominator
    
    Returns:
        float: Result of a / b
    
    Raises:
        ZeroDivisionError: When b is zero
    
    Note:
        Returns infinity when a is very large and b is very small.
        Consider using Decimal for precise calculations.
    
    Example:
        >>> divide(10, 2)
        5.0
        
        >>> divide(10, 0)  # doctest: +SKIP
        Traceback (most recent call last):
        ZeroDivisionError: division by zero
    """
    return a / b
```

### 4. Keep Documentation Updated

When you change code, update the documentation:
- Prevents confusion
- Maintains accuracy
- Shows attention to detail

### 5. Use Consistent Formatting

- Follow language conventions
- Use consistent terminology
- Maintain uniform structure

---

## Common Mistakes to Avoid

### ❌ 1. Stating the Obvious
```python
# Bad: Comment says exactly what code does
counter += 1  # Increment counter by 1

# Good: Explain why
counter += 1  # Track number of API retries
```

### ❌ 2. No Examples
```python
# Bad: No usage example
def complex_algorithm(data, options):
    """Processes data with options."""
    pass

# Good: Include example
def complex_algorithm(data, options):
    """
    Processes data with options.
    
    Example:
        >>> data = [1, 2, 3, 4, 5]
        >>> options = {'method': 'mean', 'weights': [1, 1, 1, 1, 1]}
        >>> result = complex_algorithm(data, options)
        >>> print(result)
        3.0
    """
    pass
```

### ❌ 3. Missing Parameter Types
```python
# Bad: No type information
def process(data, config):
    """Process data with config."""
    pass

# Good: Include types
def process(data: List[Dict], config: ProcessConfig) -> ProcessResult:
    """
    Process data with configuration.
    
    Args:
        data (List[Dict]): List of data dictionaries
        config (ProcessConfig): Processing configuration
    
    Returns:
        ProcessResult: Processing results
    """
    pass
```

### ❌ 4. Outdated Documentation
```python
# Bad: Documentation doesn't match code
def calculate(a, b, c):  # Added 'c' parameter
    """
    Calculate result.
    
    Args:
        a: First number
        b: Second number
        # Missing: c parameter!
    """
    return (a + b) * c

# Good: Keep docs in sync
def calculate(a, b, c):
    """
    Calculate result using formula: (a + b) * c
    
    Args:
        a: First number
        b: Second number
        c: Multiplier
    """
    return (a + b) * c
```

---

## Tools and Resources

### Documentation Generators

- **Python:** [Sphinx](https://www.sphinx-doc.org/)
- **Java:** [JavaDoc](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html)
- **JavaScript:** [JSDoc](https://jsdoc.app/)
- **C/C++:** [Doxygen](https://www.doxygen.nl/)
- **Multi-language:** [Read the Docs](https://readthedocs.org/)

### Style Guides

- **Python:** [PEP 257](https://peps.python.org/pep-0257/), [Google Python Style](https://google.github.io/styleguide/pyguide.html)
- **Java:** [Google Java Style](https://google.github.io/styleguide/javaguide.html)
- **JavaScript:** [Airbnb JavaScript Style](https://github.com/airbnb/javascript)
- **C++:** [Google C++ Style](https://google.github.io/styleguide/cppguide.html)

### AI-Assisted Documentation

#### GitHub Copilot

Use Copilot to improve documentation:

1. **Generate docstrings:**
   ```
   Prompt: "Add comprehensive docstring to this function with examples"
   ```

2. **Review documentation:**
   ```
   Prompt: "Review this code's documentation and suggest improvements"
   ```

3. **Create examples:**
   ```
   Prompt: "Generate realistic usage examples for this function"
   ```

4. **Check completeness:**
   ```
   Prompt: "What documentation is missing from this code?"
   ```

**Resources:**
- [Configuring GitHub Copilot](https://docs.github.com/en/copilot/customizing-copilot/adding-custom-instructions-for-github-copilot)
- [Code review with Copilot](https://docs.github.com/en/copilot/using-github-copilot/code-review/using-copilot-code-review)

### Validation Tools

- **Python:** `pydocstyle`, `pylint`
- **Java:** `checkstyle` with JavaDoc rules
- **JavaScript:** `eslint` with `eslint-plugin-jsdoc`
- **C/C++:** `cppcheck`, `clang-tidy`

---

## Contributing to This Guide

This documentation guide itself is open to improvements! If you have suggestions:

1. Open an issue describing your proposed change
2. Submit a PR with improvements
3. Include examples demonstrating your point

---

## Summary Checklist

Before submitting code, ensure:

- [ ] File has header documentation
- [ ] All public functions/methods are documented
- [ ] Parameters and return values are described
- [ ] At least one usage example is provided
- [ ] Complex logic has inline comments
- [ ] Documentation follows language conventions
- [ ] Examples are tested and working
- [ ] No obvious information is omitted

---

**Remember:** Good documentation is a gift to your future self and to others who will use or maintain your code. Invest the time now, and everyone benefits later! 🎁

Happy documenting! 📚✨
