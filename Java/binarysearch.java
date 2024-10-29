import java.util.*;

public class binarysearch {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int size = sc.nextInt();
            if (size < 0) {
                System.out.println("Size cannot be negative.");
                return;
            }
            int numQueries = sc.nextInt();
            if (numQueries < 0) {
                System.out.println("Number of queries cannot be negative.");
                return;
            }
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            while (numQueries > 0) {
                int searchTarget = sc.nextInt();
                int foundIndex = binarySearch(arr, searchTarget);
                if (foundIndex != -1) {
                    System.out.println("found " + foundIndex);
                } else {
                    System.out.println("not found");
                }
                numQueries--;
            }
        }
    }

    private static int binarySearch(int[] arr, int target) {
        if (arr == null) {
            System.out.println("Array is null.");
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
