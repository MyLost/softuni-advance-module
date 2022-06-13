package classes.google;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Person> persons = new HashMap<>();
        while(!"End".equals(command)) {
            String[] inputValues = command.split("\\s+");
            String name = inputValues[0];
            String type = inputValues[1];
            persons.putIfAbsent(name, new Person(name));
            switch (type) {
                case "company":
                    String companyName = inputValues[2];
                    String department = inputValues[3];
                    Double salary = Double.parseDouble(inputValues[4]);
//                    Company company = new Company(companyName, department, salary);
//                    persons.get(name).setCompany(company);
                    persons.get(name).setCompany(new Company(companyName, department, salary));
                    break;
                case "pokemon":
                    String pokemonName = inputValues[2];
                    String pokemonType = inputValues[3];
//                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
//                    persons.get(name).getPokemon().add(pokemon);
                    persons.get(name).getPokemon().add(new Pokemon(pokemonName, pokemonType));
                    break;
                case "parents":
                    String parentName = inputValues[2];
                    String parentBirthDay = inputValues[3];
//                    Parent parent = new Parent(parentName, parentBirthDay);
//                    persons.get(name).getParents().add(parent);
                    persons.get(name).getParents().add(new Parent(parentName, parentBirthDay));
                    break;
                case "children":
                    String childName = inputValues[2];
                    String childBirthDay = inputValues[3];
//                    Children children = new Children(childName, childBirthDay);
//                    persons.get(name).getChildren().add(children);
                    persons.get(name).getChildren().add(new Children(childName, childBirthDay));
                    break;
                case "car":
                    String carModel = inputValues[2];
                    int carSpeed = Integer.parseInt(inputValues[3]);
//                    Car car = new Car(carModel, carSpeed);
//                    persons.get(name).setCar(car);
                    persons.get(name).setCar(new Car(carModel, carSpeed));
                    break;
//                default:
//                    throw new IllegalArgumentException("Not valid type for processing! " + type);
            }
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        System.out.println(persons.get(command));
    }
}
