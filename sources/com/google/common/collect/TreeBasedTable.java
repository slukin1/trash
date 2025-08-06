package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

@GwtCompatible(serializable = true)
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    public static class Factory<C, V> implements Supplier<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        public final Comparator<? super C> comparator;

        public Factory(Comparator<? super C> comparator2) {
            this.comparator = comparator2;
        }

        public TreeMap<C, V> get() {
            return new TreeMap<>(this.comparator);
        }
    }

    public class TreeRow extends StandardTable<R, C, V>.Row implements SortedMap<C, V> {
        public final C lowerBound;
        public final C upperBound;
        public transient SortedMap<C, V> wholeRow;

        public TreeRow(TreeBasedTable treeBasedTable, R r11) {
            this(r11, (Object) null, (Object) null);
        }

        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        public int compare(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        public boolean containsKey(Object obj) {
            return rangeContains(obj) && super.containsKey(obj);
        }

        public C firstKey() {
            if (backingRowMap() != null) {
                return backingRowMap().firstKey();
            }
            throw new NoSuchElementException();
        }

        public SortedMap<C, V> headMap(C c11) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(c11)));
            return new TreeRow(this.rowKey, this.lowerBound, c11);
        }

        public C lastKey() {
            if (backingRowMap() != null) {
                return backingRowMap().lastKey();
            }
            throw new NoSuchElementException();
        }

        public void maintainEmptyInvariant() {
            if (wholeRow() != null && this.wholeRow.isEmpty()) {
                TreeBasedTable.this.backingMap.remove(this.rowKey);
                this.wholeRow = null;
                this.backingRowMap = null;
            }
        }

        public V put(C c11, V v11) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(c11)));
            return super.put(c11, v11);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r0 = r1.lowerBound;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
            r0 = r1.upperBound;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean rangeContains(java.lang.Object r2) {
            /*
                r1 = this;
                if (r2 == 0) goto L_0x0018
                C r0 = r1.lowerBound
                if (r0 == 0) goto L_0x000c
                int r0 = r1.compare(r0, r2)
                if (r0 > 0) goto L_0x0018
            L_0x000c:
                C r0 = r1.upperBound
                if (r0 == 0) goto L_0x0016
                int r2 = r1.compare(r0, r2)
                if (r2 <= 0) goto L_0x0018
            L_0x0016:
                r2 = 1
                goto L_0x0019
            L_0x0018:
                r2 = 0
            L_0x0019:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeBasedTable.TreeRow.rangeContains(java.lang.Object):boolean");
        }

        public SortedMap<C, V> subMap(C c11, C c12) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(c11)) && rangeContains(Preconditions.checkNotNull(c12)));
            return new TreeRow(this.rowKey, c11, c12);
        }

        public SortedMap<C, V> tailMap(C c11) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(c11)));
            return new TreeRow(this.rowKey, c11, this.upperBound);
        }

        public SortedMap<C, V> wholeRow() {
            SortedMap<C, V> sortedMap = this.wholeRow;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.rowKey))) {
                this.wholeRow = (SortedMap) TreeBasedTable.this.backingMap.get(this.rowKey);
            }
            return this.wholeRow;
        }

        public TreeRow(R r11, C c11, C c12) {
            super(r11);
            this.lowerBound = c11;
            this.upperBound = c12;
            Preconditions.checkArgument(c11 == null || c12 == null || compare(c11, c12) <= 0);
        }

        public SortedMap<C, V> backingRowMap() {
            return (SortedMap) super.backingRowMap();
        }

        public SortedMap<C, V> computeBackingRowMap() {
            SortedMap<C, V> wholeRow2 = wholeRow();
            if (wholeRow2 == null) {
                return null;
            }
            C c11 = this.lowerBound;
            if (c11 != null) {
                wholeRow2 = wholeRow2.tailMap(c11);
            }
            C c12 = this.upperBound;
            return c12 != null ? wholeRow2.headMap(c12) : wholeRow2;
        }

        public SortedSet<C> keySet() {
            return new Maps.SortedKeySet(this);
        }
    }

    public TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    public /* bridge */ /* synthetic */ boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    public Iterator<C> createColumnKeyIterator() {
        final Comparator columnComparator2 = columnComparator();
        final UnmodifiableIterator<T> mergeSorted = Iterators.mergeSorted(Iterables.transform(this.backingMap.values(), new Function<Map<C, V>, Iterator<C>>() {
            public Iterator<C> apply(Map<C, V> map) {
                return map.keySet().iterator();
            }
        }), columnComparator2);
        return new AbstractIterator<C>() {
            public C lastValue;

            public C computeNext() {
                boolean z11;
                while (mergeSorted.hasNext()) {
                    C next = mergeSorted.next();
                    C c11 = this.lastValue;
                    if (c11 == null || columnComparator2.compare(next, c11) != 0) {
                        z11 = false;
                        continue;
                    } else {
                        z11 = true;
                        continue;
                    }
                    if (!z11) {
                        this.lastValue = next;
                        return next;
                    }
                }
                this.lastValue = null;
                return endOfData();
            }
        };
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    public /* bridge */ /* synthetic */ void putAll(Table table) {
        super.putAll(table);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        return rowKeySet().comparator();
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    public SortedMap<C, V> row(R r11) {
        return new TreeRow(this, r11);
    }

    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}
