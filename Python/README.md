# 🐍 Python Code Examples

This directory contains various Python programs demonstrating algorithms, data structures, and programming concepts. Each example is designed to be educational and follows Python best practices.

## 📋 Table of Contents

1. [Prerequisites](#prerequisites)
2. [Getting Started](#getting-started)
3. [Programs Overview](#programs-overview)
4. [How to Run](#how-to-run)
5. [Contributing](#contributing)
6. [Resources](#resources)

## Prerequisites

Before running these programs, ensure you have:

- **Python 3.7 or higher** installed
- Basic understanding of Python syntax
- A text editor or IDE (VS Code, PyCharm, etc.)

### Check Python Installation

```bash
python --version
# or
python3 --version
```

### Installing Python

If you don't have Python installed:
- **Windows**: Download from [python.org](https://www.python.org/downloads/)
- **macOS**: Use Homebrew: `brew install python3`
- **Linux**: Use package manager: `sudo apt install python3`

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/username/Code-Contribution.git
   cd Code-Contribution/Python
   ```

2. **Run a program:**
   ```bash
   python hello-world.py
   ```

## Programs Overview

### 🌟 Basic Programs

| Program | Description | Difficulty |
|---------|-------------|------------|
| `hello-world.py` | Classic Hello World program | Beginner |
| `vip.py` | VIP program demonstration | Beginner |

### 🔒 Cryptography

| Program | Description | Algorithm | Difficulty |
|---------|-------------|-----------|------------|
| `CaesarCipherEncrypt.py` | Caesar cipher encryption | Substitution cipher | Beginner |
| `CaeserCipherDecrypt.py` | Caesar cipher decryption | Substitution cipher | Beginner |
| `SolitaireCipherEncrypt.py` | Solitaire cipher encryption | Stream cipher | Advanced |
| `SolitaireCipherDecrypt.py` | Solitaire cipher decryption | Stream cipher | Advanced |

### 📊 Data Analysis & Machine Learning

| Program | Description | Libraries | Difficulty |
|---------|-------------|-----------|------------|
| `LinearRegression.py` | Linear regression implementation | scikit-learn, pandas | Intermediate |

### 🧩 Algorithms

| Program | Description | Complexity | Difficulty |
|---------|-------------|------------|------------|
| `find_intersection_in_LL.py` | Find intersection in linked lists | O(n) | Intermediate |

### 🌐 Networking

| Program | Description | Purpose | Difficulty |
|---------|-------------|---------|------------|
| `IPv4AddressValidator.py` | Validate IPv4 addresses | Input validation | Intermediate |

### 🎨 Fun Projects

| Program | Description | Purpose | Difficulty |
|---------|-------------|---------|------------|
| `createStar.py` | ASCII art star pattern | Pattern printing | Beginner |
| `fun_motivational_quotes.py` | Random motivational quotes | Entertainment | Beginner |

## How to Run

### Basic Programs

```bash
# Run Hello World
python hello-world.py

# Expected Output:
# Hello World!
```

### Programs with Input

```bash
# Run Caesar Cipher Encryption
python CaesarCipherEncrypt.py

# You'll be prompted to:
# 1. Enter the string to encode
# 2. Enter the shift key (integer)
```

### Programs with Dependencies

Some programs require additional libraries:

```bash
# Install required libraries
pip install pandas scikit-learn

# Run Linear Regression
python LinearRegression.py
```

### Creating a Virtual Environment (Recommended)

```bash
# Create virtual environment
python -m venv venv

# Activate it
# Windows:
venv\Scripts\activate
# macOS/Linux:
source venv/bin/activate

# Install dependencies
pip install -r requirements.txt
```

## 📚 Detailed Examples

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
