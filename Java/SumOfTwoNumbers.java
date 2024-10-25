import java.util.*; 

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);
        
        // Prompt the user to enter the first number
        System.out.print("Enter first number: ");
        int a = sc.nextInt(); // Read the first integer input
        
        // Prompt the user to enter the second number
        System.out.print("Enter second number: ");
        int b = sc.nextInt(); // Read the second integer input

        // Calculate the sum of the two numbers
        int sum = a + b;

        // Print the result to the console
        System.out.println("The sum is: " + sum);
        
        // Close the Scanner 
        sc.close();
    }
}
