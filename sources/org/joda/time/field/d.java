package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class d extends c {

    /* renamed from: c  reason: collision with root package name */
    public final int f23115c;

    /* renamed from: d  reason: collision with root package name */
    public final DurationField f23116d;

    /* renamed from: e  reason: collision with root package name */
    public final DurationField f23117e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23118f;

    /* renamed from: g  reason: collision with root package name */
    public final int f23119g;

    public d(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i11) {
        this(dateTimeField, dateTimeField.getRangeDurationField(), dateTimeFieldType, i11);
    }

    public long add(long j11, int i11) {
        return getWrappedField().add(j11, i11 * this.f23115c);
    }

    public long addWrapField(long j11, int i11) {
        return set(j11, e.c(get(j11), i11, this.f23118f, this.f23119g));
    }

    public final int b(int i11) {
        if (i11 >= 0) {
            return i11 % this.f23115c;
        }
        int i12 = this.f23115c;
        return (i12 - 1) + ((i11 + 1) % i12);
    }

    public int get(long j11) {
        int i11 = getWrappedField().get(j11);
        if (i11 >= 0) {
            return i11 / this.f23115c;
        }
        return ((i11 + 1) / this.f23115c) - 1;
    }

    public int getDifference(long j11, long j12) {
        return getWrappedField().getDifference(j11, j12) / this.f23115c;
    }

    public long getDifferenceAsLong(long j11, long j12) {
        return getWrappedField().getDifferenceAsLong(j11, j12) / ((long) this.f23115c);
    }

    public DurationField getDurationField() {
        return this.f23116d;
    }

    public int getMaximumValue() {
        return this.f23119g;
    }

    public int getMinimumValue() {
        return this.f23118f;
    }

    public DurationField getRangeDurationField() {
        DurationField durationField = this.f23117e;
        if (durationField != null) {
            return durationField;
        }
        return super.getRangeDurationField();
    }

    public long remainder(long j11) {
        return set(j11, get(getWrappedField().remainder(j11)));
    }

    public long roundFloor(long j11) {
        DateTimeField wrappedField = getWrappedField();
        return wrappedField.roundFloor(wrappedField.set(j11, get(j11) * this.f23115c));
    }

    public long set(long j11, int i11) {
        e.m(this, i11, this.f23118f, this.f23119g);
        return getWrappedField().set(j11, (i11 * this.f23115c) + b(getWrappedField().get(j11)));
    }

    public d(DateTimeField dateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType, int i11) {
        super(dateTimeField, dateTimeFieldType);
        if (i11 >= 2) {
            DurationField durationField2 = dateTimeField.getDurationField();
            if (durationField2 == null) {
                this.f23116d = null;
            } else {
                this.f23116d = new ScaledDurationField(durationField2, dateTimeFieldType.getDurationType(), i11);
            }
            this.f23117e = durationField;
            this.f23115c = i11;
            int minimumValue = dateTimeField.getMinimumValue();
            int i12 = minimumValue >= 0 ? minimumValue / i11 : ((minimumValue + 1) / i11) - 1;
            int maximumValue = dateTimeField.getMaximumValue();
            int i13 = maximumValue >= 0 ? maximumValue / i11 : ((maximumValue + 1) / i11) - 1;
            this.f23118f = i12;
            this.f23119g = i13;
            return;
        }
        throw new IllegalArgumentException("The divisor must be at least 2");
    }

    public long add(long j11, long j12) {
        return getWrappedField().add(j11, j12 * ((long) this.f23115c));
    }
}
