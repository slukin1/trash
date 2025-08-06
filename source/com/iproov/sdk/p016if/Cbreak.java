package com.iproov.sdk.p016if;

import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.break  reason: invalid class name and invalid package */
public final class Cbreak {

    /* renamed from: do  reason: not valid java name */
    private final Ctry f644do;

    public Cbreak(Ctry tryR) {
        this.f644do = tryR;
    }

    /* renamed from: do  reason: not valid java name */
    public final Ctry m718do() {
        return this.f644do;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Cbreak) && x.b(this.f644do, ((Cbreak) obj).f644do);
    }

    public int hashCode() {
        return this.f644do.hashCode();
    }

    public String toString() {
        return "FrameEncoded(encodedFrame=" + this.f644do + ')';
    }
}
