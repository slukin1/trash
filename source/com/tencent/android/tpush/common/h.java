package com.tencent.android.tpush.common;

import android.content.Context;
import com.tencent.android.tpush.d.a;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile h f68918a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f68919b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f68920c;

    /* renamed from: d  reason: collision with root package name */
    private int f68921d;

    private h(Context context) {
        this.f68919b = false;
        this.f68920c = false;
        this.f68921d = -1;
        this.f68919b = d.a();
        this.f68920c = a.a(context);
    }

    public static h a(Context context) {
        if (f68918a == null) {
            synchronized (h.class) {
                if (f68918a == null) {
                    f68918a = new h(context);
                }
            }
        }
        return f68918a;
    }

    public boolean a() {
        return this.f68920c;
    }
}
