package com.kellydwalters.buttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    HorizontalScrollView hv;
    TextView tvHide;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //demo grabbed from here:
        // http://www.coders-hub.com/2013/11/how-to-perform-action-on-any-hardware.html#.WrwLTojwZPZ

        //get access to scroll view
        hv = findViewById(R.id.horizontalScrollView1);
        tvHide = findViewById(R.id.tvHide);
    }

    //The onKeyDown method is Called when any hardware button is clicked
    //This method takes two parameters, first hardware button code
    //Which is clicked and key event object which will have all
    //hardware button codes
    public boolean onKeyDown(int keycode, KeyEvent event)
    {

        // KeyEvent has a list of all the possible button options, I chose vol down, but it could have been anything
        if(keycode==KeyEvent.KEYCODE_VOLUME_DOWN)
        {
            Toast.makeText(this, "You hit the down key, it did these things", Toast.LENGTH_SHORT).show();

            if (hv.getVisibility() == View.INVISIBLE) {
                setVisibilities(View.VISIBLE, View.INVISIBLE);
            }
            else {
                setVisibilities(View.INVISIBLE, View.VISIBLE);
            }
        }
        return super.onKeyDown(keycode, event);
    }

    private void setVisibilities(int v, int tv) {

        //make the scrolly thing visible
        hv.setVisibility(v);

        // make the text disappear
        tvHide.setVisibility(tv);
    }
}
