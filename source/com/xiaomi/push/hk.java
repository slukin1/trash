package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class hk implements hr<hk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52277a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3168a = new ig("XmPushActionSubscription");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52278b = new hy("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52279c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52280d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52281e = new hy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52282f = new hy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52283g = new hy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52284h = new hy("", (byte) 15, 8);

    /* renamed from: a  reason: collision with other field name */
    public gv f3169a;

    /* renamed from: a  reason: collision with other field name */
    public String f3170a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f3171a;

    /* renamed from: b  reason: collision with other field name */
    public String f3172b;

    /* renamed from: c  reason: collision with other field name */
    public String f3173c;

    /* renamed from: d  reason: collision with other field name */
    public String f3174d;

    /* renamed from: e  reason: collision with other field name */
    public String f3175e;

    /* renamed from: f  reason: collision with other field name */
    public String f3176f;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2840a() {
        return this.f3170a != null;
    }

    public boolean b() {
        return this.f3169a != null;
    }

    public boolean c() {
        return this.f3172b != null;
    }

    public boolean d() {
        return this.f3173c != null;
    }

    public boolean e() {
        return this.f3174d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return compareTo((hk) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3175e != null;
    }

    public boolean g() {
        return this.f3176f != null;
    }

    public boolean h() {
        return this.f3171a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionSubscription(");
        boolean z12 = false;
        if (a()) {
            sb2.append("debug:");
            String str = this.f3170a;
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
            gv gvVar = this.f3169a;
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
        String str2 = this.f3172b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f3173c;
        if (str3 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("topic:");
        String str4 = this.f3174d;
        if (str4 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str4);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str5 = this.f3175e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("category:");
            String str6 = this.f3176f;
            if (str6 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str6);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("aliases:");
            List<String> list = this.f3171a;
            if (list == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(list);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public hk a(String str) {
        this.f3172b = str;
        return this;
    }

    public hk b(String str) {
        this.f3173c = str;
        return this;
    }

    public hk c(String str) {
        this.f3174d = str;
        return this;
    }

    public hk d(String str) {
        this.f3175e = str;
        return this;
    }

    public hk e(String str) {
        this.f3176f = str;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2841a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = hkVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3170a.equals(hkVar.f3170a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = hkVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3169a.compareTo(hkVar.f3169a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = hkVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3172b.equals(hkVar.f3172b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = hkVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f3173c.equals(hkVar.f3173c))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = hkVar.e();
        if ((e11 || e12) && (!e11 || !e12 || !this.f3174d.equals(hkVar.f3174d))) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = hkVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f3175e.equals(hkVar.f3175e))) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = hkVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3176f.equals(hkVar.f3176f))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = hkVar.h();
        if (!h11 && !h12) {
            return true;
        }
        if (!h11 || !h12 || !this.f3171a.equals(hkVar.f3171a)) {
            return false;
        }
        return true;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3168a);
        if (this.f3170a != null && a()) {
            ibVar.a(f52277a);
            ibVar.a(this.f3170a);
            ibVar.b();
        }
        if (this.f3169a != null && b()) {
            ibVar.a(f52278b);
            this.f3169a.b(ibVar);
            ibVar.b();
        }
        if (this.f3172b != null) {
            ibVar.a(f52279c);
            ibVar.a(this.f3172b);
            ibVar.b();
        }
        if (this.f3173c != null) {
            ibVar.a(f52280d);
            ibVar.a(this.f3173c);
            ibVar.b();
        }
        if (this.f3174d != null) {
            ibVar.a(f52281e);
            ibVar.a(this.f3174d);
            ibVar.b();
        }
        if (this.f3175e != null && f()) {
            ibVar.a(f52282f);
            ibVar.a(this.f3175e);
            ibVar.b();
        }
        if (this.f3176f != null && g()) {
            ibVar.a(f52283g);
            ibVar.a(this.f3176f);
            ibVar.b();
        }
        if (this.f3171a != null && h()) {
            ibVar.a(f52284h);
            ibVar.a(new hz((byte) 11, this.f3171a.size()));
            for (String a11 : this.f3171a) {
                ibVar.a(a11);
            }
            ibVar.e();
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a */
    public int compareTo(hk hkVar) {
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        if (!getClass().equals(hkVar.getClass())) {
            return getClass().getName().compareTo(hkVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hkVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a18 = hs.a(this.f3170a, hkVar.f3170a)) != 0) {
            return a18;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hkVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a17 = hs.a((Comparable) this.f3169a, (Comparable) hkVar.f3169a)) != 0) {
            return a17;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hkVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a16 = hs.a(this.f3172b, hkVar.f3172b)) != 0) {
            return a16;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hkVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a15 = hs.a(this.f3173c, hkVar.f3173c)) != 0) {
            return a15;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hkVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a14 = hs.a(this.f3174d, hkVar.f3174d)) != 0) {
            return a14;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a13 = hs.a(this.f3175e, hkVar.f3175e)) != 0) {
            return a13;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a12 = hs.a(this.f3176f, hkVar.f3176f)) != 0) {
            return a12;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a11 = hs.a((List) this.f3171a, (List) hkVar.f3171a)) == 0) {
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
                        this.f3170a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3169a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3172b = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3173c = ibVar.a();
                        break;
                    }
                case 5:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3174d = ibVar.a();
                        break;
                    }
                case 6:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3175e = ibVar.a();
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3176f = ibVar.a();
                        break;
                    }
                case 8:
                    if (b11 != 15) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        hz a12 = ibVar.a();
                        this.f3171a = new ArrayList(a12.f3244a);
                        for (int i11 = 0; i11 < a12.f3244a; i11++) {
                            this.f3171a.add(ibVar.a());
                        }
                        ibVar.i();
                        break;
                    }
                default:
                    ie.a(ibVar, b11);
                    break;
            }
            ibVar.g();
        }
    }

    public void a() {
        if (this.f3172b == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3173c == null) {
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f3174d == null) {
            throw new ic("Required field 'topic' was not present! Struct: " + toString());
        }
    }
}
