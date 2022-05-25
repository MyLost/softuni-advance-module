package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        int matrixElementSum=0;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixElementSum += matrix[i][j];
            }
        }
        System.out.println(matrixElementSum);
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
