package androidx.camera.video;

import androidx.camera.video.v;
import java.util.Objects;

public final class j extends v.b {

    /* renamed from: j  reason: collision with root package name */
    public final int f6294j;

    /* renamed from: k  reason: collision with root package name */
    public final String f6295k;

    public j(int i11, String str) {
        this.f6294j = i11;
        Objects.requireNonNull(str, "Null name");
        this.f6295k = str;
    }

    public String c() {
        return this.f6295k;
    }

    public int d() {
        return this.f6294j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.b)) {
            return false;
        }
        v.b bVar = (v.b) obj;
        if (this.f6294j != bVar.d() || !this.f6295k.equals(bVar.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f6294j ^ 1000003) * 1000003) ^ this.f6295k.hashCode();
    }

    public String toString() {
        return "ConstantQuality{value=" + this.f6294j + ", name=" + this.f6295k + "}";
    }
}
