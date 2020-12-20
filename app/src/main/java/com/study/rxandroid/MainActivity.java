package com.study.rxandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.study.rxandroid.RxJavaUtils.Sheduler.CallBackHeaven;
import com.study.rxandroid.RxJavaUtils.Sheduler.CallBackHell;
import com.study.rxandroid.RxJavaUtils.Sheduler.ExecutorScheduler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CallBackHeaven ch = new CallBackHeaven();
        ch.run();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}