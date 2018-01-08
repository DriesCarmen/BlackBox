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


public class CreateQuestion extends AppCompatActivity {

/*
    Bundle extras = getIntent().getExtras();
    String group = extras.getString("groupname");
    String name = extras.getString("username");
*/
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question);

        final EditText question = (EditText) findViewById(R.id.etMakeQuestion);

        //System.out.println("group = " + group +  "name =  " + name);

        Button buttonCreateQuestion =  (Button) findViewById(R.id.btnCreateQuestion);
        buttonCreateQuestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {




                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("test");

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        user = dataSnapshot.child("test").getValue(User.class);
                        System.out.println(user);

                        user.setQuestion(question.getText().toString());

                        System.out.println(user);


                        send(user);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });


               // send(user);
            }
        });












    }





    private void send(User user){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(user.getGroup()).child(user.getName());

        myRef.setValue(user);
    }



}


