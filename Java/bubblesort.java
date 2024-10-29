import java.util.*;
public class bubblesort {
    static int[] bubblesorting(int[] A){
        int j=0;
        int n=A.length;
        while(n>=1){
        for(int i=0;i<A.length-1-j;i++){
            if(A[i]>A[i+1]){
                int temp=A[i+1];
                A[i+1]=A[i];
                A[i]=temp;
            }
        }
        j++;
        n--;   
    }
        return A;
    }
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int []Arr=new int[size];
        for(int i=0;i<size;i++){
            Arr[i]=sc.nextInt();
        }
        Arr=bubblesorting(Arr);
        for(int i=0;i<size;i++){
            System.out.print(Arr[i]+" ");
        }
        sc.close();
    }
}
