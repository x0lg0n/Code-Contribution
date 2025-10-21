#include <stdio.h>

void reverseArray(int arr[], int size) // is equivalent to passing 'int *arr' which points to the first element of the array
{

    int *start = arr;
    int *end = arr + size - 1; // pointer to the last element
    /**
    Expression	    What it means in memory
    arr	=>          address of element 0
    arr + 1	=>      address of element 1 (4 bytes ahead)
    arr + 2	=>      address of element 2 (8 bytes ahead)
    arr + size-1=>  address of the last element
    */

    while (start < end)
    {
        int temp = *start; // dereference to store the value at that address
        *start = *end;
        *end = temp;
        start++;
        end--;
    }
}
void printArray(int arr[], int size)
{

    for (int i = 0; i < size; i++)
    {
        if (i == size - 1)
        {
            printf("%d\n", arr[i]);
            break;
        }
        printf("%d, ", arr[i]);
    }
}

int main()
{
    printf("Enter the size of the array: ");
    int size;
    scanf("%d", &size);

    printf("Enter the elements of an integer array: ");

    int arr[size];
    for (int i = 0; i < size; i++)
    {
        scanf("%d", &arr[i]);
    }

    printf("before : ");
    printArray(arr, size);
    reverseArray(arr, size);
    printf("after : ");
    printArray(arr, size);

    return 0;
}