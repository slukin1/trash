package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.x;

class CollectionsKt__CollectionsJVMKt {
    public static <E> List<E> a(List<E> list) {
        return ((ListBuilder) list).build();
    }

    public static final <T> Object[] b(T[] tArr, boolean z11) {
        Class<Object[]> cls = Object[].class;
        return (!z11 || !x.b(tArr.getClass(), cls)) ? Arrays.copyOf(tArr, tArr.length, cls) : tArr;
    }

    public static <E> List<E> c() {
        return new ListBuilder();
    }

    public static <E> List<E> d(int i11) {
        return new ListBuilder(i11);
    }

    public static <T> List<T> e(T t11) {
        return Collections.singletonList(t11);
    }

    public static <T> List<T> f(Iterable<? extends T> iterable) {
        List<T> K0 = CollectionsKt___CollectionsKt.K0(iterable);
        Collections.shuffle(K0);
        return K0;
    }
}
