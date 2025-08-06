package com.iproov.sdk.p016if;

import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.native  reason: invalid class name and invalid package */
public final class Cnative {

    /* renamed from: do  reason: not valid java name */
    private final double f699do;

    /* renamed from: if  reason: not valid java name */
    private final double f700if;

    public Cnative(double d11, double d12) {
        this.f699do = d11;
        this.f700if = d12;
    }

    /* renamed from: do  reason: not valid java name */
    public final double m788do() {
        return this.f699do;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cnative)) {
            return false;
        }
        Cnative nativeR = (Cnative) obj;
        return x.b(Double.valueOf(this.f699do), Double.valueOf(nativeR.f699do)) && x.b(Double.valueOf(this.f700if), Double.valueOf(nativeR.f700if));
    }

    public int hashCode() {
        return (Double.doubleToLongBits(this.f699do) * 31) + Double.doubleToLongBits(this.f700if);
    }

    public String toString() {
        return "LAProgress(progress=" + this.f699do + ", distanceFromTarget=" + this.f700if + ')';
    }
}
