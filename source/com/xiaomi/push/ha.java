package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class ha implements hr<ha, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52167a = new hy("", (byte) 12, 2);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3037a = new ig("XmPushActionCommand");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52168b = new hy("", (byte) 11, 3);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52169c = new hy("", (byte) 11, 4);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52170d = new hy("", (byte) 11, 5);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52171e = new hy("", (byte) 15, 6);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52172f = new hy("", (byte) 11, 7);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52173g = new hy("", (byte) 11, 9);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52174h = new hy("", (byte) 2, 10);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f52175i = new hy("", (byte) 2, 11);

    /* renamed from: j  reason: collision with root package name */
    private static final hy f52176j = new hy("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    public long f3038a;

    /* renamed from: a  reason: collision with other field name */
    public gv f3039a;

    /* renamed from: a  reason: collision with other field name */
    public String f3040a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3041a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public List<String> f3042a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3043a = false;

    /* renamed from: b  reason: collision with other field name */
    public String f3044b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f3045b = true;

    /* renamed from: c  reason: collision with other field name */
    public String f3046c;

    /* renamed from: d  reason: collision with other field name */
    public String f3047d;

    /* renamed from: e  reason: collision with other field name */
    public String f3048e;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2784a() {
        return this.f3039a != null;
    }

    public boolean b() {
        return this.f3040a != null;
    }

    public boolean c() {
        return this.f3044b != null;
    }

    public boolean d() {
        return this.f3046c != null;
    }

    public boolean e() {
        return this.f3042a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ha)) {
            return compareTo((ha) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3047d != null;
    }

    public boolean g() {
        return this.f3048e != null;
    }

    public boolean h() {
        return this.f3041a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f3041a.get(1);
    }

    public boolean j() {
        return this.f3041a.get(2);
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionCommand(");
        if (a()) {
            sb2.append("target:");
            gv gvVar = this.f3039a;
            if (gvVar == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(gvVar);
            }
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            sb2.append(", ");
        }
        sb2.append("id:");
        String str = this.f3040a;
        if (str == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str2 = this.f3044b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("cmdName:");
        String str3 = this.f3046c;
        if (str3 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str3);
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("cmdArgs:");
            List<String> list = this.f3042a;
            if (list == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(list);
            }
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str4 = this.f3047d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("category:");
            String str5 = this.f3048e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("updateCache:");
            sb2.append(this.f3043a);
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("response2Client:");
            sb2.append(this.f3045b);
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("createdTs:");
            sb2.append(this.f3038a);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public ha a(String str) {
        this.f3040a = str;
        return this;
    }

    public ha b(String str) {
        this.f3044b = str;
        return this;
    }

    public ha c(String str) {
        this.f3046c = str;
        return this;
    }

    public ha d(String str) {
        this.f3047d = str;
        return this;
    }

    public ha e(String str) {
        this.f3048e = str;
        return this;
    }

    public String a() {
        return this.f3046c;
    }

    public void b(boolean z11) {
        this.f3041a.set(1, z11);
    }

    public void c(boolean z11) {
        this.f3041a.set(2, z11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2783a(String str) {
        if (this.f3042a == null) {
            this.f3042a = new ArrayList();
        }
        this.f3042a.add(str);
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3037a);
        if (this.f3039a != null && a()) {
            ibVar.a(f52167a);
            this.f3039a.b(ibVar);
            ibVar.b();
        }
        if (this.f3040a != null) {
            ibVar.a(f52168b);
            ibVar.a(this.f3040a);
            ibVar.b();
        }
        if (this.f3044b != null) {
            ibVar.a(f52169c);
            ibVar.a(this.f3044b);
            ibVar.b();
        }
        if (this.f3046c != null) {
            ibVar.a(f52170d);
            ibVar.a(this.f3046c);
            ibVar.b();
        }
        if (this.f3042a != null && e()) {
            ibVar.a(f52171e);
            ibVar.a(new hz((byte) 11, this.f3042a.size()));
            for (String a11 : this.f3042a) {
                ibVar.a(a11);
            }
            ibVar.e();
            ibVar.b();
        }
        if (this.f3047d != null && f()) {
            ibVar.a(f52172f);
            ibVar.a(this.f3047d);
            ibVar.b();
        }
        if (this.f3048e != null && g()) {
            ibVar.a(f52173g);
            ibVar.a(this.f3048e);
            ibVar.b();
        }
        if (h()) {
            ibVar.a(f52174h);
            ibVar.a(this.f3043a);
            ibVar.b();
        }
        if (i()) {
            ibVar.a(f52175i);
            ibVar.a(this.f3045b);
            ibVar.b();
        }
        if (j()) {
            ibVar.a(f52176j);
            ibVar.a(this.f3038a);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    public void a(boolean z11) {
        this.f3041a.set(0, z11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2785a(ha haVar) {
        if (haVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = haVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3039a.compareTo(haVar.f3039a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = haVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3040a.equals(haVar.f3040a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = haVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3044b.equals(haVar.f3044b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = haVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f3046c.equals(haVar.f3046c))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = haVar.e();
        if ((e11 || e12) && (!e11 || !e12 || !this.f3042a.equals(haVar.f3042a))) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = haVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f3047d.equals(haVar.f3047d))) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = haVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3048e.equals(haVar.f3048e))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = haVar.h();
        if ((h11 || h12) && (!h11 || !h12 || this.f3043a != haVar.f3043a)) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = haVar.i();
        if ((i11 || i12) && (!i11 || !i12 || this.f3045b != haVar.f3045b)) {
            return false;
        }
        boolean j11 = j();
        boolean j12 = haVar.j();
        if (!j11 && !j12) {
            return true;
        }
        if (!j11 || !j12 || this.f3038a != haVar.f3038a) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(ha haVar) {
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
        if (!getClass().equals(haVar.getClass())) {
            return getClass().getName().compareTo(haVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(haVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a21 = hs.a((Comparable) this.f3039a, (Comparable) haVar.f3039a)) != 0) {
            return a21;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(haVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a19 = hs.a(this.f3040a, haVar.f3040a)) != 0) {
            return a19;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(haVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a18 = hs.a(this.f3044b, haVar.f3044b)) != 0) {
            return a18;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(haVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a17 = hs.a(this.f3046c, haVar.f3046c)) != 0) {
            return a17;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(haVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a16 = hs.a((List) this.f3042a, (List) haVar.f3042a)) != 0) {
            return a16;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(haVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a15 = hs.a(this.f3047d, haVar.f3047d)) != 0) {
            return a15;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(haVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a14 = hs.a(this.f3048e, haVar.f3048e)) != 0) {
            return a14;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(haVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a13 = hs.a(this.f3043a, haVar.f3043a)) != 0) {
            return a13;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(haVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a12 = hs.a(this.f3045b, haVar.f3045b)) != 0) {
            return a12;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(haVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a11 = hs.a(this.f3038a, haVar.f3038a)) == 0) {
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
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3039a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3040a = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3044b = ibVar.a();
                        break;
                    }
                case 5:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3046c = ibVar.a();
                        break;
                    }
                case 6:
                    if (b11 != 15) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        hz a12 = ibVar.a();
                        this.f3042a = new ArrayList(a12.f3244a);
                        for (int i11 = 0; i11 < a12.f3244a; i11++) {
                            this.f3042a.add(ibVar.a());
                        }
                        ibVar.i();
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3047d = ibVar.a();
                        break;
                    }
                case 9:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3048e = ibVar.a();
                        break;
                    }
                case 10:
                    if (b11 != 2) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3043a = ibVar.a();
                        a(true);
                        break;
                    }
                case 11:
                    if (b11 != 2) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3045b = ibVar.a();
                        b(true);
                        break;
                    }
                case 12:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3038a = ibVar.a();
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
    public void m2782a() {
        if (this.f3040a == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3044b == null) {
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f3046c == null) {
            throw new ic("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }
}
