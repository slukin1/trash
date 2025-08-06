package kotlinx.serialization.json.internal;

import d10.l;
import java.util.List;
import kotlin.jvm.internal.x;
import kotlin.reflect.c;
import kotlinx.serialization.a;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.d;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.descriptors.i;
import kotlinx.serialization.g;
import kotlinx.serialization.modules.SerializersModuleCollector;

public final class i0 implements SerializersModuleCollector {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f57907a;

    /* renamed from: b  reason: collision with root package name */
    public final String f57908b;

    public i0(boolean z11, String str) {
        this.f57907a = z11;
        this.f57908b = str;
    }

    public <T> void a(c<T> cVar, l<? super List<? extends b<?>>, ? extends b<?>> lVar) {
    }

    public <Base> void b(c<Base> cVar, l<? super String, ? extends a<? extends Base>> lVar) {
    }

    public <Base, Sub extends Base> void c(c<Base> cVar, c<Sub> cVar2, b<Sub> bVar) {
        f descriptor = bVar.getDescriptor();
        g(descriptor, cVar2);
        if (!this.f57907a) {
            f(descriptor, cVar2);
        }
    }

    public <T> void d(c<T> cVar, b<T> bVar) {
        SerializersModuleCollector.DefaultImpls.a(this, cVar, bVar);
    }

    public <Base> void e(c<Base> cVar, l<? super Base, ? extends g<? super Base>> lVar) {
    }

    public final void f(f fVar, c<?> cVar) {
        int e11 = fVar.e();
        int i11 = 0;
        while (i11 < e11) {
            String f11 = fVar.f(i11);
            if (!x.b(f11, this.f57908b)) {
                i11++;
            } else {
                throw new IllegalArgumentException("Polymorphic serializer for " + cVar + " has property '" + f11 + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    public final void g(f fVar, c<?> cVar) {
        h kind = fVar.getKind();
        if ((kind instanceof d) || x.b(kind, h.a.f57645a)) {
            throw new IllegalArgumentException("Serializer for " + cVar.f() + " can't be registered as a subclass for polymorphic serialization because its kind " + kind + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        } else if (!this.f57907a) {
            if (x.b(kind, i.b.f57648a) || x.b(kind, i.c.f57649a) || (kind instanceof e) || (kind instanceof h.b)) {
                throw new IllegalArgumentException("Serializer for " + cVar.f() + " of kind " + kind + " cannot be serialized polymorphically with class discriminator.");
            }
        }
    }
}
