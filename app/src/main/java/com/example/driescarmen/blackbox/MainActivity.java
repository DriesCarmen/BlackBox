package com.example.driescarmen.blackbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button =  (Button) findViewById(R.id.btnStart);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GoToJoinMake(v);
            }
        });
    }


    private void GoToJoinMake(View v){
        Intent i = new Intent(MainActivity.this, MakeGroupActivity.class);
        startActivity(i);

    }

}
