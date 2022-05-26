package sets_and_maps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] values = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> realNmbers = new LinkedHashMap<>();

        for (double value: values) {
            if(!realNmbers.containsKey(value)) {
                realNmbers.put(value, 1);
            } else {
                realNmbers.put(value, realNmbers.get(value) + 1);
            }
        }

        for(Double key: realNmbers.keySet()) {
            System.out.printf("%.1f -> %d", key,  realNmbers.get(key));
        }
    }
}
