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

    public String popFront() {
        if (head == null) {
            throw new NoSuchElementException("Linked List is Empty!");
        } else {
            String value = head.value;
            head = head.next;
            size--;
            return value;
        }
    }

    public void pushBack(String value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            Node prev, current;
            prev = null;
            current = head;
            while (current != null) {
                prev = current;
                current = current.next;
            }
            prev.next = newNode;
            size++;
        }
    }

    public String popBack() {
        if (head == null) {
            throw new NoSuchElementException("Linked List is Empty!");
        } else {
            Node prev, current;
            prev = null;
            current = head;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            String value = current.value;
            size--;
            if (prev != null) {
                prev.next = null;
            }
            return value;
        }
    }

    public static void main(String[] args) {
        testPushFront();
        testValueAtUsingValidIndex();
        testValueAtUsingInvalidIndex();
        testPopFrontWhenEmpty();
        testPopFrontWhenNonEmpty();
        testPushBack();
        testPopBackWhenEmpty();
        testPopBackWhenNonEmpty();
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

    public static void testPopFrontWhenEmpty() {
        LinkedList llist = new LinkedList();
        try {
            System.out.println(llist.popFront());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testPopFrontWhenNonEmpty() {
        LinkedList llist = new LinkedList();
        llist.pushBack("1");
        llist.pushBack("2");
        llist.pushBack("3");
        llist.pushBack("4");
        llist.pushBack("5");
        llist.popFront();
        llist.popFront();
        llist.popFront();
        llist.popFront();
        llist.popFront();
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testPushBack() {
        LinkedList llist = new LinkedList();
        llist.pushBack("1");
        llist.pushBack("2");
        llist.pushBack("3");
        llist.pushBack("4");
        llist.pushBack("5");
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    
    public static void testPopBackWhenEmpty() {
        LinkedList llist = new LinkedList();
        try {
            llist.popBack();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testPopBackWhenNonEmpty() {
        LinkedList llist = new LinkedList();
        llist.pushBack("1");
        llist.pushBack("2");
        llist.pushBack("3");
        llist.pushBack("4");
        llist.pushBack("5");
        System.out.println(llist.popBack());
        System.out.println(llist.popBack());
        System.out.println(llist.popBack());
        System.out.println(llist.popBack());
        System.out.println(llist.popBack());
    }
}
