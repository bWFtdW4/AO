package edu.wonderland.one.lifecycle2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText editFeld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFeld = findViewById(R.id.editTextText);

        sharedPreferences = getSharedPreferences("Android",MODE_PRIVATE);

        Toast.makeText(this, "ONCREATE", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(this, "ONSTART", Toast.LENGTH_LONG).show();
        // The activity is about to become visible.
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Toast.makeText(this, "ONRESTART", Toast.LENGTH_LONG).show();
        // The activity is about to become visible.
    }

    @Override
    public void onResume() {
        super.onResume();

        String vornameText = sharedPreferences.getString("vorname","");
        editFeld.setText(vornameText);

        Toast.makeText(this, "ONRESUME", Toast.LENGTH_LONG).show();
        // The activity has become visible (it is now "resumed").
    }

    @Override
    public void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = getSharedPreferences("Android",MODE_PRIVATE).edit();

        editor.putString("vorname",editFeld.getText().toString());
        //...
        //...
        editor.commit();


        Toast.makeText(this, "ONPAUSE", Toast.LENGTH_LONG).show();
        // Another activity is taking focus (this activity is about to be "paused").
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(this, "ONSTOP", Toast.LENGTH_LONG).show();
        // The activity is no longer visible (it is now "stopped")
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "ONDESTROY", Toast.LENGTH_LONG).show();
        // The activity is about to be destroyed.
    }



}