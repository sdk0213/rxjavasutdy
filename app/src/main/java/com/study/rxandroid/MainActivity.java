package com.study.rxandroid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.study.rxandroid.RxJavaUtils.Functions.Amb;
import com.study.rxandroid.RxJavaUtils.Functions.CombineLatest;
import com.study.rxandroid.RxJavaUtils.Functions.Concat;
import com.study.rxandroid.RxJavaUtils.Functions.GroupBy;
import com.study.rxandroid.RxJavaUtils.Functions.Merge;
import com.study.rxandroid.RxJavaUtils.Functions.Scan;
import com.study.rxandroid.RxJavaUtils.Functions.SwitchMap;
import com.study.rxandroid.RxJavaUtils.Functions.Zip;
import com.study.rxandroid.RxJavaUtils.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Amb.fun();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}