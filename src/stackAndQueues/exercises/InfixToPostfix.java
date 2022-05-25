package stackAndQueues.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class InfixToPostfix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> tokensQueue = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<String> outputQueue = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();

        while (!tokensQueue.isEmpty()) {
            String token = tokensQueue.poll();
           if(token.equals("("))  {
               operatorStack.push(token);
           } else if(token.equals(")")) {
               outputQueue.push(operatorStack.pop());
               operatorStack.pop();
           } else if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*") || token.equals("^")) {
               if(token.equals("/")) {
                   if (!operatorStack.isEmpty()) {
                       String currentOperator = operatorStack.pop();
                       operatorStack.push(token);
                       operatorStack.push(currentOperator);
                   } else {
                       operatorStack.push(token);
                   }
               } else  if (!operatorStack.isEmpty() && operatorStack.peek().equals("+") && token.equals("+")) {
                       String currentOperator = operatorStack.pop();
                       operatorStack.push(token);
                       outputQueue.push(currentOperator);
               }else{
                   operatorStack.push(token);
               }
           } else {
               outputQueue.push(token);
           }
        }
        while(!operatorStack.isEmpty()) {
            outputQueue.push(operatorStack.pop());
        }
        while(!outputQueue.isEmpty()) {
            System.out.print(outputQueue.pollLast() + " ");
        }
    }
}
