package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class g extends h {

    /* renamed from: d  reason: collision with root package name */
    public final int f23123d;

    /* renamed from: e  reason: collision with root package name */
    public final DurationField f23124e;

    public g(DateTimeFieldType dateTimeFieldType, DurationField durationField, DurationField durationField2) {
        super(dateTimeFieldType, durationField);
        if (durationField2.isPrecise()) {
            int unitMillis = (int) (durationField2.getUnitMillis() / c());
            this.f23123d = unitMillis;
            if (unitMillis >= 2) {
                this.f23124e = durationField2;
                return;
            }
            throw new IllegalArgumentException("The effective range must be at least 2");
        }
        throw new IllegalArgumentException("Range duration field must be precise");
    }

    public long addWrapField(long j11, int i11) {
        int i12 = get(j11);
        return j11 + (((long) (e.c(i12, i11, getMinimumValue(), getMaximumValue()) - i12)) * c());
    }

    public int get(long j11) {
        if (j11 >= 0) {
            return (int) ((j11 / c()) % ((long) this.f23123d));
        }
        return (this.f23123d - 1) + ((int) (((j11 + 1) / c()) % ((long) this.f23123d)));
    }

    public int getMaximumValue() {
        return this.f23123d - 1;
    }

    public DurationField getRangeDurationField() {
        return this.f23124e;
    }

    public long set(long j11, int i11) {
        e.m(this, i11, getMinimumValue(), getMaximumValue());
        return j11 + (((long) (i11 - get(j11))) * this.f23125b);
    }
}
