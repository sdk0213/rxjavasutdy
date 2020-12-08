package com.study.rxandroid.RxJavaUtils.Functions;

import com.study.rxandroid.RxJavaUtils.CommonUtils;
import com.study.rxandroid.RxJavaUtils.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;

public class Concat {

    public static void fun(){
        // Action 클래스 (io.reactive.functions)
        Action onCompleteAction = () -> Log.d("onComplete()");

        String[] data1 = {"1", "3", "5"};
        String[] data2 = {"2", "4", "6"};
        Observable<String> source1 = Observable.fromArray(data1)
                .doOnComplete(onCompleteAction);
        Observable<String> source2 = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(idx -> data2[idx])
                .take(data2.length)
                .doOnComplete(onCompleteAction);

        // source1 과 source2 를 concat 으로 합친 source 를 만들었다.
        Observable<String> source = Observable.concat(source1, source2)
                .doOnComplete(onCompleteAction);

        source.subscribe(Log::i);
        CommonUtils.sleep(1000);
    }
}
