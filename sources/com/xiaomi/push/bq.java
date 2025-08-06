package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bx;
import java.lang.ref.WeakReference;

public class bq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f51458a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f2571a;

    public bq(String str, WeakReference<Context> weakReference) {
        this.f51458a = str;
        this.f2571a = weakReference;
    }

    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f2571a;
        if (weakReference != null && (context = (Context) weakReference.get()) != null) {
            if (cb.a(this.f51458a) > bp.f2569a) {
                bt a11 = bt.a(this.f51458a);
                bs a12 = bs.a(this.f51458a);
                a11.a((bx.a) a12);
                a12.a((bx.a) br.a(context, this.f51458a, 1000));
                bx.a(context).a((bx.a) a11);
                return;
            }
            b.b("=====> do not need clean db");
        }
    }
}
