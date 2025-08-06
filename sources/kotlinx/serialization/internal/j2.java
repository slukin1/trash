package kotlinx.serialization.internal;

import kotlin.Unit;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class j2 implements b<Unit> {

    /* renamed from: b  reason: collision with root package name */
    public static final j2 f57732b = new j2();

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ObjectSerializer<Unit> f57733a = new ObjectSerializer<>("kotlin.Unit", Unit.f56620a);

    public void a(c cVar) {
        this.f57733a.deserialize(cVar);
    }

    /* renamed from: b */
    public void serialize(d dVar, Unit unit) {
        this.f57733a.serialize(dVar, unit);
    }

    public /* bridge */ /* synthetic */ Object deserialize(c cVar) {
        a(cVar);
        return Unit.f56620a;
    }

    public f getDescriptor() {
        return this.f57733a.getDescriptor();
    }
}
