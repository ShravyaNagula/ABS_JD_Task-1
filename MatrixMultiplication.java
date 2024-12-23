import java.util.Scanner;

public class MatrixMultiplication {

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        // Matrix multiplication is only possible if columns of A equals rows of B
        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix multiplication is not possible. " +
                    "Number of columns in Matrix A must be equal to number of rows in Matrix B.");
        }

        // Resultant matrix will have dimensions (rowsA x colsB)
        int[][] resultMatrix = new int[rowsA][colsB];

        // Multiply matrices
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                resultMatrix[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return resultMatrix;
    }

    // Method to display a matrix in a user-friendly format
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for the first matrix (Matrix A)
        System.out.println("Enter the number of rows for Matrix A:");
        int rowsA = scanner.nextInt();
        System.out.println("Enter the number of columns for Matrix A:");
        int colsA = scanner.nextInt();

        int[][] matrixA = new int[rowsA][colsA];
        System.out.println("Enter the elements of Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        // User input for the second matrix (Matrix B)
        System.out.println("Enter the number of rows for Matrix B:");
        int rowsB = scanner.nextInt();
        System.out.println("Enter the number of columns for Matrix B:");
        int colsB = scanner.nextInt();

        int[][] matrixB = new int[rowsB][colsB];
        System.out.println("Enter the elements of Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Attempt to multiply the matrices and handle exceptions if any
        try {
            int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);

            System.out.println("\nThe result of multiplying Matrix A and Matrix B is:");
            printMatrix(resultMatrix); // Display the resulting matrix
        } catch (IllegalArgumentException e) {
            // Display an error message if the matrices can't be multiplied
            System.out.println(e.getMessage());
        } finally {
            scanner.close(); // Always close the scanner after use
        }
    }
}