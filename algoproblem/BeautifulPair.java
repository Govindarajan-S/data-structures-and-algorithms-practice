package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BeautifulPair {

    // Complete the beautifulPairs function below.
    static int beautifulPairs(int[] A, int[] B) {
        int n = A.length;
        boolean[] aVisited = new boolean[n];
        boolean[] bVisited = new boolean[n];
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> pair;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!bVisited[j]) {
                    if (A[i] == B[j]) {
                        pair = new ArrayList<Integer>();
                        pair.add(i);
                        pair.add(j);
                        pairs.add(pair);
                        aVisited[i] = true;
                        bVisited[j] = true;
                        break;
                    }
                }
            }
        }
        int x = -1;
        int y = -1;
        for (int i = 0; i < n; i++) {
            if (!aVisited[i]) {
                x = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!bVisited[i]) {
                y = i;
                B[y] = A[x];
            }
        }
        if (x != -1 && y != -1) {
            pair = new ArrayList<Integer>();
            pair.add(x);
            pair.add(y);
            pairs.add(pair);
        } else if (y == -1) {
            return pairs.size() - 1;
        }
        return pairs.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(AItems[i]);
            A[i] = AItem;
        }

        int[] B = new int[n];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = beautifulPairs(A, B);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
