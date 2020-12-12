package com.study.rxandroid.RxJavaUtils.Functions;

import com.study.rxandroid.RxJavaUtils.Log;

import hu.akarnokd.rxjava3.math.MathFlowable;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class MathFunction {

    public static void fun(){
        Integer[] data = {1, 2, 3, 4};

        // 1. count
        Single<Long> source = Observable.fromArray(data)
                .count();
        source.subscribe(count -> Log.i("Count is " + count));

        // to() 함수는 타입을 변환해주는 함수이다.

        // 2. max() & min
        Flowable.fromArray(data)
                .to(MathFlowable::max)
                .subscribe(max -> Log.i("max is " + max));

        Flowable.fromArray(data)
                .to(MathFlowable::min)
                .subscribe(min -> Log.i("min is " + min));

        // 3. sum()
        Flowable<Integer> flowable = Flowable.fromArray(data)
                .to(MathFlowable::sumInt);
        flowable.subscribe(sum -> Log.i("sum is " + sum));


        // toFlowable() 함수는 Observable 타입을 Flowable 로 변환해주는 함수이다.
        // 4. average()
        Flowable<Double> flowable2 = Observable.fromArray(data)
                .toFlowable(BackpressureStrategy.BUFFER)
                .to(MathFlowable::averageDouble);
        flowable2.subscribe(avg -> Log.i("average is " + avg));
    }
}
