package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class he implements hr<he, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52196a = new hy("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3073a = new ig("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with other field name */
    public List<gp> f3074a;

    public List<gp> a() {
        return this.f3074a;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3073a);
        if (this.f3074a != null) {
            ibVar.a(f52196a);
            ibVar.a(new hz((byte) 12, this.f3074a.size()));
            for (gp b11 : this.f3074a) {
                b11.b(ibVar);
            }
            ibVar.e();
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof he)) {
            return compareTo((he) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("XmPushActionNormalConfig(");
        sb2.append("normalConfigs:");
        List<gp> list = this.f3074a;
        if (list == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(list);
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2805a() {
        return this.f3074a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2806a(he heVar) {
        if (heVar == null) {
            return false;
        }
        List<gp> a11 = a();
        List<gp> a12 = heVar.a();
        if (a11 == null && a12 == null) {
            return true;
        }
        if (a11 == null || a12 == null || !this.f3074a.equals(heVar.f3074a)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v1, types: [boolean] */
    /* renamed from: a */
    public int compareTo(he heVar) {
        int a11;
        if (!getClass().equals(heVar.getClass())) {
            return getClass().getName().compareTo(heVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(heVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() == null || (a11 = hs.a((List) this.f3074a, (List) heVar.f3074a)) == 0) {
            return 0;
        }
        return a11;
    }

    public void a(ib ibVar) {
        ibVar.a();
        while (true) {
            hy a11 = ibVar.a();
            byte b11 = a11.f52345a;
            if (b11 == 0) {
                ibVar.f();
                a();
                return;
            }
            if (a11.f3243a != 1) {
                ie.a(ibVar, b11);
            } else if (b11 == 15) {
                hz a12 = ibVar.a();
                this.f3074a = new ArrayList(a12.f3244a);
                for (int i11 = 0; i11 < a12.f3244a; i11++) {
                    gp gpVar = new gp();
                    gpVar.a(ibVar);
                    this.f3074a.add(gpVar);
                }
                ibVar.i();
            } else {
                ie.a(ibVar, b11);
            }
            ibVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2804a() {
        if (this.f3074a == null) {
            throw new ic("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }
}
