package com.iproov.sdk.p016if;

import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.if.new  reason: invalid class name and invalid package */
public final class Cnew {

    /* renamed from: do  reason: not valid java name */
    private final Rect f701do;

    /* renamed from: if  reason: not valid java name */
    private final RectF f702if;

    public Cnew(Rect rect, RectF rectF) {
        this.f701do = rect;
        this.f702if = rectF;
    }

    /* renamed from: do  reason: not valid java name */
    public final Rect m789do() {
        return this.f701do;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cnew)) {
            return false;
        }
        Cnew newR = (Cnew) obj;
        return x.b(this.f701do, newR.f701do) && x.b(this.f702if, newR.f702if);
    }

    public int hashCode() {
        return (this.f701do.hashCode() * 31) + this.f702if.hashCode();
    }

    /* renamed from: if  reason: not valid java name */
    public final RectF m790if() {
        return this.f702if;
    }

    public String toString() {
        return "CropRectLA(cropRect=" + this.f701do + ", cropRectFNormalised=" + this.f702if + ')';
    }
}
