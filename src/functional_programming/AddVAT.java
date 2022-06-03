package functional_programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] prices = Arrays.stream(scanner.nextLine().split(", ")).mapToDouble(Double::parseDouble).toArray();
        DoubleUnaryOperator addVat = value -> value * 1.2;
        System.out.println("Prices with VAT:");
        Arrays.stream(prices).map(addVat).forEach(item -> System.out.println(String.format("%.2f",item)));
    }
}
