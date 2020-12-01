package com.study.rxandroid.RxJavaUtils.Functions;

import com.study.rxandroid.RxJavaUtils.CommonUtils;
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
}

class Shape {
    public static final String HEXAGON = "HEXAGON";
    public static final String OCTAGON = "OCTAGON";
    public static final String RECTANGLE = "RECTANGLE";
    public static final String TRIANGLE = "TRIANGLE";
    public static final String DIAMOND = "DIAMOND";
    public static final String PENTAGON = "PENTAGON";
    public static final String BALL = "BALL";
    public static final String STAR = "STAR";

    public static String getColor(String shape) {
        if (shape.endsWith("◇"))  // 다이아몬드 표시.
            return shape.replace("◇", "").trim();

        int hyphen = shape.indexOf("-");
        if (hyphen > 0) {
            return shape.substring(0, hyphen);
        }
        return shape;    // 원의 경우
    }

    public static String getSuffix(String shape) {
        if (HEXAGON.equals(shape)) return "-H";
        if (OCTAGON.equals(shape)) return "-O";
        if (RECTANGLE.equals(shape)) return "-R";
        if (TRIANGLE.equals(shape)) return "-T";
        if (DIAMOND.equals(shape)) return "◇";
        if (PENTAGON.equals(shape)) return "-P";
        if (STAR.equals(shape)) return "-S";
        return "";    // 원의 경우
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
}