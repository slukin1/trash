package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.AbstractMap;
import java.util.Map;

final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    public static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap((int[]) null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    public final transient Object[] alternatingKeysAndValues;
    private final transient int[] hashTable;
    private final transient int size;

    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        /* access modifiers changed from: private */
        public final transient Object[] alternatingKeysAndValues;
        /* access modifiers changed from: private */
        public final transient int keyOffset;
        private final transient ImmutableMap<K, V> map;
        /* access modifiers changed from: private */
        public final transient int size;

        public EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i11, int i12) {
            this.map = immutableMap;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i11;
            this.size = i12;
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.map.get(key))) {
                return false;
            }
            return true;
        }

        public int copyIntoArray(Object[] objArr, int i11) {
            return asList().copyIntoArray(objArr, i11);
        }

        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() {
                public int size() {
                    return EntrySet.this.size;
                }

                public Map.Entry<K, V> get(int i11) {
                    Preconditions.g(i11, EntrySet.this.size);
                    int i12 = i11 * 2;
                    return new AbstractMap.SimpleImmutableEntry(EntrySet.this.alternatingKeysAndValues[EntrySet.this.keyOffset + i12], EntrySet.this.alternatingKeysAndValues[i12 + (EntrySet.this.keyOffset ^ 1)]);
                }
            };
        }

        public int size() {
            return this.size;
        }

        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    public static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> list;
        private final transient ImmutableMap<K, ?> map;

        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.map = immutableMap;
            this.list = immutableList;
        }

        public ImmutableList<K> asList() {
            return this.list;
        }

        public boolean contains(Object obj) {
            return this.map.get(obj) != null;
        }

        public int copyIntoArray(Object[] objArr, int i11) {
            return asList().copyIntoArray(objArr, i11);
        }

        public int size() {
            return this.map.size();
        }

        public UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }
    }

    public static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        public KeysOrValuesAsList(Object[] objArr, int i11, int i12) {
            this.alternatingKeysAndValues = objArr;
            this.offset = i11;
            this.size = i12;
        }

        public Object get(int i11) {
            Preconditions.g(i11, this.size);
            return this.alternatingKeysAndValues[(i11 * 2) + this.offset];
        }

        public int size() {
            return this.size;
        }
    }

    private RegularImmutableMap(int[] iArr, Object[] objArr, int i11) {
        this.hashTable = iArr;
        this.alternatingKeysAndValues = objArr;
        this.size = i11;
    }

    public static <K, V> RegularImmutableMap<K, V> create(int i11, Object[] objArr) {
        if (i11 == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i11 == 1) {
            CollectPreconditions.a(objArr[0], objArr[1]);
            return new RegularImmutableMap<>((int[]) null, objArr, 1);
        }
        Preconditions.l(i11, objArr.length >> 1);
        return new RegularImmutableMap<>(createHashTable(objArr, i11, ImmutableSet.chooseTableSize(i11), 0), objArr, i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        r12[r7] = r5;
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] createHashTable(java.lang.Object[] r10, int r11, int r12, int r13) {
        /*
            r0 = 1
            if (r11 != r0) goto L_0x000e
            r11 = r10[r13]
            r12 = r13 ^ 1
            r10 = r10[r12]
            androidx.test.espresso.core.internal.deps.guava.collect.CollectPreconditions.a(r11, r10)
            r10 = 0
            return r10
        L_0x000e:
            int r1 = r12 + -1
            int[] r12 = new int[r12]
            r2 = -1
            java.util.Arrays.fill(r12, r2)
            r3 = 0
        L_0x0017:
            if (r3 >= r11) goto L_0x009b
            int r4 = r3 * 2
            int r5 = r4 + r13
            r6 = r10[r5]
            r7 = r13 ^ 1
            int r4 = r4 + r7
            r4 = r10[r4]
            androidx.test.espresso.core.internal.deps.guava.collect.CollectPreconditions.a(r6, r4)
            int r7 = r6.hashCode()
            int r7 = androidx.test.espresso.core.internal.deps.guava.collect.Hashing.a(r7)
        L_0x002f:
            r7 = r7 & r1
            r8 = r12[r7]
            if (r8 != r2) goto L_0x0039
            r12[r7] = r5
            int r3 = r3 + 1
            goto L_0x0017
        L_0x0039:
            r9 = r10[r8]
            boolean r9 = r9.equals(r6)
            if (r9 != 0) goto L_0x0044
            int r7 = r7 + 1
            goto L_0x002f
        L_0x0044:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = java.lang.String.valueOf(r6)
            java.lang.String r13 = java.lang.String.valueOf(r4)
            r1 = r10[r8]
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0 = r0 ^ r8
            r10 = r10[r0]
            java.lang.String r10 = java.lang.String.valueOf(r10)
            int r0 = r12.length()
            int r0 = r0 + 39
            int r2 = r13.length()
            int r0 = r0 + r2
            int r2 = r1.length()
            int r0 = r0 + r2
            int r2 = r10.length()
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "Multiple entries with same key: "
            r2.append(r0)
            r2.append(r12)
            java.lang.String r12 = "="
            r2.append(r12)
            r2.append(r13)
            java.lang.String r13 = " and "
            r2.append(r13)
            r2.append(r1)
            r2.append(r12)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            r11.<init>(r10)
            throw r11
        L_0x009b:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.collect.RegularImmutableMap.createHashTable(java.lang.Object[], int, int, int):int[]");
    }

    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }

    public V get(Object obj) {
        return get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.size;
    }

    public static Object get(int[] iArr, Object[] objArr, int i11, int i12, Object obj) {
        if (obj == null) {
            return null;
        }
        if (i11 == 1) {
            if (objArr[i12].equals(obj)) {
                return objArr[i12 ^ 1];
            }
            return null;
        } else if (iArr == null) {
            return null;
        } else {
            int length = iArr.length - 1;
            int a11 = Hashing.a(obj.hashCode());
            while (true) {
                int i13 = a11 & length;
                int i14 = iArr[i13];
                if (i14 == -1) {
                    return null;
                }
                if (objArr[i14].equals(obj)) {
                    return objArr[i14 ^ 1];
                }
                a11 = i13 + 1;
            }
        }
    }
}
