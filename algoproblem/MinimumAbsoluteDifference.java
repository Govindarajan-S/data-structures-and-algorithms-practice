package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDifference {

    // Complete the minimumAbsoluteDifference function below.
    static long minimumAbsoluteDifference(long[] arr) {
        Arrays.sort(arr);
        long min = Math.abs(arr[0]);
        int n = arr.length - 1;
        long diff;
        for (int i = 0; i < n; i++) {
            diff = Math.abs(arr[i + 1] - arr[i]);
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.valueOf(arrItems[i]);
            arr[i] = arrItem;
        }

        long result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

