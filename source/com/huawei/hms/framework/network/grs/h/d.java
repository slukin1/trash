package com.huawei.hms.framework.network.grs.h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, a> f38093a = new ConcurrentHashMap(16);

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final long f38094a;

        /* renamed from: b  reason: collision with root package name */
        private final long f38095b;

        public a(long j11, long j12) {
            this.f38094a = j11;
            this.f38095b = j12;
        }

        public boolean a() {
            return SystemClock.elapsedRealtime() - this.f38095b <= this.f38094a;
        }
    }

    public static a a(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("map size of get is before: ");
        Map<String, a> map = f38093a;
        sb2.append(map.size());
        Logger.v("RequestUtil", sb2.toString());
        a aVar = map.get(str);
        Logger.v("RequestUtil", "map size of get is after: " + map.size());
        return aVar;
    }

    public static void a(String str, a aVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("map size of put is before: ");
        Map<String, a> map = f38093a;
        sb2.append(map.size());
        Logger.v("RequestUtil", sb2.toString());
        map.put(str, aVar);
        Logger.v("RequestUtil", "map size of put is after: " + map.size());
    }
}
