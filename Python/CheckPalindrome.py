#!/usr/bin/env python3
"""
CheckPalindrome.py

Simple program to check whether an integer is a palindrome.
Negative numbers are considered not palindromes.
"""

def is_palindrome_number(n: int) -> bool:
    if n < 0:
        return False
    original = n
    rev = 0
    while n:
        rev = rev * 10 + n % 10
        n //= 10
    return rev == original

def main():
    try:
        s = input("Enter an integer: ").strip()
        n = int(s)
    except ValueError:
        print("Invalid integer input.")
        return

    if is_palindrome_number(n):
        print(f"{n} is a palindrome.")
    else:
        print(f"{n} is not a palindrome.")

if __name__ == "__main__":
    main()