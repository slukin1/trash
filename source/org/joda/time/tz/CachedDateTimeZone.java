package org.joda.time.tz;

import org.joda.time.DateTimeZone;

public class CachedDateTimeZone extends DateTimeZone {
    private static final int cInfoCacheMask;
    private static final long serialVersionUID = 5472298452022250685L;
    private final transient a[] iInfoCache = new a[(cInfoCacheMask + 1)];
    private final DateTimeZone iZone;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f25385a;

        /* renamed from: b  reason: collision with root package name */
        public final DateTimeZone f25386b;

        /* renamed from: c  reason: collision with root package name */
        public a f25387c;

        /* renamed from: d  reason: collision with root package name */
        public String f25388d;

        /* renamed from: e  reason: collision with root package name */
        public int f25389e = Integer.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        public int f25390f = Integer.MIN_VALUE;

        public a(DateTimeZone dateTimeZone, long j11) {
            this.f25385a = j11;
            this.f25386b = dateTimeZone;
        }

        public String a(long j11) {
            a aVar = this.f25387c;
            if (aVar != null && j11 >= aVar.f25385a) {
                return aVar.a(j11);
            }
            if (this.f25388d == null) {
                this.f25388d = this.f25386b.getNameKey(this.f25385a);
            }
            return this.f25388d;
        }

        public int b(long j11) {
            a aVar = this.f25387c;
            if (aVar != null && j11 >= aVar.f25385a) {
                return aVar.b(j11);
            }
            if (this.f25389e == Integer.MIN_VALUE) {
                this.f25389e = this.f25386b.getOffset(this.f25385a);
            }
            return this.f25389e;
        }

        public int c(long j11) {
            a aVar = this.f25387c;
            if (aVar != null && j11 >= aVar.f25385a) {
                return aVar.c(j11);
            }
            if (this.f25390f == Integer.MIN_VALUE) {
                this.f25390f = this.f25386b.getStandardOffset(this.f25385a);
            }
            return this.f25390f;
        }
    }

    static {
        Integer num;
        int i11;
        try {
            num = Integer.getInteger("org.joda.time.tz.CachedDateTimeZone.size");
        } catch (SecurityException unused) {
            num = null;
        }
        if (num == null) {
            i11 = 512;
        } else {
            int i12 = 0;
            for (int intValue = num.intValue() - 1; intValue > 0; intValue >>= 1) {
                i12++;
            }
            i11 = 1 << i12;
        }
        cInfoCacheMask = i11 - 1;
    }

    private CachedDateTimeZone(DateTimeZone dateTimeZone) {
        super(dateTimeZone.getID());
        this.iZone = dateTimeZone;
    }

    private a createInfo(long j11) {
        long j12 = j11 & -4294967296L;
        a aVar = new a(this.iZone, j12);
        long j13 = 4294967295L | j12;
        a aVar2 = aVar;
        while (true) {
            long nextTransition = this.iZone.nextTransition(j12);
            if (nextTransition == j12 || nextTransition > j13) {
                return aVar;
            }
            a aVar3 = new a(this.iZone, nextTransition);
            aVar2.f25387c = aVar3;
            aVar2 = aVar3;
            j12 = nextTransition;
        }
        return aVar;
    }

    public static CachedDateTimeZone forZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone instanceof CachedDateTimeZone) {
            return (CachedDateTimeZone) dateTimeZone;
        }
        return new CachedDateTimeZone(dateTimeZone);
    }

    private a getInfo(long j11) {
        int i11 = (int) (j11 >> 32);
        a[] aVarArr = this.iInfoCache;
        int i12 = cInfoCacheMask & i11;
        a aVar = aVarArr[i12];
        if (aVar != null && ((int) (aVar.f25385a >> 32)) == i11) {
            return aVar;
        }
        a createInfo = createInfo(j11);
        aVarArr[i12] = createInfo;
        return createInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CachedDateTimeZone) {
            return this.iZone.equals(((CachedDateTimeZone) obj).iZone);
        }
        return false;
    }

    public String getNameKey(long j11) {
        return getInfo(j11).a(j11);
    }

    public int getOffset(long j11) {
        return getInfo(j11).b(j11);
    }

    public int getStandardOffset(long j11) {
        return getInfo(j11).c(j11);
    }

    public DateTimeZone getUncachedZone() {
        return this.iZone;
    }

    public int hashCode() {
        return this.iZone.hashCode();
    }

    public boolean isFixed() {
        return this.iZone.isFixed();
    }

    public long nextTransition(long j11) {
        return this.iZone.nextTransition(j11);
    }

    public long previousTransition(long j11) {
        return this.iZone.previousTransition(j11);
    }
}
