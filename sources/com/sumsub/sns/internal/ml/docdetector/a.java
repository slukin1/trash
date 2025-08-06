package com.sumsub.sns.internal.ml.docdetector;

import android.graphics.Rect;
import kotlin.jvm.internal.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f35040a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35041b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35042c;

    /* renamed from: d  reason: collision with root package name */
    public final int f35043d;

    /* renamed from: e  reason: collision with root package name */
    public final float f35044e;

    /* renamed from: f  reason: collision with root package name */
    public final long f35045f;

    /* renamed from: g  reason: collision with root package name */
    public final long f35046g;

    public a(int i11, int i12, int i13, int i14, float f11, long j11, long j12) {
        this.f35040a = i11;
        this.f35041b = i12;
        this.f35042c = i13;
        this.f35043d = i14;
        this.f35044e = f11;
        this.f35045f = j11;
        this.f35046g = j12;
    }

    public final int a() {
        return this.f35040a;
    }

    public final int b() {
        return this.f35041b;
    }

    public final int c() {
        return this.f35042c;
    }

    public final int d() {
        return this.f35043d;
    }

    public final float e() {
        return this.f35044e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f35040a == aVar.f35040a && this.f35041b == aVar.f35041b && this.f35042c == aVar.f35042c && this.f35043d == aVar.f35043d && x.b(Float.valueOf(this.f35044e), Float.valueOf(aVar.f35044e)) && this.f35045f == aVar.f35045f && this.f35046g == aVar.f35046g;
    }

    public final long f() {
        return this.f35045f;
    }

    public final long g() {
        return this.f35046g;
    }

    public final float h() {
        return this.f35044e;
    }

    public int hashCode() {
        return (((((((((((this.f35040a * 31) + this.f35041b) * 31) + this.f35042c) * 31) + this.f35043d) * 31) + Float.floatToIntBits(this.f35044e)) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f35045f)) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f35046g);
    }

    public final int i() {
        return this.f35040a;
    }

    public final int j() {
        return this.f35041b;
    }

    public final int k() {
        return this.f35043d;
    }

    public final long l() {
        return this.f35045f;
    }

    public final Rect m() {
        int i11 = this.f35040a - (this.f35042c / 2);
        int i12 = this.f35041b - (this.f35043d / 2);
        return new Rect(i11, i12, this.f35042c + i11, this.f35043d + i12);
    }

    public final long n() {
        return this.f35046g;
    }

    public final int o() {
        return this.f35042c;
    }

    public String toString() {
        return "DetectionResult(cx=" + this.f35040a + ", cy=" + this.f35041b + ", width=" + this.f35042c + ", height=" + this.f35043d + ", confidence=" + this.f35044e + ", inferenceTimeMs=" + this.f35045f + ", timeMs=" + this.f35046g + ')';
    }

    public final a a(int i11, int i12, int i13, int i14, float f11, long j11, long j12) {
        return new a(i11, i12, i13, i14, f11, j11, j12);
    }

    public static /* synthetic */ a a(a aVar, int i11, int i12, int i13, int i14, float f11, long j11, long j12, int i15, Object obj) {
        a aVar2 = aVar;
        return aVar.a((i15 & 1) != 0 ? aVar2.f35040a : i11, (i15 & 2) != 0 ? aVar2.f35041b : i12, (i15 & 4) != 0 ? aVar2.f35042c : i13, (i15 & 8) != 0 ? aVar2.f35043d : i14, (i15 & 16) != 0 ? aVar2.f35044e : f11, (i15 & 32) != 0 ? aVar2.f35045f : j11, (i15 & 64) != 0 ? aVar2.f35046g : j12);
    }
}
