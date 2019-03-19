package lesson6;

public class Main {
    public static void main(String[] args) {
        MyTreeMap<Character, Integer> tree = new MyTreeMap<>();
        boolean flag = false;
        while (!flag) {
            for (int i = 0; i < 22; i++) {
                Character key = (char) (i + 65);
                Integer value = (-100 + (int) (Math.random() * (100 - (-100))));
                tree.put(key, value);
            }
            flag = tree.isBalanced();
            System.out.println(tree.isBalanced());
        }
    }
}
