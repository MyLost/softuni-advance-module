package functional_programming.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split(" ")).forEach(item -> System.out.println("Sir " + item));
    }
}
