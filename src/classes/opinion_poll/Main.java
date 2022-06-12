package classes.opinion_poll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i <n  ; i++) {
            String[] inputTokens = scanner.nextLine().split("\\s+");
            persons.add(new Person(inputTokens[0], Integer.parseInt(inputTokens[1])));
        }
        persons.stream().filter(person -> person.getAge() > 30).sorted(Comparator.comparing(Person::getName)).forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));
    }
}
