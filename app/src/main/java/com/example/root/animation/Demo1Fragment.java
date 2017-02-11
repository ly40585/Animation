package com.example.root.animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Demo1Fragment extends Fragment implements View.OnClickListener {

    private String TAG = "linyuan";
    private ValueAnimator anim;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo1, container, false);
        final TextView textView = (TextView) view.findViewById(R.id.log);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);
        anim = ValueAnimator.ofFloat(0f, 5f, 3f, 10f);
        anim.setDuration(1000);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Object currentValue = animation.getAnimatedValue();
                Log.i(TAG, "curent value is " + currentValue);
                textView.setText(textView.getText()+"curent value is " + currentValue+"\n");
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Demo1Fragment onDestroy");
        //anim.cancel();
    }

    @Override
    public void onClick(View v) {
        anim.start();
    }
}