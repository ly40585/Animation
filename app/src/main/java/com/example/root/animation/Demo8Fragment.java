package com.example.root.animation;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Demo8Fragment extends Fragment implements View.OnClickListener {

    private String TAG = "linyuan";
    private MyAnimViewDemo8 myview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "Demo3Fragment onCreateView");
        View view = inflater.inflate(R.layout.demo8, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        myview = (MyAnimViewDemo8) view.findViewById(R.id.myview);
        button.setOnClickListener(this);
        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Demo3Fragment onDestroy");
    }


    @Override
    public void onClick(View v) {
        myview.start();
    }






}

class PointDemo8 {

    private float x;

    private float y;

    public PointDemo8(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

}

class PointEvaluatorDemo8 implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        PointDemo8 startPoint = (PointDemo8) startValue;
        PointDemo8 endPoint = (PointDemo8) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        PointDemo8 point = new PointDemo8(x, y);
        return point;
    }

}
class MyAnimViewDemo8 extends View {

    public static final float RADIUS = 50f;

    private PointDemo8 currentPoint;

    private Paint mPaint;

    public MyAnimViewDemo8(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            currentPoint = new PointDemo8(RADIUS, RADIUS);
            drawCircle(canvas);
            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }

    private void startAnimation() {
        PointDemo8 startPoint = new PointDemo8(RADIUS, RADIUS);
        PointDemo8 endPoint = new PointDemo8(getWidth() - RADIUS, getHeight() - RADIUS);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluatorDemo8(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (PointDemo8) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setDuration(5000);
        anim.start();
    }

    public void start() {
        currentPoint = null;
        invalidate();
    }

}


