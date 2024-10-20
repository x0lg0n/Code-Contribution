
import random

# A list of fun motivational quotes
quotes = [
    "Believe you can and you're halfway there!",
    "You are braver than you believe, stronger than you seem, and smarter than you think.",
    "The only way to do great work is to love what you do.",
    "Do one thing every day that scares you.",
    "Don’t watch the clock; do what it does. Keep going.",
    "Success is not the key to happiness. Happiness is the key to success."
]

# Function to select a random quote
def random_quote():
    return random.choice(quotes)

# Display a random quote
print("Your motivational quote for today is:\n")
print(random_quote())
