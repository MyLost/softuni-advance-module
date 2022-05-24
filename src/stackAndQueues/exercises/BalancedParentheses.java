package stackAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//      System.out.println("{[()]}".substring(0, "{[()]}".length()/2));
//      System.out.println("{[()]}".substring("{[()]}".length()/2, "{[()]}".length()));
        String expression = scanner.nextLine();
        Deque<Character> leftStack = new ArrayDeque<>();
        boolean isBalanced = true;
        String leftSide = expression.substring(0, expression.length()/2);
        String rightSide = expression.substring(expression.length()/2, expression.length());
        if(leftSide.length() != rightSide.length()) {
           isBalanced = false;
        } else {
            for (int i = 0; i < leftSide.length(); i++) {
                leftStack.push(leftSide.charAt(i));
            }
            for (int i = 2, y=0; i >= 0 && y < rightSide.length(); i--, y++) {
                Character leftBraket = leftStack.pop();
                Character rightBraket = rightSide.charAt(y);
                if (leftBraket.equals('(') && !rightBraket.equals(')')) {
                    isBalanced = false;
                } else if (leftBraket.equals('[') && !rightBraket.equals(']')) {
                    isBalanced = false;
                } else if (leftBraket.equals('{') && !rightBraket.equals('}')) {
                    isBalanced = false;
                }
            }
        }
        if(isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
