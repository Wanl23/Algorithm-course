package lesson2;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Character> list = new MyArrayList();
        list.add('e');
        list.add('w');
        list.add('r');
        list.add('y');
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.indexOf('w'));
        list.removeByIndex(1);
        System.out.println(list);
        list.remove('w');
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.contains('d'));
        System.out.println(list.contains('w'));
        list.set(0, 'v');
        System.out.println(list);

//        Iterator<Character> iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.print(iter.next() + ", ");
//        }

//        list.selectionSort(Character::compareTo);
//        System.out.println(list);

        list.insertionSort(new CharCmp());
        System.out.println(list);

    }
}
