package problem.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EqualStacks {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        int[] totalArr = {0, 0, 0};
        totalArr[0] = calculateTotal(h1);
        totalArr[1] = calculateTotal(h2);
        totalArr[2] = calculateTotal(h3);
        int[][] stackArr = {h1, h2, h3};
        int[] topArr = {0, 0, 0};
        int[] stack = h1;
        int top = topArr[0];
        int height = 0;
        int minIndex = 0, maxIndex = 0;
        int minValue = 0, maxValue = 0;
        int[] minMaxArr = findMinMax(totalArr);
        boolean minMaxChanged = true;
        while(true) {
            if (minMaxChanged) {
                if (minMaxArr[0] == minMaxArr[1]) {
                    height = totalArr[minMaxArr[0]];
                    break;
                }
                maxIndex = minMaxArr[1];
                minIndex = minMaxArr[0];
                maxValue = totalArr[maxIndex];
                minValue = totalArr[minIndex];
                stack = stackArr[maxIndex];
                top = topArr[maxIndex];
                minMaxChanged = false;
            }
            if (maxValue > minValue) {
                maxValue = maxValue - stack[top];
                if (top + 1 < stack.length) {
                    top++;
                }
            } else {
                totalArr[maxIndex] = maxValue;
                topArr[maxIndex] = top;
                minMaxArr = findMinMax(totalArr);
                minMaxChanged = true;
            }
        }
        return height;
    }

    static int calculateTotal(int[] stack) {
        int n = stack.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += stack[i];
        }
        return total;
    }

    static int[] findMinMax(int[] arr) {
        int n = arr.length;
        int[] minMaxArr = new int[2];
        int min = 0, max = 0;
        for (int i = 1; i < n; i++) {
            if (arr[min] > arr[i]) {
                min = i;
            }
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        minMaxArr[0] = min;
        minMaxArr[1] = max;
        return minMaxArr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = bufferedReader.readLine().split(" ");
        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }
        int[] h2 = new int[n2];

        String[] h2Items = bufferedReader.readLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = bufferedReader.readLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
        bufferedReader.close();
    }
}
