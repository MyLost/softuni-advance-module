package stackAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        Deque<String> stack = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < numberOfOperations; i++) {
            String rawCommand = scanner.nextLine();
            String[] commandArguments = rawCommand.split("\\s+");
            int command = Integer.parseInt(commandArguments[0]);
            switch(command) {
                case 1:
                    stack.push(text.toString());
                    text.append(commandArguments[1]);
                    break;
                case 2:
                    stack.push(text.toString());
                    text.delete(text.length() - Integer.parseInt(commandArguments[1]), text.length());
                    break;
                case 3:
                    System.out.println(text.charAt(Integer.parseInt(commandArguments[1]) - 1));
                    break;
                case 4:
                    text = new StringBuilder(stack.pop());
                    break;
            }
        }
    }

}
