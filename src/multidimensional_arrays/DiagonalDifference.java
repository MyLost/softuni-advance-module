package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n ; i++) {
            int[] values = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = values;
        }
        int rightDiagonalSum=0;
        int leftDiagonalSum=0;
        for (int i = 0; i < n ; i++) {
            rightDiagonalSum += matrix[i][i];
        }
        for (int i = 0; i < n ; i++) {
            leftDiagonalSum += matrix[i][n-1-i];
        }
        System.out.println(Math.abs(rightDiagonalSum - leftDiagonalSum));
    }
}
