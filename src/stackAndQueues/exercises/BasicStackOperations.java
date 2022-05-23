package stackAndQueues.exercises;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasicStackOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int elemetsToPop;
        int elementsToPush;
        int elementToBEChecked;
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toList();
        elemetsToPop = numbers.get(1);
        elementToBEChecked = numbers.get(2);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stack::push);

        for (int item = 0; item < elemetsToPop; item++) {
            stack.pop();
        }

        int foundenItem = -1;
        for(int i: stack) {
            if (i == elementToBEChecked) {
                foundenItem = elementToBEChecked;
                break;
            }
        }

        if(foundenItem != -1) {
            System.out.println(true);
        } else if(!stack.isEmpty()){
            int smallest = Integer.MAX_VALUE;
            for(int i: stack) {
                if(smallest > i) {
                    smallest = i;
                }
            }
            System.out.println(smallest);
        }
        if(stack.isEmpty()) {
            System.out.println(0);
        }
    }
}