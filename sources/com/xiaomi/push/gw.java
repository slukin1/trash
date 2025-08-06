package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class gw implements hr<gw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52133a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f2997a = new ig("XmPushActionAckMessage");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52134b = new hy("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52135c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52136d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52137e = new hy("", (byte) 10, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52138f = new hy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52139g = new hy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52140h = new hy("", (byte) 12, 8);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f52141i = new hy("", (byte) 11, 9);

    /* renamed from: j  reason: collision with root package name */
    private static final hy f52142j = new hy("", (byte) 11, 10);

    /* renamed from: k  reason: collision with root package name */
    private static final hy f52143k = new hy("", (byte) 2, 11);

    /* renamed from: l  reason: collision with root package name */
    private static final hy f52144l = new hy("", (byte) 11, 12);

    /* renamed from: m  reason: collision with root package name */
    private static final hy f52145m = new hy("", (byte) 11, 13);

    /* renamed from: n  reason: collision with root package name */
    private static final hy f52146n = new hy("", (byte) 11, 14);

    /* renamed from: o  reason: collision with root package name */
    private static final hy f52147o = new hy("", (byte) 6, 15);

    /* renamed from: p  reason: collision with root package name */
    private static final hy f52148p = new hy("", (byte) 6, 16);

    /* renamed from: q  reason: collision with root package name */
    private static final hy f52149q = new hy("", (byte) 11, 20);

    /* renamed from: r  reason: collision with root package name */
    private static final hy f52150r = new hy("", (byte) 11, 21);

    /* renamed from: s  reason: collision with root package name */
    private static final hy f52151s = new hy("", (byte) 8, 22);

    /* renamed from: t  reason: collision with root package name */
    private static final hy f52152t = new hy("", (byte) 13, 23);

    /* renamed from: a  reason: collision with other field name */
    public int f2998a;

    /* renamed from: a  reason: collision with other field name */
    public long f2999a;

    /* renamed from: a  reason: collision with other field name */
    public gv f3000a;

    /* renamed from: a  reason: collision with other field name */
    public hj f3001a;

    /* renamed from: a  reason: collision with other field name */
    public String f3002a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3003a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f3004a;

    /* renamed from: a  reason: collision with other field name */
    public short f3005a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3006a = false;

    /* renamed from: b  reason: collision with other field name */
    public String f3007b;

    /* renamed from: b  reason: collision with other field name */
    public short f3008b;

    /* renamed from: c  reason: collision with other field name */
    public String f3009c;

    /* renamed from: d  reason: collision with other field name */
    public String f3010d;

    /* renamed from: e  reason: collision with other field name */
    public String f3011e;

    /* renamed from: f  reason: collision with other field name */
    public String f3012f;

    /* renamed from: g  reason: collision with other field name */
    public String f3013g;

    /* renamed from: h  reason: collision with other field name */
    public String f3014h;

    /* renamed from: i  reason: collision with other field name */
    public String f3015i;

    /* renamed from: j  reason: collision with other field name */
    public String f3016j;

    /* renamed from: k  reason: collision with other field name */
    public String f3017k;

    /* renamed from: l  reason: collision with other field name */
    public String f3018l;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2771a() {
        return this.f3002a != null;
    }

    public boolean b() {
        return this.f3000a != null;
    }

    public boolean c() {
        return this.f3007b != null;
    }

    public boolean d() {
        return this.f3009c != null;
    }

    public boolean e() {
        return this.f3003a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gw)) {
            return compareTo((gw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3010d != null;
    }

    public boolean g() {
        return this.f3011e != null;
    }

    public boolean h() {
        return this.f3001a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f3012f != null;
    }

    public boolean j() {
        return this.f3013g != null;
    }

    public boolean k() {
        return this.f3003a.get(1);
    }

    public boolean l() {
        return this.f3014h != null;
    }

    public boolean m() {
        return this.f3015i != null;
    }

    public boolean n() {
        return this.f3016j != null;
    }

    public boolean o() {
        return this.f3003a.get(2);
    }

    public boolean p() {
        return this.f3003a.get(3);
    }

    public boolean q() {
        return this.f3017k != null;
    }

    public boolean r() {
        return this.f3018l != null;
    }

    public boolean s() {
        return this.f3003a.get(4);
    }

    public boolean t() {
        return this.f3004a != null;
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionAckMessage(");
        boolean z12 = false;
        if (a()) {
            sb2.append("debug:");
            String str = this.f3002a;
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
            gv gvVar = this.f3000a;
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
        String str2 = this.f3007b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f3009c;
        if (str3 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("messageTs:");
        sb2.append(this.f2999a);
        if (f()) {
            sb2.append(", ");
            sb2.append("topic:");
            String str4 = this.f3010d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("aliasName:");
            String str5 = this.f3011e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("request:");
            hj hjVar = this.f3001a;
            if (hjVar == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(hjVar);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str6 = this.f3012f;
            if (str6 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str6);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f3013g;
            if (str7 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str7);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("isOnline:");
            sb2.append(this.f3006a);
        }
        if (l()) {
            sb2.append(", ");
            sb2.append("regId:");
            String str8 = this.f3014h;
            if (str8 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str8);
            }
        }
        if (m()) {
            sb2.append(", ");
            sb2.append("callbackUrl:");
            String str9 = this.f3015i;
            if (str9 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str9);
            }
        }
        if (n()) {
            sb2.append(", ");
            sb2.append("userAccount:");
            String str10 = this.f3016j;
            if (str10 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str10);
            }
        }
        if (o()) {
            sb2.append(", ");
            sb2.append("deviceStatus:");
            sb2.append(this.f3005a);
        }
        if (p()) {
            sb2.append(", ");
            sb2.append("geoMsgStatus:");
            sb2.append(this.f3008b);
        }
        if (q()) {
            sb2.append(", ");
            sb2.append("imeiMd5:");
            String str11 = this.f3017k;
            if (str11 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str11);
            }
        }
        if (r()) {
            sb2.append(", ");
            sb2.append("deviceId:");
            String str12 = this.f3018l;
            if (str12 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str12);
            }
        }
        if (s()) {
            sb2.append(", ");
            sb2.append("passThrough:");
            sb2.append(this.f2998a);
        }
        if (t()) {
            sb2.append(", ");
            sb2.append("extra:");
            Map<String, String> map = this.f3004a;
            if (map == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(map);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public gw a(String str) {
        this.f3007b = str;
        return this;
    }

    public gw b(String str) {
        this.f3009c = str;
        return this;
    }

    public gw c(String str) {
        this.f3010d = str;
        return this;
    }

    public gw d(String str) {
        this.f3011e = str;
        return this;
    }

    public void e(boolean z11) {
        this.f3003a.set(4, z11);
    }

    public gw a(long j11) {
        this.f2999a = j11;
        a(true);
        return this;
    }

    public void b(boolean z11) {
        this.f3003a.set(1, z11);
    }

    public void c(boolean z11) {
        this.f3003a.set(2, z11);
    }

    public void d(boolean z11) {
        this.f3003a.set(3, z11);
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f2997a);
        if (this.f3002a != null && a()) {
            ibVar.a(f52133a);
            ibVar.a(this.f3002a);
            ibVar.b();
        }
        if (this.f3000a != null && b()) {
            ibVar.a(f52134b);
            this.f3000a.b(ibVar);
            ibVar.b();
        }
        if (this.f3007b != null) {
            ibVar.a(f52135c);
            ibVar.a(this.f3007b);
            ibVar.b();
        }
        if (this.f3009c != null) {
            ibVar.a(f52136d);
            ibVar.a(this.f3009c);
            ibVar.b();
        }
        ibVar.a(f52137e);
        ibVar.a(this.f2999a);
        ibVar.b();
        if (this.f3010d != null && f()) {
            ibVar.a(f52138f);
            ibVar.a(this.f3010d);
            ibVar.b();
        }
        if (this.f3011e != null && g()) {
            ibVar.a(f52139g);
            ibVar.a(this.f3011e);
            ibVar.b();
        }
        if (this.f3001a != null && h()) {
            ibVar.a(f52140h);
            this.f3001a.b(ibVar);
            ibVar.b();
        }
        if (this.f3012f != null && i()) {
            ibVar.a(f52141i);
            ibVar.a(this.f3012f);
            ibVar.b();
        }
        if (this.f3013g != null && j()) {
            ibVar.a(f52142j);
            ibVar.a(this.f3013g);
            ibVar.b();
        }
        if (k()) {
            ibVar.a(f52143k);
            ibVar.a(this.f3006a);
            ibVar.b();
        }
        if (this.f3014h != null && l()) {
            ibVar.a(f52144l);
            ibVar.a(this.f3014h);
            ibVar.b();
        }
        if (this.f3015i != null && m()) {
            ibVar.a(f52145m);
            ibVar.a(this.f3015i);
            ibVar.b();
        }
        if (this.f3016j != null && n()) {
            ibVar.a(f52146n);
            ibVar.a(this.f3016j);
            ibVar.b();
        }
        if (o()) {
            ibVar.a(f52147o);
            ibVar.a(this.f3005a);
            ibVar.b();
        }
        if (p()) {
            ibVar.a(f52148p);
            ibVar.a(this.f3008b);
            ibVar.b();
        }
        if (this.f3017k != null && q()) {
            ibVar.a(f52149q);
            ibVar.a(this.f3017k);
            ibVar.b();
        }
        if (this.f3018l != null && r()) {
            ibVar.a(f52150r);
            ibVar.a(this.f3018l);
            ibVar.b();
        }
        if (s()) {
            ibVar.a(f52151s);
            ibVar.a(this.f2998a);
            ibVar.b();
        }
        if (this.f3004a != null && t()) {
            ibVar.a(f52152t);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f3004a.size()));
            for (Map.Entry next : this.f3004a.entrySet()) {
                ibVar.a((String) next.getKey());
                ibVar.a((String) next.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    public void a(boolean z11) {
        this.f3003a.set(0, z11);
    }

    public gw a(short s11) {
        this.f3005a = s11;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2772a(gw gwVar) {
        if (gwVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = gwVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3002a.equals(gwVar.f3002a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = gwVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3000a.compareTo(gwVar.f3000a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = gwVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3007b.equals(gwVar.f3007b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = gwVar.d();
        if (((d11 || d12) && (!d11 || !d12 || !this.f3009c.equals(gwVar.f3009c))) || this.f2999a != gwVar.f2999a) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = gwVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f3010d.equals(gwVar.f3010d))) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = gwVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3011e.equals(gwVar.f3011e))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = gwVar.h();
        if ((h11 || h12) && (!h11 || !h12 || !this.f3001a.compareTo(gwVar.f3001a))) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = gwVar.i();
        if ((i11 || i12) && (!i11 || !i12 || !this.f3012f.equals(gwVar.f3012f))) {
            return false;
        }
        boolean j11 = j();
        boolean j12 = gwVar.j();
        if ((j11 || j12) && (!j11 || !j12 || !this.f3013g.equals(gwVar.f3013g))) {
            return false;
        }
        boolean k11 = k();
        boolean k12 = gwVar.k();
        if ((k11 || k12) && (!k11 || !k12 || this.f3006a != gwVar.f3006a)) {
            return false;
        }
        boolean l11 = l();
        boolean l12 = gwVar.l();
        if ((l11 || l12) && (!l11 || !l12 || !this.f3014h.equals(gwVar.f3014h))) {
            return false;
        }
        boolean m11 = m();
        boolean m12 = gwVar.m();
        if ((m11 || m12) && (!m11 || !m12 || !this.f3015i.equals(gwVar.f3015i))) {
            return false;
        }
        boolean n11 = n();
        boolean n12 = gwVar.n();
        if ((n11 || n12) && (!n11 || !n12 || !this.f3016j.equals(gwVar.f3016j))) {
            return false;
        }
        boolean o11 = o();
        boolean o12 = gwVar.o();
        if ((o11 || o12) && (!o11 || !o12 || this.f3005a != gwVar.f3005a)) {
            return false;
        }
        boolean p11 = p();
        boolean p12 = gwVar.p();
        if ((p11 || p12) && (!p11 || !p12 || this.f3008b != gwVar.f3008b)) {
            return false;
        }
        boolean q11 = q();
        boolean q12 = gwVar.q();
        if ((q11 || q12) && (!q11 || !q12 || !this.f3017k.equals(gwVar.f3017k))) {
            return false;
        }
        boolean r11 = r();
        boolean r12 = gwVar.r();
        if ((r11 || r12) && (!r11 || !r12 || !this.f3018l.equals(gwVar.f3018l))) {
            return false;
        }
        boolean s11 = s();
        boolean s12 = gwVar.s();
        if ((s11 || s12) && (!s11 || !s12 || this.f2998a != gwVar.f2998a)) {
            return false;
        }
        boolean t11 = t();
        boolean t12 = gwVar.t();
        if (!t11 && !t12) {
            return true;
        }
        if (!t11 || !t12 || !this.f3004a.equals(gwVar.f3004a)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(gw gwVar) {
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
        int a31;
        int a32;
        if (!getClass().equals(gwVar.getClass())) {
            return getClass().getName().compareTo(gwVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gwVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a32 = hs.a(this.f3002a, gwVar.f3002a)) != 0) {
            return a32;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gwVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a31 = hs.a((Comparable) this.f3000a, (Comparable) gwVar.f3000a)) != 0) {
            return a31;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gwVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a29 = hs.a(this.f3007b, gwVar.f3007b)) != 0) {
            return a29;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gwVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a28 = hs.a(this.f3009c, gwVar.f3009c)) != 0) {
            return a28;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gwVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a27 = hs.a(this.f2999a, gwVar.f2999a)) != 0) {
            return a27;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gwVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a26 = hs.a(this.f3010d, gwVar.f3010d)) != 0) {
            return a26;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gwVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a25 = hs.a(this.f3011e, gwVar.f3011e)) != 0) {
            return a25;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gwVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a24 = hs.a((Comparable) this.f3001a, (Comparable) gwVar.f3001a)) != 0) {
            return a24;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gwVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a23 = hs.a(this.f3012f, gwVar.f3012f)) != 0) {
            return a23;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gwVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a22 = hs.a(this.f3013g, gwVar.f3013g)) != 0) {
            return a22;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gwVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a21 = hs.a(this.f3006a, gwVar.f3006a)) != 0) {
            return a21;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(gwVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a19 = hs.a(this.f3014h, gwVar.f3014h)) != 0) {
            return a19;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gwVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a18 = hs.a(this.f3015i, gwVar.f3015i)) != 0) {
            return a18;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gwVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a17 = hs.a(this.f3016j, gwVar.f3016j)) != 0) {
            return a17;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(gwVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a16 = hs.a(this.f3005a, gwVar.f3005a)) != 0) {
            return a16;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(gwVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a15 = hs.a(this.f3008b, gwVar.f3008b)) != 0) {
            return a15;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(gwVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a14 = hs.a(this.f3017k, gwVar.f3017k)) != 0) {
            return a14;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(gwVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a13 = hs.a(this.f3018l, gwVar.f3018l)) != 0) {
            return a13;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(gwVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a12 = hs.a(this.f2998a, gwVar.f2998a)) != 0) {
            return a12;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(gwVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!t() || (a11 = hs.a((Map) this.f3004a, (Map) gwVar.f3004a)) == 0) {
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
                throw new ic("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (a11.f3243a) {
                case 1:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3002a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3000a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3007b = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3009c = ibVar.a();
                        break;
                    }
                case 5:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2999a = ibVar.a();
                        a(true);
                        break;
                    }
                case 6:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3010d = ibVar.a();
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3011e = ibVar.a();
                        break;
                    }
                case 8:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        hj hjVar = new hj();
                        this.f3001a = hjVar;
                        hjVar.a(ibVar);
                        break;
                    }
                case 9:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3012f = ibVar.a();
                        break;
                    }
                case 10:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3013g = ibVar.a();
                        break;
                    }
                case 11:
                    if (b11 != 2) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3006a = ibVar.a();
                        b(true);
                        break;
                    }
                case 12:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3014h = ibVar.a();
                        break;
                    }
                case 13:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3015i = ibVar.a();
                        break;
                    }
                case 14:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3016j = ibVar.a();
                        break;
                    }
                case 15:
                    if (b11 != 6) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3005a = ibVar.a();
                        c(true);
                        break;
                    }
                case 16:
                    if (b11 != 6) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3008b = ibVar.a();
                        d(true);
                        break;
                    }
                case 20:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3017k = ibVar.a();
                        break;
                    }
                case 21:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3018l = ibVar.a();
                        break;
                    }
                case 22:
                    if (b11 != 8) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2998a = ibVar.a();
                        e(true);
                        break;
                    }
                case 23:
                    if (b11 != 13) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        ia a12 = ibVar.a();
                        this.f3004a = new HashMap(a12.f3247a * 2);
                        for (int i11 = 0; i11 < a12.f3247a; i11++) {
                            this.f3004a.put(ibVar.a(), ibVar.a());
                        }
                        ibVar.h();
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
        if (this.f3007b == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3009c == null) {
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
