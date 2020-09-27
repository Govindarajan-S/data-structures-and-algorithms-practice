package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HappyLadyBug {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        HashMap<Character, ArrayList<Integer>> bugCounter = new HashMap<Character, ArrayList<Integer>>();
        char ladyBug;
        ArrayList<Integer> bugLocation;
        int n = b.length();
        for (int i = 0; i < n; i++) {
            ladyBug = b.charAt(i);
            if (bugCounter.containsKey(ladyBug)) {
                bugLocation = bugCounter.get(ladyBug);
                bugLocation.add(i);
            } else {
                bugLocation = new ArrayList<Integer>();
                bugLocation.add(i);
                bugCounter.put(ladyBug, bugLocation);
            }
        }
        ladyBug = '_';
        if (bugCounter.containsKey(ladyBug) && bugCounter.get(ladyBug).size() == n) {
            return "YES";
        }
        boolean isSingleLadyBug = false;
        int misMatchCount = 0;
        for (Map.Entry<Character, ArrayList<Integer>> bug : bugCounter.entrySet()) {
            bugLocation = bug.getValue();
            if (bug.getKey() != ladyBug) {
                if (bugLocation.size() < 2) {
                    isSingleLadyBug = true;
                }
                int i = 0, diff;
                while (i < bugLocation.size() - 1) {
                    diff = bugLocation.get(i + 1) - bugLocation.get(i);
                    if (diff > 1) {
                        misMatchCount++;
                    }
                    i++;
                }
            }
        }
        if (isSingleLadyBug) {
            return "NO";
        } else if (misMatchCount > 0 && !bugCounter.containsKey(ladyBug)) {
            return "NO";
        } else {
            return "YES";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
