package problem.stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        // take a value and loop left until there is value > current and add k
        // loop right until there is value > current and add k
        int n = h.length;
        long value;
        long max = -1;
        long area;
        long adj;
        for (int i = 0; i < n; i++) {
            adj = 1;
            value = h[i];
            for (int j = i - 1; j >= 0; j--) {
                if (value <= h[j]) {
                    adj++;
                } else {
                    break;
                }
            }
            for (int k = i + 1; k < n; k++) {
                if (value <= h[k]) {
                    adj++;
                } else {
                    break;
                }
            }
            area = adj * value;
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

