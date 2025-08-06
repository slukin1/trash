package com.tekartik.sqflite;

import io.flutter.plugin.common.MethodCall;

public class LogLevel {
    public static Integer a(MethodCall methodCall) {
        return (Integer) methodCall.argument("logLevel");
    }

    public static boolean b(int i11) {
        return i11 >= 1;
    }

    public static boolean c(int i11) {
        return i11 >= 2;
    }
}
