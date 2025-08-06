package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import java.util.LinkedHashMap;
import java.util.Map;

@GwtCompatible
@Immutable(containerOf = {"R", "C", "V"})
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    public static final ImmutableTable<Object, Object, Object> EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    private final int[] cellColumnInRowIndices;
    private final int[] cellRowIndices;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    public SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap<R, Integer> indexMap = Maps.indexMap(immutableSet);
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        UnmodifiableIterator<R> it2 = immutableSet.iterator();
        while (it2.hasNext()) {
            newLinkedHashMap.put(it2.next(), new LinkedHashMap());
        }
        LinkedHashMap newLinkedHashMap2 = Maps.newLinkedHashMap();
        UnmodifiableIterator<C> it3 = immutableSet2.iterator();
        while (it3.hasNext()) {
            newLinkedHashMap2.put(it3.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i11 = 0; i11 < immutableList.size(); i11++) {
            Table.Cell cell = immutableList.get(i11);
            Object rowKey = cell.getRowKey();
            Object columnKey = cell.getColumnKey();
            Object value = cell.getValue();
            iArr[i11] = indexMap.get(rowKey).intValue();
            Map map = (Map) newLinkedHashMap.get(rowKey);
            iArr2[i11] = map.size();
            checkNoDuplicate(rowKey, columnKey, map.put(columnKey, value), value);
            ((Map) newLinkedHashMap2.get(columnKey)).put(rowKey, value);
        }
        this.cellRowIndices = iArr;
        this.cellColumnInRowIndices = iArr2;
        ImmutableMap.Builder builder = new ImmutableMap.Builder(newLinkedHashMap.size());
        for (Map.Entry entry : newLinkedHashMap.entrySet()) {
            builder.put(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.rowMap = builder.build();
        ImmutableMap.Builder builder2 = new ImmutableMap.Builder(newLinkedHashMap2.size());
        for (Map.Entry entry2 : newLinkedHashMap2.entrySet()) {
            builder2.put(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.columnMap = builder2.build();
    }

    public ImmutableTable.SerializedForm createSerializedForm() {
        ImmutableMap indexMap = Maps.indexMap(columnKeySet());
        int[] iArr = new int[cellSet().size()];
        UnmodifiableIterator it2 = cellSet().iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            iArr[i11] = ((Integer) indexMap.get(((Table.Cell) it2.next()).getColumnKey())).intValue();
            i11++;
        }
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, iArr);
    }

    public Table.Cell<R, C, V> getCell(int i11) {
        Map.Entry entry = this.rowMap.entrySet().asList().get(this.cellRowIndices[i11]);
        Map.Entry entry2 = (Map.Entry) ((ImmutableMap) entry.getValue()).entrySet().asList().get(this.cellColumnInRowIndices[i11]);
        return ImmutableTable.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    public V getValue(int i11) {
        int i12 = this.cellRowIndices[i11];
        return this.rowMap.values().asList().get(i12).values().asList().get(this.cellColumnInRowIndices[i11]);
    }

    public int size() {
        return this.cellRowIndices.length;
    }

    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.columnMap);
    }

    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.rowMap);
    }
}
