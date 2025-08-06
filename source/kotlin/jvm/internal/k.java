package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ShortIterator;

public final class k extends ShortIterator {

    /* renamed from: b  reason: collision with root package name */
    public final short[] f56783b;

    /* renamed from: c  reason: collision with root package name */
    public int f56784c;

    public k(short[] sArr) {
        this.f56783b = sArr;
    }

    public short a() {
        try {
            short[] sArr = this.f56783b;
            int i11 = this.f56784c;
            this.f56784c = i11 + 1;
            return sArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f56784c--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    public boolean hasNext() {
        return this.f56784c < this.f56783b.length;
    }
}
