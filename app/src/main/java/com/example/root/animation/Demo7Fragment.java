package com.example.root.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Demo7Fragment extends Fragment implements View.OnClickListener {

    private String TAG = "linyuan";
    private ValueAnimator anim;

    private View log_layout;
    private View textView_layout;
    private TextView log;
    private TextView textview;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "Demo7Fragment onCreateView");
        View view = inflater.inflate(R.layout.demo7, container, false);
        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        log_layout = view.findViewById(R.id.log_layout);
        textView_layout = view.findViewById(R.id.textview_layout);
        log = (TextView) view.findViewById(R.id.log);
        textview = (TextView) view.findViewById(R.id.textview);
        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Demo3Fragment onDestroy");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                log.setText("");
                log_layout.setVisibility(View.VISIBLE);
                textView_layout.setVisibility(View.GONE);
                ValueAnimator animator1 = (ValueAnimator) AnimatorInflater.loadAnimator(getActivity(), R.animator.demo7_1);
                animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Log.i(TAG, ""+animation.getAnimatedValue());
                        log.setText(""+ log.getText() + "value = " + animation.getAnimatedValue()+"\n");
                    }
                });
                animator1.start();
                break;
            case R.id.button2:
                log_layout.setVisibility(View.GONE);
                textView_layout.setVisibility(View.VISIBLE);
                Animator animator2 = AnimatorInflater.loadAnimator(getActivity(), R.animator.demo7_2);
                animator2.setTarget(textview);
                animator2.start();
                break;
            case R.id.button3:
                log_layout.setVisibility(View.GONE);
                textView_layout.setVisibility(View.VISIBLE);
                Animator animator3 = AnimatorInflater.loadAnimator(getActivity(), R.animator.demo7_3);
                animator3.setTarget(textview);
                animator3.start();
                break;
        }
    }
}