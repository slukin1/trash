package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

@GwtCompatible(serializable = true)
final class LexicographicalOrdering<T> extends Ordering<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Comparator<? super T> elementOrder;

    public LexicographicalOrdering(Comparator<? super T> comparator) {
        this.elementOrder = comparator;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LexicographicalOrdering) {
            return this.elementOrder.equals(((LexicographicalOrdering) obj).elementOrder);
        }
        return false;
    }

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 2075626741;
    }

    public String toString() {
        return this.elementOrder + ".lexicographical()";
    }

    public int compare(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> it2 = iterable2.iterator();
        for (T compare : iterable) {
            if (!it2.hasNext()) {
                return 1;
            }
            int compare2 = this.elementOrder.compare(compare, it2.next());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return it2.hasNext() ? -1 : 0;
    }
}
