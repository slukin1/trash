package kotlin.sequences;

import d10.l;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesKt$requireNoNulls$1 extends Lambda implements l<Object, Object> {
    public final /* synthetic */ g<Object> $this_requireNoNulls;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$requireNoNulls$1(g<Object> gVar) {
        super(1);
        this.$this_requireNoNulls = gVar;
    }

    public final Object invoke(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
    }
}
