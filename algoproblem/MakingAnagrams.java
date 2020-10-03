package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MakingAnagrams {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[] s1Counter = new int[26];
        int[] s2Counter = new int[26];
        char value;
        for (int i = 0; i < n1; i++) {
            value = s1.charAt(i);
            s1Counter[value - 97]++;
        }
        for (int i = 0; i < n2; i++) {
            value = s2.charAt(i);
            s2Counter[value - 97]++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            while (s1Counter[i] > 0 && s2Counter[i] > 0) {
                count += 2;
                s1Counter[i]--;
                s2Counter[i]--;
            }
        }
        int diff = Math.abs(n1 + n2 - count);
        return diff;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
