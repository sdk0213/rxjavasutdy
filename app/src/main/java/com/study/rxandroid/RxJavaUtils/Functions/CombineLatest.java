package com.study.rxandroid.RxJavaUtils.Functions;

import android.annotation.SuppressLint;

import com.study.rxandroid.RxJavaUtils.CommonUtils;
import com.study.rxandroid.RxJavaUtils.Exam.Shape;
import com.study.rxandroid.RxJavaUtils.Log;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;

public class CombineLatest {

    public static void fun(){
        String[] data1 = {"6", "7", "4", "2"};
        String[] data2 = {"DIAMOND", "STAR", "PENTAGON"};

        Observable<String> source = Observable.combineLatest(
                Observable.fromArray(data1)
                        .zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS),
                                (shape, notUsed) -> Shape.getColor(shape)),
                Observable.fromArray(data2)
                        .zipWith(Observable.interval(150L, 200L, TimeUnit.MILLISECONDS),
                                (shape, notUsed) -> Shape.getSuffix(shape)), (v1, v2) -> v1 + v2);

        source.subscribe(Log::i);
        CommonUtils.sleep(1000);
    }

    public static void fun_cal(){
        ConnectableObservable<String> source = userInput();
        Observable<Integer> a = source
                .filter(str -> str.startsWith("a:"))
                .map(str -> str.replace("a:", ""))
                .map(Integer::parseInt);
        Observable<Integer> b = source
                .filter(str -> str.startsWith("b:"))
                .map(str -> str.replace("b:", ""))
                .map(Integer::parseInt);
        Observable.combineLatest(
                a.startWith(0),
                b.startWith(0),
                (x,y) -> x+y)
                .skip(1)
                .subscribe(res -> System.out.println("Result : " + res));
        source.connect();

    }

    public static ConnectableObservable<String> userInput() {
        return Observable.create((ObservableEmitter<String> emitter) -> {
            Scanner in = new Scanner(System.in);
            while (true) {
                System.out.println("Input: ");
                String line = in.nextLine();
                emitter.onNext(line);

                if (line.indexOf("exit") >= 0) {
                    in.close();
                    break;
                }
            }
        }).publish();
    }

}
