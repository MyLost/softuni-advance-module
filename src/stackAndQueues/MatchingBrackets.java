package stackAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i < expression.length(); i++) {
            char currentSymbol = expression.charAt(i);
           if(currentSymbol == '(') {
               stack.push(i);
           } else if (currentSymbol == ')') {
               int lastOpenedSymbol = stack.pop();
               System.out.println(expression.substring(lastOpenedSymbol, i+1));
           }
        }
    }
}
