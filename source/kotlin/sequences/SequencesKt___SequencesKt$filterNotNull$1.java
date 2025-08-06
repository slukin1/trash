package kotlin.sequences;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt___SequencesKt$filterNotNull$1 extends Lambda implements l<T, Boolean> {
    public static final SequencesKt___SequencesKt$filterNotNull$1 INSTANCE = new SequencesKt___SequencesKt$filterNotNull$1();

    public SequencesKt___SequencesKt$filterNotNull$1() {
        super(1);
    }

    public final Boolean invoke(T t11) {
        return Boolean.valueOf(t11 == null);
    }
}
