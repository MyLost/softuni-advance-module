package exam_preparation.matrices;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char matrix[][] = new char[n][n];
        int officerRow = -1;
        int officerCol = -1;
        int officerSpendedCoins = 0;
        for (int i = 0; i < n; i++) {
            char[] matrixTokens = scanner.nextLine().toCharArray();
            matrix[i] = matrixTokens;
            for (int j = 0; j < matrixTokens.length; j++) {
                if(matrixTokens[j] == 'A') {
                    officerRow = i;
                    officerCol = j;
                }
            }
        }
        while(officerSpendedCoins < 65) {
            String command = scanner.nextLine();
            matrix[officerRow][officerCol] = '-';
            switch(command) {
                case "up":
                    officerRow--;
                    break;
                case "down":
                    officerRow++;
                    break;
                case "left":
                    officerCol--;
                    break;
                case "right":
                    officerCol++;
                    break;
            }
            if(!isOfficerInTheArmory(officerRow, officerCol, n)) {
              break;
            }
            if(!(officerSpendedCoins < 65)) {
                matrix[officerRow][officerCol] = 'A';
                break;
            }
            if(matrix[officerRow][officerCol] != '-' && matrix[officerRow][officerCol] != 'M') {
                officerSpendedCoins += Character.getNumericValue(matrix[officerRow][officerCol]);
                matrix[officerRow][officerCol] = 'A';
            } else if (matrix[officerRow][officerCol] == 'M') {
                matrix[officerRow][officerCol] = '-';
                //possible for error if mirrors are on the same row
                for (int i = officerRow + 1; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        if(matrix[i][j] == 'M') {
                            officerRow = i;
                            officerCol = j;
                        }
                    }
                }
            }
        }
        if(officerSpendedCoins <= 65) {
            System.out.println(String.format("I do not need more swords!"));
        } else {
            System.out.println(String.format("Very nice swords, I will come back for more!"));
        }

        System.out.println(String.format("The king paid %d gold coins.", officerSpendedCoins));
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isOfficerInTheArmory(int officerRow, int officerCol, int armorySize) {
        return officerRow >= 0 && officerRow < armorySize && officerCol >= 0 && officerCol < armorySize;
    }
}
