package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        int count = 0;
        if (p == n || p == 1) {
            return count;
        }
        int fromBack;
        if (n % 2 == 0) {
            if (p % 2 == 0) {
                fromBack = (n - p) / 2;
            } else {
                fromBack = (n - p) / 2 + 1;
            }
        } else {
            fromBack = (n - p) / 2;
        }
        int fromFront = p / 2;
        if (fromFront < fromBack) {
            count = fromFront;
        } else {
            count = fromBack;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}