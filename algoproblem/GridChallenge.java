package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {
        int n = grid.length;
        int length = grid[0].length();
        char[][] matrix = new char[n][length];
        for (int i = 0; i < n; i++) {
            matrix[i] = grid[i].toCharArray();
            Arrays.sort(matrix[i]);
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[j][i] > matrix[j + 1][i]) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            String result = gridChallenge(grid);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
