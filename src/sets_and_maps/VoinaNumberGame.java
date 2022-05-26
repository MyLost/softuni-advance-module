package sets_and_maps;

import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
//        Set<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

//        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
//        Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt).forEach(firstPlayerCards::add);

        LinkedHashSet<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayerDeck = new LinkedHashSet<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(secondPlayerDeck::add);
        int firstPlayerCard;
        int secondPlayerCard;
        boolean havePlayerCards = true;

        for (int i = 0; i < 50; i++) {
            if(!firstPlayerDeck.isEmpty()) {
                Iterator<Integer>firstPlayerIterator = firstPlayerDeck.iterator();
                firstPlayerCard = firstPlayerIterator.next();
                firstPlayerIterator.remove();
            } else {
                System.out.println("Second player win!");
                havePlayerCards = false;
                break;
            }
            if(!secondPlayerDeck.isEmpty()) {
                Iterator<Integer>secondPlayerIterator = secondPlayerDeck.iterator();
                secondPlayerCard = secondPlayerIterator.next();
                secondPlayerIterator.remove();
            } else {
                System.out.println("First player win!");
                havePlayerCards = false;
                break;
            }
            if(firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if (firstPlayerCard < secondPlayerCard) {
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);

            }
        }
        if(havePlayerCards) {
            if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
                System.out.println("First player win!");
            } else if (firstPlayerDeck.size() < secondPlayerDeck.size()) {
                System.out.println("Second player win!");
            }
        }
    }
}
