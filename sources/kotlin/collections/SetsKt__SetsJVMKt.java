package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.collections.builders.SetBuilder;

class SetsKt__SetsJVMKt {
    public static <E> Set<E> a(Set<E> set) {
        return ((SetBuilder) set).build();
    }

    public static <E> Set<E> b(int i11) {
        return new SetBuilder(i11);
    }

    public static <T> Set<T> c(T t11) {
        return Collections.singleton(t11);
    }
}
