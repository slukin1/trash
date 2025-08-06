package com.tencent.a.a.a.a;

import android.content.Context;

public abstract class f {

    /* renamed from: e  reason: collision with root package name */
    public Context f40459e = null;

    public f(Context context) {
        this.f40459e = context;
    }

    public final void a(c cVar) {
        if (cVar != null) {
            String cVar2 = cVar.toString();
            if (a()) {
                b(h.g(cVar2));
            }
        }
    }

    public abstract boolean a();

    public abstract String b();

    public abstract void b(String str);

    public final c e() {
        String f11 = a() ? h.f(b()) : null;
        if (f11 != null) {
            return c.c(f11);
        }
        return null;
    }
}
