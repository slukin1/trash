package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@GwtCompatible
class StandardTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    @GwtTransient
    public final Map<R, Map<C, V>> backingMap;
    private transient Set<C> columnKeySet;
    private transient StandardTable<R, C, V>.ColumnMap columnMap;
    @GwtTransient
    public final Supplier<? extends Map<C, V>> factory;
    private transient Map<R, Map<C, V>> rowMap;

    public class CellIterator implements Iterator<Table.Cell<R, C, V>> {
        public Iterator<Map.Entry<C, V>> columnIterator;
        public Map.Entry<R, Map<C, V>> rowEntry;
        public final Iterator<Map.Entry<R, Map<C, V>>> rowIterator;

        private CellIterator() {
            this.rowIterator = StandardTable.this.backingMap.entrySet().iterator();
            this.columnIterator = Iterators.emptyModifiableIterator();
        }

        public boolean hasNext() {
            return this.rowIterator.hasNext() || this.columnIterator.hasNext();
        }

        public void remove() {
            this.columnIterator.remove();
            if (this.rowEntry.getValue().isEmpty()) {
                this.rowIterator.remove();
                this.rowEntry = null;
            }
        }

        public Table.Cell<R, C, V> next() {
            if (!this.columnIterator.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.rowIterator.next();
                this.rowEntry = next;
                this.columnIterator = next.getValue().entrySet().iterator();
            }
            Map.Entry next2 = this.columnIterator.next();
            return Tables.immutableCell(this.rowEntry.getKey(), next2.getKey(), next2.getValue());
        }
    }

    public class Column extends Maps.ViewCachingAbstractMap<R, V> {
        public final C columnKey;

        public class EntrySet extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
            private EntrySet() {
            }

            public void clear() {
                Column.this.removeFromColumnIf(Predicates.alwaysTrue());
            }

            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.containsMapping(entry.getKey(), Column.this.columnKey, entry.getValue());
            }

            public boolean isEmpty() {
                Column column = Column.this;
                return !StandardTable.this.containsColumn(column.columnKey);
            }

            public Iterator<Map.Entry<R, V>> iterator() {
                return new EntrySetIterator();
            }

            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.removeMapping(entry.getKey(), Column.this.columnKey, entry.getValue());
            }

            public boolean retainAll(Collection<?> collection) {
                return Column.this.removeFromColumnIf(Predicates.not(Predicates.in(collection)));
            }

            public int size() {
                int i11 = 0;
                for (Map<C, V> containsKey : StandardTable.this.backingMap.values()) {
                    if (containsKey.containsKey(Column.this.columnKey)) {
                        i11++;
                    }
                }
                return i11;
            }
        }

        public class EntrySetIterator extends AbstractIterator<Map.Entry<R, V>> {
            public final Iterator<Map.Entry<R, Map<C, V>>> iterator;

            private EntrySetIterator() {
                this.iterator = StandardTable.this.backingMap.entrySet().iterator();
            }

            public Map.Entry<R, V> computeNext() {
                while (this.iterator.hasNext()) {
                    final Map.Entry next = this.iterator.next();
                    if (((Map) next.getValue()).containsKey(Column.this.columnKey)) {
                        return new AbstractMapEntry<R, V>() {
                            public R getKey() {
                                return next.getKey();
                            }

                            public V getValue() {
                                return ((Map) next.getValue()).get(Column.this.columnKey);
                            }

                            public V setValue(V v11) {
                                return ((Map) next.getValue()).put(Column.this.columnKey, Preconditions.checkNotNull(v11));
                            }
                        };
                    }
                }
                return (Map.Entry) endOfData();
            }
        }

        public class KeySet extends Maps.KeySet<R, V> {
            public KeySet() {
                super(Column.this);
            }

            public boolean contains(Object obj) {
                Column column = Column.this;
                return StandardTable.this.contains(obj, column.columnKey);
            }

            public boolean remove(Object obj) {
                Column column = Column.this;
                return StandardTable.this.remove(obj, column.columnKey) != null;
            }

            public boolean retainAll(Collection<?> collection) {
                return Column.this.removeFromColumnIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection))));
            }
        }

        public class Values extends Maps.Values<R, V> {
            public Values() {
                super(Column.this);
            }

            public boolean remove(Object obj) {
                return obj != null && Column.this.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.equalTo(obj)));
            }

            public boolean removeAll(Collection<?> collection) {
                return Column.this.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.in(collection)));
            }

            public boolean retainAll(Collection<?> collection) {
                return Column.this.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection))));
            }
        }

        public Column(C c11) {
            this.columnKey = Preconditions.checkNotNull(c11);
        }

        public boolean containsKey(Object obj) {
            return StandardTable.this.contains(obj, this.columnKey);
        }

        public Set<Map.Entry<R, V>> createEntrySet() {
            return new EntrySet();
        }

        public Set<R> createKeySet() {
            return new KeySet();
        }

        public Collection<V> createValues() {
            return new Values();
        }

        public V get(Object obj) {
            return StandardTable.this.get(obj, this.columnKey);
        }

        public V put(R r11, V v11) {
            return StandardTable.this.put(r11, this.columnKey, v11);
        }

        public V remove(Object obj) {
            return StandardTable.this.remove(obj, this.columnKey);
        }

        @CanIgnoreReturnValue
        public boolean removeFromColumnIf(Predicate<? super Map.Entry<R, V>> predicate) {
            Iterator<Map.Entry<R, Map<C, V>>> it2 = StandardTable.this.backingMap.entrySet().iterator();
            boolean z11 = false;
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                Map map = (Map) next.getValue();
                Object obj = map.get(this.columnKey);
                if (obj != null && predicate.apply(Maps.immutableEntry(next.getKey(), obj))) {
                    map.remove(this.columnKey);
                    z11 = true;
                    if (map.isEmpty()) {
                        it2.remove();
                    }
                }
            }
            return z11;
        }
    }

    public class ColumnKeyIterator extends AbstractIterator<C> {
        public Iterator<Map.Entry<C, V>> entryIterator;
        public final Iterator<Map<C, V>> mapIterator;
        public final Map<C, V> seen;

        private ColumnKeyIterator() {
            this.seen = (Map) StandardTable.this.factory.get();
            this.mapIterator = StandardTable.this.backingMap.values().iterator();
            this.entryIterator = Iterators.emptyIterator();
        }

        public C computeNext() {
            while (true) {
                if (this.entryIterator.hasNext()) {
                    Map.Entry next = this.entryIterator.next();
                    if (!this.seen.containsKey(next.getKey())) {
                        this.seen.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (!this.mapIterator.hasNext()) {
                    return endOfData();
                } else {
                    this.entryIterator = this.mapIterator.next().entrySet().iterator();
                }
            }
        }
    }

    public class ColumnKeySet extends StandardTable<R, C, V>.TableSet<C> {
        private ColumnKeySet() {
            super();
        }

        public boolean contains(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        public Iterator<C> iterator() {
            return StandardTable.this.createColumnKeyIterator();
        }

        public boolean remove(Object obj) {
            boolean z11 = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it2 = StandardTable.this.backingMap.values().iterator();
            while (it2.hasNext()) {
                Map next = it2.next();
                if (next.keySet().remove(obj)) {
                    z11 = true;
                    if (next.isEmpty()) {
                        it2.remove();
                    }
                }
            }
            return z11;
        }

        public boolean removeAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            Iterator<Map<C, V>> it2 = StandardTable.this.backingMap.values().iterator();
            boolean z11 = false;
            while (it2.hasNext()) {
                Map next = it2.next();
                if (Iterators.removeAll(next.keySet().iterator(), collection)) {
                    z11 = true;
                    if (next.isEmpty()) {
                        it2.remove();
                    }
                }
            }
            return z11;
        }

        public boolean retainAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            Iterator<Map<C, V>> it2 = StandardTable.this.backingMap.values().iterator();
            boolean z11 = false;
            while (it2.hasNext()) {
                Map next = it2.next();
                if (next.keySet().retainAll(collection)) {
                    z11 = true;
                    if (next.isEmpty()) {
                        it2.remove();
                    }
                }
            }
            return z11;
        }

        public int size() {
            return Iterators.size(iterator());
        }
    }

    public class ColumnMap extends Maps.ViewCachingAbstractMap<C, Map<R, V>> {

        public class ColumnMapEntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>> {
            public ColumnMapEntrySet() {
                super();
            }

            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!StandardTable.this.containsColumn(entry.getKey())) {
                    return false;
                }
                return ColumnMap.this.get(entry.getKey()).equals(entry.getValue());
            }

            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.asMapEntryIterator(StandardTable.this.columnKeySet(), new Function<C, Map<R, V>>() {
                    public Map<R, V> apply(C c11) {
                        return StandardTable.this.column(c11);
                    }
                });
            }

            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map unused = StandardTable.this.removeColumn(((Map.Entry) obj).getKey());
                return true;
            }

            public boolean removeAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                return Sets.removeAllImpl((Set<?>) this, collection.iterator());
            }

            public boolean retainAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                Iterator it2 = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z11 = false;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (!collection.contains(Maps.immutableEntry(next, StandardTable.this.column(next)))) {
                        Map unused = StandardTable.this.removeColumn(next);
                        z11 = true;
                    }
                }
                return z11;
            }

            public int size() {
                return StandardTable.this.columnKeySet().size();
            }
        }

        public class ColumnMapValues extends Maps.Values<C, Map<R, V>> {
            public ColumnMapValues() {
                super(ColumnMap.this);
            }

            public boolean remove(Object obj) {
                for (Map.Entry entry : ColumnMap.this.entrySet()) {
                    if (((Map) entry.getValue()).equals(obj)) {
                        Map unused = StandardTable.this.removeColumn(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            public boolean removeAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                Iterator it2 = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z11 = false;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (collection.contains(StandardTable.this.column(next))) {
                        Map unused = StandardTable.this.removeColumn(next);
                        z11 = true;
                    }
                }
                return z11;
            }

            public boolean retainAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                Iterator it2 = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z11 = false;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (!collection.contains(StandardTable.this.column(next))) {
                        Map unused = StandardTable.this.removeColumn(next);
                        z11 = true;
                    }
                }
                return z11;
            }
        }

        private ColumnMap() {
        }

        public boolean containsKey(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        public Set<Map.Entry<C, Map<R, V>>> createEntrySet() {
            return new ColumnMapEntrySet();
        }

        public Collection<Map<R, V>> createValues() {
            return new ColumnMapValues();
        }

        public Set<C> keySet() {
            return StandardTable.this.columnKeySet();
        }

        public Map<R, V> get(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.column(obj);
            }
            return null;
        }

        public Map<R, V> remove(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.removeColumn(obj);
            }
            return null;
        }
    }

    public class Row extends Maps.IteratorBasedAbstractMap<C, V> {
        public Map<C, V> backingRowMap;
        public final R rowKey;

        public Row(R r11) {
            this.rowKey = Preconditions.checkNotNull(r11);
        }

        public Map<C, V> backingRowMap() {
            Map<C, V> map = this.backingRowMap;
            if (map != null && (!map.isEmpty() || !StandardTable.this.backingMap.containsKey(this.rowKey))) {
                return this.backingRowMap;
            }
            Map<C, V> computeBackingRowMap = computeBackingRowMap();
            this.backingRowMap = computeBackingRowMap;
            return computeBackingRowMap;
        }

        public void clear() {
            Map backingRowMap2 = backingRowMap();
            if (backingRowMap2 != null) {
                backingRowMap2.clear();
            }
            maintainEmptyInvariant();
        }

        public Map<C, V> computeBackingRowMap() {
            return StandardTable.this.backingMap.get(this.rowKey);
        }

        public boolean containsKey(Object obj) {
            Map backingRowMap2 = backingRowMap();
            return (obj == null || backingRowMap2 == null || !Maps.safeContainsKey(backingRowMap2, obj)) ? false : true;
        }

        public Iterator<Map.Entry<C, V>> entryIterator() {
            Map backingRowMap2 = backingRowMap();
            if (backingRowMap2 == null) {
                return Iterators.emptyModifiableIterator();
            }
            final Iterator it2 = backingRowMap2.entrySet().iterator();
            return new Iterator<Map.Entry<C, V>>() {
                public boolean hasNext() {
                    return it2.hasNext();
                }

                public void remove() {
                    it2.remove();
                    Row.this.maintainEmptyInvariant();
                }

                public Map.Entry<C, V> next() {
                    return Row.this.wrapEntry((Map.Entry) it2.next());
                }
            };
        }

        public V get(Object obj) {
            Map backingRowMap2 = backingRowMap();
            if (obj == null || backingRowMap2 == null) {
                return null;
            }
            return Maps.safeGet(backingRowMap2, obj);
        }

        public void maintainEmptyInvariant() {
            if (backingRowMap() != null && this.backingRowMap.isEmpty()) {
                StandardTable.this.backingMap.remove(this.rowKey);
                this.backingRowMap = null;
            }
        }

        public V put(C c11, V v11) {
            Preconditions.checkNotNull(c11);
            Preconditions.checkNotNull(v11);
            Map<C, V> map = this.backingRowMap;
            if (map == null || map.isEmpty()) {
                return StandardTable.this.put(this.rowKey, c11, v11);
            }
            return this.backingRowMap.put(c11, v11);
        }

        public V remove(Object obj) {
            Map backingRowMap2 = backingRowMap();
            if (backingRowMap2 == null) {
                return null;
            }
            V safeRemove = Maps.safeRemove(backingRowMap2, obj);
            maintainEmptyInvariant();
            return safeRemove;
        }

        public int size() {
            Map backingRowMap2 = backingRowMap();
            if (backingRowMap2 == null) {
                return 0;
            }
            return backingRowMap2.size();
        }

        public Map.Entry<C, V> wrapEntry(final Map.Entry<C, V> entry) {
            return new ForwardingMapEntry<C, V>() {
                public boolean equals(Object obj) {
                    return standardEquals(obj);
                }

                public V setValue(V v11) {
                    return super.setValue(Preconditions.checkNotNull(v11));
                }

                public Map.Entry<C, V> delegate() {
                    return entry;
                }
            };
        }
    }

    public class RowMap extends Maps.ViewCachingAbstractMap<R, Map<C, V>> {

        public class EntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>> {
            public EntrySet() {
                super();
            }

            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getKey() == null || !(entry.getValue() instanceof Map) || !Collections2.safeContains(StandardTable.this.backingMap.entrySet(), entry)) {
                    return false;
                }
                return true;
            }

            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.asMapEntryIterator(StandardTable.this.backingMap.keySet(), new Function<R, Map<C, V>>() {
                    public Map<C, V> apply(R r11) {
                        return StandardTable.this.row(r11);
                    }
                });
            }

            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getKey() == null || !(entry.getValue() instanceof Map) || !StandardTable.this.backingMap.entrySet().remove(entry)) {
                    return false;
                }
                return true;
            }

            public int size() {
                return StandardTable.this.backingMap.size();
            }
        }

        public RowMap() {
        }

        public boolean containsKey(Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        public Set<Map.Entry<R, Map<C, V>>> createEntrySet() {
            return new EntrySet();
        }

        public Map<C, V> get(Object obj) {
            if (StandardTable.this.containsRow(obj)) {
                return StandardTable.this.row(obj);
            }
            return null;
        }

        public Map<C, V> remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return StandardTable.this.backingMap.remove(obj);
        }
    }

    public abstract class TableSet<T> extends Sets.ImprovedAbstractSet<T> {
        private TableSet() {
        }

        public void clear() {
            StandardTable.this.backingMap.clear();
        }

        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }
    }

    public StandardTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        this.backingMap = map;
        this.factory = supplier;
    }

    /* access modifiers changed from: private */
    public boolean containsMapping(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private Map<C, V> getOrCreate(R r11) {
        Map<C, V> map = this.backingMap.get(r11);
        if (map != null) {
            return map;
        }
        Map<C, V> map2 = (Map) this.factory.get();
        this.backingMap.put(r11, map2);
        return map2;
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Map<R, V> removeColumn(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it2 = this.backingMap.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            Object remove = ((Map) next.getValue()).remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (((Map) next.getValue()).isEmpty()) {
                    it2.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    public boolean removeMapping(Object obj, Object obj2, Object obj3) {
        if (!containsMapping(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    public Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new CellIterator();
    }

    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    public void clear() {
        this.backingMap.clear();
    }

    public Map<R, V> column(C c11) {
        return new Column(c11);
    }

    public Set<C> columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set != null) {
            return set;
        }
        ColumnKeySet columnKeySet2 = new ColumnKeySet();
        this.columnKeySet = columnKeySet2;
        return columnKeySet2;
    }

    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.ColumnMap columnMap2 = this.columnMap;
        if (columnMap2 != null) {
            return columnMap2;
        }
        StandardTable<R, C, V>.ColumnMap columnMap3 = new ColumnMap();
        this.columnMap = columnMap3;
        return columnMap3;
    }

    public boolean contains(Object obj, Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    public boolean containsColumn(Object obj) {
        if (obj == null) {
            return false;
        }
        for (Map<C, V> safeContainsKey : this.backingMap.values()) {
            if (Maps.safeContainsKey(safeContainsKey, obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsRow(Object obj) {
        return obj != null && Maps.safeContainsKey(this.backingMap, obj);
    }

    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Iterator<C> createColumnKeyIterator() {
        return new ColumnKeyIterator();
    }

    public Map<R, Map<C, V>> createRowMap() {
        return new RowMap();
    }

    public V get(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return super.get(obj, obj2);
    }

    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @CanIgnoreReturnValue
    public V put(R r11, C c11, V v11) {
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(c11);
        Preconditions.checkNotNull(v11);
        return getOrCreate(r11).put(c11, v11);
    }

    @CanIgnoreReturnValue
    public V remove(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.safeGet(this.backingMap, obj)) == null) {
            return null;
        }
        V remove = map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return remove;
    }

    public Map<C, V> row(R r11) {
        return new Row(r11);
    }

    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> createRowMap = createRowMap();
        this.rowMap = createRowMap;
        return createRowMap;
    }

    public int size() {
        int i11 = 0;
        for (Map<C, V> size : this.backingMap.values()) {
            i11 += size.size();
        }
        return i11;
    }

    public Collection<V> values() {
        return super.values();
    }
}
