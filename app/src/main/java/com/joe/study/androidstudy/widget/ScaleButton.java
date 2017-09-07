package com.joe.study.androidstudy.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/**
 * @Author zongdongdong on 2017/8/21.
 * {@link }
 */

public class ScaleButton extends AppCompatButton {
    public ScaleButton(Context context) {
        super(context);
    }

    public ScaleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                beginScale();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                endScale();
                break;
            case MotionEvent.ACTION_CANCEL:
                endScale();
                break;
        }
        return true;
    }

    private synchronized void beginScale() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 0.93f, 1f, 0.93f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(80);
        scaleAnimation.setFillAfter(true);
        this.startAnimation(scaleAnimation);
    }

    private synchronized void endScale() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.93f, 1.0f, 0.93f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(80);
        scaleAnimation.setFillAfter(true);
        this.startAnimation(scaleAnimation);
    }


}
