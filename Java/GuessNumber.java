import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        try {
            String playAgain;

            do {
                // Generate a random number between 1 and 100
                int randomNumber = (int) (Math.random() * 100) + 1;
                int guess = 0;
                int attempts = 0;

                System.out.println("Welcome to the Number Guessing Game!");
                System.out.println("I have picked a number between 1 and 100. Can you guess it?");
                
                // Start the game loop
                while (guess != randomNumber) {
                    System.out.print("Enter your guess (between 1 and 100): ");

                    try {
                        // Check if the user entered a valid integer
                        guess = scanner.nextInt(); // Get the user's guess
                        attempts++; // Increment the attempt counter

                        // Validate if the guess is within the range
                        if (guess < 1 || guess > 100) {
                            System.out.println("Please enter a number between 1 and 100.");
                        } else if (guess < randomNumber) {
                            System.out.println("Too low! Try again.");
                        } else if (guess > randomNumber) {
                            System.out.println("Too high! Try again.");
                        } else {
                            // The guess is correct
                            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                        }
                    } catch (InputMismatchException e) {
                        // If the input is not a valid integer
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next(); // Consume the invalid input to avoid infinite loop
                    }
                }

                // Ask the user if they want to play again
                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = scanner.next().toLowerCase(); // Get the user's response and convert it to lowercase

            } while (playAgain.equals("yes")); // Loop if the user wants to play again

            System.out.println("Thanks for playing! Goodbye.");
        } finally {
            scanner.close(); // Close the scanner
        }
    }
}
