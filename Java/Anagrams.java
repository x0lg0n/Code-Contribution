/**
 * Program Title: Add a Java solution for checking if two words are anagrams
 * Author: [hirushi1999]
 * Date: 2025-10-20
 */

public class Anagrams {
    static boolean isAnagram(String a, String b) {
        boolean ctt = true;
        String c = a.toLowerCase();
        String d = b.toLowerCase();

        if(a.length() != b.length()){
            return false;
        }
        char[] chars1 = c.toCharArray();
        char[] chars2 = d.toCharArray();

        for(int i=0; i< chars1.length-1; i++){
            for(int j=0; j<chars1.length-i-1; j++){
                if(chars1[j] > chars1[j+ 1]){
                    char temp = chars1[j];
                    chars1[j] = chars1[j + 1];
                    chars1[j + 1] = temp;
                }
            }
        }

        for(int i=0; i< chars2.length-1; i++){
            for(int j=0; j<chars2.length-i-1; j++){
                if(chars2[j] > chars2[j+ 1]){
                    char temp = chars2[j];
                    chars2[j] = chars2[j + 1];
                    chars2[j + 1] = temp;
                }
            }
        }
        String cb = new String(chars1);
        String cb2 = new String(chars2);

        if(!cb.equals(cb2)){
            return false;
        } else{
            return true;
        }
    }

    public static void main(String[] args) {

        String a = "listen";
        String b = "silent";
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
