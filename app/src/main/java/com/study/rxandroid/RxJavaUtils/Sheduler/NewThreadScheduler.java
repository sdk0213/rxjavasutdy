package com.study.rxandroid.RxJavaUtils.Sheduler;

import com.study.rxandroid.RxJavaUtils.CommonUtils;
import com.study.rxandroid.RxJavaUtils.Exam.Shape;
import com.study.rxandroid.RxJavaUtils.Log;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewThreadScheduler {

    public static void flip(){
        String[] objs = {"1-S", "2-T", "3-P"};
        Observable<String> source = Observable.fromArray(objs)
                .doOnNext(data -> Log.v("Original data = " + data))
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread()) // 쓰레드 지정
                .map(Shape::flip);
        source.subscribe(Log::i);
        CommonUtils.sleep(500);
    }

    public static void flipWithNonObserveOn(){
        String[] objs = {"1-S", "2-T", "3-P"};
        Observable<String> source = Observable.fromArray(objs)
                .doOnNext(data -> Log.v("Original data = " + data))
                .subscribeOn(Schedulers.newThread())
      //          .observeOn(Schedulers.newThread()) // 쓰레드 지정
                .map(Shape::flip);
        source.subscribe(Log::i);
        CommonUtils.sleep(500);
    }
}
