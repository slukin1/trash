package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

@GwtCompatible
public abstract class ComparisonChain {
    /* access modifiers changed from: private */
    public static final ComparisonChain ACTIVE = new ComparisonChain() {
        public ComparisonChain classify(int i11) {
            if (i11 < 0) {
                return ComparisonChain.LESS;
            }
            return i11 > 0 ? ComparisonChain.GREATER : ComparisonChain.ACTIVE;
        }

        public ComparisonChain compare(Comparable comparable, Comparable comparable2) {
            return classify(comparable.compareTo(comparable2));
        }

        public ComparisonChain compareFalseFirst(boolean z11, boolean z12) {
            return classify(Booleans.compare(z11, z12));
        }

        public ComparisonChain compareTrueFirst(boolean z11, boolean z12) {
            return classify(Booleans.compare(z12, z11));
        }

        public int result() {
            return 0;
        }

        public <T> ComparisonChain compare(T t11, T t12, Comparator<T> comparator) {
            return classify(comparator.compare(t11, t12));
        }

        public ComparisonChain compare(int i11, int i12) {
            return classify(Ints.compare(i11, i12));
        }

        public ComparisonChain compare(long j11, long j12) {
            return classify(Longs.compare(j11, j12));
        }

        public ComparisonChain compare(float f11, float f12) {
            return classify(Float.compare(f11, f12));
        }

        public ComparisonChain compare(double d11, double d12) {
            return classify(Double.compare(d11, d12));
        }
    };
    /* access modifiers changed from: private */
    public static final ComparisonChain GREATER = new InactiveComparisonChain(1);
    /* access modifiers changed from: private */
    public static final ComparisonChain LESS = new InactiveComparisonChain(-1);

    public static final class InactiveComparisonChain extends ComparisonChain {
        public final int result;

        public InactiveComparisonChain(int i11) {
            super();
            this.result = i11;
        }

        public ComparisonChain compare(double d11, double d12) {
            return this;
        }

        public ComparisonChain compare(float f11, float f12) {
            return this;
        }

        public ComparisonChain compare(int i11, int i12) {
            return this;
        }

        public ComparisonChain compare(long j11, long j12) {
            return this;
        }

        public ComparisonChain compare(Comparable comparable, Comparable comparable2) {
            return this;
        }

        public <T> ComparisonChain compare(T t11, T t12, Comparator<T> comparator) {
            return this;
        }

        public ComparisonChain compareFalseFirst(boolean z11, boolean z12) {
            return this;
        }

        public ComparisonChain compareTrueFirst(boolean z11, boolean z12) {
            return this;
        }

        public int result() {
            return this.result;
        }
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }

    public abstract ComparisonChain compare(double d11, double d12);

    public abstract ComparisonChain compare(float f11, float f12);

    public abstract ComparisonChain compare(int i11, int i12);

    public abstract ComparisonChain compare(long j11, long j12);

    @Deprecated
    public final ComparisonChain compare(Boolean bool, Boolean bool2) {
        return compareFalseFirst(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> ComparisonChain compare(T t11, T t12, Comparator<T> comparator);

    public abstract ComparisonChain compareFalseFirst(boolean z11, boolean z12);

    public abstract ComparisonChain compareTrueFirst(boolean z11, boolean z12);

    public abstract int result();

    private ComparisonChain() {
    }
}
