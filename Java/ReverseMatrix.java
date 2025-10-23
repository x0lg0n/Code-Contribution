
import java.util.*;

public class ReverseMatrix {

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
        reverse(A); //calling the function for reversing each row of the given matrix.
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        in.close();//closing the scanner object to avoid memory leakage in the program.
    }
        public static int[][] reverse(int[][] matrix)
        {
        
        for (int i = 0 ; i < matrix.length ; i++) {
            int startIndex = 0; //startIndex refers to the startindex of each row of the matrix.
            int endIndex = matrix[i].length - 1; //endIndex refers to the endindex of each row of the matrix.
            while(startIndex < endIndex) { // applying the algorithm for reversing rows.
                int temp = matrix[i][startIndex]; //the temp variable has been declared to help in the swapping process.
                matrix[i][startIndex] = matrix[i][endIndex];
                matrix[i][endIndex] = temp;
                startIndex++; // incrementing value of startIndex and decrementing value of endIndex otherwise of which the program will go in an infinite loop.
                endIndex--;
            }
        }
        return matrix;
    }
    

}
