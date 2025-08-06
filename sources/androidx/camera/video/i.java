package androidx.camera.video;

import androidx.camera.video.x;
import java.util.Objects;

public final class i extends x.a {

    /* renamed from: a  reason: collision with root package name */
    public final v f5969a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5970b;

    public i(v vVar, int i11) {
        Objects.requireNonNull(vVar, "Null quality");
        this.f5969a = vVar;
        this.f5970b = i11;
    }

    public int a() {
        return this.f5970b;
    }

    public v b() {
        return this.f5969a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x.a)) {
            return false;
        }
        x.a aVar = (x.a) obj;
        if (!this.f5969a.equals(aVar.b()) || this.f5970b != aVar.a()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f5969a.hashCode() ^ 1000003) * 1000003) ^ this.f5970b;
    }

    public String toString() {
        return "QualityRatio{quality=" + this.f5969a + ", aspectRatio=" + this.f5970b + "}";
    }
}
