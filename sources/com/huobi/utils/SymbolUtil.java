package com.huobi.utils;

import android.text.TextUtils;
import d7.a1;

public class SymbolUtil {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return a1.v().D(str);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return a1.v().n(str);
    }

    public static String c(String str, boolean z11) {
        if (z11) {
            return a1.v().p(str);
        }
        return a1.v().F(str);
    }

    public static String d() {
        return "btc";
    }
}
