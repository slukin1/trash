package kotlinx.serialization.internal;

import kotlin.Triple;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.a;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class TripleSerializer<A, B, C> implements b<Triple<? extends A, ? extends B, ? extends C>> {

    /* renamed from: a  reason: collision with root package name */
    public final b<A> f57684a;

    /* renamed from: b  reason: collision with root package name */
    public final b<B> f57685b;

    /* renamed from: c  reason: collision with root package name */
    public final b<C> f57686c;

    /* renamed from: d  reason: collision with root package name */
    public final f f57687d = SerialDescriptorsKt.b("kotlin.Triple", new f[0], new TripleSerializer$descriptor$1(this));

    public TripleSerializer(b<A> bVar, b<B> bVar2, b<C> bVar3) {
        this.f57684a = bVar;
        this.f57685b = bVar2;
        this.f57686c = bVar3;
    }

    public final Triple<A, B, C> d(a aVar) {
        Object c11 = a.C0670a.c(aVar, getDescriptor(), 0, this.f57684a, (Object) null, 8, (Object) null);
        Object c12 = a.C0670a.c(aVar, getDescriptor(), 1, this.f57685b, (Object) null, 8, (Object) null);
        Object c13 = a.C0670a.c(aVar, getDescriptor(), 2, this.f57686c, (Object) null, 8, (Object) null);
        aVar.c(getDescriptor());
        return new Triple<>(c11, c12, c13);
    }

    public final Triple<A, B, C> e(a aVar) {
        Object a11 = w1.f57783a;
        Object a12 = w1.f57783a;
        Object a13 = w1.f57783a;
        while (true) {
            int w11 = aVar.w(getDescriptor());
            if (w11 == -1) {
                aVar.c(getDescriptor());
                if (a11 == w1.f57783a) {
                    throw new SerializationException("Element 'first' is missing");
                } else if (a12 == w1.f57783a) {
                    throw new SerializationException("Element 'second' is missing");
                } else if (a13 != w1.f57783a) {
                    return new Triple<>(a11, a12, a13);
                } else {
                    throw new SerializationException("Element 'third' is missing");
                }
            } else if (w11 == 0) {
                a11 = a.C0670a.c(aVar, getDescriptor(), 0, this.f57684a, (Object) null, 8, (Object) null);
            } else if (w11 == 1) {
                a12 = a.C0670a.c(aVar, getDescriptor(), 1, this.f57685b, (Object) null, 8, (Object) null);
            } else if (w11 == 2) {
                a13 = a.C0670a.c(aVar, getDescriptor(), 2, this.f57686c, (Object) null, 8, (Object) null);
            } else {
                throw new SerializationException("Unexpected index " + w11);
            }
        }
    }

    /* renamed from: f */
    public Triple<A, B, C> deserialize(c cVar) {
        a b11 = cVar.b(getDescriptor());
        if (b11.k()) {
            return d(b11);
        }
        return e(b11);
    }

    /* renamed from: g */
    public void serialize(d dVar, Triple<? extends A, ? extends B, ? extends C> triple) {
        kotlinx.serialization.encoding.b b11 = dVar.b(getDescriptor());
        b11.F(getDescriptor(), 0, this.f57684a, triple.getFirst());
        b11.F(getDescriptor(), 1, this.f57685b, triple.getSecond());
        b11.F(getDescriptor(), 2, this.f57686c, triple.getThird());
        b11.c(getDescriptor());
    }

    public f getDescriptor() {
        return this.f57687d;
    }
}
