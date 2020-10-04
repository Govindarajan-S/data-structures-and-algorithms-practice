package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumPerimeterTriangle {

    // Complete the maximumPerimeterTriangle function below.
    static long[] maximumPerimeterTriangle(long[] sticks) {
        Arrays.sort(sticks);
        long[] values = new long[3];
        boolean nonDegenrateTriangle = false;
        long perimeter;
        long s1, s2, s3;
        long maxPerimeter = -1;
        int n = sticks.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    s1 = sticks[i];
                    s2 = sticks[j];
                    s3 = sticks[k];
                    if ((s1 + s2 > s3) && (s1 + s3 > s2) && (s2 + s3 > s1)) {
                        nonDegenrateTriangle = true;
                        perimeter = s1 + s2 + s3;
                        if (perimeter > maxPerimeter) {
                            maxPerimeter = perimeter;
                            values[0] = s1;
                            values[1] = s2;
                            values[2] = s3;
                        } else if (perimeter == maxPerimeter) {
                            if (s3 > values[2]) {
                                values[0] = s1;
                                values[1] = s2;
                                values[2] = s3;
                            } else if (s3 == values[2]) {
                                if (s1 > values[0]) {
                                    values[0] = s1;
                                    values[1] = s2;
                                    values[2] = s3;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!nonDegenrateTriangle) {
            long[] result = { -1 };
            return result;
        } else {
            return values;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] sticks = new long[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        long[] result = maximumPerimeterTriangle(sticks);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

