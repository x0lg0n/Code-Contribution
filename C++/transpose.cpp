#include <iostream>
using namespace std;

int main() {
    int rows, cols;
    cout << "Enter the number of rows and columns: ";
    cin >> rows >> cols;

    int matrix[rows][cols], transpose[cols][rows];

    // Input matrix elements
    cout << "Enter matrix elements:\n";
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            cin >> matrix[i][j];
        }
    }

    // Compute transpose
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            transpose[j][i] = matrix[i][j];
        }
    }

    // Display transpose
    cout << "\nTranspose of the matrix:\n";
    for(int i = 0; i < cols; i++) {
        for(int j = 0; j < rows; j++) {
            cout << transpose[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}
