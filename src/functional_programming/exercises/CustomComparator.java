package functional_programming.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        Comparator<Integer> customComparator = (num1, num2) -> {
            if(num1 % 2 == 0 && num2 % 2 != 0) {
                return -1;
            } else if (num1 % 2 != 0 && num2 % 2 == 0) {
                return 1;
            } else {
                return num1.compareTo(num2);
            }
        };

        Arrays.sort(numbers, customComparator);
        Arrays.stream(numbers).forEach(item -> System.out.print(item + " "));
    }
}
