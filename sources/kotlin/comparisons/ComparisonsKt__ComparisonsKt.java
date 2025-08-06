package kotlin.comparisons;

import java.util.Comparator;

class ComparisonsKt__ComparisonsKt {
    public static <T extends Comparable<?>> int a(T t11, T t12) {
        if (t11 == t12) {
            return 0;
        }
        if (t11 == null) {
            return -1;
        }
        if (t12 == null) {
            return 1;
        }
        return t11.compareTo(t12);
    }

    public static <T extends Comparable<? super T>> Comparator<T> b() {
        return b.f56668b;
    }
}
