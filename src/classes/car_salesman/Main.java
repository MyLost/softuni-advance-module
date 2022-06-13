package classes.car_salesman;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] engineTokens = scanner.nextLine().split("\\s+");
            String model = engineTokens[0];
            Double power = Double.parseDouble(engineTokens[1]);
            Double displacement = null;
            String efficiency = null;
            if(engineTokens.length > 2) {
                if(engineTokens[2].matches("[A-Z]+")) {
                    efficiency = engineTokens[2];
                } else {
                    displacement = Double.parseDouble(engineTokens[2]);
                }
            }
            if(engineTokens.length > 3) {
                efficiency = engineTokens[3];
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.put(model, engine);
        }

        Map<String, Car>cars = new LinkedHashMap<>();
        n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carTokens = scanner.nextLine().split("\\s+");
            String model = carTokens[0];
            Engine engine = engines.get(carTokens[1]);
            Double weght=null;
            String color=null;
            if(carTokens.length > 2) {
                if(carTokens[2].matches("[A-Z][a-z]+")) {
                    color = carTokens[2];
                } else {
                    weght = Double.parseDouble(carTokens[2]);
                }
            }
            if(carTokens.length > 3) {
                color = carTokens[3];
            }
            Car car = new Car(model, engine, weght, color);
            cars.put(model, car);
        }
        cars.entrySet().stream().forEach(car -> System.out.println(car.getValue()));
    }
}
