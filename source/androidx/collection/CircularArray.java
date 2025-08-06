package androidx.collection;

public final class CircularArray<E> {

    /* renamed from: a  reason: collision with root package name */
    public E[] f6493a;

    /* renamed from: b  reason: collision with root package name */
    public int f6494b;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int i11) {
        if (i11 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i11 <= 1073741824) {
            i11 = Integer.bitCount(i11) != 1 ? Integer.highestOneBit(i11 - 1) << 1 : i11;
            this.f6494b = i11 - 1;
            this.f6493a = new Object[i11];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
    }
}
