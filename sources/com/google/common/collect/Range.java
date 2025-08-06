package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

@GwtCompatible
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C> {
    private static final Range<Comparable> ALL = new Range<>(Cut.belowAll(), Cut.aboveAll());
    private static final long serialVersionUID = 0;
    public final Cut<C> lowerBound;
    public final Cut<C> upperBound;

    /* renamed from: com.google.common.collect.Range$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.common.collect.BoundType[] r0 = com.google.common.collect.BoundType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$common$collect$BoundType = r0
                com.google.common.collect.BoundType r1 = com.google.common.collect.BoundType.OPEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$common$collect$BoundType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.collect.BoundType r1 = com.google.common.collect.BoundType.CLOSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Range.AnonymousClass1.<clinit>():void");
        }
    }

    public static class LowerBoundFn implements Function<Range, Cut> {
        public static final LowerBoundFn INSTANCE = new LowerBoundFn();

        public Cut apply(Range range) {
            return range.lowerBound;
        }
    }

    public static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        public static final Ordering<Range<?>> INSTANCE = new RangeLexOrdering();
        private static final long serialVersionUID = 0;

        private RangeLexOrdering() {
        }

        public int compare(Range<?> range, Range<?> range2) {
            return ComparisonChain.start().compare((Comparable<?>) range.lowerBound, (Comparable<?>) range2.lowerBound).compare((Comparable<?>) range.upperBound, (Comparable<?>) range2.upperBound).result();
        }
    }

    public static class UpperBoundFn implements Function<Range, Cut> {
        public static final UpperBoundFn INSTANCE = new UpperBoundFn();

        public Cut apply(Range range) {
            return range.upperBound;
        }
    }

    private Range(Cut<C> cut, Cut<C> cut2) {
        this.lowerBound = (Cut) Preconditions.checkNotNull(cut);
        this.upperBound = (Cut) Preconditions.checkNotNull(cut2);
        if (cut.compareTo(cut2) > 0 || cut == Cut.aboveAll() || cut2 == Cut.belowAll()) {
            throw new IllegalArgumentException("Invalid range: " + toString(cut, cut2));
        }
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c11) {
        return create(Cut.belowValue(c11), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c11) {
        return create(Cut.belowAll(), Cut.aboveValue(c11));
    }

    private static <T> SortedSet<T> cast(Iterable<T> iterable) {
        return (SortedSet) iterable;
    }

    public static <C extends Comparable<?>> Range<C> closed(C c11, C c12) {
        return create(Cut.belowValue(c11), Cut.aboveValue(c12));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c11, C c12) {
        return create(Cut.belowValue(c11), Cut.belowValue(c12));
    }

    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends Comparable<?>> Range<C> create(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c11, BoundType boundType) {
        int i11 = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()];
        if (i11 == 1) {
            return greaterThan(c11);
        }
        if (i11 == 2) {
            return atLeast(c11);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet<C> cast = cast(iterable);
            Comparator<? super C> comparator = cast.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) cast.first(), (Comparable) cast.last());
            }
        }
        Iterator<C> it2 = iterable.iterator();
        Comparable comparable = (Comparable) Preconditions.checkNotNull(it2.next());
        Comparable comparable2 = comparable;
        while (it2.hasNext()) {
            Comparable comparable3 = (Comparable) Preconditions.checkNotNull(it2.next());
            comparable = (Comparable) Ordering.natural().min(comparable, comparable3);
            comparable2 = (Comparable) Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c11) {
        return create(Cut.aboveValue(c11), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c11) {
        return create(Cut.belowAll(), Cut.belowValue(c11));
    }

    public static <C extends Comparable<?>> Function<Range<C>, Cut<C>> lowerBoundFn() {
        return LowerBoundFn.INSTANCE;
    }

    public static <C extends Comparable<?>> Range<C> open(C c11, C c12) {
        return create(Cut.aboveValue(c11), Cut.belowValue(c12));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c11, C c12) {
        return create(Cut.aboveValue(c11), Cut.aboveValue(c12));
    }

    public static <C extends Comparable<?>> Range<C> range(C c11, BoundType boundType, C c12, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        return create(boundType == boundType3 ? Cut.aboveValue(c11) : Cut.belowValue(c11), boundType2 == boundType3 ? Cut.belowValue(c12) : Cut.aboveValue(c12));
    }

    public static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return RangeLexOrdering.INSTANCE;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c11) {
        return closed(c11, c11);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c11, BoundType boundType) {
        int i11 = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()];
        if (i11 == 1) {
            return lessThan(c11);
        }
        if (i11 == 2) {
            return atMost(c11);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Function<Range<C>, Cut<C>> upperBoundFn() {
        return UpperBoundFn.INSTANCE;
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        Cut<C> canonical = this.lowerBound.canonical(discreteDomain);
        Cut<C> canonical2 = this.upperBound.canonical(discreteDomain);
        return (canonical == this.lowerBound && canonical2 == this.upperBound) ? this : create(canonical, canonical2);
    }

    public boolean contains(C c11) {
        Preconditions.checkNotNull(c11);
        return this.lowerBound.isLessThan(c11) && !this.upperBound.isLessThan(c11);
    }

    public boolean containsAll(Iterable<? extends C> iterable) {
        if (Iterables.isEmpty(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet<? extends C> cast = cast(iterable);
            Comparator<? super Object> comparator = cast.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                if (!contains((Comparable) cast.first()) || !contains((Comparable) cast.last())) {
                    return false;
                }
                return true;
            }
        }
        Iterator<? extends C> it2 = iterable.iterator();
        while (it2.hasNext()) {
            if (!contains((Comparable) it2.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        return this.lowerBound.compareTo(range.lowerBound) <= 0 && this.upperBound.compareTo(range.upperBound) >= 0;
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

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.common.collect.Range<C>, code=com.google.common.collect.Range, for r3v0, types: [com.google.common.collect.Range, com.google.common.collect.Range<C>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.collect.Range<C> gap(com.google.common.collect.Range r3) {
        /*
            r2 = this;
            com.google.common.collect.Cut<C> r0 = r2.lowerBound
            com.google.common.collect.Cut<C> r1 = r3.lowerBound
            int r0 = r0.compareTo(r1)
            if (r0 >= 0) goto L_0x000c
            r0 = 1
            goto L_0x000d
        L_0x000c:
            r0 = 0
        L_0x000d:
            if (r0 == 0) goto L_0x0011
            r1 = r2
            goto L_0x0012
        L_0x0011:
            r1 = r3
        L_0x0012:
            if (r0 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r3 = r2
        L_0x0016:
            com.google.common.collect.Cut<C> r0 = r1.upperBound
            com.google.common.collect.Cut<C> r3 = r3.lowerBound
            com.google.common.collect.Range r3 = create(r0, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Range.gap(com.google.common.collect.Range):com.google.common.collect.Range");
    }

    public boolean hasLowerBound() {
        return this.lowerBound != Cut.belowAll();
    }

    public boolean hasUpperBound() {
        return this.upperBound != Cut.aboveAll();
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> range) {
        int compareTo = this.lowerBound.compareTo(range.lowerBound);
        int compareTo2 = this.upperBound.compareTo(range.upperBound);
        if (compareTo >= 0 && compareTo2 <= 0) {
            return this;
        }
        if (compareTo <= 0 && compareTo2 >= 0) {
            return range;
        }
        return create(compareTo >= 0 ? this.lowerBound : range.lowerBound, compareTo2 <= 0 ? this.upperBound : range.upperBound);
    }

    public boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo(range.upperBound) <= 0 && range.lowerBound.compareTo(this.upperBound) <= 0;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public C lowerEndpoint() {
        return this.lowerBound.endpoint();
    }

    public Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    public Range<C> span(Range<C> range) {
        int compareTo = this.lowerBound.compareTo(range.lowerBound);
        int compareTo2 = this.upperBound.compareTo(range.upperBound);
        if (compareTo <= 0 && compareTo2 >= 0) {
            return this;
        }
        if (compareTo >= 0 && compareTo2 <= 0) {
            return range;
        }
        return create(compareTo <= 0 ? this.lowerBound : range.lowerBound, compareTo2 >= 0 ? this.upperBound : range.upperBound);
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return this.upperBound.endpoint();
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
