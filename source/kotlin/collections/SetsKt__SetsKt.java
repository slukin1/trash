package kotlin.collections;

import java.util.Set;

class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public static <T> Set<T> d() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> e(Set<? extends T> set) {
        int size = set.size();
        if (size == 0) {
            return d();
        }
        if (size != 1) {
            return set;
        }
        return SetsKt__SetsJVMKt.c(set.iterator().next());
    }

    public static <T> Set<T> f(T... tArr) {
        return tArr.length > 0 ? ArraysKt___ArraysKt.G0(tArr) : d();
    }
}
