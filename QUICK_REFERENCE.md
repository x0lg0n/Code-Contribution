# 📖 Quick Documentation Reference

> **Quick reference card for documenting code in this repository**

---

## 🎯 The Golden Rules

1. **Document WHY, not WHAT** - Code shows what; comments explain why
2. **Include Examples** - At least one working example per function
3. **Follow Standards** - Use language-specific conventions
4. **Keep Updated** - Change code? Update docs!
5. **Be Clear** - Write for someone who doesn't know your code

---

## 🗂️ Documentation Hierarchy

```
┌─────────────────────────────────────┐
│ 1. File Header                       │←   What this file does
├─────────────────────────────────────┤
│ 2. Class/Module Docs                │←   Overall Purpose, features, usage
├─────────────────────────────────────┤
│ 3. Function/Method Docs             │←   Params, returns, examples
├─────────────────────────────────────┤
│ 4. Inline Comments                  │←    Complex logic explained
└─────────────────────────────────────┘
```

---

## 🐍 Python - Quick Template

```python
"""
Module: Brief description

Detailed explanation of what this module does.

Example:
    >>> from module import function
    >>> function("test")
    'result'
"""

def function_name(param1: str, param2: int = 0) -> str:
    """
    Brief one-line description.
    
    Args:
        param1 (str): Description of param1
        param2 (int, optional): Description. Defaults to 0.
    
    Returns:
        str: Description of return value
    
    Raises:
        ValueError: When param1 is empty
    
    Example:
        >>> function_name("hello", 5)
        'result'
    """
    pass
```

**Key Points:**
- Use triple quotes `"""`
- Type hints for params and returns
- Include at least one example
- Document exceptions

**Full Guide:** [Python/README.md](Python/README.md)

---

## ☕ Java - Quick Template

```java
/**
 * ClassName - Brief description
 * 
 * <p>Detailed explanation of the class.</p>
 * 
 * @author Your Name
 * @version 1.0
 */
public class ClassName {
    
    /**
     * Brief method description.
     * 
     * @param param1 Description of param1
     * @param param2 Description of param2
     * @return Description of return value
     * @throws IllegalArgumentException When param is invalid
     * 
     * @example
     * <pre>{@code
     * ClassName obj = new ClassName();
     * int result = obj.method("test", 5);
     * }</pre>
     */
    public int methodName(String param1, int param2) {
        return 0;
    }
}
```

**Key Points:**
- Use `/** */` for JavaDoc
- Include `@param`, `@return`, `@throws`
- Use `<pre>{@code}` for examples
- Methods in camelCase

**Full Guide:** [Java/README.md](Java/README.md)

---

## 📜 JavaScript - Quick Template

```javascript
/**
 * @fileoverview Brief file description
 * @author Your Name
 */

/**
 * Brief function description.
 * 
 * @param {string} param1 - Description of param1
 * @param {number} [param2=0] - Optional param
 * @returns {boolean} Description of return
 * @throws {TypeError} When param is wrong type
 * 
 * @example
 * const result = functionName('test', 5);
 * console.log(result); // true
 */
function functionName(param1, param2 = 0) {
    return true;
}
```

**Key Points:**
- Use `@fileoverview` for files
- Type in `{curly braces}`
- Optional params: `[param=default]`
- Use `@returns` not `@return`

**Full Guide:** [Javascript/README.md](Javascript/README.md)

---

## 🔧 C/C++ - Quick Template

```c
/**
 * @file filename.c
 * @brief Brief file description
 * @author Your Name
 * @date 2025-10-15
 */

/**
 * @brief Brief function description
 * 
 * Detailed explanation of the function.
 * 
 * @param param1 Description of param1
 * @param param2 Description of param2
 * @return Description of return value
 * @retval 0 Success
 * @retval -1 Error
 * 
 * @code
 * int result = function_name(10, 20);
 * printf("Result: %d\n", result);
 * @endcode
 */
int function_name(int param1, int param2) {
    return 0;
}
```

**Key Points:**
- Use Doxygen format
- `@brief` for short description
- `@code` blocks for examples
- Check for NULL pointers

**Full Guide:** [C/README.md](C/README.md)

---

## ✅ Pre-Submission Checklist

Before creating your PR, verify:

- [ ] **File header** explains purpose
- [ ] **All functions** have documentation
- [ ] **Parameters** are described with types
- [ ] **Return values** are documented
- [ ] **One example** minimum per function
- [ ] **Exceptions/errors** are noted
- [ ] **Format** follows language conventions
- [ ] **Examples** are tested and work
- [ ] **README** in language folder updated

---

## 🎨 Good vs Bad Examples

### ❌ BAD - Obvious Comment
```python
counter += 1  # Increment counter
```

### ✅ GOOD - Explains Why
```python
counter += 1  # Track number of retry attempts
```

---

### ❌ BAD - No Example
```python
def process_data(data, options):
    """Process data with options."""
    pass
```

### ✅ GOOD - With Example
```python
def process_data(data: List[int], options: dict) -> List[int]:
    """
    Process data with given options.
    
    Args:
        data (List[int]): Input numbers
        options (dict): Processing options
    
    Returns:
        List[int]: Processed numbers
    
    Example:
        >>> process_data([1, 2, 3], {'method': 'double'})
        [2, 4, 6]
    """
    pass
```

---

## 🚀 Quick Start

1. **Choose your language** - See template above
2. **Copy template** - Use as starting point
3. **Fill in details** - Replace placeholders
4. **Add example** - Include working code
5. **Test example** - Make sure it works!
6. **Update README** - Add to language folder

---

## 📚 Full Documentation Resources

### Comprehensive Guides
- **[DOCUMENTATION_GUIDE.md](DOCUMENTATION_GUIDE.md)** - Complete 500+ line guide
- **[CONTRIBUTING.md](CONTRIBUTING.md)** - Full contribution guidelines
- **[README.md](README.md)** - Project overview with standards

### Language-Specific Guides
- **[Python/README.md](Python/README.md)** - Python documentation standards
- **[Java/README.md](Java/README.md)** - Java JavaDoc guide
- **[Javascript/README.md](Javascript/README.md)** - JavaScript JSDoc guide
- **[C/README.md](C/README.md)** - C Doxygen standards

### Examples
- Look at files in language directories for real examples
- All core files have been updated with proper documentation

---

## 🤖 AI-Assisted Documentation

### Using GitHub Copilot

**Generate docstring:**
```
// Type: "Add comprehensive docstring"
// Copilot will generate documentation template
```

**Ask for review:**
```
// Prompt: "Review this function's documentation"
```

**Create examples:**
```
// Prompt: "Generate usage examples for this function"
```

---

## 🎯 Remember

> **The best documentation is:**
> - **Clear:** Easy to understand
> - **Complete:** All info included
> - **Correct:** Matches the code
> - **Concise:** No unnecessary words
> - **Current:** Updated with code changes

---

## ❓ Need Help?

1. **Check** [DOCUMENTATION_GUIDE.md](DOCUMENTATION_GUIDE.md) for detailed examples
2. **Look** at existing files for reference
3. **Ask** maintainers in your PR
4. **Use** GitHub Copilot for suggestions

---

**Happy Documenting! 📝✨**

*Quick Reference v1.0 | Updated: October 15, 2025*
