/*
 * Program: Multiplication of Two Matrices (Any Size)
 * Author: RoaaAlsham
 * ---------------------------------------------------
 * This program allows the user to input two matrices (of compatible sizes)
 * and multiplies them according to the standard matrix multiplication rule
 * 
 * Example:
 *   Enter rows and columns for Matrix 1: 3 3
 *   Enter rows and columns for Matrix 2: 3 3
 *   Enter matrix1 elements: 1 2 3 4 5 6 7 8 9
 *   Enter matrix2 elements: 0 2 4 1 4.5 2.2 1.1 4.3 5.2
 *
 * Output:
 *   The multiplication of the matrices is:
 *
 *    1.0  2.0  3.0      0.0  2.0  4.0      5.3 23.9 24.0
 *    4.0  5.0  6.0   *  1.0  4.5  2.2   = 11.6 56.3 58.2
 *    7.0  8.0  9.0      1.1  4.3  5.2     17.9 88.7 92.4
 */

import java.util.Scanner;
public class AlgebraMultiplyMatrices {

    public static void main(String[] args) {
         try (Scanner scan = new Scanner(System.in)) {

            System.out.print("Enter rows and columns for Matrix 1 (e.g., 3 3): ");
            int rowsA = scan.nextInt();
            int colsA = scan.nextInt();

            System.out.print("Enter rows and columns for Matrix 2 (e.g., 3 3): ");
            int rowsB = scan.nextInt();
            int colsB = scan.nextInt();

            if (colsA != rowsB) {
                System.out.println(" Matrices cannot be multiplied. Columns of Matrix 1 must equal rows of Matrix 2.");
                return;
            }

            double[][] matrix1 = new double[rowsA][colsA];
            double[][] matrix2 = new double[rowsB][colsB];

            System.out.println("\nEnter Matrix 1 elements:");
            readMatrix(scan, matrix1);

            System.out.println("Enter Matrix 2 elements:");
            readMatrix(scan, matrix2);

            double[][] result = multiplyMatrix(matrix1, matrix2);

            System.out.println("\n The multiplication of the matrices is:\n");
            displayMatrices(matrix1, matrix2, result);

        } catch (Exception e) {
            System.out.println("Invalid input caused the following exception:\n" + e.getMessage());
        }
    }

    static double[][] readMatrix(Scanner scan, double[][] matrice) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                matrice[i][j] = scan.nextDouble();
            }
        }
        return matrice;
    }
    
      /**
     * Multiplies two matrices (a × b) and returns the resulting matrix.
     */
    static double[][] multiplyMatrix(double[][] a, double[][] b) {

        int rows = a.length;
        int columns = b[0].length;

        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int z = 0; z < b.length; z++) {
                    result[i][j] += a[i][z] * b[z][j];
                }
            }
        }
        return result;
    }
    
     /**
     * Helper to print a single row of a matrix with consistent spacing.
     */
    static void printMatrixRow(double[][] m, int row) {
        if (row < m.length) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%6.1f", m[row][j]);
            }
        } else {
            // Print blanks if this matrix has fewer rows than the others
            for (int j = 0; j < m[0].length; j++) {
                System.out.print("      ");
            }
        }
    }
     /**
     * Displays the two input matrices and the resulting matrix side by side.
     */
    static void displayMatrices(double[][] m1, double[][] m2, double[][] result) {
        int rows = Math.max(m1.length, Math.max(m2.length, result.length));
        for (int i = 0; i < rows; i++) {
            printMatrixRow(m1, i);
            System.out.print((i == m1.length / 2) ? "  *" : "   ");
            printMatrixRow(m2, i);
            System.out.print((i == m2.length / 2) ? "  =" : "   ");
            printMatrixRow(result, i);
            System.out.println();
        }
    }
}
