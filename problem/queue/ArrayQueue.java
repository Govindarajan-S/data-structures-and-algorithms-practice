package problem.queue;

public class ArrayQueue {
    private String[] queue;
    private int size = 0;
    private int read = 0;
    private int capacity = 16;

    public ArrayQueue() {
        queue = new String[capacity];
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[this.capacity];
    }

    public void enqueue(String value) {
        int write;
        if (size < capacity) {
            write = (read + size) % capacity;
            queue[write] = value;
            size++;
        } else {
            throw new RuntimeException("Queue is full!");
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        String value = queue[read];
        queue[read] = null;
        read = (read + 1) % capacity;
        size--;
        return value;
    }

    public String top() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return queue[read];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        ArrayQueue arrQueue = new ArrayQueue(4);
        arrQueue.enqueue("1");
        arrQueue.enqueue("2");
        System.out.println(arrQueue.dequeue());
        arrQueue.enqueue("3");
        arrQueue.enqueue("4");
        arrQueue.enqueue("5");
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.dequeue());
        arrQueue.enqueue("6");
        System.out.println(arrQueue.top());
        System.out.println(arrQueue.dequeue());
    }
}