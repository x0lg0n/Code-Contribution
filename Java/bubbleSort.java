import java.util.Arrays;

public class bubbleSort {

    // bubble sort:
      //  Bubble sort is an algorithm where you can sort an array by making pairs and comparing between them and through it the largest elemnt in the array get sorted first.

        // Time complexity: O(n^2) in both best and worst case.

        // Unique Feature: Large values are always sorted first. It only takes one iteration to detect that a collection is already sorted. The best time complexity for Bubble Sort is O(n).

    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                int temp= arr[j];
                if(arr[j+1]<arr[j]){
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] a= {1, 5, 6, 8, 10, 4, 12, 3, 0, 1};

        bubbleSort(a);
        for(int i=0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
