package generics.tuple;

public class CustomTuple<Type1, Type2> {

    private Type1 valueOne;
    private Type2 valueTwo;

    CustomTuple(Type1 valueOne, Type2 valueTwo) {
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Override
    public String toString() {
        return valueOne + " -> " + valueTwo;
    }
}
