package com.jumio.commons.camera;

import android.graphics.Rect;
import java.io.Serializable;
import kotlin.jvm.internal.r;

public final class Size implements Serializable {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public int f38977a;

    /* renamed from: b  reason: collision with root package name */
    public int f38978b;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public Size(int i11, int i12) {
        this.f38977a = i11;
        this.f38978b = i12;
    }

    public static /* synthetic */ Size copy$default(Size size, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = size.f38977a;
        }
        if ((i13 & 2) != 0) {
            i12 = size.f38978b;
        }
        return size.copy(i11, i12);
    }

    public final int component1() {
        return this.f38977a;
    }

    public final int component2() {
        return this.f38978b;
    }

    public final Size copy(int i11, int i12) {
        return new Size(i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f38977a == size.f38977a && this.f38978b == size.f38978b;
    }

    public final int getHeight() {
        return this.f38978b;
    }

    public final int getWidth() {
        return this.f38977a;
    }

    public int hashCode() {
        return this.f38978b + (this.f38977a * 31);
    }

    public final boolean isEmpty() {
        return this.f38977a == 0 && this.f38978b == 0;
    }

    public final void setHeight(int i11) {
        this.f38978b = i11;
    }

    public final void setWidth(int i11) {
        this.f38977a = i11;
    }

    public final Rect toRect() {
        return new Rect(0, 0, this.f38977a, this.f38978b);
    }

    public String toString() {
        int i11 = this.f38977a;
        int i12 = this.f38978b;
        return "Size(width=" + i11 + ", height=" + i12 + ")";
    }
}
