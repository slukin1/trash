package kotlin.sequences;

import d10.a;
import d10.l;
import kotlin.jvm.internal.Lambda;

final class SequencesKt__SequencesKt$generateSequence$1 extends Lambda implements l<Object, Object> {
    public final /* synthetic */ a<Object> $nextFunction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$generateSequence$1(a<Object> aVar) {
        super(1);
        this.$nextFunction = aVar;
    }

    public final Object invoke(Object obj) {
        return this.$nextFunction.invoke();
    }
}
