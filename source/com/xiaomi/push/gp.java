package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class gp implements hr<gp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52047a = new hy("", (byte) 8, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f2936a = new ig("NormalConfig");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52048b = new hy("", (byte) 15, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52049c = new hy("", (byte) 8, 3);

    /* renamed from: a  reason: collision with other field name */
    public int f2937a;

    /* renamed from: a  reason: collision with other field name */
    public gm f2938a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f2939a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<gr> f2940a;

    public int a() {
        return this.f2937a;
    }

    public boolean b() {
        return this.f2940a != null;
    }

    public boolean c() {
        return this.f2938a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gp)) {
            return compareTo((gp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("NormalConfig(");
        sb2.append("version:");
        sb2.append(this.f2937a);
        sb2.append(", ");
        sb2.append("configItems:");
        List<gr> list = this.f2940a;
        if (list == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(list);
        }
        if (c()) {
            sb2.append(", ");
            sb2.append("type:");
            gm gmVar = this.f2938a;
            if (gmVar == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(gmVar);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2741a() {
        return this.f2939a.get(0);
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f2936a);
        ibVar.a(f52047a);
        ibVar.a(this.f2937a);
        ibVar.b();
        if (this.f2940a != null) {
            ibVar.a(f52048b);
            ibVar.a(new hz((byte) 12, this.f2940a.size()));
            for (gr b11 : this.f2940a) {
                b11.b(ibVar);
            }
            ibVar.e();
            ibVar.b();
        }
        if (this.f2938a != null && c()) {
            ibVar.a(f52049c);
            ibVar.a(this.f2938a.a());
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    public void a(boolean z11) {
        this.f2939a.set(0, z11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public gm m2739a() {
        return this.f2938a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2742a(gp gpVar) {
        if (gpVar == null || this.f2937a != gpVar.f2937a) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = gpVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f2940a.equals(gpVar.f2940a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = gpVar.c();
        if (!c11 && !c12) {
            return true;
        }
        if (!c11 || !c12 || !this.f2938a.equals(gpVar.f2938a)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(gp gpVar) {
        int a11;
        int a12;
        int a13;
        if (!getClass().equals(gpVar.getClass())) {
            return getClass().getName().compareTo(gpVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gpVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a13 = hs.a(this.f2937a, gpVar.f2937a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gpVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a12 = hs.a((List) this.f2940a, (List) gpVar.f2940a)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gpVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a11 = hs.a((Comparable) this.f2938a, (Comparable) gpVar.f2938a)) == 0) {
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
                break;
            }
            short s11 = a11.f3243a;
            if (s11 != 1) {
                if (s11 != 2) {
                    if (s11 != 3) {
                        ie.a(ibVar, b11);
                    } else if (b11 == 8) {
                        this.f2938a = gm.a(ibVar.a());
                    } else {
                        ie.a(ibVar, b11);
                    }
                } else if (b11 == 15) {
                    hz a12 = ibVar.a();
                    this.f2940a = new ArrayList(a12.f3244a);
                    for (int i11 = 0; i11 < a12.f3244a; i11++) {
                        gr grVar = new gr();
                        grVar.a(ibVar);
                        this.f2940a.add(grVar);
                    }
                    ibVar.i();
                } else {
                    ie.a(ibVar, b11);
                }
            } else if (b11 == 8) {
                this.f2937a = ibVar.a();
                a(true);
            } else {
                ie.a(ibVar, b11);
            }
            ibVar.g();
        }
        ibVar.f();
        if (a()) {
            a();
            return;
        }
        throw new ic("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2740a() {
        if (this.f2940a == null) {
            throw new ic("Required field 'configItems' was not present! Struct: " + toString());
        }
    }
}
