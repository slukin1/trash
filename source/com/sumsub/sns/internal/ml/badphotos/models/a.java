package com.sumsub.sns.internal.ml.badphotos.models;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f34967a;

    /* renamed from: b  reason: collision with root package name */
    public final float f34968b;

    /* renamed from: c  reason: collision with root package name */
    public final long f34969c;

    public a(String str, float f11, long j11) {
        this.f34967a = str;
        this.f34968b = f11;
        this.f34969c = j11;
    }

    public final long a() {
        return this.f34969c;
    }

    public final String b() {
        return this.f34967a;
    }

    public final float c() {
        return this.f34968b;
    }

    public String toString() {
        return "UnsatisfactoryPhotosDetectorResult(res=" + this.f34968b + ')';
    }
}
