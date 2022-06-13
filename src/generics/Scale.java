package generics;

public class Scale<T extends Comparable> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int weight =  left.compareTo(right);
        if(weight > 0) {
            return left;
        } else if(weight < 0) {
            return right;
        }
        return null;
    }
}
