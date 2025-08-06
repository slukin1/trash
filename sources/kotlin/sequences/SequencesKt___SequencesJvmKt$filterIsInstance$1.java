package kotlin.sequences;

import d10.l;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesJvmKt$filterIsInstance$1 extends Lambda implements l<Object, Boolean> {
    public final /* synthetic */ Class<Object> $klass;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesJvmKt$filterIsInstance$1(Class<Object> cls) {
        super(1);
        this.$klass = cls;
    }

    public final Boolean invoke(Object obj) {
        return Boolean.valueOf(this.$klass.isInstance(obj));
    }
}
