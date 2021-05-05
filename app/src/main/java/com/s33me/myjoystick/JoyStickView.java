package com.s33me.myjoystick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.*;
import android.widget.Toast.*;
import android.graphics.*;
import android.view.View.*;

public class JoyStickView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener
{
    private float centerX, centerY, baseRadius, hatRadius;
    private void setupDimensions() {
        centerX = getWidth() /2;
        centerY = getHeight() /2;
        baseRadius = Math.min(getWidth(), getHeight()) /3;
        hatRadius = Math.min(getWidth(), getHeight()) / 5;
    }
    public JoyStickView (Context context) {
        super(context);
        getHolder().addCallback(this);
        setOnTouchListener(this);
    }
    public JoyStickView (Context context, AttributeSet attributes, int style) {
        super(context, attributes, style);
        getHolder().addCallback(this);
        setOnTouchListener(this);
    }
    public JoyStickView (Context context, AttributeSet attributes) {
        super(context, attributes);
        getHolder().addCallback(this);
        setOnTouchListener(this);
    }
    private void drawJoystick(float newX, float newY) {
        if (getHolder().getSurface().isValid()) {
            Canvas myCanvas = this.getHolder().lockCanvas();
            Paint colors = new Paint();
            myCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            colors.setARGB(255,50,50,50);
            myCanvas.drawCircle(centerX, centerY, baseRadius, colors);
            colors.setARGB(255,0,0,255);
            myCanvas.drawCircle(newX, newY, hatRadius, colors);
            getHolder().unlockCanvasAndPost(myCanvas);
        }
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        setupDimensions();
        drawJoystick(centerX,centerY);

    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
    public boolean onTouch(View v, MotionEvent e) {
        if (v.equals(this)) {
            if (e.getAction() != e.ACTION_UP)
                drawJoystick(e.getX(), e.getY());
            else
                drawJoystick(centerX, centerY);
        }
        return true;
    }
    public interface JoystickListener {
        void onJoystickMoved(float xPercent, float yPercent, int id);
    }
}
