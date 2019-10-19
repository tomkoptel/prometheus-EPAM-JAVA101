package com.uzhnu.epam.course.week3;

public class LinkedList {
    private Node tail;
    private Node head;
    private int size = 0;

    public LinkedList() {
        tail = new Node();
        head = tail;
    }

    public void add(Integer data) {
        if (tail.getData() == null) {
            tail.setData(data);
        } else {
            Node newNode = new Node();
            newNode.setData(data);
            Node currentHead = head;
            currentHead.setNext(newNode);
            head = newNode;
        }
        size++;
    }

    public Integer get(int index) {
        int counter = 0;
        Integer result = tail.getData();
        Node nextNode = tail;

        while (counter <= (size - 1) && counter != index) {
            nextNode = nextNode.getNext();
            result = nextNode.getData();
            counter++;
        }

        return result;
    }

    public boolean delete(int index) {
        if (index + 1 > size || index < 0) return false;

        // 0     1     2      3
        // n1 -> n2 -> n3 --> n4
        if (index == 0) {
            Node next = tail.getNext();
            if (next == null) {
                tail.setData(null);
            } else {
                tail = next;
            }
        } else {
            Node previousNode = tail;
            Node currentNode = tail;
            int counter = 0;

            while (counter <= (size - 1) && counter != index) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
                counter++;
            }

            previousNode.setNext(currentNode.getNext());
        }
        size--;
        return true;
    }

    public int size() {
        return size;
    }
}
