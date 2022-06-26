package regular_exam_2022;

import java.util.*;
import java.util.stream.Collectors;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //queue
        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        //stack
        ArrayDeque<Double> powderStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).forEach(element -> milkQueue.offer(element));
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).forEach(element -> powderStack.push(element));
        Map<String, Integer> chocolates = new TreeMap<>();
        chocolates.put("Milk Chocolate", 0);
        chocolates.put("Dark Chocolate", 0);
        chocolates.put("Baking Chocolate", 0);
        while(!milkQueue.isEmpty() && !powderStack.isEmpty()) {
            Double milkValue = milkQueue.poll();
            Double cacaoPowderValue = powderStack.pop();

            int cacaoPercentage = (int) ((cacaoPowderValue / (milkValue + cacaoPowderValue)) * 100);

            switch (cacaoPercentage) {
                case 100:
                    chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
                    break;
                case 50:
                    chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
                    break;
                case 30:
                    chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
                    break;
                default:
                    milkQueue.add(milkValue + 10);
            }
        }

        if(chocolates.get("Baking Chocolate") > 0 && chocolates.get("Dark Chocolate") > 0 && chocolates.get("Milk Chocolate") > 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> entry : chocolates.entrySet()) {
            if(entry.getValue() > 0) {
                System.out.println(String.format("# %s --> %d", entry.getKey(), entry.getValue()));
            }
        }
    }
}
