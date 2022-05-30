package sets_and_maps.exercises;
import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> setOne = new LinkedHashSet<>();
        Set<Integer> setTwo = new LinkedHashSet<>();

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < size[0] ; i++) {
            setOne.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < size[1] ; i++) {
            setTwo.add(Integer.parseInt(scanner.nextLine()));
        }

        setOne.retainAll(setTwo);
        setOne.forEach(e -> System.out.print(e + " "));
    }
}
