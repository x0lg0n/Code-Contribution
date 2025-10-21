public class rotate180d{
    static void rotateMatrix(int[][] mat){
        int n=mat.length;
        int [][] res= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[i][j]=mat[n-i-1][n-j-1];
            }
        }
        for(int i = 0; i < n; i++){
            System.arraycopy(res[i], 0, mat[i], 0, n);
        }
    }
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        rotateMatrix(mat);

        // Print the rotated matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }


}
