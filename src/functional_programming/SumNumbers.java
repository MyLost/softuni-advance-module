package functional_programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<String, Integer> func = s -> Integer.parseInt(s);
        Integer[] numbers = Arrays.stream(scanner.nextLine().split(", ")).map(func).toArray(Integer[]::new);
        System.out.println("Count = " + numbers.length);
        System.out.println("Sum = " + Arrays.stream(numbers).mapToInt(Integer::intValue).sum());
    }
}
