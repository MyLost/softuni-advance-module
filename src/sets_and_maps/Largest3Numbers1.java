package sets_and_maps;

import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> sorted = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .sorted((n1,n2) -> n2.compareTo(n1)).collect(Collectors.toList());

        for (int i = 0; i < 3; i++) {
            if(sorted.size() > i) {
                System.out.print(sorted.get(i) + " ");
            }
        }
    }
}
