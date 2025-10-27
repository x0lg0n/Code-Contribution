/*
 * binarySearch.c
 * Simple iterative binary search in C.
 * Reads number of elements, the sorted array, and a target value from stdin.
 * Prints the index (0-based) if found, or a "not found" message otherwise.
 */

#include <stdio.h>
#include <stdlib.h>

int binary_search(int arr[], int n, int target) {
    int lo = 0;
    int hi = n - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == target) return mid; // found
        else if (arr[mid] < target) lo = mid + 1;
        else hi = mid - 1;
    }
    return -1; // not found
}

int main(void) {
    int n;
    if (printf("Enter number of elements: ") < 0) return 1;
    if (scanf("%d", &n) != 1 || n <= 0) {
        fprintf(stderr, "Invalid number of elements.\n");
        return 1;
    }

    int *arr = malloc(sizeof(int) * n);
    if (!arr) {
        fprintf(stderr, "Memory allocation failed.\n");
        return 1;
    }

    printf("Enter %d sorted integers (ascending) separated by spaces or newlines:\n", n);
    for (int i = 0; i < n; ++i) {
        if (scanf("%d", &arr[i]) != 1) {
            fprintf(stderr, "Failed to read array element %d.\n", i);
            free(arr);
            return 1;
        }
    }

    int target;
    if (printf("Enter value to search: ") < 0) { free(arr); return 1; }
    if (scanf("%d", &target) != 1) {
        fprintf(stderr, "Failed to read target value.\n");
        free(arr);
        return 1;
    }

    int idx = binary_search(arr, n, target);
    if (idx >= 0) {
        printf("Element %d found at index %d (0-based).\n", target, idx);
    } else {
        printf("Element %d not found in the array.\n", target);
    }

    free(arr);
    return 0;
}
