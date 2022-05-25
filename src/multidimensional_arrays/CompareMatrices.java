package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean result = compareTwoMatrices(firstMatrix, secondMatrix);

        if(result) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
     }

    private static boolean compareTwoMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if(firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int column = 0; column < firstMatrix[row].length; column++) {
                if(firstMatrix[row][column] != secondMatrix[row][column]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows ; row++) {
            int [] inputTokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int column = 0; column < cols; column++) {
                matrix[row][column] = inputTokens[column];
            }
        }
        return matrix;
    }
}
