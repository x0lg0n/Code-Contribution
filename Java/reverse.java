
import java.util.*;

public class reverse {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); //for inputing the number of rows.
        int m = in.nextInt(); //for inputing the number of columns.

        int[][] A = new int[n][m];

        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j  < m; j++){
                A[i][j] = in.nextInt();
            }
        }
        Reverse(A); //calling the function for reversing each row of the given matrix.
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        in.close();//closing the scanner object to avoid memory leakage in the program.
    }
        public static int[][] Reverse(int[][] image)
        {
        
        for (int i = 0 ; i < image.length ; i++) {
        int s = 0; //s refers to the startindex of each row of the matrix.
        int e = image[0].length -1;//e refers to the endindex of each row of the matrix.
        while(s < e) { // applying the algorithm for reversing rows.
            int temp = image[i][s]; //the temp variable has been declared to help in the swapping process.
            image[i][s] = image[i][e];
            image[i][e] =temp;
            s++; // incrementing value of s and decrementing value of e otherwise of which the program will show an error.
            e--;
        }
        }
        return image;
    }
    

}
