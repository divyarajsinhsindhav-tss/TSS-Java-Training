package com.tss.test;

import java.util.Scanner;

public class MatrixOperation {

    public static Scanner scanner = new Scanner(System.in);
    public static int row;
    public static int col;
    public static int[][] matrix;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Create Matrix");
            System.out.println("2. Display Matrix");
            System.out.println("3. Addition");
            System.out.println("4. Multiplication");
            System.out.println("5. Check Magical Matrix");
            System.out.println("6. Check Prime Harmonic");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            while (choice != 1 && choice !=2 && choice !=3 && choice !=4 && choice !=5 && choice !=6 && choice !=7 ) {
                System.out.println("Enter valid choice from 1 to 7.");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1:
                    createMatrix();
                    break;
                case 2:
                    displayMatrix(matrix);
                    break;
                case 3:
                    addition();
                    break;
                case 4:
                    multiplication();
                    break;
                case 5:
                    boolean resultOfMagicalMatrix = checkMagicalMatrix(matrix);
                    if (resultOfMagicalMatrix) {
                        System.out.println("Given matrix is magical matrix");
                    } else {
                        System.out.println("Given matrix is not magical matrix");
                    }
                    break;
                case 6:
                    boolean resultOfPrimeHarmonic = checkPrimeHarmonic(matrix);
                    if (resultOfPrimeHarmonic) {
                        System.out.println("Given matrix is prime harmonic");
                    } else {
                        System.out.println("Given matrix is not prime harmonic");
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void createMatrix() {
        do {
            System.out.print("Enter rows (>0): ");
            row = scanner.nextInt();
        } while (row <= 0);
        do {
            System.out.print("Enter columns (>0): ");
            col = scanner.nextInt();
        } while (col <= 0);

        matrix = new int[row][col];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void displayMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix not created yet!");
            return;
        }

        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static void addition() {
        if (matrix == null) {
            createMatrix();
        }

        System.out.println("Create a matrix with dimension of " + row + "*" + col);
        int[][] secondMatrix = new int[row][col];

        System.out.println("Enter second matrix elements:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                secondMatrix[i][j] = scanner.nextInt();
            }
        }

        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix[i][j] + secondMatrix[i][j];
            }
        }

        System.out.println("Addition Result:");
        displayMatrix(result);
    }

    private static void multiplication() {
        if (matrix == null) {
            System.out.println("Matrix not created yet! Please create a matrix first.");
            createMatrix();
        };

        System.out.println("Matrix multiplication rule:");
        System.out.println("First matrix size: " + row + " x " + col);
        System.out.println("Second matrix must have " + col + " rows.");

        int secondMatrixCol;
        do {
            System.out.print("Enter columns for second matrix: ");
            secondMatrixCol = scanner.nextInt();
        } while (col <= 0);

        int secondMatrixRow = col;
        int firstMatrixRow = row;

        int[][] secondMatrix = new int[secondMatrixRow][secondMatrixCol];

        System.out.println("Enter second matrix elements:");
        for (int i = 0; i < secondMatrixRow; i++) {
            for (int j = 0; j < secondMatrixCol; j++) {
                secondMatrix[i][j] = scanner.nextInt();
            }
        }

        int[][] result = new int[firstMatrixRow][secondMatrixCol];

        for (int i = 0; i < firstMatrixRow; i++) {
            for (int j = 0; j < secondMatrixCol; j++) {
                for (int k = 0; k < secondMatrixRow; k++) {
                    result[i][j] += matrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        System.out.println("Multiplication Result:");
        displayMatrix(result);
    }

    private static boolean checkMagicalMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix not created yet! Please create a matrix first.");
            createMatrix();
        };

        boolean isMagicalMatrix = false;
        if(row != col) {
            System.out.println("For magic square, matrix must be of same row and column");
            return false;
        }

        int initialRowSum = 0;
        for (int i = 0; i < col; i++) {
            initialRowSum += matrix[0][i];
        }

        int rowSum;
        int colSum;
        for (int i = 0; i < row; i++) {
            rowSum = 0;
            colSum = 0;
            for (int j = 0; j < col; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            if (rowSum == initialRowSum && colSum == initialRowSum) {
                isMagicalMatrix = true;
            } else {
                isMagicalMatrix = false;
                return isMagicalMatrix;
            }
        }

        int diagonalSum = 0;
        for (int j = 0; j < row; j++) {
            diagonalSum += matrix[j][j];
        }
        if (diagonalSum == initialRowSum) {
            isMagicalMatrix = true;
        } else {
            isMagicalMatrix = false;
            return isMagicalMatrix;
        }

        diagonalSum = 0;
        for (int j = 0; j < row; j++) {
            diagonalSum += matrix[j][row-1-j];
        }
        if (diagonalSum == initialRowSum) {
            isMagicalMatrix = true;
        } else {
            isMagicalMatrix = false;
            return isMagicalMatrix;
        }

        return true;
    }

    private static boolean checkPrimeHarmonic(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix not created yet! Please create a matrix first.");
            createMatrix();
        };

        if (matrix[0].length < 3) {
            System.out.println("Matrix must have at least 3 columns for Prime Harmonic check.");
            return false;
        }
        int primeCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean isPrime = checkPrime(matrix, i, j);
                if (isPrime) {
                    primeCount++;
                }
            }
            if (primeCount != 3) {
                return false;
            } else {
                primeCount = 0;
            }
        }
        return true;
    }

    private static boolean checkPrime(int[][] matrix, int i, int j) {
        int number = matrix[i][j];
        if (number <= 1) {
            return false;
        }
        for (int k = 2; k <= number/2; k++) {
            if (number%k == 0) {
                return false;
            }
        }
        return true;
    }
}

