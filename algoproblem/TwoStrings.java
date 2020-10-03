package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        int n1 = s1.length();
        int[] s1Counter = new int[26];
        int n2 = s2.length();
        char value;
        for(int i = 0; i < n1; i++) {
            value = s1.charAt(i);
            s1Counter[value - 97]++; 
        }
        int count = 0;
        for (int i = 0; i < n2; i++) {
            value = s2.charAt(i);
            if (s1Counter[value - 97] > 0) {
                count++;
            }
        }
        if (count > 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
