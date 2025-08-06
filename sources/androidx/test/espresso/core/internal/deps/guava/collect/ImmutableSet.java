package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private transient ImmutableList<E> asList;

    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {

        /* renamed from: d  reason: collision with root package name */
        public Object[] f11317d;

        /* renamed from: e  reason: collision with root package name */
        public int f11318e;

        public Builder() {
            super(4);
        }

        public Builder<E> e(E e11) {
            Preconditions.i(e11);
            if (this.f11317d == null || ImmutableSet.chooseTableSize(this.f11310b) > this.f11317d.length) {
                this.f11317d = null;
                super.b(e11);
                return this;
            }
            g(e11);
            return this;
        }

        public Builder<E> f(E... eArr) {
            if (this.f11317d != null) {
                for (E e11 : eArr) {
                    e(e11);
                }
            } else {
                super.c(eArr);
            }
            return this;
        }

        public final void g(E e11) {
            int length = this.f11317d.length - 1;
            int hashCode = e11.hashCode();
            int a11 = Hashing.a(hashCode);
            while (true) {
                int i11 = a11 & length;
                Object[] objArr = this.f11317d;
                Object obj = objArr[i11];
                if (obj == null) {
                    objArr[i11] = e11;
                    this.f11318e += hashCode;
                    super.b(e11);
                    return;
                } else if (!obj.equals(e11)) {
                    a11 = i11 + 1;
                } else {
                    return;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: androidx.test.espresso.core.internal.deps.guava.collect.RegularImmutableSet} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: androidx.test.espresso.core.internal.deps.guava.collect.RegularImmutableSet} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: androidx.test.espresso.core.internal.deps.guava.collect.RegularImmutableSet} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet<E> h() {
            /*
                r8 = this;
                int r0 = r8.f11310b
                if (r0 == 0) goto L_0x0059
                r1 = 1
                if (r0 == r1) goto L_0x004f
                java.lang.Object[] r2 = r8.f11317d
                if (r2 == 0) goto L_0x003b
                int r0 = androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet.chooseTableSize(r0)
                java.lang.Object[] r2 = r8.f11317d
                int r2 = r2.length
                if (r0 != r2) goto L_0x003b
                int r0 = r8.f11310b
                java.lang.Object[] r2 = r8.f11309a
                int r2 = r2.length
                boolean r0 = androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet.shouldTrim(r0, r2)
                if (r0 == 0) goto L_0x0028
                java.lang.Object[] r0 = r8.f11309a
                int r2 = r8.f11310b
                java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
                goto L_0x002a
            L_0x0028:
                java.lang.Object[] r0 = r8.f11309a
            L_0x002a:
                r3 = r0
                androidx.test.espresso.core.internal.deps.guava.collect.RegularImmutableSet r0 = new androidx.test.espresso.core.internal.deps.guava.collect.RegularImmutableSet
                int r4 = r8.f11318e
                java.lang.Object[] r5 = r8.f11317d
                int r2 = r5.length
                int r6 = r2 + -1
                int r7 = r8.f11310b
                r2 = r0
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x0049
            L_0x003b:
                int r0 = r8.f11310b
                java.lang.Object[] r2 = r8.f11309a
                androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet r0 = androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet.construct(r0, r2)
                int r2 = r0.size()
                r8.f11310b = r2
            L_0x0049:
                r8.f11311c = r1
                r1 = 0
                r8.f11317d = r1
                return r0
            L_0x004f:
                java.lang.Object[] r0 = r8.f11309a
                r1 = 0
                r0 = r0[r1]
                androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet r0 = androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet.of(r0)
                return r0
            L_0x0059:
                androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet r0 = androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet.of()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet.Builder.h():androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet");
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    public static int chooseTableSize(int i11) {
        int max = Math.max(i11, 2);
        boolean z11 = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z11 = false;
        }
        Preconditions.e(z11, "collection too large");
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
            Object a11 = ObjectArrays.a(objArr[i15], i15);
            int hashCode = a11.hashCode();
            int a12 = Hashing.a(hashCode);
            while (true) {
                int i16 = a12 & i12;
                Object obj = objArr2[i16];
                if (obj == null) {
                    objArr[i14] = a11;
                    objArr2[i16] = a11;
                    i13 += hashCode;
                    i14++;
                    break;
                } else if (obj.equals(a11)) {
                    break;
                } else {
                    a12++;
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
            return Sets.a(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return Sets.b(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract UnmodifiableIterator<E> iterator();

    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e11) {
        return new SingletonImmutableSet(e11);
    }
}
