package com.example.organizer;
import java.util.*;

// Node class for the to-do lists
public class Node<String> {
    public String value; // The text stored in the item
    public Date date; // The date of the to-do item
    public Set<String> tag;
    public Node<String> next;

    // Creates a node given a value
    public Node(String value) {
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
    public void setDate(Node item, Date date) {
        item.date = date;
    }

    // Not yet implemented
    public void setTag(Node item, Set<String> tag) {

    }
}
