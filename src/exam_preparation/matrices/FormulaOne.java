package exam_preparation.matrices;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());
        char matrix[][] = new char[n][n];
        int playerRow = -1;
        int playerCol = -1;
        boolean playerReachedTheFinish =false;
        for (int i = 0; i < n; i++) {
            char[] matrixTokens = scanner.nextLine().toCharArray();
            matrix[i] = matrixTokens;
            for (int j = 0; j < matrixTokens.length; j++) {
                if (matrixTokens[j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        for (int i = 0; i < commandsCount; i++) {
            if(isCarOnTheTrack(playerRow, playerCol, n)) {
                matrix[playerRow][playerCol] = '.';
            }
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }
            if(isCarOnTheTrack(playerRow, playerCol, n)) {
                if (matrix[playerRow][playerCol] == 'B') {
                    if (command.equals("up")) {
                        playerRow--;
                    } else {
                        if (command.equals("down")) {
                            playerRow++;
                        } else {
                            if (command.equals("left")) {
                                playerCol--;
                            } else {
                                playerCol++;
                            }
                        }
                    }
                }
                if(isCarOnTheTrack(playerRow, playerCol, n)) {
                    if (matrix[playerRow][playerCol] == 'T') {
                        if (command.equals("up")) {
                            playerRow++;
                        } else {
                            if (command.equals("down")) {
                                playerRow--;
                            } else {
                                if (command.equals("left")) {
                                    playerCol++;
                                } else {
                                    playerCol--;
                                }
                            }
                        }
                    }
                } else {
                    if(playerRow < 0 ) {
                        playerRow = matrix.length-1;
                    } else if (playerRow > matrix.length-1) {
                        playerRow = 0;
                    } else if(playerCol < 0) {
                        playerCol = matrix.length-1;
                    } else {
                        playerCol = 0;
                    }
                    matrix[playerRow][playerCol] = 'P';
                }
                if(isCarOnTheTrack(playerRow, playerCol, n)) {
                    if (matrix[playerRow][playerCol] == 'F') {
                        matrix[playerRow][playerCol] = 'P';
                        playerReachedTheFinish = true;
                        break;
                    }
                    matrix[playerRow][playerCol] = 'P';
                }
            } else {
                //return car on the track
                if(playerRow < 0 ) {
                    playerRow = matrix.length-1;
                } else if (playerRow > matrix.length-1) {
                    playerRow = 0;
                } else if(playerCol < 0) {
                    playerCol = matrix.length-1;
                } else {
                    playerCol = 0;
                }
                matrix[playerRow][playerCol] = 'P';
            }
        }
        if(playerReachedTheFinish) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
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

    private static boolean isCarOnTheTrack(int playerRow, int playerCol, int trackSize) {
        return playerRow >= 0 && playerRow < trackSize && playerCol >= 0 && playerCol < trackSize;
    }
}
