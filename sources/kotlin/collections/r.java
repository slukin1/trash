package kotlin.collections;

import java.util.List;

public class r<T> extends a<T> {

    /* renamed from: b  reason: collision with root package name */
    public final List<T> f56660b;

    public r(List<? extends T> list) {
        this.f56660b = list;
    }

    public T get(int i11) {
        return this.f56660b.get(CollectionsKt__ReversedViewsKt.N(this, i11));
    }

    public int getSize() {
        return this.f56660b.size();
    }
}
