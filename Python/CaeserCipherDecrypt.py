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
