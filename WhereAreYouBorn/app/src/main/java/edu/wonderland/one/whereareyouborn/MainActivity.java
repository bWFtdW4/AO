package edu.wonderland.one.whereareyouborn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create a layout and set it as the content view
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.CYAN);

        // create a text field and add it to the layout
        final EditText ortView = new EditText(this);
        ortView.setBackgroundColor(Color.WHITE);
        layout.addView(ortView);

        // create a button and add it to the layout
        Button losView = new Button(this);
        losView.setText("WO GEBOREN?");
        layout.addView(losView);

        losView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // toast a message, when the button is clicked
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_LONG).show();

                String  geburtsort = ortView.getText().toString();
                geburtsort = geburtsort.replace(' ','+');

                String map  = "https://www.google.de/maps/place/" + geburtsort + "/";
                // create an intent to open a web page (intent = Absicht)
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));

                startActivity(intent);

            }
        });

        setContentView(layout);
    }
}