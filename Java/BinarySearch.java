import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int size;
            int numQueries;

            try {
                size = sc.nextInt();
                if (size < 0) {
                    throw new IllegalArgumentException("Size cannot be negative.");
                }
                numQueries = sc.nextInt();
                if (numQueries < 0) {
                    throw new IllegalArgumentException("Number of queries cannot be negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers for size and number of queries.");
                return;
            }

            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            while (numQueries > 0) {
                try {
                    int searchTarget = sc.nextInt();
                    int foundIndex = binarySearch(arr, searchTarget);
                    if (foundIndex != -1) {
                        System.out.println("found " + foundIndex);
                    } else {
                        System.out.println("not found");
                    }
                    numQueries--;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter integers only.");
                    break;
                }
            }
        }
    }

    private static int binarySearch(int[] arr, int target) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be null.");
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
