package com.study.rxandroid.RxJavaUtils.Sheduler;

import com.study.rxandroid.RxJavaUtils.CommonUtils;
import com.study.rxandroid.RxJavaUtils.Log;
import com.study.rxandroid.RxJavaUtils.OkHttpHelper;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static com.study.rxandroid.RxJavaUtils.CommonUtils.GITHUB_ROOT;

public class CallBackHeaven {
    private static final String FIRST_URL = "https://api.github.com/zen";
    private static final String SECOND_URL = GITHUB_ROOT + "/samples/callback_heaven";

    public void run() {
        CommonUtils.exampleStart();
        Observable<String> source = Observable.just(FIRST_URL)
                .subscribeOn(Schedulers.io())
                .map(OkHttpHelper::get)
                .concatWith(Observable.just(SECOND_URL)
                        .map(OkHttpHelper::get));
        source.subscribe(Log::it);
        CommonUtils.sleep(5000);
        CommonUtils.exampleComplete();
    }
}
