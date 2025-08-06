package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;

public class hm implements hr<hm, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52294a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3188a = new ig("XmPushActionUnRegistration");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52295b = new hy("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52296c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52297d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52298e = new hy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52299f = new hy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52300g = new hy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52301h = new hy("", (byte) 11, 8);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f52302i = new hy("", (byte) 11, 9);

    /* renamed from: j  reason: collision with root package name */
    private static final hy f52303j = new hy("", (byte) 11, 10);

    /* renamed from: k  reason: collision with root package name */
    private static final hy f52304k = new hy("", (byte) 2, 11);

    /* renamed from: l  reason: collision with root package name */
    private static final hy f52305l = new hy("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    public long f3189a;

    /* renamed from: a  reason: collision with other field name */
    public gv f3190a;

    /* renamed from: a  reason: collision with other field name */
    public String f3191a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3192a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f3193a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f3194b;

    /* renamed from: c  reason: collision with other field name */
    public String f3195c;

    /* renamed from: d  reason: collision with other field name */
    public String f3196d;

    /* renamed from: e  reason: collision with other field name */
    public String f3197e;

    /* renamed from: f  reason: collision with other field name */
    public String f3198f;

    /* renamed from: g  reason: collision with other field name */
    public String f3199g;

    /* renamed from: h  reason: collision with other field name */
    public String f3200h;

    /* renamed from: i  reason: collision with other field name */
    public String f3201i;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2847a() {
        return this.f3191a != null;
    }

    public boolean b() {
        return this.f3190a != null;
    }

    public boolean c() {
        return this.f3194b != null;
    }

    public boolean d() {
        return this.f3195c != null;
    }

    public boolean e() {
        return this.f3196d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hm)) {
            return compareTo((hm) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3197e != null;
    }

    public boolean g() {
        return this.f3198f != null;
    }

    public boolean h() {
        return this.f3199g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f3200h != null;
    }

    public boolean j() {
        return this.f3201i != null;
    }

    public boolean k() {
        return this.f3192a.get(0);
    }

    public boolean l() {
        return this.f3192a.get(1);
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionUnRegistration(");
        boolean z12 = false;
        if (a()) {
            sb2.append("debug:");
            String str = this.f3191a;
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
            gv gvVar = this.f3190a;
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
        String str2 = this.f3194b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f3195c;
        if (str3 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str3);
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("regId:");
            String str4 = this.f3196d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("appVersion:");
            String str5 = this.f3197e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str6 = this.f3198f;
            if (str6 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str6);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("token:");
            String str7 = this.f3199g;
            if (str7 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str7);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("deviceId:");
            String str8 = this.f3200h;
            if (str8 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str8);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("aliasName:");
            String str9 = this.f3201i;
            if (str9 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str9);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("needAck:");
            sb2.append(this.f3193a);
        }
        if (l()) {
            sb2.append(", ");
            sb2.append("createdTs:");
            sb2.append(this.f3189a);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public hm a(String str) {
        this.f3194b = str;
        return this;
    }

    public hm b(String str) {
        this.f3195c = str;
        return this;
    }

    public hm c(String str) {
        this.f3196d = str;
        return this;
    }

    public hm d(String str) {
        this.f3198f = str;
        return this;
    }

    public hm e(String str) {
        this.f3199g = str;
        return this;
    }

    public void a(boolean z11) {
        this.f3192a.set(0, z11);
    }

    public void b(boolean z11) {
        this.f3192a.set(1, z11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2848a(hm hmVar) {
        if (hmVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = hmVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3191a.equals(hmVar.f3191a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = hmVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3190a.compareTo(hmVar.f3190a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = hmVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3194b.equals(hmVar.f3194b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = hmVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f3195c.equals(hmVar.f3195c))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = hmVar.e();
        if ((e11 || e12) && (!e11 || !e12 || !this.f3196d.equals(hmVar.f3196d))) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = hmVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f3197e.equals(hmVar.f3197e))) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = hmVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3198f.equals(hmVar.f3198f))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = hmVar.h();
        if ((h11 || h12) && (!h11 || !h12 || !this.f3199g.equals(hmVar.f3199g))) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = hmVar.i();
        if ((i11 || i12) && (!i11 || !i12 || !this.f3200h.equals(hmVar.f3200h))) {
            return false;
        }
        boolean j11 = j();
        boolean j12 = hmVar.j();
        if ((j11 || j12) && (!j11 || !j12 || !this.f3201i.equals(hmVar.f3201i))) {
            return false;
        }
        boolean k11 = k();
        boolean k12 = hmVar.k();
        if ((k11 || k12) && (!k11 || !k12 || this.f3193a != hmVar.f3193a)) {
            return false;
        }
        boolean l11 = l();
        boolean l12 = hmVar.l();
        if (!l11 && !l12) {
            return true;
        }
        if (!l11 || !l12 || this.f3189a != hmVar.f3189a) {
            return false;
        }
        return true;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3188a);
        if (this.f3191a != null && a()) {
            ibVar.a(f52294a);
            ibVar.a(this.f3191a);
            ibVar.b();
        }
        if (this.f3190a != null && b()) {
            ibVar.a(f52295b);
            this.f3190a.b(ibVar);
            ibVar.b();
        }
        if (this.f3194b != null) {
            ibVar.a(f52296c);
            ibVar.a(this.f3194b);
            ibVar.b();
        }
        if (this.f3195c != null) {
            ibVar.a(f52297d);
            ibVar.a(this.f3195c);
            ibVar.b();
        }
        if (this.f3196d != null && e()) {
            ibVar.a(f52298e);
            ibVar.a(this.f3196d);
            ibVar.b();
        }
        if (this.f3197e != null && f()) {
            ibVar.a(f52299f);
            ibVar.a(this.f3197e);
            ibVar.b();
        }
        if (this.f3198f != null && g()) {
            ibVar.a(f52300g);
            ibVar.a(this.f3198f);
            ibVar.b();
        }
        if (this.f3199g != null && h()) {
            ibVar.a(f52301h);
            ibVar.a(this.f3199g);
            ibVar.b();
        }
        if (this.f3200h != null && i()) {
            ibVar.a(f52302i);
            ibVar.a(this.f3200h);
            ibVar.b();
        }
        if (this.f3201i != null && j()) {
            ibVar.a(f52303j);
            ibVar.a(this.f3201i);
            ibVar.b();
        }
        if (k()) {
            ibVar.a(f52304k);
            ibVar.a(this.f3193a);
            ibVar.b();
        }
        if (l()) {
            ibVar.a(f52305l);
            ibVar.a(this.f3189a);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a */
    public int compareTo(hm hmVar) {
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
        if (!getClass().equals(hmVar.getClass())) {
            return getClass().getName().compareTo(hmVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hmVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a23 = hs.a(this.f3191a, hmVar.f3191a)) != 0) {
            return a23;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hmVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a22 = hs.a((Comparable) this.f3190a, (Comparable) hmVar.f3190a)) != 0) {
            return a22;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hmVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a21 = hs.a(this.f3194b, hmVar.f3194b)) != 0) {
            return a21;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hmVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a19 = hs.a(this.f3195c, hmVar.f3195c)) != 0) {
            return a19;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hmVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a18 = hs.a(this.f3196d, hmVar.f3196d)) != 0) {
            return a18;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hmVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a17 = hs.a(this.f3197e, hmVar.f3197e)) != 0) {
            return a17;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hmVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a16 = hs.a(this.f3198f, hmVar.f3198f)) != 0) {
            return a16;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hmVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a15 = hs.a(this.f3199g, hmVar.f3199g)) != 0) {
            return a15;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hmVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a14 = hs.a(this.f3200h, hmVar.f3200h)) != 0) {
            return a14;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hmVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a13 = hs.a(this.f3201i, hmVar.f3201i)) != 0) {
            return a13;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hmVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a12 = hs.a(this.f3193a, hmVar.f3193a)) != 0) {
            return a12;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hmVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (a11 = hs.a(this.f3189a, hmVar.f3189a)) == 0) {
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
                        this.f3191a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3190a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3194b = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3195c = ibVar.a();
                        break;
                    }
                case 5:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3196d = ibVar.a();
                        break;
                    }
                case 6:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3197e = ibVar.a();
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3198f = ibVar.a();
                        break;
                    }
                case 8:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3199g = ibVar.a();
                        break;
                    }
                case 9:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3200h = ibVar.a();
                        break;
                    }
                case 10:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3201i = ibVar.a();
                        break;
                    }
                case 11:
                    if (b11 != 2) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3193a = ibVar.a();
                        a(true);
                        break;
                    }
                case 12:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3189a = ibVar.a();
                        b(true);
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
        if (this.f3194b == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3195c == null) {
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
