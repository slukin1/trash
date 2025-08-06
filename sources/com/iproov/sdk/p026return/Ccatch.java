package com.iproov.sdk.p026return;

import com.fluttercandies.photo_manager.core.entity.a;

/* renamed from: com.iproov.sdk.return.catch  reason: invalid class name and invalid package */
public final class Ccatch {

    /* renamed from: do  reason: not valid java name */
    private final long f1356do;

    /* renamed from: for  reason: not valid java name */
    private final boolean f1357for;

    /* renamed from: if  reason: not valid java name */
    private final long f1358if;

    public Ccatch(long j11, long j12, boolean z11) {
        this.f1356do = j11;
        this.f1358if = j12;
        this.f1357for = z11;
    }

    /* renamed from: do  reason: not valid java name */
    public final long m1416do() {
        return this.f1356do;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ccatch)) {
            return false;
        }
        Ccatch catchR = (Ccatch) obj;
        return this.f1356do == catchR.f1356do && this.f1358if == catchR.f1358if && this.f1357for == catchR.f1357for;
    }

    /* renamed from: for  reason: not valid java name */
    public final boolean m1417for() {
        return this.f1357for;
    }

    public int hashCode() {
        int a11 = ((a.a(this.f1356do) * 31) + a.a(this.f1358if)) * 31;
        boolean z11 = this.f1357for;
        if (z11) {
            z11 = true;
        }
        return a11 + (z11 ? 1 : 0);
    }

    /* renamed from: if  reason: not valid java name */
    public final long m1418if() {
        return this.f1358if;
    }

    public String toString() {
        return "HeldFrameData(startTimeFPS=" + this.f1356do + ", timestamp=" + this.f1358if + ", isSupplementary=" + this.f1357for + ')';
    }
}
