package com.example.organizer;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.CheckBox;

// Organizes a list of items in a To-Do List
public class ToDoList {
    private String name; // Name of the To-Do List
    private Node front; // Node to the front of the list
    private Node back; // Node to the back of the list
    private int size; // Size of the list

    // Creates an empty To-Do List
    public ToDoList() {
        this("unnamed");
    }

    // Creates an empty To-Do List with given name
    public ToDoList(String name) {
        this.name = name; // Empty name
        this.front = null;
        this.back = null;
        this.size = 0;
}
    // Adds an item to the To-Do list
    public void add(Node item) {
        if (front == null) {
            front = item;
            back = front;
        } else {
            back.setNext(back, item);
            back = back.getNext();
        }
        this.size++;
    }

    // Checks to see if the To-Do List contains a given item
    // Returns true if To-Do List has given item
    // Returns false if To-Do List does not have given item
    // Throws new IllegalArgumentException() if given item is null
    public boolean contains(Node item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (front.equals(item)) {
            return true;
        }
        Node curr = front;
        while (curr.getNext() != null) {
            if (curr.getNext().equals(item)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    // Removes a given item from the To-Do List
    // Throws IllegalArgumentException if given item is not in the list
    public void remove(Node item) {
        if (this.contains(item)) {
            Node prev = null;
            Node curr = front;
            if (curr != null && curr.equals(item)) {
                front = curr.getNext();
                return;
            }
            while (curr != null && !curr.equals(item)) {
                prev = curr;
                curr = curr.getNext();
            }
            prev.setNext(prev.getNext(), curr.getNext());
            this.size--;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Clears the To-Do list
    public void clear() {
        this.name = "unnamed";
        this.front = null;
        this.back = null;
        this.size = 0;
    }
}
