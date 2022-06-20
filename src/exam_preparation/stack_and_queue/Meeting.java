package exam_preparation.stack_and_queue;

import java.util.*;
import java.util.stream.Collectors;

public class Meeting {
//    static Deque<Integer> males;
//    static Deque<Integer> females;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        males = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .boxed()
//                .collect(Collectors.toCollection(ArrayDeque::new));
//        females = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .boxed()
//                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> males = new ArrayDeque<>(); //stack
        ArrayDeque<Integer> females = new ArrayDeque<>(); //queue
        Integer[] malesFromConsole = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] femalesFromConsole = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.stream(malesFromConsole).forEach(males::push);
        Collections.addAll(females, femalesFromConsole);


        int matches = 0;
        while (!(males.isEmpty() || females.isEmpty())) {

            if(males.peek() <= 0) {
                males.pop();
                continue;
            }
            if(females.peek() <= 0) {
                females.poll();
                continue;
            }

            if (males.peek() % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }
            if (females.peek() % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            }

            int singleMan = males.pop();
            int singleWoman = females.poll();
            if (singleMan == singleWoman) {
                matches++;
            } else {
                males.push(singleMan - 2);
            }
        }
//        System.out.println("Matches: " + matches);
//        String maleResult = males.size() == 0 ? "none" :  males.stream().map(item -> String.valueOf(item)).collect(Collectors.joining(", "));
//        String femaleResult = females.size() == 0 ? "none" :  females.stream().map(item -> String.valueOf(item)).collect(Collectors.joining(", "));
//        System.out.println(String.format("Males left: %s", maleResult));
//        System.out.println(String.format("Females left: %s", femaleResult));

        String result;

        System.out.println("Matches: " + matches);

        if(males.isEmpty()) {
            result = "Males left: none";
        } else {
            result = String.format("Males left: %s", males.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);

        if(females.isEmpty()) {
            result = "Females left: none";
        } else {
            result = String.format("Females left: %s", females.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);

    }
}
