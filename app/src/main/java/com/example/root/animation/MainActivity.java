package com.example.root.animation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public static String TAG = "linyuan";
    private Spinner mSpinner;
    FragmentTransaction transaction;
    FragmentManager fm;

    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinner = (Spinner) findViewById(R.id.spinner_list);
        mSpinner.setOnItemSelectedListener(this);
        fm = getFragmentManager();
        addFragments();
    }

    private void addFragments() {
        fragmentList.add(new Demo1Fragment());
        fragmentList.add(new Demo2Fragment());
        fragmentList.add(new Demo3Fragment());
        fragmentList.add(new Demo4Fragment());
        fragmentList.add(new Demo5Fragment());
        fragmentList.add(new Demo6Fragment());
        fragmentList.add(new Demo7Fragment());
        fragmentList.add(new Demo8Fragment());
        fragmentList.add(new Demo9Fragment());
        fragmentList.add(new Demo10Fragment());
        fragmentList.add(new Demo11Fragment());

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG, "click, position = " + position);
        transaction = fm.beginTransaction();
        transaction.replace(R.id.frame_layout, fragmentList.get(position));
        transaction.commit();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.i(TAG, "on nothing selected");
    }


}
