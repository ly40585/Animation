package com.example.root.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Demo8Fragment extends Fragment {

    private String TAG = "linyuan";
    private ValueAnimator anim;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "Demo5Fragment onCreateView");

        View view = inflater.inflate(R.layout.demo4, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(textView, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();

        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Demo5Fragment onDestroy");
        //anim.cancel();
    }
}