# Python Code Examples

This directory contains code examples written in Python. Each example demonstrates a specific concept or functionality in Python programming.

## 🐍 Python Coding Standards

### Documentation Requirements

All Python code in this directory should follow these standards:

#### 1. **Module-Level Docstrings**
Every `.py` file should start with a module docstring:
```python
"""
Module Name: Brief Description

Longer description explaining the module's purpose,
key features, and usage.

Author: Your Name (optional)
License: MIT
"""
```

#### 2. **Function Docstrings**
All functions must include docstrings following Google/NumPy style:
```python
def function_name(param1: str, param2: int = 0) -> bool:
    """
    Brief one-line description.
    
    Detailed description of what the function does,
    including algorithm details if complex.
    
    Args:
        param1 (str): Description of param1
        param2 (int, optional): Description of param2. Defaults to 0.
    
    Returns:
        bool: Description of return value
    
    Raises:
        ValueError: When and why this error is raised
        TypeError: When and why this error is raised
    
    Example:
        >>> function_name("test", 5)
        True
        
        >>> function_name("example")
        False
    
    Note:
        Any important implementation details or warnings.
    """
    pass
```

#### 3. **Type Hints**
Use type hints for function parameters and return values:
```python
from typing import List, Dict, Optional, Union

def process_data(items: List[str], config: Optional[Dict] = None) -> Union[str, None]:
    """Process items according to configuration."""
    pass
```

#### 4. **Code Style**
- Follow [PEP 8](https://pep8.org/) style guide
- Use 4 spaces for indentation (no tabs)
- Maximum line length: 79 characters (code), 72 (docstrings/comments)
- Use `snake_case` for functions and variables
- Use `PascalCase` for class names
- Use `UPPER_SNAKE_CASE` for constants

#### 5. **Naming Conventions**
```python
# Constants
MAX_BUFFER_SIZE = 1024
DEFAULT_TIMEOUT = 30

# Classes
class DataProcessor:
    pass

# Functions and variables
def calculate_total(items):
    total_sum = 0
    return total_sum
```

#### 6. **Comments**
```python
# Good: Explain WHY, not WHAT
# Using binary search because the list is sorted and large
result = binary_search(sorted_list, target)

# Bad: Stating the obvious
# Increment counter by 1
counter += 1
```

### Examples in This Directory

1. [Hello World](#hello-world)
2. [Caesar Cipher Encrypt](#caesar-cipher-encrypt)
3. [Caesar Cipher Decrypt](#caesar-cipher-decrypt)

## Hello World

The "Hello World" program is a simple program that prints "Hello, World!" to the console. It is often used as the first program when learning a new programming language.

```python
# Program to print Hello World

print("Hello World!")
```

## Caesar Cipher Encrypt

The Caesar Cipher is a simple encryption technique where each letter in the plaintext is shifted a certain number of places down the alphabet. The following code demonstrates how to encrypt a message using the Caesar Cipher.

```python
def caesar_cipher(text, key):
    result = ""
    for char in text:
        if char.isupper():
            result += chr((ord(char) + key - 65) % 26 + 65)
        elif char.islower():
            result += chr((ord(char) + key - 97) % 26 + 97)
        else:
            result += char
    
    return result
text = input("Enter the string to encode: ")
key = int(input("Enter the shift key: "))

encoded_text = caesar_cipher(text, key)
print(f"Encoded string: {encoded_text}")
```

## Caesar Cipher Decrypt

The Caesar Cipher decryption is the reverse process of the encryption. It shifts each letter in the ciphertext back by the same number of places to get the original plaintext. The following code demonstrates how to decrypt a message using the Caesar Cipher.

```python
def caesar_decrypt(text, key):
    result = ""
    for char in text:
        if char.isupper():
            result += chr((ord(char) - key - 65) % 26 + 65)
        elif char.islower():
            result += chr((ord(char) - key - 97) % 26 + 97)
        else:
            result += char
    return result

text = input("Enter the encoded string: ")
key = int(input("Enter the shift key: "))

decoded_text = caesar_decrypt(text, key)
print(f"Decoded string: {decoded_text}")
```
