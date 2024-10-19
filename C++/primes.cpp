//This program calculates prime numbers in a range between two numbers using C++

#include <iostream>
using namespace std ;
int main() {
   int a,b ;
   cin >> a ; 
   cin >> b ;

   for (int i = a;i<=b;i++) {
    int c = 0 ;
    for (int j = 1; j<=i;j++) {
        if (i%j == 0) {
            c += 1 ;
        }
    }
    if (c==2) {
        cout << i << " ";
    }
   }
   return 0 ;
}
