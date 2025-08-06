package com.huobi.woodpecker.net;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kv.e;

public class UrlConfig {

    /* renamed from: a  reason: collision with root package name */
    public static int f21153a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static String f21154b = "";

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f21155c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static List<String> f21156d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, String> f21157e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static boolean f21158f;

    public static String a() {
        return f21154b;
    }

    public static Map<String, String> b() {
        return f21157e;
    }

    public static String c() {
        List<String> list = f21155c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        if (f21153a >= f21155c.size()) {
            f21153a = 0;
            f21158f = true;
        } else if (f21153a < f21155c.size()) {
            f21155c.get(f21153a);
        } else {
            int size = f21155c.size() - 1;
            f21153a = size;
            f21155c.get(size);
        }
        String str = f21155c.get(f21153a);
        e.c("URL", "getUploadUrl choice:" + f21153a + ", size:" + f21155c.size() + ", url:" + str);
        return str;
    }

    public static boolean d() {
        int i11 = f21153a + 1;
        f21153a = i11;
        if (i11 >= f21155c.size() || f21158f) {
            return false;
        }
        return true;
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<String> list = f21156d;
        if (list != null && !list.isEmpty()) {
            for (String indexOf : f21156d) {
                if (str.indexOf(indexOf) != -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void f(String str) {
        f21154b = str;
    }

    public static void g(List<String> list) {
        if (list != null && list.size() > 0) {
            f21156d.clear();
            f21156d.addAll(list);
        }
    }

    public static void h(Map<String, String> map) {
        if (map != null) {
            f21157e = map;
        }
    }

    public static void i(List<String> list) {
        if (list != null && list.size() > 0) {
            f21153a = 0;
            f21155c.clear();
            f21155c.addAll(list);
        }
    }
}
