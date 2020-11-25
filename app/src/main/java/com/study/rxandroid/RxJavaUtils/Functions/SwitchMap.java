package com.study.rxandroid.RxJavaUtils.Functions;

import com.study.rxandroid.RxJavaUtils.CommonUtils;
import com.study.rxandroid.RxJavaUtils.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class SwitchMap {

    public static void fun(){
        CommonUtils.exampleStart();

        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(idx -> balls[idx])
                .take(balls.length)
                .doOnNext(Log::it) // 중간 결과 확인요 함수
                .switchMap(
                        ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                                .map(notUsed -> ball + "◇")
                                .take(2)
                );
        source.subscribe(Log::it);
        CommonUtils.sleep(2000);
    }
}
