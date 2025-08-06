package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    public static <T extends Comparable<? super T>> void y(List<T> list) {
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static <T> void z(List<T> list, Comparator<? super T> comparator) {
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
