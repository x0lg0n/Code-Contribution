/**
 * @file bubbleSort.cpp
 * @brief Implementation of the Bubble Sort algorithm in C++
 * 
 * This program demonstrates the bubble sort algorithm, one of the simplest
 * sorting algorithms. It works by repeatedly swapping adjacent elements if
 * they are in the wrong order, causing larger elements to "bubble" to the end.
 * 
 * Algorithm Explanation:
 * Bubble sort compares each pair of adjacent items and swaps them if they are
 * in the wrong order. The pass through the list is repeated until no swaps are
 * needed, which indicates that the list is sorted.
 * 
 * Complexity Analysis:
 * - Time Complexity (Best):    O(n)   - Already sorted array
 * - Time Complexity (Average): O(n²)  - Random order
 * - Time Complexity (Worst):   O(n²)  - Reverse sorted array
 * - Space Complexity:          O(1)   - In-place sorting
 * 
 * Properties:
 * - Stable: Yes (maintains relative order of equal elements)
 * - In-place: Yes (requires only constant O(1) extra space)
 * - Adaptive: Can be optimized to stop early if array becomes sorted
 * 
 * Compilation: g++ bubbleSort.cpp -o bubbleSort
 * Execution:   ./bubbleSort
 * 
 * @author Code-Contribution Community
 * @version 1.0
 * @date October 2025
 */

#include <iostream>
using namespace std;

/**
 * @brief Sorts an array using the bubble sort algorithm
 * 
 * This function implements the bubble sort algorithm to sort an integer array
 * in ascending order. It uses nested loops to compare adjacent elements and
 * swap them if they are in the wrong order.
 * 
 * The outer loop runs (size-1) times, and in each iteration, the largest
 * unsorted element "bubbles up" to its correct position at the end.
 * 
 * @param arr The integer array to be sorted
 * @param size The number of elements in the array
 * 
 * @note This function modifies the original array in-place
 * @note The algorithm is stable and maintains the relative order of equal elements
 * 
 * @complexity O(n²) time complexity, O(1) space complexity
 * 
 * Example:
 * @code
 * int arr[] = {64, 34, 25, 12, 22};
 * bubbleSort(arr, 5);
 * // arr is now: {12, 22, 25, 34, 64}
 * @endcode
 */
void bubbleSort(int arr[], int size) {
    // Outer loop: represents the number of passes
    // After each pass, one more element is in its correct position
    for (int step = 0; step < size - 1; ++step) {
        
        // Flag to optimize: if no swaps occur in a pass, array is sorted
        bool swapped = false;
        
        // Inner loop: compares adjacent elements
        // The range decreases with each pass since last elements are already sorted
        for (int i = 0; i < size - step - 1; ++i) {
            
            // Compare adjacent elements
            if (arr[i] > arr[i + 1]) {
                // Swap if elements are in wrong order
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                swapped = true;
            }
        }
        
        // Optimization: if no swaps occurred, array is already sorted
        if (!swapped) {
            break;
        }
    }
}

/**
 * @brief Prints the elements of an integer array
 * 
 * This utility function displays all elements of an array in a formatted manner,
 * with each element separated by a space.
 * 
 * @param arr The integer array to be printed
 * @param size The number of elements in the array
 * 
 * Output format: " element1 element2 element3 ..."
 */
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        cout << " " << arr[i];
    }
    cout << endl;
}

/**
 * @brief Main function demonstrating bubble sort
 * 
 * Creates a sample array, sorts it using bubble sort, and displays
 * both the original and sorted arrays.
 * 
 * @return 0 on successful execution
 */
int main() {
    // Sample array to demonstrate bubble sort
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    
    // Calculate the number of elements in the array
    int N = sizeof(arr) / sizeof(arr[0]);
    
    // Display original array
    cout << "Original array:\n";
    printArray(arr, N);
    
    // Sort the array using bubble sort
    bubbleSort(arr, N);
    
    // Display sorted array
    cout << "\nSorted array:\n";
    printArray(arr, N);
    
    return 0;
}