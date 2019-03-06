package lesson2;

import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<Item> implements Iterable<Item> {
    private int capasity = 1;
    private Object[] list;
    private int size = 0;

    public MyArrayList(int capasity) {
        this.list = new Object[capasity];
    }

    public MyArrayList() {
        this.list = new Object[capasity];
    }

    public Item get(int index) {
        if (index >= 0 && index < list.length) {
            return (Item) list[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(Item item) {
        if (item != null) {
            list[size] = item;
            size++;
            if(size == list.length) {
                resize(list.length * 2);
            }
        }
    }

    public void resize(int capasity) {
        Object[] newList = new Object[capasity];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }

    public int indexOf(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(i != size - 1? list[i] + ", " : list[i]);
        }
        return stringBuilder.toString();
    }

    public boolean removeByIndex(int index) {
        if (index >= 0 && index < list.length) {
            for (int j = index; j < size - 1; j++) {
                list[j] = list[j+1];
            }
            list[size - 1] = null;
            size--;
            if (size == list.length / 4 && size > 0) {
                resize((list.length - 1) / 2);
            }
            return true;
        }
        return false;
    }


    public boolean remove(Item item) {
        if (item == null) {
            return false;
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].equals(item)) {
                return removeByIndex(i);
            }
        }
        return false;
    }

    public int size() {
        return list.length;
    }

    public boolean contains(Item item) {
        if (item != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i] != null && list[i].equals(item)) return true;
            }
        }
        return false;
    }

    public void set(int index, Item item) {
        if (index >=0 && index < list.length) {
            list[index] = item;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private void exch(int i, int j) {
        Object temp = list[i];
        list[i]= list[j];
        list[j] = temp;
    }

    private boolean less(Item item1, Item item2, Comparator<Item> cmp) {
        return cmp.compare(item1, item2) < 0;
    }

    public void selectionSort(Comparator<Item> cmp) {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less((Item) list[j], (Item) list[min], cmp)) {
                    min = j;
                }
            }
            exch(i, min);
        }
    }

    public void insertionSort(Comparator<Item> cmp) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less((Item) list[j], (Item) list[j - 1], cmp)) {
                    exch(j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public boolean binarySearch(Item item, Comparator<Item> cmp) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low = (high - low) / 2;
            if (cmp.compare(item, (Item) list[mid]) < 0) {
                high = mid - 1;
            }
            if (cmp.compare(item, (Item) list[mid]) > 0) {
                low = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<Item> {
        int corsor = 0;


        @Override
        public boolean hasNext() {
            return corsor != size;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            Item item = (Item) list[corsor];
            corsor++;
            return item;
        }
    }
}
