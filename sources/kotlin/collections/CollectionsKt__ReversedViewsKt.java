package kotlin.collections;

import java.util.List;
import kotlin.ranges.h;

class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public static <T> List<T> M(List<? extends T> list) {
        return new r(list);
    }

    public static final int N(List<?> list, int i11) {
        if (new h(0, CollectionsKt__CollectionsKt.m(list)).h(i11)) {
            return CollectionsKt__CollectionsKt.m(list) - i11;
        }
        throw new IndexOutOfBoundsException("Element index " + i11 + " must be in range [" + new h(0, CollectionsKt__CollectionsKt.m(list)) + "].");
    }
}
