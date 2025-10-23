public class Largest {
    public static void main(String[] args) {
        int [] numbers = {34, 67, 23, 89, 2, 45};
        int largest = findLargest(numbers);
        System.out.println("Largest number: " + largest);
    }
    static int findLargest(int[] arr) {
        int largest = arr[0];
        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }
}
