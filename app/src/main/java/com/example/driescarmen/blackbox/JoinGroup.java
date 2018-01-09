package com.example.driescarmen.blackbox;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class JoinGroup extends AppCompatActivity {

    Spinner spinner;

    Object data;
    User user;

    List<String> list = new ArrayList<String>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);






        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                DataSnapshot snapshot = dataSnapshot;
                snapshot.getValue(User.class);
                String user2 = snapshot.getValue(User.class).getGroup();
                // String groupName = user.getGroup();
                //addItemsOnSpinner(groupName);

                //Log.v("E_val","datasnapshot: " + data);
               // Log.v("E_val","list of vals: " + s);
                Log.v("E_val","user " + user2);


                //set in button
               // TextView et = (TextView) findViewById(R.id.tvTest);
                //et.setText(groupName);



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
               // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }


    public void addItemsOnSpinner(String group) {

        spinner = (Spinner) findViewById(R.id.spinnerGroups);




            list.add(group);




        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }




}
