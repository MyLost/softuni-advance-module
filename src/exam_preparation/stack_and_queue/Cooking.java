package exam_preparation.stack_and_queue;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read input first line is queue second is stack
        //queue
        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

//        ArrayDeque<Integer> ingredians = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .collect(Collectors.toCollection(ArrayDeque::new));
        //stack
        ArrayDeque<Integer> ingredians = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(ingredians::push);

        Map<String, Integer> cookedFoods = new TreeMap<>();
        cookedFoods.put("Bread",0);
        cookedFoods.put("Cake",0);
        cookedFoods.put("Pastry",0);
        cookedFoods.put("Fruit Pie",0);

        while(!liquids.isEmpty() && !ingredians.isEmpty()) {
            int lastIngredient = ingredians.pop();
            // sum first from queue with last from stack
            int sum = liquids.poll() + lastIngredient;
            String cookedFood;
                    switch(sum) {
            case 100:
                cookedFood = "Fruit Pie";
                break;
            case 75:
                cookedFood = "Pastry";
                break;
            case 50:
                cookedFood = "Cake";
                break;
            case 25:
                cookedFood = "Bread";
                break;
            default:
                cookedFood = null;
            }
//            //return first element of this queue
//            liquids.poll();
//            //return last element of stack
//            int lastIngrediant =  ingredians.pop();
            if(cookedFood !=null) {
                int newVal = cookedFoods.get(cookedFood) + 1 ;
                cookedFoods.put(cookedFood, newVal);
            } else {
                ingredians.push(lastIngredient + 3);
            }
        }

        boolean allFoodsAreCooked = cookedFoods.entrySet().stream().allMatch(e -> e.getValue()  > 0);
        //check and print output
        if(allFoodsAreCooked) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        String remainingLiquids = liquids.isEmpty() ? "none" : liquids.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Liquids left: " + remainingLiquids);


        String remainingIngrideans = ingredians.isEmpty() ? "none" : ingredians.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Ingredients left: " + remainingIngrideans);

        cookedFoods.entrySet().forEach(e ->
            System.out.println(e.getKey() + ": " + e.getValue())
        );
    }
}
