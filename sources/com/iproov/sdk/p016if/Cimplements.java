package com.iproov.sdk.p016if;

import android.graphics.RectF;
import com.fluttercandies.photo_manager.core.entity.a;
import com.iproov.sdk.core.Cif;
import com.iproov.sdk.p005class.Celse;
import com.iproov.sdk.p026return.Cstatic;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.implements  reason: invalid class name and invalid package */
public final class Cimplements {

    /* renamed from: case  reason: not valid java name */
    private final Celse f680case;

    /* renamed from: do  reason: not valid java name */
    private final byte[] f681do;

    /* renamed from: else  reason: not valid java name */
    private final Cif f682else;

    /* renamed from: for  reason: not valid java name */
    private final List<Cstatic> f683for;

    /* renamed from: goto  reason: not valid java name */
    private final boolean f684goto;

    /* renamed from: if  reason: not valid java name */
    private final long f685if;

    /* renamed from: new  reason: not valid java name */
    private final RectF f686new;

    /* renamed from: try  reason: not valid java name */
    private final byte[] f687try;

    public Cimplements(byte[] bArr, long j11, List<Cstatic> list, RectF rectF, byte[] bArr2, Celse elseR, Cif ifVar, boolean z11) {
        this.f681do = bArr;
        this.f685if = j11;
        this.f683for = list;
        this.f686new = rectF;
        this.f687try = bArr2;
        this.f680case = elseR;
        this.f682else = ifVar;
        this.f684goto = z11;
    }

    /* renamed from: case  reason: not valid java name */
    public final byte[] m774case() {
        return this.f687try;
    }

    /* renamed from: do  reason: not valid java name */
    public final RectF m775do() {
        return this.f686new;
    }

    /* renamed from: else  reason: not valid java name */
    public final long m776else() {
        return this.f685if;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cimplements)) {
            return false;
        }
        Cimplements implementsR = (Cimplements) obj;
        return x.b(this.f681do, implementsR.f681do) && this.f685if == implementsR.f685if && x.b(this.f683for, implementsR.f683for) && x.b(this.f686new, implementsR.f686new) && x.b(this.f687try, implementsR.f687try) && this.f680case == implementsR.f680case && this.f682else == implementsR.f682else && this.f684goto == implementsR.f684goto;
    }

    /* renamed from: for  reason: not valid java name */
    public final Celse m777for() {
        return this.f680case;
    }

    /* renamed from: goto  reason: not valid java name */
    public final boolean m778goto() {
        return this.f684goto;
    }

    public int hashCode() {
        int hashCode = ((Arrays.hashCode(this.f681do) * 31) + a.a(this.f685if)) * 31;
        List<Cstatic> list = this.f683for;
        int i11 = 0;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        RectF rectF = this.f686new;
        int hashCode3 = (hashCode2 + (rectF == null ? 0 : rectF.hashCode())) * 31;
        byte[] bArr = this.f687try;
        if (bArr != null) {
            i11 = Arrays.hashCode(bArr);
        }
        int hashCode4 = (((((hashCode3 + i11) * 31) + this.f680case.hashCode()) * 31) + this.f682else.hashCode()) * 31;
        boolean z11 = this.f684goto;
        if (z11) {
            z11 = true;
        }
        return hashCode4 + (z11 ? 1 : 0);
    }

    /* renamed from: if  reason: not valid java name */
    public final byte[] m779if() {
        return this.f681do;
    }

    /* renamed from: new  reason: not valid java name */
    public final Cif m780new() {
        return this.f682else;
    }

    public String toString() {
        return "VideoData(timestamp=" + this.f685if + ", cropRectFNormalised=" + this.f686new + ", encoderType=" + this.f680case + ", frameType=" + this.f682else + ", isFinal=" + this.f684goto + ')';
    }

    /* renamed from: try  reason: not valid java name */
    public final List<Cstatic> m781try() {
        return this.f683for;
    }
}
