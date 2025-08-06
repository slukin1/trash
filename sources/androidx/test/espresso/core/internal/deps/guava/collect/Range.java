package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.lang.Comparable;

public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies {
    private static final Range<Comparable> ALL = new Range<>(Cut.belowAll(), Cut.aboveAll());
    private static final long serialVersionUID = 0;
    public final Cut<C> lowerBound;
    public final Cut<C> upperBound;

    private Range(Cut<C> cut, Cut<C> cut2) {
        this.lowerBound = (Cut) Preconditions.i(cut);
        this.upperBound = (Cut) Preconditions.i(cut2);
        if (cut.compareTo(cut2) > 0 || cut == Cut.aboveAll() || cut2 == Cut.belowAll()) {
            String valueOf = String.valueOf(toString(cut, cut2));
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid range: ".concat(valueOf) : new String("Invalid range: "));
        }
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> Range<C> closed(C c11, C c12) {
        return create(Cut.belowValue(c11), Cut.aboveValue(c12));
    }

    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends Comparable<?>> Range<C> create(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public boolean contains(C c11) {
        Preconditions.i(c11);
        return this.lowerBound.isLessThan(c11) && !this.upperBound.isLessThan(c11);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (!this.lowerBound.equals(range.lowerBound) || !this.upperBound.equals(range.upperBound)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    private static String toString(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb2 = new StringBuilder(16);
        cut.describeAsLowerBound(sb2);
        sb2.append("..");
        cut2.describeAsUpperBound(sb2);
        return sb2.toString();
    }

    @Deprecated
    public boolean apply(C c11) {
        return contains(c11);
    }
}
