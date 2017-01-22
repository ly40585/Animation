package com.example.root.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Demo2Fragment extends Fragment {

    private String TAG = "linyuan";
    private ValueAnimator anim;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        anim = ValueAnimator.ofFloat(0f, 5f, 3f, 10f);
        anim.setDuration(1000);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Object currentValue = animation.getAnimatedValue();
                Log.i(TAG, "curent value is " + currentValue);
            }
        });
        anim.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Demo2Fragment onDestroy");
        //anim.cancel();
    }
}