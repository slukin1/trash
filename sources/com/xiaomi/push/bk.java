package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.push.af;

public class bk extends af.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f51445a;

    public bk(Context context) {
        this.f51445a = context;
    }

    private boolean a() {
        return a.a(this.f51445a).a().isPerfUploadSwitchOpen();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2440a() {
        return "100887";
    }

    public void run() {
        try {
            if (a()) {
                a.a(this.f51445a).c();
                b.c(this.f51445a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e11) {
            b.d("fail to send perf data. " + e11);
        }
    }
}
