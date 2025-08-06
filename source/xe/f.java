package xe;

import kotlin.jvm.internal.x;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f26367a;

    /* renamed from: b  reason: collision with root package name */
    public int f26368b;

    public f(String str, int i11) {
        this.f26367a = str;
        this.f26368b = i11;
    }

    public final int a() {
        return this.f26368b;
    }

    public final String b() {
        return this.f26367a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return x.b(this.f26367a, fVar.f26367a) && this.f26368b == fVar.f26368b;
    }

    public int hashCode() {
        return (this.f26367a.hashCode() * 31) + this.f26368b;
    }

    public String toString() {
        return "JumpEvent(pageName=" + this.f26367a + ", category=" + this.f26368b + ')';
    }
}
