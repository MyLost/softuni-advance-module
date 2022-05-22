package stackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MathPotato {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String names = scanner.nextLine();
            int count = Integer.parseInt(scanner.nextLine());
            Deque<String> queue = new ArrayDeque<>();
            String lastName;
            Arrays.stream(names.split("\\s+")).forEach(queue::offer);
            int cycle = 1;
            while(true) {
                int i;
                for (i=1; i < count; i++) {
                    lastName = queue.pollFirst();
                    queue.add(lastName);
                }
                if(queue.size() <= 1) {
                    break;
                }
                if(cycle==1 || cycle==4 || (cycle>5 && (cycle%2==0 || cycle%3==0 || cycle%5==0))) {
                    System.out.println("Removed " + queue.pollFirst());
                } else {
                    System.out.println("Prime " + queue.peekFirst());
                }
                cycle++;
            }
            System.out.println("Last is " + queue.poll());
        }
    }

