package com.example.driescarmen.blackbox;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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



        Button button =  (Button) findViewById(R.id.btnCreateGroup);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText etGroupname = (EditText) findViewById(R.id.etGroupName);
                EditText etYourName = (EditText) findViewById(R.id.etYourName);

                String name = etYourName.getText().toString();
                String group = etGroupname.getText().toString();


                User user = new User(name,group,false,false);


                if(group == " ")
                {

                    Context context = getApplicationContext();
                    CharSequence text = "please enter name and group";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }
                else
                {
                    send(v,user);
                    GoToMakeQuestion(v);
                }

            }
        });


    }




    private void send(View v, User user){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(user.getGroup().toString());

        myRef.push().setValue(user);
    }



    private void GoToMakeQuestion(View v){
        Intent i = new Intent(this, CreateQuestion.class);
        startActivity(i);

    }

}
