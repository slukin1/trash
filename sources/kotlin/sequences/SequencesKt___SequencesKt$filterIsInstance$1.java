package kotlin.sequences;

import d10.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class SequencesKt___SequencesKt$filterIsInstance$1 extends Lambda implements l<Object, Boolean> {
    public static final SequencesKt___SequencesKt$filterIsInstance$1 INSTANCE = new SequencesKt___SequencesKt$filterIsInstance$1();

    public SequencesKt___SequencesKt$filterIsInstance$1() {
        super(1);
    }

    public final Boolean invoke(Object obj) {
        x.f(3, "R");
        return Boolean.valueOf(obj instanceof Object);
    }
}
