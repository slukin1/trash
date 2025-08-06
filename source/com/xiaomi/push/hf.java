package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class hf implements hr<hf, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52197a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3075a = new ig("XmPushActionNotification");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52198b = new hy("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52199c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52200d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52201e = new hy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52202f = new hy("", (byte) 2, 6);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52203g = new hy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52204h = new hy("", (byte) 13, 8);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f52205i = new hy("", (byte) 11, 9);

    /* renamed from: j  reason: collision with root package name */
    private static final hy f52206j = new hy("", (byte) 11, 10);

    /* renamed from: k  reason: collision with root package name */
    private static final hy f52207k = new hy("", (byte) 11, 12);

    /* renamed from: l  reason: collision with root package name */
    private static final hy f52208l = new hy("", (byte) 11, 13);

    /* renamed from: m  reason: collision with root package name */
    private static final hy f52209m = new hy("", (byte) 11, 14);

    /* renamed from: n  reason: collision with root package name */
    private static final hy f52210n = new hy("", (byte) 10, 15);

    /* renamed from: o  reason: collision with root package name */
    private static final hy f52211o = new hy("", (byte) 2, 20);

    /* renamed from: a  reason: collision with other field name */
    public long f3076a;

    /* renamed from: a  reason: collision with other field name */
    public gv f3077a;

    /* renamed from: a  reason: collision with other field name */
    public String f3078a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f3079a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3080a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f3081a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3082a;

    /* renamed from: b  reason: collision with other field name */
    public String f3083b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f3084b;

    /* renamed from: c  reason: collision with other field name */
    public String f3085c;

    /* renamed from: d  reason: collision with other field name */
    public String f3086d;

    /* renamed from: e  reason: collision with other field name */
    public String f3087e;

    /* renamed from: f  reason: collision with other field name */
    public String f3088f;

    /* renamed from: g  reason: collision with other field name */
    public String f3089g;

    /* renamed from: h  reason: collision with other field name */
    public String f3090h;

    /* renamed from: i  reason: collision with other field name */
    public String f3091i;

    public hf() {
        this.f3080a = new BitSet(3);
        this.f3082a = true;
        this.f3084b = false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2811a() {
        return this.f3078a != null;
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2814b() {
        return this.f3077a != null;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2815c() {
        return this.f3083b != null;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m2816d() {
        return this.f3085c != null;
    }

    public boolean e() {
        return this.f3086d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hf)) {
            return compareTo((hf) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3080a.get(0);
    }

    public boolean g() {
        return this.f3087e != null;
    }

    public boolean h() {
        return this.f3081a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f3088f != null;
    }

    public boolean j() {
        return this.f3089g != null;
    }

    public boolean k() {
        return this.f3090h != null;
    }

    public boolean l() {
        return this.f3091i != null;
    }

    public boolean m() {
        return this.f3079a != null;
    }

    public boolean n() {
        return this.f3080a.get(1);
    }

    public boolean o() {
        return this.f3080a.get(2);
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionNotification(");
        boolean z12 = false;
        if (a()) {
            sb2.append("debug:");
            String str = this.f3078a;
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
            gv gvVar = this.f3077a;
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
        String str2 = this.f3083b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        if (d()) {
            sb2.append(", ");
            sb2.append("appId:");
            String str3 = this.f3085c;
            if (str3 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str3);
            }
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("type:");
            String str4 = this.f3086d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        sb2.append(", ");
        sb2.append("requireAck:");
        sb2.append(this.f3082a);
        if (g()) {
            sb2.append(", ");
            sb2.append("payload:");
            String str5 = this.f3087e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("extra:");
            Map<String, String> map = this.f3081a;
            if (map == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(map);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str6 = this.f3088f;
            if (str6 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str6);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f3089g;
            if (str7 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str7);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("regId:");
            String str8 = this.f3090h;
            if (str8 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str8);
            }
        }
        if (l()) {
            sb2.append(", ");
            sb2.append("aliasName:");
            String str9 = this.f3091i;
            if (str9 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str9);
            }
        }
        if (m()) {
            sb2.append(", ");
            sb2.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f3079a;
            if (byteBuffer == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                hs.a(byteBuffer, sb2);
            }
        }
        if (n()) {
            sb2.append(", ");
            sb2.append("createdTs:");
            sb2.append(this.f3076a);
        }
        if (o()) {
            sb2.append(", ");
            sb2.append("alreadyLogClickInXmq:");
            sb2.append(this.f3084b);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public gv a() {
        return this.f3077a;
    }

    public String b() {
        return this.f3085c;
    }

    public String c() {
        return this.f3086d;
    }

    public String d() {
        return this.f3088f;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2807a() {
        return this.f3083b;
    }

    public hf b(String str) {
        this.f3085c = str;
        return this;
    }

    public hf c(String str) {
        this.f3086d = str;
        return this;
    }

    public hf d(String str) {
        this.f3088f = str;
        return this;
    }

    public hf a(String str) {
        this.f3083b = str;
        return this;
    }

    public void b(boolean z11) {
        this.f3080a.set(1, z11);
    }

    public void c(boolean z11) {
        this.f3080a.set(2, z11);
    }

    public hf(String str, boolean z11) {
        this();
        this.f3083b = str;
        this.f3082a = z11;
        a(true);
    }

    public hf a(boolean z11) {
        this.f3082a = z11;
        a(true);
        return this;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3075a);
        if (this.f3078a != null && a()) {
            ibVar.a(f52197a);
            ibVar.a(this.f3078a);
            ibVar.b();
        }
        if (this.f3077a != null && b()) {
            ibVar.a(f52198b);
            this.f3077a.b(ibVar);
            ibVar.b();
        }
        if (this.f3083b != null) {
            ibVar.a(f52199c);
            ibVar.a(this.f3083b);
            ibVar.b();
        }
        if (this.f3085c != null && d()) {
            ibVar.a(f52200d);
            ibVar.a(this.f3085c);
            ibVar.b();
        }
        if (this.f3086d != null && e()) {
            ibVar.a(f52201e);
            ibVar.a(this.f3086d);
            ibVar.b();
        }
        ibVar.a(f52202f);
        ibVar.a(this.f3082a);
        ibVar.b();
        if (this.f3087e != null && g()) {
            ibVar.a(f52203g);
            ibVar.a(this.f3087e);
            ibVar.b();
        }
        if (this.f3081a != null && h()) {
            ibVar.a(f52204h);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f3081a.size()));
            for (Map.Entry next : this.f3081a.entrySet()) {
                ibVar.a((String) next.getKey());
                ibVar.a((String) next.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (this.f3088f != null && i()) {
            ibVar.a(f52205i);
            ibVar.a(this.f3088f);
            ibVar.b();
        }
        if (this.f3089g != null && j()) {
            ibVar.a(f52206j);
            ibVar.a(this.f3089g);
            ibVar.b();
        }
        if (this.f3090h != null && k()) {
            ibVar.a(f52207k);
            ibVar.a(this.f3090h);
            ibVar.b();
        }
        if (this.f3091i != null && l()) {
            ibVar.a(f52208l);
            ibVar.a(this.f3091i);
            ibVar.b();
        }
        if (this.f3079a != null && m()) {
            ibVar.a(f52209m);
            ibVar.a(this.f3079a);
            ibVar.b();
        }
        if (n()) {
            ibVar.a(f52210n);
            ibVar.a(this.f3076a);
            ibVar.b();
        }
        if (o()) {
            ibVar.a(f52211o);
            ibVar.a(this.f3084b);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2810a(boolean z11) {
        this.f3080a.set(0, z11);
    }

    public void a(String str, String str2) {
        if (this.f3081a == null) {
            this.f3081a = new HashMap();
        }
        this.f3081a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m2808a() {
        return this.f3081a;
    }

    public hf a(Map<String, String> map) {
        this.f3081a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m2813a() {
        a(hs.a(this.f3079a));
        return this.f3079a.array();
    }

    public hf a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public hf a(ByteBuffer byteBuffer) {
        this.f3079a = byteBuffer;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2812a(hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = hfVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3078a.equals(hfVar.f3078a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = hfVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3077a.compareTo(hfVar.f3077a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = hfVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3083b.equals(hfVar.f3083b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = hfVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f3085c.equals(hfVar.f3085c))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = hfVar.e();
        if (((e11 || e12) && (!e11 || !e12 || !this.f3086d.equals(hfVar.f3086d))) || this.f3082a != hfVar.f3082a) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = hfVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3087e.equals(hfVar.f3087e))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = hfVar.h();
        if ((h11 || h12) && (!h11 || !h12 || !this.f3081a.equals(hfVar.f3081a))) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = hfVar.i();
        if ((i11 || i12) && (!i11 || !i12 || !this.f3088f.equals(hfVar.f3088f))) {
            return false;
        }
        boolean j11 = j();
        boolean j12 = hfVar.j();
        if ((j11 || j12) && (!j11 || !j12 || !this.f3089g.equals(hfVar.f3089g))) {
            return false;
        }
        boolean k11 = k();
        boolean k12 = hfVar.k();
        if ((k11 || k12) && (!k11 || !k12 || !this.f3090h.equals(hfVar.f3090h))) {
            return false;
        }
        boolean l11 = l();
        boolean l12 = hfVar.l();
        if ((l11 || l12) && (!l11 || !l12 || !this.f3091i.equals(hfVar.f3091i))) {
            return false;
        }
        boolean m11 = m();
        boolean m12 = hfVar.m();
        if ((m11 || m12) && (!m11 || !m12 || !this.f3079a.equals(hfVar.f3079a))) {
            return false;
        }
        boolean n11 = n();
        boolean n12 = hfVar.n();
        if ((n11 || n12) && (!n11 || !n12 || this.f3076a != hfVar.f3076a)) {
            return false;
        }
        boolean o11 = o();
        boolean o12 = hfVar.o();
        if (!o11 && !o12) {
            return true;
        }
        if (!o11 || !o12 || this.f3084b != hfVar.f3084b) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(hf hfVar) {
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
        if (!getClass().equals(hfVar.getClass())) {
            return getClass().getName().compareTo(hfVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hfVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a26 = hs.a(this.f3078a, hfVar.f3078a)) != 0) {
            return a26;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hfVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a25 = hs.a((Comparable) this.f3077a, (Comparable) hfVar.f3077a)) != 0) {
            return a25;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hfVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a24 = hs.a(this.f3083b, hfVar.f3083b)) != 0) {
            return a24;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hfVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a23 = hs.a(this.f3085c, hfVar.f3085c)) != 0) {
            return a23;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hfVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a22 = hs.a(this.f3086d, hfVar.f3086d)) != 0) {
            return a22;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hfVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a21 = hs.a(this.f3082a, hfVar.f3082a)) != 0) {
            return a21;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hfVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a19 = hs.a(this.f3087e, hfVar.f3087e)) != 0) {
            return a19;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hfVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a18 = hs.a((Map) this.f3081a, (Map) hfVar.f3081a)) != 0) {
            return a18;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hfVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a17 = hs.a(this.f3088f, hfVar.f3088f)) != 0) {
            return a17;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hfVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a16 = hs.a(this.f3089g, hfVar.f3089g)) != 0) {
            return a16;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hfVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a15 = hs.a(this.f3090h, hfVar.f3090h)) != 0) {
            return a15;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hfVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a14 = hs.a(this.f3091i, hfVar.f3091i)) != 0) {
            return a14;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hfVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a13 = hs.a((Comparable) this.f3079a, (Comparable) hfVar.f3079a)) != 0) {
            return a13;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hfVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a12 = hs.a(this.f3076a, hfVar.f3076a)) != 0) {
            return a12;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hfVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (!o() || (a11 = hs.a(this.f3084b, hfVar.f3084b)) == 0) {
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
                if (f()) {
                    a();
                    return;
                }
                throw new ic("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (a11.f3243a) {
                case 1:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3078a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3077a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3083b = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3085c = ibVar.a();
                        break;
                    }
                case 5:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3086d = ibVar.a();
                        break;
                    }
                case 6:
                    if (b11 != 2) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3082a = ibVar.a();
                        a(true);
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3087e = ibVar.a();
                        break;
                    }
                case 8:
                    if (b11 != 13) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        ia a12 = ibVar.a();
                        this.f3081a = new HashMap(a12.f3247a * 2);
                        for (int i11 = 0; i11 < a12.f3247a; i11++) {
                            this.f3081a.put(ibVar.a(), ibVar.a());
                        }
                        ibVar.h();
                        break;
                    }
                case 9:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3088f = ibVar.a();
                        break;
                    }
                case 10:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3089g = ibVar.a();
                        break;
                    }
                case 12:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3090h = ibVar.a();
                        break;
                    }
                case 13:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3091i = ibVar.a();
                        break;
                    }
                case 14:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3079a = ibVar.a();
                        break;
                    }
                case 15:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3076a = ibVar.a();
                        b(true);
                        break;
                    }
                case 20:
                    if (b11 != 2) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3084b = ibVar.a();
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
    public void m2809a() {
        if (this.f3083b == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
