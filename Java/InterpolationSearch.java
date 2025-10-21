/**
 * InterpolationSearch - Implementation of the Interpolation Search Algorithm
 * 
 * <p>Interpolation Search is an algorithm for searching in a sorted array that
 * estimates the likely position of the target value based on its relationship
 * to the range of values in the array. It is particularly effective for
 * uniformly distributed data and often outperforms binary search under these conditions.</p>
 * 
 * <h2>Algorithm Characteristics:</h2>
 * <ul>
 *   <li><b>Time Complexity (Best):</b> O(log log n) - when data is uniformly distributed</li>
 *   <li><b>Time Complexity (Worst):</b> O(n) - when data is highly skewed or non-uniform</li>
 *   <li><b>Space Complexity:</b> O(1) - operates in-place</li>
 *   <li><b>Prerequisite:</b> Array must be sorted</li>
 *   <li><b>Method:</b> Probabilistic search using interpolation formula</li>
 * </ul>
 * 
 * <h2>How It Works:</h2>
 * <p>Unlike binary search which always divides the search space in half,
 * interpolation search estimates the position using the formula:</p>
 * <pre>
 * position = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low])
 * </pre>
 * <p>This formula assumes a linear distribution of values between the bounds.</p>
 * 
 * <h2>Advantages:</h2>
 * <ul>
 *   <li>Excellent performance on uniformly distributed data</li>
 *   <li>Often faster than binary search for large datasets</li>
 *   <li>Constant space complexity</li>
 * </ul>
 * 
 * <h2>Disadvantages:</h2>
 * <ul>
 *   <li>Performance degrades on non-uniformly distributed data</li>
 *   <li>Worst-case time complexity is O(n)</li>
 *   <li>Requires sorted array</li>
 * </ul>
 * 
 * @author Code-Contribution Community
 * @version 1.1
 * @since 2025-10-15
 * 
 * @see BinarySearch
 */
public class InterpolationSearch {
    
    /**
     * Performs interpolation search on a sorted array to find the target value.
     * 
     * <p>This method uses interpolation to estimate the position of the target
     * value based on the distribution of values in the array. It works best
     * when the data is uniformly distributed.</p>
     * 
     * @param arr The sorted array to search in (must not be null)
     * @param target The value to search for
     * @return The index of the target value if found, -1 if not found
     * 
     * @throws NullPointerException if the array is null
     * 
     * @example
     * <pre>{@code
     * int[] sortedArray = {2, 3, 4, 10, 40};
     * int index = InterpolationSearch.interpolationSearch(sortedArray, 10);
     * // Returns: 3 (index of value 10)
     * 
     * int notFound = InterpolationSearch.interpolationSearch(sortedArray, 5);
     * // Returns: -1 (value 5 not found)
     * }</pre>
     * 
     * @see #main(String[])
     */
    public static int interpolationSearch(int[] arr, int target) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be null");
        }
        
        int low = 0;
        int high = arr.length - 1;
        
        // Continue searching while target is within the bounds of the array
        while (low <= high && target >= arr[low] && target <= arr[high]) {
            // Calculate the estimated position using interpolation formula
            int estimatedPosition = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            
            // Check if target is found at the estimated position
            if (arr[estimatedPosition] == target) {
                return estimatedPosition;
            }
            
            // Adjust search bounds based on comparison
            if (arr[estimatedPosition] < target) {
                // Target is in the right half
                low = estimatedPosition + 1;
            } else {
                // Target is in the left half
                high = estimatedPosition - 1;
            }
        }
        
        // Target not found
        return -1;
    }
    
    /**
     * Main method demonstrating the usage of Interpolation Search.
     * 
     * <p>Creates a sample sorted array and demonstrates searching for
     * different values, showing both successful and unsuccessful searches.</p>
     * 
     * @param args Command-line arguments (not used)
     * 
     * @example
     * Output for the given array:
     * <pre>
     * Searching for 10 in array: [2, 3, 4, 10, 40]
     * Element found at index 3
     * 
     * Searching for 5 in array: [2, 3, 4, 10, 40]
     * Element not present in array
     * </pre>
     */
    public static void main(String[] args) {
        // Sample sorted array for demonstration
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;
        
        System.out.println("Searching for " + target + " in array: [2, 3, 4, 10, 40]");
        int result = interpolationSearch(arr, target);
        
        if (result == -1) {
            System.out.println("Element not present in array");
        } else {
            System.out.println("Element found at index " + result);
        }
        
        // Additional demonstration with a value not in the array
        System.out.println("\n--- Additional Example ---");
        int[] largerArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int searchTarget = 7;
        
        System.out.println("Searching for " + searchTarget + " in larger array");
        int searchResult = interpolationSearch(largerArray, searchTarget);
        
        if (searchResult == -1) {
            System.out.println("Element not present in array");
        } else {
            System.out.println("Element found at index " + searchResult);
        }
        
        // Test with non-existent element
        int nonExistentTarget = 20;
        System.out.println("\nSearching for " + nonExistentTarget + " (not in array)");
        int nonExistentResult = interpolationSearch(largerArray, nonExistentTarget);
        
        if (nonExistentResult == -1) {
            System.out.println("Element not present in array");
        } else {
            System.out.println("Element found at index " + nonExistentResult);
        }
    }
}