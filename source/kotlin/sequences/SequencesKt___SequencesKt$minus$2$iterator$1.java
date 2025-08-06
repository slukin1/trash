package kotlin.sequences;

import d10.l;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesKt$minus$2$iterator$1 extends Lambda implements l<Object, Boolean> {
    public final /* synthetic */ Object[] $elements;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$minus$2$iterator$1(Object[] objArr) {
        super(1);
        this.$elements = objArr;
    }

    public final Boolean invoke(Object obj) {
        return Boolean.valueOf(ArraysKt___ArraysKt.C(this.$elements, obj));
    }
}
