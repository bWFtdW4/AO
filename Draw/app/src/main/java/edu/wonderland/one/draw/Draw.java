package edu.wonderland.one.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Draw extends View implements View.OnTouchListener {

    private Bitmap bitmap;
    private Canvas bitmapCanvas;

    private Paint paint = new Paint();

    private boolean isInitialized;
    private float downX = 0, downY = 0, upX = 0, upY = 0;



    public Draw(Context context) {
        super(context);
        setBackgroundColor(Color.MAGENTA);

        //Focus
        setFocusable(true);
        //Focus in Touch Mode
        setFocusableInTouchMode(true);
        setClickable(true);

        // initialize paint
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        isInitialized = false;

        // set the OnTouchListener
        setOnTouchListener(this);
    }

    // Canvas is the drawing surface / Bitmap is the image on top of the Canvas
    public void onDraw(Canvas canvas) {
        // initialize the bitmap and canvas on the first draw
        if(!isInitialized) {
            init();
        }
        // draw the bitmap on the canvas
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }

    private void init() {
        // initialize the Bitmap
        bitmap = Bitmap.createBitmap(getWidth(), getHeight() - 100, Bitmap.Config.RGB_565);

        // initialize the Canvas
        bitmapCanvas = new Canvas();
        // set the Bitmap as the bitmap to be drawn on
        bitmapCanvas.setBitmap(bitmap);
        // set the background color of the Canvas
        bitmapCanvas.drawColor(Color.BLACK);

        isInitialized = true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        // get the action of the MotionEvent / MotionEvent = user finger interaction
        int action = event.getAction();

        switch (action){
            // get the position of the user finger
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                break;

            // get the position of the user finger movement
            case MotionEvent.ACTION_MOVE:
                // get the current position
                upX = event.getX();
                upY = event.getY();
                // draw a line from the last position to the current position
                bitmapCanvas.drawLine(downX, downY, upX, upY, paint);
                System.out.println("downX: " + downX + " downY: " + downY + " upX: " + upX + " upY: " + upY);
                // set the last position to the current position
                downX = upX;
                downY = upY;
                // repaint the view / invalidate() = repaint()
                invalidate();
                break;
        }



        return false;
    }
}
