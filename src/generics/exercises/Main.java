package generics.exercises;

import workshop.ArrayDeque;
import workshop.SmartArray;

public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();
        smartArray.add(5);
        smartArray.add(6);
        smartArray.add(8);
        smartArray.add(10);
        smartArray.add(6);
        smartArray.add(3);
        smartArray.add(4);

        System.out.println(smartArray.remove(0));
        System.out.println(smartArray.remove(4));

        System.out.println(smartArray.contains(10));
        smartArray.forEach(System.out::println);

        System.out.println("#########################################################################################");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(2);
        arrayDeque.push(4);
        arrayDeque.push(6);
        arrayDeque.push(8);
        arrayDeque.push(10);

        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque.pop());
        System.out.println(arrayDeque.pop());
        arrayDeque.forEach(System.out::println);
    }
}
