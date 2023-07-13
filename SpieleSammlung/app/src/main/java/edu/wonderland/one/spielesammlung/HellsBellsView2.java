package edu.wonderland.one.spielesammlung;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;

import java.util.Random;

public class HellsBellsView2 extends View {

    private Drawable backgroundImage;
    private Context c;

    private int imageX, imageY;
    public int imageWidth, imageHeight;
    private int canvasWidth, canvasHeight;

    private boolean isInit = false;

    public HellsBellsView2(Context context) {
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

        if (!isInit){
            canvasWidth = canvas.getWidth();
            canvasHeight = canvas.getHeight();
            isInit = true;
        }

        //draw the background image
        backgroundImage.setBounds(imageX, imageY, imageWidth, imageHeight);
        backgroundImage.draw(canvas);

    }

    public int getImageX() {
        return imageX;
    }

    public void setImageX(int imageX) {
        this.imageX = imageX;
    }

    public int getImageY() {
        return imageY;
    }

    public void setImageY(int imageY) {
        this.imageY = imageY;
    }

    public int getCanvasWidth(){
        return canvasWidth;
    }

    public int getCanvasHeight(){
        return canvasHeight;
    }

    //override the onTouchEvent method for hellsBellsView.setOnTouchListener
    //to handle the touch event on the screen
    public boolean performClick() {
        super.performClick();
        return true;
    }

    public boolean isHit(int x, int y){
        return (x > imageX && y > imageY && x < imageX + imageWidth && y < imageY + imageHeight);
    }

}
