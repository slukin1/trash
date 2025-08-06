package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class hd implements hr<hd, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52195a = new hy("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3071a = new ig("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with other field name */
    public List<gr> f3072a;

    public List<gr> a() {
        return this.f3072a;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3071a);
        if (this.f3072a != null) {
            ibVar.a(f52195a);
            ibVar.a(new hz((byte) 12, this.f3072a.size()));
            for (gr b11 : this.f3072a) {
                b11.b(ibVar);
            }
            ibVar.e();
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hd)) {
            return compareTo((hd) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("XmPushActionCustomConfig(");
        sb2.append("customConfigs:");
        List<gr> list = this.f3072a;
        if (list == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(list);
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2802a() {
        return this.f3072a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2803a(hd hdVar) {
        if (hdVar == null) {
            return false;
        }
        List<gr> a11 = a();
        List<gr> a12 = hdVar.a();
        if (a11 == null && a12 == null) {
            return true;
        }
        if (a11 == null || a12 == null || !this.f3072a.equals(hdVar.f3072a)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v1, types: [boolean] */
    /* renamed from: a */
    public int compareTo(hd hdVar) {
        int a11;
        if (!getClass().equals(hdVar.getClass())) {
            return getClass().getName().compareTo(hdVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hdVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() == null || (a11 = hs.a((List) this.f3072a, (List) hdVar.f3072a)) == 0) {
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
                this.f3072a = new ArrayList(a12.f3244a);
                for (int i11 = 0; i11 < a12.f3244a; i11++) {
                    gr grVar = new gr();
                    grVar.a(ibVar);
                    this.f3072a.add(grVar);
                }
                ibVar.i();
            } else {
                ie.a(ibVar, b11);
            }
            ibVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2801a() {
        if (this.f3072a == null) {
            throw new ic("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }
}
