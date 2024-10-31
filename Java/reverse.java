
import java.util.*;

public class reverse {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] A = new int[n][m];

        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j  < m; j++){
                A[i][j] = in.nextInt();
            }
        }
        Reverse(A);
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        in.close();
    }
        public static int[][] Reverse(int[][] image)
        {
        
        for (int i = 0 ; i < image.length ; i++) {
        int s = 0;
        int e = image[0].length -1;
        while(s < e) {
            int temp = image[i][s];
            image[i][s] = image[i][e];
            image[i][e] =temp;
            s++;
            e--;
        }
        }
        return image;
    }
    

}
