package kotlinx.serialization.internal;

import h10.a;
import kotlin.m;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class z1 implements b<m> {

    /* renamed from: a  reason: collision with root package name */
    public static final z1 f57805a = new z1();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57806b = j0.a("kotlin.UByte", a.B(kotlin.jvm.internal.m.f56786a));

    public byte a(c cVar) {
        return m.b(cVar.x(getDescriptor()).H());
    }

    public void b(d dVar, byte b11) {
        dVar.h(getDescriptor()).f(b11);
    }

    public /* bridge */ /* synthetic */ Object deserialize(c cVar) {
        return m.a(a(cVar));
    }

    public f getDescriptor() {
        return f57806b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((m) obj).g());
    }
}
