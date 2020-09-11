package problem.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class DTZ {

    /*
     * Complete the downToZero function below.
     */
    static int downToZero(int n) {
        /*
         * Write your code here.
         */
        int steps = 0;
        int sqrtValue;
        LinkedList<Integer> stack;
        System.out.println("Input Value - " + n);
        while (n > 1) {
            sqrtValue = Double.valueOf(Math.sqrt(n)).intValue();
            int i = 2;
            stack = new LinkedList<Integer>();
            while (i <= sqrtValue) {
                if (n % i == 0) {
                    stack.addFirst(n / i);
                }
                i++;
            }
            if (stack.isEmpty()) {
                n = n - 1;
            } else {
                n = stack.removeFirst();
            }
            steps++;
        }
        if (n == 1) {
            return ++steps;
        }
        if (n == 0) {
            return steps;
        }
        return steps;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            int result = downToZero(n);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
