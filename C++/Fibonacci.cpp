#include <iostream>
#include <limits>
#include <vector>
using namespace std;
int main() {
    int n;

    while (true) {
        cout << "Enter a non-negative integer (0-20) to compute Fibonacci sequence: ";
        if (!(cin >> n)) {
            cout << "Invalid input. Please enter an integer." << endl;
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            continue;
        }
        if (n < 0) {
            cout << "Negative number entered. Please enter a non-negative integer." << endl;
            continue;
        }
        if (n > 20) {
            cout << "Warning: Fibonacci number for " << n 
                 << " may overflow unsigned long long. Please enter a value <= 20:" << endl;
            continue;
        }
        break;
    }

    vector<unsigned long long> fib(n);

    if (n > 0) fib[0] = 0;
    if (n > 1) fib[1] = 1;

    for (int i = 2; i < n; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }

    cout << "Fibonacci sequence up to " << n << " terms:" << endl;
    for (int i = 0; i < n; i++) {
        cout << fib[i] << " ";
    }
    cout << endl;

    return 0;
}