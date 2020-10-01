package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FunnyString {

    // Complete the funnyString function below.
    static String funnyString(String s) {
        int n = s.length();
        if (n == 2) {
            return "Funny";
        }
        char[] funnyArr = s.toCharArray();
        int diff1, diff2;
        int len = n % 2 == 0 ? n / 2 + 1: n / 2;
        for (int i = 0; i < len; i++) {
            diff1 = Math.abs(funnyArr[i] - funnyArr[i + 1]);
            diff2 = Math.abs(funnyArr[n - i - 2] - funnyArr[n - i - 1]);
            if (diff1 != diff2) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

