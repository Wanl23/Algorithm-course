package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        revertList();
    }

    public static void revertList() throws IOException {
        System.out.println("Enter string");
        String flag = "";
        while (flag != "exit") {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String in = bufferedReader.readLine();
            String[] arr = in.split("");
            MyLinkedList myLinkedList = new MyLinkedList();
            for (int i = arr.length - 1; i != -1; i--) {
                myLinkedList.addFirst(arr[i]);
            }
            if (in.equals("exit")) {
                flag = in;
                break;
            }
            while (!myLinkedList.isEmpty()) {
                System.out.print(myLinkedList.removeLast());
            }
            System.out.println();
        }
    }
}
