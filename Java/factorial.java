public class factorial {
    public static long factorial(int x){
        long fact=1;
        for(int i=0;i<x;i++){
            fact=fact*i;
        }
        return fact;
    }
    public static void main(String[] args){
        long c=factorial(10);
        System.out.print(c);
    }
}

