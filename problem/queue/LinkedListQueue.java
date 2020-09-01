package problem.queue;

public class LinkedListQueue {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private String value;
        private Node next;

        public String getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(String value) {
            this(value, null);
        }

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public LinkedListQueue() {

    }

    public void enqueue(String value) {
        Node newNode = new Node(value, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        String value = head.getValue();
        head = head.getNext();
        size--;
        return value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String top() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return head.getValue();
    }

    public static void main(String[] args) {
        LinkedListQueue llQueue = new LinkedListQueue();
        llQueue.enqueue("1");
        llQueue.enqueue("2");
        System.out.println(llQueue.dequeue());
        llQueue.enqueue("3");
        llQueue.enqueue("4");
        llQueue.enqueue("5");
        System.out.println(llQueue.dequeue());
        System.out.println(llQueue.dequeue());
        System.out.println(llQueue.dequeue());
        System.out.println(llQueue.dequeue());
        llQueue.enqueue("6");
        System.out.println(llQueue.top());
        System.out.println(llQueue.dequeue());
    }
}