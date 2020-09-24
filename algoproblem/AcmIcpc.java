package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AcmIcpc {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int knowledge;
        int[] countMax = {0, 1};
        int n = topic.length;
        int m = topic[0].length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                knowledge = 0;
                for (int k = 0; k < m; k++) {
                    if (topic[i].charAt(k) == '1' || topic[j].charAt(k) == '1') {
                        knowledge++;
                    }
                }
                if (countMax[0] < knowledge) {
                    countMax[0] = knowledge;
                    countMax[1] = 1;
                } else if (countMax[0] == knowledge) {
                    countMax[1]++;
                }
            }
        }
        return countMax;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
