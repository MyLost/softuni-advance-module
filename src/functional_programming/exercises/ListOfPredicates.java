package functional_programming.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] devisionNumbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Predicate<Integer> predicate = number -> {
            for (int i = 0; i < devisionNumbers.length ; i++) {
                if(number % devisionNumbers[i] != 0) {
                    return false;
                }
            }
            return true;
        };
        Integer[] result = IntStream.range(1,n+1).filter(predicate::test).boxed().toArray(Integer[]::new);
        Arrays.stream(result).forEach(num ->System.out.print(num + " "));
    }
}
