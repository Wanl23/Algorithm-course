package lesson3;


import java.util.Arrays;

public class MyDec<Item> {
    private static final int DEFAULT_SIZE = 1, GROW_COF = 2;

    private Object[] array;
    private int elementsCount = 0;

    public MyDec() {
        array = new Object[DEFAULT_SIZE];
    }

    public void addFirst(Item item) {
        ensureCapacity();
        System.arraycopy(array, 0, array, 1, elementsCount);
        array[0] = item;
        elementsCount++;
    }

    public void addLast(Item item) {
        ensureCapacity();
        array[elementsCount++] = item;
    }

    public boolean isEmpty() {
        return elementsCount == 0;
    }

    private void ensureCapacity() {
        if (elementsCount + 1 > array.length) {
            array = Arrays.copyOf(array, array.length * GROW_COF);
        }
    }
}