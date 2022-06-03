package functional_programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] range = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        Predicate<Integer> oddPredicate = number -> number % 2 != 0;
        Predicate<Integer> evenPredicate = number -> number % 2 == 0;

        if(scanner.nextLine().equals("odd")) {
             IntStream.range(range[0], range[1]+1).filter(oddPredicate::test).forEach(number -> System.out.print(number + " "));
        } else {
            IntStream.range(range[0], range[1]+1).filter(evenPredicate::test).forEach(number -> System.out.print(number + " "));
        }
    }
}
