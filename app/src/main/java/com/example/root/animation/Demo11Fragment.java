package com.example.root.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Demo11Fragment extends Fragment {

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

        Animator animator = AnimatorInflater.loadAnimator(getActivity(), R.animator.demo11);
        animator.setTarget(textView);

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