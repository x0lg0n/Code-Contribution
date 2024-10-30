import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner ok = new Scanner(System.in);
        int N = ok.nextInt();
        ok.close();
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                System.out.print("   ");
            }
            for (int j=N-1; j>i; j--){
                System.out.print("   ");
            }
            for (int j=0; j<=i; j++){
                System.out.print(" * ");
            }
            for (int j=0; j<i; j++){
                System.out.print(" * ");
            }
            for (int j=N-1; j>i; j--){
                System.out.print("   ");
            }
            for (int j=0; j<N; j++){
                System.out.print("   ");
            }
            System.out.println();
        }
        for (int i=0; i<N; i++){
            for (int j=0; j<i; j++){
                System.out.print("   ");
            }
            for (int j=N-1; j>=i; j--){
                System.out.print(" * ");
            }
            for (int j=0; j< (2*N) - 1; j++){
                System.out.print(" * ");
            }
            for (int j=N-1; j>=i; j--){
                System.out.print(" * ");
            }
            for (int j=0; j<i; j++){
                System.out.print("   ");
            }
            System.out.println();
        }
        for (int i=0; i<N; i++){
            for (int j=N-1; j>i; j--){
                System.out.print("   ");
            }
            for (int j=0; j<=i; j++){
                System.out.print(" * ");
            }
            for (int j=0; j< (2*N) - 1; j++){
                System.out.print(" * ");
            }
            for (int j=0; j<=i; j++){
                System.out.print(" * ");
            }
            for (int j=N-1; j>i; j--){
                System.out.print("   ");
            }
            System.out.println();
        }
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                System.out.print("   ");
            }
            for (int j=0; j<i; j++){
                System.out.print("   ");
            }
            for (int j=N-1; j>=i; j--){
                System.out.print(" * ");
            }
            for (int j=N-1; j>i; j--){
                System.out.print(" * ");
            }
            for (int j=0; j<i; j++){
                System.out.print("   ");
            }
            for (int j=0; j<N; j++){
                System.out.print("   ");
            }
            System.out.println();
        }
    }
}