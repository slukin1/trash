package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

public class HmsHiAnalyticsUtils {
    public static void enableLog() {
        c.a();
    }

    public static boolean getInitFlag() {
        return a.b();
    }

    public static void init(Context context, boolean z11, boolean z12, boolean z13, String str, String str2) {
        new b(context).a(z11).c(z12).b(z13).a(0, str).a(1, str).a(str2).a();
    }

    public static void onEvent(Context context, String str, String str2) {
        a.a(context, str, str2);
    }

    public static void onReport() {
        a.c();
    }

    public static void onStreamEvent(int i11, String str, LinkedHashMap<String, String> linkedHashMap) {
        a.b(i11, str, linkedHashMap);
    }

    public static void onEvent(int i11, String str, LinkedHashMap<String, String> linkedHashMap) {
        a.a(i11, str, linkedHashMap);
    }
}
