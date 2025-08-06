package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;

public class hi implements hr<hi, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52258a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3145a = new ig("XmPushActionSendFeedbackResult");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52259b = new hy("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52260c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52261d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52262e = new hy("", (byte) 10, 6);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52263f = new hy("", (byte) 11, 7);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52264g = new hy("", (byte) 11, 8);

    /* renamed from: a  reason: collision with other field name */
    public long f3146a;

    /* renamed from: a  reason: collision with other field name */
    public gv f3147a;

    /* renamed from: a  reason: collision with other field name */
    public String f3148a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f3149a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f3150b;

    /* renamed from: c  reason: collision with other field name */
    public String f3151c;

    /* renamed from: d  reason: collision with other field name */
    public String f3152d;

    /* renamed from: e  reason: collision with other field name */
    public String f3153e;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2829a() {
        return this.f3148a != null;
    }

    public boolean b() {
        return this.f3147a != null;
    }

    public boolean c() {
        return this.f3150b != null;
    }

    public boolean d() {
        return this.f3151c != null;
    }

    public boolean e() {
        return this.f3149a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hi)) {
            return compareTo((hi) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3152d != null;
    }

    public boolean g() {
        return this.f3153e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z12 = false;
        if (a()) {
            sb2.append("debug:");
            String str = this.f3148a;
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
            gv gvVar = this.f3147a;
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
        String str2 = this.f3150b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f3151c;
        if (str3 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("errorCode:");
        sb2.append(this.f3146a);
        if (f()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str4 = this.f3152d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("category:");
            String str5 = this.f3153e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public void a(boolean z11) {
        this.f3149a.set(0, z11);
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3145a);
        if (this.f3148a != null && a()) {
            ibVar.a(f52258a);
            ibVar.a(this.f3148a);
            ibVar.b();
        }
        if (this.f3147a != null && b()) {
            ibVar.a(f52259b);
            this.f3147a.b(ibVar);
            ibVar.b();
        }
        if (this.f3150b != null) {
            ibVar.a(f52260c);
            ibVar.a(this.f3150b);
            ibVar.b();
        }
        if (this.f3151c != null) {
            ibVar.a(f52261d);
            ibVar.a(this.f3151c);
            ibVar.b();
        }
        ibVar.a(f52262e);
        ibVar.a(this.f3146a);
        ibVar.b();
        if (this.f3152d != null && f()) {
            ibVar.a(f52263f);
            ibVar.a(this.f3152d);
            ibVar.b();
        }
        if (this.f3153e != null && g()) {
            ibVar.a(f52264g);
            ibVar.a(this.f3153e);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2830a(hi hiVar) {
        if (hiVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = hiVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3148a.equals(hiVar.f3148a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = hiVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3147a.compareTo(hiVar.f3147a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = hiVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3150b.equals(hiVar.f3150b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = hiVar.d();
        if (((d11 || d12) && (!d11 || !d12 || !this.f3151c.equals(hiVar.f3151c))) || this.f3146a != hiVar.f3146a) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = hiVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f3152d.equals(hiVar.f3152d))) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = hiVar.g();
        if (!g11 && !g12) {
            return true;
        }
        if (!g11 || !g12 || !this.f3153e.equals(hiVar.f3153e)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(hi hiVar) {
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        if (!getClass().equals(hiVar.getClass())) {
            return getClass().getName().compareTo(hiVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hiVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a17 = hs.a(this.f3148a, hiVar.f3148a)) != 0) {
            return a17;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hiVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a16 = hs.a((Comparable) this.f3147a, (Comparable) hiVar.f3147a)) != 0) {
            return a16;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hiVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a15 = hs.a(this.f3150b, hiVar.f3150b)) != 0) {
            return a15;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hiVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a14 = hs.a(this.f3151c, hiVar.f3151c)) != 0) {
            return a14;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hiVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a13 = hs.a(this.f3146a, hiVar.f3146a)) != 0) {
            return a13;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hiVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a12 = hs.a(this.f3152d, hiVar.f3152d)) != 0) {
            return a12;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hiVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!g() || (a11 = hs.a(this.f3153e, hiVar.f3153e)) == 0) {
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
                case 1:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3148a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3147a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3150b = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3151c = ibVar.a();
                        break;
                    }
                case 6:
                    if (b11 != 10) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3146a = ibVar.a();
                        a(true);
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3152d = ibVar.a();
                        break;
                    }
                case 8:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3153e = ibVar.a();
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
        if (this.f3150b == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3151c == null) {
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
