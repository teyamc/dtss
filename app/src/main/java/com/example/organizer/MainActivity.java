package com.example.organizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OrganizerDBHelper helper = new OrganizerDBHelper(this);

        Button b1 = (Button) findViewById(R.id.add_item);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText txtname = findViewById(R.id.input_text);
                String name = txtname.getText().toString();
            }
        });
    }

    public void makeListItem(String value) {

    }
}
