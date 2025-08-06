package kotlinx.serialization;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.reflect.c;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.internal.g1;
import kotlinx.serialization.modules.d;

public final class ContextualSerializer<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final c<T> f57589a;

    /* renamed from: b  reason: collision with root package name */
    public final b<T> f57590b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b<?>> f57591c;

    /* renamed from: d  reason: collision with root package name */
    public final f f57592d;

    public ContextualSerializer(c<T> cVar, b<T> bVar, b<?>[] bVarArr) {
        this.f57589a = cVar;
        this.f57590b = bVar;
        this.f57591c = ArraysKt___ArraysJvmKt.d(bVarArr);
        this.f57592d = b.c(SerialDescriptorsKt.c("kotlinx.serialization.ContextualSerializer", h.a.f57645a, new f[0], new ContextualSerializer$descriptor$1(this)), cVar);
    }

    public final b<T> b(d dVar) {
        b<T> b11 = dVar.b(this.f57589a, this.f57591c);
        if (b11 != null || (b11 = this.f57590b) != null) {
            return b11;
        }
        g1.f(this.f57589a);
        throw new KotlinNothingValueException();
    }

    public T deserialize(kotlinx.serialization.encoding.c cVar) {
        return cVar.G(b(cVar.a()));
    }

    public f getDescriptor() {
        return this.f57592d;
    }

    public void serialize(kotlinx.serialization.encoding.d dVar, T t11) {
        dVar.e(b(dVar.a()), t11);
    }
}
