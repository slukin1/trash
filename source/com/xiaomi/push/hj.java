package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class hj implements hr<hj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52265a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3154a = new ig("XmPushActionSendMessage");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52266b = new hy("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52267c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52268d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52269e = new hy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52270f = new hy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52271g = new hy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52272h = new hy("", (byte) 12, 8);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f52273i = new hy("", (byte) 2, 9);

    /* renamed from: j  reason: collision with root package name */
    private static final hy f52274j = new hy("", (byte) 13, 10);

    /* renamed from: k  reason: collision with root package name */
    private static final hy f52275k = new hy("", (byte) 11, 11);

    /* renamed from: l  reason: collision with root package name */
    private static final hy f52276l = new hy("", (byte) 11, 12);

    /* renamed from: a  reason: collision with other field name */
    public gs f3155a;

    /* renamed from: a  reason: collision with other field name */
    public gv f3156a;

    /* renamed from: a  reason: collision with other field name */
    public String f3157a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3158a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f3159a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3160a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f3161b;

    /* renamed from: c  reason: collision with other field name */
    public String f3162c;

    /* renamed from: d  reason: collision with other field name */
    public String f3163d;

    /* renamed from: e  reason: collision with other field name */
    public String f3164e;

    /* renamed from: f  reason: collision with other field name */
    public String f3165f;

    /* renamed from: g  reason: collision with other field name */
    public String f3166g;

    /* renamed from: h  reason: collision with other field name */
    public String f3167h;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2833a() {
        return this.f3157a != null;
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2835b() {
        return this.f3156a != null;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2836c() {
        return this.f3161b != null;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m2837d() {
        return this.f3162c != null;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m2838e() {
        return this.f3163d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return compareTo((hj) obj);
        }
        return false;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m2839f() {
        return this.f3164e != null;
    }

    public boolean g() {
        return this.f3165f != null;
    }

    public boolean h() {
        return this.f3155a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f3158a.get(0);
    }

    public boolean j() {
        return this.f3159a != null;
    }

    public boolean k() {
        return this.f3166g != null;
    }

    public boolean l() {
        return this.f3167h != null;
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionSendMessage(");
        boolean z12 = false;
        if (a()) {
            sb2.append("debug:");
            String str = this.f3157a;
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
            gv gvVar = this.f3156a;
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
        String str2 = this.f3161b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f3162c;
        if (str3 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str3);
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str4 = this.f3163d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("topic:");
            String str5 = this.f3164e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("aliasName:");
            String str6 = this.f3165f;
            if (str6 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str6);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("message:");
            gs gsVar = this.f3155a;
            if (gsVar == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(gsVar);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("needAck:");
            sb2.append(this.f3160a);
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("params:");
            Map<String, String> map = this.f3159a;
            if (map == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(map);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f3166g;
            if (str7 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str7);
            }
        }
        if (l()) {
            sb2.append(", ");
            sb2.append("userAccount:");
            String str8 = this.f3167h;
            if (str8 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str8);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2831a() {
        return this.f3161b;
    }

    public String b() {
        return this.f3162c;
    }

    public String c() {
        return this.f3164e;
    }

    public String d() {
        return this.f3165f;
    }

    public String e() {
        return this.f3166g;
    }

    public String f() {
        return this.f3167h;
    }

    public gs a() {
        return this.f3155a;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3154a);
        if (this.f3157a != null && a()) {
            ibVar.a(f52265a);
            ibVar.a(this.f3157a);
            ibVar.b();
        }
        if (this.f3156a != null && b()) {
            ibVar.a(f52266b);
            this.f3156a.b(ibVar);
            ibVar.b();
        }
        if (this.f3161b != null) {
            ibVar.a(f52267c);
            ibVar.a(this.f3161b);
            ibVar.b();
        }
        if (this.f3162c != null) {
            ibVar.a(f52268d);
            ibVar.a(this.f3162c);
            ibVar.b();
        }
        if (this.f3163d != null && e()) {
            ibVar.a(f52269e);
            ibVar.a(this.f3163d);
            ibVar.b();
        }
        if (this.f3164e != null && f()) {
            ibVar.a(f52270f);
            ibVar.a(this.f3164e);
            ibVar.b();
        }
        if (this.f3165f != null && g()) {
            ibVar.a(f52271g);
            ibVar.a(this.f3165f);
            ibVar.b();
        }
        if (this.f3155a != null && h()) {
            ibVar.a(f52272h);
            this.f3155a.b(ibVar);
            ibVar.b();
        }
        if (i()) {
            ibVar.a(f52273i);
            ibVar.a(this.f3160a);
            ibVar.b();
        }
        if (this.f3159a != null && j()) {
            ibVar.a(f52274j);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f3159a.size()));
            for (Map.Entry next : this.f3159a.entrySet()) {
                ibVar.a((String) next.getKey());
                ibVar.a((String) next.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (this.f3166g != null && k()) {
            ibVar.a(f52275k);
            ibVar.a(this.f3166g);
            ibVar.b();
        }
        if (this.f3167h != null && l()) {
            ibVar.a(f52276l);
            ibVar.a(this.f3167h);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    public void a(boolean z11) {
        this.f3158a.set(0, z11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2834a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = hjVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3157a.equals(hjVar.f3157a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = hjVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3156a.compareTo(hjVar.f3156a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = hjVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3161b.equals(hjVar.f3161b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = hjVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f3162c.equals(hjVar.f3162c))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = hjVar.e();
        if ((e11 || e12) && (!e11 || !e12 || !this.f3163d.equals(hjVar.f3163d))) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = hjVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f3164e.equals(hjVar.f3164e))) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = hjVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3165f.equals(hjVar.f3165f))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = hjVar.h();
        if ((h11 || h12) && (!h11 || !h12 || !this.f3155a.compareTo(hjVar.f3155a))) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = hjVar.i();
        if ((i11 || i12) && (!i11 || !i12 || this.f3160a != hjVar.f3160a)) {
            return false;
        }
        boolean j11 = j();
        boolean j12 = hjVar.j();
        if ((j11 || j12) && (!j11 || !j12 || !this.f3159a.equals(hjVar.f3159a))) {
            return false;
        }
        boolean k11 = k();
        boolean k12 = hjVar.k();
        if ((k11 || k12) && (!k11 || !k12 || !this.f3166g.equals(hjVar.f3166g))) {
            return false;
        }
        boolean l11 = l();
        boolean l12 = hjVar.l();
        if (!l11 && !l12) {
            return true;
        }
        if (!l11 || !l12 || !this.f3167h.equals(hjVar.f3167h)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(hj hjVar) {
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
        if (!getClass().equals(hjVar.getClass())) {
            return getClass().getName().compareTo(hjVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hjVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a23 = hs.a(this.f3157a, hjVar.f3157a)) != 0) {
            return a23;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hjVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a22 = hs.a((Comparable) this.f3156a, (Comparable) hjVar.f3156a)) != 0) {
            return a22;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hjVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a21 = hs.a(this.f3161b, hjVar.f3161b)) != 0) {
            return a21;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hjVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a19 = hs.a(this.f3162c, hjVar.f3162c)) != 0) {
            return a19;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hjVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a18 = hs.a(this.f3163d, hjVar.f3163d)) != 0) {
            return a18;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hjVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a17 = hs.a(this.f3164e, hjVar.f3164e)) != 0) {
            return a17;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hjVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a16 = hs.a(this.f3165f, hjVar.f3165f)) != 0) {
            return a16;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hjVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a15 = hs.a((Comparable) this.f3155a, (Comparable) hjVar.f3155a)) != 0) {
            return a15;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hjVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a14 = hs.a(this.f3160a, hjVar.f3160a)) != 0) {
            return a14;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hjVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a13 = hs.a((Map) this.f3159a, (Map) hjVar.f3159a)) != 0) {
            return a13;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hjVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a12 = hs.a(this.f3166g, hjVar.f3166g)) != 0) {
            return a12;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hjVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (a11 = hs.a(this.f3167h, hjVar.f3167h)) == 0) {
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
                        this.f3157a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3156a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3161b = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3162c = ibVar.a();
                        break;
                    }
                case 5:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3163d = ibVar.a();
                        break;
                    }
                case 6:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3164e = ibVar.a();
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3165f = ibVar.a();
                        break;
                    }
                case 8:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gs gsVar = new gs();
                        this.f3155a = gsVar;
                        gsVar.a(ibVar);
                        break;
                    }
                case 9:
                    if (b11 != 2) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3160a = ibVar.a();
                        a(true);
                        break;
                    }
                case 10:
                    if (b11 != 13) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        ia a12 = ibVar.a();
                        this.f3159a = new HashMap(a12.f3247a * 2);
                        for (int i11 = 0; i11 < a12.f3247a; i11++) {
                            this.f3159a.put(ibVar.a(), ibVar.a());
                        }
                        ibVar.h();
                        break;
                    }
                case 11:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3166g = ibVar.a();
                        break;
                    }
                case 12:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3167h = ibVar.a();
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
    public void m2832a() {
        if (this.f3161b == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3162c == null) {
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
