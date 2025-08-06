package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class gk implements hr<gk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f51949a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f2912a = new ig("ClientUploadDataItem");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f51950b = new hy("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f51951c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f51952d = new hy("", (byte) 10, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f51953e = new hy("", (byte) 10, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f51954f = new hy("", (byte) 2, 6);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f51955g = new hy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f51956h = new hy("", (byte) 11, 8);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f51957i = new hy("", (byte) 11, 9);

    /* renamed from: j  reason: collision with root package name */
    private static final hy f51958j = new hy("", (byte) 13, 10);

    /* renamed from: k  reason: collision with root package name */
    private static final hy f51959k = new hy("", (byte) 11, 11);

    /* renamed from: a  reason: collision with other field name */
    public long f2913a;

    /* renamed from: a  reason: collision with other field name */
    public String f2914a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f2915a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f2916a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2917a;

    /* renamed from: b  reason: collision with other field name */
    public long f2918b;

    /* renamed from: b  reason: collision with other field name */
    public String f2919b;

    /* renamed from: c  reason: collision with other field name */
    public String f2920c;

    /* renamed from: d  reason: collision with other field name */
    public String f2921d;

    /* renamed from: e  reason: collision with other field name */
    public String f2922e;

    /* renamed from: f  reason: collision with other field name */
    public String f2923f;

    /* renamed from: g  reason: collision with other field name */
    public String f2924g;

    /* renamed from: a  reason: collision with other method in class */
    public String m2726a() {
        return this.f2914a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2728a() {
    }

    public gk b(String str) {
        this.f2919b = str;
        return this;
    }

    public gk c(String str) {
        this.f2920c = str;
        return this;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m2734d() {
        return this.f2915a.get(0);
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m2735e() {
        return this.f2915a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gk)) {
            return compareTo((gk) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f2915a.get(2);
    }

    public boolean g() {
        return this.f2921d != null;
    }

    public boolean h() {
        return this.f2922e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f2923f != null;
    }

    public boolean j() {
        return this.f2916a != null;
    }

    public boolean k() {
        return this.f2924g != null;
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("ClientUploadDataItem(");
        boolean z12 = false;
        if (a()) {
            sb2.append("channel:");
            String str = this.f2914a;
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
            sb2.append("data:");
            String str2 = this.f2919b;
            if (str2 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str2);
            }
            z11 = false;
        }
        if (c()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("name:");
            String str3 = this.f2920c;
            if (str3 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str3);
            }
            z11 = false;
        }
        if (d()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("counter:");
            sb2.append(this.f2913a);
            z11 = false;
        }
        if (e()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("timestamp:");
            sb2.append(this.f2918b);
            z11 = false;
        }
        if (f()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("fromSdk:");
            sb2.append(this.f2917a);
            z11 = false;
        }
        if (g()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("category:");
            String str4 = this.f2921d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
            z11 = false;
        }
        if (h()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("sourcePackage:");
            String str5 = this.f2922e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
            z11 = false;
        }
        if (i()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("id:");
            String str6 = this.f2923f;
            if (str6 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str6);
            }
            z11 = false;
        }
        if (j()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("extra:");
            Map<String, String> map = this.f2916a;
            if (map == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(map);
            }
        } else {
            z12 = z11;
        }
        if (k()) {
            if (!z12) {
                sb2.append(", ");
            }
            sb2.append("pkgName:");
            String str7 = this.f2924g;
            if (str7 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str7);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public gk a(String str) {
        this.f2914a = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2732b() {
        return this.f2919b != null;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2733c() {
        return this.f2920c != null;
    }

    public gk d(String str) {
        this.f2921d = str;
        return this;
    }

    public gk e(String str) {
        this.f2922e = str;
        return this;
    }

    public gk f(String str) {
        this.f2923f = str;
        return this;
    }

    public gk g(String str) {
        this.f2924g = str;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2730a() {
        return this.f2914a != null;
    }

    public String b() {
        return this.f2920c;
    }

    public void c(boolean z11) {
        this.f2915a.set(2, z11);
    }

    public String d() {
        return this.f2923f;
    }

    public String e() {
        return this.f2924g;
    }

    public gk a(long j11) {
        this.f2913a = j11;
        a(true);
        return this;
    }

    public gk b(long j11) {
        this.f2918b = j11;
        b(true);
        return this;
    }

    public String c() {
        return this.f2922e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2729a(boolean z11) {
        this.f2915a.set(0, z11);
    }

    public void b(boolean z11) {
        this.f2915a.set(1, z11);
    }

    public long a() {
        return this.f2918b;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f2912a);
        if (this.f2914a != null && a()) {
            ibVar.a(f51949a);
            ibVar.a(this.f2914a);
            ibVar.b();
        }
        if (this.f2919b != null && b()) {
            ibVar.a(f51950b);
            ibVar.a(this.f2919b);
            ibVar.b();
        }
        if (this.f2920c != null && c()) {
            ibVar.a(f51951c);
            ibVar.a(this.f2920c);
            ibVar.b();
        }
        if (d()) {
            ibVar.a(f51952d);
            ibVar.a(this.f2913a);
            ibVar.b();
        }
        if (e()) {
            ibVar.a(f51953e);
            ibVar.a(this.f2918b);
            ibVar.b();
        }
        if (f()) {
            ibVar.a(f51954f);
            ibVar.a(this.f2917a);
            ibVar.b();
        }
        if (this.f2921d != null && g()) {
            ibVar.a(f51955g);
            ibVar.a(this.f2921d);
            ibVar.b();
        }
        if (this.f2922e != null && h()) {
            ibVar.a(f51956h);
            ibVar.a(this.f2922e);
            ibVar.b();
        }
        if (this.f2923f != null && i()) {
            ibVar.a(f51957i);
            ibVar.a(this.f2923f);
            ibVar.b();
        }
        if (this.f2916a != null && j()) {
            ibVar.a(f51958j);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f2916a.size()));
            for (Map.Entry next : this.f2916a.entrySet()) {
                ibVar.a((String) next.getKey());
                ibVar.a((String) next.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (this.f2924g != null && k()) {
            ibVar.a(f51959k);
            ibVar.a(this.f2924g);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    public gk a(boolean z11) {
        this.f2917a = z11;
        c(true);
        return this;
    }

    public void a(String str, String str2) {
        if (this.f2916a == null) {
            this.f2916a = new HashMap();
        }
        this.f2916a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m2727a() {
        return this.f2916a;
    }

    public gk a(Map<String, String> map) {
        this.f2916a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2731a(gk gkVar) {
        if (gkVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = gkVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f2914a.equals(gkVar.f2914a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = gkVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f2919b.equals(gkVar.f2919b))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = gkVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f2920c.equals(gkVar.f2920c))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = gkVar.d();
        if ((d11 || d12) && (!d11 || !d12 || this.f2913a != gkVar.f2913a)) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = gkVar.e();
        if ((e11 || e12) && (!e11 || !e12 || this.f2918b != gkVar.f2918b)) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = gkVar.f();
        if ((f11 || f12) && (!f11 || !f12 || this.f2917a != gkVar.f2917a)) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = gkVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f2921d.equals(gkVar.f2921d))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = gkVar.h();
        if ((h11 || h12) && (!h11 || !h12 || !this.f2922e.equals(gkVar.f2922e))) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = gkVar.i();
        if ((i11 || i12) && (!i11 || !i12 || !this.f2923f.equals(gkVar.f2923f))) {
            return false;
        }
        boolean j11 = j();
        boolean j12 = gkVar.j();
        if ((j11 || j12) && (!j11 || !j12 || !this.f2916a.equals(gkVar.f2916a))) {
            return false;
        }
        boolean k11 = k();
        boolean k12 = gkVar.k();
        if (!k11 && !k12) {
            return true;
        }
        if (!k11 || !k12 || !this.f2924g.equals(gkVar.f2924g)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(gk gkVar) {
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
        int a22;
        if (!getClass().equals(gkVar.getClass())) {
            return getClass().getName().compareTo(gkVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gkVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a22 = hs.a(this.f2914a, gkVar.f2914a)) != 0) {
            return a22;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gkVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a21 = hs.a(this.f2919b, gkVar.f2919b)) != 0) {
            return a21;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gkVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a19 = hs.a(this.f2920c, gkVar.f2920c)) != 0) {
            return a19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gkVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a18 = hs.a(this.f2913a, gkVar.f2913a)) != 0) {
            return a18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gkVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a17 = hs.a(this.f2918b, gkVar.f2918b)) != 0) {
            return a17;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gkVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a16 = hs.a(this.f2917a, gkVar.f2917a)) != 0) {
            return a16;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gkVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a15 = hs.a(this.f2921d, gkVar.f2921d)) != 0) {
            return a15;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gkVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a14 = hs.a(this.f2922e, gkVar.f2922e)) != 0) {
            return a14;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gkVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a13 = hs.a(this.f2923f, gkVar.f2923f)) != 0) {
            return a13;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gkVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a12 = hs.a((Map) this.f2916a, (Map) gkVar.f2916a)) != 0) {
            return a12;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gkVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!k() || (a11 = hs.a(this.f2924g, gkVar.f2924g)) == 0) {
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
                        this.f2914a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2919b = ibVar.a();
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2920c = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2913a = ibVar.a();
                        a(true);
                        break;
                    }
                case 5:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2918b = ibVar.a();
                        b(true);
                        break;
                    }
                case 6:
                    if (b11 != 2) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2917a = ibVar.a();
                        c(true);
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2921d = ibVar.a();
                        break;
                    }
                case 8:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2922e = ibVar.a();
                        break;
                    }
                case 9:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2923f = ibVar.a();
                        break;
                    }
                case 10:
                    if (b11 != 13) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        ia a12 = ibVar.a();
                        this.f2916a = new HashMap(a12.f3247a * 2);
                        for (int i11 = 0; i11 < a12.f3247a; i11++) {
                            this.f2916a.put(ibVar.a(), ibVar.a());
                        }
                        ibVar.h();
                        break;
                    }
                case 11:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2924g = ibVar.a();
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
