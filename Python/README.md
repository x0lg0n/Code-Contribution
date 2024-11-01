# Python Code Examples

This directory contains code examples written in Python. Each example demonstrates a specific concept or functionality in Python programming.

## Table of Contents

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
