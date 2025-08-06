package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;

public class hn implements hr<hn, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52306a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3202a = new ig("XmPushActionUnRegistrationResult");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52307b = new hy("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52308c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52309d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52310e = new hy("", (byte) 10, 6);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52311f = new hy("", (byte) 11, 7);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52312g = new hy("", (byte) 11, 8);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52313h = new hy("", (byte) 10, 9);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f52314i = new hy("", (byte) 10, 10);

    /* renamed from: a  reason: collision with other field name */
    public long f3203a;

    /* renamed from: a  reason: collision with other field name */
    public gv f3204a;

    /* renamed from: a  reason: collision with other field name */
    public String f3205a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3206a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f3207b;

    /* renamed from: b  reason: collision with other field name */
    public String f3208b;

    /* renamed from: c  reason: collision with other field name */
    public long f3209c;

    /* renamed from: c  reason: collision with other field name */
    public String f3210c;

    /* renamed from: d  reason: collision with other field name */
    public String f3211d;

    /* renamed from: e  reason: collision with other field name */
    public String f3212e;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2850a() {
        return this.f3205a != null;
    }

    public boolean b() {
        return this.f3204a != null;
    }

    public boolean c() {
        return this.f3208b != null;
    }

    public boolean d() {
        return this.f3210c != null;
    }

    public boolean e() {
        return this.f3206a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hn)) {
            return compareTo((hn) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3211d != null;
    }

    public boolean g() {
        return this.f3212e != null;
    }

    public boolean h() {
        return this.f3206a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f3206a.get(2);
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z12 = false;
        if (a()) {
            sb2.append("debug:");
            String str = this.f3205a;
            if (str == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str);
            }
            z11 = false;
        } else {
            z11 = true;
        }
        if (b()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("target:");
            gv gvVar = this.f3204a;
            if (gvVar == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(gvVar);
            }
        } else {
            z12 = z11;
        }
        if (!z12) {
            sb2.append(", ");
        }
        sb2.append("id:");
        String str2 = this.f3208b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f3210c;
        if (str3 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("errorCode:");
        sb2.append(this.f3203a);
        if (f()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str4 = this.f3211d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str5 = this.f3212e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("unRegisteredAt:");
            sb2.append(this.f3207b);
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("costTime:");
            sb2.append(this.f3209c);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public void a(boolean z11) {
        this.f3206a.set(0, z11);
    }

    public void b(boolean z11) {
        this.f3206a.set(1, z11);
    }

    public void c(boolean z11) {
        this.f3206a.set(2, z11);
    }

    public String a() {
        return this.f3212e;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3202a);
        if (this.f3205a != null && a()) {
            ibVar.a(f52306a);
            ibVar.a(this.f3205a);
            ibVar.b();
        }
        if (this.f3204a != null && b()) {
            ibVar.a(f52307b);
            this.f3204a.b(ibVar);
            ibVar.b();
        }
        if (this.f3208b != null) {
            ibVar.a(f52308c);
            ibVar.a(this.f3208b);
            ibVar.b();
        }
        if (this.f3210c != null) {
            ibVar.a(f52309d);
            ibVar.a(this.f3210c);
            ibVar.b();
        }
        ibVar.a(f52310e);
        ibVar.a(this.f3203a);
        ibVar.b();
        if (this.f3211d != null && f()) {
            ibVar.a(f52311f);
            ibVar.a(this.f3211d);
            ibVar.b();
        }
        if (this.f3212e != null && g()) {
            ibVar.a(f52312g);
            ibVar.a(this.f3212e);
            ibVar.b();
        }
        if (h()) {
            ibVar.a(f52313h);
            ibVar.a(this.f3207b);
            ibVar.b();
        }
        if (i()) {
            ibVar.a(f52314i);
            ibVar.a(this.f3209c);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2851a(hn hnVar) {
        if (hnVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = hnVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3205a.equals(hnVar.f3205a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = hnVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3204a.compareTo(hnVar.f3204a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = hnVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3208b.equals(hnVar.f3208b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = hnVar.d();
        if (((d11 || d12) && (!d11 || !d12 || !this.f3210c.equals(hnVar.f3210c))) || this.f3203a != hnVar.f3203a) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = hnVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f3211d.equals(hnVar.f3211d))) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = hnVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3212e.equals(hnVar.f3212e))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = hnVar.h();
        if ((h11 || h12) && (!h11 || !h12 || this.f3207b != hnVar.f3207b)) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = hnVar.i();
        if (!i11 && !i12) {
            return true;
        }
        if (!i11 || !i12 || this.f3209c != hnVar.f3209c) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(hn hnVar) {
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        if (!getClass().equals(hnVar.getClass())) {
            return getClass().getName().compareTo(hnVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hnVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a19 = hs.a(this.f3205a, hnVar.f3205a)) != 0) {
            return a19;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hnVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a18 = hs.a((Comparable) this.f3204a, (Comparable) hnVar.f3204a)) != 0) {
            return a18;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hnVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a17 = hs.a(this.f3208b, hnVar.f3208b)) != 0) {
            return a17;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hnVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a16 = hs.a(this.f3210c, hnVar.f3210c)) != 0) {
            return a16;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hnVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a15 = hs.a(this.f3203a, hnVar.f3203a)) != 0) {
            return a15;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hnVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a14 = hs.a(this.f3211d, hnVar.f3211d)) != 0) {
            return a14;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hnVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a13 = hs.a(this.f3212e, hnVar.f3212e)) != 0) {
            return a13;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hnVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a12 = hs.a(this.f3207b, hnVar.f3207b)) != 0) {
            return a12;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hnVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a11 = hs.a(this.f3209c, hnVar.f3209c)) == 0) {
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
                if (e()) {
                    a();
                    return;
                }
                throw new ic("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (a11.f3243a) {
                case 1:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3205a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3204a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3208b = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3210c = ibVar.a();
                        break;
                    }
                case 6:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3203a = ibVar.a();
                        a(true);
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3211d = ibVar.a();
                        break;
                    }
                case 8:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3212e = ibVar.a();
                        break;
                    }
                case 9:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3207b = ibVar.a();
                        b(true);
                        break;
                    }
                case 10:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3209c = ibVar.a();
                        c(true);
                        break;
                    }
                default:
                    ie.a(ibVar, b11);
                    break;
            }
            ibVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2849a() {
        if (this.f3208b == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3210c == null) {
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
