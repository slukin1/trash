package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class ArrayDeque<E> extends d<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f56626e = new a((r) null);

    /* renamed from: f  reason: collision with root package name */
    public static final Object[] f56627f = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    public int f56628b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f56629c;

    /* renamed from: d  reason: collision with root package name */
    public int f56630d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final int a(int i11, int i12) {
            int i13 = i11 + (i11 >> 1);
            if (i13 - i12 < 0) {
                i13 = i12;
            }
            return i13 - 2147483639 > 0 ? i12 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i13;
        }
    }

    public ArrayDeque(int i11) {
        Object[] objArr;
        if (i11 == 0) {
            objArr = f56627f;
        } else if (i11 > 0) {
            objArr = new Object[i11];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + i11);
        }
        this.f56629c = objArr;
    }

    public final void a(int i11, Collection<? extends E> collection) {
        Iterator<? extends E> it2 = collection.iterator();
        int length = this.f56629c.length;
        while (i11 < length && it2.hasNext()) {
            this.f56629c[i11] = it2.next();
            i11++;
        }
        int i12 = this.f56628b;
        for (int i13 = 0; i13 < i12 && it2.hasNext(); i13++) {
            this.f56629c[i13] = it2.next();
        }
        this.f56630d = size() + collection.size();
    }

    public boolean add(E e11) {
        addLast(e11);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ensureCapacity(size() + collection.size());
        a(j(this.f56628b + size()), collection);
        return true;
    }

    public final void addFirst(E e11) {
        ensureCapacity(size() + 1);
        int c11 = c(this.f56628b);
        this.f56628b = c11;
        this.f56629c[c11] = e11;
        this.f56630d = size() + 1;
    }

    public final void addLast(E e11) {
        ensureCapacity(size() + 1);
        this.f56629c[j(this.f56628b + size())] = e11;
        this.f56630d = size() + 1;
    }

    public final void b(int i11) {
        Object[] objArr = new Object[i11];
        Object[] objArr2 = this.f56629c;
        Object[] unused = ArraysKt___ArraysJvmKt.f(objArr2, objArr, 0, this.f56628b, objArr2.length);
        Object[] objArr3 = this.f56629c;
        int length = objArr3.length;
        int i12 = this.f56628b;
        Object[] unused2 = ArraysKt___ArraysJvmKt.f(objArr3, objArr, length - i12, 0, i12);
        this.f56628b = 0;
        this.f56629c = objArr;
    }

    public final int c(int i11) {
        return i11 == 0 ? ArraysKt___ArraysKt.L(this.f56629c) : i11 - 1;
    }

    public void clear() {
        int j11 = j(this.f56628b + size());
        int i11 = this.f56628b;
        if (i11 < j11) {
            ArraysKt___ArraysJvmKt.m(this.f56629c, null, i11, j11);
        } else if (!isEmpty()) {
            Object[] objArr = this.f56629c;
            ArraysKt___ArraysJvmKt.m(objArr, null, this.f56628b, objArr.length);
            ArraysKt___ArraysJvmKt.m(this.f56629c, null, 0, j11);
        }
        this.f56628b = 0;
        this.f56630d = 0;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final E d() {
        if (isEmpty()) {
            return null;
        }
        return this.f56629c[this.f56628b];
    }

    public final void ensureCapacity(int i11) {
        if (i11 >= 0) {
            Object[] objArr = this.f56629c;
            if (i11 > objArr.length) {
                if (objArr == f56627f) {
                    this.f56629c = new Object[RangesKt___RangesKt.d(i11, 10)];
                } else {
                    b(f56626e.a(objArr.length, i11));
                }
            }
        } else {
            throw new IllegalStateException("Deque is too big.");
        }
    }

    public final E first() {
        if (!isEmpty()) {
            return this.f56629c[this.f56628b];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final int g(int i11) {
        if (i11 == ArraysKt___ArraysKt.L(this.f56629c)) {
            return 0;
        }
        return i11 + 1;
    }

    public E get(int i11) {
        a.Companion.b(i11, size());
        return this.f56629c[j(this.f56628b + i11)];
    }

    public int getSize() {
        return this.f56630d;
    }

    public final E h() {
        if (isEmpty()) {
            return null;
        }
        return this.f56629c[j(this.f56628b + CollectionsKt__CollectionsKt.m(this))];
    }

    public final int i(int i11) {
        return i11 < 0 ? i11 + this.f56629c.length : i11;
    }

    public int indexOf(Object obj) {
        int i11;
        int j11 = j(this.f56628b + size());
        int i12 = this.f56628b;
        if (i12 < j11) {
            while (i12 < j11) {
                if (x.b(obj, this.f56629c[i12])) {
                    i11 = this.f56628b;
                } else {
                    i12++;
                }
            }
            return -1;
        } else if (i12 < j11) {
            return -1;
        } else {
            int length = this.f56629c.length;
            while (true) {
                if (i12 >= length) {
                    int i13 = 0;
                    while (i13 < j11) {
                        if (x.b(obj, this.f56629c[i13])) {
                            i12 = i13 + this.f56629c.length;
                            i11 = this.f56628b;
                        } else {
                            i13++;
                        }
                    }
                    return -1;
                } else if (x.b(obj, this.f56629c[i12])) {
                    i11 = this.f56628b;
                    break;
                } else {
                    i12++;
                }
            }
        }
        return i12 - i11;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final int j(int i11) {
        Object[] objArr = this.f56629c;
        return i11 >= objArr.length ? i11 - objArr.length : i11;
    }

    public final E k() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E l() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    public final E last() {
        if (!isEmpty()) {
            return this.f56629c[j(this.f56628b + CollectionsKt__CollectionsKt.m(this))];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public int lastIndexOf(Object obj) {
        int i11;
        int i12;
        int j11 = j(this.f56628b + size());
        int i13 = this.f56628b;
        if (i13 < j11) {
            i11 = j11 - 1;
            if (i13 <= i11) {
                while (!x.b(obj, this.f56629c[i11])) {
                    if (i11 != i13) {
                        i11--;
                    }
                }
                i12 = this.f56628b;
            }
            return -1;
        }
        if (i13 > j11) {
            int i14 = j11 - 1;
            while (true) {
                if (-1 >= i14) {
                    int L = ArraysKt___ArraysKt.L(this.f56629c);
                    int i15 = this.f56628b;
                    if (i15 <= L) {
                        while (!x.b(obj, this.f56629c[i11])) {
                            if (i11 != i15) {
                                L = i11 - 1;
                            }
                        }
                        i12 = this.f56628b;
                    }
                } else if (x.b(obj, this.f56629c[i14])) {
                    i11 = i14 + this.f56629c.length;
                    i12 = this.f56628b;
                    break;
                } else {
                    i14--;
                }
            }
        }
        return -1;
        return i11 - i12;
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeAll(java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0091
            java.lang.Object[] r0 = r11.f56629c
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x000f
            r0 = r2
            goto L_0x0010
        L_0x000f:
            r0 = r1
        L_0x0010:
            if (r0 == 0) goto L_0x0014
            goto L_0x0091
        L_0x0014:
            int r0 = r11.f56628b
            int r3 = r11.size()
            int r0 = r0 + r3
            int r0 = r11.j(r0)
            int r3 = r11.f56628b
            r4 = 0
            if (r3 >= r0) goto L_0x0044
            r5 = r3
        L_0x0025:
            if (r3 >= r0) goto L_0x003e
            java.lang.Object[] r6 = r11.f56629c
            r6 = r6[r3]
            boolean r7 = r12.contains(r6)
            r7 = r7 ^ r2
            if (r7 == 0) goto L_0x003a
            java.lang.Object[] r7 = r11.f56629c
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003b
        L_0x003a:
            r1 = r2
        L_0x003b:
            int r3 = r3 + 1
            goto L_0x0025
        L_0x003e:
            java.lang.Object[] r12 = r11.f56629c
            kotlin.collections.ArraysKt___ArraysJvmKt.m(r12, r4, r5, r0)
            goto L_0x0086
        L_0x0044:
            java.lang.Object[] r5 = r11.f56629c
            int r5 = r5.length
            r7 = r1
            r6 = r3
        L_0x0049:
            if (r3 >= r5) goto L_0x0064
            java.lang.Object[] r8 = r11.f56629c
            r9 = r8[r3]
            r8[r3] = r4
            boolean r8 = r12.contains(r9)
            r8 = r8 ^ r2
            if (r8 == 0) goto L_0x0060
            java.lang.Object[] r8 = r11.f56629c
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0061
        L_0x0060:
            r7 = r2
        L_0x0061:
            int r3 = r3 + 1
            goto L_0x0049
        L_0x0064:
            int r3 = r11.j(r6)
            r5 = r3
        L_0x0069:
            if (r1 >= r0) goto L_0x0085
            java.lang.Object[] r3 = r11.f56629c
            r6 = r3[r1]
            r3[r1] = r4
            boolean r3 = r12.contains(r6)
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0081
            java.lang.Object[] r3 = r11.f56629c
            r3[r5] = r6
            int r5 = r11.g(r5)
            goto L_0x0082
        L_0x0081:
            r7 = r2
        L_0x0082:
            int r1 = r1 + 1
            goto L_0x0069
        L_0x0085:
            r1 = r7
        L_0x0086:
            if (r1 == 0) goto L_0x0091
            int r12 = r11.f56628b
            int r5 = r5 - r12
            int r12 = r11.i(r5)
            r11.f56630d = r12
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.removeAll(java.util.Collection):boolean");
    }

    public E removeAt(int i11) {
        a.Companion.b(i11, size());
        if (i11 == CollectionsKt__CollectionsKt.m(this)) {
            return removeLast();
        }
        if (i11 == 0) {
            return removeFirst();
        }
        int j11 = j(this.f56628b + i11);
        E e11 = this.f56629c[j11];
        if (i11 < (size() >> 1)) {
            int i12 = this.f56628b;
            if (j11 >= i12) {
                Object[] objArr = this.f56629c;
                Object[] unused = ArraysKt___ArraysJvmKt.f(objArr, objArr, i12 + 1, i12, j11);
            } else {
                Object[] objArr2 = this.f56629c;
                Object[] unused2 = ArraysKt___ArraysJvmKt.f(objArr2, objArr2, 1, 0, j11);
                Object[] objArr3 = this.f56629c;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i13 = this.f56628b;
                Object[] unused3 = ArraysKt___ArraysJvmKt.f(objArr3, objArr3, i13 + 1, i13, objArr3.length - 1);
            }
            Object[] objArr4 = this.f56629c;
            int i14 = this.f56628b;
            objArr4[i14] = null;
            this.f56628b = g(i14);
        } else {
            int j12 = j(this.f56628b + CollectionsKt__CollectionsKt.m(this));
            if (j11 <= j12) {
                Object[] objArr5 = this.f56629c;
                Object[] unused4 = ArraysKt___ArraysJvmKt.f(objArr5, objArr5, j11, j11 + 1, j12 + 1);
            } else {
                Object[] objArr6 = this.f56629c;
                Object[] unused5 = ArraysKt___ArraysJvmKt.f(objArr6, objArr6, j11, j11 + 1, objArr6.length);
                Object[] objArr7 = this.f56629c;
                objArr7[objArr7.length - 1] = objArr7[0];
                Object[] unused6 = ArraysKt___ArraysJvmKt.f(objArr7, objArr7, 0, 1, j12 + 1);
            }
            this.f56629c[j12] = null;
        }
        this.f56630d = size() - 1;
        return e11;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            E[] eArr = this.f56629c;
            int i11 = this.f56628b;
            E e11 = eArr[i11];
            eArr[i11] = null;
            this.f56628b = g(i11);
            this.f56630d = size() - 1;
            return e11;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int j11 = j(this.f56628b + CollectionsKt__CollectionsKt.m(this));
            E[] eArr = this.f56629c;
            E e11 = eArr[j11];
            eArr[j11] = null;
            this.f56630d = size() - 1;
            return e11;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retainAll(java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x008e
            java.lang.Object[] r0 = r11.f56629c
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x000f
            r0 = r2
            goto L_0x0010
        L_0x000f:
            r0 = r1
        L_0x0010:
            if (r0 == 0) goto L_0x0014
            goto L_0x008e
        L_0x0014:
            int r0 = r11.f56628b
            int r3 = r11.size()
            int r0 = r0 + r3
            int r0 = r11.j(r0)
            int r3 = r11.f56628b
            r4 = 0
            if (r3 >= r0) goto L_0x0043
            r5 = r3
        L_0x0025:
            if (r3 >= r0) goto L_0x003d
            java.lang.Object[] r6 = r11.f56629c
            r6 = r6[r3]
            boolean r7 = r12.contains(r6)
            if (r7 == 0) goto L_0x0039
            java.lang.Object[] r7 = r11.f56629c
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003a
        L_0x0039:
            r1 = r2
        L_0x003a:
            int r3 = r3 + 1
            goto L_0x0025
        L_0x003d:
            java.lang.Object[] r12 = r11.f56629c
            kotlin.collections.ArraysKt___ArraysJvmKt.m(r12, r4, r5, r0)
            goto L_0x0083
        L_0x0043:
            java.lang.Object[] r5 = r11.f56629c
            int r5 = r5.length
            r7 = r1
            r6 = r3
        L_0x0048:
            if (r3 >= r5) goto L_0x0062
            java.lang.Object[] r8 = r11.f56629c
            r9 = r8[r3]
            r8[r3] = r4
            boolean r8 = r12.contains(r9)
            if (r8 == 0) goto L_0x005e
            java.lang.Object[] r8 = r11.f56629c
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x005f
        L_0x005e:
            r7 = r2
        L_0x005f:
            int r3 = r3 + 1
            goto L_0x0048
        L_0x0062:
            int r3 = r11.j(r6)
            r5 = r3
        L_0x0067:
            if (r1 >= r0) goto L_0x0082
            java.lang.Object[] r3 = r11.f56629c
            r6 = r3[r1]
            r3[r1] = r4
            boolean r3 = r12.contains(r6)
            if (r3 == 0) goto L_0x007e
            java.lang.Object[] r3 = r11.f56629c
            r3[r5] = r6
            int r5 = r11.g(r5)
            goto L_0x007f
        L_0x007e:
            r7 = r2
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0067
        L_0x0082:
            r1 = r7
        L_0x0083:
            if (r1 == 0) goto L_0x008e
            int r12 = r11.f56628b
            int r5 = r5 - r12
            int r12 = r11.i(r5)
            r11.f56630d = r12
        L_0x008e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.retainAll(java.util.Collection):boolean");
    }

    public E set(int i11, E e11) {
        a.Companion.b(i11, size());
        int j11 = j(this.f56628b + i11);
        E[] eArr = this.f56629c;
        E e12 = eArr[j11];
        eArr[j11] = e11;
        return e12;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < size()) {
            tArr = ArraysKt__ArraysJVMKt.a(tArr, size());
        }
        int j11 = j(this.f56628b + size());
        int i11 = this.f56628b;
        if (i11 < j11) {
            Object[] unused = ArraysKt___ArraysJvmKt.h(this.f56629c, tArr, 0, i11, j11, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f56629c;
            Object[] unused2 = ArraysKt___ArraysJvmKt.f(objArr, tArr, 0, this.f56628b, objArr.length);
            Object[] objArr2 = this.f56629c;
            Object[] unused3 = ArraysKt___ArraysJvmKt.f(objArr2, tArr, objArr2.length - this.f56628b, 0, j11);
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }

    public void add(int i11, E e11) {
        a.Companion.c(i11, size());
        if (i11 == size()) {
            addLast(e11);
        } else if (i11 == 0) {
            addFirst(e11);
        } else {
            ensureCapacity(size() + 1);
            int j11 = j(this.f56628b + i11);
            if (i11 < ((size() + 1) >> 1)) {
                int c11 = c(j11);
                int c12 = c(this.f56628b);
                int i12 = this.f56628b;
                if (c11 >= i12) {
                    Object[] objArr = this.f56629c;
                    objArr[c12] = objArr[i12];
                    Object[] unused = ArraysKt___ArraysJvmKt.f(objArr, objArr, i12, i12 + 1, c11 + 1);
                } else {
                    Object[] objArr2 = this.f56629c;
                    Object[] unused2 = ArraysKt___ArraysJvmKt.f(objArr2, objArr2, i12 - 1, i12, objArr2.length);
                    Object[] objArr3 = this.f56629c;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    Object[] unused3 = ArraysKt___ArraysJvmKt.f(objArr3, objArr3, 0, 1, c11 + 1);
                }
                this.f56629c[c11] = e11;
                this.f56628b = c12;
            } else {
                int j12 = j(this.f56628b + size());
                if (j11 < j12) {
                    Object[] objArr4 = this.f56629c;
                    Object[] unused4 = ArraysKt___ArraysJvmKt.f(objArr4, objArr4, j11 + 1, j11, j12);
                } else {
                    Object[] objArr5 = this.f56629c;
                    Object[] unused5 = ArraysKt___ArraysJvmKt.f(objArr5, objArr5, 1, 0, j12);
                    Object[] objArr6 = this.f56629c;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    Object[] unused6 = ArraysKt___ArraysJvmKt.f(objArr6, objArr6, j11 + 1, j11, objArr6.length - 1);
                }
                this.f56629c[j11] = e11;
            }
            this.f56630d = size() + 1;
        }
    }

    public boolean addAll(int i11, Collection<? extends E> collection) {
        a.Companion.c(i11, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i11 == size()) {
            return addAll(collection);
        }
        ensureCapacity(size() + collection.size());
        int j11 = j(this.f56628b + size());
        int j12 = j(this.f56628b + i11);
        int size = collection.size();
        if (i11 < ((size() + 1) >> 1)) {
            int i12 = this.f56628b;
            int i13 = i12 - size;
            if (j12 < i12) {
                Object[] objArr = this.f56629c;
                Object[] unused = ArraysKt___ArraysJvmKt.f(objArr, objArr, i13, i12, objArr.length);
                if (size >= j12) {
                    Object[] objArr2 = this.f56629c;
                    Object[] unused2 = ArraysKt___ArraysJvmKt.f(objArr2, objArr2, objArr2.length - size, 0, j12);
                } else {
                    Object[] objArr3 = this.f56629c;
                    Object[] unused3 = ArraysKt___ArraysJvmKt.f(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f56629c;
                    Object[] unused4 = ArraysKt___ArraysJvmKt.f(objArr4, objArr4, 0, size, j12);
                }
            } else if (i13 >= 0) {
                Object[] objArr5 = this.f56629c;
                Object[] unused5 = ArraysKt___ArraysJvmKt.f(objArr5, objArr5, i13, i12, j12);
            } else {
                Object[] objArr6 = this.f56629c;
                i13 += objArr6.length;
                int i14 = j12 - i12;
                int length = objArr6.length - i13;
                if (length >= i14) {
                    Object[] unused6 = ArraysKt___ArraysJvmKt.f(objArr6, objArr6, i13, i12, j12);
                } else {
                    Object[] unused7 = ArraysKt___ArraysJvmKt.f(objArr6, objArr6, i13, i12, i12 + length);
                    Object[] objArr7 = this.f56629c;
                    Object[] unused8 = ArraysKt___ArraysJvmKt.f(objArr7, objArr7, 0, this.f56628b + length, j12);
                }
            }
            this.f56628b = i13;
            a(i(j12 - size), collection);
        } else {
            int i15 = j12 + size;
            if (j12 < j11) {
                int i16 = size + j11;
                Object[] objArr8 = this.f56629c;
                if (i16 <= objArr8.length) {
                    Object[] unused9 = ArraysKt___ArraysJvmKt.f(objArr8, objArr8, i15, j12, j11);
                } else if (i15 >= objArr8.length) {
                    Object[] unused10 = ArraysKt___ArraysJvmKt.f(objArr8, objArr8, i15 - objArr8.length, j12, j11);
                } else {
                    int length2 = j11 - (i16 - objArr8.length);
                    Object[] unused11 = ArraysKt___ArraysJvmKt.f(objArr8, objArr8, 0, length2, j11);
                    Object[] objArr9 = this.f56629c;
                    Object[] unused12 = ArraysKt___ArraysJvmKt.f(objArr9, objArr9, i15, j12, length2);
                }
            } else {
                Object[] objArr10 = this.f56629c;
                Object[] unused13 = ArraysKt___ArraysJvmKt.f(objArr10, objArr10, size, 0, j11);
                Object[] objArr11 = this.f56629c;
                if (i15 >= objArr11.length) {
                    Object[] unused14 = ArraysKt___ArraysJvmKt.f(objArr11, objArr11, i15 - objArr11.length, j12, objArr11.length);
                } else {
                    Object[] unused15 = ArraysKt___ArraysJvmKt.f(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f56629c;
                    Object[] unused16 = ArraysKt___ArraysJvmKt.f(objArr12, objArr12, i15, j12, objArr12.length - size);
                }
            }
            a(j12, collection);
        }
        return true;
    }

    public ArrayDeque() {
        this.f56629c = f56627f;
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
