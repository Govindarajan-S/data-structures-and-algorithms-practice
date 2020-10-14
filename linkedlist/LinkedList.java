package linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String valueAt(int index) {
        Node current = head;
        int i = 0;
        while (i < index && current != null) {
            current = current.next;
            i++;
        }
        if (current == null) {
            throw new NoSuchElementException("There is no such index " +  index);
        } else {
            return current.value;
        }
    }

    public void pushFront(String value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public static void main(String[] args) {
        testPushFront();
        testValueAtUsingValidIndex();
        testValueAtUsingInvalidIndex();
    }

    public static void testPushFront() {
        LinkedList llist = new LinkedList();
        llist.pushFront("1");
        llist.pushFront("2");
        llist.pushFront("3");
        llist.pushFront("4");
        llist.pushFront("5");
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testValueAtUsingValidIndex() {
        LinkedList llist = new LinkedList();
        llist.pushFront("1");
        llist.pushFront("2");
        llist.pushFront("3");
        llist.pushFront("4");
        llist.pushFront("5");
        System.out.println(llist.valueAt(0));
        System.out.println(llist.valueAt(1));
        System.out.println(llist.valueAt(2));
        System.out.println(llist.valueAt(3));
        System.out.println(llist.valueAt(4));
    }

    public static void testValueAtUsingInvalidIndex() {
        LinkedList llist = new LinkedList();
        llist.pushFront("1");
        llist.pushFront("2");
        llist.pushFront("3");
        llist.pushFront("4");
        llist.pushFront("5");
        try {
            System.out.println(llist.valueAt(5));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
