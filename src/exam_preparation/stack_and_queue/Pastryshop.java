package exam_preparation.stack_and_queue;

import java.util.*;
import java.util.stream.Collectors;

public class Pastryshop {
    static Deque<Integer> liquids = new ArrayDeque<>(); //queue
    static Deque<Integer> ingredients = new ArrayDeque<>(); //stack
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        ingredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

//        Integer[] liquidsFromConsole = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
//        Integer[] ingredientsFromConsole = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
//        Arrays.stream(ingredientsFromConsole).forEach(ingredients::push);
//        Collections.addAll(liquids, liquidsFromConsole);
        Map<String, Integer> pastry = new LinkedHashMap<>();
        pastry.put("Biscuit",0);
        pastry.put("Cake",0);
        pastry.put("Pie",0);
        pastry.put("Pastry",0);

        while(!liquids.isEmpty() && !ingredients.isEmpty()) {
//            int pickedIngredient =  ingredients.pop();
//            int sum = liquids.poll() + pickedIngredient;
            int sum = liquids.peekFirst() + ingredients.peekLast();
            if(sum == 100) {
                pastry.put("Pie", pastry.get("Pie") + 1);
                removeElements();
            } else if(sum == 75) {
                pastry.put("Pastry", pastry.get("Pastry") + 1);
                removeElements();
            } else if(sum == 50) {
                pastry.put("Cake", pastry.get("Cake") + 1);
                removeElements();
            } else if(sum == 25) {
                pastry.put("Biscuit", pastry.get("Biscuit") + 1);
                removeElements();
            }  else {
                liquids.removeFirst();
                ingredients.addLast(ingredients.pollLast() + 3);
//                ingredients.push(pickedIngredient + 3);
            }
        }

        if(pastry.get("Biscuit") > 0 && pastry.get("Cake") > 0 && pastry.get("Pastry") > 0 && pastry.get("Pie") > 0)  {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if(liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
//            String result = liquids.stream().sorted(Comparator.comparingInt(Integer::intValue)).map(item -> String.valueOf(item)).collect(Collectors.joining(", "));
            String result = liquids.stream().map(item -> String.valueOf(item)).collect(Collectors.joining(", "));
            System.out.println("Liquids left: " + result);
        }
        if(ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
//            String result = ingredients.stream().sorted(Comparator.comparingInt(Integer::intValue)).map(item -> String.valueOf(item)).collect(Collectors.joining(", "));
            //you need to reverse structure, because item must appear like getting it from stack;
            //you can optimize code. Use queue for liquids and stack for ingredients;
            String result = reverse(ingredients).stream().map(item -> String.valueOf(item)).collect(Collectors.joining(", "));
            System.out.println("Ingredients left: " + result);
        }
        for (Map.Entry<String, Integer> entry : pastry.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    private static void removeElements() {
        // this remove rightmost element in collections
        ingredients.removeLast();
        // this remove leftmost element in collections
        liquids.removeFirst();
    }
    public static List<Integer> reverse(Deque<Integer> queue) {
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            list.add(queue.pollLast());
        }
        return list;
    }
}
