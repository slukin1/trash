package kotlin.sequences;

import d10.a;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt__SequencesKt$generateSequence$2 extends Lambda implements a<T> {
    public final /* synthetic */ T $seed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$generateSequence$2(T t11) {
        super(0);
        this.$seed = t11;
    }

    public final T invoke() {
        return this.$seed;
    }
}
