package problem.arrays;

/**
 * ResizeArray class implements dynamic integer array.
 */
public class ResizeArray {

    private int[] arr;
    private int size = 0;
    private int capacity = 2;

    public ResizeArray() {
        arr = new int[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return arr[index];
    }

    public void addLast(int value) {
        if (size == capacity) {
            arr = resize(capacity * 2);
        }
        arr[size++] = value;
    }

    private int[] resize(int newCapacity) {
        capacity = newCapacity;
        int[] newArr = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    
    public static void main(String[] args) {
        testGetWithinRange();
        testGetLessThanZero();
        testGetGreaterThanSize();
    }

    private static void testGetLessThanZero() {
        ResizeArray resizeArray = new ResizeArray();
        try {
            System.out.println(resizeArray.get(-1));
        } catch (ArrayIndexOutOfBoundsException execption) {
            System.out.println("Array Index Out of Bounds");
        }
    }

    private static void testGetWithinRange() {
        ResizeArray resizeArray = new ResizeArray();
        resizeArray.addLast(1);
        resizeArray.addLast(2);
        resizeArray.addLast(3);
        resizeArray.addLast(4);
        resizeArray.addLast(5);
        for (int i = 0; i < resizeArray.size(); i++) {
            System.out.println(resizeArray.get(i));
        }
    }

    private static void testGetGreaterThanSize() {
        ResizeArray resizeArray = new ResizeArray();
        resizeArray.addLast(1);
        resizeArray.addLast(2);
        resizeArray.addLast(3);
        resizeArray.addLast(4);
        resizeArray.addLast(5);
        try {
            System.out.println(resizeArray.get(resizeArray.size()));
        } catch (ArrayIndexOutOfBoundsException execption) {
            System.out.println("Array Index Out of Bounds");
        }
    }
}
