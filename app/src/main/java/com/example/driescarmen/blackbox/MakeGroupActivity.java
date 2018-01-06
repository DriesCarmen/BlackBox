package com.example.driescarmen.blackbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MakeGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_group);
    }


    EditText etGroupname = (EditText) findViewById(R.id.etGroupName);
    EditText etYourName = (EditText) findViewById(R.id.etYourName);
    Button btnCreateGroup = (Button) findViewById(R.id.btnCreateGroup);


    private void send(View v, String Group, String Name){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(Group);

        myRef.setValue(Name);
    }

}
