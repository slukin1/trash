package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class el implements hr<el, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f51730a = new hy("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f2785a = new ig("StatsEvents");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f51731b = new hy("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f51732c = new hy("", (byte) 15, 3);

    /* renamed from: a  reason: collision with other field name */
    public String f2786a;

    /* renamed from: a  reason: collision with other field name */
    public List<ek> f2787a;

    /* renamed from: b  reason: collision with other field name */
    public String f2788b;

    public el() {
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2638a() {
        return this.f2786a != null;
    }

    public boolean b() {
        return this.f2788b != null;
    }

    public boolean c() {
        return this.f2787a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof el)) {
            return compareTo((el) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("StatsEvents(");
        sb2.append("uuid:");
        String str = this.f2786a;
        if (str == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str);
        }
        if (b()) {
            sb2.append(", ");
            sb2.append("operator:");
            String str2 = this.f2788b;
            if (str2 == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str2);
            }
        }
        sb2.append(", ");
        sb2.append("events:");
        List<ek> list = this.f2787a;
        if (list == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(list);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public el(String str, List<ek> list) {
        this();
        this.f2786a = str;
        this.f2787a = list;
    }

    public el a(String str) {
        this.f2788b = str;
        return this;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f2785a);
        if (this.f2786a != null) {
            ibVar.a(f51730a);
            ibVar.a(this.f2786a);
            ibVar.b();
        }
        if (this.f2788b != null && b()) {
            ibVar.a(f51731b);
            ibVar.a(this.f2788b);
            ibVar.b();
        }
        if (this.f2787a != null) {
            ibVar.a(f51732c);
            ibVar.a(new hz((byte) 12, this.f2787a.size()));
            for (ek b11 : this.f2787a) {
                b11.b(ibVar);
            }
            ibVar.e();
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2639a(el elVar) {
        if (elVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = elVar.a();
        if ((a11 || a12) && (!a11 || !a12 || !this.f2786a.equals(elVar.f2786a))) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = elVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f2788b.equals(elVar.f2788b))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = elVar.c();
        if (!c11 && !c12) {
            return true;
        }
        if (!c11 || !c12 || !this.f2787a.equals(elVar.f2787a)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(el elVar) {
        int a11;
        int a12;
        int a13;
        if (!getClass().equals(elVar.getClass())) {
            return getClass().getName().compareTo(elVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(elVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a13 = hs.a(this.f2786a, elVar.f2786a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(elVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a12 = hs.a(this.f2788b, elVar.f2788b)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(elVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a11 = hs.a((List) this.f2787a, (List) elVar.f2787a)) == 0) {
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
            short s11 = a11.f3243a;
            if (s11 != 1) {
                if (s11 != 2) {
                    if (s11 != 3) {
                        ie.a(ibVar, b11);
                    } else if (b11 == 15) {
                        hz a12 = ibVar.a();
                        this.f2787a = new ArrayList(a12.f3244a);
                        for (int i11 = 0; i11 < a12.f3244a; i11++) {
                            ek ekVar = new ek();
                            ekVar.a(ibVar);
                            this.f2787a.add(ekVar);
                        }
                        ibVar.i();
                    } else {
                        ie.a(ibVar, b11);
                    }
                } else if (b11 == 11) {
                    this.f2788b = ibVar.a();
                } else {
                    ie.a(ibVar, b11);
                }
            } else if (b11 == 11) {
                this.f2786a = ibVar.a();
            } else {
                ie.a(ibVar, b11);
            }
            ibVar.g();
        }
    }

    public void a() {
        if (this.f2786a == null) {
            throw new ic("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f2787a == null) {
            throw new ic("Required field 'events' was not present! Struct: " + toString());
        }
    }
}
