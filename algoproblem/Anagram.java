package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Anagram {

    // Complete the anagram function below.
    static int anagram(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return -1;
        }
        boolean[] alphabet = new boolean[26];
        int[] alphabetCount = new int[26];
        char value;
        int diff;
        int count1 = 0;
        int count2 = 0;
        int length = n / 2;
        int index;
        for (int i = 0; i < length; i++) {
            value = s.charAt(i);
            index = value - 97;
            if (!alphabet[index]) {
                alphabet[index] = true;
            }
            alphabetCount[index]++;
        }
        for (int i = length; i < n; i++) {
            value = s.charAt(i);
            index = value - 97;
            if (alphabet[index] && alphabetCount[index] > 0) {
                count2++;
                alphabetCount[index]--;
            }
        }
        diff = Math.abs(length - count2);
        return diff;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

