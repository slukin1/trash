package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.i;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.a;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class ObjectSerializer<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f57664a;

    /* renamed from: b  reason: collision with root package name */
    public List<? extends Annotation> f57665b = CollectionsKt__CollectionsKt.k();

    /* renamed from: c  reason: collision with root package name */
    public final i f57666c;

    public ObjectSerializer(String str, T t11) {
        this.f57664a = t11;
        this.f57666c = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.PUBLICATION, new ObjectSerializer$descriptor$2(str, this));
    }

    public T deserialize(c cVar) {
        f descriptor = getDescriptor();
        a b11 = cVar.b(descriptor);
        int w11 = b11.w(getDescriptor());
        if (w11 == -1) {
            Unit unit = Unit.f56620a;
            b11.c(descriptor);
            return this.f57664a;
        }
        throw new SerializationException("Unexpected index " + w11);
    }

    public f getDescriptor() {
        return (f) this.f57666c.getValue();
    }

    public void serialize(d dVar, T t11) {
        dVar.b(getDescriptor()).c(getDescriptor());
    }
}
