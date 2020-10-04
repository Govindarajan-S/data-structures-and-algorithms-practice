package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LuckBalance {

    // Complete the luckBalance function below.
    static long luckBalance(int k, int[][] contests) {
        int n = contests.length;
        long sum = 0;
        int diff;
        long importantContestSum = 0;
        ArrayList<Integer> importantContest = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (contests[i][1] == 1) {
                importantContest.add(contests[i][0]);
            }
            sum = sum + contests[i][0];
        }
        int size = importantContest.size();
        if (size == 0 || size == k) {
            return sum;
        }
        diff = size - k;
        int[] importantContestArr = new int[size];
        for (int i = 0; i < size; i++) {
            importantContestArr[i] = importantContest.get(i);
        }
        Arrays.sort(importantContestArr);
        for (int i = 0; i < diff; i++) {
            importantContestSum = importantContestSum + importantContestArr[i];
        }
        sum = sum - 2 * importantContestSum;
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        long result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
