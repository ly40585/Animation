package com.example.root.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    public static String TAG = "linyuan";
    private Spinner mSpinner;
    private FrameLayout mFrameLayout;
    private Button mButton;
    FragmentTransaction transaction;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinner = (Spinner) findViewById(R.id.spinner_list);
        mButton = (Button) findViewById(R.id.button);
        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        mSpinner.setOnItemSelectedListener(this);
        mButton.setOnClickListener(this);
        fm = getFragmentManager();

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG, "click, position = " + position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.i(TAG, "on nothing selected");
    }

    @Override
    public void onClick(View v) {
        int position = mSpinner.getSelectedItemPosition();
        Log.i(TAG, "button click, item id = " + position);
        transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                transaction.replace(R.id.frame_layout, new Demo1Fragment());
                break;
            case 1:
                transaction.replace(R.id.frame_layout, new Demo2Fragment());
                break;
            case 2:
                transaction.replace(R.id.frame_layout, new Demo3Fragment());
                break;
            case 3:
                transaction.replace(R.id.frame_layout, new Demo4Fragment());
                break;
            case 4:
                transaction.replace(R.id.frame_layout, new Demo5Fragment());
                break;
            case 5:
                transaction.replace(R.id.frame_layout, new Demo6Fragment());
                break;
            case 6:
                transaction.replace(R.id.frame_layout, new Demo7Fragment());
                break;
            case 7:
                transaction.replace(R.id.frame_layout, new Demo8Fragment());
                break;
            case 8:
                transaction.replace(R.id.frame_layout, new Demo9Fragment());
                break;
            case 9:
                transaction.replace(R.id.frame_layout, new Demo10Fragment());
                break;
            case 10:
                transaction.replace(R.id.frame_layout, new Demo11Fragment());
                break;
            case 11:
                transaction.replace(R.id.frame_layout, new Demo12Fragment());
                break;
        }
        transaction.commit();
    }

}
