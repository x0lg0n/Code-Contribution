import java.util.Arrays;

/**
 * InsertionSort - Implementation of the Insertion Sort Algorithm
 * 
 * <p>Insertion Sort is a simple sorting algorithm that builds the final sorted
 * array one element at a time. It is much less efficient on large lists than
 * more advanced algorithms such as quicksort, heapsort, or merge sort, but
 * it has several advantages including simplicity and efficiency on small datasets.</p>
 * 
 * <h2>Algorithm Characteristics:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(n²) worst/average case, O(n) best case</li>
 *   <li><b>Space Complexity:</b> O(1) - sorts in-place</li>
 *   <li><b>Stability:</b> Stable - maintains relative order of equal elements</li>
 *   <li><b>Method:</b> Comparison-based sorting</li>
 *   <li><b>Adaptive:</b> Efficient for data sets that are already substantially sorted</li>
 * </ul>
 * 
 * <h2>How It Works:</h2>
 * <p>The algorithm works by maintaining a sorted subarray at the beginning of the array:</p>
 * <ol>
 *   <li>Start with the second element (index 1)</li>
 *   <li>Compare it with elements in the sorted subarray</li>
 *   <li>Shift larger elements to the right to make space</li>
 *   <li>Insert the current element in its correct position</li>
 *   <li>Repeat for all remaining elements</li>
 * </ol>
 * 
 * <h2>Advantages:</h2>
 * <ul>
 *   <li>Simple implementation</li>
 *   <li>Efficient for small datasets</li>
 *   <li>Stable sorting algorithm</li>
 *   <li>Online algorithm - can sort a list as it receives it</li>
 * </ul>
 * 
 * @author Code-Contribution Community
 * @version 1.1
 * @since 2025-10-15
 * 
 * @see Arrays#sort(int[])
 */
public class InsertionSort {
    
    /**
     * Sorts an array of integers in ascending order using the Insertion Sort algorithm.
     * 
     * <p>This method modifies the input array in-place. It iterates through the array
     * starting from the second element, and for each element, it finds its correct
     * position in the sorted portion of the array and inserts it there.</p>
     * 
     * @param array The array of integers to be sorted (modified in-place)
     * 
     * @throws NullPointerException if the array is null
     * 
     * @example
     * <pre>{@code
     * int[] numbers = {12, 11, 13, 5, 6};
     * InsertionSort.insertionSort(numbers);
     * // numbers is now {5, 6, 11, 12, 13}
     * }</pre>
     * 
     * @see #main(String[])
     */
    public static void insertionSort(int[] array) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null");
        }
        
        int arrayLength = array.length;
        
        // Start from the second element (index 1)
        for (int currentIndex = 1; currentIndex < arrayLength; currentIndex++) {
            // Store the current element to be inserted
            int currentElement = array[currentIndex];
            
            // Find the correct position for currentElement in the sorted subarray
            int previousIndex = currentIndex - 1;
            
            // Move elements of array[0..currentIndex-1] that are greater than
            // currentElement to one position ahead of their current position
            while (previousIndex >= 0 && array[previousIndex] > currentElement) {
                array[previousIndex + 1] = array[previousIndex];
                previousIndex = previousIndex - 1;
            }
            
            // Insert currentElement at its correct position
            array[previousIndex + 1] = currentElement;
        }
    }
    
    /**
     * Prints the elements of an array to the console.
     * 
     * <p>This utility method displays all elements of the given array
     * separated by spaces, followed by a newline character.</p>
     * 
     * @param array The array to be printed (must not be null)
     * 
     * @throws NullPointerException if the array is null
     * 
     * @example
     * <pre>{@code
     * int[] numbers = {1, 2, 3, 4, 5};
     * InsertionSort.printArray(numbers);
     * // Output: 1 2 3 4 5
     * }</pre>
     */
    public static void printArray(int[] array) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null");
        }
        
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    /**
     * Main method demonstrating the usage of Insertion Sort.
     * 
     * <p>Creates a sample array, displays the original array, sorts it using
     * insertion sort, and then displays the sorted result.</p>
     * 
     * @param args Command-line arguments (not used)
     * 
     * @example
     * Output for the given array:
     * <pre>
     * Original array:
     * 12 11 13 5 6 
     * Sorted array:
     * 5 6 11 12 13 
     * </pre>
     */
    public static void main(String[] args) {
        // Sample array to demonstrate sorting
        int[] array = {12, 11, 13, 5, 6};
        
        System.out.println("Original array:");
        printArray(array);
        
        // Sort the array using insertion sort
        insertionSort(array);
        
        System.out.println("Sorted array:");
        printArray(array);
        
        // Additional demonstration with a larger array
        System.out.println("\n--- Additional Example ---");
        int[] largerArray = {64, 34, 25, 12, 22, 11, 90, 5};
        System.out.println("Original: " + Arrays.toString(largerArray));
        insertionSort(largerArray);
        System.out.println("Sorted:   " + Arrays.toString(largerArray));
    }
}