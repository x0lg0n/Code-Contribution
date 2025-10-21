import java.util.Scanner;

/**
 * FibonacciSeries - Implementation of Fibonacci Number Generation
 * 
 * <p>The Fibonacci sequence is a series of numbers where each number is the sum
 * of the two preceding ones, usually starting with 0 and 1. This class provides
 * methods to generate and display Fibonacci sequences using iterative approach.</p>
 * 
 * <h2>Mathematical Definition:</h2>
 * <p>The Fibonacci sequence is defined as:</p>
 * <ul>
 *   <li>F(0) = 0</li>
 *   <li>F(1) = 1</li>
 *   <li>F(n) = F(n-1) + F(n-2) for n > 1</li>
 * </ul>
 * 
 * <h2>Algorithm Characteristics:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(n) - linear time complexity</li>
 *   <li><b>Space Complexity:</b> O(1) - constant space (iterative implementation)</li>
 *   <li><b>Method:</b> Iterative approach with two variables</li>
 *   <li><b>Range:</b> Can handle large numbers efficiently</li>
 * </ul>
 * 
 * <h2>Example Sequence:</h2>
 * <p>For n = 10, the Fibonacci sequence is:</p>
 * <pre>0, 1, 1, 2, 3, 5, 8, 13, 21, 34</pre>
 * 
 * <h2>Applications:</h2>
 * <ul>
 *   <li>Mathematical analysis and number theory</li>
 *   <li>Computer science algorithms</li>
 *   <li>Financial modeling (Fibonacci retracements)</li>
 *   <li>Nature patterns (spiral arrangements)</li>
 * </ul>
 * 
 * @author Code-Contribution Community
 * @version 1.1
 * @since 2025-10-15
 * 
 * @see Scanner
 */
public class FibonacciSeries {
    
    /**
     * Generates and prints the Fibonacci series up to the specified number of terms.
     * 
     * <p>This method uses an iterative approach to generate Fibonacci numbers
     * efficiently. It starts with the first two numbers (0 and 1) and generates
     * subsequent numbers by adding the previous two numbers.</p>
     * 
     * @param numberOfTerms The number of terms to generate (must be >= 1)
     * 
     * @throws IllegalArgumentException if numberOfTerms is less than 1
     * 
     * @example
     * <pre>{@code
     * FibonacciSeries.generateFibonacciSeries(8);
     * // Output: Fibonacci Series: 0, 1, 1, 2, 3, 5, 8, 13
     * }</pre>
     * 
     * @see #main(String[])
     */
    public static void generateFibonacciSeries(int numberOfTerms) {
        if (numberOfTerms < 1) {
            throw new IllegalArgumentException("Number of terms must be at least 1");
        }
        
        // Handle the first term
        if (numberOfTerms == 1) {
            System.out.println("Fibonacci Series: 0");
            return;
        }
        
        // Handle the first two terms
        if (numberOfTerms == 2) {
            System.out.println("Fibonacci Series: 0, 1");
            return;
        }
        
        // Initialize the first two Fibonacci numbers
        int firstNumber = 0;
        int secondNumber = 1;
        
        System.out.print("Fibonacci Series: " + firstNumber + ", " + secondNumber);
        
        // Generate remaining terms
        for (int currentTerm = 2; currentTerm < numberOfTerms; currentTerm++) {
            int nextNumber = firstNumber + secondNumber;
            System.out.print(", " + nextNumber);
            
            // Update the two previous numbers for the next iteration
            firstNumber = secondNumber;
            secondNumber = nextNumber;
        }
        
        System.out.println(); // Print newline after the series
    }
    
    /**
     * Calculates the nth Fibonacci number using iterative approach.
     * 
     * <p>This method efficiently calculates a specific Fibonacci number
     * without generating the entire sequence, making it memory-efficient
     * for large values of n.</p>
     * 
     * @param n The position in the Fibonacci sequence (0-based index)
     * @return The nth Fibonacci number
     * 
     * @throws IllegalArgumentException if n is negative
     * 
     * @example
     * <pre>{@code
     * long fib10 = FibonacciSeries.getNthFibonacci(10);
     * // Returns: 55 (10th Fibonacci number)
     * }</pre>
     */
    public static long getNthFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }
        
        if (n <= 1) {
            return n;
        }
        
        long firstNumber = 0;
        long secondNumber = 1;
        
        for (int i = 2; i <= n; i++) {
            long nextNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = nextNumber;
        }
        
        return secondNumber;
    }
    
    /**
     * Main method demonstrating Fibonacci series generation with user input.
     * 
     * <p>This method prompts the user to enter the number of terms they want
     * in the Fibonacci series, validates the input, and then generates and
     * displays the series. It also demonstrates additional functionality
     * like calculating specific Fibonacci numbers.</p>
     * 
     * @param args Command-line arguments (not used)
     * 
     * @example
     * <pre>
     * Enter the number of terms in Fibonacci series: 8
     * Fibonacci Series: 0, 1, 1, 2, 3, 5, 8, 13
     * 
     * Additional examples:
     * 10th Fibonacci number: 55
     * 15th Fibonacci number: 610
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter the number of terms in Fibonacci series: ");
            int numberOfTerms = scanner.nextInt();
            
            // Validate input
            if (numberOfTerms < 1) {
                System.out.println("Error: Number of terms must be at least 1");
                return;
            }
            
            // Generate and display the Fibonacci series
            generateFibonacciSeries(numberOfTerms);
            
            // Additional demonstrations
            System.out.println("\n--- Additional Examples ---");
            System.out.println("10th Fibonacci number: " + getNthFibonacci(10));
            System.out.println("15th Fibonacci number: " + getNthFibonacci(15));
            System.out.println("20th Fibonacci number: " + getNthFibonacci(20));
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}