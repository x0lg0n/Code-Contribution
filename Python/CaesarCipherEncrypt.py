"""
Caesar Cipher Encryption

This module implements the Caesar cipher encryption algorithm, which is one of the
simplest and most widely known encryption techniques. It is a type of substitution
cipher where each letter in the plaintext is shifted a certain number of positions
down or up the alphabet.

The Caesar cipher is named after Julius Caesar, who used it to protect messages of
military significance.

Algorithm:
    1. For each character in the input text:
       - If uppercase: shift within A-Z range
       - If lowercase: shift within a-z range
       - If not a letter: keep unchanged
    2. Apply modulo 26 to wrap around the alphabet

Time Complexity: O(n) where n is the length of the text
Space Complexity: O(n) for storing the result

Example:
    Text: "Hello World"
    Key: 3
    Result: "Khoor Zruog"

Author: Code-Contribution Community
Date: October 2025
"""


def caesar_cipher(text, key):
    """
    Encrypts text using the Caesar cipher algorithm.
    
    This function shifts each alphabetic character by the specified key value.
    Non-alphabetic characters (spaces, punctuation, numbers) remain unchanged.
    
    Args:
        text (str): The plaintext message to encrypt
        key (int): The number of positions to shift each letter (can be positive or negative)
    
    Returns:
        str: The encrypted text with each letter shifted by the key amount
    
    Example:
        >>> caesar_cipher("Hello", 3)
        'Khoor'
        >>> caesar_cipher("XYZ", 3)
        'ABC'
        >>> caesar_cipher("Hello World!", 5)
        'Mjqqt Btwqi!'
    
    Note:
        - Uppercase letters remain uppercase
        - Lowercase letters remain lowercase
        - The shift wraps around (Z shifts to A, z shifts to a)
    """
    result = ""
    
    # Iterate through each character in the input text
    for char in text:
        if char.isupper():
            # Shift uppercase letters (ASCII 65-90)
            # Formula: (ASCII value - 65 + key) % 26 + 65
            result += chr((ord(char) + key - 65) % 26 + 65)
        elif char.islower():
            # Shift lowercase letters (ASCII 97-122)
            # Formula: (ASCII value - 97 + key) % 26 + 97
            result += chr((ord(char) + key - 97) % 26 + 97)
        else:
            # Keep non-alphabetic characters unchanged
            result += char
    
    return result


def main():
    """
    Main function to run the Caesar cipher encryption program.
    
    Prompts the user for input text and shift key, then displays
    the encrypted result.
    """
    print("=== Caesar Cipher Encryption ===")
    print("This program encrypts your text using the Caesar cipher.")
    print("Tip: Use a negative key to shift backwards\n")
    
    # Get user input
    text = input("Enter the string to encode: ")
    
    # Validate and get the shift key
    try:
        key = int(input("Enter the shift key (integer): "))
    except ValueError:
        print("Error: Please enter a valid integer for the shift key.")
        return
    
    # Encrypt the text
    encoded_text = caesar_cipher(text, key)
    
    # Display results
    print(f"\nOriginal text:  {text}")
    print(f"Shift key:      {key}")
    print(f"Encoded string: {encoded_text}")


if __name__ == "__main__":
    # Execute the main function when script is run directly
    main()
