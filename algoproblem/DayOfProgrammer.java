package algoproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DayOfProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        int[] noOfDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int targetDay = 256;
        int days = 0;
        int diff;
        for (int i = 0; i < 8; i++) {
            days = days + noOfDays[i];
        }
        if (year <= 1917) {
            if (year % 4 == 0) {
                days++;
            }
        } else if (year == 1918) {
            days = days - 13;
        } else {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                days++;
            }
        }
        diff = targetDay - days;
        return diff + ".09." + year;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
