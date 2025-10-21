import java.util.Arrays;

/**
 * MergeSort - Implementation of the Merge Sort Algorithm
 * 
 * <p>Merge Sort is an efficient, stable, comparison-based sorting algorithm
 * that uses the divide-and-conquer paradigm. It divides the input array into
 * two halves, recursively sorts each half, and then merges the sorted halves
 * to produce the final sorted array.</p>
 * 
 * <h2>Algorithm Characteristics:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(n log n) - consistent performance in all cases</li>
 *   <li><b>Space Complexity:</b> O(n) - requires additional space for merging</li>
 *   <li><b>Stability:</b> Stable - maintains relative order of equal elements</li>
 *   <li><b>Method:</b> Divide and conquer with merge operation</li>
 *   <li><b>Performance:</b> Guaranteed O(n log n) performance regardless of input</li>
 * </ul>
 * 
 * <h2>How It Works:</h2>
 * <p>The algorithm follows these steps:</p>
 * <ol>
 *   <li><b>Divide:</b> Split the array into two equal halves</li>
 *   <li><b>Conquer:</b> Recursively sort both halves</li>
 *   <li><b>Combine:</b> Merge the sorted halves into a single sorted array</li>
 * </ol>
 * 
 * <h2>Advantages:</h2>
 * <ul>
 *   <li>Consistent O(n log n) time complexity</li>
 *   <li>Stable sorting algorithm</li>
 *   <li>Predictable performance</li>
 *   <li>Good for large datasets</li>
 *   <li>Parallelizable</li>
 * </ul>
 * 
 * <h2>Disadvantages:</h2>
 * <ul>
 *   <li>Requires O(n) additional space</li>
 *   <li>Not in-place sorting</li>
 *   <li>Slower than quicksort for small arrays</li>
 * </ul>
 * 
 * @author Code-Contribution Community
 * @version 1.0
 * @since 2025-10-15
 * 
 * @see Arrays#sort(int[])
 */
public class MergeSort {
    
    /**
     * Sorts an array of integers in ascending order using the Merge Sort algorithm.
     * 
     * <p>This method initiates the merge sort process by calling the recursive
     * mergeSortHelper method. It creates a temporary array for the merge operation
     * to avoid creating multiple arrays during recursion.</p>
     * 
     * @param array The array of integers to be sorted (modified in-place)
     * 
     * @throws NullPointerException if the array is null
     * 
     * @example
     * <pre>{@code
     * int[] numbers = {38, 27, 43, 3, 9, 82, 10};
     * MergeSort.mergeSort(numbers);
     * // numbers is now {3, 9, 10, 27, 38, 43, 82}
     * }</pre>
     * 
     * @see #mergeSortHelper(int[], int[], int, int)
     * @see #main(String[])
     */
    public static void mergeSort(int[] array) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null");
        }
        
        if (array.length <= 1) {
            return; // Array is already sorted or empty
        }
        
        // Create temporary array for merge operation
        int[] tempArray = new int[array.length];
        mergeSortHelper(array, tempArray, 0, array.length - 1);
    }
    
    /**
     * Recursively sorts a portion of the array using the divide-and-conquer approach.
     * 
     * <p>This method divides the array into two halves, recursively sorts each half,
     * and then merges the sorted halves back together.</p>
     * 
     * @param array The array to be sorted
     * @param tempArray Temporary array used for merging
     * @param left The starting index of the subarray
     * @param right The ending index of the subarray
     */
    private static void mergeSortHelper(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {
            // Calculate the middle point
            int mid = left + (right - left) / 2;
            
            // Recursively sort the left half
            mergeSortHelper(array, tempArray, left, mid);
            
            // Recursively sort the right half
            mergeSortHelper(array, tempArray, mid + 1, right);
            
            // Merge the sorted halves
            merge(array, tempArray, left, mid, right);
        }
    }
    
    /**
     * Merges two sorted subarrays into a single sorted array.
     * 
     * <p>This method takes two sorted subarrays and merges them into a single
     * sorted array. It uses a temporary array to store the merged result
     * and then copies it back to the original array.</p>
     * 
     * @param array The original array containing the subarrays
     * @param tempArray Temporary array for storing merged result
     * @param left The starting index of the first subarray
     * @param mid The ending index of the first subarray
     * @param right The ending index of the second subarray
     */
    private static void merge(int[] array, int[] tempArray, int left, int mid, int right) {
        // Copy elements to temporary array
        for (int i = left; i <= right; i++) {
            tempArray[i] = array[i];
        }
        
        // Initialize pointers for the two subarrays
        int leftPointer = left;
        int rightPointer = mid + 1;
        int mergedPointer = left;
        
        // Merge the two subarrays
        while (leftPointer <= mid && rightPointer <= right) {
            if (tempArray[leftPointer] <= tempArray[rightPointer]) {
                array[mergedPointer] = tempArray[leftPointer];
                leftPointer++;
            } else {
                array[mergedPointer] = tempArray[rightPointer];
                rightPointer++;
            }
            mergedPointer++;
        }
        
        // Copy remaining elements from left subarray
        while (leftPointer <= mid) {
            array[mergedPointer] = tempArray[leftPointer];
            leftPointer++;
            mergedPointer++;
        }
        
        // Copy remaining elements from right subarray
        while (rightPointer <= right) {
            array[mergedPointer] = tempArray[rightPointer];
            rightPointer++;
            mergedPointer++;
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
     * MergeSort.printArray(numbers);
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
     * Main method demonstrating the usage of Merge Sort.
     * 
     * <p>Creates sample arrays of different sizes and demonstrates the
     * merge sort algorithm. It shows the original array, sorts it,
     * and displays the sorted result.</p>
     * 
     * @param args Command-line arguments (not used)
     * 
     * @example
     * Output for the given arrays:
     * <pre>
     * Original array: 38 27 43 3 9 82 10 
     * Sorted array:   3 9 10 27 38 43 82 
     * 
     * --- Additional Example ---
     * Original: [64, 34, 25, 12, 22, 11, 90, 5]
     * Sorted:   [5, 11, 12, 22, 25, 34, 64, 90]
     * </pre>
     */
    public static void main(String[] args) {
        // Sample array to demonstrate sorting
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Original array: " + Arrays.toString(array));
        printArray(array);
        
        // Sort the array using merge sort
        mergeSort(array);
        
        System.out.println("Sorted array:   " + Arrays.toString(array));
        printArray(array);
        
        // Additional demonstration with a larger array
        System.out.println("\n--- Additional Example ---");
        int[] largerArray = {64, 34, 25, 12, 22, 11, 90, 5};
        System.out.println("Original: " + Arrays.toString(largerArray));
        mergeSort(largerArray);
        System.out.println("Sorted:   " + Arrays.toString(largerArray));
        
        // Test with already sorted array
        System.out.println("\n--- Test with Sorted Array ---");
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Original: " + Arrays.toString(sortedArray));
        mergeSort(sortedArray);
        System.out.println("Sorted:   " + Arrays.toString(sortedArray));
        
        // Test with reverse sorted array
        System.out.println("\n--- Test with Reverse Sorted Array ---");
        int[] reverseArray = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Original: " + Arrays.toString(reverseArray));
        mergeSort(reverseArray);
        System.out.println("Sorted:   " + Arrays.toString(reverseArray));
    }
}
