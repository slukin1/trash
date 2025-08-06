package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.i;
import kotlin.reflect.c;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

public final class PolymorphicSerializer<T> extends AbstractPolymorphicSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    public final c<T> f57593a;

    /* renamed from: b  reason: collision with root package name */
    public List<? extends Annotation> f57594b;

    /* renamed from: c  reason: collision with root package name */
    public final i f57595c;

    public PolymorphicSerializer(c<T> cVar) {
        this.f57593a = cVar;
        this.f57594b = CollectionsKt__CollectionsKt.k();
        this.f57595c = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.PUBLICATION, new PolymorphicSerializer$descriptor$2(this));
    }

    public c<T> e() {
        return this.f57593a;
    }

    public f getDescriptor() {
        return (f) this.f57595c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + e() + ')';
    }

    public PolymorphicSerializer(c<T> cVar, Annotation[] annotationArr) {
        this(cVar);
        this.f57594b = ArraysKt___ArraysJvmKt.d(annotationArr);
    }
}
