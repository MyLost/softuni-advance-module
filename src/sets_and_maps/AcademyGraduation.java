package sets_and_maps;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> schoolRecords = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        String pattern ="#.###################################";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        for (int i = 0; i < n; i++) {
            double sum =0;
            String name = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
//            schoolRecords.put(name, averageScore);
            for (double element: scores) {
                sum += element;
            }
            schoolRecords.put(name, sum / scores.length);
        }
        for (var entry : schoolRecords.entrySet()) {
            System.out.println(String.format("%s is graduated with %s", entry.getKey(), decimalFormat.format(entry.getValue())));
        }
    }
}
