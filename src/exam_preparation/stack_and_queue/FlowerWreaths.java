package exam_preparation.stack_and_queue;

import java.util.*;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liliesStack = new ArrayDeque<>();
        Deque<Integer> rosesQueue = new ArrayDeque<>();
        //queue
        rosesQueue = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        //stack
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(liliesStack::push);

        int wreath = 0;
        int otherFlowers = 0;
        while(!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {

            int rose = rosesQueue.poll();
            int lily = liliesStack.pop();

            int sum = lily + rose;

            while(sum > 15) {
                lily -=2;
                sum = lily + rose;
            }

            if(sum == 15) {
                wreath++;
            } else if (sum < 15) {
                otherFlowers += sum;
            }
        }

        int leftoverWreaths = otherFlowers / 12;
        wreath += leftoverWreaths;

        if(wreath >= 5 ) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreath);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreath);
        }
    }
}
