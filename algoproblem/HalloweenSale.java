package algoproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HalloweenSale {

    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int gamesAtCostD = (p - m) / d + 1;
        int spentAmount = p * gamesAtCostD - d * getDiffInCost(gamesAtCostD);
        if (spentAmount > s) {
            while (spentAmount > s) {
                gamesAtCostD--;
                spentAmount = p * gamesAtCostD - d * getDiffInCost(gamesAtCostD);
            }
            return gamesAtCostD;
        }
        int gamesAtCostM = (s - spentAmount) / m;
        return gamesAtCostD + gamesAtCostM;
    }

    static int getDiffInCost(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

