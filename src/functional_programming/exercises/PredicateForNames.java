package functional_programming.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nameLenght = Integer.parseInt(scanner.nextLine());
        Arrays.stream(scanner.nextLine().split(" ")).filter(name -> name.length() <= nameLenght).forEach(System.out::println);
    }
}
