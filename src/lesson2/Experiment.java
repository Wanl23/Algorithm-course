package lesson2;


public class Experiment {
    public static void main(String[] args) {
        int iteration = 10;
        int listSize = 10000;
        int numberRestriction = 10000;
        System.out.println("Number-SelectionSort-InsertionSort");
        for (int j = 0; j < iteration; j++) {
            System.out.print("  " + j + "         ");

            MyArrayList testList1 = new MyArrayList();
            for (int i = 0; i < listSize; i++) {
                testList1.add((int)(Math.random() * numberRestriction));
            }

            MyArrayList testList2 = new MyArrayList();
            for (int i = 0; i < listSize; i++) {
                testList2.add((int)(Math.random() * numberRestriction));
            }

            long start1 = System.currentTimeMillis();
            testList1.selectionSort(new IntegerCmp());
            long end1 = System.currentTimeMillis();
            System.out.print(end1 - start1 + "            ");

            long start2 = System.currentTimeMillis();
            testList1.insertionSort(new IntegerCmp());
            long end2 = System.currentTimeMillis();
            System.out.println(end2 - start2);

        }


    }
}
