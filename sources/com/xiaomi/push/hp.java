package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;

public class hp implements hr<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52323a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3222a = new ig("XmPushActionUnSubscriptionResult");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52324b = new hy("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52325c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52326d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52327e = new hy("", (byte) 10, 6);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52328f = new hy("", (byte) 11, 7);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52329g = new hy("", (byte) 11, 8);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52330h = new hy("", (byte) 11, 9);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f52331i = new hy("", (byte) 11, 10);

    /* renamed from: a  reason: collision with other field name */
    public long f3223a;

    /* renamed from: a  reason: collision with other field name */
    public gv f3224a;

    /* renamed from: a  reason: collision with other field name */
    public String f3225a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3226a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f3227b;

    /* renamed from: c  reason: collision with other field name */
    public String f3228c;

    /* renamed from: d  reason: collision with other field name */
    public String f3229d;

    /* renamed from: e  reason: collision with other field name */
    public String f3230e;

    /* renamed from: f  reason: collision with other field name */
    public String f3231f;

    /* renamed from: g  reason: collision with other field name */
    public String f3232g;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2855a() {
        return this.f3225a != null;
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2857b() {
        return this.f3224a != null;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2858c() {
        return this.f3227b != null;
    }

    public boolean d() {
        return this.f3228c != null;
    }

    public boolean e() {
        return this.f3226a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return compareTo((hp) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3229d != null;
    }

    public boolean g() {
        return this.f3230e != null;
    }

    public boolean h() {
        return this.f3231f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f3232g != null;
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z12 = false;
        if (a()) {
            sb2.append("debug:");
            String str = this.f3225a;
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
            gv gvVar = this.f3224a;
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
        String str2 = this.f3227b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        if (d()) {
            sb2.append(", ");
            sb2.append("appId:");
            String str3 = this.f3228c;
            if (str3 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str3);
            }
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("errorCode:");
            sb2.append(this.f3223a);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str4 = this.f3229d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("topic:");
            String str5 = this.f3230e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str6 = this.f3231f;
            if (str6 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str6);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f3232g;
            if (str7 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str7);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public String a() {
        return this.f3227b;
    }

    public String b() {
        return this.f3230e;
    }

    public String c() {
        return this.f3232g;
    }

    public void a(boolean z11) {
        this.f3226a.set(0, z11);
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3222a);
        if (this.f3225a != null && a()) {
            ibVar.a(f52323a);
            ibVar.a(this.f3225a);
            ibVar.b();
        }
        if (this.f3224a != null && b()) {
            ibVar.a(f52324b);
            this.f3224a.b(ibVar);
            ibVar.b();
        }
        if (this.f3227b != null) {
            ibVar.a(f52325c);
            ibVar.a(this.f3227b);
            ibVar.b();
        }
        if (this.f3228c != null && d()) {
            ibVar.a(f52326d);
            ibVar.a(this.f3228c);
            ibVar.b();
        }
        if (e()) {
            ibVar.a(f52327e);
            ibVar.a(this.f3223a);
            ibVar.b();
        }
        if (this.f3229d != null && f()) {
            ibVar.a(f52328f);
            ibVar.a(this.f3229d);
            ibVar.b();
        }
        if (this.f3230e != null && g()) {
            ibVar.a(f52329g);
            ibVar.a(this.f3230e);
            ibVar.b();
        }
        if (this.f3231f != null && h()) {
            ibVar.a(f52330h);
            ibVar.a(this.f3231f);
            ibVar.b();
        }
        if (this.f3232g != null && i()) {
            ibVar.a(f52331i);
            ibVar.a(this.f3232g);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2856a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = hpVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3225a.equals(hpVar.f3225a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = hpVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3224a.compareTo(hpVar.f3224a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = hpVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3227b.equals(hpVar.f3227b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = hpVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f3228c.equals(hpVar.f3228c))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = hpVar.e();
        if ((e11 || e12) && (!e11 || !e12 || this.f3223a != hpVar.f3223a)) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = hpVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f3229d.equals(hpVar.f3229d))) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = hpVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3230e.equals(hpVar.f3230e))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = hpVar.h();
        if ((h11 || h12) && (!h11 || !h12 || !this.f3231f.equals(hpVar.f3231f))) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = hpVar.i();
        if (!i11 && !i12) {
            return true;
        }
        if (!i11 || !i12 || !this.f3232g.equals(hpVar.f3232g)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        if (!getClass().equals(hpVar.getClass())) {
            return getClass().getName().compareTo(hpVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hpVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a19 = hs.a(this.f3225a, hpVar.f3225a)) != 0) {
            return a19;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hpVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a18 = hs.a((Comparable) this.f3224a, (Comparable) hpVar.f3224a)) != 0) {
            return a18;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hpVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a17 = hs.a(this.f3227b, hpVar.f3227b)) != 0) {
            return a17;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hpVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a16 = hs.a(this.f3228c, hpVar.f3228c)) != 0) {
            return a16;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hpVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a15 = hs.a(this.f3223a, hpVar.f3223a)) != 0) {
            return a15;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hpVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a14 = hs.a(this.f3229d, hpVar.f3229d)) != 0) {
            return a14;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hpVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a13 = hs.a(this.f3230e, hpVar.f3230e)) != 0) {
            return a13;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hpVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a12 = hs.a(this.f3231f, hpVar.f3231f)) != 0) {
            return a12;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hpVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a11 = hs.a(this.f3232g, hpVar.f3232g)) == 0) {
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
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3225a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3224a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3227b = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3228c = ibVar.a();
                        break;
                    }
                case 6:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3223a = ibVar.a();
                        a(true);
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3229d = ibVar.a();
                        break;
                    }
                case 8:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3230e = ibVar.a();
                        break;
                    }
                case 9:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3231f = ibVar.a();
                        break;
                    }
                case 10:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3232g = ibVar.a();
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
    public void m2854a() {
        if (this.f3227b == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
