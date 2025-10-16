import java.util.Arrays;

/**
 * BubbleSort - Implementation of the Bubble Sort Algorithm
 * 
 * <p>Bubble Sort is a simple sorting algorithm that repeatedly steps through
 * the list, compares adjacent elements, and swaps them if they are in the
 * wrong order. The pass through the list is repeated until the list is sorted.</p>
 * 
 * <h2>Algorithm Characteristics:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(n²) worst/average case, O(n) best case</li>
 *   <li><b>Space Complexity:</b> O(1) - sorts in-place</li>
 *   <li><b>Stability:</b> Stable - maintains relative order of equal elements</li>
 *   <li><b>Method:</b> Comparison-based sorting</li>
 * </ul>
 * 
 * <h2>How It Works:</h2>
 * <p>The algorithm makes multiple passes through the array. In each pass:</p>
 * <ol>
 *   <li>Compare adjacent pairs of elements</li>
 *   <li>Swap them if they are out of order</li>
 *   <li>After each pass, the largest unsorted element "bubbles up" to its correct position</li>
 *   <li>Continue until no swaps are needed (array is sorted)</li>
 * </ol>
 * 
 * <h2>Optimization:</h2>
 * <p>This implementation includes an optimization that detects when the array
 * is already sorted and terminates early, achieving O(n) time in the best case.</p>
 * 
 * @author Code-Contribution Community
 * @version 1.1
 * @since 2025-10-15
 */
public class BubbleSort {

    /**
     * Sorts an array of integers in ascending order using the Bubble Sort algorithm.
     * 
     * <p>This method modifies the input array in-place. It uses an optimized
     * version of bubble sort that tracks whether any swaps were made in each pass.
     * If no swaps occur, the array is already sorted and the algorithm terminates early.</p>
     * 
     * @param arr The array of integers to be sorted (modified in-place)
     * 
     * @throws NullPointerException if the array is null
     * 
     * @example
     * <pre>{@code
     * int[] numbers = {5, 2, 8, 1, 9};
     * BubbleSort.bubbleSort(numbers);
     * // numbers is now {1, 2, 5, 8, 9}
     * }</pre>
     * 
     * @see #main(String[])
     */
    public static void bubbleSort(int[] arr) {
        boolean swapped;
        
        // Outer loop: make n-1 passes through the array
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            
            // Inner loop: compare and swap adjacent elements
            // After i passes, the last i elements are already in place
            for (int j = 0; j < arr.length - i - 1; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    // Swap if they're in wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // Optimization: if no swaps occurred, array is sorted
            if (!swapped) break;
        }
    }

    /**
     * Main method demonstrating the usage of Bubble Sort.
     * 
     * <p>Creates a sample array, sorts it using bubble sort,
     * and prints the sorted result to the console.</p>
     * 
     * @param args Command-line arguments (not used)
     * 
     * @example
     * Output for the given array:
     * <pre>
     * 0 1 1 3 4 5 6 8 10 12
     * </pre>
     */
    public static void main(String[] args) {
        // Sample array to demonstrate sorting
        int[] a = {1, 5, 6, 8, 10, 4, 12, 3, 0, 1};
        
        System.out.println("Original array: " + Arrays.toString(a));
        
        // Sort the array
        bubbleSort(a);
        
        System.out.println("Sorted array:   " + Arrays.toString(a));
        
        // Alternative: print without Arrays.toString()
        System.out.print("Elements: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

