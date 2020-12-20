package com.study.rxandroid.RxJavaUtils.Sheduler;

import com.study.rxandroid.RxJavaUtils.CommonUtils;
import com.study.rxandroid.RxJavaUtils.Log;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TrampolineScheduler {

    public static void fun(){
        String[] orgs = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(orgs);

        // 구독 #1
        source.subscribeOn(Schedulers.trampoline())
                .map(data -> "<<" + data + ">>")
                .subscribe(Log::i);

        // 구독 #2
        source.subscribeOn(Schedulers.trampoline())
                .map(data -> "##" + data + "##")
                .subscribe(Log::i);
        CommonUtils.sleep(500);
    }
}
