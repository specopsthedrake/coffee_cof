package com.example.djohnson7823.coffee_cof;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Continue_Coffee_Cof extends AppCompatActivity {

    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue__coffee__cof);



        Intent intent = getIntent();
        message = intent.getStringExtra(Coffee_Activity.mule);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setTextColor(Color.parseColor("#663300"));
        textView.setText(message +" please pay with cash or credit. " +
                " no checks. no loitering " +
" come back if you wish "        );

        ViewGroup layout = (ViewGroup) findViewById(R.id.theTopMan);
        layout.addView(textView);
        }
    public static void fds(View view)
    { //TextView ans = (TextView)findViewById(R.id.display_cost);

    }
}