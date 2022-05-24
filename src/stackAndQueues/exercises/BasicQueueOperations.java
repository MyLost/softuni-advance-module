package stackAndQueues.exercises;

import java.util.*;
import java.util.stream.IntStream;

public class BasicQueueOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] number = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> queue = new ArrayDeque<>();
        IntStream.range(0,number.length).forEach(item -> queue.add(number[item]));
        IntStream.range(0,commands[1]).forEach(item ->queue.poll());
        if(queue.contains(commands[2])) {
            System.out.println("true");
        }else if(queue.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
