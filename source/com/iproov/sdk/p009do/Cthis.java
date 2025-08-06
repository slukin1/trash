package com.iproov.sdk.p009do;

import android.graphics.Bitmap;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.do.this  reason: invalid class name and invalid package */
public final class Cthis {

    /* renamed from: do  reason: not valid java name */
    private final Bitmap f506do;

    public Cthis(Bitmap bitmap) {
        this.f506do = bitmap;
    }

    /* renamed from: do  reason: not valid java name */
    public final Bitmap m579do() {
        return this.f506do;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Cthis) && x.b(this.f506do, ((Cthis) obj).f506do);
    }

    public int hashCode() {
        Bitmap bitmap = this.f506do;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.hashCode();
    }

    public String toString() {
        return "SuccessResult(frame=" + this.f506do + ')';
    }
}
