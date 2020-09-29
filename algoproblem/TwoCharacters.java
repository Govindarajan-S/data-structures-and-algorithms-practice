package algoproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class TwoCharacters {

    // Complete the alternate function below.
    static int alternate(String s) {
        int n = s.length();
        int max = 0;
        ArrayList<Character> uniqueList = getUniqueCharacters(s, n);
        int uniqueElements = uniqueList.size();
        if (uniqueElements == 1) {
            return max;
        }
        ArrayList<String> permutation = getPermutationOfCharacters(uniqueList, uniqueElements);
        ArrayList<String> reducedAlternatingStrings = getReducedAlternatingStrings(uniqueList, permutation, s);
        max = getMaxAlternatingString(reducedAlternatingStrings, max);
        return max;
    }

    static int getMaxAlternatingString(ArrayList<String> reducedAlternatingStrings, int max) {
        ArrayList<Character> stack;
        boolean isAlternating;
        int length;
        int lastElement;
        char value;
        for (String alternatingString: reducedAlternatingStrings) {
            stack = new ArrayList<Character>();
            isAlternating = true;
            length = alternatingString.length();
            for (int i = 0; i < length; i++) {
                value = alternatingString.charAt(i);
                if (stack.isEmpty()) {
                    stack.add(value);
                } else {
                    lastElement = stack.size() - 1;
                    if (stack.get(lastElement) == value) {
                        isAlternating = false;
                        break;
                    } else {
                        stack.add(value);
                    }
                }
            }
            if (isAlternating) {
                if (stack.size() > max) {
                    max = stack.size();
                }
            }
        }
        return max;
    }

    static ArrayList<String> getReducedAlternatingStrings(ArrayList<Character> uniqueList, ArrayList<String> permutation, String s) {
        int length = permutation.size();
        String cPermutation;
        String s1;
        ArrayList<String> reducedAlternatingStrings = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            s1 = s;
            for (Character uniqueChar: uniqueList) {
                cPermutation = permutation.get(i);
                if (cPermutation.charAt(0) != uniqueChar &&
                    cPermutation.charAt(1) != uniqueChar) {
                        s1 = s1.replaceAll(String.valueOf(uniqueChar), "");
                    }
            }
            reducedAlternatingStrings.add(s1);
        }
        return reducedAlternatingStrings;
    }

    static ArrayList<String> getPermutationOfCharacters(ArrayList<Character> uniqueList, int uniqueElements) {
        ArrayList<String> permutation = new ArrayList<String>();
        char[] permutationArr = new char[2];
        for (int i = 0; i < uniqueElements - 1; i++) {
            for (int j = i + 1; j < uniqueElements; j++) {
                permutationArr[0] = uniqueList.get(i);
                permutationArr[1] = uniqueList.get(j);
                permutation.add(String.valueOf(permutationArr));
            }
        }
        return permutation;
    }

    static ArrayList<Character> getUniqueCharacters(String s, int length) {
        char value;
        HashMap<Character, Integer> uniqueMap = new HashMap<Character, Integer>();
        ArrayList<Character> uniqueList = new ArrayList<Character>();
        for (int i = 0; i < length; i++) {
            value = s.charAt(i);
            if (!uniqueMap.containsKey(value)) {
                uniqueMap.put(value, i);
                uniqueList.add(value);
            }
        }
        return uniqueList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
