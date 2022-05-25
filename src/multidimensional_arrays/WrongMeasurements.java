package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixRows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            int[] readValues = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = readValues;
        }
        int[][] staticMatrix = new int[matrix.length][matrix[0].length];
        int[] wrongCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int wrongNumber = matrix[wrongCoordinates[0]][wrongCoordinates[1]];

        //static matrix
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                staticMatrix[i][j] = matrix[i][j];

            }
        }

        //int this matrix replace all wrong numbers with 0 after that calculate sums and replace 0 with corresponding sum
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                if(matrix[i][j] == wrongNumber) {
                    matrix[i][j] = 0;
                }
            }
        }
        int[][] updatedMatrix = updateMatrix(matrix, staticMatrix, wrongNumber);
        printMatrix(updatedMatrix);
    }

    private static void printMatrix(int[][] updatedMatrix) {
        for (int i = 0; i <updatedMatrix.length ; i++) {
            for (int j = 0; j <updatedMatrix[i].length ; j++) {
                System.out.print(updatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] updateMatrix(int[][] matrix, int[][] staticMatrix, int wrongNumber) {
        int sum;
        for (int i = 0; i < staticMatrix.length; i++) {
            for (int j = 0; j <staticMatrix[i].length ; j++) {
                sum=0;
                if(staticMatrix[i][j] == wrongNumber) {
                    //check matrix for upper limit
                    if(i > 0) {
                       if( staticMatrix[i-1][j] != wrongNumber) {
                           sum += staticMatrix[i-1][j];
                       }
                    }
                    //check matrix for lower limit
                    if(i < staticMatrix.length-1) {
                        if(staticMatrix[i+1][j] != wrongNumber) {
                            sum += staticMatrix[i+1][j];
                        }
                    }
                    //check matrix for left limit
                    if(j > 0) {
                        if(staticMatrix[i][j-1] != wrongNumber) {
                            sum += staticMatrix[i][j-1];
                        }
                     }
                    //check matrix for right limit
                    if(j < staticMatrix[i].length-1) {
                        if(staticMatrix[i][j+1] != wrongNumber) {
                            sum += staticMatrix[i][j+1];
                        }
                    }
                    matrix[i][j] = sum;
                }
            }
        }
        //return matrix with updated values
        return matrix;
    }
}
