package com.example.root.animation;

import android.animation.TimeInterpolator;
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
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;


public class Demo10Fragment extends Fragment implements View.OnClickListener {

    private String TAG = "linyuan";
    private MyAnimViewDemo10 myview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "Demo3Fragment onCreateView");
        View view = inflater.inflate(R.layout.demo10, container, false);
        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);
        Button button4 = (Button) view.findViewById(R.id.button4);

        myview = (MyAnimViewDemo10) view.findViewById(R.id.myview);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            myview.start(1);
        } else if (v.getId() == R.id.button2) {
            myview.start(2);
        } else if (v.getId() == R.id.button3) {
            myview.start(3);
        } else if (v.getId() == R.id.button4) {
            myview.start(4);
        }
    }


}

class MyAnimViewDemo10 extends View {
    private int animation = 1;
    private PointDemo10 currentPoint;

    private Paint mPaint;
    public static final float RADIUS = 50f;
    private String color;

    public MyAnimViewDemo10(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            currentPoint = new PointDemo10(getWidth() / 2, RADIUS);
            drawCircle(canvas);
            if (animation == 1) {
                startAnimation1();
            } else if (animation == 2) {
                startAnimation2();
            } else if (animation == 3) {
                startAnimation3();
            } else if (animation == 4) {
                startAnimation4();
            }
        } else {
            drawCircle(canvas);
        }
    }

    private void startAnimation4() {
         PointDemo10 startPoint = new PointDemo10(getWidth() / 2, RADIUS);
             PointDemo10 endPoint = new PointDemo10(getWidth() / 2, getHeight() - RADIUS);
             ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluatorDemo10(), startPoint, endPoint);
             anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                     @Override
                     public void onAnimationUpdate(ValueAnimator animation) {
                             currentPoint = (PointDemo10) animation.getAnimatedValue();
                             invalidate();
                         }
                 });
             anim.setInterpolator(new DecelerateAccelerateInterpolator());
             anim.setDuration(3000);
             anim.start();
    }

    private void startAnimation3() {
        PointDemo10 startPoint = new PointDemo10(getWidth() / 2, RADIUS);
        PointDemo10 endPoint = new PointDemo10(getWidth() / 2, getHeight() - RADIUS);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluatorDemo10(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (PointDemo10) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setInterpolator(new BounceInterpolator());
        anim.setDuration(3000);
        anim.start();
    }

    public void start(int animation) {
        currentPoint = null;
        this.animation = animation;
        invalidate();
    }

    private void drawCircle(Canvas canvas) {
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }

    private void startAnimation2() {
        PointDemo10 startPoint = new PointDemo10(getWidth() / 2, RADIUS);
        PointDemo10 endPoint = new PointDemo10(getWidth() / 2, getHeight() - RADIUS);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluatorDemo10(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (PointDemo10) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setInterpolator(new AccelerateInterpolator(2f));
        anim.setDuration(2500);
        anim.start();
    }

    private void startAnimation1() {
        PointDemo10 startPoint = new PointDemo10(getWidth() / 2, RADIUS);
        PointDemo10 endPoint = new PointDemo10(getWidth() / 2, getHeight() - RADIUS);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluatorDemo10(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (PointDemo10) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setDuration(2000);
        anim.start();
    }


}


class PointDemo10 {

    private float x;

    private float y;

    public PointDemo10(float x, float y) {
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

class PointEvaluatorDemo10 implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        PointDemo10 startPoint = (PointDemo10) startValue;
        PointDemo10 endPoint = (PointDemo10) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        PointDemo10 point = new PointDemo10(x, y);
        return point;
    }

}

class DecelerateAccelerateInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        float result;
        if (input <= 0.5) {
            result = (float) (Math.sin(Math.PI * input)) / 2;
        } else {
            result = (float) (2 - Math.sin(Math.PI * input)) / 2;
        }
        return result;
    }

}



