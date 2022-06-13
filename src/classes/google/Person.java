package classes.google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String Name;
    private Company company;
    private final List<Pokemon> pokemon = new ArrayList<>();
    private final List<Parent> parents = new ArrayList<>();
    private final List<Children> children = new ArrayList<>();
    private Car car;

    public Person(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return Name + System.lineSeparator() +
                "Company:" + System.lineSeparator() +
                (company == null ? "" : company + System.lineSeparator()) +
                "Car:" + System.lineSeparator() +
                (car == null ? "" : car + System.lineSeparator()) +
                "Pokemon:" + System.lineSeparator() +
                ((pokemon.isEmpty()) ? "" : pokemon.stream().map(Pokemon::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator()) +
                "Parents:" + System.lineSeparator() +
                ((parents.isEmpty()) ? "" : parents.stream().map(Parent::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator()) +
                "Children:" + System.lineSeparator() +
                ((children.isEmpty()) ? "" : children.stream().map(Children::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator());

    }
}
