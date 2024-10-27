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
