package com.example.driescarmen.blackbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button button =  (Button) findViewById(R.id.btnMakeGroup);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GoToMakeGroup(v);
            }
        });

        Button buttonjoin =  (Button) findViewById(R.id.btnGoToJoinGroup);
        buttonjoin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GoToJoinGroup(v);
            }
        });

    }

    private void GoToMakeGroup(View v){
        Intent i = new Intent(this, MakeGroupActivity.class);
        startActivity(i);

    }

    private void GoToJoinGroup(View v){
        Intent i = new Intent(this, JoinGroup.class);
        startActivity(i);

    }


}
