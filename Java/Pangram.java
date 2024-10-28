public class Pangram {
    public static boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        int freq[] = new int[26];

        for (int i = 0; i < n; i++) {
            char ch = sentence.charAt(i);
            freq[ch - 'a']++;
        }

        for (int f : freq) {
            if (f == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test case 1
        String sentence1 = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println("Input: " + sentence1);
        System.out.println("Output: " + checkIfPangram(sentence1)); // Expected output: true
        System.out.println();

        // Test case 2
        String sentence2 = "leetcode";
        System.out.println("Input: " + sentence2);
        System.out.println("Output: " + checkIfPangram(sentence2)); // Expected output: false
        System.out.println();
    }
}