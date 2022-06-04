package multidimensional_arrays;

import java.util.*;
import java.util.stream.Collectors;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputToken = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(inputToken[0]);
        int columns = Integer.parseInt(inputToken[1]);
//        Map<Integer, String> alfabet = new HashMap<>();
//        alfabet.put(1, "a");
//        alfabet.put(2, "b");
//        alfabet.put(3, "c");
//        alfabet.put(4, "d");
//        alfabet.put(5, "e");
//        alfabet.put(6, "f");
//        alfabet.put(7, "g");
//        alfabet.put(8, "h");
//        alfabet.put(9, "i");
//        alfabet.put(10, "j");
//        alfabet.put(11, "k");
//        alfabet.put(12, "l");
//        alfabet.put(13, "m");
//        alfabet.put(14, "n");
//        alfabet.put(15, "o");
//        alfabet.put(16, "p");
//        alfabet.put(17, "r");
//        alfabet.put(18, "s");
//        alfabet.put(19, "t");
//        alfabet.put(20, "u");
//        alfabet.put(21, "v");
//        alfabet.put(22, "w");
//        alfabet.put(23, "x");
//        alfabet.put(24, "w");
//        alfabet.put(25, "z");
        String[][] matrix = new String[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = new StringBuilder().append(String.valueOf((char) ('a' + row))).append(String.valueOf((char) ('a' + row + col))).append(String.valueOf((char) ('a' + row))).toString();
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
