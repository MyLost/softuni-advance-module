package generics.custom_list;

import java.util.ArrayList;
import java.util.List;

public class CustomList<Type extends Comparable<Type>> {
    private List<Type> data;

    CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(Type element) {
        this.data.add(element);
    }

    public Type remove (int index) {
        return this.data.remove(index);
    }

    public boolean contains(Type element) {
        return this.data.contains(element);
    }

    public void swap (int indexOne, int indexTwo) {
        Type temp = this.data.get(indexOne);
        this.data.set(indexOne, this.data.get(indexTwo));
        this.data.set(indexTwo, temp);
    }

    public long countGreaterThan(Type element) {
        return this.data.stream().filter(item -> item.compareTo(element) > 0).count();
    }

    public Type getMax() {
        return this.data.stream().max((el1,el2) -> el1.compareTo(el2)).get();
    }

    public Type getMin() {
        return this.data.stream().min((el1,el2) -> el1.compareTo(el2)).get();
    }

    public void print() {
        this.data.forEach(System.out::println);
    }

    public int size() {
        return data.size();
    }

    public Type get(int index) {
        return this.data
                .get(index);
    }
}
