package functional_programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        Predicate<String> predicate = s -> Character.isUpperCase(s.charAt(0));
        long upperWordsCount = Arrays.stream(words).filter(predicate).count();
        System.out.println(upperWordsCount);
        Arrays.stream(words).filter(predicate).forEach(System.out::println);
    }
}
