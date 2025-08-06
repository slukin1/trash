package kotlin.collections;

import kotlin.jvm.internal.x;

public final class m<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f56655a;

    /* renamed from: b  reason: collision with root package name */
    public final T f56656b;

    public m(int i11, T t11) {
        this.f56655a = i11;
        this.f56656b = t11;
    }

    public final int a() {
        return this.f56655a;
    }

    public final T b() {
        return this.f56656b;
    }

    public final int c() {
        return this.f56655a;
    }

    public final T d() {
        return this.f56656b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f56655a == mVar.f56655a && x.b(this.f56656b, mVar.f56656b);
    }

    public int hashCode() {
        int i11 = this.f56655a * 31;
        T t11 = this.f56656b;
        return i11 + (t11 == null ? 0 : t11.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f56655a + ", value=" + this.f56656b + ')';
    }
}
