package kotlinx.coroutines;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.x;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final Object f57585a;

    /* renamed from: b  reason: collision with root package name */
    public final l<Throwable, Unit> f57586b;

    public z(Object obj, l<? super Throwable, Unit> lVar) {
        this.f57585a = obj;
        this.f57586b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return x.b(this.f57585a, zVar.f57585a) && x.b(this.f57586b, zVar.f57586b);
    }

    public int hashCode() {
        Object obj = this.f57585a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f57586b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f57585a + ", onCancellation=" + this.f57586b + ')';
    }
}
