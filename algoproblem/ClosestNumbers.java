package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {

    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> minimumAbsoluteDiff = new ArrayList<Integer>();
        int n = arr.length;
        int min = arr[1] - arr[0];
        int diff;
        for (int i = 1; i < n - 1; i++) {
            diff = arr[i + 1] - arr[i];
            if (diff < min) {
                min = diff;
                minimumAbsoluteDiff = new ArrayList<Integer>();
                minimumAbsoluteDiff.add(arr[i]);
                minimumAbsoluteDiff.add(arr[i + 1]);
            } else if (diff == min) {
                minimumAbsoluteDiff.add(arr[i]);
                minimumAbsoluteDiff.add(arr[i + 1]);
            }
        }
        int length = minimumAbsoluteDiff.size();
        int[] absoluteDiff = new int[length];
        for (int i = 0; i < length; i++) {
            absoluteDiff[i] = minimumAbsoluteDiff.get(i);
        }
        return absoluteDiff;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = closestNumbers(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
