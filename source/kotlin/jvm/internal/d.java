package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.DoubleIterator;

public final class d extends DoubleIterator {

    /* renamed from: b  reason: collision with root package name */
    public final double[] f56772b;

    /* renamed from: c  reason: collision with root package name */
    public int f56773c;

    public d(double[] dArr) {
        this.f56772b = dArr;
    }

    public double a() {
        try {
            double[] dArr = this.f56772b;
            int i11 = this.f56773c;
            this.f56773c = i11 + 1;
            return dArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f56773c--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    public boolean hasNext() {
        return this.f56773c < this.f56772b.length;
    }
}
