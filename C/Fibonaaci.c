#include <stdio.h>
void main(){
    int n,a=0,b=1,c,i;
    printf("Enter a number");
    scanf("%d",&n);
    for(i=1;i<=n;i++)
    {
        c=a+b;
        printf("%d,",a);
        a=b;
        b=c;
     }
}
