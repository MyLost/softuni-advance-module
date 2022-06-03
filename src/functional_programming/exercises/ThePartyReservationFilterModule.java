package functional_programming.exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        List<String> filters = new ArrayList<>();
        while(!"Print".equals(command)) {
            String[] inputTokens = command.split(";");
            String action = inputTokens[0];
            if(action.equals("Add filter")) {
               filters.add(command.replace("Add filter;", ""));
            } else if(action.equals("Remove filter")) {
              if(filters.contains(command.replace("Remove filter;",""))) {
                  filters.remove(command.replace("Remove filter;",""));
              }
            }
            command = scanner.nextLine();
        }
        for (String item : filters) {
            String[] tokens = item.split(";");
            String criteria = tokens[0];
            String filterParam = tokens[1];
            Predicate<String> filter = null;
            switch (criteria) {
                case "Starts with":
                    filter = s -> s.startsWith(filterParam);
                    break;
                case "Ends with":
                    filter = s -> s.endsWith(filterParam);
                    break;
                case "Length":
                    filter = s -> s.length() == Integer.parseInt(filterParam);
                    break;
                case "Contains":
                    filter = s -> s.contains(filterParam);
                    break;
                default:
                    throw new IllegalArgumentException("Given condition is not valid! " + criteria);
            }
            names.removeIf(filter);
        }
        System.out.println(String.join(" ", names));
    }
}
