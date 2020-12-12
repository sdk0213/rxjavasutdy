package com.study.rxandroid.RxJavaUtils.Exam;

public class Shape {
    public static final String HEXAGON = "HEXAGON";
    public static final String OCTAGON = "OCTAGON";
    public static final String RECTANGLE = "RECTANGLE";
    public static final String TRIANGLE = "TRIANGLE";
    public static final String DIAMOND = "DIAMOND";
    public static final String PENTAGON = "PENTAGON";
    public static final String BALL = "BALL";
    public static final String STAR = "STAR";
    public static final String NO_SHAPE = "NO_SHAPE";
    public static final String FLIPPED = "(flipped)";

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

    public static String getShape(String obj) {
        if (obj == null || obj.equals("")) return NO_SHAPE;
        if (obj.endsWith("-H")) return HEXAGON;
        if (obj.endsWith("-O")) return OCTAGON;
        if (obj.endsWith("-R")) return RECTANGLE;
        if (obj.endsWith("-T")) return TRIANGLE;
        if (obj.endsWith("<>")) return DIAMOND;
        if (obj.endsWith("-P")) return PENTAGON;
        if (obj.endsWith("-S")) return STAR;
        return "BALL";
    }
}
