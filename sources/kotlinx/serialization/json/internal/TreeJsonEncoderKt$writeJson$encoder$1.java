package kotlinx.serialization.json.internal;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.json.g;

public final class TreeJsonEncoderKt$writeJson$encoder$1 extends Lambda implements l<g, Unit> {
    public final /* synthetic */ Ref$ObjectRef<g> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TreeJsonEncoderKt$writeJson$encoder$1(Ref$ObjectRef<g> ref$ObjectRef) {
        super(1);
        this.$result = ref$ObjectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((g) obj);
        return Unit.f56620a;
    }

    public final void invoke(g gVar) {
        this.$result.element = gVar;
    }
}
