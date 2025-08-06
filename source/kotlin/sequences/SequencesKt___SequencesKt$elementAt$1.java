package kotlin.sequences;

import d10.l;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesKt$elementAt$1 extends Lambda implements l<Integer, Object> {
    public final /* synthetic */ int $index;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$elementAt$1(int i11) {
        super(1);
        this.$index = i11;
    }

    public final Object invoke(int i11) {
        throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.$index + '.');
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
