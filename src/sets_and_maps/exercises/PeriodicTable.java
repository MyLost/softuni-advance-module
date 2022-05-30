package sets_and_maps.exercises;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalElements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Arrays.stream(scanner.nextLine().split(" ")).forEach(chemicalElements::add);
        }
        chemicalElements.forEach(element -> System.out.print(element + " "));
    }
}
