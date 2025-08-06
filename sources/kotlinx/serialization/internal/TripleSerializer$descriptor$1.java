package kotlinx.serialization.internal;

import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.a;

public final class TripleSerializer$descriptor$1 extends Lambda implements l<a, Unit> {
    public final /* synthetic */ TripleSerializer<A, B, C> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TripleSerializer$descriptor$1(TripleSerializer<A, B, C> tripleSerializer) {
        super(1);
        this.this$0 = tripleSerializer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((a) obj);
        return Unit.f56620a;
    }

    public final void invoke(a aVar) {
        a aVar2 = aVar;
        a.b(aVar2, "first", this.this$0.f57684a.getDescriptor(), (List) null, false, 12, (Object) null);
        a.b(aVar2, "second", this.this$0.f57685b.getDescriptor(), (List) null, false, 12, (Object) null);
        a.b(aVar2, "third", this.this$0.f57686c.getDescriptor(), (List) null, false, 12, (Object) null);
    }
}
