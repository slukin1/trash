package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;

final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Comparator<T> comparator;

    public ComparatorOrdering(Comparator<T> comparator2) {
        this.comparator = (Comparator) Preconditions.i(comparator2);
    }

    public int compare(T t11, T t12) {
        return this.comparator.compare(t11, t12);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ComparatorOrdering) {
            return this.comparator.equals(((ComparatorOrdering) obj).comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}
