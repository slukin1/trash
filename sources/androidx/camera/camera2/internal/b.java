package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.Objects;

public final class b extends Camera2CameraImpl.h {

    /* renamed from: a  reason: collision with root package name */
    public final String f5013a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f5014b;

    /* renamed from: c  reason: collision with root package name */
    public final SessionConfig f5015c;

    /* renamed from: d  reason: collision with root package name */
    public final UseCaseConfig<?> f5016d;

    /* renamed from: e  reason: collision with root package name */
    public final Size f5017e;

    public b(String str, Class<?> cls, SessionConfig sessionConfig, UseCaseConfig<?> useCaseConfig, Size size) {
        Objects.requireNonNull(str, "Null useCaseId");
        this.f5013a = str;
        Objects.requireNonNull(cls, "Null useCaseType");
        this.f5014b = cls;
        Objects.requireNonNull(sessionConfig, "Null sessionConfig");
        this.f5015c = sessionConfig;
        Objects.requireNonNull(useCaseConfig, "Null useCaseConfig");
        this.f5016d = useCaseConfig;
        this.f5017e = size;
    }

    public SessionConfig c() {
        return this.f5015c;
    }

    public Size d() {
        return this.f5017e;
    }

    public UseCaseConfig<?> e() {
        return this.f5016d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Camera2CameraImpl.h)) {
            return false;
        }
        Camera2CameraImpl.h hVar = (Camera2CameraImpl.h) obj;
        if (this.f5013a.equals(hVar.f()) && this.f5014b.equals(hVar.g()) && this.f5015c.equals(hVar.c()) && this.f5016d.equals(hVar.e())) {
            Size size = this.f5017e;
            if (size == null) {
                if (hVar.d() == null) {
                    return true;
                }
            } else if (size.equals(hVar.d())) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f5013a;
    }

    public Class<?> g() {
        return this.f5014b;
    }

    public int hashCode() {
        int hashCode = (((((((this.f5013a.hashCode() ^ 1000003) * 1000003) ^ this.f5014b.hashCode()) * 1000003) ^ this.f5015c.hashCode()) * 1000003) ^ this.f5016d.hashCode()) * 1000003;
        Size size = this.f5017e;
        return hashCode ^ (size == null ? 0 : size.hashCode());
    }

    public String toString() {
        return "UseCaseInfo{useCaseId=" + this.f5013a + ", useCaseType=" + this.f5014b + ", sessionConfig=" + this.f5015c + ", useCaseConfig=" + this.f5016d + ", surfaceResolution=" + this.f5017e + "}";
    }
}
