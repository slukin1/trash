package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.b;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.j.c;
import com.huawei.hms.framework.network.grs.h.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final String f38003e = "a";

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, Map<String, Map<String, String>>> f38004f = new ConcurrentHashMap(16);

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Long> f38005a = new ConcurrentHashMap(16);

    /* renamed from: b  reason: collision with root package name */
    private final c f38006b;

    /* renamed from: c  reason: collision with root package name */
    private final c f38007c;

    /* renamed from: d  reason: collision with root package name */
    private final g f38008d;

    public a(c cVar, c cVar2, g gVar) {
        this.f38007c = cVar2;
        this.f38006b = cVar;
        this.f38008d = gVar;
        gVar.a(this);
    }

    private void a(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Long l11 = this.f38005a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (e.a(l11)) {
            bVar.a(2);
            return;
        }
        if (e.a(l11, 300000)) {
            this.f38008d.a(new c(grsBaseInfo, context), (b) null, str, this.f38007c, -1);
        }
        bVar.a(1);
    }

    private void a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (e.a(this.f38005a.get(str), 300000)) {
            this.f38008d.a(new c(grsBaseInfo, context), (b) null, (String) null, this.f38007c, -1);
        }
    }

    public c a() {
        return this.f38006b;
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        Map<String, Map<String, Map<String, String>>> map = f38004f;
        Map map2 = map.get(grsParasKey);
        if (map2 == null || map2.isEmpty()) {
            String str2 = f38003e;
            Logger.i(str2, "Cache size is: " + map.size());
            return new HashMap();
        }
        a(grsBaseInfo, bVar, context, str);
        return (Map) map2.get(str);
    }

    public void a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        c cVar = this.f38006b;
        cVar.b(grsParasKey + CrashHianalyticsData.TIME, "0");
        Map<String, Long> map = this.f38005a;
        map.remove(grsParasKey + CrashHianalyticsData.TIME);
        Map<String, Map<String, Map<String, String>>> map2 = f38004f;
        map2.remove(grsParasKey);
        String str = f38003e;
        Logger.i(str, "Cache size is: " + map2.size());
        this.f38008d.a(grsParasKey);
    }

    public void a(GrsBaseInfo grsBaseInfo, d dVar, Context context, c cVar) {
        if (dVar.f() == 2) {
            Logger.w(f38003e, "update cache from server failed");
            return;
        }
        if (cVar.d().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (dVar.m()) {
                f38004f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(this.f38006b.a(grsParasKey, "")));
            } else {
                this.f38006b.b(grsParasKey, dVar.j());
                f38004f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(dVar.j()));
            }
            if (!TextUtils.isEmpty(dVar.e())) {
                c cVar2 = this.f38006b;
                cVar2.b(grsParasKey + HttpHeaders.ETAG, dVar.e());
            }
            c cVar3 = this.f38006b;
            cVar3.b(grsParasKey + CrashHianalyticsData.TIME, dVar.a());
            this.f38005a.put(grsParasKey, Long.valueOf(Long.parseLong(dVar.a())));
        } else {
            this.f38006b.b("geoipCountryCode", dVar.j());
            this.f38006b.b("geoipCountryCodetime", dVar.a());
        }
        String str = f38003e;
        Logger.i(str, "Cache size is: " + f38004f.size());
    }

    public g b() {
        return this.f38008d;
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String a11 = this.f38006b.a(grsParasKey, "");
        c cVar = this.f38006b;
        String a12 = cVar.a(grsParasKey + CrashHianalyticsData.TIME, "0");
        long j11 = 0;
        if (!TextUtils.isEmpty(a12) && a12.matches("\\d+")) {
            try {
                j11 = Long.parseLong(a12);
            } catch (NumberFormatException e11) {
                Logger.w(f38003e, "convert urlParamKey from String to Long catch NumberFormatException.", (Throwable) e11);
            }
        }
        Map<String, Map<String, Map<String, String>>> map = f38004f;
        map.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(a11));
        String str = f38003e;
        Logger.i(str, "Cache size is: " + map.size());
        this.f38005a.put(grsParasKey, Long.valueOf(j11));
        a(grsBaseInfo, grsParasKey, context);
    }

    public c c() {
        return this.f38007c;
    }
}
