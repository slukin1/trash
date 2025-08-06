package com.iproov.sdk.p009do;

import android.graphics.Bitmap;
import com.iproov.sdk.Cfor;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.do.if  reason: invalid class name and invalid package */
public final class Cif {

    /* renamed from: do  reason: not valid java name */
    private final Cfor f486do;

    /* renamed from: if  reason: not valid java name */
    private final Bitmap f487if;

    public Cif(Cfor forR, Bitmap bitmap) {
        this.f486do = forR;
        this.f487if = bitmap;
    }

    /* renamed from: do  reason: not valid java name */
    public final Bitmap m569do() {
        return this.f487if;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cif)) {
            return false;
        }
        Cif ifVar = (Cif) obj;
        return this.f486do == ifVar.f486do && x.b(this.f487if, ifVar.f487if);
    }

    public int hashCode() {
        int hashCode = this.f486do.hashCode() * 31;
        Bitmap bitmap = this.f487if;
        return hashCode + (bitmap == null ? 0 : bitmap.hashCode());
    }

    /* renamed from: if  reason: not valid java name */
    public final Cfor m570if() {
        return this.f486do;
    }

    public String toString() {
        return "FailureResult(reason=" + this.f486do + ", frame=" + this.f487if + ')';
    }
}
