package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class i extends c {

    /* renamed from: c  reason: collision with root package name */
    public final int f23127c;

    /* renamed from: d  reason: collision with root package name */
    public final DurationField f23128d;

    /* renamed from: e  reason: collision with root package name */
    public final DurationField f23129e;

    public i(DateTimeField dateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType, int i11) {
        super(dateTimeField, dateTimeFieldType);
        if (i11 >= 2) {
            this.f23129e = durationField;
            this.f23128d = dateTimeField.getDurationField();
            this.f23127c = i11;
            return;
        }
        throw new IllegalArgumentException("The divisor must be at least 2");
    }

    public long addWrapField(long j11, int i11) {
        return set(j11, e.c(get(j11), i11, 0, this.f23127c - 1));
    }

    public final int b(int i11) {
        if (i11 >= 0) {
            return i11 / this.f23127c;
        }
        return ((i11 + 1) / this.f23127c) - 1;
    }

    public int get(long j11) {
        int i11 = getWrappedField().get(j11);
        if (i11 >= 0) {
            return i11 % this.f23127c;
        }
        int i12 = this.f23127c;
        return (i12 - 1) + ((i11 + 1) % i12);
    }

    public DurationField getDurationField() {
        return this.f23128d;
    }

    public int getMaximumValue() {
        return this.f23127c - 1;
    }

    public int getMinimumValue() {
        return 0;
    }

    public DurationField getRangeDurationField() {
        return this.f23129e;
    }

    public long remainder(long j11) {
        return getWrappedField().remainder(j11);
    }

    public long roundCeiling(long j11) {
        return getWrappedField().roundCeiling(j11);
    }

    public long roundFloor(long j11) {
        return getWrappedField().roundFloor(j11);
    }

    public long roundHalfCeiling(long j11) {
        return getWrappedField().roundHalfCeiling(j11);
    }

    public long roundHalfEven(long j11) {
        return getWrappedField().roundHalfEven(j11);
    }

    public long roundHalfFloor(long j11) {
        return getWrappedField().roundHalfFloor(j11);
    }

    public long set(long j11, int i11) {
        e.m(this, i11, 0, this.f23127c - 1);
        return getWrappedField().set(j11, (b(getWrappedField().get(j11)) * this.f23127c) + i11);
    }

    public i(d dVar) {
        this(dVar, dVar.getType());
    }

    public i(d dVar, DateTimeFieldType dateTimeFieldType) {
        this(dVar, dVar.getWrappedField().getDurationField(), dateTimeFieldType);
    }

    public i(d dVar, DurationField durationField, DateTimeFieldType dateTimeFieldType) {
        super(dVar.getWrappedField(), dateTimeFieldType);
        this.f23127c = dVar.f23115c;
        this.f23128d = durationField;
        this.f23129e = dVar.f23116d;
    }
}
