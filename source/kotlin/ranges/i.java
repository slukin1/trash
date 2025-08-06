package kotlin.ranges;

import a10.b;
import kotlin.collections.LongIterator;
import kotlin.jvm.internal.r;

public class i implements Iterable<Long>, e10.a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f56846e = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final long f56847b;

    /* renamed from: c  reason: collision with root package name */
    public final long f56848c;

    /* renamed from: d  reason: collision with root package name */
    public final long f56849d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final i a(long j11, long j12, long j13) {
            return new i(j11, j12, j13);
        }
    }

    public i(long j11, long j12, long j13) {
        if (j13 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j13 != Long.MIN_VALUE) {
            this.f56847b = j11;
            this.f56848c = b.d(j11, j12, j13);
            this.f56849d = j13;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final long a() {
        return this.f56847b;
    }

    public final long b() {
        return this.f56848c;
    }

    /* renamed from: c */
    public LongIterator iterator() {
        return new j(this.f56847b, this.f56848c, this.f56849d);
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            if (!isEmpty() || !((i) obj).isEmpty()) {
                i iVar = (i) obj;
                if (!(this.f56847b == iVar.f56847b && this.f56848c == iVar.f56848c && this.f56849d == iVar.f56849d)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j11 = (long) 31;
        long j12 = this.f56847b;
        long j13 = this.f56848c;
        long j14 = j11 * (((j12 ^ (j12 >>> 32)) * j11) + (j13 ^ (j13 >>> 32)));
        long j15 = this.f56849d;
        return (int) (j14 + (j15 ^ (j15 >>> 32)));
    }

    public boolean isEmpty() {
        int i11 = (this.f56849d > 0 ? 1 : (this.f56849d == 0 ? 0 : -1));
        long j11 = this.f56847b;
        long j12 = this.f56848c;
        if (i11 > 0) {
            if (j11 > j12) {
                return true;
            }
        } else if (j11 < j12) {
            return true;
        }
        return false;
    }

    public String toString() {
        long j11;
        StringBuilder sb2;
        if (this.f56849d > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f56847b);
            sb2.append("..");
            sb2.append(this.f56848c);
            sb2.append(" step ");
            j11 = this.f56849d;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f56847b);
            sb2.append(" downTo ");
            sb2.append(this.f56848c);
            sb2.append(" step ");
            j11 = -this.f56849d;
        }
        sb2.append(j11);
        return sb2.toString();
    }
}
