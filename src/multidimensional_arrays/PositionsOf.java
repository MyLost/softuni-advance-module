package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int numberForSearch = Integer.parseInt(scanner.nextLine());
        boolean isNumberForSearchFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                if(matrix[row][col] == numberForSearch) {
                    isNumberForSearchFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if(!isNumberForSearchFound) {
            System.out.println("not found");
        }
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
