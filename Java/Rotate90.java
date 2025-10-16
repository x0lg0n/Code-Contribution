public class Rotate90 {
    public void solve(int[][] A) {
        int temp = 0;
        for(int i = 0; i<A.length; i++){
            for(int j = i+1; j<A.length; j++){
                
                    temp = A[i][j];
                     A[i][j] = A[j][i];
                     A[j][i] = temp;
                
        int temp;
        for(int i = 0; i<A.length; i++){
            for(int j = i+1; j<A.length; j++){
                     temp = A[i][j]; //the temp variable has been declared to do the swapping process
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
            int startIndex = 0; 
            int endIndex = A.length - 1;
      
            while (startIndex < endIndex) {
                temp = A[i][startIndex];
                A[i][startIndex] = A[i][endIndex];
                A[i][endIndex] = temp;
                
                startIndex++;
                endIndex--;
            }
        }
    }
}
