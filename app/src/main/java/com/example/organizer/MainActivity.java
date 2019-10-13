package com.example.organizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OrganizerDBHelper helper = new OrganizerDBHelper(this);
        ToDoList toDoList = helper.readList();
    }
}
