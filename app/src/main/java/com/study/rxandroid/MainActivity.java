package com.study.rxandroid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.study.rxandroid.RxJavaUtils.Functions.All;
import com.study.rxandroid.RxJavaUtils.Functions.Amb;
import com.study.rxandroid.RxJavaUtils.Functions.CombineLatest;
import com.study.rxandroid.RxJavaUtils.Functions.Concat;
import com.study.rxandroid.RxJavaUtils.Functions.Delay;
import com.study.rxandroid.RxJavaUtils.Functions.GroupBy;
import com.study.rxandroid.RxJavaUtils.Functions.MathFunction;
import com.study.rxandroid.RxJavaUtils.Functions.Merge;
import com.study.rxandroid.RxJavaUtils.Functions.Scan;
import com.study.rxandroid.RxJavaUtils.Functions.SkipUntil;
import com.study.rxandroid.RxJavaUtils.Functions.SwitchMap;
import com.study.rxandroid.RxJavaUtils.Functions.TakeUntil;
import com.study.rxandroid.RxJavaUtils.Functions.TimeInterval;
import com.study.rxandroid.RxJavaUtils.Functions.Zip;
import com.study.rxandroid.RxJavaUtils.Log;
import com.study.rxandroid.RxJavaUtils.Sheduler.Computation;
import com.study.rxandroid.RxJavaUtils.Sheduler.IO;
import com.study.rxandroid.RxJavaUtils.Sheduler.NewThread;
import com.study.rxandroid.RxJavaUtils.Sheduler.SubscribeOn;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IO.getListofFiles();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}