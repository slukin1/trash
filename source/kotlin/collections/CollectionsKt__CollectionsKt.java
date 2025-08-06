package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ranges.h;

class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static <T> ArrayList<T> g(T... tArr) {
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new g(tArr, true));
    }

    public static final <T> Collection<T> h(T[] tArr) {
        return new g(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int i(List<? extends T> list, T t11, int i11, int i12) {
        r(list.size(), i11, i12);
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int a11 = ComparisonsKt__ComparisonsKt.a((Comparable) list.get(i14), t11);
            if (a11 < 0) {
                i11 = i14 + 1;
            } else if (a11 <= 0) {
                return i14;
            } else {
                i13 = i14 - 1;
            }
        }
        return -(i11 + 1);
    }

    public static /* synthetic */ int j(List list, Comparable comparable, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = list.size();
        }
        return i(list, comparable, i11, i12);
    }

    public static <T> List<T> k() {
        return EmptyList.INSTANCE;
    }

    public static h l(Collection<?> collection) {
        return new h(0, collection.size() - 1);
    }

    public static <T> int m(List<? extends T> list) {
        return list.size() - 1;
    }

    public static <T> List<T> n(T... tArr) {
        return tArr.length > 0 ? ArraysKt___ArraysJvmKt.d(tArr) : k();
    }

    public static <T> List<T> o(T... tArr) {
        return ArraysKt___ArraysKt.F(tArr);
    }

    public static <T> List<T> p(T... tArr) {
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new g(tArr, true));
    }

    public static <T> List<T> q(List<? extends T> list) {
        int size = list.size();
        if (size == 0) {
            return k();
        }
        if (size != 1) {
            return list;
        }
        return CollectionsKt__CollectionsJVMKt.e(list.get(0));
    }

    public static final void r(int i11, int i12, int i13) {
        if (i12 > i13) {
            throw new IllegalArgumentException("fromIndex (" + i12 + ") is greater than toIndex (" + i13 + ").");
        } else if (i12 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i12 + ") is less than zero.");
        } else if (i13 > i11) {
            throw new IndexOutOfBoundsException("toIndex (" + i13 + ") is greater than size (" + i11 + ").");
        }
    }

    public static void s() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void t() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
