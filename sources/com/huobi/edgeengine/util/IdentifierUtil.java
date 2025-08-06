package com.huobi.edgeengine.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class IdentifierUtil {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Integer> f44360a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, Integer> f44361b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, Integer> f44362c = new HashMap();

    public static int a(Context context, String str, String str2) {
        Map<String, Integer> map;
        str2.hashCode();
        char c11 = 65535;
        switch (str2.hashCode()) {
            case -891985903:
                if (str2.equals("string")) {
                    c11 = 0;
                    break;
                }
                break;
            case -826507106:
                if (str2.equals("drawable")) {
                    c11 = 1;
                    break;
                }
                break;
            case 94842723:
                if (str2.equals("color")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                map = f44362c;
                break;
            case 1:
                map = f44360a;
                break;
            case 2:
                map = f44361b;
                break;
            default:
                map = null;
                break;
        }
        return b(context, str2, str, map);
    }

    public static int b(Context context, String str, String str2, Map<String, Integer> map) {
        if (context == null) {
            return 0;
        }
        if (map != null && map.containsKey(str2)) {
            return map.get(str2).intValue();
        }
        int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
        if (map != null) {
            map.put(str2, Integer.valueOf(identifier));
        }
        return identifier;
    }
}
