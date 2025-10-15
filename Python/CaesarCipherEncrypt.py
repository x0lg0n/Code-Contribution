"""
Caesar Cipher Encryption

This module implements the Caesar cipher, a substitution cipher where each
letter in the plaintext is shifted a certain number of places down the alphabet.

Named after Julius Caesar, who used it to protect messages of military significance,
this is one of the oldest and simplest encryption techniques.

Author: Code-Contribution Community
License: MIT
"""


def caesar_cipher(text: str, key: int) -> str:
    """
    Encrypt text using the Caesar cipher algorithm.
    
    The Caesar cipher shifts each letter in the text by a fixed number of
    positions in the alphabet. Non-alphabetic characters remain unchanged.
    
    Args:
        text (str): The plaintext message to encrypt
        key (int): The shift value (number of positions to shift).
                   Positive values shift right, negative shift left.
    
    Returns:
        str: The encrypted ciphertext
    
    Raises:
        None: This function handles all input gracefully
    
    Example:
        >>> caesar_cipher("HELLO", 3)
        'KHOOR'
        
        >>> caesar_cipher("Hello World!", 5)
        'Mjqqt Btwqi!'
        
        >>> caesar_cipher("XYZ", 3)
        'ABC'
        
    Note:
        - Uppercase letters remain uppercase
        - Lowercase letters remain lowercase
        - Non-alphabetic characters (spaces, punctuation) are preserved
        - The cipher wraps around (Z + 1 = A)
    
    Algorithm:
        1. Iterate through each character in the text
        2. If uppercase: shift within A-Z range (ASCII 65-90)
        3. If lowercase: shift within a-z range (ASCII 97-122)
        4. Otherwise: keep character unchanged
        5. Use modulo 26 to wrap around the alphabet
    """
    result = ""
    
    for char in text:
        if char.isupper():
            # Shift uppercase letters (A=65, Z=90)
            result += chr((ord(char) + key - 65) % 26 + 65)
        elif char.islower():
            # Shift lowercase letters (a=97, z=122)
            result += chr((ord(char) + key - 97) % 26 + 97)
        else:
            # Preserve non-alphabetic characters
            result += char
    
    return result


def main():
    """
    Main function to run the Caesar cipher encryption program interactively.
    
    Prompts the user for input text and shift key, then displays the
    encrypted result.
    """
    print("=== Caesar Cipher Encryption ===\n")
    
    # Get input from user
    text = input("Enter the string to encode: ")
    
    try:
        key = int(input("Enter the shift key (integer): "))
    except ValueError:
        print("Error: Shift key must be an integer. Using default key = 3")
        key = 3
    
    # Encrypt the text
    encoded_text = caesar_cipher(text, key)
    
    # Display result
    print(f"\nOriginal text: {text}")
    print(f"Shift key: {key}")
    print(f"Encoded string: {encoded_text}")


if __name__ == "__main__":
    main()

