package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class JimAndTheOrder {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
        int n = orders.length;
        long[][] serveTime = new long[n][2];
        long[] t = new long[n];
        int[] index = new int[n];
        int i = 0;
        while (i < n) {
            serveTime[i][0] = orders[i][0] + orders[i][1];
            t[i] = serveTime[i][0];
            serveTime[i][1] = ++i;
        }
        Arrays.sort(t);
        i = 0;
        int j;
        while (i < n) {
            j = 0;
            while (j < n) {
                if (t[i] == serveTime[j][0]) {
                    index[i] = (int) serveTime[j][1];
                    serveTime[j][0] = -1;
                    break;
                }
                j++;
            }
            i++;
        }
        return index;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

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

