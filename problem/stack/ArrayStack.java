package problem.stack;

public class ArrayStack {
    private int capacity = 16;
    private int size = 0;
    private String[] stack;

    public ArrayStack() {
        stack = new String[capacity];
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new String[this.capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(String value) {
        if (size == capacity) {
            throw new RuntimeException("Stack is already full!");
        }
        stack[size] = value;
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return stack[--size];
    }

    public String top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return stack[size - 1];
    }

    public static void main(String[] args) {
        ArrayStack arrStack = new ArrayStack(4);
        arrStack.push("Hashirama");
        arrStack.push("Tobirama");
        arrStack.push("Minato");
        arrStack.push("Kushina");
        System.out.println("Last added Element is " + arrStack.pop());
        arrStack.push("Shikamaru");
        System.out.println("Last added Element is " + arrStack.pop());
        System.out.println("Last added Element is " + arrStack.pop());
        System.out.println("Last added Element is " + arrStack.pop());
        System.out.println("Last added Element is " + arrStack.top());
        System.out.println("Last added Element is " + arrStack.pop());
    }
}