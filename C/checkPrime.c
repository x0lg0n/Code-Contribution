#include <stdio.h>
int isPrime(int n){
    for (int i = 2; i*i <=n; i++){
        if (n%i==0){
          return 0;//not prime 
        }
        
    }
    return 1;//prime
    
}
int main(){
    printf("Prime numbers from 1 to 100 are:\n");
    for(int i=2;i<100;i++){
        if(isPrime(i)){
            printf("%d ",i);
        }
    }
}