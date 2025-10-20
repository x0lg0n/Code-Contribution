#include <iostream>
#include <limits>
using namespace std;

long long factorial(int num) {
    long long fact = 1;
    for (int i = 1; i <= num; ++i)
        fact *= i;
    return fact;
}

// Input validation function
int getValidatedInput(const string &prompt, int minValue) {
    int num;
    cout << prompt;
    while (!(cin >> num) || num < minValue) {
        cin.clear(); // clear error flag
        cin.ignore(numeric_limits<streamsize>::max(), '\n'); // discard invalid input
        cout << "Invalid input! " << prompt;
    }
    return num;
}

int main() {
    int num = getValidatedInput("Enter a non-negative integer: ", 0);
    cout << "Factorial of " << num << " is " << factorial(num) << endl;
    return 0;
}