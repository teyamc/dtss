package com.example.organizer;

public class MasterList {
    public ListNode front;

    public MasterList(){
        front = new ListNode();
    }

    public void addList(ToDoList list){

    }

    public class ListNode {
        public ToDoList data;
        public ListNode next;

        public ListNode(){
            this.data = null;
            this.next = null;
        }

        public ListNode(ToDoList data){
            this.data = data;
            this.next = null;
        }
    }
}
