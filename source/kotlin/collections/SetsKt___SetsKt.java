package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.x;

class SetsKt___SetsKt extends SetsKt__SetsKt {
    public static <T> Set<T> g(Set<? extends T> set, Iterable<? extends T> iterable) {
        Collection<? extends T> C = CollectionsKt__MutableCollectionsKt.C(iterable);
        if (C.isEmpty()) {
            return CollectionsKt___CollectionsKt.N0(set);
        }
        if (C instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T next : set) {
                if (!C.contains(next)) {
                    linkedHashSet.add(next);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(C);
        return linkedHashSet2;
    }

    public static <T> Set<T> h(Set<? extends T> set, T t11) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.d(set.size()));
        boolean z11 = false;
        for (T next : set) {
            boolean z12 = true;
            if (!z11 && x.b(next, t11)) {
                z11 = true;
                z12 = false;
            }
            if (z12) {
                linkedHashSet.add(next);
            }
        }
        return linkedHashSet;
    }

    public static <T> Set<T> i(Set<? extends T> set, Iterable<? extends T> iterable) {
        int i11;
        Integer v11 = CollectionsKt__IterablesKt.v(iterable);
        if (v11 != null) {
            i11 = set.size() + v11.intValue();
        } else {
            i11 = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.d(i11));
        linkedHashSet.addAll(set);
        boolean unused = CollectionsKt__MutableCollectionsKt.A(linkedHashSet, iterable);
        return linkedHashSet;
    }

    public static <T> Set<T> j(Set<? extends T> set, T t11) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.d(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t11);
        return linkedHashSet;
    }
}
