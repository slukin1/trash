package androidx.camera.video;

import java.util.Objects;

public final class l extends a1 {

    /* renamed from: a  reason: collision with root package name */
    public final long f6308a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6309b;

    /* renamed from: c  reason: collision with root package name */
    public final b f6310c;

    public l(long j11, long j12, b bVar) {
        this.f6308a = j11;
        this.f6309b = j12;
        Objects.requireNonNull(bVar, "Null audioStats");
        this.f6310c = bVar;
    }

    public b a() {
        return this.f6310c;
    }

    public long b() {
        return this.f6309b;
    }

    public long c() {
        return this.f6308a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a1)) {
            return false;
        }
        a1 a1Var = (a1) obj;
        if (this.f6308a == a1Var.c() && this.f6309b == a1Var.b() && this.f6310c.equals(a1Var.a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j11 = this.f6308a;
        long j12 = this.f6309b;
        return ((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003) ^ this.f6310c.hashCode();
    }

    public String toString() {
        return "RecordingStats{recordedDurationNanos=" + this.f6308a + ", numBytesRecorded=" + this.f6309b + ", audioStats=" + this.f6310c + "}";
    }
}
