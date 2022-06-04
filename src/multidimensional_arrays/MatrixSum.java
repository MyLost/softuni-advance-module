package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputToken = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(inputToken[0]);
        int columns = Integer.parseInt(inputToken[1]);
        int[][] matrix = new int[rows][columns];
        int sumMax = Integer.MIN_VALUE;
        int xStartIndex = 0;
        int yStartIndex = 0;
        for (int i = 0; i < rows ; i++) {
            int[] values = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = values;
        }

        for (int i = 0; i < rows -2 ; i++) {
            for (int j = 0; j < columns -2; j++) {
                int currentSum = matrix[i][j] + matrix[i+1][j] + matrix[i+2][j] +
                                matrix[i][j+1] + matrix[i+1][j+1] + matrix[i+2][j+1] +
                                matrix[i][j+2] + matrix[i+1][j+2] + matrix[i+2][j+2];
                if(currentSum > sumMax) {
                    xStartIndex = i;
                    yStartIndex = j;
                  sumMax = currentSum;
                }
            }
        }
        System.out.println("Sum = " + sumMax);
        for (int i = xStartIndex; i < xStartIndex + 3; i++) {
            for (int j = yStartIndex; j < yStartIndex + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
