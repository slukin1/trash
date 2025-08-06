package kotlinx.serialization.internal;

import kotlin.jvm.internal.x;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class d1<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final b<T> f57705a;

    /* renamed from: b  reason: collision with root package name */
    public final f f57706b;

    public d1(b<T> bVar) {
        this.f57705a = bVar;
        this.f57706b = new p1(bVar.getDescriptor());
    }

    public T deserialize(c cVar) {
        return cVar.D() ? cVar.G(this.f57705a) : cVar.g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && d1.class == obj.getClass() && x.b(this.f57705a, ((d1) obj).f57705a);
    }

    public f getDescriptor() {
        return this.f57706b;
    }

    public int hashCode() {
        return this.f57705a.hashCode();
    }

    public void serialize(d dVar, T t11) {
        if (t11 != null) {
            dVar.E();
            dVar.e(this.f57705a, t11);
            return;
        }
        dVar.B();
    }
}
