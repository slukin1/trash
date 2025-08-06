package kotlin.ranges;

import a10.b;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.r;

public class f implements Iterable<Integer>, e10.a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f56836e = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final int f56837b;

    /* renamed from: c  reason: collision with root package name */
    public final int f56838c;

    /* renamed from: d  reason: collision with root package name */
    public final int f56839d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final f a(int i11, int i12, int i13) {
            return new f(i11, i12, i13);
        }
    }

    public f(int i11, int i12, int i13) {
        if (i13 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i13 != Integer.MIN_VALUE) {
            this.f56837b = i11;
            this.f56838c = b.c(i11, i12, i13);
            this.f56839d = i13;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int a() {
        return this.f56837b;
    }

    public final int b() {
        return this.f56838c;
    }

    public final int c() {
        return this.f56839d;
    }

    /* renamed from: d */
    public IntIterator iterator() {
        return new g(this.f56837b, this.f56838c, this.f56839d);
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            if (!isEmpty() || !((f) obj).isEmpty()) {
                f fVar = (f) obj;
                if (!(this.f56837b == fVar.f56837b && this.f56838c == fVar.f56838c && this.f56839d == fVar.f56839d)) {
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
        return (((this.f56837b * 31) + this.f56838c) * 31) + this.f56839d;
    }

    public boolean isEmpty() {
        if (this.f56839d > 0) {
            if (this.f56837b > this.f56838c) {
                return true;
            }
        } else if (this.f56837b < this.f56838c) {
            return true;
        }
        return false;
    }

    public String toString() {
        int i11;
        StringBuilder sb2;
        if (this.f56839d > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f56837b);
            sb2.append("..");
            sb2.append(this.f56838c);
            sb2.append(" step ");
            i11 = this.f56839d;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f56837b);
            sb2.append(" downTo ");
            sb2.append(this.f56838c);
            sb2.append(" step ");
            i11 = -this.f56839d;
        }
        sb2.append(i11);
        return sb2.toString();
    }
}
