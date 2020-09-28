package algoproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SuperReducedString {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        int n = s.length();
        ArrayList<Character> reducedCharList = new ArrayList<Character>();
        Character singleChar;
        int lastElement;
        for (int i = 0; i < n; i++) {
            singleChar = s.charAt(i);
            if (reducedCharList.isEmpty()) {
                reducedCharList.add(singleChar);
            } else {
                lastElement = reducedCharList.size() - 1;
                if (reducedCharList.get(lastElement) == singleChar) {
                    reducedCharList.remove(lastElement);
                } else {
                    reducedCharList.add(singleChar);
                }
            }
        }
        if (reducedCharList.isEmpty()) {
            return "Empty String";
        }
        char[] reducedCharArr = new char[reducedCharList.size()];
        int i = 0;
        for (char val : reducedCharList) {
            reducedCharArr[i++] = val;
        }
        String reducedString = String.valueOf(reducedCharArr);
        return reducedString;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

