package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.CharIterator;

public final class c extends CharIterator {

    /* renamed from: b  reason: collision with root package name */
    public final char[] f56769b;

    /* renamed from: c  reason: collision with root package name */
    public int f56770c;

    public c(char[] cArr) {
        this.f56769b = cArr;
    }

    public char a() {
        try {
            char[] cArr = this.f56769b;
            int i11 = this.f56770c;
            this.f56770c = i11 + 1;
            return cArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f56770c--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    public boolean hasNext() {
        return this.f56770c < this.f56769b.length;
    }
}
