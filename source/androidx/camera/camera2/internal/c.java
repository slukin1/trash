package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.p3;

public final class c extends p3.b {

    /* renamed from: a  reason: collision with root package name */
    public final int f5034a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5035b;

    public c(int i11, int i12) {
        this.f5034a = i11;
        this.f5035b = i12;
    }

    public int a() {
        return this.f5034a;
    }

    public int b() {
        return this.f5035b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p3.b)) {
            return false;
        }
        p3.b bVar = (p3.b) obj;
        if (this.f5034a == bVar.a() && this.f5035b == bVar.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f5034a ^ 1000003) * 1000003) ^ this.f5035b;
    }

    public String toString() {
        return "FeatureSettings{cameraMode=" + this.f5034a + ", requiredMaxBitDepth=" + this.f5035b + "}";
    }
}
