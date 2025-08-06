package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;

public class gr implements hr<gr, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52086a = new hy("", (byte) 8, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f2943a = new ig("OnlineConfigItem");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52087b = new hy("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52088c = new hy("", (byte) 2, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52089d = new hy("", (byte) 8, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52090e = new hy("", (byte) 10, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52091f = new hy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52092g = new hy("", (byte) 2, 7);

    /* renamed from: a  reason: collision with other field name */
    public int f2944a;

    /* renamed from: a  reason: collision with other field name */
    public long f2945a;

    /* renamed from: a  reason: collision with other field name */
    public String f2946a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f2947a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f2948a;

    /* renamed from: b  reason: collision with other field name */
    public int f2949b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2950b;

    /* renamed from: c  reason: collision with other field name */
    public int f2951c;

    public int a() {
        return this.f2944a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2745a() {
    }

    public int b() {
        return this.f2949b;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2749c() {
        return this.f2947a.get(2);
    }

    public boolean d() {
        return this.f2947a.get(3);
    }

    public boolean e() {
        return this.f2947a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gr)) {
            return compareTo((gr) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f2946a != null;
    }

    public boolean g() {
        return this.f2950b;
    }

    public boolean h() {
        return this.f2947a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("OnlineConfigItem(");
        boolean z12 = false;
        if (a()) {
            sb2.append("key:");
            sb2.append(this.f2944a);
            z11 = false;
        } else {
            z11 = true;
        }
        if (b()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("type:");
            sb2.append(this.f2949b);
            z11 = false;
        }
        if (c()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("clear:");
            sb2.append(this.f2948a);
            z11 = false;
        }
        if (d()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("intValue:");
            sb2.append(this.f2951c);
            z11 = false;
        }
        if (e()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("longValue:");
            sb2.append(this.f2945a);
            z11 = false;
        }
        if (f()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("stringValue:");
            String str = this.f2946a;
            if (str == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str);
            }
        } else {
            z12 = z11;
        }
        if (h()) {
            if (!z12) {
                sb2.append(", ");
            }
            sb2.append("boolValue:");
            sb2.append(this.f2950b);
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2746a() {
        return this.f2947a.get(0);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2748b() {
        return this.f2947a.get(1);
    }

    public void c(boolean z11) {
        this.f2947a.set(2, z11);
    }

    public void d(boolean z11) {
        this.f2947a.set(3, z11);
    }

    public void e(boolean z11) {
        this.f2947a.set(4, z11);
    }

    public void f(boolean z11) {
        this.f2947a.set(5, z11);
    }

    public void a(boolean z11) {
        this.f2947a.set(0, z11);
    }

    public void b(boolean z11) {
        this.f2947a.set(1, z11);
    }

    public int c() {
        return this.f2951c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m2743a() {
        return this.f2945a;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f2943a);
        if (a()) {
            ibVar.a(f52086a);
            ibVar.a(this.f2944a);
            ibVar.b();
        }
        if (b()) {
            ibVar.a(f52087b);
            ibVar.a(this.f2949b);
            ibVar.b();
        }
        if (c()) {
            ibVar.a(f52088c);
            ibVar.a(this.f2948a);
            ibVar.b();
        }
        if (d()) {
            ibVar.a(f52089d);
            ibVar.a(this.f2951c);
            ibVar.b();
        }
        if (e()) {
            ibVar.a(f52090e);
            ibVar.a(this.f2945a);
            ibVar.b();
        }
        if (this.f2946a != null && f()) {
            ibVar.a(f52091f);
            ibVar.a(this.f2946a);
            ibVar.b();
        }
        if (h()) {
            ibVar.a(f52092g);
            ibVar.a(this.f2950b);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2744a() {
        return this.f2946a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2747a(gr grVar) {
        if (grVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = grVar.a();
        if ((a11 || a12) && (!a11 || !a12 || this.f2944a != grVar.f2944a)) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = grVar.b();
        if ((b11 || b12) && (!b11 || !b12 || this.f2949b != grVar.f2949b)) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = grVar.c();
        if ((c11 || c12) && (!c11 || !c12 || this.f2948a != grVar.f2948a)) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = grVar.d();
        if ((d11 || d12) && (!d11 || !d12 || this.f2951c != grVar.f2951c)) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = grVar.e();
        if ((e11 || e12) && (!e11 || !e12 || this.f2945a != grVar.f2945a)) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = grVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f2946a.equals(grVar.f2946a))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = grVar.h();
        if (!h11 && !h12) {
            return true;
        }
        if (!h11 || !h12 || this.f2950b != grVar.f2950b) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(gr grVar) {
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        if (!getClass().equals(grVar.getClass())) {
            return getClass().getName().compareTo(grVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(grVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a17 = hs.a(this.f2944a, grVar.f2944a)) != 0) {
            return a17;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(grVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a16 = hs.a(this.f2949b, grVar.f2949b)) != 0) {
            return a16;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(grVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a15 = hs.a(this.f2948a, grVar.f2948a)) != 0) {
            return a15;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(grVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a14 = hs.a(this.f2951c, grVar.f2951c)) != 0) {
            return a14;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(grVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a13 = hs.a(this.f2945a, grVar.f2945a)) != 0) {
            return a13;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(grVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a12 = hs.a(this.f2946a, grVar.f2946a)) != 0) {
            return a12;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(grVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!h() || (a11 = hs.a(this.f2950b, grVar.f2950b)) == 0) {
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
            switch (a11.f3243a) {
                case 1:
                    if (b11 != 8) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2944a = ibVar.a();
                        a(true);
                        break;
                    }
                case 2:
                    if (b11 != 8) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2949b = ibVar.a();
                        b(true);
                        break;
                    }
                case 3:
                    if (b11 != 2) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2948a = ibVar.a();
                        c(true);
                        break;
                    }
                case 4:
                    if (b11 != 8) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2951c = ibVar.a();
                        d(true);
                        break;
                    }
                case 5:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2945a = ibVar.a();
                        e(true);
                        break;
                    }
                case 6:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2946a = ibVar.a();
                        break;
                    }
                case 7:
                    if (b11 != 2) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2950b = ibVar.a();
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
