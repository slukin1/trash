package com.tencent.qcloud.tuikit.timcommon.util;

import com.tencent.imsdk.common.IMLog;

public class TIMCommonLog extends IMLog {
    private static final String PRE = "TIMCommon-";

    public static void d(String str, String str2) {
        IMLog.d(mixTag(str), str2);
    }

    public static void e(String str, String str2) {
        IMLog.e(mixTag(str), str2);
    }

    public static void i(String str, String str2) {
        IMLog.i(mixTag(str), str2);
    }

    private static String mixTag(String str) {
        return PRE + str;
    }

    public static void v(String str, String str2) {
        IMLog.v(mixTag(str), str2);
    }

    public static void w(String str, String str2) {
        IMLog.w(mixTag(str), str2);
    }

    public static void w(String str, String str2, Throwable th2) {
        String mixTag = mixTag(str);
        IMLog.w(mixTag, str2 + th2.getMessage());
    }
}
