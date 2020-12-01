package com.study.rxandroid.RxJavaUtils.Functions;

import com.study.rxandroid.RxJavaUtils.Log;

import io.reactivex.rxjava3.core.Observable;

public class Scan {

    public static void fun() {
        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .scan( (ball1, ball2) -> ball2 + "(" + ball1 + ")");
        source.subscribe(Log::it);

    }
}
