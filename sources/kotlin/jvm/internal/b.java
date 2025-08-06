package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ByteIterator;

public final class b extends ByteIterator {

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f56766b;

    /* renamed from: c  reason: collision with root package name */
    public int f56767c;

    public b(byte[] bArr) {
        this.f56766b = bArr;
    }

    public boolean hasNext() {
        return this.f56767c < this.f56766b.length;
    }

    public byte nextByte() {
        try {
            byte[] bArr = this.f56766b;
            int i11 = this.f56767c;
            this.f56767c = i11 + 1;
            return bArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f56767c--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }
}
