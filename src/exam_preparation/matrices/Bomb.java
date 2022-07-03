package exam_preparation.matrices;

import java.util.*;
import java.util.stream.Collectors;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split("\\s+");

        char[][]  matrix = new char[matrixSize][matrixSize];

        int sapperRow = 0;
        int sapperCol = 0;
        int bombCounter = 0;

        for (int i = 0; i <matrixSize ; i++) {
           List<Character> characterList = Arrays.stream(scanner.nextLine().split("\\s+"))
                   .map(e -> e.charAt(0))
                   .collect(Collectors.toList());
            for (int j = 0; j < characterList.size(); j++) {
                char currentChar = characterList.get(j);
                if(currentChar == 'S') {
                    sapperRow = i;
                    sapperCol = j;
                } else if (currentChar == 'B') {
                    bombCounter++;
                }
                matrix[i][j] = currentChar;
            }
        }

        int bombFound =0;

        for (int i = 0; i <commands.length ; i++) {
            String commandName = commands[i];

            switch (commandName) {
                case "up":
                    if(sapperRow != 0) {
                        sapperRow--;
                    }
                    break;
                case "down":
                    if(sapperRow != matrixSize -1) {
                        sapperRow++;
                    }
                    break;
                case "left":
                    if(sapperCol != 0) {
                        sapperCol--;
                    }
                    break;
                case "right":
                    if(sapperCol != matrixSize -1) {
                        sapperCol++;
                    }
                    break;
            }
            if(matrix[sapperRow][sapperCol] == 'B') {
                matrix[sapperRow][sapperCol] = '+';
                bombFound++;
                if(bombFound == bombCounter) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[sapperRow][sapperCol] == 'e') {
                System.out.printf("END! %d bombs left on the field%n ", bombCounter - bombFound);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombCounter - bombFound,  sapperRow, sapperCol);
    }


//    void printMatrix(char[][] matrix) {
//        for (int i = 0; i < matrix.length ; i++) {
//            for (int j = 0; j < matrix[i].length ; j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
//    }
}
