package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import java.lang.reflect.Method;

class am implements aj {

    /* renamed from: a  reason: collision with root package name */
    private Context f51381a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f2526a;

    /* renamed from: a  reason: collision with other field name */
    private Object f2527a;

    /* renamed from: a  reason: collision with other field name */
    private Method f2528a = null;

    /* renamed from: b  reason: collision with root package name */
    private Method f51382b = null;

    /* renamed from: c  reason: collision with root package name */
    private Method f51383c = null;

    /* renamed from: d  reason: collision with root package name */
    private Method f51384d = null;

    public am(Context context) {
        this.f51381a = context;
        a(context);
    }

    private void a(Context context) {
        try {
            Class<?> a11 = s.a(context, "com.android.id.impl.IdProviderImpl");
            this.f2526a = a11;
            this.f2527a = a11.newInstance();
            this.f51382b = this.f2526a.getMethod("getOAID", new Class[]{Context.class});
        } catch (Exception e11) {
            b.a("miui load class error", (Throwable) e11);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2392a() {
        return (this.f2526a == null || this.f2527a == null) ? false : true;
    }

    public String a() {
        return a(this.f51381a, this.f51382b);
    }

    private String a(Context context, Method method) {
        Object obj = this.f2527a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, new Object[]{context});
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e11) {
            b.a("miui invoke error", (Throwable) e11);
            return null;
        }
    }
}
