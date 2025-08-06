package kotlinx.serialization.internal;

import d10.p;
import kotlin.jvm.internal.r;
import kotlinx.serialization.descriptors.f;

public final class z {

    /* renamed from: e  reason: collision with root package name */
    public static final a f57797e = new a((r) null);
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final long[] f57798f = new long[0];

    /* renamed from: a  reason: collision with root package name */
    public final f f57799a;

    /* renamed from: b  reason: collision with root package name */
    public final p<f, Integer, Boolean> f57800b;

    /* renamed from: c  reason: collision with root package name */
    public long f57801c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f57802d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public z(f fVar, p<? super f, ? super Integer, Boolean> pVar) {
        this.f57799a = fVar;
        this.f57800b = pVar;
        int e11 = fVar.e();
        long j11 = 0;
        if (e11 <= 64) {
            this.f57801c = e11 != 64 ? -1 << e11 : j11;
            this.f57802d = f57798f;
            return;
        }
        this.f57801c = 0;
        this.f57802d = e(e11);
    }

    public final void a(int i11) {
        if (i11 < 64) {
            this.f57801c |= 1 << i11;
        } else {
            b(i11);
        }
    }

    public final void b(int i11) {
        int i12 = (i11 >>> 6) - 1;
        long[] jArr = this.f57802d;
        jArr[i12] = jArr[i12] | (1 << (i11 & 63));
    }

    public final int c() {
        int length = this.f57802d.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            int i13 = i12 * 64;
            long j11 = this.f57802d[i11];
            while (j11 != -1) {
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(~j11);
                j11 |= 1 << numberOfTrailingZeros;
                int i14 = numberOfTrailingZeros + i13;
                if (this.f57800b.invoke(this.f57799a, Integer.valueOf(i14)).booleanValue()) {
                    this.f57802d[i11] = j11;
                    return i14;
                }
            }
            this.f57802d[i11] = j11;
            i11 = i12;
        }
        return -1;
    }

    public final int d() {
        int numberOfTrailingZeros;
        int e11 = this.f57799a.e();
        do {
            long j11 = this.f57801c;
            if (j11 != -1) {
                numberOfTrailingZeros = Long.numberOfTrailingZeros(~j11);
                this.f57801c |= 1 << numberOfTrailingZeros;
            } else if (e11 > 64) {
                return c();
            } else {
                return -1;
            }
        } while (!this.f57800b.invoke(this.f57799a, Integer.valueOf(numberOfTrailingZeros)).booleanValue());
        return numberOfTrailingZeros;
    }

    public final long[] e(int i11) {
        long[] jArr = new long[((i11 - 1) >>> 6)];
        if ((i11 & 63) != 0) {
            jArr[ArraysKt___ArraysKt.K(jArr)] = -1 << i11;
        }
        return jArr;
    }
}
