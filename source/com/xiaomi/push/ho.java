package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ho implements hr<ho, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52315a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3213a = new ig("XmPushActionUnSubscription");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52316b = new hy("", (byte) 12, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52317c = new hy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    private static final hy f52318d = new hy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final hy f52319e = new hy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    private static final hy f52320f = new hy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    private static final hy f52321g = new hy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    private static final hy f52322h = new hy("", (byte) 15, 8);

    /* renamed from: a  reason: collision with other field name */
    public gv f3214a;

    /* renamed from: a  reason: collision with other field name */
    public String f3215a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f3216a;

    /* renamed from: b  reason: collision with other field name */
    public String f3217b;

    /* renamed from: c  reason: collision with other field name */
    public String f3218c;

    /* renamed from: d  reason: collision with other field name */
    public String f3219d;

    /* renamed from: e  reason: collision with other field name */
    public String f3220e;

    /* renamed from: f  reason: collision with other field name */
    public String f3221f;

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2852a() {
        return this.f3215a != null;
    }

    public boolean b() {
        return this.f3214a != null;
    }

    public boolean c() {
        return this.f3217b != null;
    }

    public boolean d() {
        return this.f3218c != null;
    }

    public boolean e() {
        return this.f3219d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ho)) {
            return compareTo((ho) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f3220e != null;
    }

    public boolean g() {
        return this.f3221f != null;
    }

    public boolean h() {
        return this.f3216a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder("XmPushActionUnSubscription(");
        boolean z12 = false;
        if (a()) {
            sb2.append("debug:");
            String str = this.f3215a;
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
            gv gvVar = this.f3214a;
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
        String str2 = this.f3217b;
        if (str2 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f3218c;
        if (str3 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("topic:");
        String str4 = this.f3219d;
        if (str4 == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str4);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str5 = this.f3220e;
            if (str5 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str5);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("category:");
            String str6 = this.f3221f;
            if (str6 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str6);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("aliases:");
            List<String> list = this.f3216a;
            if (list == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(list);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public ho a(String str) {
        this.f3217b = str;
        return this;
    }

    public ho b(String str) {
        this.f3218c = str;
        return this;
    }

    public ho c(String str) {
        this.f3219d = str;
        return this;
    }

    public ho d(String str) {
        this.f3220e = str;
        return this;
    }

    public ho e(String str) {
        this.f3221f = str;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2853a(ho hoVar) {
        if (hoVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = hoVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f3215a.equals(hoVar.f3215a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = hoVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f3214a.compareTo(hoVar.f3214a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = hoVar.c();
        if ((c11 || c12) && (!c11 || !c12 || !this.f3217b.equals(hoVar.f3217b))) {
            return false;
        }
        boolean d11 = d();
        boolean d12 = hoVar.d();
        if ((d11 || d12) && (!d11 || !d12 || !this.f3218c.equals(hoVar.f3218c))) {
            return false;
        }
        boolean e11 = e();
        boolean e12 = hoVar.e();
        if ((e11 || e12) && (!e11 || !e12 || !this.f3219d.equals(hoVar.f3219d))) {
            return false;
        }
        boolean f11 = f();
        boolean f12 = hoVar.f();
        if ((f11 || f12) && (!f11 || !f12 || !this.f3220e.equals(hoVar.f3220e))) {
            return false;
        }
        boolean g11 = g();
        boolean g12 = hoVar.g();
        if ((g11 || g12) && (!g11 || !g12 || !this.f3221f.equals(hoVar.f3221f))) {
            return false;
        }
        boolean h11 = h();
        boolean h12 = hoVar.h();
        if (!h11 && !h12) {
            return true;
        }
        if (!h11 || !h12 || !this.f3216a.equals(hoVar.f3216a)) {
            return false;
        }
        return true;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3213a);
        if (this.f3215a != null && a()) {
            ibVar.a(f52315a);
            ibVar.a(this.f3215a);
            ibVar.b();
        }
        if (this.f3214a != null && b()) {
            ibVar.a(f52316b);
            this.f3214a.b(ibVar);
            ibVar.b();
        }
        if (this.f3217b != null) {
            ibVar.a(f52317c);
            ibVar.a(this.f3217b);
            ibVar.b();
        }
        if (this.f3218c != null) {
            ibVar.a(f52318d);
            ibVar.a(this.f3218c);
            ibVar.b();
        }
        if (this.f3219d != null) {
            ibVar.a(f52319e);
            ibVar.a(this.f3219d);
            ibVar.b();
        }
        if (this.f3220e != null && f()) {
            ibVar.a(f52320f);
            ibVar.a(this.f3220e);
            ibVar.b();
        }
        if (this.f3221f != null && g()) {
            ibVar.a(f52321g);
            ibVar.a(this.f3221f);
            ibVar.b();
        }
        if (this.f3216a != null && h()) {
            ibVar.a(f52322h);
            ibVar.a(new hz((byte) 11, this.f3216a.size()));
            for (String a11 : this.f3216a) {
                ibVar.a(a11);
            }
            ibVar.e();
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a */
    public int compareTo(ho hoVar) {
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        if (!getClass().equals(hoVar.getClass())) {
            return getClass().getName().compareTo(hoVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hoVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a18 = hs.a(this.f3215a, hoVar.f3215a)) != 0) {
            return a18;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hoVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a17 = hs.a((Comparable) this.f3214a, (Comparable) hoVar.f3214a)) != 0) {
            return a17;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hoVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a16 = hs.a(this.f3217b, hoVar.f3217b)) != 0) {
            return a16;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hoVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a15 = hs.a(this.f3218c, hoVar.f3218c)) != 0) {
            return a15;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hoVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a14 = hs.a(this.f3219d, hoVar.f3219d)) != 0) {
            return a14;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hoVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a13 = hs.a(this.f3220e, hoVar.f3220e)) != 0) {
            return a13;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hoVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a12 = hs.a(this.f3221f, hoVar.f3221f)) != 0) {
            return a12;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hoVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a11 = hs.a((List) this.f3216a, (List) hoVar.f3216a)) == 0) {
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
                        this.f3215a = ibVar.a();
                        break;
                    }
                case 2:
                    if (b11 != 12) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        gv gvVar = new gv();
                        this.f3214a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    }
                case 3:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3217b = ibVar.a();
                        break;
                    }
                case 4:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3218c = ibVar.a();
                        break;
                    }
                case 5:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3219d = ibVar.a();
                        break;
                    }
                case 6:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3220e = ibVar.a();
                        break;
                    }
                case 7:
                    if (b11 != 11) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        this.f3221f = ibVar.a();
                        break;
                    }
                case 8:
                    if (b11 != 15) {
                        ie.a(ibVar, b11);
                        break;
                    } else {
                        hz a12 = ibVar.a();
                        this.f3216a = new ArrayList(a12.f3244a);
                        for (int i11 = 0; i11 < a12.f3244a; i11++) {
                            this.f3216a.add(ibVar.a());
                        }
                        ibVar.i();
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
        if (this.f3217b == null) {
            throw new ic("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3218c == null) {
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f3219d == null) {
            throw new ic("Required field 'topic' was not present! Struct: " + toString());
        }
    }
}
