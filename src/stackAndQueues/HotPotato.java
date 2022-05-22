package stackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        Deque<String> queue = new ArrayDeque<>();
        String lastName;
        Arrays.stream(names.split("\\s+")).forEach(queue::offer);

        while(true) {
            for (int i = 1; i < count; i++) {
               lastName = queue.pollFirst();
                queue.add(lastName);
            }
            if(queue.size() <= 1) {
                break;
            }
            System.out.println("Removed " +  queue.pollFirst());
        }
        System.out.println("Last is " + queue.poll());
    }
}
