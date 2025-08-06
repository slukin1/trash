package com.xiaomi.push;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class gz implements hr<gz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final hy f52165a = new hy("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final ig f3035a = new ig("XmPushActionCollectData");

    /* renamed from: a  reason: collision with other field name */
    public List<go> f3036a;

    public gz a(List<go> list) {
        this.f3036a = list;
        return this;
    }

    public void b(ib ibVar) {
        a();
        ibVar.a(f3035a);
        if (this.f3036a != null) {
            ibVar.a(f52165a);
            ibVar.a(new hz((byte) 12, this.f3036a.size()));
            for (go b11 : this.f3036a) {
                b11.b(ibVar);
            }
            ibVar.e();
            ibVar.b();
        }
        ibVar.c();
        ibVar.a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gz)) {
            return compareTo((gz) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("XmPushActionCollectData(");
        sb2.append("dataCollectionItems:");
        List<go> list = this.f3036a;
        if (list == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            sb2.append(list);
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2780a() {
        return this.f3036a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2781a(gz gzVar) {
        if (gzVar == null) {
            return false;
        }
        boolean a11 = a();
        boolean a12 = gzVar.a();
        if (!a11 && !a12) {
            return true;
        }
        if (!a11 || !a12 || !this.f3036a.equals(gzVar.f3036a)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public int compareTo(gz gzVar) {
        int a11;
        if (!getClass().equals(gzVar.getClass())) {
            return getClass().getName().compareTo(gzVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gzVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!a() || (a11 = hs.a((List) this.f3036a, (List) gzVar.f3036a)) == 0) {
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
                this.f3036a = new ArrayList(a12.f3244a);
                for (int i11 = 0; i11 < a12.f3244a; i11++) {
                    go goVar = new go();
                    goVar.a(ibVar);
                    this.f3036a.add(goVar);
                }
                ibVar.i();
            } else {
                ie.a(ibVar, b11);
            }
            ibVar.g();
        }
    }

    public void a() {
        if (this.f3036a == null) {
            throw new ic("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }
}
