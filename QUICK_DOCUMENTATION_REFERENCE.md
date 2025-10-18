# 📖 Quick Documentation Reference

> **Quick access guide for contributors who need documentation examples fast!**

## 🚀 Quick Start

1. **Read this file** for quick templates
2. **Check [DOCUMENTATION_GUIDE.md](DOCUMENTATION_GUIDE.md)** for detailed explanations
3. **See [CONTRIBUTING.md](CONTRIBUTING.md)** for full guidelines

---

## 📝 Python Quick Template

```python
"""
[Brief one-line description]

[Detailed description of what this module/program does.
Include algorithm explanation if applicable.]

Time Complexity: O(?)
Space Complexity: O(?)

Author: Your Name
Date: YYYY-MM-DD
"""


def function_name(param1, param2):
    """
    [Brief description of what function does]
    
    Args:
        param1 (type): Description
        param2 (type): Description
    
    Returns:
        type: Description
    
    Raises:
        ExceptionType: When this occurs
    
    Example:
        >>> function_name(1, 2)
        3
    """
    # Implementation here
    pass


def main():
    """Main function to run the program."""
    # Your code here
    pass


if __name__ == "__main__":
    main()
```

---

## ☕ Java Quick Template

```java
/**
 * [Brief class description]
 * 
 * <p>[Detailed description of class purpose and functionality.]</p>
 * 
 * <p><b>Time Complexity:</b> O(?)</p>
 * <p><b>Space Complexity:</b> O(?)</p>
 * 
 * @author Your Name
 * @version 1.0
 * @since 2025-10-19
 */
public class ClassName {
    
    /**
     * [Brief method description]
     * 
     * @param param1 Description
     * @param param2 Description
     * @return Description of return value
     * @throws ExceptionType When this occurs
     * 
     * @example
     * <pre>
     * {@code
     * int result = methodName(1, 2);
     * }
     * </pre>
     */
    public static int methodName(int param1, int param2) {
        // Implementation here
        return 0;
    }
    
    /**
     * Main method - entry point
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Your code here
    }
}
```

---

## 🌐 JavaScript Quick Template

```javascript
/**
 * [Brief description]
 * 
 * [Detailed explanation of functionality]
 * 
 * @param {type} param1 - Description
 * @param {type} param2 - Description
 * @returns {type} Description
 * @throws {ErrorType} When this occurs
 * 
 * @complexity Time: O(?), Space: O(?)
 * 
 * @example
 * // Basic usage
 * functionName(value1, value2);
 */
function functionName(param1, param2) {
    // Implementation here
}

// Usage
functionName(arg1, arg2);
```

---

## 🔧 C/C++ Quick Template

```c
/**
 * @file filename.c
 * @brief [Brief description]
 * 
 * [Detailed description of file contents and purpose]
 * 
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 * 
 * @author Your Name
 * @date 2025-10-19
 */

#include <stdio.h>

/**
 * @brief [Brief function description]
 * 
 * @param[in] param1 Description of input parameter
 * @param[out] param2 Description of output parameter
 * @return Description of return value
 * 
 * @note Important notes
 * @complexity O(?)
 */
int functionName(int param1, int* param2) {
    // Implementation here
    return 0;
}

/**
 * @brief Main function
 * @return 0 on success
 */
int main() {
    // Your code here
    return 0;
}
```

---

## 💡 Inline Comments Guidelines

### ✅ DO: Explain WHY

```python
# Use binary search since array is sorted - O(log n) vs O(n)
index = binary_search(arr, target)

# Avoid integer overflow when calculating middle
mid = left + (right - left) // 2
```

### ❌ DON'T: State the OBVIOUS

```python
# Bad - obvious from code
x = 5  # Set x to 5
print(x)  # Print x
```

---

## 📋 Documentation Checklist

Before submitting, ensure:

- [ ] File has header documentation
- [ ] All functions have docstrings/comments
- [ ] Complex logic explained with inline comments
- [ ] Examples included
- [ ] Time/space complexity documented (for algorithms)
- [ ] No obvious or misleading comments
- [ ] Updated README if adding new file

---

## 🎯 Common Patterns

### Algorithm Documentation

```python
"""
[Algorithm Name]

Description: [What it does]
How it works: [Step-by-step]

Time Complexity: O(?)
Space Complexity: O(?)
Best Case: O(?)
Worst Case: O(?)

Example:
    Input: [sample input]
    Output: [sample output]
"""
```

### Function with Examples

```python
def function_name(param):
    """
    Brief description.
    
    Args:
        param: Description
    
    Returns:
        Description
    
    Example:
        >>> function_name([1, 2, 3])
        6
        >>> function_name([])
        0
    """
```

### Error Handling Documentation

```python
def function_name(param):
    """
    Description.
    
    Args:
        param: Description
    
    Returns:
        Description
    
    Raises:
        TypeError: If param is not correct type
        ValueError: If param is invalid value
        KeyError: If required key is missing
    """
    if not isinstance(param, expected_type):
        raise TypeError("Error message")
```

---

## 🔍 Quick Examples by Category

### 1. Hello World

```python
"""
Hello World Program

Demonstrates basic syntax by printing "Hello World!" to console.
Traditional first program in any language.
"""

def main():
    """Print Hello World to console."""
    print("Hello World!")

if __name__ == "__main__":
    main()
```

### 2. Sorting Algorithm

```python
"""
Bubble Sort Algorithm

Sorts array by repeatedly swapping adjacent elements if in wrong order.

Time Complexity: O(n²) average, O(n) best case
Space Complexity: O(1)
Stability: Stable
"""

def bubble_sort(arr):
    """
    Sort array using bubble sort.
    
    Args:
        arr (list): Array to sort
    
    Returns:
        list: Sorted array
    """
    n = len(arr)
    for i in range(n):
        swapped = False
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        if not swapped:
            break
    return arr
```

### 3. Search Algorithm

```python
"""
Binary Search Implementation

Efficient search on sorted arrays using divide-and-conquer.

Time Complexity: O(log n)
Space Complexity: O(1)
Prerequisite: Array must be sorted
"""

def binary_search(arr, target):
    """
    Search for target in sorted array.
    
    Args:
        arr (list): Sorted array
        target: Element to find
    
    Returns:
        int: Index if found, -1 otherwise
    
    Example:
        >>> binary_search([1, 3, 5, 7], 5)
        2
    """
    left, right = 0, len(arr) - 1
    
    while left <= right:
        mid = left + (right - left) // 2
        
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    
    return -1
```

---

## 📚 README Template for Language Folders

```markdown
# [Language] Programs

Brief description of programs in this folder.

## Prerequisites

- [Required software/version]
- [Installation instructions]

## Programs List

| Program | Description | Complexity | Difficulty |
|---------|-------------|------------|------------|
| file.ext | Description | O(?) | Level |

## How to Run

```bash
# Compilation (if needed)
compiler file.ext

# Execution
./program
```

## Contributing

See [CONTRIBUTING.md](../CONTRIBUTING.md)

## Resources

- [Documentation links]
- [Tutorial links]
```

---

## 🚨 Common Mistakes to Avoid

### ❌ Over-commenting
```python
x = 5  # Set x to 5 (BAD)
```

### ❌ Outdated comments
```python
# Sort in descending order (comment says one thing)
arr.sort()  # but code does another (BAD)
```

### ❌ Missing examples
```python
def complex_function(a, b, c):
    """Does something complex."""  # No examples! (BAD)
```

### ✅ Good documentation
```python
def calculate_average(numbers):
    """
    Calculate average of numbers.
    
    Args:
        numbers (list): List of numbers
    
    Returns:
        float: Average value
    
    Example:
        >>> calculate_average([1, 2, 3, 4, 5])
        3.0
    """
    return sum(numbers) / len(numbers)
```

---

## 🎓 Learning Path

1. **Start Simple**: Document Hello World programs
2. **Add Complexity**: Document basic algorithms
3. **Master Templates**: Use templates consistently
4. **Read Examples**: Study well-documented files
5. **Practice**: Document your own code
6. **Review**: Check against guidelines

---

## 📞 Need More Help?

- **Detailed Guide**: [DOCUMENTATION_GUIDE.md](DOCUMENTATION_GUIDE.md)
- **Full Guidelines**: [CONTRIBUTING.md](CONTRIBUTING.md)
- **Examples**: Check documented files in language folders
- **Ask**: Open an issue or pull request discussion

---

## ⚡ One-Minute Checklist

1. ✅ File header with description?
2. ✅ Function docstrings with args/returns?
3. ✅ Examples included?
4. ✅ Complexity noted (for algorithms)?
5. ✅ Inline comments for complex parts?

If all ✅, you're good to go! 🚀

---

**Last Updated**: October 19, 2025

*Keep this file handy when writing documentation!*
