package problem.binary_search;

public class BinarySearch {
    public int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] >  key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1};
        BinarySearch bs = new BinarySearch();
        int index = bs.binarySearch(arr, 1);
        if (index == -1) {
            System.out.println("Value 1 is not found!");
        } else {
            System.out.println("Value 1 is found!");
        }
        index = bs.binarySearch(arr, 2);
        if (index == -1) {
            System.out.println("Value 2 is not found!");
        } else {
            System.out.println("Value 2 is found!");
        }
    }
}