package kotlin.sequences;

import d10.l;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

final class SequencesKt__SequencesKt$flatten$2 extends Lambda implements l<Iterable<Object>, Iterator<Object>> {
    public static final SequencesKt__SequencesKt$flatten$2 INSTANCE = new SequencesKt__SequencesKt$flatten$2();

    public SequencesKt__SequencesKt$flatten$2() {
        super(1);
    }

    public final Iterator<Object> invoke(Iterable<Object> iterable) {
        return iterable.iterator();
    }
}
