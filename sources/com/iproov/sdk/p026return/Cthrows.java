package com.iproov.sdk.p026return;

import java.util.Set;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.return.throws  reason: invalid class name and invalid package */
public final class Cthrows {

    /* renamed from: do  reason: not valid java name */
    private final Set<Integer> f1879do;

    public Cthrows(Set<Integer> set) {
        this.f1879do = set;
    }

    /* renamed from: do  reason: not valid java name */
    public final Set<Integer> m1754do() {
        return this.f1879do;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Cthrows) && x.b(this.f1879do, ((Cthrows) obj).f1879do);
    }

    public int hashCode() {
        return this.f1879do.hashCode();
    }

    public String toString() {
        return "SensorTypes(types=" + this.f1879do + ')';
    }
}
