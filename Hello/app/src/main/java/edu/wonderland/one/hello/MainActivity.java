package edu.wonderland.one.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickmich (View v){
        System.out.println("clicked");
        textView = findViewById(R.id.ausgabe);
        textView.setText("neuer text");

    }

}