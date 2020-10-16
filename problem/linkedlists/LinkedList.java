package problem.linkedlists;

public class LinkedList {
    private class Node {
        private String value;
        private Node next;

        public Node(String value) {
            this(value, null);
        }

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public String getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private int size = 0;

    public LinkedList() {
        head = null;
    }

    public LinkedList(String value) {
        head = new Node(value);
        size++;
    }

    public String valueAt(int index) {
        int i = 1;
        Node current = head;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        return current.getValue();
    }

    public void pushFront(String value) {
        Node current = head;
        head = new Node(value, current);
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void pushBack(String value) {
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current = new Node(value);
        size++;
    }

    public String popBack() {
        String value;
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        value = current.getValue();
        current.setNext(null);
        size--;
        return value;
    }

    public String front() {
        if (isEmpty()) {
            return null;
        } else {
            return head.getValue();
        }
    }

    public String back() {
        if (isEmpty()) {
            return null;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            return current.getValue();
        }
    }

    public void insert(int index, String value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index cannot be less 0 or greter than size " + size);
        }
        int i = 1;
        Node current = head;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        current.setNext(new Node(value, current.getNext()));
        size++;
    }

    public void erase(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index cannot be less 0 or greter than size " + size);
        }
        int i = 1;
        Node current = head;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        current.setNext(current.getNext().getNext());
        size--;
    }

    public String valueAtNFromEnd(int n) {
        int index = size - n;
        if (index < 0) {
            throw new IllegalArgumentException("n cannot be greater than size " + size);
        }
        return valueAt(index);
    }

    public void reverse() {
        Node reversedPart = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = reversedPart;
            reversedPart = current;
            current = next;
        }
        head = reversedPart;
    }

    public void printValues() {
        Node current = head;
        while (current.getNext() != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
        System.out.println(current.getValue());
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.pushFront("5");
        ll.pushFront("4");
        ll.pushFront("3");
        ll.pushFront("2");
        ll.pushFront("1");
        ll.pushFront("0");
        System.out.println("Before Reversing the list");
        ll.printValues();
        ll.reverse();
        System.out.println("After reversing the list");
        ll.printValues();
        System.out.println("Value at index 2 is " + ll.valueAt(2));
        System.out.println("Value at 3 from last is " + ll.valueAtNFromEnd(3));
        ll.erase(3);
        ll.insert(3, "4");
        ll.pushBack("6");
        System.out.println("Pop Back value is " + ll.popBack());
        System.out.println("Head value is " + ll.front());
        System.out.println("Tail Value is " + ll.back());
    }
}
