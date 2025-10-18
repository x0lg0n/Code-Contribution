/**
 * @file bubblesort.c
 * @brief Implementation of the Bubble Sort algorithm in C
 * 
 * This program demonstrates the bubble sort algorithm, which is a simple
 * comparison-based sorting algorithm. It repeatedly steps through the list,
 * compares adjacent elements, and swaps them if they are in the wrong order.
 * 
 * Algorithm Overview:
 * - Bubble sort works by comparing adjacent pairs of elements
 * - If they are in the wrong order, they are swapped
 * - This process is repeated until no more swaps are needed
 * - Larger elements "bubble" to the end of the array
 * 
 * Time Complexity:
 * - Best Case:    O(n)   - when array is already sorted
 * - Average Case: O(n²)  - typical random data
 * - Worst Case:   O(n²)  - when array is reverse sorted
 * 
 * Space Complexity: O(1) - sorts in place, only uses constant extra space
 * 
 * Stability: Stable - maintains relative order of equal elements
 * 
 * Compilation: gcc bubblesort.c -o bubblesort
 * Execution:   ./bubblesort
 * 
 * @author Code-Contribution Community
 * @date October 2025
 * @version 1.0
 */

#include <stdio.h>

/**
 * @brief Sorts an array using the bubble sort algorithm
 * 
 * This function implements bubble sort by repeatedly comparing adjacent
 * elements and swapping them if they are in the wrong order. The algorithm
 * continues until no more swaps are needed, indicating the array is sorted.
 * 
 * @param arr Pointer to the integer array to be sorted
 * @param n The number of elements in the array
 * 
 * @note This function modifies the original array
 * @note Time complexity: O(n²) in worst and average cases
 * 
 * @see printArray() for displaying the array
 * 
 * Example:
 * @code
 * int arr[] = {5, 1, 4, 2, 8};
 * int n = 5;
 * bubbleSort(arr, n);
 * // arr is now {1, 2, 4, 5, 8}
 * @endcode
 */
void bubbleSort(int arr[], int n) {
    // Outer loop: controls the number of passes
    // After each pass, the largest unsorted element moves to its correct position
    for (int i = 0; i < n - 1; i++) {
        
        // Inner loop: compares adjacent elements
        // After pass i, the last i elements are already in place
        for (int j = 0; j < n - i - 1; j++) {
            
            // Compare adjacent elements
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1] if they are in wrong order
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

/**
 * @brief Prints the elements of an integer array
 * 
 * This utility function displays all elements of an array on a single line,
 * separated by spaces, followed by a newline character.
 * 
 * @param arr Pointer to the integer array to be printed
 * @param n The number of elements in the array
 * 
 * Example Output:
 * @code
 * 1 2 3 4 5
 * @endcode
 */
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

/**
 * @brief Main function demonstrating bubble sort
 * 
 * This function creates a sample array, displays it before sorting,
 * applies bubble sort, and then displays the sorted result.
 * 
 * @return 0 on successful execution
 */
int main() {
    // Initialize a sample array
    int arr[] = {5, 1, 4, 2, 8};
    
    // Calculate the number of elements in the array
    int n = sizeof(arr) / sizeof(arr[0]);

    // Display the original unsorted array
    printf("Original array:\n");
    printArray(arr, n);

    // Sort the array using bubble sort
    bubbleSort(arr, n);

    // Display the sorted array
    printf("Sorted array:\n");
    printArray(arr, n);

    return 0;
}
