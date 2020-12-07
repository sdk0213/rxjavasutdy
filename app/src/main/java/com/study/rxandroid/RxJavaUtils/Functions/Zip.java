package com.study.rxandroid.RxJavaUtils.Functions;

import org.apache.commons.lang3.tuple.Pair;

import com.study.rxandroid.RxJavaUtils.CommonUtils;
import com.study.rxandroid.RxJavaUtils.Exam.Shape;
import com.study.rxandroid.RxJavaUtils.Log;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Zip {

    public static void fun() {
        String[] shapes = {"BALL", "PENTAGON", "STAR"};
        String[] coloredTriangles = {"2-T", "6-T", "4-T"};

        Observable<String> source = Observable.zip(
                Observable.fromArray(shapes).map(Shape::getSuffix), // 모양 가져오기
                Observable.fromArray(coloredTriangles).map(Shape::getColor), // 색상 가져오기
                (suffix, color) -> color + suffix);

        source.subscribe(Log::it);

    }

    public static void zipNumbers(){
        Observable<Integer> source = Observable.zip(
                Observable.just(100, 200, 300),
                Observable.just(10, 20, 30),
                Observable.just(1, 2, 3),
                (a, b, c) -> a + b + c );
        source.subscribe(Log::it);
    }


    public static void zipinterval(){
        Observable<String> source = Observable.zip(
                Observable.just("RED", "GREEN", "BLUE"),
                Observable.interval(200L, TimeUnit.MILLISECONDS),
                (value, i) -> value);

        CommonUtils.exampleStart();
        source.subscribe(Log::it);
        CommonUtils.sleep(1000);
    }

    public static void caleleBill(){
        ElctricBill eb = new ElctricBill();
        eb.cal();
    }

    public static void caleleBill_non_sideeffect(){
        ElctricBill eb = new ElctricBill();
        eb.cal_non_sideeffect();
    }

    public static void zipWith(){
        Observable<Integer> source = Observable.zip(
                Observable.just(100, 200, 300),
                Observable.just(10, 20, 30),
                (a, b) -> a + b)
                .zipWith(Observable.just(1, 2, 3), (ab, c) -> ab + c);
        source.subscribe(Log::i);
    }
}

class ElctricBill{

    private int index = 0;

    public void cal(){

        String[] data = {"100", "300"};

        Observable<Integer> basePrice = Observable.fromArray(data)
                .map(Integer::parseInt)
                .map(val -> {
                            if (val <= 200) return 910;
                            if (val <= 400) return 1600;
                            return 7300;
                        }
                );

        Observable<Integer> usagePrice = Observable.fromArray(data)
                .map(Integer::parseInt)
                .map(val -> {
                            double series1 = min(200, val) * 93.3;
                            double series2 = min(200, max(val-200, 0)) * 187.9;
                            double series3 = min(0, max(val-400, 0)) * 280.56;
                            return (int)(series1 + series2 + series3);
                        }
                );

        Observable<Integer> source = Observable.zip(
                basePrice,
                usagePrice,
                (v1, v2) -> v1 + v2);

        // result:
        source.map(val -> new DecimalFormat("#,###").format(val))
                .subscribe(val -> {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Usage: " + data[index] + " kWh => ");
                            sb.append("Price " + val + "원");
                            Log.i(sb.toString());

                            index++; // 부수 효
                        }
                );
    }

    public void cal_non_sideeffect(){
        String[] data = {"100", "300"};

        Observable<Integer> basePrice = Observable.fromArray(data)
                .map(Integer::parseInt)
                .map(val -> {
                            if (val <= 200) return 910;
                            if (val <= 400) return 1600;
                            return 7300;
                        }
                );

        Observable<Integer> usagePrice = Observable.fromArray(data)
                .map(Integer::parseInt)
                .map(val -> {
                            double series1 = min(200, val) * 93.3;
                            double series2 = min(200, max(val-200, 0)) * 187.9;
                            double series3 = min(0, max(val-400, 0)) * 280.56;
                            return (int)(series1 + series2 + series3);
                        }
                );

        Observable<Pair<String,Integer>> source = Observable.zip(
                basePrice,
                usagePrice,
                Observable.fromArray(data),
                (v1, v2, i) -> Pair.of(i, v1 + v2));

        // result:
        source.map(val -> Pair.of(val.getLeft(),
                new DecimalFormat("#,###").format(val.getValue())))
                .subscribe(val -> {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Usage: " + val.getLeft() + " kWh => ");
                            sb.append("Price " + val.getRight() + "원");
                            Log.i(sb.toString());

                            }
                            );

    }
}