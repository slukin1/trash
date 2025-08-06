package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.c;

public final class SlidingWindowKt {
    public static final void a(int i11, int i12) {
        String str;
        if (!(i11 > 0 && i12 > 0)) {
            if (i11 != i12) {
                str = "Both size " + i11 + " and step " + i12 + " must be greater than zero.";
            } else {
                str = "size " + i11 + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public static final <T> Iterator<List<T>> b(Iterator<? extends T> it2, int i11, int i12, boolean z11, boolean z12) {
        if (!it2.hasNext()) {
            return k.f56654b;
        }
        return SequencesKt__SequenceBuilderKt.a(new SlidingWindowKt$windowedIterator$1(i11, i12, it2, z12, z11, (c<? super SlidingWindowKt$windowedIterator$1>) null));
    }
}
