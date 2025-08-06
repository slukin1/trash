package com.huobi.vulcan.net;

import android.text.TextUtils;
import lu.a;

public class UrlConfig {

    /* renamed from: a  reason: collision with root package name */
    public static String f20607a = "";

    public static String a(String str) {
        return f20607a + str;
    }

    public static String b() {
        return a("/cr/v1/external/vulcan/config");
    }

    public static String c() {
        return a("/cr/v1/external/vulcan/data/send");
    }

    public static String d() {
        return a("/cr/v1/external/vulcan/log/send_sdk_log");
    }

    public static String e() {
        return a("/cr/v1/external/vulcan/switch");
    }

    public static void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            f20607a = str;
            a.b("Urlconfig", "BASE_URL=" + f20607a);
            return;
        }
        throw new IllegalArgumentException("UrlConfig.setBaseUrl(url): url is null");
    }
}
