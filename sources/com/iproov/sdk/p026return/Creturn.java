package com.iproov.sdk.p026return;

import com.fluttercandies.photo_manager.core.entity.a;
import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.return.return  reason: invalid class name and invalid package */
public final class Creturn {

    /* renamed from: do  reason: not valid java name */
    private final int f1731do;

    /* renamed from: for  reason: not valid java name */
    private final float[] f1732for;

    /* renamed from: if  reason: not valid java name */
    private final String f1733if;

    /* renamed from: new  reason: not valid java name */
    private final long f1734new = com.iproov.sdk.p017implements.Creturn.f944do.m1034do();

    public Creturn(int i11, String str, float[] fArr) {
        this.f1731do = i11;
        this.f1733if = str;
        this.f1732for = fArr;
    }

    /* renamed from: do  reason: not valid java name */
    public final long m1688do() {
        return this.f1734new;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!x.b(Creturn.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.iproov.sdk.impl.SensorEvent");
        Creturn returnR = (Creturn) obj;
        return this.f1731do == returnR.f1731do && x.b(this.f1733if, returnR.f1733if) && Arrays.equals(this.f1732for, returnR.f1732for) && this.f1734new == returnR.f1734new;
    }

    /* renamed from: for  reason: not valid java name */
    public final float[] m1689for() {
        return this.f1732for;
    }

    public int hashCode() {
        return (((((this.f1731do * 31) + this.f1733if.hashCode()) * 31) + Arrays.hashCode(this.f1732for)) * 31) + a.a(this.f1734new);
    }

    /* renamed from: if  reason: not valid java name */
    public final int m1690if() {
        return this.f1731do;
    }

    public String toString() {
        return "SensorEvent(type=" + this.f1731do + ", name=" + this.f1733if + ", values=" + Arrays.toString(this.f1732for) + ')';
    }
}
