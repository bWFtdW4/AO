package edu.wonderland.one.spielesammlung;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;


public class HellsBellsGame extends AppCompatActivity {

    /**
     * MVC
     * Model: keine, da keine Daten gespeichert/geladen werden
     * View: activity_hells_bells_games.xml -> Spielfeld
     * Controller: HellsBellsGames.java     -> Observer
     */


    private MediaPlayer mediaPlayer;
    private Button buttonCounter;
    private HellsBellsView hellsBellsView;

    private boolean gameRun = false;

    private int counter = 0;
    private int delay = 1000;

    private Handler handler = new Handler();
    private Runnable runnable;



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
        } else {
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
        buttonStart.setWidth(displayWidth / 3);
        buttonStart.setBackgroundColor(Color.DKGRAY);
        buttonStart.setTextColor(Color.WHITE);

        Button buttonPause = new Button(this);
        buttonPause.setText("Pause");
        buttonPause.setWidth(displayWidth / 3);
        buttonPause.setBackgroundColor(Color.DKGRAY);
        buttonPause.setTextColor(Color.WHITE);

        Button buttonStop = new Button(this);
        buttonStop.setText("Stop");
        buttonStop.setWidth(displayWidth / 3);
        buttonStop.setBackgroundColor(Color.DKGRAY);
        buttonStop.setTextColor(Color.WHITE);

        /*
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
        */

        //button listener with lambda expression
        buttonStart.setOnClickListener(v -> {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                System.out.println("music starting");
            } else if (mediaPlayer.isPlaying()) {
                System.out.println("music is already playing");
            }

            if (!gameRun) {

                Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();

                //start the runnable. the runnable is called every delay milliseconds.
                //postDelayed() = run the runnable after the delay
                handler.postDelayed(runnable = new Runnable() {
                    @Override
                    public void run() {
                        handler.postDelayed(runnable, delay);

                        //TODO: random position for hellsbells

                        hellsBellsView.setImageX(getRandomX());
                        System.out.println("x: " + hellsBellsView.getX());
                        hellsBellsView.setImageY(getRandomY());
                        System.out.println("y: " + hellsBellsView.getY());

                        //invalidate() = redraw the view
                        hellsBellsView.invalidate();
                    }
                }, delay);
                gameRun = true;
            }

        });

        buttonPause.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                System.out.println("music is paused");
            } else {
                System.out.println("music is not playing");
            }

            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        });

        buttonStop.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                System.out.println("music is stopped");
            } else {
                System.out.println("music is not playing");
            }

            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();

            gameRun = false;

            //stop the runnable
            handler.removeCallbacks(runnable);
        });


        //create a new button object for the counter
        buttonCounter = new Button(this);
        buttonCounter.setText("0");
        buttonCounter.setWidth(displayWidth);
        buttonCounter.setBackgroundColor(Color.DKGRAY);
        buttonCounter.setTextColor(Color.WHITE);

        //button listener for the counter with lambda expression
        buttonCounter.setOnClickListener(v -> {
            System.out.println("buttonCounter clicked");
        });


        //add the buttons to the panelLayout
        panelLayout.addView(buttonStart);
        panelLayout.addView(buttonPause);
        panelLayout.addView(buttonStop);
        //add the counter button to the counterPanelLayout
        counterPanelLayout.addView(buttonCounter);

        basicLinearLayout.addView(panelLayout);
        basicLinearLayout.addView(counterPanelLayout);

        //create a new view object for the game
        hellsBellsView = new HellsBellsView(this);

        /*
        hellsBellsView.setOnTouchListener(v -> {
            System.out.println("hellsBellsView touched");
            return false;
        });
         */

        hellsBellsView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                System.out.println("hellsBellsView touched");
                if (gameRun && hellsBellsView.isHit((int)e.getX(),(int)e.getY())) {

                    counter++;
                    buttonCounter.setText(counter + "");

                }

                return false;
            }
        });



        basicLinearLayout.addView(hellsBellsView);


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
        mediaPlayer.stop();
    }

    public int getRandomX() {
        //get the width of the canvas
        int max = hellsBellsView.getCanvasWidth();
        //subtract the width of the image
        int realMax = max - hellsBellsView.imageWidth;
        //return a random number between 0 and realMax
        return (new Random()).nextInt(realMax);
    }

    public int getRandomY() {
        int max = hellsBellsView.getCanvasHeight();
        int realMax = max - hellsBellsView.imageHeight;
        return (new Random()).nextInt(realMax);
    }



}