package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import com.xiaomi.push.service.aj;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class gt implements hr<gt, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52111a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f2972a = new ig("PushMetaInfo");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52112b = new hy("", (byte) 10, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52113c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52114d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52115e = new hy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52116f = new hy("", (byte) 8, 6);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52117g = new hy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52118h = new hy("", (byte) 8, 8);

    /* renamed from: i  reason: collision with root package name */
    private static final hy f52119i = new hy("", (byte) 8, 9);

    /* renamed from: j  reason: collision with root package name */
    private static final hy f52120j = new hy("", (byte) 13, 10);

    /* renamed from: k  reason: collision with root package name */
    private static final hy f52121k = new hy("", (byte) 13, 11);

    /* renamed from: l  reason: collision with root package name */
    private static final hy f52122l = new hy("", (byte) 2, 12);

    /* renamed from: m  reason: collision with root package name */
    private static final hy f52123m = new hy("", (byte) 13, 13);

    /* renamed from: a  reason: collision with other field name */
    public int f2973a;

    /* renamed from: a  reason: collision with other field name */
    public long f2974a;

    /* renamed from: a  reason: collision with other field name */
    public String f2975a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f2976a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f2977a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2978a;

    /* renamed from: b  reason: collision with other field name */
    public int f2979b;

    /* renamed from: b  reason: collision with other field name */
    public String f2980b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f2981b;

    /* renamed from: c  reason: collision with other field name */
    public int f2982c;

    /* renamed from: c  reason: collision with other field name */
    public String f2983c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f2984c;

    /* renamed from: d  reason: collision with other field name */
    public String f2985d;

    /* renamed from: e  reason: collision with other field name */
    public String f2986e;

    public gt() {
        this.f2976a = new BitSet(5);
        this.f2978a = false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public gt m2757a() {
        return new gt(this);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2765b() {
        return this.f2976a.get(0);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2767c() {
        return this.f2980b != null;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m2768d() {
        return this.f2983c != null;
    }

    public boolean e() {
        return this.f2985d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gt)) {
            return compareTo((gt) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f2976a.get(1);
    }

    public boolean g() {
        return this.f2986e != null;
    }

    public boolean h() {
        return this.f2976a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f2976a.get(3);
    }

    public boolean j() {
        return this.f2977a != null;
    }

    public boolean k() {
        return this.f2981b != null;
    }

    public boolean l() {
        return this.f2978a;
    }

    public boolean m() {
        return this.f2976a.get(4);
    }

    public boolean n() {
        return this.f2984c != null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PushMetaInfo(");
        sb2.append("id:");
        String str = this.f2975a;
        if (str == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(aj.a(str));
        }
        sb2.append(", ");
        sb2.append("messageTs:");
        sb2.append(this.f2974a);
        if (c()) {
            sb2.append(", ");
            sb2.append("topic:");
            String str2 = this.f2980b;
            if (str2 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str2);
            }
        }
        if (d()) {
            sb2.append(", ");
            sb2.append("title:");
            String str3 = this.f2983c;
            if (str3 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str3);
            }
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("description:");
            String str4 = this.f2985d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("notifyType:");
            sb2.append(this.f2973a);
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("url:");
            String str5 = this.f2986e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("passThrough:");
            sb2.append(this.f2979b);
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("notifyId:");
            sb2.append(this.f2982c);
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("extra:");
            Map<String, String> map = this.f2977a;
            if (map == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(map);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("internal:");
            Map<String, String> map2 = this.f2981b;
            if (map2 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(map2);
            }
        }
        if (m()) {
            sb2.append(", ");
            sb2.append("ignoreRegInfo:");
            sb2.append(this.f2978a);
        }
        if (n()) {
            sb2.append(", ");
            sb2.append("apsProperFields:");
            Map<String, String> map3 = this.f2984c;
            if (map3 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(map3);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2758a() {
        return this.f2975a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m2763b() {
        return this.f2980b;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m2766c() {
        return this.f2983c;
    }

    public String d() {
        return this.f2985d;
    }

    public void e(boolean z11) {
        this.f2976a.set(4, z11);
    }

    public gt a(String str) {
        this.f2975a = str;
        return this;
    }

    public gt b(String str) {
        this.f2980b = str;
        return this;
    }

    public gt c(String str) {
        this.f2983c = str;
        return this;
    }

    public gt d(String str) {
        this.f2985d = str;
        return this;
    }

    public gt(gt gtVar) {
        BitSet bitSet = new BitSet(5);
        this.f2976a = bitSet;
        bitSet.clear();
        this.f2976a.or(gtVar.f2976a);
        if (gtVar.a()) {
            this.f2975a = gtVar.f2975a;
        }
        this.f2974a = gtVar.f2974a;
        if (gtVar.c()) {
            this.f2980b = gtVar.f2980b;
        }
        if (gtVar.d()) {
            this.f2983c = gtVar.f2983c;
        }
        if (gtVar.e()) {
            this.f2985d = gtVar.f2985d;
        }
        this.f2973a = gtVar.f2973a;
        if (gtVar.g()) {
            this.f2986e = gtVar.f2986e;
        }
        this.f2979b = gtVar.f2979b;
        this.f2982c = gtVar.f2982c;
        if (gtVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : gtVar.f2977a.entrySet()) {
                hashMap.put((String) next.getKey(), (String) next.getValue());
            }
            this.f2977a = hashMap;
        }
        if (gtVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry next2 : gtVar.f2981b.entrySet()) {
                hashMap2.put((String) next2.getKey(), (String) next2.getValue());
            }
            this.f2981b = hashMap2;
        }
        this.f2978a = gtVar.f2978a;
        if (gtVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry next3 : gtVar.f2984c.entrySet()) {
                hashMap3.put((String) next3.getKey(), (String) next3.getValue());
            }
            this.f2984c = hashMap3;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2761a() {
        return this.f2975a != null;
    }

    public void b(boolean z11) {
        this.f2976a.set(1, z11);
    }

    public void c(boolean z11) {
        this.f2976a.set(2, z11);
    }

    public void d(boolean z11) {
        this.f2976a.set(3, z11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m2756a() {
        return this.f2974a;
    }

    public int b() {
        return this.f2979b;
    }

    public int c() {
        return this.f2982c;
    }

    public void a(boolean z11) {
        this.f2976a.set(0, z11);
    }

    public gt b(int i11) {
        this.f2979b = i11;
        c(true);
        return this;
    }

    public gt c(int i11) {
        this.f2982c = i11;
        d(true);
        return this;
    }

    public int a() {
        return this.f2973a;
    }

    public gt a(int i11) {
        this.f2973a = i11;
        b(true);
        return this;
    }

    public void b(String str, String str2) {
        if (this.f2981b == null) {
            this.f2981b = new HashMap();
        }
        this.f2981b.put(str, str2);
    }

    public void a(String str, String str2) {
        if (this.f2977a == null) {
            this.f2977a = new HashMap();
        }
        this.f2977a.put(str, str2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m2764b() {
        return this.f2981b;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f2972a);
        if (this.f2975a != null) {
            ibVar.a(f52111a);
            ibVar.a(this.f2975a);
            ibVar.b();
        }
        ibVar.a(f52112b);
        ibVar.a(this.f2974a);
        ibVar.b();
        if (this.f2980b != null && c()) {
            ibVar.a(f52113c);
            ibVar.a(this.f2980b);
            ibVar.b();
        }
        if (this.f2983c != null && d()) {
            ibVar.a(f52114d);
            ibVar.a(this.f2983c);
            ibVar.b();
        }
        if (this.f2985d != null && e()) {
            ibVar.a(f52115e);
            ibVar.a(this.f2985d);
            ibVar.b();
        }
        if (f()) {
            ibVar.a(f52116f);
            ibVar.a(this.f2973a);
            ibVar.b();
        }
        if (this.f2986e != null && g()) {
            ibVar.a(f52117g);
            ibVar.a(this.f2986e);
            ibVar.b();
        }
        if (h()) {
            ibVar.a(f52118h);
            ibVar.a(this.f2979b);
            ibVar.b();
        }
        if (i()) {
            ibVar.a(f52119i);
            ibVar.a(this.f2982c);
            ibVar.b();
        }
        if (this.f2977a != null && j()) {
            ibVar.a(f52120j);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f2977a.size()));
            for (Map.Entry next : this.f2977a.entrySet()) {
                ibVar.a((String) next.getKey());
                ibVar.a((String) next.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (this.f2981b != null && k()) {
            ibVar.a(f52121k);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f2981b.size()));
            for (Map.Entry next2 : this.f2981b.entrySet()) {
                ibVar.a((String) next2.getKey());
                ibVar.a((String) next2.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (m()) {
            ibVar.a(f52122l);
            ibVar.a(this.f2978a);
            ibVar.b();
        }
        if (this.f2984c != null && n()) {
            ibVar.a(f52123m);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f2984c.size()));
            for (Map.Entry next3 : this.f2984c.entrySet()) {
                ibVar.a((String) next3.getKey());
                ibVar.a((String) next3.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m2759a() {
        return this.f2977a;
    }

    public gt a(Map<String, String> map) {
        this.f2977a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2762a(gt gtVar) {
        if (gtVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = gtVar.a();
        if (((a11 || a12) && (!a11 || !a12 || !this.f2975a.equals(gtVar.f2975a))) || this.f2974a != gtVar.f2974a) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = gtVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f2980b.equals(gtVar.f2980b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = gtVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f2983c.equals(gtVar.f2983c))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = gtVar.e();
        if ((e11 || e12) && (!e11 || !e12 || !this.f2985d.equals(gtVar.f2985d))) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = gtVar.f();
        if ((f11 || f12) && (!f11 || !f12 || this.f2973a != gtVar.f2973a)) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = gtVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f2986e.equals(gtVar.f2986e))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = gtVar.h();
        if ((h11 || h12) && (!h11 || !h12 || this.f2979b != gtVar.f2979b)) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = gtVar.i();
        if ((i11 || i12) && (!i11 || !i12 || this.f2982c != gtVar.f2982c)) {
            return false;
        }
        boolean j11 = j();
        boolean j12 = gtVar.j();
        if ((j11 || j12) && (!j11 || !j12 || !this.f2977a.equals(gtVar.f2977a))) {
            return false;
        }
        boolean k11 = k();
        boolean k12 = gtVar.k();
        if ((k11 || k12) && (!k11 || !k12 || !this.f2981b.equals(gtVar.f2981b))) {
            return false;
        }
        boolean m11 = m();
        boolean m12 = gtVar.m();
        if ((m11 || m12) && (!m11 || !m12 || this.f2978a != gtVar.f2978a)) {
            return false;
        }
        boolean n11 = n();
        boolean n12 = gtVar.n();
        if (!n11 && !n12) {
            return true;
        }
        if (!n11 || !n12 || !this.f2984c.equals(gtVar.f2984c)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(gt gtVar) {
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
        if (!getClass().equals(gtVar.getClass())) {
            return getClass().getName().compareTo(gtVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gtVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a24 = hs.a(this.f2975a, gtVar.f2975a)) != 0) {
            return a24;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gtVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a23 = hs.a(this.f2974a, gtVar.f2974a)) != 0) {
            return a23;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gtVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a22 = hs.a(this.f2980b, gtVar.f2980b)) != 0) {
            return a22;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gtVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a21 = hs.a(this.f2983c, gtVar.f2983c)) != 0) {
            return a21;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gtVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a19 = hs.a(this.f2985d, gtVar.f2985d)) != 0) {
            return a19;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gtVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a18 = hs.a(this.f2973a, gtVar.f2973a)) != 0) {
            return a18;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gtVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a17 = hs.a(this.f2986e, gtVar.f2986e)) != 0) {
            return a17;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gtVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a16 = hs.a(this.f2979b, gtVar.f2979b)) != 0) {
            return a16;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gtVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a15 = hs.a(this.f2982c, gtVar.f2982c)) != 0) {
            return a15;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gtVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a14 = hs.a((Map) this.f2977a, (Map) gtVar.f2977a)) != 0) {
            return a14;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gtVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a13 = hs.a((Map) this.f2981b, (Map) gtVar.f2981b)) != 0) {
            return a13;
        }
        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gtVar.m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m() && (a12 = hs.a(this.f2978a, gtVar.f2978a)) != 0) {
            return a12;
        }
        int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gtVar.n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!n() || (a11 = hs.a((Map) this.f2984c, (Map) gtVar.f2984c)) == 0) {
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
                if (b()) {
                    a();
                    return;
                }
                throw new ic("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i11 = 0;
            switch (a11.f3243a) {
                case 1:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2975a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2974a = ibVar.a();
                        a(true);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2980b = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2983c = ibVar.a();
                        break;
                    }
                case 5:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2985d = ibVar.a();
                        break;
                    }
                case 6:
                    if (b11 != 8) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2973a = ibVar.a();
                        b(true);
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2986e = ibVar.a();
                        break;
                    }
                case 8:
                    if (b11 != 8) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2979b = ibVar.a();
                        c(true);
                        break;
                    }
                case 9:
                    if (b11 != 8) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2982c = ibVar.a();
                        d(true);
                        break;
                    }
                case 10:
                    if (b11 != 13) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        ia a12 = ibVar.a();
                        this.f2977a = new HashMap(a12.f3247a * 2);
                        while (i11 < a12.f3247a) {
                            this.f2977a.put(ibVar.a(), ibVar.a());
                            i11++;
                        }
                        ibVar.h();
                        break;
                    }
                case 11:
                    if (b11 != 13) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        ia a13 = ibVar.a();
                        this.f2981b = new HashMap(a13.f3247a * 2);
                        while (i11 < a13.f3247a) {
                            this.f2981b.put(ibVar.a(), ibVar.a());
                            i11++;
                        }
                        ibVar.h();
                        break;
                    }
                case 12:
                    if (b11 != 2) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f2978a = ibVar.a();
                        e(true);
                        break;
                    }
                case 13:
                    if (b11 != 13) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        ia a14 = ibVar.a();
                        this.f2984c = new HashMap(a14.f3247a * 2);
                        while (i11 < a14.f3247a) {
                            this.f2984c.put(ibVar.a(), ibVar.a());
                            i11++;
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

    /* renamed from: a  reason: collision with other method in class */
    public void m2760a() {
        if (this.f2975a == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
