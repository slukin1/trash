package com.kakao.common;

import android.content.Context;
import com.kakao.common.IConfiguration;
import qw.b;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f25028c;

    /* renamed from: a  reason: collision with root package name */
    public b f25029a;

    /* renamed from: b  reason: collision with root package name */
    public IConfiguration f25030b;

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f25028c == null) {
                f25028c = new a();
            }
            aVar = f25028c;
        }
        return aVar;
    }

    public IConfiguration a() {
        return this.f25030b;
    }

    public synchronized void c(Context context) {
        if (this.f25030b == null) {
            this.f25030b = IConfiguration.Factory.a(context);
        }
        if (this.f25029a == null) {
            this.f25029a = new qw.a(context);
        }
    }

    public b d() {
        return this.f25029a;
    }
}
