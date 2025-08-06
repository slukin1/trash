package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hb implements hr<hb, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52177a = new hy("", (byte) 12, 2);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3049a = new ig("XmPushActionCommandResult");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52178b = new hy("", (byte) 11, 3);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52179c = new hy("", (byte) 11, 4);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52180d = new hy("", (byte) 11, 5);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52181e = new hy("", (byte) 10, 7);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52182f = new hy("", (byte) 11, 8);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52183g = new hy("", (byte) 11, 9);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52184h = new hy("", (byte) 15, 10);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f52185i = new hy("", (byte) 11, 12);

    /* renamed from: j  reason: collision with root package name */
    private static final hy f52186j = new hy("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    public long f3050a;

    /* renamed from: a  reason: collision with other field name */
    public gv f3051a;

    /* renamed from: a  reason: collision with other field name */
    public String f3052a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3053a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public List<String> f3054a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3055a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f3056b;

    /* renamed from: c  reason: collision with other field name */
    public String f3057c;

    /* renamed from: d  reason: collision with other field name */
    public String f3058d;

    /* renamed from: e  reason: collision with other field name */
    public String f3059e;

    /* renamed from: f  reason: collision with other field name */
    public String f3060f;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2788a() {
        return this.f3051a != null;
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2790b() {
        return this.f3052a != null;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2791c() {
        return this.f3056b != null;
    }

    public boolean d() {
        return this.f3057c != null;
    }

    public boolean e() {
        return this.f3053a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hb)) {
            return compareTo((hb) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3058d != null;
    }

    public boolean g() {
        return this.f3059e != null;
    }

    public boolean h() {
        return this.f3054a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f3060f != null;
    }

    public boolean j() {
        return this.f3053a.get(1);
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionCommandResult(");
        if (a()) {
            sb2.append("target:");
            gv gvVar = this.f3051a;
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
        String str = this.f3052a;
        if (str == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str2 = this.f3056b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("cmdName:");
        String str3 = this.f3057c;
        if (str3 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("errorCode:");
        sb2.append(this.f3050a);
        if (f()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str4 = this.f3058d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str5 = this.f3059e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("cmdArgs:");
            List<String> list = this.f3054a;
            if (list == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(list);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("category:");
            String str6 = this.f3060f;
            if (str6 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str6);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("response2Client:");
            sb2.append(this.f3055a);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public String a() {
        return this.f3052a;
    }

    public String b() {
        return this.f3057c;
    }

    public String c() {
        return this.f3060f;
    }

    public void a(boolean z11) {
        this.f3053a.set(0, z11);
    }

    public void b(boolean z11) {
        this.f3053a.set(1, z11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m2786a() {
        return this.f3054a;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3049a);
        if (this.f3051a != null && a()) {
            ibVar.a(f52177a);
            this.f3051a.b(ibVar);
            ibVar.b();
        }
        if (this.f3052a != null) {
            ibVar.a(f52178b);
            ibVar.a(this.f3052a);
            ibVar.b();
        }
        if (this.f3056b != null) {
            ibVar.a(f52179c);
            ibVar.a(this.f3056b);
            ibVar.b();
        }
        if (this.f3057c != null) {
            ibVar.a(f52180d);
            ibVar.a(this.f3057c);
            ibVar.b();
        }
        ibVar.a(f52181e);
        ibVar.a(this.f3050a);
        ibVar.b();
        if (this.f3058d != null && f()) {
            ibVar.a(f52182f);
            ibVar.a(this.f3058d);
            ibVar.b();
        }
        if (this.f3059e != null && g()) {
            ibVar.a(f52183g);
            ibVar.a(this.f3059e);
            ibVar.b();
        }
        if (this.f3054a != null && h()) {
            ibVar.a(f52184h);
            ibVar.a(new hz((byte) 11, this.f3054a.size()));
            for (String a11 : this.f3054a) {
                ibVar.a(a11);
            }
            ibVar.e();
            ibVar.b();
        }
        if (this.f3060f != null && i()) {
            ibVar.a(f52185i);
            ibVar.a(this.f3060f);
            ibVar.b();
        }
        if (j()) {
            ibVar.a(f52186j);
            ibVar.a(this.f3055a);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2789a(hb hbVar) {
        if (hbVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = hbVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3051a.compareTo(hbVar.f3051a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = hbVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3052a.equals(hbVar.f3052a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = hbVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3056b.equals(hbVar.f3056b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = hbVar.d();
        if (((d11 || d12) && (!d11 || !d12 || !this.f3057c.equals(hbVar.f3057c))) || this.f3050a != hbVar.f3050a) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = hbVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f3058d.equals(hbVar.f3058d))) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = hbVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3059e.equals(hbVar.f3059e))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = hbVar.h();
        if ((h11 || h12) && (!h11 || !h12 || !this.f3054a.equals(hbVar.f3054a))) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = hbVar.i();
        if ((i11 || i12) && (!i11 || !i12 || !this.f3060f.equals(hbVar.f3060f))) {
            return false;
        }
        boolean j11 = j();
        boolean j12 = hbVar.j();
        if (!j11 && !j12) {
            return true;
        }
        if (!j11 || !j12 || this.f3055a != hbVar.f3055a) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(hb hbVar) {
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
        if (!getClass().equals(hbVar.getClass())) {
            return getClass().getName().compareTo(hbVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hbVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a21 = hs.a((Comparable) this.f3051a, (Comparable) hbVar.f3051a)) != 0) {
            return a21;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hbVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a19 = hs.a(this.f3052a, hbVar.f3052a)) != 0) {
            return a19;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hbVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a18 = hs.a(this.f3056b, hbVar.f3056b)) != 0) {
            return a18;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hbVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a17 = hs.a(this.f3057c, hbVar.f3057c)) != 0) {
            return a17;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hbVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a16 = hs.a(this.f3050a, hbVar.f3050a)) != 0) {
            return a16;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hbVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a15 = hs.a(this.f3058d, hbVar.f3058d)) != 0) {
            return a15;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hbVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a14 = hs.a(this.f3059e, hbVar.f3059e)) != 0) {
            return a14;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hbVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a13 = hs.a((List) this.f3054a, (List) hbVar.f3054a)) != 0) {
            return a13;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hbVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a12 = hs.a(this.f3060f, hbVar.f3060f)) != 0) {
            return a12;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hbVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a11 = hs.a(this.f3055a, hbVar.f3055a)) == 0) {
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
                throw new ic("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (a11.f3243a) {
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3051a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3052a = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3056b = ibVar.a();
                        break;
                    }
                case 5:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3057c = ibVar.a();
                        break;
                    }
                case 7:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3050a = ibVar.a();
                        a(true);
                        break;
                    }
                case 8:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3058d = ibVar.a();
                        break;
                    }
                case 9:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3059e = ibVar.a();
                        break;
                    }
                case 10:
                    if (b11 != 15) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        hz a12 = ibVar.a();
                        this.f3054a = new ArrayList(a12.f3244a);
                        for (int i11 = 0; i11 < a12.f3244a; i11++) {
                            this.f3054a.add(ibVar.a());
                        }
                        ibVar.i();
                        break;
                    }
                case 12:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3060f = ibVar.a();
                        break;
                    }
                case 13:
                    if (b11 != 2) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3055a = ibVar.a();
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

    /* renamed from: a  reason: collision with other method in class */
    public void m2787a() {
        if (this.f3052a == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3056b == null) {
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f3057c == null) {
            throw new ic("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }
}
