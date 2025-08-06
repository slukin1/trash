package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.r;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.PrimitiveArrayBuilder;

public abstract class l1<Element, Array, Builder extends PrimitiveArrayBuilder<Array>> extends r<Element, Array, Builder> {

    /* renamed from: b  reason: collision with root package name */
    public final f f57741b;

    public l1(b<Element> bVar) {
        super(bVar, (r) null);
        this.f57741b = new k1(bVar.getDescriptor());
    }

    public final Iterator<Element> d(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    public final Array deserialize(c cVar) {
        return f(cVar, null);
    }

    public final f getDescriptor() {
        return this.f57741b;
    }

    /* renamed from: o */
    public final Builder a() {
        return (PrimitiveArrayBuilder) k(r());
    }

    /* renamed from: p */
    public final int b(Builder builder) {
        return builder.d();
    }

    /* renamed from: q */
    public final void c(Builder builder, int i11) {
        builder.b(i11);
    }

    public abstract Array r();

    /* renamed from: s */
    public final void n(Builder builder, int i11, Element element) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    public final void serialize(d dVar, Array array) {
        int e11 = e(array);
        f fVar = this.f57741b;
        kotlinx.serialization.encoding.b z11 = dVar.z(fVar, e11);
        u(z11, array, e11);
        z11.c(fVar);
    }

    /* renamed from: t */
    public final Array l(Builder builder) {
        return builder.a();
    }

    public abstract void u(kotlinx.serialization.encoding.b bVar, Array array, int i11);
}
