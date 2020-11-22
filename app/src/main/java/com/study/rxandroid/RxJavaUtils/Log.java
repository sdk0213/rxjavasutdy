package com.study.rxandroid.RxJavaUtils;

import static com.study.rxandroid.RxJavaUtils.CommonUtils.getThreadName;

public class Log {
    public static void it(Object obj) {
        long time = System.currentTimeMillis() - CommonUtils.startTime;
        System.out.println(getThreadName() + " | " + time + " | " + "value = " + obj);

    }
}
