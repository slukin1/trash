package kotlin.sequences;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesKt$onEach$1 extends Lambda implements l<Object, Object> {
    public final /* synthetic */ l<Object, Unit> $action;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$onEach$1(l<Object, Unit> lVar) {
        super(1);
        this.$action = lVar;
    }

    public final Object invoke(Object obj) {
        this.$action.invoke(obj);
        return obj;
    }
}
