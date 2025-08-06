package kotlin.sequences;

import d10.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.x;

final class SequencesKt___SequencesKt$minus$1$iterator$1 extends Lambda implements l<Object, Boolean> {
    public final /* synthetic */ Object $element;
    public final /* synthetic */ Ref$BooleanRef $removed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$minus$1$iterator$1(Ref$BooleanRef ref$BooleanRef, Object obj) {
        super(1);
        this.$removed = ref$BooleanRef;
        this.$element = obj;
    }

    public final Boolean invoke(Object obj) {
        boolean z11 = true;
        if (!this.$removed.element && x.b(obj, this.$element)) {
            this.$removed.element = true;
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }
}
