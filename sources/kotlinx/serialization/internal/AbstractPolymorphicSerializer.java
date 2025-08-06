package kotlinx.serialization.internal;

import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.b;
import kotlinx.serialization.d;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.a;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.g;

public abstract class AbstractPolymorphicSerializer<T> implements b<T> {
    public final T b(a aVar) {
        return a.C0670a.c(aVar, getDescriptor(), 1, d.a(this, aVar, aVar.i(getDescriptor(), 0)), (Object) null, 8, (Object) null);
    }

    public kotlinx.serialization.a<T> c(a aVar, String str) {
        return aVar.a().d(e(), str);
    }

    public g<T> d(kotlinx.serialization.encoding.d dVar, T t11) {
        return dVar.a().e(e(), t11);
    }

    public final T deserialize(c cVar) {
        T t11;
        f descriptor = getDescriptor();
        a b11 = cVar.b(descriptor);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (b11.k()) {
            t11 = b(b11);
        } else {
            t11 = null;
            while (true) {
                int w11 = b11.w(getDescriptor());
                if (w11 != -1) {
                    if (w11 == 0) {
                        ref$ObjectRef.element = b11.i(getDescriptor(), w11);
                    } else if (w11 != 1) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Invalid index in polymorphic deserialization of ");
                        String str = (String) ref$ObjectRef.element;
                        if (str == null) {
                            str = "unknown class";
                        }
                        sb2.append(str);
                        sb2.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                        sb2.append(w11);
                        throw new SerializationException(sb2.toString());
                    } else {
                        T t12 = ref$ObjectRef.element;
                        if (t12 != null) {
                            ref$ObjectRef.element = t12;
                            kotlinx.serialization.a a11 = d.a(this, b11, (String) t12);
                            t11 = a.C0670a.c(b11, getDescriptor(), w11, a11, (Object) null, 8, (Object) null);
                        } else {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                        }
                    }
                } else if (t11 == null) {
                    throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) ref$ObjectRef.element)).toString());
                }
            }
        }
        b11.c(descriptor);
        return t11;
    }

    public abstract kotlin.reflect.c<T> e();

    public final void serialize(kotlinx.serialization.encoding.d dVar, T t11) {
        g b11 = d.b(this, dVar, t11);
        f descriptor = getDescriptor();
        kotlinx.serialization.encoding.b b12 = dVar.b(descriptor);
        b12.p(getDescriptor(), 0, b11.getDescriptor().h());
        b12.F(getDescriptor(), 1, b11, t11);
        b12.c(descriptor);
    }
}
