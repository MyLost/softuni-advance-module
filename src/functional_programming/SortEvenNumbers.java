package functional_programming;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(Arrays.stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new))
                .filter(number -> number % 2 == 0)
                .toArray(Integer[]::new);
        System.out.print(String.join(", ", Arrays.stream(numbers).map(String::valueOf).collect(Collectors.toList())));
        System.out.println();
        System.out.print(String.join(", ", Arrays.stream(
                Arrays.stream(numbers)
                .sorted(Integer::compareTo)
                .toArray(Integer[]::new)
                )
                .map(String::valueOf)
                .collect(Collectors.toList())));
    }
}
