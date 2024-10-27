import string

class SolitaireCipher:
    def __init__(self, deck):
        self.deck = deck
    
    def move_joker_A(self):
        joker_A_index = self.deck.index(53)
        self.deck.insert((joker_A_index + 1) % len(self.deck), self.deck.pop(joker_A_index))

    def move_joker_B(self):
        joker_B_index = self.deck.index(54)
        self.deck.insert((joker_B_index + 2) % len(self.deck), self.deck.pop(joker_B_index))

    def triple_cut(self):
        first_joker = min(self.deck.index(53), self.deck.index(54))
        second_joker = max(self.deck.index(53), self.deck.index(54))
        self.deck = self.deck[second_joker + 1:] + self.deck[first_joker:second_joker + 1] + self.deck[:first_joker]

    def count_cut(self):
        cut_value = self.deck[-1]
        if cut_value == 54:
            cut_value = 53
        self.deck = self.deck[cut_value:-1] + self.deck[:cut_value] + [self.deck[-1]]

    def get_keystream_value(self):
        top_card_value = self.deck[0]
        if top_card_value == 54:
            top_card_value = 53
        return self.deck[top_card_value]

    def generate_keystream(self, length):
        keystream = []
        while len(keystream) < length:
            self.move_joker_A()
            self.move_joker_B()
            self.triple_cut()
            self.count_cut()
            keystream_value = self.get_keystream_value()
            if keystream_value < 53:  # ignore joker values
                keystream.append(keystream_value)
        return keystream

def preprocess_message(message):
    message = ''.join([c.upper() for c in message if c in string.ascii_letters])
    if len(message) % 5 != 0:
        message += 'X' * (5 - len(message) % 5)
    return message

def letters_to_numbers(message):
    return [ord(c) - ord('A') + 1 for c in message]

def numbers_to_letters(numbers):
    return ''.join([chr((n - 1) % 26 + ord('A')) for n in numbers])

def solitaire_encrypt(message, deck):
    cipher = SolitaireCipher(deck)
    message = preprocess_message(message)
    message_numbers = letters_to_numbers(message)
    keystream = cipher.generate_keystream(len(message_numbers))
    
    encrypted_numbers = [(m + k - 1) % 26 + 1 for m, k in zip(message_numbers, keystream)]
    encrypted_message = numbers_to_letters(encrypted_numbers)
    
    return encrypted_message

# Initial deck setup (cards are numbered 1-52, 53 is Joker A, 54 is Joker B)
deck = list(range(1, 55))

# Input message
message = input("Enter the message to encrypt: ")

# Encrypt the message using the Solitaire cipher
encrypted_message = solitaire_encrypt(message, deck)
print(f"Encrypted message: {encrypted_message}")
