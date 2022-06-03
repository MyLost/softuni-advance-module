package functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            String[] personTokens = scanner.nextLine().split(", ");
            persons.add(new Person(personTokens[0], Integer.parseInt(personTokens[1])));
        }
        String ageCondition = scanner.nextLine();
        Integer ageFilter = Integer.parseInt(scanner.nextLine());
        String outputFormat = scanner.nextLine();
        persons = filterByAgeCondition(persons, getPredicate(ageCondition, ageFilter));
        Consumer<Person> printer = getPrinter(outputFormat);
        persons.forEach(printer);

    }

    private static Consumer<Person> getPrinter(String outputFormat) {
        switch (outputFormat) {
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalArgumentException("Unknown format " + outputFormat);
        }
    }

    private static Predicate<Person> getPredicate(String ageCondition, Integer ageFilter) {
        switch (ageCondition) {
            case "younger":
                return p -> p.age <= ageFilter;
            case "older":
                    return p -> p.age >= ageFilter;
            default:
                throw new IllegalArgumentException("Invalid parameters for age predicate " + ageCondition + " " + ageFilter);
        }
    }

    public static List<Person> filterByAgeCondition(List<Person> persons, Predicate<Person> predicate) {
            return persons.stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
    }

    private static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
