package kotlin.sequences;

import d10.l;
import java.util.Collection;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesKt$minus$3$iterator$1 extends Lambda implements l<Object, Boolean> {
    public final /* synthetic */ Collection<Object> $other;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$minus$3$iterator$1(Collection<Object> collection) {
        super(1);
        this.$other = collection;
    }

    public final Boolean invoke(Object obj) {
        return Boolean.valueOf(this.$other.contains(obj));
    }
}
