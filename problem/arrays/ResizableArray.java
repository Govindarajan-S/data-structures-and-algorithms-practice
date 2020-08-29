package problem.arrays;

public class ResizableArray {
    private String[] arr;
    private int size = 0;
    private int capacity = 8;

    public ResizableArray() {
        arr = new String[capacity];
    }

    public ResizableArray(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Array size cannot be less than or equal to 0");
        }
        while (n > capacity) {
            capacity *= 2;
        }
        arr = new String[capacity];
    }

    public ResizableArray(String[] items) {
        this(items.length);
        arr = items;
        size = items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public String valueAt(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("There is no value present at index " + index);
        }
        return arr[index];
    }

    public void push(String value) {
        if (size == capacity) {
            arr = resize(capacity * 2);
        }
        arr[size++] = value;
    }

    public void insert(int index, String value) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("There is no such index " + index);
        }
        if (size == capacity) {
            arr = resize(capacity * 2);
        }
        for (int i = ++size; i > index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = value;
        size++;
    }

    public void prepend(String value) {
        this.insert(0, value);
    }

    public String pop() {
        String popedValue = arr[--size];
        arr[size] = null;
        if (size == capacity / 4) {
            arr = resize(capacity / 2);
        }
        return popedValue;
    }

    public void delete(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("There is no such index " + index);
        }
        for (int i = index - 1; i < size; i++) {
            arr[index] = arr[index + 1];
            size--;
        }
        if (size == capacity / 4) {
            arr = resize(capacity / 2);
        }
    }

    public void remove(String value) {
        int i = 0;
        int count = 0;
        String[] newArr = new String[capacity];
        while (i < size) {
            if (!arr[i].equals(value)) {
                newArr[count] = arr[i];
                count++;
            }
            else {
                size--;
            }
            i++;
        }
        arr = newArr;
        if (size == capacity / 4) {
            arr = resize(capacity / 2);
        }
    }

    public int find(String value) {
        int indexOfValue = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(value)) {
                indexOfValue = i;
                break;
            }
        }
        return indexOfValue;
    }

    private String[] resize(int resizeCapacity) {
        capacity = resizeCapacity;
        String[] oldArr = arr;
        arr = new String[capacity];
        int resize = oldArr.length > capacity ? capacity : oldArr.length;
        for (int i = 0; i < resize; i++) {
            arr[i] = oldArr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        ResizableArray resArr = new ResizableArray(4);
        resArr.push("Naruto");
        resArr.push("Sasuke");
        resArr.push("Sakura");
        resArr.push("Kakashi");
        assert resArr.capacity == 8;
        resArr.pop();
        resArr.pop();
        resArr.pop();
        assert resArr.capacity == 2;
        resArr.push("Jiraya");
        resArr.push("Tsunade");
        resArr.push("Orochimaru");
        assert resArr.capacity == 8;
        assert resArr.find("Orochimaru") == 3;
        assert resArr.find("Mighty Guy") == -1;
        resArr.push("Orochimaru");
        resArr.push("Orochimaru");
        resArr.push("Orochimaru");
        resArr.push("Hiruzan Sarutobi");
        resArr.remove("Orochimaru");
        assert resArr.find("Orochimaru") == -1;
        assert resArr.size == 4;
        resArr.delete(4);
        assert resArr.find("Hiruzen") == -1;
        resArr.insert(3, "Itachi");
        resArr.prepend("Nagato");
        assert resArr.valueAt(0).equals("Nagato");
    }
}
