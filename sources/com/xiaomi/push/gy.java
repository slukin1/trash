package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class gy implements hr<gy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52163a = new hy("", (byte) 8, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3031a = new ig("XmPushActionCheckClientInfo");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52164b = new hy("", (byte) 8, 2);

    /* renamed from: a  reason: collision with other field name */
    public int f3032a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3033a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f3034b;

    public gy a(int i11) {
        this.f3032a = i11;
        a(true);
        return this;
    }

    public void a() {
    }

    public gy b(int i11) {
        this.f3034b = i11;
        b(true);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gy)) {
            return compareTo((gy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(" + "miscConfigVersion:" + this.f3032a + ", " + "pluginConfigVersion:" + this.f3034b + ")";
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2778a() {
        return this.f3033a.get(0);
    }

    public boolean b() {
        return this.f3033a.get(1);
    }

    public void a(boolean z11) {
        this.f3033a.set(0, z11);
    }

    public void b(boolean z11) {
        this.f3033a.set(1, z11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2779a(gy gyVar) {
        if (gyVar != null && this.f3032a == gyVar.f3032a && this.f3034b == gyVar.f3034b) {
            return true;
        }
        return false;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3031a);
        ibVar.a(f52163a);
        ibVar.a(this.f3032a);
        ibVar.b();
        ibVar.a(f52164b);
        ibVar.a(this.f3034b);
        ibVar.b();
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a */
    public int compareTo(gy gyVar) {
        int a11;
        int a12;
        if (!getClass().equals(gyVar.getClass())) {
            return getClass().getName().compareTo(gyVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gyVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a12 = hs.a(this.f3032a, gyVar.f3032a)) != 0) {
            return a12;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gyVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!b() || (a11 = hs.a(this.f3034b, gyVar.f3034b)) == 0) {
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
                    ie.a(ibVar, b11);
                } else if (b11 == 8) {
                    this.f3034b = ibVar.a();
                    b(true);
                } else {
                    ie.a(ibVar, b11);
                }
            } else if (b11 == 8) {
                this.f3032a = ibVar.a();
                a(true);
            } else {
                ie.a(ibVar, b11);
            }
            ibVar.g();
        }
        ibVar.f();
        if (!a()) {
            throw new ic("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (b()) {
            a();
        } else {
            throw new ic("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }
}
