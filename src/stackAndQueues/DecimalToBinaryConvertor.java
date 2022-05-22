package stackAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinaryConvertor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int remainder;
        Deque<Integer> stack = new ArrayDeque<>();

        while(number != 0 ) {
            remainder =  number % 2;
            stack.push(remainder);
            number = number / 2;
        }
        if(stack.isEmpty()) {
            System.out.println(0);
        } else {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
    }
}
