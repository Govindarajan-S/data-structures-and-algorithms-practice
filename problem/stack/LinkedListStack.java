package problem.stack;

public class LinkedListStack {
    private class Node {
        private String value;
        private Node next;
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
    }

    private Node head;
    private int size = 0;

    public void push(String value) {
        head = new Node(value, head);
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        String popedValue = head.getValue();
        head = head.getNext();
        size--;
        return popedValue;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return head.getValue();
    }

    public static void main(String[] args) {
        LinkedListStack llStack = new LinkedListStack();
        llStack.push("Hashirama");
        llStack.push("Tobirama");
        llStack.push("Minato");
        llStack.push("Kushina");
        System.out.println("Last added Element is " + llStack.pop());
        llStack.push("Shikamaru");
        System.out.println("Last added Element is " + llStack.pop());
        System.out.println("Last added Element is " + llStack.pop());
        System.out.println("Last added Element is " + llStack.pop());
        System.out.println("Last added Element is " + llStack.top());
        System.out.println("Last added Element is " + llStack.pop());
    }
}