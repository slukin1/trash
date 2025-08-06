package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

public class hc implements hr<hc, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52187a = new hy("", (byte) 8, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3061a = new ig("XmPushActionContainer");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52188b = new hy("", (byte) 2, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52189c = new hy("", (byte) 2, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52190d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52191e = new hy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52192f = new hy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52193g = new hy("", (byte) 12, 7);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52194h = new hy("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    public gg f3062a;

    /* renamed from: a  reason: collision with other field name */
    public gt f3063a;

    /* renamed from: a  reason: collision with other field name */
    public gv f3064a;

    /* renamed from: a  reason: collision with other field name */
    public String f3065a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f3066a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3067a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f3068a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f3069b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f3070b = true;

    public gg a() {
        return this.f3062a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2800b() {
        return this.f3068a;
    }

    public boolean c() {
        return this.f3067a.get(0);
    }

    public boolean d() {
        return this.f3067a.get(1);
    }

    public boolean e() {
        return this.f3066a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hc)) {
            return compareTo((hc) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3065a != null;
    }

    public boolean g() {
        return this.f3069b != null;
    }

    public boolean h() {
        return this.f3064a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f3063a != null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("XmPushActionContainer(");
        sb2.append("action:");
        gg ggVar = this.f3062a;
        if (ggVar == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(ggVar);
        }
        sb2.append(", ");
        sb2.append("encryptAction:");
        sb2.append(this.f3068a);
        sb2.append(", ");
        sb2.append("isRequest:");
        sb2.append(this.f3070b);
        if (f()) {
            sb2.append(", ");
            sb2.append("appid:");
            String str = this.f3065a;
            if (str == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str2 = this.f3069b;
            if (str2 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str2);
            }
        }
        sb2.append(", ");
        sb2.append("target:");
        gv gvVar = this.f3064a;
        if (gvVar == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(gvVar);
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("metaInfo:");
            gt gtVar = this.f3063a;
            if (gtVar == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(gtVar);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public hc a(gg ggVar) {
        this.f3062a = ggVar;
        return this;
    }

    public hc b(boolean z11) {
        this.f3070b = z11;
        b(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2796a() {
        return this.f3062a != null;
    }

    public hc a(boolean z11) {
        this.f3068a = z11;
        a(true);
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m2799b(boolean z11) {
        this.f3067a.set(1, z11);
    }

    public String b() {
        return this.f3069b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2795a(boolean z11) {
        this.f3067a.set(0, z11);
    }

    public hc b(String str) {
        this.f3069b = str;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m2798a() {
        a(hs.a(this.f3066a));
        return this.f3066a.array();
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3061a);
        if (this.f3062a != null) {
            ibVar.a(f52187a);
            ibVar.a(this.f3062a.a());
            ibVar.b();
        }
        ibVar.a(f52188b);
        ibVar.a(this.f3068a);
        ibVar.b();
        ibVar.a(f52189c);
        ibVar.a(this.f3070b);
        ibVar.b();
        if (this.f3066a != null) {
            ibVar.a(f52190d);
            ibVar.a(this.f3066a);
            ibVar.b();
        }
        if (this.f3065a != null && f()) {
            ibVar.a(f52191e);
            ibVar.a(this.f3065a);
            ibVar.b();
        }
        if (this.f3069b != null && g()) {
            ibVar.a(f52192f);
            ibVar.a(this.f3069b);
            ibVar.b();
        }
        if (this.f3064a != null) {
            ibVar.a(f52193g);
            this.f3064a.b(ibVar);
            ibVar.b();
        }
        if (this.f3063a != null && i()) {
            ibVar.a(f52194h);
            this.f3063a.b(ibVar);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    public hc a(ByteBuffer byteBuffer) {
        this.f3066a = byteBuffer;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2793a() {
        return this.f3065a;
    }

    public hc a(String str) {
        this.f3065a = str;
        return this;
    }

    public hc a(gv gvVar) {
        this.f3064a = gvVar;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public gt m2792a() {
        return this.f3063a;
    }

    public hc a(gt gtVar) {
        this.f3063a = gtVar;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2797a(hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = hcVar.a();
        if (((a11 || a12) && (!a11 || !a12 || !this.f3062a.equals(hcVar.f3062a))) || this.f3068a != hcVar.f3068a || this.f3070b != hcVar.f3070b) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = hcVar.e();
        if ((e11 || e12) && (!e11 || !e12 || !this.f3066a.equals(hcVar.f3066a))) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = hcVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f3065a.equals(hcVar.f3065a))) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = hcVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3069b.equals(hcVar.f3069b))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = hcVar.h();
        if ((h11 || h12) && (!h11 || !h12 || !this.f3064a.compareTo(hcVar.f3064a))) {
            return false;
        }
        boolean i11 = i();
        boolean i12 = hcVar.i();
        if (!i11 && !i12) {
            return true;
        }
        if (!i11 || !i12 || !this.f3063a.compareTo(hcVar.f3063a)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(hc hcVar) {
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        if (!getClass().equals(hcVar.getClass())) {
            return getClass().getName().compareTo(hcVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hcVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a18 = hs.a((Comparable) this.f3062a, (Comparable) hcVar.f3062a)) != 0) {
            return a18;
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hcVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a17 = hs.a(this.f3068a, hcVar.f3068a)) != 0) {
            return a17;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hcVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a16 = hs.a(this.f3070b, hcVar.f3070b)) != 0) {
            return a16;
        }
        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hcVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (a15 = hs.a((Comparable) this.f3066a, (Comparable) hcVar.f3066a)) != 0) {
            return a15;
        }
        int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hcVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a14 = hs.a(this.f3065a, hcVar.f3065a)) != 0) {
            return a14;
        }
        int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hcVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (a13 = hs.a(this.f3069b, hcVar.f3069b)) != 0) {
            return a13;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hcVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a12 = hs.a((Comparable) this.f3064a, (Comparable) hcVar.f3064a)) != 0) {
            return a12;
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hcVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!i() || (a11 = hs.a((Comparable) this.f3063a, (Comparable) hcVar.f3063a)) == 0) {
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
                if (!c()) {
                    throw new ic("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    a();
                    return;
                } else {
                    throw new ic("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (a11.f3243a) {
                    case 1:
                        if (b11 != 8) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f3062a = gg.a(ibVar.a());
                            break;
                        }
                    case 2:
                        if (b11 != 2) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f3068a = ibVar.a();
                            a(true);
                            break;
                        }
                    case 3:
                        if (b11 != 2) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f3070b = ibVar.a();
                            b(true);
                            break;
                        }
                    case 4:
                        if (b11 != 11) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f3066a = ibVar.a();
                            break;
                        }
                    case 5:
                        if (b11 != 11) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f3065a = ibVar.a();
                            break;
                        }
                    case 6:
                        if (b11 != 11) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            this.f3069b = ibVar.a();
                            break;
                        }
                    case 7:
                        if (b11 != 12) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            gv gvVar = new gv();
                            this.f3064a = gvVar;
                            gvVar.a(ibVar);
                            break;
                        }
                    case 8:
                        if (b11 != 12) {
                            ie.a(ibVar, b11);
                            break;
                        } else {
                            gt gtVar = new gt();
                            this.f3063a = gtVar;
                            gtVar.a(ibVar);
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

    /* renamed from: a  reason: collision with other method in class */
    public void m2794a() {
        if (this.f3062a == null) {
            throw new ic("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f3066a == null) {
            throw new ic("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f3064a == null) {
            throw new ic("Required field 'target' was not present! Struct: " + toString());
        }
    }
}
