import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an integer
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();

        // Edge cases: negative numbers and numbers ending with 0 (except 0 itself) are not palindromes
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            System.out.println(num + " is not a palindrome");
        } else {
            int original = num;
            int reversed = 0;

            // Reverse the integer
            while (num > 0) {
                int lastDigit = num % 10;
                reversed = reversed * 10 + lastDigit;
                num /= 10;
            }

            // Check if the original number is equal to the reversed number
            if (original == reversed) {
                System.out.println(original + " is a palindrome");
            } else {
                System.out.println(original + " is not a palindrome");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
