package com.study.rxandroid.RxJavaUtils.Functions;

import com.study.rxandroid.RxJavaUtils.Exam.Shape;
import com.study.rxandroid.RxJavaUtils.Log;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class All {

    public static void fun(){
        String[] data = {"1", "2", "3", "4"};
        String[] data2 = {"1", "2", "3", "-H"};

        Single<Boolean> source = Observable.fromArray(data)
                .map(Shape::getShape)
                .all(Shape.BALL::equals);
        Single<Boolean> source2 = Observable.fromArray(data2)
                .map(Shape::getShape)
                .all(Shape.BALL::equals);
        // .all(val -> Shape.BALL.equals(Shape.getShape(val)));
        source.subscribe(val -> Log.i(val));
        source2.subscribe(val -> Log.i(val));
    }
}
