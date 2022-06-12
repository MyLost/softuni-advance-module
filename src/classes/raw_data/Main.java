package classes.raw_data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] carTokens = scanner.nextLine().split("\\s+");

            String model = carTokens[0];
            double engineSpeed = Double.parseDouble(carTokens[1]);
            double enginePower = Double.parseDouble(carTokens[2]);
            double cargoWeight = Double.parseDouble(carTokens[3]);
            String cargoType = carTokens[4];
            double tire1Pressure = Double.parseDouble(carTokens[5]);
            double tire1Age = Double.parseDouble(carTokens[6]);
            double tire2Pressure = Double.parseDouble(carTokens[7]);
            double tire2Age = Double.parseDouble(carTokens[8]);
            double tire3Pressure = Double.parseDouble(carTokens[9]);
            double tire3Age = Double.parseDouble(carTokens[10]);
            double tire4Pressure = Double.parseDouble(carTokens[11]);
            double tire4Age = Double.parseDouble(carTokens[12]);

            Car car = new Car(model);
            Engine engine = new Engine(engineSpeed, enginePower);
            car.setEngine(engine);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            car.setCargo(cargo);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            car.getTires().add(tire1);
            car.getTires().add(tire2);
            car.getTires().add(tire3);
            car.getTires().add(tire4);
            cars.add(car);
        }

        String command = scanner.nextLine();

        if(command.equals("fragile")) {
          cars.stream()
                   .filter(car -> car.getCargo().getCargoType().equals("fragile"))
                   .filter(car -> car.isHaveTyreWithLowPressure()).forEach(System.out::println);

        } else if (command.equals("flamable")) {
            cars.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("flamable"))
                    .filter(car -> car.getEngine().getEnginePower() > 250).forEach(System.out::println);
        }
    }
}
