package exam_preparation.matrices;

import java.util.*;

public class PresentDelivery {

        private static   int santaRow = 0;
        private static  int santaCol = 0;

        private static char[][] matrix;

        private static int presents = 0;

        private static int niceKindsnumber = 0;

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialValueOfPresents = 0;
        presents = Integer.parseInt(scanner.nextLine());
        initialValueOfPresents = presents;

        int matrixSize = Integer.parseInt(scanner.nextLine());

        matrix = new char[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            String[] inputTokens = scanner.nextLine().split("\\s+");
            for (int j = 0; j < inputTokens.length; j++) {
                matrix[i][j] = inputTokens[j].charAt(0);
                if(inputTokens[j].equals("S")) {
                    santaRow = i;
                    santaCol = j;
                } else if(inputTokens[j].equals("V")) {
                    niceKindsnumber++;
                }
            }
        }

        String command = scanner.nextLine();

        boolean santaIsOutOfNeighborhood = false;
        while(!command.equals("Christmas morning") && presents > 0 && !santaIsOutOfNeighborhood) {

            switch (command) {
                case "up":
                    if(santaRow != 0 ) {
                        moveSanta(-1, 0);
                    } else {
                        santaIsOutOfNeighborhood = true;
                        System.out.println("Santa ran out of presents!");
                    }
                    break;
                case "down":
                    if(santaRow != matrixSize -1) {
                        moveSanta(1, 0);
                    } else {
                        santaIsOutOfNeighborhood = true;
                        System.out.println("Santa ran out of presents!");
                    }
                    break;
                case "left":
                    if(santaCol != 0) {
                        moveSanta(0, -1);
                    } else {
                        santaIsOutOfNeighborhood = true;
                        System.out.println("Santa ran out of presents!");
                    }
                    break;
                case "right":
                    if(santaCol != matrixSize -1 ) {
                        moveSanta(0, 1);
                    } else {
                        santaIsOutOfNeighborhood = true;
                        System.out.println("Santa ran out of presents!");
                    }
                    break;
            }
            if(presents > 0 && !santaIsOutOfNeighborhood) {
                command = scanner.nextLine();
            }
        }
        if(presents < 1) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix();
        if((niceKindsnumber - (initialValueOfPresents - presents) == 0 )) {
            System.out.println(String.format("Good job, Santa! %d happy nice kid/s.", niceKindsnumber));
        } else {
            System.out.println(String.format("No presents for %d nice kid/s.", (niceKindsnumber - (initialValueOfPresents - presents))));
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void moveSanta(int rowMutator, int colMutator) {
            int nextSantaRow = santaRow + rowMutator;
            int nextSantaCol = santaCol + colMutator;
            if(matrix[nextSantaRow][nextSantaCol] == 'X') {
                // found naughty kid on this coordinates
            } else if(matrix[nextSantaRow][nextSantaCol] == 'V') {
                // found nice kid on this coordinates
                presents--;
            } else if ((matrix[nextSantaRow][nextSantaCol] == 'C')) {
                //check all sades of santa for kid if found give them present
                if(matrix[nextSantaRow - 1][nextSantaCol] == 'X' || matrix[nextSantaRow - 1][nextSantaCol] == 'V') {
                    //fount kid up from santa
                    presents--;
                    if(matrix[nextSantaRow - 1][nextSantaCol] == 'X') {
                        niceKindsnumber++;
                    }
                    matrix[nextSantaRow - 1][nextSantaCol] = '-';
                }
                if(matrix[nextSantaRow + 1][nextSantaCol] == 'X' || matrix[nextSantaRow + 1][nextSantaCol] == 'V') {
                    //fount kid down from santa
                    presents--;
                    if(matrix[nextSantaRow + 1][nextSantaCol] == 'X') {
                        niceKindsnumber++;
                    }
                    matrix[nextSantaRow + 1][nextSantaCol] = '-';
                }
                if(matrix[nextSantaRow][nextSantaCol-1 ] == 'X' || matrix[nextSantaRow][nextSantaCol - 1] == 'V') {
                    //fount kid left from santa
                    presents--;
                    if(matrix[nextSantaRow][nextSantaCol-1 ] == 'X') {
                        niceKindsnumber++;
                    }
                    matrix[nextSantaRow][nextSantaCol-1] = '-';
                }
                if(matrix[nextSantaRow][nextSantaCol + 1] == 'X' || matrix[nextSantaRow][nextSantaCol + 1] == 'V') {
                    //fount kid right from santa
                    presents--;
                    if(matrix[nextSantaRow][nextSantaCol + 1] == 'X') {
                        niceKindsnumber++;
                    }
                    matrix[nextSantaRow][nextSantaCol+1] = '-';
                }
            }
            matrix[nextSantaRow][nextSantaCol] = 'S';
            matrix[santaRow][santaCol] = '-';
            santaRow = nextSantaRow;
            santaCol = nextSantaCol;
    }
}
