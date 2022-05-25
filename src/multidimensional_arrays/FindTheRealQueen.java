package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character[][] matrix = new Character[8][8];
        for (int i = 0; i < 8; i++) {
            String[] values = (scanner.nextLine().split("\\s+"));
            for (int j = 0; j < values.length; j++) {
                matrix[i][j] = values[j].charAt(0);
            }
        }
        boolean isRealQueen = false;
        int queenXCoordinate = 0;
        int queenYCoordinate = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'q') {
                    isRealQueen = foundRealQueen(i, j, matrix);
                    if(isRealQueen) {
                        queenXCoordinate = i;
                        queenYCoordinate = j;
                    }
                }
            }
        }
        System.out.print(queenXCoordinate + " " + queenYCoordinate);
    }

    public static boolean foundRealQueen (int row, int col, Character[][] matrix) {

        // check for queen up
        for (int i = row-1; i >= 0 ; i--) {
            if(matrix[i][col] == 'q') {
                return false;
            }
        }
        // check for queen down
        for (int i = row+1; i < matrix.length ; i++) {
            if(matrix[i][col] == 'q') {
                return false;
            }
        }
        // check for queen left
        for (int i = col-1; i >=0 ; i--) {
            if(matrix[row][i] == 'q') {
                return false;
            }
        }
        // check for queen right
        for (int i = col+1; i < matrix[0].length ; i++) {
            if(matrix[row][i] == 'q') {
                return false;
            }
        }

        //check for left up diagonal
        for (int i = 1; i > matrix.length ; i++) {
            if(col-i >=0 && row-i >=0) {
                if (matrix[row - i][col - i] == 'q') {
                    return false;
                }
            }
        }

        //check for queen right down diagonal
        for (int i = 1; i <= matrix.length ; i++) {
            if(col+i < matrix[0].length && row+i < matrix.length) {
                if (matrix[row + i][col + i] == 'q') {
                    return false;
                }
            }
        }

        //check for left down diagonal
        for (int i = 1; i < col ; i++) {
            if(row+i < matrix.length && col-1 >= 0) {
                if (matrix[row + i][col - i] == 'q') {
                    return false;
                }
            }
        }

        //check for queen right up diagonal
        for (int i = 1; i < col; i++) {
            if(col+i < matrix[0].length && row-i >=0) {
                if (matrix[row - i][col + i] == 'q') {
                    return false;
                }
            }
        }
        return true;
    }
}
