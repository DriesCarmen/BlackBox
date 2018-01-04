package com.example.driescarmen.blackbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                //Log.d(TAG, "Value is: " + value);
                TextView TV = (TextView) findViewById(R.id.TVtekst);
                TV.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        Button send = (Button) findViewById(R.id.btnSend);
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Readgroupinfo(v);
                Send(v,Readgroupinfo(v), Readmessageinfo(v));
            }
        });

    }
    int num = 0;





    public void Send(View v , String group , String message)
    {
        myRef = database.getReference(group.);
        // Write a message to the database

        myRef.setValue(message);
        num++;
    }

    private String Readgroupinfo(View v){
        EditText ET = (EditText) findViewById(R.id.ETGroup);
        return ET.getText().toString();
    }
    private String Readmessageinfo(View v){
        EditText ET = (EditText) findViewById(R.id.ETmessage);
        return ET.getText().toString();
    }

}
