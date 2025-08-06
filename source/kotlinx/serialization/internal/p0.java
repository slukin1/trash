package kotlinx.serialization.internal;

import kotlin.jvm.internal.r;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.b;
import kotlinx.serialization.encoding.a;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public abstract class p0<K, V, R> implements b<R> {

    /* renamed from: a  reason: collision with root package name */
    public final b<K> f57754a;

    /* renamed from: b  reason: collision with root package name */
    public final b<V> f57755b;

    public p0(b<K> bVar, b<V> bVar2) {
        this.f57754a = bVar;
        this.f57755b = bVar2;
    }

    public /* synthetic */ p0(b bVar, b bVar2, r rVar) {
        this(bVar, bVar2);
    }

    public abstract K a(R r11);

    public abstract V b(R r11);

    public abstract R c(K k11, V v11);

    public R deserialize(c cVar) {
        a b11 = cVar.b(getDescriptor());
        if (b11.k()) {
            a aVar = b11;
            return c(a.C0670a.c(aVar, getDescriptor(), 0, this.f57754a, (Object) null, 8, (Object) null), a.C0670a.c(aVar, getDescriptor(), 1, this.f57755b, (Object) null, 8, (Object) null));
        }
        Object a11 = w1.f57783a;
        Object a12 = w1.f57783a;
        while (true) {
            int w11 = b11.w(getDescriptor());
            if (w11 == -1) {
                b11.c(getDescriptor());
                if (a11 == w1.f57783a) {
                    throw new SerializationException("Element 'key' is missing");
                } else if (a12 != w1.f57783a) {
                    return c(a11, a12);
                } else {
                    throw new SerializationException("Element 'value' is missing");
                }
            } else if (w11 == 0) {
                a11 = a.C0670a.c(b11, getDescriptor(), 0, this.f57754a, (Object) null, 8, (Object) null);
            } else if (w11 == 1) {
                a12 = a.C0670a.c(b11, getDescriptor(), 1, this.f57755b, (Object) null, 8, (Object) null);
            } else {
                throw new SerializationException("Invalid index: " + w11);
            }
        }
    }

    public void serialize(d dVar, R r11) {
        kotlinx.serialization.encoding.b b11 = dVar.b(getDescriptor());
        b11.F(getDescriptor(), 0, this.f57754a, a(r11));
        b11.F(getDescriptor(), 1, this.f57755b, b(r11));
        b11.c(getDescriptor());
    }
}
