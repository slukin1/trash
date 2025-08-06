package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;

public class gv implements hr<gv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52127a = new hy("", (byte) 10, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f2989a = new ig("Target");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52128b = new hy("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52129c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52130d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52131e = new hy("", (byte) 2, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52132f = new hy("", (byte) 11, 7);

    /* renamed from: a  reason: collision with other field name */
    public long f2990a = 5;

    /* renamed from: a  reason: collision with other field name */
    public String f2991a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f2992a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f2993a = false;

    /* renamed from: b  reason: collision with other field name */
    public String f2994b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f2995c = "";

    /* renamed from: d  reason: collision with other field name */
    public String f2996d;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2769a() {
        return this.f2992a.get(0);
    }

    public boolean b() {
        return this.f2991a != null;
    }

    public boolean c() {
        return this.f2994b != null;
    }

    public boolean d() {
        return this.f2995c != null;
    }

    public boolean e() {
        return this.f2992a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gv)) {
            return compareTo((gv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f2996d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Target(");
        sb2.append("channelId:");
        sb2.append(this.f2990a);
        sb2.append(", ");
        sb2.append("userId:");
        String str = this.f2991a;
        if (str == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str);
        }
        if (c()) {
            sb2.append(", ");
            sb2.append("server:");
            String str2 = this.f2994b;
            if (str2 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str2);
            }
        }
        if (d()) {
            sb2.append(", ");
            sb2.append("resource:");
            String str3 = this.f2995c;
            if (str3 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str3);
            }
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("isPreview:");
            sb2.append(this.f2993a);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("token:");
            String str4 = this.f2996d;
            if (str4 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str4);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public void a(boolean z11) {
        this.f2992a.set(0, z11);
    }

    public void b(boolean z11) {
        this.f2992a.set(1, z11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2770a(gv gvVar) {
        if (gvVar == null || this.f2990a != gvVar.f2990a) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = gvVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f2991a.equals(gvVar.f2991a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = gvVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f2994b.equals(gvVar.f2994b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = gvVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f2995c.equals(gvVar.f2995c))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = gvVar.e();
        if ((e11 || e12) && (!e11 || !e12 || this.f2993a != gvVar.f2993a)) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = gvVar.f();
        if (!f11 && !f12) {
            return true;
        }
        if (!f11 || !f12 || !this.f2996d.equals(gvVar.f2996d)) {
            return false;
        }
        return true;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f2989a);
        ibVar.a(f52127a);
        ibVar.a(this.f2990a);
        ibVar.b();
        if (this.f2991a != null) {
            ibVar.a(f52128b);
            ibVar.a(this.f2991a);
            ibVar.b();
        }
        if (this.f2994b != null && c()) {
            ibVar.a(f52129c);
            ibVar.a(this.f2994b);
            ibVar.b();
        }
        if (this.f2995c != null && d()) {
            ibVar.a(f52130d);
            ibVar.a(this.f2995c);
            ibVar.b();
        }
        if (e()) {
            ibVar.a(f52131e);
            ibVar.a(this.f2993a);
            ibVar.b();
        }
        if (this.f2996d != null && f()) {
            ibVar.a(f52132f);
            ibVar.a(this.f2996d);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a */
    public int compareTo(gv gvVar) {
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        if (!getClass().equals(gvVar.getClass())) {
            return getClass().getName().compareTo(gvVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gvVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a16 = hs.a(this.f2990a, gvVar.f2990a)) != 0) {
            return a16;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gvVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a15 = hs.a(this.f2991a, gvVar.f2991a)) != 0) {
            return a15;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gvVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a14 = hs.a(this.f2994b, gvVar.f2994b)) != 0) {
            return a14;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gvVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a13 = hs.a(this.f2995c, gvVar.f2995c)) != 0) {
            return a13;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gvVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a12 = hs.a(this.f2993a, gvVar.f2993a)) != 0) {
            return a12;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gvVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!f() || (a11 = hs.a(this.f2996d, gvVar.f2996d)) == 0) {
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
                break;
            }
            short s11 = a11.f3243a;
            if (s11 != 1) {
                if (s11 != 2) {
                    if (s11 != 3) {
                        if (s11 != 4) {
                            if (s11 != 5) {
                                if (s11 != 7) {
                                    ie.a(ibVar, b11);
                                } else if (b11 == 11) {
                                    this.f2996d = ibVar.a();
                                } else {
                                    ie.a(ibVar, b11);
                                }
                            } else if (b11 == 2) {
                                this.f2993a = ibVar.a();
                                b(true);
                            } else {
                                ie.a(ibVar, b11);
                            }
                        } else if (b11 == 11) {
                            this.f2995c = ibVar.a();
                        } else {
                            ie.a(ibVar, b11);
                        }
                    } else if (b11 == 11) {
                        this.f2994b = ibVar.a();
                    } else {
                        ie.a(ibVar, b11);
                    }
                } else if (b11 == 11) {
                    this.f2991a = ibVar.a();
                } else {
                    ie.a(ibVar, b11);
                }
            } else if (b11 == 10) {
                this.f2990a = ibVar.a();
                a(true);
            } else {
                ie.a(ibVar, b11);
            }
            ibVar.g();
        }
        ibVar.f();
        if (a()) {
            a();
            return;
        }
        throw new ic("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a() {
        if (this.f2991a == null) {
            throw new ic("Required field 'userId' was not present! Struct: " + toString());
        }
    }
}
