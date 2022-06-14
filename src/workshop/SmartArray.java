package workshop;

import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    int[] data;
    int size;
    int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }
    public void add(int element) {
        if(this.size == this.capacity) {
            this.resize();
        }
        this.data[this.size++] = element;
    }
    int get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= this.size) {
            String message = String.format("index %d out of bounds for length %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    public int remove(int index) {
        checkIndex(index);
        int item = this.data[index];
        this.size--;
        if(this.size <= this.capacity / 4) {
            shrink();
        }
        return item;
    }
    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if(this.data[i] == element) {
                return true;
            }
        }
        return false;
    }
    public void add(int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        if(firstIndex == this.size - 1) {
            add(this.data[this.size -1 ]);
            this.data[this.size-2] = secondIndex;
        } else {
            this.size++;
            shiftRight(firstIndex);
            this.data[firstIndex] = secondIndex;
        }
    }
    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    private void resize() {
        this.capacity *= 2;
        int[] copy = new int[this.capacity];
        for (int i = 0; i < this.data.length ; i++) {
            copy[i] = this.data[i];
        }
        this.data = copy;
    }

    private void shrink() {
        this.capacity /= 2;
        int[] copy = new int[this.capacity];

        for (int i = 0; i <this.size ; i++) {
            copy[i] = this.data[i];
        }
        this.data = copy;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i+1];
        }
        this.data[size-1] = 0;
    }

    private void shiftRight(int index) {
        for (int i = this.size-1; i > index ; i--) {
            this.data[i] = this.data[i-1];
        }
    }

}
