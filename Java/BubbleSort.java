import java.util.*;
public class BubbleSort {   //n-1
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        //Input
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        //Sort
        for (int i = 0; i < arr.length - 1; i++) {                    //for example size is 5 then i<4
            for (int j = 0; j < arr.length - i - 1; j++) {              //for Moving to the next Index with comparing
                if (arr[j] > arr[j + 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        printArray(arr);                                      //Calling the Function.
    }
}