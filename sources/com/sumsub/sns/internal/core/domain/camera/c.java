package com.sumsub.sns.internal.core.domain.camera;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final float f33564a;

    /* renamed from: b  reason: collision with root package name */
    public final float f33565b;

    /* renamed from: c  reason: collision with root package name */
    public final float f33566c;

    public c() {
        this(0.0f, 0.0f, 0.0f, 7, (r) null);
    }

    public final float a() {
        return this.f33564a;
    }

    public final float b() {
        return this.f33565b;
    }

    public final float c() {
        return this.f33566c;
    }

    public final float d() {
        return this.f33564a;
    }

    public final float e() {
        return this.f33566c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return x.b(Float.valueOf(this.f33564a), Float.valueOf(cVar.f33564a)) && x.b(Float.valueOf(this.f33565b), Float.valueOf(cVar.f33565b)) && x.b(Float.valueOf(this.f33566c), Float.valueOf(cVar.f33566c));
    }

    public final float f() {
        return this.f33565b;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f33564a) * 31) + Float.floatToIntBits(this.f33565b)) * 31) + Float.floatToIntBits(this.f33566c);
    }

    public String toString() {
        return "Exposure(current=" + this.f33564a + ", min=" + this.f33565b + ", max=" + this.f33566c + ')';
    }

    public c(float f11, float f12, float f13) {
        this.f33564a = f11;
        this.f33565b = f12;
        this.f33566c = f13;
    }

    public final c a(float f11, float f12, float f13) {
        return new c(f11, f12, f13);
    }

    public static /* synthetic */ c a(c cVar, float f11, float f12, float f13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = cVar.f33564a;
        }
        if ((i11 & 2) != 0) {
            f12 = cVar.f33565b;
        }
        if ((i11 & 4) != 0) {
            f13 = cVar.f33566c;
        }
        return cVar.a(f11, f12, f13);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(float f11, float f12, float f13, int i11, r rVar) {
        this((i11 & 1) != 0 ? 0.0f : f11, (i11 & 2) != 0 ? 0.0f : f12, (i11 & 4) != 0 ? 0.0f : f13);
    }
}
