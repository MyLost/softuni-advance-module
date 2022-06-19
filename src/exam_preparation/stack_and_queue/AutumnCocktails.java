package exam_preparation.stack_and_queue;

import java.util.*;
import java.util.stream.Collectors;
public class AutumnCocktails {
    static Deque<Integer> ingredients;
    static Deque<Integer> freshness;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ingredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        freshness = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour",0);
        cocktails.put("The Harvest",0);
        cocktails.put("Apple Hinny",0);
        cocktails.put("High Fashion",0);

        while(!freshness.isEmpty() && !ingredients.isEmpty()) {
            if(ingredients.peekFirst() == 0) {
                ingredients.removeFirst();
                continue;
            }
//            else if (freshness.peekLast() == 0) {
//                freshness.removeLast();
//                continue;
//            }
            int sum = ingredients.peekFirst() * freshness.peekLast();
            if(sum == 400) {
                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                removeElements();
            } else if(sum == 300) {
                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                removeElements();
            } else if(sum == 250) {
                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                removeElements();
            } else if(sum == 150) {
                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                removeElements();
            }  else {
                freshness.removeLast();
                //get leftmost element and put it rightmost
                ingredients.addLast(ingredients.pollFirst() + 5);
            }
        }

        if(cocktails.get("Pear Sour") > 0 &&  cocktails.get("The Harvest") > 0 &&  cocktails.get("Apple Hinny") > 0 &&  cocktails.get("High Fashion") > 0)  {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if(!ingredients.isEmpty()) {
            int result = ingredients.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Ingredients left: " + result);
        }
//        if(!freshness.isEmpty()) {
//            int result = freshness.stream().mapToInt(Integer::intValue).sum();
//            System.out.println("Ingredients left: " + result);
//        }
        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
            if(entry.getValue() > 0) {
                System.out.println("# " + entry.getKey() + " --> " + entry.getValue());
            }
        }
    }
    private static void removeElements() {
        // this remove rightmost element in collections
        freshness.removeLast();
        // this remove leftmost element in collections
        ingredients.removeFirst();
    }

}
