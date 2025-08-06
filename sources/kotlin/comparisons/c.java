package kotlin.comparisons;

import java.util.Comparator;

public final class c implements Comparator<Comparable<? super Object>> {

    /* renamed from: b  reason: collision with root package name */
    public static final c f56669b = new c();

    /* renamed from: a */
    public int compare(Comparable<Object> comparable, Comparable<Object> comparable2) {
        return comparable2.compareTo(comparable);
    }

    public final Comparator<Comparable<Object>> reversed() {
        return b.f56668b;
    }
}
