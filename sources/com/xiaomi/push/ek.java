package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;

public class ek implements hr<ek, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f51720a = new hy("", (byte) 3, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f2773a = new ig("StatsEvent");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f51721b = new hy("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f51722c = new hy("", (byte) 8, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f51723d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f51724e = new hy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f51725f = new hy("", (byte) 8, 6);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f51726g = new hy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f51727h = new hy("", (byte) 11, 8);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f51728i = new hy("", (byte) 8, 9);

    /* renamed from: j  reason: collision with root package name */
    private static final hy f51729j = new hy("", (byte) 8, 10);

    /* renamed from: a  reason: collision with other field name */
    public byte f2774a;

    /* renamed from: a  reason: collision with other field name */
    public int f2775a;

    /* renamed from: a  reason: collision with other field name */
    public String f2776a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f2777a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f2778b;

    /* renamed from: b  reason: collision with other field name */
    public String f2779b;

    /* renamed from: c  reason: collision with other field name */
    public int f2780c;

    /* renamed from: c  reason: collision with other field name */
    public String f2781c;

    /* renamed from: d  reason: collision with other field name */
    public int f2782d;

    /* renamed from: d  reason: collision with other field name */
    public String f2783d;

    /* renamed from: e  reason: collision with other field name */
    public int f2784e;

    public ek a(byte b11) {
        this.f2774a = b11;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f2777a.get(1);
    }

    public boolean c() {
        return this.f2777a.get(2);
    }

    public boolean d() {
        return this.f2776a != null;
    }

    public boolean e() {
        return this.f2779b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ek)) {
            return compareTo((ek) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f2777a.get(3);
    }

    public boolean g() {
        return this.f2781c != null;
    }

    public boolean h() {
        return this.f2783d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f2777a.get(4);
    }

    public boolean j() {
        return this.f2777a.get(5);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("StatsEvent(");
        sb2.append("chid:");
        sb2.append(this.f2774a);
        sb2.append(", ");
        sb2.append("type:");
        sb2.append(this.f2775a);
        sb2.append(", ");
        sb2.append("value:");
        sb2.append(this.f2778b);
        sb2.append(", ");
        sb2.append("connpt:");
        String str = this.f2776a;
        if (str == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str);
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("host:");
            String str2 = this.f2779b;
            if (str2 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str2);
            }
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("subvalue:");
            sb2.append(this.f2780c);
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("annotation:");
            String str3 = this.f2781c;
            if (str3 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str3);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("user:");
            String str4 = this.f2783d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("time:");
            sb2.append(this.f2782d);
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("clientIp:");
            sb2.append(this.f2784e);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public void b(boolean z11) {
        this.f2777a.set(1, z11);
    }

    public void c(boolean z11) {
        this.f2777a.set(2, z11);
    }

    public void d(boolean z11) {
        this.f2777a.set(3, z11);
    }

    public void e(boolean z11) {
        this.f2777a.set(4, z11);
    }

    public void f(boolean z11) {
        this.f2777a.set(5, z11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2636a() {
        return this.f2777a.get(0);
    }

    public ek b(int i11) {
        this.f2778b = i11;
        c(true);
        return this;
    }

    public ek c(int i11) {
        this.f2780c = i11;
        d(true);
        return this;
    }

    public ek d(String str) {
        this.f2783d = str;
        return this;
    }

    public void a(boolean z11) {
        this.f2777a.set(0, z11);
    }

    public ek d(int i11) {
        this.f2782d = i11;
        e(true);
        return this;
    }

    public ek a(int i11) {
        this.f2775a = i11;
        b(true);
        return this;
    }

    public ek b(String str) {
        this.f2779b = str;
        return this;
    }

    public ek c(String str) {
        this.f2781c = str;
        return this;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f2773a);
        ibVar.a(f51720a);
        ibVar.a(this.f2774a);
        ibVar.b();
        ibVar.a(f51721b);
        ibVar.a(this.f2775a);
        ibVar.b();
        ibVar.a(f51722c);
        ibVar.a(this.f2778b);
        ibVar.b();
        if (this.f2776a != null) {
            ibVar.a(f51723d);
            ibVar.a(this.f2776a);
            ibVar.b();
        }
        if (this.f2779b != null && e()) {
            ibVar.a(f51724e);
            ibVar.a(this.f2779b);
            ibVar.b();
        }
        if (f()) {
            ibVar.a(f51725f);
            ibVar.a(this.f2780c);
            ibVar.b();
        }
        if (this.f2781c != null && g()) {
            ibVar.a(f51726g);
            ibVar.a(this.f2781c);
            ibVar.b();
        }
        if (this.f2783d != null && h()) {
            ibVar.a(f51727h);
            ibVar.a(this.f2783d);
            ibVar.b();
        }
        if (i()) {
            ibVar.a(f51728i);
            ibVar.a(this.f2782d);
            ibVar.b();
        }
        if (j()) {
            ibVar.a(f51729j);
            ibVar.a(this.f2784e);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    public ek a(String str) {
        this.f2776a = str;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2637a(ek ekVar) {
        if (ekVar == null || this.f2774a != ekVar.f2774a || this.f2775a != ekVar.f2775a || this.f2778b != ekVar.f2778b) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = ekVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f2776a.equals(ekVar.f2776a))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = ekVar.e();
        if ((e11 || e12) && (!e11 || !e12 || !this.f2779b.equals(ekVar.f2779b))) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = ekVar.f();
        if ((f11 || f12) && (!f11 || !f12 || this.f2780c != ekVar.f2780c)) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = ekVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f2781c.equals(ekVar.f2781c))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = ekVar.h();
        if ((h11 || h12) && (!h11 || !h12 || !this.f2783d.equals(ekVar.f2783d))) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = ekVar.i();
        if ((i11 || i12) && (!i11 || !i12 || this.f2782d != ekVar.f2782d)) {
            return false;
        }
        boolean j11 = j();
        boolean j12 = ekVar.j();
        if (!j11 && !j12) {
            return true;
        }
        if (!j11 || !j12 || this.f2784e != ekVar.f2784e) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(ek ekVar) {
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        int a21;
        if (!getClass().equals(ekVar.getClass())) {
            return getClass().getName().compareTo(ekVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(ekVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a21 = hs.a(this.f2774a, ekVar.f2774a)) != 0) {
            return a21;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ekVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a19 = hs.a(this.f2775a, ekVar.f2775a)) != 0) {
            return a19;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ekVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a18 = hs.a(this.f2778b, ekVar.f2778b)) != 0) {
            return a18;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ekVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a17 = hs.a(this.f2776a, ekVar.f2776a)) != 0) {
            return a17;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ekVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a16 = hs.a(this.f2779b, ekVar.f2779b)) != 0) {
            return a16;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ekVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a15 = hs.a(this.f2780c, ekVar.f2780c)) != 0) {
            return a15;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ekVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a14 = hs.a(this.f2781c, ekVar.f2781c)) != 0) {
            return a14;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ekVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a13 = hs.a(this.f2783d, ekVar.f2783d)) != 0) {
            return a13;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ekVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a12 = hs.a(this.f2782d, ekVar.f2782d)) != 0) {
            return a12;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ekVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a11 = hs.a(this.f2784e, ekVar.f2784e)) == 0) {
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
                if (!a()) {
                    throw new ic("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!b()) {
                    throw new ic("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (c()) {
                    a();
                    return;
                } else {
                    throw new ic("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (a11.f3243a) {
                    case 1:
                        if (b11 != 3) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f2774a = ibVar.a();
                            a(true);
                            break;
                        }
                    case 2:
                        if (b11 != 8) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f2775a = ibVar.a();
                            b(true);
                            break;
                        }
                    case 3:
                        if (b11 != 8) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f2778b = ibVar.a();
                            c(true);
                            break;
                        }
                    case 4:
                        if (b11 != 11) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f2776a = ibVar.a();
                            break;
                        }
                    case 5:
                        if (b11 != 11) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f2779b = ibVar.a();
                            break;
                        }
                    case 6:
                        if (b11 != 8) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f2780c = ibVar.a();
                            d(true);
                            break;
                        }
                    case 7:
                        if (b11 != 11) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f2781c = ibVar.a();
                            break;
                        }
                    case 8:
                        if (b11 != 11) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f2783d = ibVar.a();
                            break;
                        }
                    case 9:
                        if (b11 != 8) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f2782d = ibVar.a();
                            e(true);
                            break;
                        }
                    case 10:
                        if (b11 != 8) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f2784e = ibVar.a();
                            f(true);
                            break;
                        }
                    default:
                        ie.a(ibVar, b11);
                        break;
                }
                ibVar.g();
            }
        }
    }

    public void a() {
        if (this.f2776a == null) {
            throw new ic("Required field 'connpt' was not present! Struct: " + toString());
        }
    }
}
