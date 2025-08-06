package androidx.camera.video.internal.encoder;

public final class e extends j1 {

    /* renamed from: e  reason: collision with root package name */
    public final int f6196e;

    /* renamed from: f  reason: collision with root package name */
    public final int f6197f;

    /* renamed from: g  reason: collision with root package name */
    public final int f6198g;

    public e(int i11, int i12, int i13) {
        this.f6196e = i11;
        this.f6197f = i12;
        this.f6198g = i13;
    }

    public int b() {
        return this.f6198g;
    }

    public int c() {
        return this.f6196e;
    }

    public int d() {
        return this.f6197f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j1)) {
            return false;
        }
        j1 j1Var = (j1) obj;
        if (this.f6196e == j1Var.c() && this.f6197f == j1Var.d() && this.f6198g == j1Var.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f6196e ^ 1000003) * 1000003) ^ this.f6197f) * 1000003) ^ this.f6198g;
    }

    public String toString() {
        return "VideoEncoderDataSpace{standard=" + this.f6196e + ", transfer=" + this.f6197f + ", range=" + this.f6198g + "}";
    }
}
