package problem.stack;

import java.io.*;
import java.util.*;

public class SimpleTextEditor {

    public static ArrayList<String> stack = new ArrayList<String>();

    public static void append(String w) {
        if (stack.isEmpty()) {
            stack.add(w);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(stack.get(stack.size() - 1));
            sb.append(w);
            stack.add(sb.toString());
        }
    }

    public static void delete(int k) {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        } else {
            String s = stack.get(stack.size() - 1);
            s = s.substring(0, s.length() - k);
            stack.add(s);
        }
    }

    public static void undo() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        } else {
            stack.remove(stack.size() - 1);
        }
    }

    public static void print(int k) {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        } else {
            char[] c = stack.get(stack.size() - 1).toCharArray();
            System.out.println(c[k - 1]);
        }
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int queries = Integer.parseInt(br.readLine());
        int i = 0;
        String[] line;
        while (i < queries) {
            line = br.readLine().split(" ");
            switch(Integer.parseInt(line[0])) {
                case 1 : append(line[1]);
                            break;
                case 2 : delete(Integer.parseInt(line[1]));
                            break;
                case 3 : print(Integer.parseInt(line[1]));
                            break;
                case 4 : undo();
                            break;
            }
            i++;
        }
    }
}
