public class Rotate90 {
    public void solve(int[][] A) {
        int temp = 0;
        for(int i = 0; i<A.length; i++){
            for(int j = i+1; j<A.length; j++){
                
                    temp = A[i][j];
                     A[i][j] = A[j][i];
                     A[j][i] = temp;
                
            }
        }
    
    
        for (int i = 0; i < A.length; i++) {
            int start = 0;
            int end = A.length - 1;
      
            while (start < end) {
                temp = A[i][start];
                A[i][start] = A[i][end];
                A[i][end] = temp;
                
                start++;
                end--;
            }
        }
    }
}
