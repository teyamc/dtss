package com.example.organizer;

public class ToDoList {
    private Node front;
    private Node back;
    private int size;

    public ToDoList() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public void add(String value) {
        if (front == null) {
            front = new Node(value);
            back = front;
        } else {
            back.setNext(back, new Node(value));
            back = back.getNext();
        }
        this.size++;
    }

    // Not yet implemented
    public Node remove(Node item) {
        return null;
    }

    public void clear() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }


}
