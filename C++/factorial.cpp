#include <iostream>
using namespace std;

// Function to calculate factorial
long long factorial(int n) {
    if (n == 0) return 1; // 0! = 1
    long long fact = 1;
    for (int i = 1; i <= n; i++) {
        fact *= i;
    }
    return fact;
}

int main() {
    int num;
    cout << "Enter a non-negative integer ";
    cin >> num;

    if (num < 0) {
        cout << "Please enter a num>0" << endl;
    } else {
        cout << "Factorial of " << num << " = " << factorial(num) << endl;
    }

    return 0;
}
