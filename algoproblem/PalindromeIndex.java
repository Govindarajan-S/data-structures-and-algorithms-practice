package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PalindromeIndex {

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        int n = s.length();
        int index = - 1;
        if (n == 1) {
            return index;
        }
        int length = n %  2 == 0 ? n / 2 : n / 2 + 1;
        int lastElement = n - 1;
        int[] indexes = new int[2];
        boolean indexFound = false;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != s.charAt(lastElement - i)) {
                indexFound = true;
                indexes[0] = i;
                indexes[1] = lastElement - i;
                break;
            }
        }
        if (indexFound) {
            indexFound = false;
            String s1 = s.substring(0, indexes[0]) + s.substring(indexes[0] + 1, n);
            String s2 = s.substring(0, indexes[1]) + s.substring(indexes[1] + 1, n);
            n = s1.length();
            length = n %  2 == 0 ? n / 2 : n / 2 + 1;
            lastElement = n - 1;
            for (int i = 0; i < length; i++) {
                if (s1.charAt(i) != s1.charAt(lastElement - i)) {
                    indexFound = true;
                    break;
                }
            }
            if (indexFound) {
                indexFound = false;
                for (int i = 0; i < length; i++) {
                    if (s2.charAt(i) != s2.charAt(lastElement - i)) {
                        indexFound = true;
                        break;
                    }
                }
            } else {
                return indexes[0];
            }
            if (indexFound) {
                index = -1;
                return index;
            } else {
                return indexes[1];
            }
        } else {
            return index;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
