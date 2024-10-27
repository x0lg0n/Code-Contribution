public class InterpolationSearch {
    /*
     * Interpolation Search:
     * 
     * Working: Interpolation search is an algorithm for searching in a sorted array, particularly effective for uniformly 
     *          distributed data. It estimates the likely position of the target value based on its relationship to the 
     *          range of values in the array, rather than splitting the search space in half as in binary search.
     * 
     * Stability: Interpolation search is not stable, as it does not maintain the order of equal elements.
     * 
     * Time Complexity(Best): O(log log n) - Achieved when elements are uniformly distributed.
     * 
     * Time Complexity(Worst): O(n) - Occurs when data is highly skewed or distribution is non-uniform.
     * 
     * Space Complexity: O(1) - Interpolation search operates in-place, requiring no extra space.
     * 
     * Unique Feature: Interpolation search is well-suited for searching in large, uniformly distributed data sets and 
     *                 often outperforms binary search under these conditions. However, its efficiency diminishes on 
     *                 non-uniformly distributed data.
    */

    public static void main(String args[]) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        int result = interpolationSearch(arr, x);

        if (result == -1)
            System.out.println("Element not present in array");

        else
            System.out.println("Element found at index " + result);

    }

    public static int interpolationSearch(int[] arr, int x) {
        int low = 0, high = (arr.length - 1);

        while (low <= high && x >= arr[low] && x <= arr[high]) {
            int pos = low + ((x - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == x)
                return pos;

            if (arr[pos] < x)
                low = pos + 1;

            else
                high = pos - 1;

        }
        return -1;
    }

}