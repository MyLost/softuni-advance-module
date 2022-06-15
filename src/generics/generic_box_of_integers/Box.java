package generics.generic_box_of_integers;

import java.util.ArrayList;
import java.util.List;

public class Box<Type extends Comparable<Type>> {

    List<Type> data;

    public void add(Type value) {
        data.add(value);
    }

    public Box() {
        data = new ArrayList<>();
    }

    @Override
    public String toString() {
        return data.getClass().getName() + ": " + data.toString();
    }


    public void swap (Integer firstIndex, Integer secondIndex) {
        Type temp = data.get(firstIndex.intValue());
        data.set(firstIndex, data.get(secondIndex.intValue()));
        data.set(secondIndex, temp);
    }

    public long countGreaterItems(Type element) {
        return data.stream().filter(elem -> elem.compareTo(element) > 0 ).count();
    }
}
