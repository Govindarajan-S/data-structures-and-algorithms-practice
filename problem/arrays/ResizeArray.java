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

    public void insert(int index, int value) {
        if (size == capacity) {
            arr = resize(capacity * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = value;
        size++;
    }

    public void prepend(int value) {
        insert(0, value);
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Array is Empty!");
        }
        int removedValue = arr[size - 1];
        if (size == capacity / 4) {
            arr = resize(capacity / 2);
        }
        size--;
        return removedValue;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Array Index is out of bounds!");
        }
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public void remove(int value) {
        int[] newArr = new int[capacity];
        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (arr[i] != value) {
                newArr[count++] = arr[i];
            }
        }
        size = count;
        arr = newArr;
        if (size == capacity / 4) {
            arr = resize(capacity / 2);
        }
    }

    public int find(int value) {
        for (int i = 0; i < size(); i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        testGetWithinRange();
        testGetLessThanZero();
        testGetGreaterThanSize();
        testInsertWhenNotFull();
        testInsertWhenFull();
        testInsertOnAlreadyAvailableValue();
        testPrepend();
        testPopWhenValueAvailable();
        testPopWhenValueNotAvailable();
        testDeleteWhenValueNotAvailable();
        testDeleteWhenValueAvailable();
        testRemoveWhenDuplicateValuesAvailable();
        testRemoveWhenUniqueValuesAvailable();
        testFindWhenValuePresent();
        testFindWhenValueNotPresent();
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

    public static void testInsertWhenNotFull() {
        ResizeArray resizeArray = new ResizeArray();
        resizeArray.insert(0, 1);
        resizeArray.insert(1, 2);
        resizeArray.insert(2, 3);
        resizeArray.insert(3, 4);
        resizeArray.insert(4, 5);
        resizeArray.insert(5, 6);
        for (int i = 0; i < resizeArray.size(); i++) {
            System.out.println(resizeArray.get(i));
        }
    }

    public static void testInsertWhenFull() {
        ResizeArray resizeArray = new ResizeArray();
        resizeArray.insert(0, 1);
        resizeArray.insert(1, 2);
        resizeArray.insert(2, 3);
        assert resizeArray.capacity() == 4;
        for (int i = 0; i < resizeArray.size(); i++) {
            System.out.println(resizeArray.get(i));
        }
        System.out.println("Capcity is " + resizeArray.capacity());
    }

    public static void testInsertOnAlreadyAvailableValue() {
        ResizeArray resizeArray = new ResizeArray();
        resizeArray.insert(0, 1);
        resizeArray.insert(1, 2);
        resizeArray.insert(2, 3);
        resizeArray.insert(2, 4);
        resizeArray.insert(4, 5);
        resizeArray.insert(5, 6);
        for (int i = 0; i < resizeArray.size(); i++) {
            System.out.println(resizeArray.get(i));
        }
    }

    public static void testPrepend() {
        ResizeArray resizeArray = new ResizeArray();
        resizeArray.prepend(1);
        resizeArray.prepend(2);
        resizeArray.prepend(3);
        resizeArray.prepend(4);
        resizeArray.prepend(5);
        resizeArray.prepend(6);
        for (int i = 0; i < resizeArray.size(); i++) {
            System.out.println(resizeArray.get(i));
        }
    }

    public static void testPopWhenValueAvailable() {
        ResizeArray resizeArray = new ResizeArray();
        resizeArray.addLast(10);
        resizeArray.insert(1, 8);
        resizeArray.insert(2, 16);
        resizeArray.insert(3, 9);
        for (int i = 0; i < resizeArray.size(); i = 0) {
            System.out.println(resizeArray.pop());
        }
    }

    public static void testPopWhenValueNotAvailable() {
        ResizeArray resizeArray = new ResizeArray();
        try {
            System.out.println(resizeArray.pop());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testDeleteWhenValueNotAvailable() {
        ResizeArray resizeArray = new ResizeArray();
        try {
            resizeArray.delete(-2);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testDeleteWhenValueAvailable() {
        ResizeArray resizeArray = new ResizeArray();
        resizeArray.addLast(1);
        resizeArray.addLast(2);
        resizeArray.addLast(3);
        resizeArray.addLast(4);
        resizeArray.addLast(5);
        resizeArray.delete(2);
        resizeArray.delete(3);
        for (int i = 0; i < resizeArray.size(); i++) {
            System.out.println(resizeArray.get(i));
        }
    }

    public static void testRemoveWhenDuplicateValuesAvailable() {
        ResizeArray resizeArray = new ResizeArray();
        resizeArray.addLast(1);
        resizeArray.addLast(1);
        resizeArray.addLast(2);
        resizeArray.addLast(2);
        resizeArray.addLast(2);
        resizeArray.remove(2);
        for (int i = 0; i < resizeArray.size(); i++) {
            System.out.println(resizeArray.get(i));
        }   
    }

    public static void testRemoveWhenUniqueValuesAvailable() {
        ResizeArray resizeArray = new ResizeArray();
        resizeArray.addLast(1);
        resizeArray.addLast(2);
        resizeArray.addLast(3);
        resizeArray.addLast(4);
        resizeArray.addLast(5);
        resizeArray.remove(1);
        for (int i = 0; i < resizeArray.size(); i++) {
            System.out.println(resizeArray.get(i));
        }
    }

    public static void testFindWhenValueNotPresent() {
        ResizeArray resizeArray = new ResizeArray();
        System.out.println(resizeArray.find(3));
    }

    public static void testFindWhenValuePresent() {
        ResizeArray resizeArray = new ResizeArray();
        resizeArray.addLast(1);
        resizeArray.addLast(2);
        resizeArray.addLast(3);
        resizeArray.addLast(4);
        resizeArray.addLast(5);
        System.out.println(resizeArray.find(3));
    }
}
