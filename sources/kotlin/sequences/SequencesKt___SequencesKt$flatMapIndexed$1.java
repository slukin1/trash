package kotlin.sequences;

import d10.l;
import java.util.Iterator;
import kotlin.jvm.internal.FunctionReferenceImpl;

final /* synthetic */ class SequencesKt___SequencesKt$flatMapIndexed$1 extends FunctionReferenceImpl implements l<Iterable<Object>, Iterator<Object>> {
    public static final SequencesKt___SequencesKt$flatMapIndexed$1 INSTANCE = new SequencesKt___SequencesKt$flatMapIndexed$1();

    public SequencesKt___SequencesKt$flatMapIndexed$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    public final Iterator<Object> invoke(Iterable<Object> iterable) {
        return iterable.iterator();
    }
}
