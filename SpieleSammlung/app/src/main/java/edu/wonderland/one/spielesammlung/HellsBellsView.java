package edu.wonderland.one.spielesammlung;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;

import java.util.Random;

public class HellsBellsView extends View {

    private Drawable backgroundImage;
    private Context c;

    private int imageX, imageY, imageWidth, imageHeight;

    public HellsBellsView(Context context) {
        super(context);
        c = context;

        //make the GameView focusable so it can handle events
        setFocusable(true);

        //load the background image as a drawable object
        backgroundImage = ContextCompat.getDrawable(context, R.drawable.hellsbells);

        //set the initial position of the image
        imageY = 0;
        imageX = 0;
        imageWidth = 500;
        imageHeight = 500;
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.BLACK);

        //draw the background image
        backgroundImage.setBounds(imageX, imageY, imageWidth, imageHeight);
        backgroundImage.draw(canvas);

    }


}
