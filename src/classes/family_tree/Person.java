package classes.family_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Person {
    private String name;
    private String birthDate;
    private final List<Person> children = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Person> getChildren() {
        return children;
    }


}
