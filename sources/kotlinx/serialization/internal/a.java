package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.r;
import kotlinx.serialization.b;
import kotlinx.serialization.encoding.c;

public abstract class a<Element, Collection, Builder> implements b<Collection> {
    public a() {
    }

    public /* synthetic */ a(r rVar) {
        this();
    }

    public static /* synthetic */ void i(a aVar, kotlinx.serialization.encoding.a aVar2, int i11, Object obj, boolean z11, int i12, Object obj2) {
        if (obj2 == null) {
            if ((i12 & 8) != 0) {
                z11 = true;
            }
            aVar.h(aVar2, i11, obj, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
    }

    public abstract Builder a();

    public abstract int b(Builder builder);

    public abstract void c(Builder builder, int i11);

    public abstract Iterator<Element> d(Collection collection);

    public Collection deserialize(c cVar) {
        return f(cVar, (Object) null);
    }

    public abstract int e(Collection collection);

    public final Collection f(c cVar, Collection collection) {
        Object obj;
        if (collection == null || (obj = k(collection)) == null) {
            obj = a();
        }
        int b11 = b(obj);
        kotlinx.serialization.encoding.a b12 = cVar.b(getDescriptor());
        if (!b12.k()) {
            while (true) {
                int w11 = b12.w(getDescriptor());
                if (w11 == -1) {
                    break;
                }
                i(this, b12, b11 + w11, obj, false, 8, (Object) null);
            }
        } else {
            g(b12, obj, b11, j(b12, obj));
        }
        b12.c(getDescriptor());
        return l(obj);
    }

    public abstract void g(kotlinx.serialization.encoding.a aVar, Builder builder, int i11, int i12);

    public abstract void h(kotlinx.serialization.encoding.a aVar, int i11, Builder builder, boolean z11);

    public final int j(kotlinx.serialization.encoding.a aVar, Builder builder) {
        int v11 = aVar.v(getDescriptor());
        c(builder, v11);
        return v11;
    }

    public abstract Builder k(Collection collection);

    public abstract Collection l(Builder builder);
}
