package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible(serializable = true)
final class PairwiseEquivalence<T> extends Equivalence<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 1;
    public final Equivalence<? super T> elementEquivalence;

    public PairwiseEquivalence(Equivalence<? super T> equivalence) {
        this.elementEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
    }

    public boolean equals(Object obj) {
        if (obj instanceof PairwiseEquivalence) {
            return this.elementEquivalence.equals(((PairwiseEquivalence) obj).elementEquivalence);
        }
        return false;
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        return this.elementEquivalence + ".pairwise()";
    }

    public boolean doEquivalent(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> it2 = iterable.iterator();
        Iterator<T> it3 = iterable2.iterator();
        while (it2.hasNext() && it3.hasNext()) {
            if (!this.elementEquivalence.equivalent(it2.next(), it3.next())) {
                return false;
            }
        }
        if (it2.hasNext() || it3.hasNext()) {
            return false;
        }
        return true;
    }

    public int doHash(Iterable<T> iterable) {
        int i11 = 78721;
        for (T hash : iterable) {
            i11 = (i11 * 24943) + this.elementEquivalence.hash(hash);
        }
        return i11;
    }
}
