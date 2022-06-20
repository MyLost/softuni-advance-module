package exam_preparation.stack_and_queue;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequenceOne = scanner.nextLine().split("\\s+");
        String[] sequenceTwo = scanner.nextLine().split("\\s+");

        Map<String, Integer> swords = new TreeMap<>();

        Deque<Integer> steel = new ArrayDeque<>();
        Deque<Integer> carbon = new ArrayDeque<>();

        int totalNumberOfSwords = 0;
        Arrays.stream(sequenceOne).forEach(item -> steel.push(Integer.parseInt(item)));
        Arrays.stream(sequenceTwo).forEach(item -> carbon.push(Integer.parseInt(item)));

        while(!steel.isEmpty() && !carbon.isEmpty()) {
//          System.out.println(steel.pollLast() + " -> " + carbon.pollFirst());
            //We can use pool -> getLast and pop -> getFirst the result will be the same!.
            // But need to save values in variable in use it in condition statements below, isn't program not working!
            int materialSum = steel.getLast() + carbon.getFirst();
            if(materialSum == 110) {
                totalNumberOfSwords++;
                if(swords.get("Sabre") == null) {
                    swords.put("Sabre", 1);
                } else {
                    swords.put("Sabre", swords.get("Sabre") + 1);
                }
                steel.removeLast();
                carbon.removeFirst();
            } else if(materialSum == 90) {
                totalNumberOfSwords++;
                if(swords.get("Katana") == null) {
                    swords.put("Katana", 1);
                } else {
                    swords.put("Katana", swords.get("Katana") + 1);
                }
                steel.removeLast();
                carbon.removeFirst();
            } else if(materialSum == 80) {
                totalNumberOfSwords++;
                if(swords.get("Shamshir") == null) {
                    swords.put("Shamshir", 1);
                } else {
                    swords.put("Shamshir", swords.get("Shamshir") + 1);
                }
                steel.removeLast();
                carbon.removeFirst();
            } else if(materialSum == 70) {
                totalNumberOfSwords++;
                if(swords.get("Gladius") == null) {
                    swords.put("Gladius", 1);
                } else {
                    swords.put("Gladius", swords.get("Gladius") + 1);
                }
                steel.removeLast();
                carbon.removeFirst();
            }  else {
                steel.removeLast();
                carbon.push(carbon.pollFirst() + 5);
            }
        }
        if(totalNumberOfSwords > 0) {
            System.out.println(String.format("You have forged %d swords.", totalNumberOfSwords));
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if(steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            String result = steel.stream().map(item -> String.valueOf(item)).collect(Collectors.joining(", "));
            System.out.print(result);
            System.out.println();
        }
        if(carbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            String result = carbon.stream().map(item -> String.valueOf(item)).collect(Collectors.joining(", "));
            System.out.print(result);
            System.out.println();
        }
        for (Map.Entry<String, Integer> entry : swords.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
