package algoproblem;

import java.util.Scanner;

public class SeparateTheNumbers {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        int n = s.length();
        boolean nextValueFound = false;
        boolean isBeautiful = true;
        long value = -1;
        String nextValue = "";
        long initialValue = Integer.valueOf(s.charAt(0));
        int i;
        int index;
        String nextValueString;
        if (n == 1) {
            System.out.println("NO");
            return;
        }
        for (i = 1; i <= n / 2; i++) {
            if (!nextValueFound) {
                value = Long.valueOf(s.substring(0, i));
                value++;
                nextValue = String.valueOf(value);
                if (i + nextValue.length() <= n) {
                    nextValueString = s.substring(i, i + nextValue.length());
                } else {
                    break;
                }
                if (nextValueString.equals(nextValue)) {
                    nextValueFound = true;
                    isBeautiful = true;
                    initialValue = value - 1;
                    index = i + nextValue.length();
                    while (index < n) {
                        value++;
                        nextValue = String.valueOf(value);
                        if (index + nextValue.length() <= n) {
                            nextValueString = s.substring(index, index + nextValue.length());
                        } else {
                            isBeautiful = false;
                            break;
                        }
                        if (!nextValueString.equals(nextValue)) {
                            isBeautiful = false;
                            nextValueFound = false;
                            break;
                        }
                        index = index + nextValue.length();
                    }
                }
            }
        }
        if (!nextValueFound) {
            System.out.println("NO");
            return;
        }
        if (!isBeautiful) {
            System.out.println("NO");
            return;
        } else {
            System.out.println("YES " + initialValue);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}

