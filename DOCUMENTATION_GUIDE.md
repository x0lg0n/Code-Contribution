# 📚 Documentation Guide for Code-Contribution

Welcome! This guide will help you write excellent documentation for your code contributions. Good documentation makes your code understandable, maintainable, and valuable to the community.

## Table of Contents
1. [Why Documentation Matters](#why-documentation-matters)
2. [Documentation Levels](#documentation-levels)
3. [Language-Specific Examples](#language-specific-examples)
4. [Best Practices](#best-practices)
5. [Common Mistakes to Avoid](#common-mistakes-to-avoid)
6. [Tools and Resources](#tools-and-resources)

---

## Why Documentation Matters

Good documentation:
- ✅ Helps others understand your code quickly
- ✅ Makes your code more maintainable
- ✅ Encourages collaboration and contributions
- ✅ Serves as a learning resource for beginners
- ✅ Increases the value of open-source projects
- ✅ Helps you remember your own code logic later

---

## Documentation Levels

### 1. File-Level Documentation (Header Comments)

Every file should start with a header explaining its purpose.

**What to Include:**
- Brief description of what the file does
- Author information (optional)
- Date created (optional)
- Algorithm explanation (for algorithm implementations)
- Time and space complexity
- Usage instructions

**Example:**
```python
"""
Quick Sort Algorithm Implementation

This module implements the quicksort algorithm, a divide-and-conquer sorting
algorithm that picks a pivot element and partitions the array around it.

Time Complexity: O(n log n) average, O(n²) worst case
Space Complexity: O(log n) due to recursion stack

Author: YourName
Date: October 2025
"""
```

---

### 2. Function/Method Documentation (Docstrings)

Every function should have documentation explaining:
- What it does (purpose)
- Parameters (inputs)
- Return values (outputs)
- Exceptions/Errors
- Examples of usage

#### Python Docstring Example

```python
def binary_search(arr, target):
    """
    Perform binary search on a sorted array.
    
    Binary search is an efficient algorithm for finding an element in a sorted
    list by repeatedly dividing the search interval in half.
    
    Args:
        arr (list): A sorted list of comparable elements
        target: The element to search for in the array
    
    Returns:
        int: The index of target in arr if found, -1 otherwise
    
    Raises:
        TypeError: If arr is not a list
        ValueError: If arr is empty
    
    Time Complexity: O(log n)
    Space Complexity: O(1)
    
    Example:
        >>> binary_search([1, 3, 5, 7, 9], 5)
        2
        >>> binary_search([1, 3, 5, 7, 9], 4)
        -1
    """
    if not isinstance(arr, list):
        raise TypeError("First argument must be a list")
    if len(arr) == 0:
        raise ValueError("Array cannot be empty")
    
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

#### Java Javadoc Example

```java
/**
 * Performs binary search on a sorted integer array.
 * 
 * <p>Binary search is an efficient algorithm that works on sorted arrays.
 * It repeatedly divides the search space in half until the target is found
 * or the search space is exhausted.</p>
 * 
 * <p><b>Algorithm Steps:</b></p>
 * <ol>
 *   <li>Compare target with the middle element</li>
 *   <li>If equal, return the index</li>
 *   <li>If target is smaller, search left half</li>
 *   <li>If target is larger, search right half</li>
 *   <li>Repeat until found or search space is empty</li>
 * </ol>
 * 
 * @param arr The sorted array to search through (must not be null)
 * @param target The element to search for
 * @return The index of the target element, or -1 if not found
 * @throws IllegalArgumentException if arr is null or empty
 * 
 * @complexity Time: O(log n), Space: O(1)
 * 
 * @example
 * <pre>
 * {@code
 * int[] arr = {1, 3, 5, 7, 9};
 * int index = binarySearch(arr, 5);  // Returns 2
 * int notFound = binarySearch(arr, 4);  // Returns -1
 * }
 * </pre>
 * 
 * @see Arrays#sort(int[]) for sorting arrays before searching
 * @since 1.0
 */
public static int binarySearch(int[] arr, int target) {
    // Validate input
    if (arr == null || arr.length == 0) {
        throw new IllegalArgumentException("Array cannot be null or empty");
    }
    
    int left = 0;
    int right = arr.length - 1;
    
    // Continue while search space exists
    while (left <= right) {
        // Calculate middle index (avoids integer overflow)
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;  // Target found
        } else if (arr[mid] < target) {
            left = mid + 1;  // Search right half
        } else {
            right = mid - 1;  // Search left half
        }
    }
    
    return -1;  // Target not found
}
```

#### JavaScript JSDoc Example

```javascript
/**
 * Performs binary search on a sorted array.
 * 
 * Binary search is an efficient search algorithm that works on sorted arrays.
 * It has O(log n) time complexity, making it much faster than linear search
 * for large datasets.
 * 
 * @param {Array<number>} arr - The sorted array to search (must be sorted ascending)
 * @param {number} target - The element to find
 * @returns {number} The index of the target element, or -1 if not found
 * @throws {TypeError} If arr is not an array or target is not a number
 * @throws {Error} If array is not sorted
 * 
 * @complexity Time: O(log n), Space: O(1)
 * 
 * @example
 * // Basic usage
 * const arr = [1, 3, 5, 7, 9];
 * binarySearch(arr, 5);  // Returns 2
 * 
 * @example
 * // Element not found
 * const arr = [1, 3, 5, 7, 9];
 * binarySearch(arr, 4);  // Returns -1
 * 
 * @see {@link https://en.wikipedia.org/wiki/Binary_search_algorithm|Binary Search on Wikipedia}
 */
function binarySearch(arr, target) {
    // Input validation
    if (!Array.isArray(arr)) {
        throw new TypeError('First argument must be an array');
    }
    if (typeof target !== 'number') {
        throw new TypeError('Target must be a number');
    }
    
    let left = 0;
    let right = arr.length - 1;
    
    // Main search loop
    while (left <= right) {
        // Calculate middle index (prevents integer overflow)
        const mid = Math.floor(left + (right - left) / 2);
        
        if (arr[mid] === target) {
            return mid;  // Found the target
        } else if (arr[mid] < target) {
            left = mid + 1;  // Search right half
        } else {
            right = mid - 1;  // Search left half
        }
    }
    
    return -1;  // Target not in array
}
```

#### C/C++ Doxygen Example

```c
/**
 * @brief Performs binary search on a sorted integer array
 * 
 * This function implements the binary search algorithm to find a target
 * element in a sorted array. It uses an iterative approach with O(log n)
 * time complexity.
 * 
 * @details
 * The algorithm works by:
 * 1. Comparing the target with the middle element
 * 2. If found, returning the index
 * 3. If target is smaller, searching the left half
 * 4. If target is larger, searching the right half
 * 5. Repeating until found or search space is exhausted
 * 
 * @param[in] arr Pointer to the sorted integer array (must not be NULL)
 * @param[in] size Number of elements in the array (must be > 0)
 * @param[in] target The element to search for
 * 
 * @return Index of the target element if found, -1 otherwise
 * 
 * @pre Array must be sorted in ascending order
 * @pre arr must not be NULL
 * @pre size must be greater than 0
 * 
 * @post Original array remains unchanged
 * 
 * @note Time Complexity: O(log n)
 * @note Space Complexity: O(1)
 * 
 * @warning Returns -1 if element is not found
 * @warning Undefined behavior if array is not sorted
 * 
 * @code
 * int arr[] = {1, 3, 5, 7, 9};
 * int result = binarySearch(arr, 5, 5);  // Returns 2
 * @endcode
 * 
 * @see linearSearch() for unsorted arrays
 * @author Code-Contribution Community
 * @date 2025-10-19
 */
int binarySearch(int arr[], int size, int target) {
    // Validate inputs
    if (arr == NULL || size <= 0) {
        return -1;
    }
    
    int left = 0;
    int right = size - 1;
    
    // Main search loop
    while (left <= right) {
        // Calculate middle index (avoids overflow)
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;  // Found
        } else if (arr[mid] < target) {
            left = mid + 1;  // Search right
        } else {
            right = mid - 1;  // Search left
        }
    }
    
    return -1;  // Not found
}
```

---

### 3. Inline Comments

Use inline comments to explain:
- **Complex logic**: Why you chose a specific approach
- **Important variables**: What they represent
- **Edge cases**: How special situations are handled
- **Algorithm steps**: Break down the process

#### Guidelines for Good Inline Comments

✅ **DO:**
```python
# Use binary search since array is already sorted - O(log n) vs O(n)
index = binary_search(arr, target)

# Avoid integer overflow when calculating middle index
mid = left + (right - left) // 2

# Early exit optimization: if no swaps occurred, array is sorted
if not swapped:
    break
```

❌ **DON'T:**
```python
# Set x to 5
x = 5

# Loop through array
for i in range(len(arr)):
    # Print element
    print(arr[i])
```

**The difference:** Good comments explain *why* and *what the purpose is*, not just *what* the code does (which should be obvious from the code itself).

---

### 4. README Files in Language Folders

Each language folder should have a README.md explaining:

```markdown
# Python Algorithms

This folder contains various algorithm implementations in Python.

## Prerequisites

- Python 3.7 or higher
- pip (Python package installer)

## Installation

```bash
# Clone the repository
git clone https://github.com/username/Code-Contribution.git

# Navigate to Python folder
cd Code-Contribution/Python

# Install dependencies (if any)
pip install -r requirements.txt
```

## Running the Programs

```bash
# Run a specific program
python hello-world.py

# Run with arguments
python binary-search.py
```

## Programs List

| Program | Description | Complexity |
|---------|-------------|------------|
| `hello-world.py` | Basic Hello World program | N/A |
| `binary-search.py` | Binary search implementation | O(log n) |
| `bubble-sort.py` | Bubble sort algorithm | O(n²) |

## Contributing

See [CONTRIBUTING.md](../CONTRIBUTING.md) for guidelines.

## Resources

- [Python Official Documentation](https://docs.python.org/)
- [Python Style Guide (PEP 8)](https://pep8.org/)
```

---

## Language-Specific Examples

### Python Documentation Style

```python
"""
Module docstring explaining the purpose.

This module provides utility functions for sorting and searching algorithms.
"""

def function_name(param1, param2):
    """
    Brief one-line description.
    
    More detailed description if needed. Explain what the function does,
    any important algorithm details, and usage patterns.
    
    Args:
        param1 (type): Description of param1
        param2 (type): Description of param2
    
    Returns:
        type: Description of return value
    
    Raises:
        ExceptionType: When this exception occurs
    
    Example:
        >>> function_name(1, 2)
        3
    """
    pass
```

### Java Documentation Style

```java
/**
 * Class-level Javadoc comment.
 * 
 * <p>Detailed description of the class purpose and functionality.</p>
 * 
 * @author Your Name
 * @version 1.0
 * @since 2025-10-19
 */
public class ClassName {
    
    /**
     * Brief method description.
     * 
     * <p>Detailed explanation of what the method does.</p>
     * 
     * @param param1 Description of parameter 1
     * @param param2 Description of parameter 2
     * @return Description of return value
     * @throws ExceptionType When this exception is thrown
     */
    public ReturnType methodName(Type1 param1, Type2 param2) {
        // Implementation
    }
}
```

### JavaScript Documentation Style

```javascript
/**
 * Brief function description.
 * 
 * Detailed explanation of what the function does and how it works.
 * 
 * @param {Type} param1 - Description of param1
 * @param {Type} param2 - Description of param2
 * @returns {Type} Description of return value
 * @throws {ErrorType} When this error occurs
 * 
 * @example
 * // Example usage
 * functionName(value1, value2);
 */
function functionName(param1, param2) {
    // Implementation
}
```

### C/C++ Documentation Style

```c
/**
 * @file filename.c
 * @brief Brief description of the file
 * 
 * Detailed description of what this file contains and its purpose.
 * 
 * @author Your Name
 * @date 2025-10-19
 */

/**
 * @brief Brief function description
 * 
 * @param[in] param1 Description of input parameter
 * @param[out] param2 Description of output parameter
 * @return Description of return value
 * 
 * @note Important notes
 * @warning Warnings about usage
 */
int functionName(int param1, int* param2);
```

---

## Best Practices

### 1. Write Clear and Concise Comments

✅ **Good:**
```python
# Binary search requires O(log n) time, making it efficient for large datasets
result = binary_search(sorted_array, target)
```

❌ **Bad:**
```python
# Search the array
result = binary_search(sorted_array, target)
```

### 2. Update Comments When Code Changes

Always update documentation when you modify code. Outdated comments are worse than no comments.

### 3. Use Proper Grammar and Spelling

Professional documentation uses correct grammar, punctuation, and spelling.

### 4. Include Examples

Show practical usage examples:

```python
"""
Example:
    >>> numbers = [1, 2, 3, 4, 5]
    >>> binary_search(numbers, 3)
    2
    >>> binary_search(numbers, 6)
    -1
"""
```

### 5. Document Complexity

Always include time and space complexity for algorithms:

```python
"""
Time Complexity: O(n log n)
Space Complexity: O(1)
"""
```

### 6. Explain Non-Obvious Code

If code is complex or uses a clever trick, explain it:

```python
# Use XOR to swap without temporary variable
# Works because: a XOR b XOR b = a
a ^= b
b ^= a  
a ^= b
```

### 7. Use TODO and FIXME Comments

Mark areas that need work:

```python
# TODO: Add input validation
# FIXME: Handle edge case when array is empty
# NOTE: This assumes array is already sorted
```

---

## Common Mistakes to Avoid

### ❌ Over-Commenting

Don't comment obvious code:
```python
# Bad: obvious what's happening
x = 5  # Set x to 5
print(x)  # Print x
```

### ❌ Writing Comments Instead of Clear Code

Bad code with comments is still bad:
```python
# Bad
def calc(a, b):  # Calculate something
    return a * 2 + b  # Multiply a by 2 and add b

# Good
def calculate_total_price(base_price, tax):
    doubled_base = base_price * 2
    return doubled_base + tax
```

### ❌ Using Misleading Comments

```python
# Bad: comment doesn't match code
# Sort array in descending order
arr.sort()  # Actually sorts in ascending order
```

### ❌ Not Documenting Parameters

```python
# Bad
def process_data(data):
    """Process some data."""
    pass

# Good
def process_data(data):
    """
    Process raw data and return cleaned results.
    
    Args:
        data (list): Raw data list containing dictionaries
    
    Returns:
        list: Cleaned and validated data
    """
    pass
```

---

## Tools and Resources

### Documentation Generators

- **Python**: [Sphinx](https://www.sphinx-doc.org/), [pydoc](https://docs.python.org/3/library/pydoc.html)
- **Java**: [Javadoc](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html)
- **JavaScript**: [JSDoc](https://jsdoc.app/)
- **C/C++**: [Doxygen](https://www.doxygen.nl/)

### Style Guides

- **Python**: [PEP 257](https://peps.python.org/pep-0257/) - Docstring Conventions
- **Java**: [Oracle Javadoc Guide](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html)
- **JavaScript**: [JSDoc Guide](https://jsdoc.app/)
- **Google Style Guides**: [google.github.io/styleguide](https://google.github.io/styleguide/)

### Learning Resources

- [Write The Docs](https://www.writethedocs.org/)
- [Documentation Guide by GitHub](https://guides.github.com/features/wikis/)
- [The Art of README](https://github.com/hackergrrl/art-of-readme)

---

## Quick Checklist

Before submitting your contribution, verify:

- [ ] File has header documentation explaining purpose
- [ ] All functions/methods have docstrings
- [ ] Complex logic has inline comments
- [ ] Examples are included
- [ ] Time and space complexity documented (for algorithms)
- [ ] Comments use proper grammar and spelling
- [ ] No misleading or outdated comments
- [ ] README updated if adding new files

---

## Need Help?

- Check existing well-documented files for examples
- Ask questions in issues or pull requests
- Review the [CONTRIBUTING.md](CONTRIBUTING.md) guide
- Refer to language-specific documentation standards

---

**Happy Documenting! 🎉**

Remember: Good documentation is just as important as good code. Thank you for helping make this project better!
