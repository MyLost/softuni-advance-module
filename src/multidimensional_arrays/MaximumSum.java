package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int startRowIndex = 0;
        int startColIndex = 0;
        int sum = Integer.MIN_VALUE;

        for (int row = 0; row <= matrix.length-2; row++) {
            for (int col = 0; col <= matrix[row].length-2; col++) {
                int currentSum = matrix[row][col] +  matrix[row][col+1] + matrix[row+1][col] + matrix[row+1][col+1];
                if(currentSum > sum) {
                    sum = currentSum;
                    startRowIndex = row;
                    startColIndex = col;
                }
            }
        }
        printMatrix(startRowIndex, startColIndex, matrix);
        System.out.println(sum);
    }

    private static void printMatrix(int startRowIndex, int startColIndex, int[][] matrix) {
        for (int i = startRowIndex; i < startRowIndex+2; i++) {
            for (int j = startColIndex; j < startColIndex+2 ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows ; row++) {
            int [] inputTokens = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int column = 0; column < cols; column++) {
                matrix[row][column] = inputTokens[column];
            }
        }
        return matrix;
    }
}
