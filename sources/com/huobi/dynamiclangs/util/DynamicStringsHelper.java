package com.huobi.dynamiclangs.util;

import android.util.LruCache;
import com.huobi.dynamiclangs.data.DynamicStringsBean;
import com.huobi.dynamiclangs.db.DynamicStringsDbHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m6.a;

public class DynamicStringsHelper {

    /* renamed from: a  reason: collision with root package name */
    public static LruCache<String, String> f43879a;

    public static void a() {
        f43879a = null;
    }

    public static Map<String, String> b() {
        HashMap hashMap = null;
        if (!a.k()) {
            return null;
        }
        List<DynamicStringsBean> b11 = DynamicStringsDbHelper.b();
        if (b11 != null && !b11.isEmpty()) {
            hashMap = new HashMap(b11.size(), 1.0f);
            for (DynamicStringsBean next : b11) {
                hashMap.put(next.getKey(), next.getValue());
            }
        }
        return hashMap;
    }
}
