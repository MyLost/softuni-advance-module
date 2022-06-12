package classes.speed_racing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap();

        for (int i = 0; i < n ; i++) {
            String[] carTokens = scanner.nextLine().split("\\s+");
            String carModel = carTokens[0];
            double carFuel = Double.parseDouble(carTokens[1]);
            double neededFulrFOrOneKm = Double.parseDouble(carTokens[2]);
            Car car = new Car(carModel, carFuel, neededFulrFOrOneKm);
            if(!cars.containsKey(carModel)) {
                cars.put(carModel, car);
            }
        }
        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            String[] commndTokens = command.split("\\s+");
            String action = commndTokens[0];
            String carModel = commndTokens[1];
            int distanceForTravel = Integer.parseInt(commndTokens[2]);

            if(action.equals("Drive")) {
                cars.get(carModel).travel(distanceForTravel);
            }
            command = scanner.nextLine();
        }
        cars.entrySet().stream().forEach(item -> {
            System.out.println(item.getValue());
        });
    }
}
