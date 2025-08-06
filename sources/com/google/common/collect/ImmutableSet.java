package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    public static final int MAX_TABLE_SIZE = 1073741824;
    @RetainedWith
    @LazyInit
    private transient ImmutableList<E> asList;

    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        private int hashCode;
        @VisibleForTesting
        public Object[] hashTable;

        public Builder() {
            super(4);
        }

        private void addDeduping(E e11) {
            int length = this.hashTable.length - 1;
            int hashCode2 = e11.hashCode();
            int smear = Hashing.smear(hashCode2);
            while (true) {
                int i11 = smear & length;
                Object[] objArr = this.hashTable;
                Object obj = objArr[i11];
                if (obj == null) {
                    objArr[i11] = e11;
                    this.hashCode += hashCode2;
                    super.add(e11);
                    return;
                } else if (!obj.equals(e11)) {
                    smear = i11 + 1;
                } else {
                    return;
                }
            }
        }

        public Builder(int i11) {
            super(i11);
            this.hashTable = new Object[ImmutableSet.chooseTableSize(i11)];
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.common.collect.RegularImmutableSet} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.google.common.collect.ImmutableSet} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.common.collect.RegularImmutableSet} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.common.collect.RegularImmutableSet} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.common.collect.ImmutableSet<E> build() {
            /*
                r8 = this;
                int r0 = r8.size
                if (r0 == 0) goto L_0x0059
                r1 = 1
                if (r0 == r1) goto L_0x004f
                java.lang.Object[] r2 = r8.hashTable
                if (r2 == 0) goto L_0x003b
                int r0 = com.google.common.collect.ImmutableSet.chooseTableSize(r0)
                java.lang.Object[] r2 = r8.hashTable
                int r2 = r2.length
                if (r0 != r2) goto L_0x003b
                int r0 = r8.size
                java.lang.Object[] r2 = r8.contents
                int r2 = r2.length
                boolean r0 = com.google.common.collect.ImmutableSet.shouldTrim(r0, r2)
                if (r0 == 0) goto L_0x0028
                java.lang.Object[] r0 = r8.contents
                int r2 = r8.size
                java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
                goto L_0x002a
            L_0x0028:
                java.lang.Object[] r0 = r8.contents
            L_0x002a:
                r3 = r0
                com.google.common.collect.RegularImmutableSet r0 = new com.google.common.collect.RegularImmutableSet
                int r4 = r8.hashCode
                java.lang.Object[] r5 = r8.hashTable
                int r2 = r5.length
                int r6 = r2 + -1
                int r7 = r8.size
                r2 = r0
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x0049
            L_0x003b:
                int r0 = r8.size
                java.lang.Object[] r2 = r8.contents
                com.google.common.collect.ImmutableSet r0 = com.google.common.collect.ImmutableSet.construct(r0, r2)
                int r2 = r0.size()
                r8.size = r2
            L_0x0049:
                r8.forceCopy = r1
                r1 = 0
                r8.hashTable = r1
                return r0
            L_0x004f:
                java.lang.Object[] r0 = r8.contents
                r1 = 0
                r0 = r0[r1]
                com.google.common.collect.ImmutableSet r0 = com.google.common.collect.ImmutableSet.of(r0)
                return r0
            L_0x0059:
                com.google.common.collect.ImmutableSet r0 = com.google.common.collect.ImmutableSet.of()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableSet.Builder.build():com.google.common.collect.ImmutableSet");
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            Preconditions.checkNotNull(iterable);
            if (this.hashTable != null) {
                for (Object add : iterable) {
                    add((Object) add);
                }
            } else {
                super.addAll(iterable);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E e11) {
            Preconditions.checkNotNull(e11);
            if (this.hashTable == null || ImmutableSet.chooseTableSize(this.size) > this.hashTable.length) {
                this.hashTable = null;
                super.add(e11);
                return this;
            }
            addDeduping(e11);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it2) {
            Preconditions.checkNotNull(it2);
            while (it2.hasNext()) {
                add((Object) it2.next());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            if (this.hashTable != null) {
                for (E add : eArr) {
                    add((Object) add);
                }
            } else {
                super.add(eArr);
            }
            return this;
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf((E[]) this.elements);
        }
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    @Beta
    public static <E> Builder<E> builderWithExpectedSize(int i11) {
        CollectPreconditions.checkNonnegative(i11, "expectedSize");
        return new Builder<>(i11);
    }

    @VisibleForTesting
    static int chooseTableSize(int i11) {
        int max = Math.max(i11, 2);
        boolean z11 = true;
        if (max < CUTOFF) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * DESIRED_LOAD_FACTOR < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "collection too large");
        return 1073741824;
    }

    /* access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i11, Object... objArr) {
        if (i11 == 0) {
            return of();
        }
        if (i11 == 1) {
            return of(objArr[0]);
        }
        int chooseTableSize = chooseTableSize(i11);
        Object[] objArr2 = new Object[chooseTableSize];
        int i12 = chooseTableSize - 1;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i11; i15++) {
            Object checkElementNotNull = ObjectArrays.checkElementNotNull(objArr[i15], i15);
            int hashCode = checkElementNotNull.hashCode();
            int smear = Hashing.smear(hashCode);
            while (true) {
                int i16 = smear & i12;
                Object obj = objArr2[i16];
                if (obj == null) {
                    objArr[i14] = checkElementNotNull;
                    objArr2[i16] = checkElementNotNull;
                    i13 += hashCode;
                    i14++;
                    break;
                } else if (obj.equals(checkElementNotNull)) {
                    break;
                } else {
                    smear++;
                }
            }
        }
        Arrays.fill(objArr, i14, i11, (Object) null);
        if (i14 == 1) {
            return new SingletonImmutableSet(objArr[0], i13);
        }
        if (chooseTableSize(i14) < chooseTableSize / 2) {
            return construct(i14, objArr);
        }
        if (shouldTrim(i14, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i14);
        }
        return new RegularImmutableSet(objArr, i13, objArr2, i12, i14);
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    /* access modifiers changed from: private */
    public static boolean shouldTrim(int i11, int i12) {
        return i11 < (i12 >> 1) + (i12 >> 2);
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.asList = createAsList;
        return createAsList;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableSet) || !isHashCodeFast() || !((ImmutableSet) obj).isHashCodeFast() || hashCode() == obj.hashCode()) {
            return Sets.equalsImpl(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    /* access modifiers changed from: package-private */
    public boolean isHashCodeFast() {
        return false;
    }

    public abstract UnmodifiableIterator<E> iterator();

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e11) {
        return new SingletonImmutableSet(e11);
    }

    public static <E> ImmutableSet<E> of(E e11, E e12) {
        return construct(2, e11, e12);
    }

    public static <E> ImmutableSet<E> of(E e11, E e12, E e13) {
        return construct(3, e11, e12, e13);
    }

    public static <E> ImmutableSet<E> of(E e11, E e12, E e13, E e14) {
        return construct(4, e11, e12, e13, e14);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e11, E e12, E e13, E e14, E e15) {
        return construct(5, e11, e12, e13, e14, e15);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E... eArr) {
        Preconditions.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e11;
        objArr[1] = e12;
        objArr[2] = e13;
        objArr[3] = e14;
        objArr[4] = e15;
        objArr[5] = e16;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it2) {
        if (!it2.hasNext()) {
            return of();
        }
        Object next = it2.next();
        if (!it2.hasNext()) {
            return of(next);
        }
        return new Builder().add((Object) next).addAll((Iterator) it2).build();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return construct(eArr.length, (Object[]) eArr.clone());
        }
        return of(eArr[0]);
    }
}
