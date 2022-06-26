package regular_exam_2022;

import java.util.*;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] field = new char[fieldSize][fieldSize];
        int stolenMoney = 0;
        int dillingerRow = 0;
        int dillingerCol = 0;
        boolean dillingerCaught = false;
        for (int i = 0; i < fieldSize; i++) {
            String[] fieldTokens =  scanner.nextLine().split(" ");
            for (int j = 0; j < fieldTokens.length; j++) {
                field[i][j] = fieldTokens[j].charAt(0);
                if(fieldTokens[j].charAt(0) == 'D') {
                    dillingerRow = i;
                    dillingerCol = j;
                }
            }
        }


        for (int i = 0; i < commands.length ; i++) {
            String commandName = commands[i];
            switch (commandName) {
                case "up":
                    if(dillingerRow != 0) {
                        field[dillingerRow][dillingerCol] = '+';
                        dillingerRow--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    if(dillingerRow != fieldSize -1) {
                        field[dillingerRow][dillingerCol] = '+';
                        dillingerRow++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "left":
                    if(dillingerCol != 0) {
                        field[dillingerRow][dillingerCol] = '+';
                        dillingerCol--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "right":
                    if(dillingerCol != fieldSize -1) {
                        field[dillingerRow][dillingerCol] = '+';
                        dillingerCol++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }
             if(field[dillingerRow][dillingerCol] == '$') {
                 stolenMoney = stolenMoney + dillingerRow * dillingerCol;
                 System.out.println(String.format("You successfully stole %d$.", dillingerRow * dillingerCol));

             } else if (field[dillingerRow][dillingerCol] == 'P') {

                 System.out.println(String.format("You got caught with %d$, and you are going to jail.", stolenMoney));
                 field[dillingerRow][dillingerCol] = '#';
                 dillingerCaught = true;
                 break;
             }
            field[dillingerRow][dillingerCol] = 'D';
        }

        if(!dillingerCaught) {
            System.out.println(String.format("Your last theft has finished successfully with %d$ in your pocket.", stolenMoney));
        }

        printField(field);

    }

    private static void printField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length ; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}
