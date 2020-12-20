package com.study.rxandroid.RxJavaUtils.Sheduler;

import com.study.rxandroid.RxJavaUtils.CommonUtils;
import com.study.rxandroid.RxJavaUtils.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ExecutorScheduler {

    public static void fun(){
        final int THREAD_NUM = 10;

        String[] data = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(data);
        Executor executor = (Executor) Executors.newFixedThreadPool(THREAD_NUM);

        for (int i = 0; i < 2; i++) {
            source.subscribeOn(Schedulers.from(executor))
                    .subscribe(Log::i);
        }
        CommonUtils.sleep(500);
    }
}
