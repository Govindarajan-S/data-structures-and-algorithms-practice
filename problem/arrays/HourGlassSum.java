package problem.arrays;

public class HourGlassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max = 0;
        int hourGlassSum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    hourGlassSum += arr[i][j+k] + arr[i + 2][j + k];
                }
                hourGlassSum += arr[i + 1][j + 1];
                if (i == 0 && j == 0 || hourGlassSum > max) {
                    max = hourGlassSum;
                }
                hourGlassSum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = {
            { -9, -9, -9, 1, 1, 1 },
            { 0, -9, 0, 4, 3, 2 },
            { -9, -9, -9, 1, 2, 3 },
            { 0, 0, 8, 6, 6, 0 },
            { 0, 0, 0, -2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 },
        };
        int[][] arr2 = {
            { 1, 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0 },
            { 1, 1, 1, 0, 0, 0 },
            { 0, 0, 2, 4, 4, 0 },
            { 0, 0, 0, 2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 }
        };
        int result = hourglassSum(arr);
        System.out.println(result);
        result = hourglassSum(arr2);
        System.out.println(result);
    }
}