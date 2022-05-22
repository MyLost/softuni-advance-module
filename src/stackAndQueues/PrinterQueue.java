package stackAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();

        String input = scanner.nextLine();

        while(!"print".equals(input)) {
            if(input.equals("cancel")) {
                if (stack.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + stack.pop());
                }
            } else {
                stack.offer(input);
            }
            input = scanner.nextLine();
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pollFirst());
        }
    }
}
