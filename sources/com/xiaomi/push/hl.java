package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;

public class hl implements hr<hl, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52285a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3177a = new ig("XmPushActionSubscriptionResult");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52286b = new hy("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52287c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52288d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52289e = new hy("", (byte) 10, 6);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52290f = new hy("", (byte) 11, 7);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52291g = new hy("", (byte) 11, 8);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52292h = new hy("", (byte) 11, 9);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f52293i = new hy("", (byte) 11, 10);

    /* renamed from: a  reason: collision with other field name */
    public long f3178a;

    /* renamed from: a  reason: collision with other field name */
    public gv f3179a;

    /* renamed from: a  reason: collision with other field name */
    public String f3180a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3181a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f3182b;

    /* renamed from: c  reason: collision with other field name */
    public String f3183c;

    /* renamed from: d  reason: collision with other field name */
    public String f3184d;

    /* renamed from: e  reason: collision with other field name */
    public String f3185e;

    /* renamed from: f  reason: collision with other field name */
    public String f3186f;

    /* renamed from: g  reason: collision with other field name */
    public String f3187g;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2843a() {
        return this.f3180a != null;
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2845b() {
        return this.f3179a != null;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2846c() {
        return this.f3182b != null;
    }

    public boolean d() {
        return this.f3183c != null;
    }

    public boolean e() {
        return this.f3181a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hl)) {
            return compareTo((hl) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3184d != null;
    }

    public boolean g() {
        return this.f3185e != null;
    }

    public boolean h() {
        return this.f3186f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f3187g != null;
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z12 = false;
        if (a()) {
            sb2.append("debug:");
            String str = this.f3180a;
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
            gv gvVar = this.f3179a;
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
        String str2 = this.f3182b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        if (d()) {
            sb2.append(", ");
            sb2.append("appId:");
            String str3 = this.f3183c;
            if (str3 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str3);
            }
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("errorCode:");
            sb2.append(this.f3178a);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str4 = this.f3184d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("topic:");
            String str5 = this.f3185e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str6 = this.f3186f;
            if (str6 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str6);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f3187g;
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
        return this.f3182b;
    }

    public String b() {
        return this.f3185e;
    }

    public String c() {
        return this.f3187g;
    }

    public void a(boolean z11) {
        this.f3181a.set(0, z11);
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3177a);
        if (this.f3180a != null && a()) {
            ibVar.a(f52285a);
            ibVar.a(this.f3180a);
            ibVar.b();
        }
        if (this.f3179a != null && b()) {
            ibVar.a(f52286b);
            this.f3179a.b(ibVar);
            ibVar.b();
        }
        if (this.f3182b != null) {
            ibVar.a(f52287c);
            ibVar.a(this.f3182b);
            ibVar.b();
        }
        if (this.f3183c != null && d()) {
            ibVar.a(f52288d);
            ibVar.a(this.f3183c);
            ibVar.b();
        }
        if (e()) {
            ibVar.a(f52289e);
            ibVar.a(this.f3178a);
            ibVar.b();
        }
        if (this.f3184d != null && f()) {
            ibVar.a(f52290f);
            ibVar.a(this.f3184d);
            ibVar.b();
        }
        if (this.f3185e != null && g()) {
            ibVar.a(f52291g);
            ibVar.a(this.f3185e);
            ibVar.b();
        }
        if (this.f3186f != null && h()) {
            ibVar.a(f52292h);
            ibVar.a(this.f3186f);
            ibVar.b();
        }
        if (this.f3187g != null && i()) {
            ibVar.a(f52293i);
            ibVar.a(this.f3187g);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2844a(hl hlVar) {
        if (hlVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = hlVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3180a.equals(hlVar.f3180a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = hlVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3179a.compareTo(hlVar.f3179a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = hlVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3182b.equals(hlVar.f3182b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = hlVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f3183c.equals(hlVar.f3183c))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = hlVar.e();
        if ((e11 || e12) && (!e11 || !e12 || this.f3178a != hlVar.f3178a)) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = hlVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f3184d.equals(hlVar.f3184d))) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = hlVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3185e.equals(hlVar.f3185e))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = hlVar.h();
        if ((h11 || h12) && (!h11 || !h12 || !this.f3186f.equals(hlVar.f3186f))) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = hlVar.i();
        if (!i11 && !i12) {
            return true;
        }
        if (!i11 || !i12 || !this.f3187g.equals(hlVar.f3187g)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(hl hlVar) {
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        if (!getClass().equals(hlVar.getClass())) {
            return getClass().getName().compareTo(hlVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hlVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a19 = hs.a(this.f3180a, hlVar.f3180a)) != 0) {
            return a19;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hlVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a18 = hs.a((Comparable) this.f3179a, (Comparable) hlVar.f3179a)) != 0) {
            return a18;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hlVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a17 = hs.a(this.f3182b, hlVar.f3182b)) != 0) {
            return a17;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hlVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a16 = hs.a(this.f3183c, hlVar.f3183c)) != 0) {
            return a16;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hlVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a15 = hs.a(this.f3178a, hlVar.f3178a)) != 0) {
            return a15;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hlVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a14 = hs.a(this.f3184d, hlVar.f3184d)) != 0) {
            return a14;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hlVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a13 = hs.a(this.f3185e, hlVar.f3185e)) != 0) {
            return a13;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hlVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a12 = hs.a(this.f3186f, hlVar.f3186f)) != 0) {
            return a12;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hlVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a11 = hs.a(this.f3187g, hlVar.f3187g)) == 0) {
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
                        this.f3180a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3179a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3182b = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3183c = ibVar.a();
                        break;
                    }
                case 6:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3178a = ibVar.a();
                        a(true);
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3184d = ibVar.a();
                        break;
                    }
                case 8:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3185e = ibVar.a();
                        break;
                    }
                case 9:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3186f = ibVar.a();
                        break;
                    }
                case 10:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3187g = ibVar.a();
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
    public void m2842a() {
        if (this.f3182b == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
