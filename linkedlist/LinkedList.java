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

    public String front() {
        if (head == null) {
            return null;
        } else {
            return head.value;
        }
    }

    public String back() {
        if (head == null) {
            return null;
        } else {
            Node prev, current;
            prev = null;
            current = head;
            while (current != null) {
                prev = current;
                current = current.next;
            }
            return prev.value;
        }
    }

    public void insert(int index, String value) {
        Node newNode = new Node(value);
        Node prev, current;
        prev = null;
        current = head;
        int i = 0;
        while (i < index && current != null) {
            prev = current;
            current = current.next;
            i++;
        }
        if (i == index) {
            if (prev == null) {
                prev = newNode;
                head = prev;
            } else {
                prev.next = newNode;
            }
            newNode.next = current;
            size++;
        } else {
            throw new NoSuchElementException("There is no such index " + index);
        }
    }

    public void erase(int index) {
        Node prev, current;
        prev = null;
        current = head;
        int i = 0;
        while (i < index && current != null) {
            prev = current;
            current = current.next;
            i++;
        }
        if (i == index) {
            if (prev == null) {
                current = current.next;
                head = current;
            } else {
                prev.next = current.next;
            }
            size--;
        } else {
            throw new NoSuchElementException("There is no such index " + index);
        }
    }

    public String valueNFromEnd(int n) {
        Node nFromEnd, current;
        current = head;
        int i = 0;
        while (i < n && current != null) {
            current = current.next;
            i++;
        }
        if (i == n) {
            nFromEnd = head;
        } else {
            throw new NoSuchElementException("There is no such element " + n);
        }
        while (current != null) {
            nFromEnd = nFromEnd.next;
            current = current.next;
        }
        return nFromEnd.value;
    }

    public void removeValue(String value) {
        Node prev, current;
        prev = null;
        current = head;
        while (current != null && current.value != value) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            return;
        } else {
            prev.next = current.next;
            size--;
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
        testFrontWhenEmpty();
        testFrontWhenNonEmpty();
        testBackWhenEmpty();
        testBackWhenNonEmpty();
        testInsertAtFront();
        testInsertAtMiddle();
        testInsertAtEnd();
        testInsertForNegativeValue();
        testInsertForValueAfterEnd();
        testEraseAtFront();
        testEraseAtMiddle();
        testEraseAtEnd();
        testEraseForNegativeValue();
        testEraseForValueAfterEnd();
        testValueNFromEndWhenValueInList();
        testValueNFromEndWhenValueNotInList();
        testRemoveValueWhenValueInList();
        testRemoveValueWhenValueNotInList();
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

    public static void testFrontWhenEmpty() {
        LinkedList llist = new LinkedList();
        try {
            llist.front();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testFrontWhenNonEmpty() {
        LinkedList llist = new LinkedList();
        llist.pushBack("1");
        llist.pushBack("2");
        llist.pushBack("3");
        llist.pushBack("4");
        llist.pushBack("5");
        System.out.println(llist.front());
    }

    public static void testBackWhenEmpty() {
        LinkedList llist = new LinkedList();
        try {
            llist.back();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testBackWhenNonEmpty() {
        LinkedList llist = new LinkedList();
        llist.pushBack("1");
        llist.pushBack("2");
        llist.pushBack("3");
        llist.pushBack("4");
        llist.pushBack("5");
        System.out.println(llist.back());
    }

    public static void testInsertAtFront() {
        LinkedList llist = new LinkedList();
        llist.insert(0, "1");
        llist.insert(0, "2");
        llist.insert(0, "3");
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testInsertAtMiddle() {
        LinkedList llist = new LinkedList();
        llist.pushFront("1");
        llist.insert(1, "2");
        llist.insert(2, "3");
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testInsertAtEnd() {
        LinkedList llist = new LinkedList();
        llist.pushFront("1");
        llist.insert(1, "2");
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testInsertForNegativeValue() {
        LinkedList llist = new LinkedList();
        llist.pushFront("1");
        try {
            llist.insert(-1, "2");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testInsertForValueAfterEnd() {
        LinkedList llist = new LinkedList();
        llist.pushFront("1");
        try {
            llist.insert(2, "2");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testEraseAtFront() {
        LinkedList llist = new LinkedList();
        llist.insert(0, "1");
        llist.insert(0, "2");
        llist.insert(0, "3");
        llist.erase(0);
        llist.erase(0);
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testEraseAtMiddle() {
        LinkedList llist = new LinkedList();
        llist.pushFront("1");
        llist.insert(1, "2");
        llist.insert(2, "3");
        llist.erase(1);
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testEraseAtEnd() {
        LinkedList llist = new LinkedList();
        llist.pushFront("1");
        llist.insert(1, "2");
        llist.erase(1);
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testEraseForNegativeValue() {
        LinkedList llist = new LinkedList();
        llist.pushFront("1");
        try {
            llist.erase(-1);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testEraseForValueAfterEnd() {
        LinkedList llist = new LinkedList();
        llist.pushFront("1");
        try {
            llist.erase(2);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testValueNFromEndWhenValueInList() {
        LinkedList llist = new LinkedList();
        llist.pushBack("1");
        llist.pushBack("2");
        llist.pushBack("3");
        llist.pushBack("4");
        llist.pushBack("5");
        System.out.println(llist.valueNFromEnd(2));
    }

    public static void testValueNFromEndWhenValueNotInList() {
        LinkedList llist = new LinkedList();
        llist.pushBack("1");
        llist.pushBack("2");
        llist.pushBack("3");
        llist.pushBack("4");
        llist.pushBack("5");
        try {
            llist.valueNFromEnd(6);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testRemoveValueWhenValueInList() {
        LinkedList llist = new LinkedList();
        llist.pushBack("1");
        llist.pushBack("2");
        llist.pushBack("3");
        llist.pushBack("4");
        llist.pushBack("5");
        llist.removeValue("2");
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void testRemoveValueWhenValueNotInList() {
        LinkedList llist = new LinkedList();
        llist.pushBack("1");
        llist.pushBack("2");
        llist.pushBack("3");
        llist.pushBack("4");
        llist.pushBack("5");
        llist.removeValue("6");
        Node current = llist.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
