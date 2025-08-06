package kotlin.comparisons;

import java.util.Comparator;

public final class b implements Comparator<Comparable<? super Object>> {

    /* renamed from: b  reason: collision with root package name */
    public static final b f56668b = new b();

    /* renamed from: a */
    public int compare(Comparable<Object> comparable, Comparable<Object> comparable2) {
        return comparable.compareTo(comparable2);
    }

    public final Comparator<Comparable<Object>> reversed() {
        return c.f56669b;
    }
}
