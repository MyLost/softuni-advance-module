package sets_and_maps;

import java.util.*;
import java.util.stream.Collectors;

public class CitiesByContinentAndCountry {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();
        for (int i = 0; i < n ; i++) {
            String [] inputValues = scanner.nextLine().split(" ");
            String continent = inputValues[0];
            String country = inputValues[1];
            String city = inputValues[2];

            if(!data.containsKey(continent)) {
                data.put(continent, new LinkedHashMap<>());
                data.get(continent).put(country, new ArrayList<>());
                data.get(continent).get(country).add(city);
            } else {
                if(!data.get(continent).containsKey(country)) {
                    data.get(continent).put(country, new ArrayList<>());
                    data.get(continent).get(country).add(city);
                } else {
                    data.get(continent).get(country).add(city);
                }
            }
        }
        printData(data);
    }

    private static void printData(Map<String, Map<String, List<String>>> data) {
        for (String continent : data.keySet()) {
            System.out.println(continent + ":");
            for (var entry : data.get(continent).entrySet()) {
                System.out.print(entry.getKey() + " -> ");
                String joiningList = String.join(", ",entry.getValue());
                System.out.println(joiningList);
            }
        }
    }
}
