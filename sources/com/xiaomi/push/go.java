package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.BitSet;

public class go implements hr<go, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52044a = new hy("", (byte) 10, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f2931a = new ig("DataCollectionItem");

    /* renamed from: b  reason: collision with root package name */
    private static final hy f52045b = new hy("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final hy f52046c = new hy("", (byte) 11, 3);

    /* renamed from: a  reason: collision with other field name */
    public long f2932a;

    /* renamed from: a  reason: collision with other field name */
    public gi f2933a;

    /* renamed from: a  reason: collision with other field name */
    public String f2934a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f2935a = new BitSet(1);

    public go a(long j11) {
        this.f2932a = j11;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f2933a != null;
    }

    public boolean c() {
        return this.f2934a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof go)) {
            return compareTo((go) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DataCollectionItem(");
        sb2.append("collectedAt:");
        sb2.append(this.f2932a);
        sb2.append(", ");
        sb2.append("collectionType:");
        gi giVar = this.f2933a;
        if (giVar == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(giVar);
        }
        sb2.append(", ");
        sb2.append("content:");
        String str = this.f2934a;
        if (str == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(str);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f2931a);
        ibVar.a(f52044a);
        ibVar.a(this.f2932a);
        ibVar.b();
        if (this.f2933a != null) {
            ibVar.a(f52045b);
            ibVar.a(this.f2933a.a());
            ibVar.b();
        }
        if (this.f2934a != null) {
            ibVar.a(f52046c);
            ibVar.a(this.f2934a);
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2737a() {
        return this.f2935a.get(0);
    }

    public void a(boolean z11) {
        this.f2935a.set(0, z11);
    }

    public go a(gi giVar) {
        this.f2933a = giVar;
        return this;
    }

    public String a() {
        return this.f2934a;
    }

    public go a(String str) {
        this.f2934a = str;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2738a(go goVar) {
        if (goVar == null || this.f2932a != goVar.f2932a) {
            return false;
        }
        boolean b11 = b();
        boolean b12 = goVar.b();
        if ((b11 || b12) && (!b11 || !b12 || !this.f2933a.equals(goVar.f2933a))) {
            return false;
        }
        boolean c11 = c();
        boolean c12 = goVar.c();
        if (!c11 && !c12) {
            return true;
        }
        if (!c11 || !c12 || !this.f2934a.equals(goVar.f2934a)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(go goVar) {
        int a11;
        int a12;
        int a13;
        if (!getClass().equals(goVar.getClass())) {
            return getClass().getName().compareTo(goVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(goVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a13 = hs.a(this.f2932a, goVar.f2932a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(goVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a12 = hs.a((Comparable) this.f2933a, (Comparable) goVar.f2933a)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(goVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a11 = hs.a(this.f2934a, goVar.f2934a)) == 0) {
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
                        ie.a(ibVar, b11);
                    } else if (b11 == 11) {
                        this.f2934a = ibVar.a();
                    } else {
                        ie.a(ibVar, b11);
                    }
                } else if (b11 == 8) {
                    this.f2933a = gi.a(ibVar.a());
                } else {
                    ie.a(ibVar, b11);
                }
            } else if (b11 == 10) {
                this.f2932a = ibVar.a();
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
        throw new ic("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2736a() {
        if (this.f2933a == null) {
            throw new ic("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.f2934a == null) {
            throw new ic("Required field 'content' was not present! Struct: " + toString());
        }
    }
}
