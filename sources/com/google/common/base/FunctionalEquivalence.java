package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible
@Beta
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Function<F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    public FunctionalEquivalence(Function<F, ? extends T> function2, Equivalence<T> equivalence) {
        this.function = (Function) Preconditions.checkNotNull(function2);
        this.resultEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
    }

    public boolean doEquivalent(F f11, F f12) {
        return this.resultEquivalence.equivalent(this.function.apply(f11), this.function.apply(f12));
    }

    public int doHash(F f11) {
        return this.resultEquivalence.hash(this.function.apply(f11));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionalEquivalence)) {
            return false;
        }
        FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
        if (!this.function.equals(functionalEquivalence.function) || !this.resultEquivalence.equals(functionalEquivalence.resultEquivalence)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.function, this.resultEquivalence);
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
