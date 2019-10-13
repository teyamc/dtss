package com.example.organizer;
import java.util.*;

// Node class for the to-do lists
public class Node {
    private int id; // ID of the node
    private String value; // The text stored in the item
    private String date; // The date of the to-do item
    private Set<String> tag; // The tag of the to-do item
    private Node next; // The next item in the to-do list

    // Creates a node given a value
    public Node(String value, int order) {
        this.value = value;
    }

    // Creates an empty node
    public Node() {
        this.value = null;
    }

    // Sets the value of the given item to the given item
    public void setValue(Node item, String value) {
        item.value = value;
    }

    // Sets the date of the given item to the given date
    public void setDate(Node item, String date) {
        item.date = date;
    }

    // Not yet implemented
    public void setTag(Node item, Set<String> tag) {
    }

    // Sets the next given the item and the next item
    public void setNext(Node item, Node next) {
        item.next = next;
    }

    // Returns the id of the node
    public int getId() { return this.id; }

    // Returns the value of the node
    public String getValue() {
        return this.value;
    }

    // Returns the date of the node
    public String getDate() {
        return this.date;
    }

    // Returns the tag of the node
    public Set<String> getTag() {
        return this.tag;
    }

    // Returns the next of the node
    public Node getNext() {
        return this.next;
    }
}
