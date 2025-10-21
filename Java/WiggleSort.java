import java.util.Arrays;
import java.util.Scanner;

public class WiggleSort {
    public static void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int j = n - 1;
        for (int i = 1; i < n; i += 2) {
            nums[i] = sorted[j--];
        }

        for (int i = 0; i < n; i += 2) {
            nums[i] = sorted[j--];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        wiggleSort(nums);

        System.out.println("Wiggled array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}