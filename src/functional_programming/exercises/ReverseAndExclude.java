package functional_programming.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        numbers.removeIf(element -> element % n == 0);
        Collections.reverse(numbers);
        numbers.forEach(item -> System.out.print(item + " "));
    }
}
