package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt {
    public static <T> int u(Iterable<? extends T> iterable, int i11) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : i11;
    }

    public static final <T> Integer v(Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    public static <T> List<T> w(Iterable<? extends Iterable<? extends T>> iterable) {
        ArrayList arrayList = new ArrayList();
        for (Iterable A : iterable) {
            boolean unused = CollectionsKt__MutableCollectionsKt.A(arrayList, A);
        }
        return arrayList;
    }
}
