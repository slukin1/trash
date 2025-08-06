package kotlinx.serialization.json.internal;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.g;

public final class AbstractJsonTreeEncoder$beginStructure$consumer$1 extends Lambda implements l<g, Unit> {
    public final /* synthetic */ AbstractJsonTreeEncoder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractJsonTreeEncoder$beginStructure$consumer$1(AbstractJsonTreeEncoder abstractJsonTreeEncoder) {
        super(1);
        this.this$0 = abstractJsonTreeEncoder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((g) obj);
        return Unit.f56620a;
    }

    public final void invoke(g gVar) {
        AbstractJsonTreeEncoder abstractJsonTreeEncoder = this.this$0;
        abstractJsonTreeEncoder.y0(AbstractJsonTreeEncoder.h0(abstractJsonTreeEncoder), gVar);
    }
}
