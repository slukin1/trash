package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class y extends a<Long> implements u.h, RandomAccess, o0 {

    /* renamed from: e  reason: collision with root package name */
    public static final y f9250e;

    /* renamed from: c  reason: collision with root package name */
    public long[] f9251c;

    /* renamed from: d  reason: collision with root package name */
    public int f9252d;

    static {
        y yVar = new y(new long[0], 0);
        f9250e = yVar;
        yVar.makeImmutable();
    }

    public y() {
        this(new long[10], 0);
    }

    public boolean addAll(Collection<? extends Long> collection) {
        a();
        u.a(collection);
        if (!(collection instanceof y)) {
            return super.addAll(collection);
        }
        y yVar = (y) collection;
        int i11 = yVar.f9252d;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.f9252d;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            long[] jArr = this.f9251c;
            if (i13 > jArr.length) {
                this.f9251c = Arrays.copyOf(jArr, i13);
            }
            System.arraycopy(yVar.f9251c, 0, this.f9251c, this.f9252d, yVar.f9252d);
            this.f9252d = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addLong(long j11) {
        a();
        int i11 = this.f9252d;
        long[] jArr = this.f9251c;
        if (i11 == jArr.length) {
            long[] jArr2 = new long[(((i11 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            this.f9251c = jArr2;
        }
        long[] jArr3 = this.f9251c;
        int i12 = this.f9252d;
        this.f9252d = i12 + 1;
        jArr3[i12] = j11;
    }

    /* renamed from: b */
    public void add(int i11, Long l11) {
        d(i11, l11.longValue());
    }

    /* renamed from: c */
    public boolean add(Long l11) {
        addLong(l11.longValue());
        return true;
    }

    public final void d(int i11, long j11) {
        int i12;
        a();
        if (i11 < 0 || i11 > (i12 = this.f9252d)) {
            throw new IndexOutOfBoundsException(h(i11));
        }
        long[] jArr = this.f9251c;
        if (i12 < jArr.length) {
            System.arraycopy(jArr, i11, jArr, i11 + 1, i12 - i11);
        } else {
            long[] jArr2 = new long[(((i12 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            System.arraycopy(this.f9251c, i11, jArr2, i11 + 1, this.f9252d - i11);
            this.f9251c = jArr2;
        }
        this.f9251c[i11] = j11;
        this.f9252d++;
        this.modCount++;
    }

    public final void e(int i11) {
        if (i11 < 0 || i11 >= this.f9252d) {
            throw new IndexOutOfBoundsException(h(i11));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return super.equals(obj);
        }
        y yVar = (y) obj;
        if (this.f9252d != yVar.f9252d) {
            return false;
        }
        long[] jArr = yVar.f9251c;
        for (int i11 = 0; i11 < this.f9252d; i11++) {
            if (this.f9251c[i11] != jArr[i11]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public Long get(int i11) {
        return Long.valueOf(getLong(i11));
    }

    public long getLong(int i11) {
        e(i11);
        return this.f9251c[i11];
    }

    public final String h(int i11) {
        return "Index:" + i11 + ", Size:" + this.f9252d;
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.f9252d; i12++) {
            i11 = (i11 * 31) + u.f(this.f9251c[i12]);
        }
        return i11;
    }

    /* renamed from: i */
    public u.h mutableCopyWithCapacity(int i11) {
        if (i11 >= this.f9252d) {
            return new y(Arrays.copyOf(this.f9251c, i11), this.f9252d);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: j */
    public Long remove(int i11) {
        a();
        e(i11);
        long[] jArr = this.f9251c;
        long j11 = jArr[i11];
        int i12 = this.f9252d;
        if (i11 < i12 - 1) {
            System.arraycopy(jArr, i11 + 1, jArr, i11, (i12 - i11) - 1);
        }
        this.f9252d--;
        this.modCount++;
        return Long.valueOf(j11);
    }

    /* renamed from: k */
    public Long set(int i11, Long l11) {
        return Long.valueOf(setLong(i11, l11.longValue()));
    }

    public void removeRange(int i11, int i12) {
        a();
        if (i12 >= i11) {
            long[] jArr = this.f9251c;
            System.arraycopy(jArr, i12, jArr, i11, this.f9252d - i12);
            this.f9252d -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public long setLong(int i11, long j11) {
        a();
        e(i11);
        long[] jArr = this.f9251c;
        long j12 = jArr[i11];
        jArr[i11] = j11;
        return j12;
    }

    public int size() {
        return this.f9252d;
    }

    public y(long[] jArr, int i11) {
        this.f9251c = jArr;
        this.f9252d = i11;
    }

    public boolean remove(Object obj) {
        a();
        for (int i11 = 0; i11 < this.f9252d; i11++) {
            if (obj.equals(Long.valueOf(this.f9251c[i11]))) {
                long[] jArr = this.f9251c;
                System.arraycopy(jArr, i11 + 1, jArr, i11, (this.f9252d - i11) - 1);
                this.f9252d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
