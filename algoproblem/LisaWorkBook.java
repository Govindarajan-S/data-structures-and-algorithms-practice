package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LisaWorkBook {

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int count, pageCount = 1;
        int specialCount = 0;
        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = 1; j <= arr[i]; j++) {
                if (count > k) {
                    count = 1;
                    pageCount++;
                }
                count++;
                if (j == pageCount) {
                    specialCount++;
                }
            }
            pageCount++;
        }
        return specialCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
