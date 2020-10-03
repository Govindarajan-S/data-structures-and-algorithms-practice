package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GameOfThronesI {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        int n = s.length();
        if (n == 1) {
            return "YES";
        }
        int[] sCounter = new int[26];
        char value;
        for (int i = 0; i < n; i++) {
            value = s.charAt(i);
            sCounter[value - 97]++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (sCounter[i] % 2 == 1) {
                count++;
                if (count > 1) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
