# IPv4 Address Validator 


def validate(ip):
    """
    Validates whether the given string is a valid IPv4 address.

    Args:
        ip (str): The IPv4 address as a string.

    Returns:
        bool: True if valid IPv4 address, False otherwise.
    """
    try:
        # Split the IP address into its four components
        numbers = ip.split(".")
    except Exception as e:
        # If splitting fails, return False
        return False

    # IPv4 address must have exactly 4 components
    if len(numbers) != 4:
        return False
    else:
        for num in numbers:
            # Check if each component is a valid integer in the range 0-255
            try:
                if int(num) not in range(256):
                    return False
            except ValueError:
                # If conversion to int fails, it's not a valid number
                return False
        return True

def main():
    """
    Main function to prompt user for IPv4 address and validate it.
    """
    print(validate(input("Enter IPv4 Address: ")))

if __name__ == "__main__":
    main()