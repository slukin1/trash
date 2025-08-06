package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible(serializable = true)
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Comparator<? super T>[] comparators;

    public CompoundOrdering(Comparator<? super T> comparator, Comparator<? super T> comparator2) {
        this.comparators = new Comparator[]{comparator, comparator2};
    }

    public int compare(T t11, T t12) {
        int i11 = 0;
        while (true) {
            Comparator<? super T>[] comparatorArr = this.comparators;
            if (i11 >= comparatorArr.length) {
                return 0;
            }
            int compare = comparatorArr[i11].compare(t11, t12);
            if (compare != 0) {
                return compare;
            }
            i11++;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompoundOrdering) {
            return Arrays.equals(this.comparators, ((CompoundOrdering) obj).comparators);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.comparators) + ")";
    }

    public CompoundOrdering(Iterable<? extends Comparator<? super T>> iterable) {
        this.comparators = (Comparator[]) Iterables.toArray(iterable, (T[]) new Comparator[0]);
    }
}
