package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.push.af;

public class bj extends af.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f51444a;

    public bj(Context context) {
        this.f51444a = context;
    }

    private boolean a() {
        return a.a(this.f51444a).a().isEventUploadSwitchOpen();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2439a() {
        return "100886";
    }

    public void run() {
        try {
            if (a()) {
                b.c(this.f51444a.getPackageName() + " begin upload event");
                a.a(this.f51444a).b();
            }
        } catch (Exception e11) {
            b.a((Throwable) e11);
        }
    }
}
