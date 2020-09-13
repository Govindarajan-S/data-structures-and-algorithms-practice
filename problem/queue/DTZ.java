package problem.queue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class DTZ {

    static int[] minMove = new int[1000001];
    static void computeMinMove() {
        for (int i = 1; i < minMove.length; i++) {
            minMove[i] = minMove[i - 1] + 1;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    minMove[i] = Math.min(minMove[i], minMove[i / j] + 1);
                }
            }
        }
    }

    static int downToZero(int n) {
        return minMove[n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(scanner.nextLine().trim());
        computeMinMove();
        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = downToZero(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}