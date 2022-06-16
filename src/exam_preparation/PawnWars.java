package exam_preparation;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = new String[8][8];
        Paw whitePaw = new Paw();
        Paw blackPaw = new Paw();
        for (int i = 0; i < 8 ; i++) {
            String[] inputTokens = scanner.nextLine().split("");
            for (int j = 0; j < inputTokens.length ; j++) {
                if (!inputTokens[j].equals("-")) {
                    if (inputTokens[j].equals("w")) {
                        whitePaw.setRow(i);
                        whitePaw.setColl(j);
                    } else {
                        blackPaw.setRow(i);
                        blackPaw.setColl(j);
                    }
                }
            }
            matrix[i] = inputTokens;
        }

        boolean isHit = false;

        while (whitePaw.getRow() != 0 && blackPaw.getRow() != 7 && !isHit) {
            if (whitePawHitBlack(whitePaw.getRow(), whitePaw.getColl(), blackPaw.getRow(), blackPaw.getColl())) {

                String coordinates = findCoordinates(blackPaw.getRow(), blackPaw.getColl());
                System.out.printf("Game over! White capture on %s.", coordinates);
                isHit = true;

            }
            whitePaw.setRow(whitePaw.getRow() - 1);

            if (blackPawHitWhite(blackPaw.getRow(), blackPaw.getColl(), whitePaw.getRow(), whitePaw.getColl())) {

                String coordinates = findCoordinates(whitePaw.getRow(), whitePaw.getColl());
                System.out.printf("Game over! Black capture on %s.", coordinates);
                isHit = true;

            }
            blackPaw.setRow(blackPaw.getRow() + 1);

        }

        if (!isHit) {
            System.out.print(whitePaw.getRow() == 0
                    ? "Game over! White pawn is promoted to a queen at " + findCoordinates(whitePaw.getRow(), whitePaw.getColl()) + "."
                    : "Game over! Black pawn is promoted to a queen at " + findCoordinates(blackPaw.getRow(), blackPaw.getColl()) + "."
            );
        }
    }

    private static String findCoordinates(int bRow, int bCol) {
        char[] col = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};
        StringBuilder sb = new StringBuilder();
        sb.append(col[bCol]).append(row[bRow]);
        return sb.toString();
    }

    private static boolean blackPawHitWhite(int bRow, int bCol, int wRow, int wCol) {
        if (bRow + 1 == wRow && (bCol + 1 == wCol || bCol - 1 == wCol)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean whitePawHitBlack(int wRow, int wCol, int bRow, int bCol) {
        if (wRow - 1 == bRow && (wCol + 1 == bCol || wCol - 1 == bCol)) {
            return true;
        } else {
            return false;
        }
    }

    public static class Paw {
        private int row;
        private int coll;

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColl() {
            return coll;
        }

        public void setColl(int coll) {
            this.coll = coll;
        }
    }
}
