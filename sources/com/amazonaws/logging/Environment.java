package com.amazonaws.logging;

public final class Environment {
    public static boolean a() {
        for (StackTraceElement className : Thread.currentThread().getStackTrace()) {
            if (className.getClassName().startsWith("org.junit.")) {
                return true;
            }
        }
        return false;
    }
}
