package sets_and_maps;
import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> records = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n ; i++) {
            String[] inputValues = scanner.nextLine().split("\\s+");
            String name = inputValues[0];
            Double grade = Double.parseDouble(inputValues[1]);

            if(!records.containsKey(name)) {
                records.put(name, new ArrayList<>());
                records.get(name).add(grade);
            } else {
                records.get(name).add(grade);
            }
        }
        records.entrySet().forEach(item -> {
           System.out.println(item.getKey() + " -> " +
                   String.join(" ", records.get(item.getKey()).stream().map(grade -> String.format("%.2f", grade)).collect(Collectors.toList())) + " (avg: " +
                   String.format("%.2f", findAverageSum(item.getValue()) / item.getValue().size()) + ")");
       });
    }
    private static Double findAverageSum(List<Double> list) {
        return list.stream().mapToDouble(Double::doubleValue).sum();
    }
}
