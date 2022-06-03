package functional_programming.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::valueOf)
                .boxed()
                .toArray(Integer[]::new);
        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            if (command.equals("add")) {
                numbers = Arrays.stream(numbers).mapToInt(number -> number + 1).boxed().toArray(Integer[]::new);
            } else if (command.equals("multiply")) {
                numbers = Arrays.stream(numbers).mapToInt(number -> number * 2).boxed().toArray(Integer[]::new);
            } else if (command.equals("subtract")) {
                numbers = Arrays.stream(numbers).mapToInt(number -> number - 1).boxed().toArray(Integer[]::new);
            } else if (command.equals("print")) {
                Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
            }
            command = scanner.nextLine();
        }
    }
}
