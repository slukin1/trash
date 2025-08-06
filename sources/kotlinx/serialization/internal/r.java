package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.a;
import kotlinx.serialization.encoding.d;

public abstract class r<Element, Collection, Builder> extends a<Element, Collection, Builder> {

    /* renamed from: a  reason: collision with root package name */
    public final b<Element> f57761a;

    public r(b<Element> bVar) {
        super((kotlin.jvm.internal.r) null);
        this.f57761a = bVar;
    }

    public /* synthetic */ r(b bVar, kotlin.jvm.internal.r rVar) {
        this(bVar);
    }

    public final void g(a aVar, Builder builder, int i11, int i12) {
        if (i12 >= 0) {
            for (int i13 = 0; i13 < i12; i13++) {
                h(aVar, i11 + i13, builder, false);
            }
            return;
        }
        throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
    }

    public abstract f getDescriptor();

    public void h(a aVar, int i11, Builder builder, boolean z11) {
        n(builder, i11, a.C0670a.c(aVar, getDescriptor(), i11, this.f57761a, (Object) null, 8, (Object) null));
    }

    public abstract void n(Builder builder, int i11, Element element);

    public void serialize(d dVar, Collection collection) {
        int e11 = e(collection);
        f descriptor = getDescriptor();
        kotlinx.serialization.encoding.b z11 = dVar.z(descriptor, e11);
        Iterator d11 = d(collection);
        for (int i11 = 0; i11 < e11; i11++) {
            z11.F(getDescriptor(), i11, this.f57761a, d11.next());
        }
        z11.c(descriptor);
    }
}
