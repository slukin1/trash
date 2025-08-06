package com.google.android.play.integrity.internal;

final class e extends f {

    /* renamed from: a  reason: collision with root package name */
    private final int f66885a;

    /* renamed from: b  reason: collision with root package name */
    private final long f66886b;

    public e(int i11, long j11) {
        this.f66885a = i11;
        this.f66886b = j11;
    }

    public final int a() {
        return this.f66885a;
    }

    public final long b() {
        return this.f66886b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.f66885a == fVar.a() && this.f66886b == fVar.b();
        }
    }

    public final int hashCode() {
        long j11 = this.f66886b;
        return ((this.f66885a ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public final String toString() {
        int i11 = this.f66885a;
        long j11 = this.f66886b;
        return "EventRecord{eventType=" + i11 + ", eventTimestamp=" + j11 + "}";
    }
}
