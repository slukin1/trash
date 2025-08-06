package kotlin.sequences;

import d10.l;
import java.util.List;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesKt$minus$4$iterator$1 extends Lambda implements l<Object, Boolean> {
    public final /* synthetic */ List<Object> $other;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$minus$4$iterator$1(List<Object> list) {
        super(1);
        this.$other = list;
    }

    public final Boolean invoke(Object obj) {
        return Boolean.valueOf(this.$other.contains(obj));
    }
}
