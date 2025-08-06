package com.mob.commons.b;

import android.content.Context;
import com.mob.commons.a.l;
import com.mob.commons.b.h;
import com.mob.tools.MobLog;
import java.lang.reflect.Method;

public class q extends h {
    public q(Context context) {
        super(context);
    }

    private String a(Context context, Object obj, Method method) {
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, new Object[]{context});
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public h.b b() {
        Object obj;
        Class<?> cls;
        Method method = null;
        try {
            cls = Class.forName(l.a("034d7elegemNefZedekelejedemejedemejegHkh1emffedhmekeleeejed)g2ekffeg0kh"));
            try {
                obj = cls.newInstance();
            } catch (Throwable th2) {
                th = th2;
                MobLog.getInstance().d(th);
                obj = null;
                try {
                    method = cls.getMethod(l.a("007Gfk gj1higeffgm"), new Class[]{Context.class});
                } catch (Throwable th3) {
                    MobLog.getInstance().d(th3);
                }
                h.b bVar = new h.b();
                bVar.f27087a = a(this.f27079a, obj, method);
                return bVar;
            }
        } catch (Throwable th4) {
            th = th4;
            cls = null;
            MobLog.getInstance().d(th);
            obj = null;
            method = cls.getMethod(l.a("007Gfk gj1higeffgm"), new Class[]{Context.class});
            h.b bVar2 = new h.b();
            bVar2.f27087a = a(this.f27079a, obj, method);
            return bVar2;
        }
        if (!(cls == null || obj == null)) {
            method = cls.getMethod(l.a("007Gfk gj1higeffgm"), new Class[]{Context.class});
        }
        h.b bVar22 = new h.b();
        bVar22.f27087a = a(this.f27079a, obj, method);
        return bVar22;
    }
}
