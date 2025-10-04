import java.util.*;

/**
 * This class demonstrates a simple implementation of binary search in Java.
 * It allows the user to input an array of integers, sorts it, and then performs
 * multiple binary search queries on the sorted array.
 */
public class BinarySearch {

    /**
     * The main method that drives the program.
     * It reads user input, performs input validation, sorts the array, and
     * executes binary search for the given queries.
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int size;        // Size of the array
            int numQueries;  // Number of search queries to perform

            // Read size and number of queries with input validation
            try {
                size = sc.nextInt();
                if (size < 0) {
                    throw new IllegalArgumentException("Size cannot be negative.");
                }
                numQueries = sc.nextInt();
                if (numQueries < 0) {
                    throw new IllegalArgumentException("Number of queries cannot be negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers for size and number of queries.");
                return; // Exit program if invalid input
            }

            // Initialize the array and read elements from the user
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            // Sort the array before performing binary search
            Arrays.sort(arr);

            // Perform binary search for each query
            while (numQueries > 0) {
                try {
                    int searchTarget = sc.nextInt();  // The number to search for
                    int foundIndex = binarySearch(arr, searchTarget);  // Call binary search
                    if (foundIndex != -1) {
                        System.out.println("found " + foundIndex); // Print index if found
                    } else {
                        System.out.println("not found"); // Print not found message
                    }
                    numQueries--;  // Decrement the number of remaining queries
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter integers only.");
                    break; // Exit the loop if invalid input is provided
                }
            }
        }
    }

    /**
     * Performs binary search on a sorted array to find the index of the target element.
     *
     * @param arr    The sorted array to search in
     * @param target The value to search for
     * @return The index of the target if found, otherwise -1
     * @throws NullPointerException if the array is null
     */
    private static int binarySearch(int[] arr, int target) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be null.");
        }

        int start = 0;             // Start index of the search range
        int end = arr.length - 1;  // End index of the search range

        // Continue searching until the range is exhausted
        while (start <= end) {
            int mid = start + (end - start) / 2;  // Avoid potential overflow
            if (arr[mid] > target) {
                end = mid - 1;  // Target is in the left half
            } else if (arr[mid] < target) {
                start = mid + 1;  // Target is in the right half
            } else {
                return mid;  // Target found at index mid
            }
        }
        return -1; // Target not found
    }
}