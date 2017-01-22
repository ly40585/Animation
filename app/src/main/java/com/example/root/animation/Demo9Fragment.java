package com.example.root.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
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


public class Demo9Fragment extends Fragment {

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
        view.findViewById(R.id.textview).setVisibility(View.GONE);
        final TextView textView = (TextView) view.findViewById(R.id.log);

        ValueAnimator animator = (ValueAnimator) AnimatorInflater.loadAnimator(getActivity(), R.animator.demo9);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i(TAG, ""+animation.getAnimatedValue());
                textView.setText(""+textView.getText() + "value = " + animation.getAnimatedValue()+"\n");
            }
        });
        animator.start();


        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Demo5Fragment onDestroy");
        //anim.cancel();
    }
}