package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class gj implements hr<gj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f51948a = new hy("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f2910a = new ig("ClientUploadData");

    /* renamed from: a  reason: collision with other field name */
    public List<gk> f2911a;

    public int a() {
        List<gk> list = this.f2911a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f2910a);
        if (this.f2911a != null) {
            ibVar.a(f51948a);
            ibVar.a(new hz((byte) 12, this.f2911a.size()));
            for (gk b11 : this.f2911a) {
                b11.b(ibVar);
            }
            ibVar.e();
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gj)) {
            return compareTo((gj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ClientUploadData(");
        sb2.append("uploadDataItems:");
        List<gk> list = this.f2911a;
        if (list == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(list);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public void a(gk gkVar) {
        if (this.f2911a == null) {
            this.f2911a = new ArrayList();
        }
        this.f2911a.add(gkVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2724a() {
        return this.f2911a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2725a(gj gjVar) {
        if (gjVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = gjVar.a();
        if (!a11 && !a12) {
            return true;
        }
        if (!a11 || !a12 || !this.f2911a.equals(gjVar.f2911a)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(gj gjVar) {
        int a11;
        if (!getClass().equals(gjVar.getClass())) {
            return getClass().getName().compareTo(gjVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gjVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!a() || (a11 = hs.a((List) this.f2911a, (List) gjVar.f2911a)) == 0) {
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
            if (a11.f3243a != 1) {
                ie.a(ibVar, b11);
            } else if (b11 == 15) {
                hz a12 = ibVar.a();
                this.f2911a = new ArrayList(a12.f3244a);
                for (int i11 = 0; i11 < a12.f3244a; i11++) {
                    gk gkVar = new gk();
                    gkVar.a(ibVar);
                    this.f2911a.add(gkVar);
                }
                ibVar.i();
            } else {
                ie.a(ibVar, b11);
            }
            ibVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2723a() {
        if (this.f2911a == null) {
            throw new ic("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }
}
