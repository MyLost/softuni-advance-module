package functional_programming.exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> filter;
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while(!"Party!".equals(command)) {
            String[] inputTokens = command.split(" ");
            String action = inputTokens[0];
            String criteria = inputTokens[1];
            String filterParam = inputTokens[2];
            switch (criteria) {
                case "StartsWith":
                    filter = s -> s.startsWith(filterParam);
                    break;
                case "EndsWith":
                    filter = s -> s.endsWith(filterParam);
                    break;
                case "Length":
                    filter = s -> s.length() == Integer.parseInt(filterParam);
                    break;
                default:
                    throw new IllegalArgumentException("Given condition is not valid! " + criteria);
            };

            if(action.equals("Remove")) {
                names.removeIf(filter);
            } else if(action.equals("Double")) {
                List<String> namesToAddAgain = new ArrayList<>();
                names.stream().filter(filter).forEach(namesToAddAgain::add);
                names.addAll(namesToAddAgain);
            }
            command = scanner.nextLine();
        }
        if(names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            System.out.println(String.join(", ", names) + " are going to the party!");
        }
    }
}
