package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.LongIterator;

public final class j extends LongIterator {

    /* renamed from: b  reason: collision with root package name */
    public final long f56850b;

    /* renamed from: c  reason: collision with root package name */
    public final long f56851c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56852d;

    /* renamed from: e  reason: collision with root package name */
    public long f56853e;

    public j(long j11, long j12, long j13) {
        this.f56850b = j13;
        this.f56851c = j12;
        boolean z11 = true;
        if (j13 <= 0 ? j11 < j12 : j11 > j12) {
            z11 = false;
        }
        this.f56852d = z11;
        this.f56853e = !z11 ? j12 : j11;
    }

    public long a() {
        long j11 = this.f56853e;
        if (j11 != this.f56851c) {
            this.f56853e = this.f56850b + j11;
        } else if (this.f56852d) {
            this.f56852d = false;
        } else {
            throw new NoSuchElementException();
        }
        return j11;
    }

    public boolean hasNext() {
        return this.f56852d;
    }
}
