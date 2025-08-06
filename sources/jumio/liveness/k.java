package jumio.liveness;

import kotlin.jvm.internal.x;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final j f56486a;

    /* renamed from: b  reason: collision with root package name */
    public final r f56487b;

    public k(j jVar, r rVar) {
        this.f56486a = jVar;
        this.f56487b = rVar;
    }

    public final void a() {
        this.f56486a.f56482b.delete();
    }

    public final j b() {
        return this.f56486a;
    }

    public final r c() {
        return this.f56487b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return x.b(this.f56486a, kVar.f56486a) && x.b(this.f56487b, kVar.f56487b);
    }

    public final int hashCode() {
        return this.f56487b.hashCode() + (this.f56486a.hashCode() * 31);
    }

    public final String toString() {
        j jVar = this.f56486a;
        r rVar = this.f56487b;
        return "LivenessImage(frame=" + jVar + ", poseEvent=" + rVar + ")";
    }

    public /* synthetic */ k(j jVar) {
        this(jVar, new r(0));
    }
}
