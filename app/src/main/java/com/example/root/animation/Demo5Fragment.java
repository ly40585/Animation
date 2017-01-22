package com.example.root.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Demo5Fragment extends Fragment {

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
        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);
        anim.setDuration(5000);
        anim.start();

        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Demo5Fragment onDestroy");
        //anim.cancel();
    }
}