package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class gx implements hr<gx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52153a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3019a = new ig("XmPushActionAckNotification");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52154b = new hy("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52155c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52156d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52157e = new hy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52158f = new hy("", (byte) 10, 7);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52159g = new hy("", (byte) 11, 8);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52160h = new hy("", (byte) 13, 9);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f52161i = new hy("", (byte) 11, 10);

    /* renamed from: j  reason: collision with root package name */
    private static final hy f52162j = new hy("", (byte) 11, 11);

    /* renamed from: a  reason: collision with other field name */
    public long f3020a = 0;

    /* renamed from: a  reason: collision with other field name */
    public gv f3021a;

    /* renamed from: a  reason: collision with other field name */
    public String f3022a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3023a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f3024a;

    /* renamed from: b  reason: collision with other field name */
    public String f3025b;

    /* renamed from: c  reason: collision with other field name */
    public String f3026c;

    /* renamed from: d  reason: collision with other field name */
    public String f3027d;

    /* renamed from: e  reason: collision with other field name */
    public String f3028e;

    /* renamed from: f  reason: collision with other field name */
    public String f3029f;

    /* renamed from: g  reason: collision with other field name */
    public String f3030g;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2775a() {
        return this.f3022a != null;
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2777b() {
        return this.f3021a != null;
    }

    public boolean c() {
        return this.f3025b != null;
    }

    public boolean d() {
        return this.f3026c != null;
    }

    public boolean e() {
        return this.f3027d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gx)) {
            return compareTo((gx) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3023a.get(0);
    }

    public boolean g() {
        return this.f3028e != null;
    }

    public boolean h() {
        return this.f3024a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f3029f != null;
    }

    public boolean j() {
        return this.f3030g != null;
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionAckNotification(");
        boolean z12 = false;
        if (a()) {
            sb2.append("debug:");
            String str = this.f3022a;
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
            gv gvVar = this.f3021a;
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
        String str2 = this.f3025b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        if (d()) {
            sb2.append(", ");
            sb2.append("appId:");
            String str3 = this.f3026c;
            if (str3 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str3);
            }
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("type:");
            String str4 = this.f3027d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("errorCode:");
            sb2.append(this.f3020a);
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str5 = this.f3028e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("extra:");
            Map<String, String> map = this.f3024a;
            if (map == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(map);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str6 = this.f3029f;
            if (str6 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str6);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f3030g;
            if (str7 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str7);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public gx a(gv gvVar) {
        this.f3021a = gvVar;
        return this;
    }

    public gx b(String str) {
        this.f3026c = str;
        return this;
    }

    public gx c(String str) {
        this.f3027d = str;
        return this;
    }

    public gx d(String str) {
        this.f3028e = str;
        return this;
    }

    public gx e(String str) {
        this.f3029f = str;
        return this;
    }

    public String a() {
        return this.f3025b;
    }

    public String b() {
        return this.f3027d;
    }

    public gx a(String str) {
        this.f3025b = str;
        return this;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3019a);
        if (this.f3022a != null && a()) {
            ibVar.a(f52153a);
            ibVar.a(this.f3022a);
            ibVar.b();
        }
        if (this.f3021a != null && b()) {
            ibVar.a(f52154b);
            this.f3021a.b(ibVar);
            ibVar.b();
        }
        if (this.f3025b != null) {
            ibVar.a(f52155c);
            ibVar.a(this.f3025b);
            ibVar.b();
        }
        if (this.f3026c != null && d()) {
            ibVar.a(f52156d);
            ibVar.a(this.f3026c);
            ibVar.b();
        }
        if (this.f3027d != null && e()) {
            ibVar.a(f52157e);
            ibVar.a(this.f3027d);
            ibVar.b();
        }
        if (f()) {
            ibVar.a(f52158f);
            ibVar.a(this.f3020a);
            ibVar.b();
        }
        if (this.f3028e != null && g()) {
            ibVar.a(f52159g);
            ibVar.a(this.f3028e);
            ibVar.b();
        }
        if (this.f3024a != null && h()) {
            ibVar.a(f52160h);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f3024a.size()));
            for (Map.Entry next : this.f3024a.entrySet()) {
                ibVar.a((String) next.getKey());
                ibVar.a((String) next.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (this.f3029f != null && i()) {
            ibVar.a(f52161i);
            ibVar.a(this.f3029f);
            ibVar.b();
        }
        if (this.f3030g != null && j()) {
            ibVar.a(f52162j);
            ibVar.a(this.f3030g);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    public gx a(long j11) {
        this.f3020a = j11;
        a(true);
        return this;
    }

    public void a(boolean z11) {
        this.f3023a.set(0, z11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m2773a() {
        return this.f3024a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2776a(gx gxVar) {
        if (gxVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = gxVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3022a.equals(gxVar.f3022a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = gxVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3021a.compareTo(gxVar.f3021a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = gxVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3025b.equals(gxVar.f3025b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = gxVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f3026c.equals(gxVar.f3026c))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = gxVar.e();
        if ((e11 || e12) && (!e11 || !e12 || !this.f3027d.equals(gxVar.f3027d))) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = gxVar.f();
        if ((f11 || f12) && (!f11 || !f12 || this.f3020a != gxVar.f3020a)) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = gxVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3028e.equals(gxVar.f3028e))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = gxVar.h();
        if ((h11 || h12) && (!h11 || !h12 || !this.f3024a.equals(gxVar.f3024a))) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = gxVar.i();
        if ((i11 || i12) && (!i11 || !i12 || !this.f3029f.equals(gxVar.f3029f))) {
            return false;
        }
        boolean j11 = j();
        boolean j12 = gxVar.j();
        if (!j11 && !j12) {
            return true;
        }
        if (!j11 || !j12 || !this.f3030g.equals(gxVar.f3030g)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(gx gxVar) {
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
        if (!getClass().equals(gxVar.getClass())) {
            return getClass().getName().compareTo(gxVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gxVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a21 = hs.a(this.f3022a, gxVar.f3022a)) != 0) {
            return a21;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gxVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a19 = hs.a((Comparable) this.f3021a, (Comparable) gxVar.f3021a)) != 0) {
            return a19;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gxVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a18 = hs.a(this.f3025b, gxVar.f3025b)) != 0) {
            return a18;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gxVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a17 = hs.a(this.f3026c, gxVar.f3026c)) != 0) {
            return a17;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gxVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a16 = hs.a(this.f3027d, gxVar.f3027d)) != 0) {
            return a16;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gxVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a15 = hs.a(this.f3020a, gxVar.f3020a)) != 0) {
            return a15;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gxVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a14 = hs.a(this.f3028e, gxVar.f3028e)) != 0) {
            return a14;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gxVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a13 = hs.a((Map) this.f3024a, (Map) gxVar.f3024a)) != 0) {
            return a13;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gxVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a12 = hs.a(this.f3029f, gxVar.f3029f)) != 0) {
            return a12;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gxVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a11 = hs.a(this.f3030g, gxVar.f3030g)) == 0) {
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
                        this.f3022a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3021a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3025b = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3026c = ibVar.a();
                        break;
                    }
                case 5:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3027d = ibVar.a();
                        break;
                    }
                case 7:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3020a = ibVar.a();
                        a(true);
                        break;
                    }
                case 8:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3028e = ibVar.a();
                        break;
                    }
                case 9:
                    if (b11 != 13) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        ia a12 = ibVar.a();
                        this.f3024a = new HashMap(a12.f3247a * 2);
                        for (int i11 = 0; i11 < a12.f3247a; i11++) {
                            this.f3024a.put(ibVar.a(), ibVar.a());
                        }
                        ibVar.h();
                        break;
                    }
                case 10:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3029f = ibVar.a();
                        break;
                    }
                case 11:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3030g = ibVar.a();
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
    public void m2774a() {
        if (this.f3025b == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
