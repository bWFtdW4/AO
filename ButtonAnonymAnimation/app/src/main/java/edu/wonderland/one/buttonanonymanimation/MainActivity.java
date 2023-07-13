package edu.wonderland.one.buttonanonymanimation;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity{

    private Button animationButton, colorButton, colorButtonSwitch;
    private ConstraintLayout layout;
    private boolean dark = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationButton = findViewById(R.id.anibutton);
        colorButton = findViewById(R.id.colorbutton);
        layout = findViewById(R.id.mylayout);
        colorButtonSwitch = findViewById(R.id.colorbuttonswitch);

        ImageView darkImg = findViewById(R.id.dark);
        ImageView lightImg = findViewById(R.id.light);



        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.BLUE);
            }
        });

        //load R.anim.animation into this
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.animation);
        //animationButton.startAnimation(animationSet);
        //layout.startAnimation(animationSet);

        animationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationButton.startAnimation(animationSet);
            }
        });


        colorButtonSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked");
                if (dark == false){
                    layout.setBackgroundColor(Color.parseColor("#FFFAD7"));
                    colorButtonSwitch.setText("DARK");
                    dark = true;
                    darkImg.setVisibility(View.VISIBLE);
                    lightImg.setVisibility(View.INVISIBLE);

                }else{
                    layout.setBackgroundColor(Color.parseColor("#176B87"));
                    colorButtonSwitch.setText("LIGHT");
                    dark = false;
                    darkImg.setVisibility(View.INVISIBLE);
                    lightImg.setVisibility(View.VISIBLE);
                }
            }
        });










    }



}