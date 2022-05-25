package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        Character[][] firstMatrix = readMatrix(rows, cols, scanner);
        Character[][] secondMatrix = readMatrix(rows, cols, scanner);
        Character[][] resultMatrix = new Character[rows][cols];

        for (int row = 0; row <firstMatrix.length ; row++) {
            for (int column = 0; column < firstMatrix[row].length ; column++) {
                if(firstMatrix[row][column] == secondMatrix[row][column]) {
                    resultMatrix[row][column] = firstMatrix[row][column];
                } else {
                    resultMatrix[row][column] = '*';
                }
            }
        }
        printMatrix(resultMatrix);
    }

    private static void printMatrix(Character[][] resultMatrix) {
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j <resultMatrix[i].length ; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static Character[][] readMatrix(int rows, int cols, Scanner scanner) {
        Character[][] matrix = new Character[rows][cols];
        for (int row = 0; row <rows ; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }
        return matrix;
    }
}
