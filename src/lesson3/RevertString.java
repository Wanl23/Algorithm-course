package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RevertString {
    public static void main(String[] args) throws IOException {
//        revertStack();
        revertMyDec();

    }
        public static void revertMyDec() throws IOException {
        System.out.println("Enter string");
        String flag = "";
        while (flag != "exit") {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String in = bufferedReader.readLine();
            String[] arr = in.split("");
            Deque myDec = new Deque(arr.length);
            for (int i = arr.length - 1; i != -1; i--) {
                myDec.addFirst(arr[i]);
            }
            if (in.equals("exit")) {
                flag = in;
                break;
            }
            while (!myDec.isEmpty()) {
                System.out.print(myDec.removeLast());
            }
            System.out.println();
        }
    }

    public static void revertStack () throws IOException {
        System.out.println("Enter string");
        String flag = "";
        while (flag != "exit") {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String in = bufferedReader.readLine();
            Stack<String> stack = new Stack<>();
            String[] arr = in.split("");
            for (int i = 0; i < arr.length; i++) {
                stack.push(arr[i]);
            }
            if (in.equals("exit")) {
                flag = in;
                break;
            }
            while (!stack.empty()) {
                System.out.print(stack.pop());
            }
            System.out.println();
        }
    }


}
