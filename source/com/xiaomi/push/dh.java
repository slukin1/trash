package com.xiaomi.push;

public class dh {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dh f51587a;

    /* renamed from: a  reason: collision with other field name */
    private dg f2671a;

    public static dh a() {
        if (f51587a == null) {
            synchronized (dh.class) {
                if (f51587a == null) {
                    f51587a = new dh();
                }
            }
        }
        return f51587a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dg m2520a() {
        return this.f2671a;
    }

    public void a(dg dgVar) {
        this.f2671a = dgVar;
    }
}
