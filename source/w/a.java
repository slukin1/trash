package w;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.LifecycleOwner;
import java.util.Objects;
import w.c;

public final class a extends c.a {

    /* renamed from: a  reason: collision with root package name */
    public final LifecycleOwner f16701a;

    /* renamed from: b  reason: collision with root package name */
    public final CameraUseCaseAdapter.CameraId f16702b;

    public a(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        Objects.requireNonNull(lifecycleOwner, "Null lifecycleOwner");
        this.f16701a = lifecycleOwner;
        Objects.requireNonNull(cameraId, "Null cameraId");
        this.f16702b = cameraId;
    }

    public CameraUseCaseAdapter.CameraId b() {
        return this.f16702b;
    }

    public LifecycleOwner c() {
        return this.f16701a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c.a)) {
            return false;
        }
        c.a aVar = (c.a) obj;
        if (!this.f16701a.equals(aVar.c()) || !this.f16702b.equals(aVar.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f16701a.hashCode() ^ 1000003) * 1000003) ^ this.f16702b.hashCode();
    }

    public String toString() {
        return "Key{lifecycleOwner=" + this.f16701a + ", cameraId=" + this.f16702b + "}";
    }
}
