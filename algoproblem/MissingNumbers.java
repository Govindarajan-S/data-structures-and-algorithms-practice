package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MissingNumbers {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
        int n = brr.length;
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int count;
        for (int i = 0; i < n; i++) {
            if (countMap.containsKey(brr[i])) {
                count = countMap.get(brr[i]);
                count++;
                countMap.put(brr[i], count);
            } else {
                countMap.put(brr[i], 1);
            }
        }
        n = arr.length;
        for (int i = 0; i < n; i++) {
            count = countMap.get(arr[i]);
            count--;
            if (count == 0) {
                countMap.remove(arr[i]);
            } else {
                countMap.put(arr[i], count);
            }
        }
        n = countMap.size();
        int[] result = new int[n];
        count = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            result[count++] = entry.getKey();
        }
        Arrays.sort(result);
        return result;
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

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

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
