package androidx.collection;

public final class CircularIntArray {

    /* renamed from: a  reason: collision with root package name */
    public int[] f6495a;

    /* renamed from: b  reason: collision with root package name */
    public int f6496b;

    public CircularIntArray() {
        this(8);
    }

    public CircularIntArray(int i11) {
        if (i11 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i11 <= 1073741824) {
            i11 = Integer.bitCount(i11) != 1 ? Integer.highestOneBit(i11 - 1) << 1 : i11;
            this.f6496b = i11 - 1;
            this.f6495a = new int[i11];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
    }
}
