package stackAndQueues;

import java.util.*;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        Deque<String> stack = new ArrayDeque<>();
        Integer finalSum = 0;
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            stack.add(token);
        }

        while(true) {
            Integer sum = 0;
            String firstNumber = stack.pop();
            if(stack.isEmpty()) {
                finalSum = Integer.parseInt(firstNumber);
                break;
            }
            String token = stack.pop();
            String secondNumber = stack.pop();

            if(token.equals("+")) {
                sum = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
                stack.push(String.valueOf(sum));
            }

            if(token.equals("-")) {
                sum = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
                stack.push(String.valueOf(sum));
            }
        }
        System.out.println(finalSum);
    }
}
