package generics;

import java.util.ArrayDeque;

public class Jar<T> {

    private final ArrayDeque<T> data = new ArrayDeque();

    public void add(T element) {
        data.push(element);
    }

    public T remove() {
        return data.pop();
    }
}
