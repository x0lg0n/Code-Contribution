#include <iostream>
#include <limits>
#include <vector>
using namespace std;

vector<long long> fibonacci(int n) {
    vector<long long> fib(n);
    if (n >= 1) fib[0] = 0;
    if (n >= 2) fib[1] = 1;
    for (int i = 2; i < n; ++i)
        fib[i] = fib[i - 1] + fib[i - 2];
    return fib;
}

// Input validation function
int getValidatedInput(const string &prompt, int minValue) {
    int num;
    cout << prompt;
    while (!(cin >> num) || num < minValue) {
        cin.clear(); 
        cin.ignore(numeric_limits<streamsize>::max(), '\n'); 
        cout << "Invalid input! " << prompt;
    }
    return num;
}

int main() {
    int n = getValidatedInput("Enter the number of Fibonacci terms: ", 1);
    vector<long long> fib = fibonacci(n);
    cout << "Fibonacci sequence: ";
    for (auto val : fib)
        cout << val << " ";
    cout << endl;
    return 0;
}