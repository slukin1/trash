package com.iproov.sdk.p026return;

import com.fluttercandies.photo_manager.core.entity.a;
import java.util.Map;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.return.static  reason: invalid class name and invalid package */
public final class Cstatic {

    /* renamed from: do  reason: not valid java name */
    private final int f1735do;

    /* renamed from: for  reason: not valid java name */
    private final long f1736for;

    /* renamed from: if  reason: not valid java name */
    private final long f1737if;

    /* renamed from: new  reason: not valid java name */
    private Map<Integer, Creturn> f1738new;

    /* renamed from: try  reason: not valid java name */
    private final Map<Integer, Integer> f1739try;

    public Cstatic(int i11, long j11, long j12, Map<Integer, Creturn> map, Map<Integer, Integer> map2) {
        this.f1735do = i11;
        this.f1737if = j11;
        this.f1736for = j12;
        this.f1738new = map;
        this.f1739try = map2;
    }

    /* renamed from: do  reason: not valid java name */
    public final long m1691do() {
        return this.f1737if;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cstatic)) {
            return false;
        }
        Cstatic staticR = (Cstatic) obj;
        return this.f1735do == staticR.f1735do && this.f1737if == staticR.f1737if && this.f1736for == staticR.f1736for && x.b(this.f1738new, staticR.f1738new) && x.b(this.f1739try, staticR.f1739try);
    }

    /* renamed from: for  reason: not valid java name */
    public final long m1692for() {
        return this.f1736for;
    }

    public int hashCode() {
        return (((((((this.f1735do * 31) + a.a(this.f1737if)) * 31) + a.a(this.f1736for)) * 31) + this.f1738new.hashCode()) * 31) + this.f1739try.hashCode();
    }

    /* renamed from: if  reason: not valid java name */
    public final int m1693if() {
        return this.f1735do;
    }

    /* renamed from: new  reason: not valid java name */
    public final Map<Integer, Creturn> m1694new() {
        return this.f1738new;
    }

    public String toString() {
        return "SensorSample(id=" + this.f1735do + ", firstTimeStampMs=" + this.f1737if + ", lastTimeStampMs=" + this.f1736for + ", sensorData=" + this.f1738new + ", sampleCountDebug=" + this.f1739try + ')';
    }
}
