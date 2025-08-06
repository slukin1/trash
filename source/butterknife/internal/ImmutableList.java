package butterknife.internal;

import java.util.AbstractList;
import java.util.RandomAccess;

final class ImmutableList<T> extends AbstractList<T> implements RandomAccess {
    private final T[] views;

    public ImmutableList(T[] tArr) {
        this.views = tArr;
    }

    public boolean contains(Object obj) {
        for (T t11 : this.views) {
            if (t11 == obj) {
                return true;
            }
        }
        return false;
    }

    public T get(int i11) {
        return this.views[i11];
    }

    public int size() {
        return this.views.length;
    }
}
