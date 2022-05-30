package sets_and_maps.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> data = new LinkedHashMap<>();
        while(!"JOKER".equals(input)) {
            String[] inputValues = input.split(":");
            String name = inputValues[0];
            String[] cards = inputValues[1].split(", ");

            if(!data.containsKey(name)) {
                data.put(name, new LinkedHashSet<>());
            }
            Arrays.stream(cards).forEach(card -> {
                data.get(name).add(card.trim());
            });
            input = scanner.nextLine();
        }
        for (var entry : data.entrySet()) {
            System.out.println(entry.getKey() + ": " + getPawerScore(entry.getValue()));
        }
    }
    private static int getPawerScore(Set<String> value) {
        Map<String, Integer> cardPower = new HashMap<>();
        cardPower.put("2", 2);
        cardPower.put("3", 3);
        cardPower.put("4", 4);
        cardPower.put("5", 5);
        cardPower.put("6", 6);
        cardPower.put("7", 7);
        cardPower.put("8", 8);
        cardPower.put("9", 9);
        cardPower.put("10", 10);
        cardPower.put("J", 11);
        cardPower.put("Q", 12);
        cardPower.put("K", 13);
        cardPower.put("A", 14);
        Map<String, Integer> typePower = new HashMap<>();
        typePower.put("S", 4);
        typePower.put("H", 3);
        typePower.put("D", 2);
        typePower.put("C", 1);

        int maxPower = Arrays.stream(value.stream().mapToInt(card -> {
            String power = card.substring(0, card.length()-1);
            String multiplier = card.substring(card.length()-1, card.length());

            return cardPower.get(power) * typePower.get(multiplier);
        }).toArray()).sum();
        return maxPower;
    }
}
