import java.util.Arrays;

public class BubbleSort {

    // bubble sort:
      //  Bubble sort is an algorithm where you can sort an array by making pairs and comparing between them and through it the largest elemnt in the array get sorted first.

        // Time complexity: O(n^2) in worst case and O(1) in best case.

        // Unique Feature: Large values are always sorted first. It only takes one iteration to detect that a collection is already sorted. The best time complexity for Bubble Sort is O(n).

        public static void BubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] a= {1, 5, 6, 8, 10, 4, 12, 3, 0, 1};

        BubbleSort(a);
        for(int i=0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
