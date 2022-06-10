package classes.defining_classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputValues = scanner.nextLine().split("\\s+");
//            Car car = new Car();
//            car.setBrand(inputValues[0]);
//            car.setModel(inputValues[1]);
//            car.setHorsePower(Integer.parseInt(inputValues[2]));
            if(inputValues.length == 1) {
                Car car = new Car(inputValues[0]);
                cars.add(car);
            } else {
                Car car = new Car(inputValues[0], inputValues[1], Integer.parseInt(inputValues[2]));
                cars.add(car);

            }
//            cars.add(car);
        }

        cars.forEach(car -> System.out.println(car.carInfo()));

//        Car car = new Car();
//        car.setBrand("Chevrolet");
//        car.setModel("Impala");
//        car.setHorsePower(390);
//
//        System.out.println(String.format("The car is: %s %s -%d HP", car.getBrand(), car.getModel(), car.getHorsePower()));



    }
}
