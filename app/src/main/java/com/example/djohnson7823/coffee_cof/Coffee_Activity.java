package com.example.djohnson7823.coffee_cof;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import static android.R.color.holo_green_light;
import static android.R.id.toggle;
//import static com.example.djohnson7823.coffee_cof.R.id.Font;
//import static com.example.djohnson7823.coffee_cof.R.id.font;

public class Coffee_Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    ToggleButton toggle;
    RelativeLayout r;
    private double basePrice = 2.75;
    private double costPer = 2.75;
    private int coffeeQuantity;
    private double total;
    private boolean chocolate = false;
    private boolean carmel = false;
    final public static String mule = "wasup";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee_main);
        coffeeQuantity = 1;
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void plus(View v) {
        coffeeQuantity++;
        TextView quan = (TextView) findViewById(R.id.number_coffee);
        quan.setText("" + coffeeQuantity);
        calculatePrice();
        TextView ans = (TextView) findViewById(R.id.final_price);
        ans.setText("" + total);
        Log.d("This is the tag", "This is the Message");
    }

    public void minus(View v) {
        if (coffeeQuantity > 0)
            coffeeQuantity--;

        TextView sund = (TextView) findViewById(R.id.number_coffee);
        sund.setText("" + coffeeQuantity);
        calculatePrice();
        TextView anw = (TextView) findViewById(R.id.final_price);
        anw.setText("" + total);
    }

    private void calculatePrice() {

        costPer = basePrice;

        CheckBox choco = (CheckBox) findViewById(R.id.choco_CheckBox);
        if (choco.isChecked()) costPer += .50;
        CheckBox carmel = (CheckBox) findViewById(R.id.carmel_CheckBox);
        if (carmel.isChecked()) costPer += .50;
        total = costPer * coffeeQuantity;


    }

    //how to change screens
    public void continu(View view) {
        Intent intent = new Intent(this, Continue_Coffee_Cof.class);

        String message = "" + total;
        intent.putExtra(mule, message);
        startActivity(intent);
    }

    public void toggleClicked(View view) {
//watch this to finish togglebutoon https://www.youtube.com/watch?v=DHFFgqmWM9s
        r = (RelativeLayout) findViewById(R.id.fontmain);
        toggle = (ToggleButton) findViewById(R.id.t);
        Log.d("DEBUG YO", "toggleClicked is running");
        ToggleButton tb = (ToggleButton) view;
        TextView addCoffee = (TextView) findViewById(R.id.add_coffee);
        TextView chocolate = (TextView) findViewById(R.id.chocolate);
        TextView welcome = (TextView) findViewById(R.id.welcome);
        TextView minus_coffee = (TextView) findViewById(R.id.minus_coffee);
        TextView number_coffee = (TextView) findViewById(R.id.number_coffee);
        TextView carmel = (TextView) findViewById(R.id.carmel);
        TextView choco_CheckBox = (TextView) findViewById(R.id.choco_CheckBox);
        TextView carmel_CheckBox = (TextView) findViewById(R.id.carmel_CheckBox);
        TextView final_price = (TextView) findViewById(R.id.final_price);
        TextView continu = (TextView) findViewById(R.id.continu);
        TextView t = (TextView) findViewById(R.id.t);
        if (tb.isChecked())
        {
            addCoffee.setTextSize(24);
            chocolate.setTextSize(24);
            welcome.setTextSize(24);
            minus_coffee.setTextSize(24);
            number_coffee.setTextSize(24);
            carmel.setTextSize(24);
            choco_CheckBox.setTextSize(24);
            carmel_CheckBox.setTextSize(24);
            final_price.setTextSize(24);
            continu.setTextSize(24);
            t.setTextSize(24);
           // addCoffee.setTextSize(24);

        }
        else
        {
            addCoffee.setTextSize(12);
            chocolate.setTextSize(12);
            welcome.setTextSize(12);
            minus_coffee.setTextSize(12);
            number_coffee.setTextSize(12);
            carmel.setTextSize(12);
            choco_CheckBox.setTextSize(12);
            carmel_CheckBox.setTextSize(12);
            final_price.setTextSize(12);
            continu.setTextSize(12);
            t.setTextSize(12);
           // addCoffee.setTextSize(12);
        }
//        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

//                                          {
    }//useless method for now
    public void onCheckedChanged(CompoundButton CompoundButton, boolean isChecked) {
        Log.d("DEBUG YO", "onCheckedChanged is running");
        try {
            if (r instanceof ViewGroup) {

                for (int i = 0; i < r.getChildCount(); i++) {
                    TextView child = (TextView) r.getChildAt(i);
                    if (isChecked)
                        child.setTextSize(24);
                    else
                        child.setTextSize(12);
//                        overrideFonts(context, child);
                }
            }
        } catch (Exception e) {
        }


//            if (isChecked) {
//                // The toggle is enabled
//
//            } else {
//                r.setFontsize(12)
//                Font newFont = currentFont.deriveFont(currentFont.getSize(F_font));
//                // The toggle is disabled
//            }
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Coffee_ Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    //    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


}

/*
{
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        }*/

