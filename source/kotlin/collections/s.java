package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

public final class s<T> extends a<T> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f56661b;

    /* renamed from: c  reason: collision with root package name */
    public final int f56662c;

    /* renamed from: d  reason: collision with root package name */
    public int f56663d;

    /* renamed from: e  reason: collision with root package name */
    public int f56664e;

    public static final class a extends AbstractIterator<T> {

        /* renamed from: d  reason: collision with root package name */
        public int f56665d;

        /* renamed from: e  reason: collision with root package name */
        public int f56666e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s<T> f56667f;

        public a(s<T> sVar) {
            this.f56667f = sVar;
            this.f56665d = sVar.size();
            this.f56666e = sVar.f56663d;
        }

        public void a() {
            if (this.f56665d == 0) {
                b();
                return;
            }
            c(this.f56667f.f56661b[this.f56666e]);
            this.f56666e = (this.f56666e + 1) % this.f56667f.f56662c;
            this.f56665d--;
        }
    }

    public s(Object[] objArr, int i11) {
        this.f56661b = objArr;
        boolean z11 = true;
        if (i11 >= 0) {
            if (i11 > objArr.length ? false : z11) {
                this.f56662c = objArr.length;
                this.f56664e = i11;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i11 + " cannot be larger than the buffer size: " + objArr.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i11).toString());
    }

    public final void d(T t11) {
        if (!h()) {
            this.f56661b[(this.f56663d + size()) % this.f56662c] = t11;
            this.f56664e = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    public final s<T> g(int i11) {
        int i12 = this.f56662c;
        int g11 = RangesKt___RangesKt.g(i12 + (i12 >> 1) + 1, i11);
        return new s<>(this.f56663d == 0 ? Arrays.copyOf(this.f56661b, g11) : toArray(new Object[g11]), size());
    }

    public T get(int i11) {
        a.Companion.b(i11, size());
        return this.f56661b[(this.f56663d + i11) % this.f56662c];
    }

    public int getSize() {
        return this.f56664e;
    }

    public final boolean h() {
        return size() == this.f56662c;
    }

    public final void i(int i11) {
        boolean z11 = true;
        if (i11 >= 0) {
            if (i11 > size()) {
                z11 = false;
            }
            if (!z11) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i11 + ", size = " + size()).toString());
            } else if (i11 > 0) {
                int i12 = this.f56663d;
                int b11 = (i12 + i11) % this.f56662c;
                if (i12 > b11) {
                    ArraysKt___ArraysJvmKt.m(this.f56661b, null, i12, this.f56662c);
                    ArraysKt___ArraysJvmKt.m(this.f56661b, null, 0, b11);
                } else {
                    ArraysKt___ArraysJvmKt.m(this.f56661b, null, i12, b11);
                }
                this.f56663d = b11;
                this.f56664e = size() - i11;
            }
        } else {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i11).toString());
        }
    }

    public Iterator<T> iterator() {
        return new a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < size()) {
            tArr = Arrays.copyOf(tArr, size());
        }
        int size = size();
        int i11 = this.f56663d;
        int i12 = 0;
        int i13 = 0;
        while (i13 < size && i11 < this.f56662c) {
            tArr[i13] = this.f56661b[i11];
            i13++;
            i11++;
        }
        while (i13 < size) {
            tArr[i13] = this.f56661b[i12];
            i13++;
            i12++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }

    public s(int i11) {
        this(new Object[i11], 0);
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
