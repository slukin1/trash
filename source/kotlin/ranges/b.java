package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.x;

public final class b extends CharIterator {

    /* renamed from: b  reason: collision with root package name */
    public final int f56828b;

    /* renamed from: c  reason: collision with root package name */
    public final int f56829c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56830d;

    /* renamed from: e  reason: collision with root package name */
    public int f56831e;

    public b(char c11, char c12, int i11) {
        this.f56828b = i11;
        this.f56829c = c12;
        boolean z11 = true;
        if (i11 <= 0 ? x.c(c11, c12) < 0 : x.c(c11, c12) > 0) {
            z11 = false;
        }
        this.f56830d = z11;
        this.f56831e = !z11 ? c12 : c11;
    }

    public char a() {
        int i11 = this.f56831e;
        if (i11 != this.f56829c) {
            this.f56831e = this.f56828b + i11;
        } else if (this.f56830d) {
            this.f56830d = false;
        } else {
            throw new NoSuchElementException();
        }
        return (char) i11;
    }

    public boolean hasNext() {
        return this.f56830d;
    }
}
