package com.tencent.a.a.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g {

    /* renamed from: i  reason: collision with root package name */
    private static g f40460i;

    /* renamed from: f  reason: collision with root package name */
    private Map<Integer, f> f40461f = null;

    /* renamed from: g  reason: collision with root package name */
    private int f40462g = 0;

    /* renamed from: h  reason: collision with root package name */
    private Context f40463h = null;

    private g(Context context) {
        this.f40463h = context.getApplicationContext();
        HashMap hashMap = new HashMap(3);
        this.f40461f = hashMap;
        hashMap.put(1, new e(context));
        this.f40461f.put(2, new b(context));
        this.f40461f.put(4, new d(context));
    }

    private c a(List<Integer> list) {
        c e11;
        if (list != null && list.size() >= 0) {
            for (Integer num : list) {
                f fVar = this.f40461f.get(num);
                if (fVar != null && (e11 = fVar.e()) != null && h.e(e11.f40457c)) {
                    return e11;
                }
            }
        }
        return new c();
    }

    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            if (f40460i == null) {
                f40460i = new g(context);
            }
            gVar = f40460i;
        }
        return gVar;
    }

    public final void b(String str) {
        c f11 = f();
        f11.f40457c = str;
        if (!h.d(f11.f40455a)) {
            f11.f40455a = h.b(this.f40463h);
        }
        if (!h.d(f11.f40456b)) {
            f11.f40456b = h.c(this.f40463h);
        }
        f11.f40458d = System.currentTimeMillis();
        for (Map.Entry<Integer, f> value : this.f40461f.entrySet()) {
            ((f) value.getValue()).a(f11);
        }
    }

    public final c f() {
        return a((List<Integer>) new ArrayList(Arrays.asList(new Integer[]{1, 2, 4})));
    }
}
