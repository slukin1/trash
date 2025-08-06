package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.BooleanIterator;

public final class a extends BooleanIterator {

    /* renamed from: b  reason: collision with root package name */
    public final boolean[] f56762b;

    /* renamed from: c  reason: collision with root package name */
    public int f56763c;

    public a(boolean[] zArr) {
        this.f56762b = zArr;
    }

    public boolean a() {
        try {
            boolean[] zArr = this.f56762b;
            int i11 = this.f56763c;
            this.f56763c = i11 + 1;
            return zArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f56763c--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    public boolean hasNext() {
        return this.f56763c < this.f56762b.length;
    }
}
