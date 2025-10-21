import java.util.Arrays;

/**
 * Program Title: Add a Java solution for checking if two words are anagrams
 * Author: [hirushi1999]
 * Date: 2025-10-20
 */

public class Anagrams {
    static boolean isAnagram(String a, String b) {
        String c = a.toLowerCase();
        String d = b.toLowerCase();

        if(a.length() != b.length()){
            return false;
        }
        char[] chars1 = c.toCharArray();
        char[] chars2 = d.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        String cb = new String(chars1);
        String cb2 = new String(chars2);

        return cb.equals(cb2);
    }

    public static void main(String[] args) {

        String a = "listen";
        String b = "silent";
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
