package edu.wonderland.one.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Ausnahmsweise den Listener in die View
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create a new Draw object
        //Draw d = new Draw(this);
        Draw2 d = new Draw2(this);


        // set the Draw object "d" as the view of this Activity
        setContentView(d);
    }
}