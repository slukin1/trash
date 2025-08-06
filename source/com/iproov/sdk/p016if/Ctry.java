package com.iproov.sdk.p016if;

import com.fluttercandies.photo_manager.core.entity.a;
import java.util.Arrays;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.try  reason: invalid class name and invalid package */
public final class Ctry {

    /* renamed from: do  reason: not valid java name */
    private final byte[] f728do;

    /* renamed from: for  reason: not valid java name */
    private final long f729for;

    /* renamed from: if  reason: not valid java name */
    private final boolean f730if;

    /* renamed from: new  reason: not valid java name */
    private final boolean f731new;

    public Ctry(byte[] bArr, boolean z11, long j11, boolean z12) {
        this.f728do = bArr;
        this.f730if = z11;
        this.f729for = j11;
        this.f731new = z12;
    }

    /* renamed from: do  reason: not valid java name */
    public final byte[] m840do() {
        return this.f728do;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ctry)) {
            return false;
        }
        Ctry tryR = (Ctry) obj;
        return x.b(this.f728do, tryR.f728do) && this.f730if == tryR.f730if && this.f729for == tryR.f729for && this.f731new == tryR.f731new;
    }

    /* renamed from: for  reason: not valid java name */
    public final boolean m841for() {
        return this.f730if;
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.f728do) * 31;
        boolean z11 = this.f730if;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int a11 = (((hashCode + (z11 ? 1 : 0)) * 31) + a.a(this.f729for)) * 31;
        boolean z13 = this.f731new;
        if (!z13) {
            z12 = z13;
        }
        return a11 + (z12 ? 1 : 0);
    }

    /* renamed from: if  reason: not valid java name */
    public final long m842if() {
        return this.f729for;
    }

    /* renamed from: new  reason: not valid java name */
    public final boolean m843new() {
        return this.f731new;
    }

    public String toString() {
        return "EncodedFrame(isFinal=" + this.f730if + ", isSupplementary=" + this.f731new + " timestamp=" + this.f729for + " data size=" + this.f728do.length + '}';
    }
}
