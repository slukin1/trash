package com.xiaomi.push;

import android.content.Context;

public class cn implements fg, fl {

    /* renamed from: a  reason: collision with root package name */
    private Context f51504a;

    public cn(Context context) {
        this.f51504a = context;
    }

    public void a(fp fpVar) {
        cu.a(this.f51504a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2496a(fp fpVar) {
        return true;
    }

    public void a(es esVar) {
        if (esVar == null || esVar.a() != 0 || !"PING".equals(esVar.a())) {
            cu.a(this.f51504a);
        } else {
            cu.c(this.f51504a);
        }
    }
}
