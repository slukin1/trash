package com.alibaba.sdk.android.httpdns.c;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;
import p2.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f14549a = new AtomicBoolean(false);

    /* renamed from: com.alibaba.sdk.android.httpdns.c.a$a  reason: collision with other inner class name */
    public static class C0068a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public Context f14550b;

        /* renamed from: c  reason: collision with root package name */
        public q2.a f14551c;

        /* renamed from: d  reason: collision with root package name */
        public a f14552d;

        public C0068a(Context context, q2.a aVar, a aVar2) {
            this.f14550b = context;
            this.f14551c = aVar;
            this.f14552d = aVar2;
        }

        public void run() {
            this.f14552d.f14549a.set(false);
            SharedPreferences.Editor edit = this.f14550b.getSharedPreferences("httpdns_config_" + this.f14551c.s(), 0).edit();
            c[] i11 = this.f14551c.i();
            for (c b11 : i11) {
                b11.b(edit);
            }
            edit.commit();
        }
    }

    public void b(Context context, q2.a aVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("httpdns_config_" + aVar.s(), 0);
        c[] i11 = aVar.i();
        for (c a11 : i11) {
            a11.a(sharedPreferences);
        }
    }

    public void c(Context context, q2.a aVar) {
        if (this.f14549a.compareAndSet(false, true)) {
            try {
                aVar.c().execute(new C0068a(context, aVar, this));
            } catch (Exception unused) {
                this.f14549a.set(false);
            }
        }
    }
}
