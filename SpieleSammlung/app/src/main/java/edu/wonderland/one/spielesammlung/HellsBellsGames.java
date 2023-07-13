package edu.wonderland.one.spielesammlung;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class HellsBellsGames extends AppCompatActivity {

    /**
     * MVC
     * Model: keine, da keine Daten gespeichert/geladen werden
     * View: activity_hells_bells_games.xml -> Spielfeld
     * Controller: HellsBellsGames.java     -> Observer
     */


    private MediaPlayer mediaPlayer;
    private Button buttonCounter;
    private HellsBellsView hellBellsView;

    //this is the controller for the HellsBellsGames activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hells_bells_games);

        //get the display size of the device
        Display display = getWindowManager().getDefaultDisplay();
        //create a point object to store the display size
        Point size = new Point();
        //store the display size in the point object
        display.getSize(size);
        //store the display size in size.x and size.y
        int displayWidth = size.x;
        int displayHeight = size.y;
        Log.d("display size", displayWidth + " " + displayHeight);

        mediaPlayer = MediaPlayer.create(this, R.raw.testmusic);

        if (mediaPlayer.isPlaying()) {
            System.out.println("music is playing");
        }else{
            System.out.println("music is not playing");
        }

        LinearLayout basicLinearLayout = new LinearLayout(this);
        basicLinearLayout.setBackgroundColor(Color.RED);
        basicLinearLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout panelLayout = new LinearLayout(this);
        panelLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout counterPanelLayout = new LinearLayout(this);
        panelLayout.setOrientation(LinearLayout.HORIZONTAL);


        Button buttonStart = new Button(this);
        buttonStart.setText("Start");
        buttonStart.setWidth(displayWidth/3);
        buttonStart.setBackgroundColor(Color.DKGRAY);
        buttonStart.setTextColor(Color.WHITE);

        Button buttonPause = new Button(this);
        buttonPause.setText("Pause");
        buttonPause.setWidth(displayWidth/3);
        buttonPause.setBackgroundColor(Color.DKGRAY);
        buttonPause.setTextColor(Color.WHITE);

        Button buttonStop = new Button(this);
        buttonStop.setText("Stop");
        buttonStop.setWidth(displayWidth/3);
        buttonStop.setBackgroundColor(Color.DKGRAY);
        buttonStop.setTextColor(Color.WHITE);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    System.out.println("music starting");
                }else if (mediaPlayer.isPlaying()){
                    System.out.println("music is already playing");
                }
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    System.out.println("music is paused");
                }
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    System.out.println("music is stopped");
                }

            }
        });

        //create a new button object for the counter
        buttonCounter = new Button(this);
        buttonCounter.setText("0");
        buttonCounter.setWidth(displayWidth);
        buttonCounter.setBackgroundColor(Color.DKGRAY);
        buttonCounter.setTextColor(Color.WHITE);



        //add the buttons to the panelLayout
        panelLayout.addView(buttonStart);
        panelLayout.addView(buttonPause);
        panelLayout.addView(buttonStop);
        //add the counter button to the counterPanelLayout
        counterPanelLayout.addView(buttonCounter);

        basicLinearLayout.addView(panelLayout);
        basicLinearLayout.addView(counterPanelLayout);

        //create a new view object for the game
        hellBellsView = new HellsBellsView(this);



        basicLinearLayout.addView(hellBellsView);


        setContentView(basicLinearLayout);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}