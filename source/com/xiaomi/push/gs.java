package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;

public class gs implements hr<gs, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52093a = new hy("", (byte) 12, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f2952a = new ig("PushMessage");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52094b = new hy("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52095c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52096d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52097e = new hy("", (byte) 10, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52098f = new hy("", (byte) 10, 6);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52099g = new hy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52100h = new hy("", (byte) 11, 8);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f52101i = new hy("", (byte) 11, 9);

    /* renamed from: j  reason: collision with root package name */
    private static final hy f52102j = new hy("", (byte) 11, 10);

    /* renamed from: k  reason: collision with root package name */
    private static final hy f52103k = new hy("", (byte) 11, 11);

    /* renamed from: l  reason: collision with root package name */
    private static final hy f52104l = new hy("", (byte) 12, 12);

    /* renamed from: m  reason: collision with root package name */
    private static final hy f52105m = new hy("", (byte) 11, 13);

    /* renamed from: n  reason: collision with root package name */
    private static final hy f52106n = new hy("", (byte) 2, 14);

    /* renamed from: o  reason: collision with root package name */
    private static final hy f52107o = new hy("", (byte) 11, 15);

    /* renamed from: p  reason: collision with root package name */
    private static final hy f52108p = new hy("", (byte) 10, 16);

    /* renamed from: q  reason: collision with root package name */
    private static final hy f52109q = new hy("", (byte) 11, 20);

    /* renamed from: r  reason: collision with root package name */
    private static final hy f52110r = new hy("", (byte) 11, 21);

    /* renamed from: a  reason: collision with other field name */
    public long f2953a;

    /* renamed from: a  reason: collision with other field name */
    public gt f2954a;

    /* renamed from: a  reason: collision with other field name */
    public gv f2955a;

    /* renamed from: a  reason: collision with other field name */
    public String f2956a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f2957a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f2958a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f2959b;

    /* renamed from: b  reason: collision with other field name */
    public String f2960b;

    /* renamed from: c  reason: collision with other field name */
    public long f2961c;

    /* renamed from: c  reason: collision with other field name */
    public String f2962c;

    /* renamed from: d  reason: collision with other field name */
    public String f2963d;

    /* renamed from: e  reason: collision with other field name */
    public String f2964e;

    /* renamed from: f  reason: collision with other field name */
    public String f2965f;

    /* renamed from: g  reason: collision with other field name */
    public String f2966g;

    /* renamed from: h  reason: collision with other field name */
    public String f2967h;

    /* renamed from: i  reason: collision with other field name */
    public String f2968i;

    /* renamed from: j  reason: collision with other field name */
    public String f2969j;

    /* renamed from: k  reason: collision with other field name */
    public String f2970k;

    /* renamed from: l  reason: collision with other field name */
    public String f2971l;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2752a() {
        return this.f2955a != null;
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2754b() {
        return this.f2956a != null;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2755c() {
        return this.f2960b != null;
    }

    public boolean d() {
        return this.f2962c != null;
    }

    public boolean e() {
        return this.f2957a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gs)) {
            return compareTo((gs) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f2957a.get(1);
    }

    public boolean g() {
        return this.f2963d != null;
    }

    public boolean h() {
        return this.f2964e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f2965f != null;
    }

    public boolean j() {
        return this.f2966g != null;
    }

    public boolean k() {
        return this.f2967h != null;
    }

    public boolean l() {
        return this.f2954a != null;
    }

    public boolean m() {
        return this.f2968i != null;
    }

    public boolean n() {
        return this.f2957a.get(2);
    }

    public boolean o() {
        return this.f2969j != null;
    }

    public boolean p() {
        return this.f2957a.get(3);
    }

    public boolean q() {
        return this.f2970k != null;
    }

    public boolean r() {
        return this.f2971l != null;
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("PushMessage(");
        if (a()) {
            sb2.append("to:");
            gv gvVar = this.f2955a;
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
        String str = this.f2956a;
        if (str == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str2 = this.f2960b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("payload:");
        String str3 = this.f2962c;
        if (str3 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str3);
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("createAt:");
            sb2.append(this.f2953a);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("ttl:");
            sb2.append(this.f2959b);
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("collapseKey:");
            String str4 = this.f2963d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str5 = this.f2964e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("regId:");
            String str6 = this.f2965f;
            if (str6 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str6);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f2966g;
            if (str7 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str7);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("topic:");
            String str8 = this.f2967h;
            if (str8 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str8);
            }
        }
        if (l()) {
            sb2.append(", ");
            sb2.append("metaInfo:");
            gt gtVar = this.f2954a;
            if (gtVar == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(gtVar);
            }
        }
        if (m()) {
            sb2.append(", ");
            sb2.append("aliasName:");
            String str9 = this.f2968i;
            if (str9 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str9);
            }
        }
        if (n()) {
            sb2.append(", ");
            sb2.append("isOnline:");
            sb2.append(this.f2958a);
        }
        if (o()) {
            sb2.append(", ");
            sb2.append("userAccount:");
            String str10 = this.f2969j;
            if (str10 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str10);
            }
        }
        if (p()) {
            sb2.append(", ");
            sb2.append("miid:");
            sb2.append(this.f2961c);
        }
        if (q()) {
            sb2.append(", ");
            sb2.append("imeiMd5:");
            String str11 = this.f2970k;
            if (str11 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str11);
            }
        }
        if (r()) {
            sb2.append(", ");
            sb2.append("deviceId:");
            String str12 = this.f2971l;
            if (str12 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str12);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2750a() {
        return this.f2956a;
    }

    public String b() {
        return this.f2960b;
    }

    public String c() {
        return this.f2962c;
    }

    public void d(boolean z11) {
        this.f2957a.set(3, z11);
    }

    public long a() {
        return this.f2953a;
    }

    public void b(boolean z11) {
        this.f2957a.set(1, z11);
    }

    public void c(boolean z11) {
        this.f2957a.set(2, z11);
    }

    public void a(boolean z11) {
        this.f2957a.set(0, z11);
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f2952a);
        if (this.f2955a != null && a()) {
            ibVar.a(f52093a);
            this.f2955a.b(ibVar);
            ibVar.b();
        }
        if (this.f2956a != null) {
            ibVar.a(f52094b);
            ibVar.a(this.f2956a);
            ibVar.b();
        }
        if (this.f2960b != null) {
            ibVar.a(f52095c);
            ibVar.a(this.f2960b);
            ibVar.b();
        }
        if (this.f2962c != null) {
            ibVar.a(f52096d);
            ibVar.a(this.f2962c);
            ibVar.b();
        }
        if (e()) {
            ibVar.a(f52097e);
            ibVar.a(this.f2953a);
            ibVar.b();
        }
        if (f()) {
            ibVar.a(f52098f);
            ibVar.a(this.f2959b);
            ibVar.b();
        }
        if (this.f2963d != null && g()) {
            ibVar.a(f52099g);
            ibVar.a(this.f2963d);
            ibVar.b();
        }
        if (this.f2964e != null && h()) {
            ibVar.a(f52100h);
            ibVar.a(this.f2964e);
            ibVar.b();
        }
        if (this.f2965f != null && i()) {
            ibVar.a(f52101i);
            ibVar.a(this.f2965f);
            ibVar.b();
        }
        if (this.f2966g != null && j()) {
            ibVar.a(f52102j);
            ibVar.a(this.f2966g);
            ibVar.b();
        }
        if (this.f2967h != null && k()) {
            ibVar.a(f52103k);
            ibVar.a(this.f2967h);
            ibVar.b();
        }
        if (this.f2954a != null && l()) {
            ibVar.a(f52104l);
            this.f2954a.b(ibVar);
            ibVar.b();
        }
        if (this.f2968i != null && m()) {
            ibVar.a(f52105m);
            ibVar.a(this.f2968i);
            ibVar.b();
        }
        if (n()) {
            ibVar.a(f52106n);
            ibVar.a(this.f2958a);
            ibVar.b();
        }
        if (this.f2969j != null && o()) {
            ibVar.a(f52107o);
            ibVar.a(this.f2969j);
            ibVar.b();
        }
        if (p()) {
            ibVar.a(f52108p);
            ibVar.a(this.f2961c);
            ibVar.b();
        }
        if (this.f2970k != null && q()) {
            ibVar.a(f52109q);
            ibVar.a(this.f2970k);
            ibVar.b();
        }
        if (this.f2971l != null && r()) {
            ibVar.a(f52110r);
            ibVar.a(this.f2971l);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2753a(gs gsVar) {
        if (gsVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = gsVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f2955a.compareTo(gsVar.f2955a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = gsVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f2956a.equals(gsVar.f2956a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = gsVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f2960b.equals(gsVar.f2960b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = gsVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f2962c.equals(gsVar.f2962c))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = gsVar.e();
        if ((e11 || e12) && (!e11 || !e12 || this.f2953a != gsVar.f2953a)) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = gsVar.f();
        if ((f11 || f12) && (!f11 || !f12 || this.f2959b != gsVar.f2959b)) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = gsVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f2963d.equals(gsVar.f2963d))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = gsVar.h();
        if ((h11 || h12) && (!h11 || !h12 || !this.f2964e.equals(gsVar.f2964e))) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = gsVar.i();
        if ((i11 || i12) && (!i11 || !i12 || !this.f2965f.equals(gsVar.f2965f))) {
            return false;
        }
        boolean j11 = j();
        boolean j12 = gsVar.j();
        if ((j11 || j12) && (!j11 || !j12 || !this.f2966g.equals(gsVar.f2966g))) {
            return false;
        }
        boolean k11 = k();
        boolean k12 = gsVar.k();
        if ((k11 || k12) && (!k11 || !k12 || !this.f2967h.equals(gsVar.f2967h))) {
            return false;
        }
        boolean l11 = l();
        boolean l12 = gsVar.l();
        if ((l11 || l12) && (!l11 || !l12 || !this.f2954a.compareTo(gsVar.f2954a))) {
            return false;
        }
        boolean m11 = m();
        boolean m12 = gsVar.m();
        if ((m11 || m12) && (!m11 || !m12 || !this.f2968i.equals(gsVar.f2968i))) {
            return false;
        }
        boolean n11 = n();
        boolean n12 = gsVar.n();
        if ((n11 || n12) && (!n11 || !n12 || this.f2958a != gsVar.f2958a)) {
            return false;
        }
        boolean o11 = o();
        boolean o12 = gsVar.o();
        if ((o11 || o12) && (!o11 || !o12 || !this.f2969j.equals(gsVar.f2969j))) {
            return false;
        }
        boolean p11 = p();
        boolean p12 = gsVar.p();
        if ((p11 || p12) && (!p11 || !p12 || this.f2961c != gsVar.f2961c)) {
            return false;
        }
        boolean q11 = q();
        boolean q12 = gsVar.q();
        if ((q11 || q12) && (!q11 || !q12 || !this.f2970k.equals(gsVar.f2970k))) {
            return false;
        }
        boolean r11 = r();
        boolean r12 = gsVar.r();
        if (!r11 && !r12) {
            return true;
        }
        if (!r11 || !r12 || !this.f2971l.equals(gsVar.f2971l)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(gs gsVar) {
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
        int a23;
        int a24;
        int a25;
        int a26;
        int a27;
        int a28;
        int a29;
        if (!getClass().equals(gsVar.getClass())) {
            return getClass().getName().compareTo(gsVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gsVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a29 = hs.a((Comparable) this.f2955a, (Comparable) gsVar.f2955a)) != 0) {
            return a29;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gsVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a28 = hs.a(this.f2956a, gsVar.f2956a)) != 0) {
            return a28;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gsVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a27 = hs.a(this.f2960b, gsVar.f2960b)) != 0) {
            return a27;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gsVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a26 = hs.a(this.f2962c, gsVar.f2962c)) != 0) {
            return a26;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gsVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a25 = hs.a(this.f2953a, gsVar.f2953a)) != 0) {
            return a25;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gsVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a24 = hs.a(this.f2959b, gsVar.f2959b)) != 0) {
            return a24;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gsVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a23 = hs.a(this.f2963d, gsVar.f2963d)) != 0) {
            return a23;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gsVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a22 = hs.a(this.f2964e, gsVar.f2964e)) != 0) {
            return a22;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gsVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a21 = hs.a(this.f2965f, gsVar.f2965f)) != 0) {
            return a21;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gsVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a19 = hs.a(this.f2966g, gsVar.f2966g)) != 0) {
            return a19;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gsVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a18 = hs.a(this.f2967h, gsVar.f2967h)) != 0) {
            return a18;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(gsVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a17 = hs.a((Comparable) this.f2954a, (Comparable) gsVar.f2954a)) != 0) {
            return a17;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gsVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a16 = hs.a(this.f2968i, gsVar.f2968i)) != 0) {
            return a16;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gsVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a15 = hs.a(this.f2958a, gsVar.f2958a)) != 0) {
            return a15;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(gsVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a14 = hs.a(this.f2969j, gsVar.f2969j)) != 0) {
            return a14;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(gsVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a13 = hs.a(this.f2961c, gsVar.f2961c)) != 0) {
            return a13;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(gsVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a12 = hs.a(this.f2970k, gsVar.f2970k)) != 0) {
            return a12;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(gsVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!r() || (a11 = hs.a(this.f2971l, gsVar.f2971l)) == 0) {
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
            short s11 = a11.f3243a;
            if (s11 != 20) {
                if (s11 != 21) {
                    switch (s11) {
                        case 1:
                            if (b11 != 12) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                gv gvVar = new gv();
                                this.f2955a = gvVar;
                                gvVar.a(ibVar);
                                break;
                            }
                        case 2:
                            if (b11 != 11) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2956a = ibVar.a();
                                break;
                            }
                        case 3:
                            if (b11 != 11) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2960b = ibVar.a();
                                break;
                            }
                        case 4:
                            if (b11 != 11) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2962c = ibVar.a();
                                break;
                            }
                        case 5:
                            if (b11 != 10) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2953a = ibVar.a();
                                a(true);
                                break;
                            }
                        case 6:
                            if (b11 != 10) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2959b = ibVar.a();
                                b(true);
                                break;
                            }
                        case 7:
                            if (b11 != 11) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2963d = ibVar.a();
                                break;
                            }
                        case 8:
                            if (b11 != 11) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2964e = ibVar.a();
                                break;
                            }
                        case 9:
                            if (b11 != 11) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2965f = ibVar.a();
                                break;
                            }
                        case 10:
                            if (b11 != 11) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2966g = ibVar.a();
                                break;
                            }
                        case 11:
                            if (b11 != 11) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2967h = ibVar.a();
                                break;
                            }
                        case 12:
                            if (b11 != 12) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                gt gtVar = new gt();
                                this.f2954a = gtVar;
                                gtVar.a(ibVar);
                                break;
                            }
                        case 13:
                            if (b11 != 11) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2968i = ibVar.a();
                                break;
                            }
                        case 14:
                            if (b11 != 2) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2958a = ibVar.a();
                                c(true);
                                break;
                            }
                        case 15:
                            if (b11 != 11) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2969j = ibVar.a();
                                break;
                            }
                        case 16:
                            if (b11 != 10) {
                                ie.a(ibVar, b11);
                                break;
                            } else {
                                this.f2961c = ibVar.a();
                                d(true);
                                break;
                            }
                        default:
                            ie.a(ibVar, b11);
                            break;
                    }
                } else if (b11 == 11) {
                    this.f2971l = ibVar.a();
                } else {
                    ie.a(ibVar, b11);
                }
            } else if (b11 == 11) {
                this.f2970k = ibVar.a();
            } else {
                ie.a(ibVar, b11);
            }
            ibVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2751a() {
        if (this.f2956a == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f2960b == null) {
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f2962c == null) {
            throw new ic("Required field 'payload' was not present! Struct: " + toString());
        }
    }
}
