package com.s33me.myjoystick;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.drawable.*;
import android.view.animation.*;

public class MainActivity extends Activity implements JoyStickView.JoystickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        JoyStickView joystick = new JoyStickView(this);
        setContentView(R.layout.main);
    }

    @Override
    public void onJoystickMoved(float xPercent, float yPercent, int id)
    {
        // TODO: Implement this method
    }
    public void didTapButton1(View view) {
        Button button = (Button)findViewById(R.id.on);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button.startAnimation(myAnim);

    }
    public void didTapButton2(View view) {
        Button button2 = (Button)findViewById(R.id.off);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button2.startAnimation(myAnim);

    }
    public void didTapButton3(View view) {
        Button button3 = (Button)findViewById(R.id.walk);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button3.startAnimation(myAnim);

    }
    public void didTapButton4(View view) {
        Button button4 = (Button)findViewById(R.id.run);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button4.startAnimation(myAnim);

    }
    public void didTapButton5(View view) {
        Button button5 = (Button)findViewById(R.id.eat);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button5.startAnimation(myAnim);

    }
    public void didTapButton6(View view) {
        Button button6 = (Button)findViewById(R.id.sleep);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button6.startAnimation(myAnim);

    }
}
