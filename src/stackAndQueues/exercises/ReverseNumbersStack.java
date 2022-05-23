package stackAndQueues.exercises;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseNumbersStack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        String input = scanner.nextLine();

        Arrays.stream(input.split("\\s+")).map(item -> Integer.parseInt(item)).forEach(stack::push);
        stack.stream().forEach(item -> {
            System.out.print(item);
            System.out.print(" ");
        });
    }
}
