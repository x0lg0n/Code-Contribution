import java.util.*;

/**
 * BinarySearch - Implementation of the Binary Search Algorithm
 * 
 * <p>Binary Search is an efficient search algorithm that finds the position
 * of a target value within a sorted array. It compares the target value
 * to the middle element of the array and eliminates half of the search
 * space in each iteration.</p>
 * 
 * <h2>Algorithm Characteristics:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(log n) - logarithmic time complexity</li>
 *   <li><b>Space Complexity:</b> O(1) - constant space (iterative implementation)</li>
 *   <li><b>Prerequisite:</b> Array must be sorted</li>
 *   <li><b>Method:</b> Divide and conquer approach</li>
 * </ul>
 * 
 * <h2>How It Works:</h2>
 * <p>The algorithm repeatedly divides the search space in half:</p>
 * <ol>
 *   <li>Compare target with middle element</li>
 *   <li>If equal, return the index</li>
 *   <li>If target is smaller, search left half</li>
 *   <li>If target is larger, search right half</li>
 *   <li>Repeat until found or search space is exhausted</li>
 * </ol>
 * 
 * @author Code-Contribution Community
 * @version 1.1
 * @since 2025-10-15
 * 
 * @see Arrays#sort(int[])
 */
public class BinarySearch {
    /**
     * Main method demonstrating binary search functionality.
     * 
     * <p>This method reads input from the user including array size, number of queries,
     * array elements, and search targets. It sorts the array and performs binary search
     * for each query, displaying the results.</p>
     * 
     * <p><b>Input Format:</b></p>
     * <ul>
     *   <li>First line: array size and number of queries</li>
     *   <li>Second line: array elements (space-separated)</li>
     *   <li>Next lines: search targets (one per line)</li>
     * </ul>
     * 
     * @param args Command-line arguments (not used)
     * 
     * @example
     * <pre>
     * Input:
     * 5 3
     * 1 3 5 7 9
     * 3
     * 7
     * 4
     * 
     * Output:
     * found 1
     * found 3
     * not found
     * </pre>
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int size;
            int numQueries;

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
                return;
            }

            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            while (numQueries > 0) {
                try {
                    int searchTarget = sc.nextInt();
                    int foundIndex = binarySearch(arr, searchTarget);
                    if (foundIndex != -1) {
                        System.out.println("found " + foundIndex);
                    } else {
                        System.out.println("not found");
                    }
                    numQueries--;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter integers only.");
                    break;
                }
            }
        }
    }

    /**
     * Performs binary search on a sorted array to find the target value.
     * 
     * <p>This method implements the iterative version of binary search algorithm.
     * It assumes the input array is already sorted in ascending order. The method
     * uses the divide-and-conquer approach to efficiently locate the target value.</p>
     * 
     * @param arr The sorted array to search in (must not be null)
     * @param target The value to search for
     * @return The index of the target value if found, -1 if not found
     * 
     * @throws NullPointerException if the array is null
     * 
     * @example
     * <pre>{@code
     * int[] sortedArray = {1, 3, 5, 7, 9, 11, 13};
     * int index = BinarySearch.binarySearch(sortedArray, 7);
     * // Returns: 3 (index of value 7)
     * 
     * int notFound = BinarySearch.binarySearch(sortedArray, 4);
     * // Returns: -1 (value 4 not found)
     * }</pre>
     * 
     * @see #main(String[])
     */
    private static int binarySearch(int[] arr, int target) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be null.");
        }
        
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end) {
            // Calculate middle index using safe arithmetic to prevent overflow
            int mid = start + (end - start) / 2;
            
            if (arr[mid] > target) {
                // Target is in left half
                end = mid - 1;
            } else if (arr[mid] < target) {
                // Target is in right half
                start = mid + 1;
            } else {
                // Target found
                return mid;
            }
        }
        
        // Target not found
        return -1;
    }
}
