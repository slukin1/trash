package com.mob.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private static s f27339a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, Object> f27340b;

    private s() {
        HashMap<String, Object> c11 = c();
        this.f27340b = c11;
        if (c11 == null) {
            this.f27340b = new HashMap<>();
        }
        ArrayList<MobProduct> b11 = aa.b();
        if (b11 != null && !b11.isEmpty()) {
            Iterator<MobProduct> it2 = b11.iterator();
            while (it2.hasNext()) {
                MobProduct next = it2.next();
                if (!this.f27340b.containsKey(next.getProductTag())) {
                    this.f27340b.put(next.getProductTag(), 0);
                }
            }
        }
    }

    public static s a() {
        if (f27339a == null) {
            synchronized (s.class) {
                if (f27339a == null) {
                    f27339a = new s();
                }
            }
        }
        return f27339a;
    }

    private HashMap<String, Object> c() {
        try {
            return ab.a().g();
        } catch (Throwable unused) {
            return null;
        }
    }

    public HashMap<String, Object> b() {
        return this.f27340b;
    }

    public void a(MobProduct mobProduct, int i11) {
        if (mobProduct != null) {
            this.f27340b.put(mobProduct.getProductTag(), Integer.valueOf(i11));
            a(this.f27340b);
        }
    }

    private void a(HashMap<String, Object> hashMap) {
        try {
            ab.a().b(hashMap);
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        return v.a(str, 99);
    }
}
