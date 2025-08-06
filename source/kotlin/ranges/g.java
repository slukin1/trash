package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

public final class g extends IntIterator {

    /* renamed from: b  reason: collision with root package name */
    public final int f56840b;

    /* renamed from: c  reason: collision with root package name */
    public final int f56841c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56842d;

    /* renamed from: e  reason: collision with root package name */
    public int f56843e;

    public g(int i11, int i12, int i13) {
        this.f56840b = i13;
        this.f56841c = i12;
        boolean z11 = true;
        if (i13 <= 0 ? i11 < i12 : i11 > i12) {
            z11 = false;
        }
        this.f56842d = z11;
        this.f56843e = !z11 ? i12 : i11;
    }

    public int a() {
        int i11 = this.f56843e;
        if (i11 != this.f56841c) {
            this.f56843e = this.f56840b + i11;
        } else if (this.f56842d) {
            this.f56842d = false;
        } else {
            throw new NoSuchElementException();
        }
        return i11;
    }

    public boolean hasNext() {
        return this.f56842d;
    }
}
