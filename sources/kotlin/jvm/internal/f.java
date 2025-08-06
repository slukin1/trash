package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

public final class f extends IntIterator {

    /* renamed from: b  reason: collision with root package name */
    public final int[] f56777b;

    /* renamed from: c  reason: collision with root package name */
    public int f56778c;

    public f(int[] iArr) {
        this.f56777b = iArr;
    }

    public int a() {
        try {
            int[] iArr = this.f56777b;
            int i11 = this.f56778c;
            this.f56778c = i11 + 1;
            return iArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f56778c--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    public boolean hasNext() {
        return this.f56778c < this.f56777b.length;
    }
}
