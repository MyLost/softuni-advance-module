package stackAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        int n = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] inputArguments = scanner.nextLine().split("\\s+");
            int commandType = Integer.parseInt(inputArguments[0]);
            if(commandType == 1) {
                number = Integer.parseInt(inputArguments[1]);
            }
            switch(commandType) {
                case 1:
                    stack.push(number);
                    break;
                case 2:
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case 3:
                    if(!stack.isEmpty()) {
                        Integer maxNum = Integer.MIN_VALUE;
                        for (Integer y : stack) {
                            if (y > maxNum) {
                                maxNum = y;
                            }
                        }
                        System.out.println(maxNum);
                    }
                    break;
            }
//            inputArguments = scanner.nextLine().split("\\s+");
//            if(!inputArguments[0].equals("")) {
//                commandType = Integer.parseInt(inputArguments[0]);
//            }
//            if(commandType == 1) {
//                number = Integer.parseInt(inputArguments[1]);
//            }
        }
    }
}
