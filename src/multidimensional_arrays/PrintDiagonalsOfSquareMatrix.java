package multidimensional_arrays;
import java.util.Arrays;
import java.util.Scanner;
public class PrintDiagonalsOfSquareMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size ; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j];
            }
        }
        //right diagonal
        for (int i = 0; i < size ; i++) {
                System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        //left diagonal
        for (int i = size-1, j=0; i >= 0 && j < size ; i--, j++) {
            System.out.print(matrix[j][i] + " ");
        }
    }
}

