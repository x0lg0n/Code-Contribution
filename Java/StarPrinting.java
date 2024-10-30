import java.util.*;
public class star {
    public static void main(String[] args) {
        Scanner scn =  new Scanner (System.in);
        int N = scn.nextInt();

        //upperstar
        for(int i = 1 ; i<=N ; i++){
            for(int j = 1; j<=2*N-i ; j++){
                System.out.print(" ");
            }
            for(int k = 0 ; k<2*i-1 ; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        //upper2
        for(int i = 0 ; i < N ; i++){
            for(int a = 0 ; a<i ; a++){
                System.out.print(" ");
            }
            for(int b = 1 ; b<4*N-2*i; b++){
                System.out.print("*");
            }
            System.out.println();
        }

        //upper3
        for(int i = 1 ; i <= N ; i++){
            for(int a = 0 ; a<N-i ; a++){
                System.out.print(" ");
            }
            for(int b = 1 ; b<2*N+2*i; b++){
                System.out.print("*");
            }
            System.out.println();
        }

        //bottom
        for(int i = 0 ; i< N ; i++){
            for(int j = 1 ; j<=N+i ; j++){
                System.out.print(" ");
            }
            for(int k = 1; k<2*(N-i); k++){
                System.out.print("*");
            }
            System.out.println();
        }
        scn.close();
    }
    
}
