package com.study.rxandroid.RxJavaUtils.Functions;

import com.study.rxandroid.RxJavaUtils.Log;

import io.reactivex.rxjava3.core.Observable;

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