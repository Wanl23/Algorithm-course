package lesson5;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(exponentiation(2, 12));

        long start = System.currentTimeMillis();
        towers(20, 1, 2, 3);
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }

    public static int exponentiation(int x, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return exponentiation(x, n - 1) * x;
        else {
            int b = exponentiation(x, n / 2);
            return b * b;
        }
    }

    static void towers(int n, int from, int to, int additional) {
        if (n == 0) return;

        towers(n - 1, from, additional, to);
        System.out.println(from + " " + to);
        towers(n - 1, additional, to, from);
    }
}
