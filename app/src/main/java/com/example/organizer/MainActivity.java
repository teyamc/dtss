package com.example.organizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public ToDoList list;
    OrganizerDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //helper = new OrganizerDBHelper(this);
        //list = helper.readList();
        list = new ToDoList();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.add_item);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText txtname = findViewById(R.id.input_text);
                String name = txtname.getText().toString();
                makeListItem(name);
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void makeListItem(String value) {
        Node node = new Node(value);
        list.add(node);
        //helper.insertNode(node);
    }
}
