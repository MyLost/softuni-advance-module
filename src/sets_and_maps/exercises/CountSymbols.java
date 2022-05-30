package sets_and_maps.exercises;

import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] inputText = scanner.nextLine().toCharArray();
        Map<Character, Integer> map = new TreeMap<>();

        for (char character: inputText) {
            map.putIfAbsent(character, 0);
            map.put(character, map.get(character) + 1);
        }

        for (var entry: map.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
