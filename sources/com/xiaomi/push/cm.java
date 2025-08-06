package com.xiaomi.push;

import android.content.Context;

public class cm implements fg, fl {

    /* renamed from: a  reason: collision with root package name */
    private Context f51503a;

    public cm(Context context) {
        this.f51503a = context;
    }

    public void a(fp fpVar) {
        cu.b(this.f51503a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2495a(fp fpVar) {
        return true;
    }

    public void a(es esVar) {
        if (esVar == null || esVar.a() != 0 || !"PING".equals(esVar.a())) {
            cu.b(this.f51503a);
        } else {
            cu.d(this.f51503a);
        }
    }
}
