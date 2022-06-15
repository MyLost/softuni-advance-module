package generics.generic_box_of_integers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box box = new Box();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
//           box.add(scanner.nextLine());
            box.add(Double.parseDouble(scanner.nextLine()));
        }

//        int[] swapTokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        Box.swap(swapTokens[0], swapTokens[1]);
//        boxes.forEach(System.out::println);

//        String token = scanner.nextLine();
        Double token = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countGreaterItems(token));

    }
}
