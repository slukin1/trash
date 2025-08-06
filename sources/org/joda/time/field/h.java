package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public abstract class h extends b {

    /* renamed from: b  reason: collision with root package name */
    public final long f23125b;

    /* renamed from: c  reason: collision with root package name */
    public final DurationField f23126c;

    public h(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        super(dateTimeFieldType);
        if (durationField.isPrecise()) {
            long unitMillis = durationField.getUnitMillis();
            this.f23125b = unitMillis;
            if (unitMillis >= 1) {
                this.f23126c = durationField;
                return;
            }
            throw new IllegalArgumentException("The unit milliseconds must be at least 1");
        }
        throw new IllegalArgumentException("Unit duration field must be precise");
    }

    public int b(long j11, int i11) {
        return getMaximumValue(j11);
    }

    public final long c() {
        return this.f23125b;
    }

    public DurationField getDurationField() {
        return this.f23126c;
    }

    public int getMinimumValue() {
        return 0;
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j11) {
        if (j11 >= 0) {
            return j11 % this.f23125b;
        }
        long j12 = this.f23125b;
        return (((j11 + 1) % j12) + j12) - 1;
    }

    public long roundCeiling(long j11) {
        if (j11 <= 0) {
            return j11 - (j11 % this.f23125b);
        }
        long j12 = j11 - 1;
        long j13 = this.f23125b;
        return (j12 - (j12 % j13)) + j13;
    }

    public long roundFloor(long j11) {
        long j12;
        if (j11 >= 0) {
            j12 = j11 % this.f23125b;
        } else {
            long j13 = j11 + 1;
            j12 = this.f23125b;
            j11 = j13 - (j13 % j12);
        }
        return j11 - j12;
    }

    public long set(long j11, int i11) {
        e.m(this, i11, getMinimumValue(), b(j11, i11));
        return j11 + (((long) (i11 - get(j11))) * this.f23125b);
    }
}
