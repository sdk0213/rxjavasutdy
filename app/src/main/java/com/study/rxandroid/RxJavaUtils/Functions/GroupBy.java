package com.study.rxandroid.RxJavaUtils.Functions;

import com.study.rxandroid.RxJavaUtils.CommonUtils;
import com.study.rxandroid.RxJavaUtils.Exam.Shape;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.GroupedObservable;

public class GroupBy {

    public static void fun(){
        String[] objs = {"6", "4", "2-T","2", "6-T", "4-T"};
        Observable<GroupedObservable<String, String>> source =
                Observable.fromArray(objs).groupBy(Shape::getShape);

        source.subscribe(obj -> {
            obj.subscribe(
                    val -> System.out.println("GROUP:" + obj.getKey() + "\t Value:" + val)
            );
        });
    }
}
