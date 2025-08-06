package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import com.alibaba.sdk.android.httpdns.e.h;
import q2.c;

public class HttpDns {

    /* renamed from: a  reason: collision with root package name */
    public static final c f14520a = new c(new h());

    public static synchronized m2.c a(Context context, String str) {
        m2.c a11;
        synchronized (HttpDns.class) {
            a11 = f14520a.a(context, str, (String) null);
        }
        return a11;
    }
}
