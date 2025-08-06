package androidx.camera.video;

import androidx.camera.video.o;
import java.util.Objects;

public final class e extends o.b {

    /* renamed from: b  reason: collision with root package name */
    public final v f5937b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5938c;

    public e(v vVar, int i11) {
        Objects.requireNonNull(vVar, "Null fallbackQuality");
        this.f5937b = vVar;
        this.f5938c = i11;
    }

    public v b() {
        return this.f5937b;
    }

    public int c() {
        return this.f5938c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o.b)) {
            return false;
        }
        o.b bVar = (o.b) obj;
        if (!this.f5937b.equals(bVar.b()) || this.f5938c != bVar.c()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f5937b.hashCode() ^ 1000003) * 1000003) ^ this.f5938c;
    }

    public String toString() {
        return "RuleStrategy{fallbackQuality=" + this.f5937b + ", fallbackRule=" + this.f5938c + "}";
    }
}
