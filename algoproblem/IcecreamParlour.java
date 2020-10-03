package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class IcecreamParlour {

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {
        int[] possibleValues = new int[m];
        HashMap<Integer, ArrayList<Integer>> location = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> position;
        int[] result = new int[2];
        int value;
        int sum;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            value = arr[i];
            if (value < m) {
                possibleValues[value] = value;
                if (location.containsKey(value)) {
                    position = location.get(value);
                    position.add(i + 1);
                } else {
                    position = new ArrayList<Integer>();
                    position.add(i + 1);
                    location.put(value, position);
                }
            }
        }
        int length = m / 2;
        for (int i = 1, j = m - 1; i <= length && j >= length; i++, j--) {
            if (possibleValues[i] == 0 || possibleValues[j] == 0) {
                continue;
            }
            sum = possibleValues[i] + possibleValues[j];
            if (sum == m) {
                result[0] = location.get(possibleValues[i]).get(0);
                if (i == j) {
                    result[1] = location.get(possibleValues[j]).get(1);
                } else {
                    result[1] = location.get(possibleValues[j]).get(0);
                }
                if (result[0] > result[1]) {
                    int temp = result[0];
                    result[0] = result[1];
                    result[1] = temp;
                }
                break;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
