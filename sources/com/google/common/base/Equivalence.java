package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;

@GwtCompatible
public abstract class Equivalence<T> {

    public static final class Equals extends Equivalence<Object> implements Serializable {
        public static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        public boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        public int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    public static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;
        private final T target;

        public EquivalentToPredicate(Equivalence<T> equivalence2, T t11) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence2);
            this.target = t11;
        }

        public boolean apply(T t11) {
            return this.equivalence.equivalent(t11, this.target);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EquivalentToPredicate)) {
                return false;
            }
            EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
            if (!this.equivalence.equals(equivalentToPredicate.equivalence) || !Objects.equal(this.target, equivalentToPredicate.target)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.equivalence, this.target);
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }
    }

    public static final class Identity extends Equivalence<Object> implements Serializable {
        public static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        public boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        public int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;
        private final T reference;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, wrapper.reference);
            }
            return false;
        }

        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }

        private Wrapper(Equivalence<? super T> equivalence2, T t11) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence2);
            this.reference = t11;
        }
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    @ForOverride
    public abstract boolean doEquivalent(T t11, T t12);

    @ForOverride
    public abstract int doHash(T t11);

    public final boolean equivalent(T t11, T t12) {
        if (t11 == t12) {
            return true;
        }
        if (t11 == null || t12 == null) {
            return false;
        }
        return doEquivalent(t11, t12);
    }

    public final Predicate<T> equivalentTo(T t11) {
        return new EquivalentToPredicate(this, t11);
    }

    public final int hash(T t11) {
        if (t11 == null) {
            return 0;
        }
        return doHash(t11);
    }

    public final <F> Equivalence<F> onResultOf(Function<F, ? extends T> function) {
        return new FunctionalEquivalence(function, this);
    }

    @GwtCompatible(serializable = true)
    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final <S extends T> Wrapper<S> wrap(S s11) {
        return new Wrapper<>(s11);
    }
}
