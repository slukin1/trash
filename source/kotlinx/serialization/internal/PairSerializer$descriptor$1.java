package kotlinx.serialization.internal;

import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.a;

public final class PairSerializer$descriptor$1 extends Lambda implements l<a, Unit> {
    public final /* synthetic */ b<K> $keySerializer;
    public final /* synthetic */ b<V> $valueSerializer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PairSerializer$descriptor$1(b<K> bVar, b<V> bVar2) {
        super(1);
        this.$keySerializer = bVar;
        this.$valueSerializer = bVar2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((a) obj);
        return Unit.f56620a;
    }

    public final void invoke(a aVar) {
        a aVar2 = aVar;
        a.b(aVar2, "first", this.$keySerializer.getDescriptor(), (List) null, false, 12, (Object) null);
        a.b(aVar2, "second", this.$valueSerializer.getDescriptor(), (List) null, false, 12, (Object) null);
    }
}
