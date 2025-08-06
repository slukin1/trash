package com.iproov.sdk.p016if;

import com.fluttercandies.photo_manager.core.entity.a;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.const  reason: invalid class name and invalid package */
public final class Cconst {

    /* renamed from: do  reason: not valid java name */
    private final int f653do;

    /* renamed from: for  reason: not valid java name */
    private final long f654for;

    /* renamed from: if  reason: not valid java name */
    private final float f655if;

    public Cconst(int i11, float f11, long j11) {
        this.f653do = i11;
        this.f655if = f11;
        this.f654for = j11;
    }

    /* renamed from: do  reason: not valid java name */
    public final int m721do() {
        return this.f653do;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cconst)) {
            return false;
        }
        Cconst constR = (Cconst) obj;
        return this.f653do == constR.f653do && x.b(Float.valueOf(this.f655if), Float.valueOf(constR.f655if)) && this.f654for == constR.f654for;
    }

    /* renamed from: for  reason: not valid java name */
    public final float m722for() {
        return this.f655if;
    }

    public int hashCode() {
        return (((this.f653do * 31) + Float.floatToIntBits(this.f655if)) * 31) + a.a(this.f654for);
    }

    /* renamed from: if  reason: not valid java name */
    public final long m723if() {
        return this.f654for;
    }

    public String toString() {
        return "FlashWithColor(color=" + this.f653do + ", progress=" + this.f655if + ", estimatedDurationMillis=" + this.f654for + ')';
    }
}
