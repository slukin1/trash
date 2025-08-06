package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable = true)
final class NullsFirstOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Ordering<? super T> ordering;

    public NullsFirstOrdering(Ordering<? super T> ordering2) {
        this.ordering = ordering2;
    }

    public int compare(T t11, T t12) {
        if (t11 == t12) {
            return 0;
        }
        if (t11 == null) {
            return -1;
        }
        if (t12 == null) {
            return 1;
        }
        return this.ordering.compare(t11, t12);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsFirstOrdering) {
            return this.ordering.equals(((NullsFirstOrdering) obj).ordering);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ 957692532;
    }

    public <S extends T> Ordering<S> nullsFirst() {
        return this;
    }

    public <S extends T> Ordering<S> nullsLast() {
        return this.ordering.nullsLast();
    }

    public <S extends T> Ordering<S> reverse() {
        return this.ordering.reverse().nullsLast();
    }

    public String toString() {
        return this.ordering + ".nullsFirst()";
    }
}
