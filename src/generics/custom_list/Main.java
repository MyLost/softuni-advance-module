package generics.custom_list;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList customList = new CustomList<>();
        String commandInput = scanner.nextLine();

        while(!"END".equals(commandInput)) {
            String[] commandTokens = commandInput.split("\\s+");
            String command = commandTokens[0];

            switch (command) {
                case "Add":
                    customList.add(commandTokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(commandTokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(commandTokens[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(commandTokens[1]), Integer.parseInt(commandTokens[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(commandTokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.print();
                    break;
                case "Sort":
                     Sorter.sort(customList);
                break;
                default:
                    throw new IllegalArgumentException("Wrong command input!");
            }
            commandInput = scanner.nextLine();
        }
    }
}
