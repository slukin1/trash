package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.LongIterator;

public final class j extends LongIterator {

    /* renamed from: b  reason: collision with root package name */
    public final long[] f56781b;

    /* renamed from: c  reason: collision with root package name */
    public int f56782c;

    public j(long[] jArr) {
        this.f56781b = jArr;
    }

    public long a() {
        try {
            long[] jArr = this.f56781b;
            int i11 = this.f56782c;
            this.f56782c = i11 + 1;
            return jArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f56782c--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    public boolean hasNext() {
        return this.f56782c < this.f56781b.length;
    }
}
