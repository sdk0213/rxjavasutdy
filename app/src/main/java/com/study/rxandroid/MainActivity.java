package com.study.rxandroid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.study.rxandroid.RxJavaUtils.CommonUtils;

public class MainActivity extends AppCompatActivity {

    private TextView mTestTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestTextview = findViewById(R.id.testview);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}