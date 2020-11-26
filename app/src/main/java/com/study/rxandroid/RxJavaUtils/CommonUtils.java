package com.study.rxandroid.RxJavaUtils;

import java.util.Random;

public class CommonUtils {
    public static long startTime;

    public static void exampleStart() {
        startTime = System.currentTimeMillis();
    }

    public static void exampleComplete() {
        startTime = System.currentTimeMillis();
    }

    public static void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getThreadName() {
        String threadName = Thread.currentThread().getName();
        if (threadName.length() > 30) {
            threadName = threadName.substring(0, 30) + "...";
        }
        return threadName;
    }

    public static void doSomething() {
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getShape(String obj) {
        if (obj == null || obj.equals("")) return "NO-SHAPE";
        if (obj.endsWith("-H")) return "HEXAGON";
        if (obj.endsWith("-O")) return "OCTAGON";
        if (obj.endsWith("-R")) return "RECTANGLE";
        if (obj.endsWith("-T")) return "TRIANGLE";
        if (obj.endsWith("-◇")) return "DIAMOND";
        return "BALL";
    }
}

