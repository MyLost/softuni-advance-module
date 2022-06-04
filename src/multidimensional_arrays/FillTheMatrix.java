package multidimensional_arrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputTokens = scanner.nextLine().split(", ");
        int n = Integer.parseInt(inputTokens[0]);
        String matrixType = inputTokens[1];
        int[][] matrix = new int[n][n];

        if(matrixType.equals("A")) {
            matrix = fillMatrixTypeA(n);
        }else if(matrixType.equals("B")) {
            matrix = fillMatrixTypeB(n);
        }

        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixTypeB(int n) {
        int[][] matrix = new int[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i % 2 != 0) {
                    matrix[j][i] = count--;
                } else {
                    count++;
                    matrix[j][i] = count;
                }
            }
            count = count + n;
        }
        return matrix;
    }

    private static int[][] fillMatrixTypeA(int n) {
        int[][] matrix = new int[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
                matrix[j][i] =count;
            }
        }
        return matrix;
    }

}
