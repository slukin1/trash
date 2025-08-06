package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class f extends c {

    /* renamed from: c  reason: collision with root package name */
    public final int f23120c;

    /* renamed from: d  reason: collision with root package name */
    public final int f23121d;

    /* renamed from: e  reason: collision with root package name */
    public final int f23122e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public f(DateTimeField dateTimeField, int i11) {
        this(dateTimeField, dateTimeField == null ? null : dateTimeField.getType(), i11, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public long add(long j11, int i11) {
        long add = super.add(j11, i11);
        e.m(this, get(add), this.f23121d, this.f23122e);
        return add;
    }

    public long addWrapField(long j11, int i11) {
        return set(j11, e.c(get(j11), i11, this.f23121d, this.f23122e));
    }

    public int get(long j11) {
        return super.get(j11) + this.f23120c;
    }

    public int getLeapAmount(long j11) {
        return getWrappedField().getLeapAmount(j11);
    }

    public DurationField getLeapDurationField() {
        return getWrappedField().getLeapDurationField();
    }

    public int getMaximumValue() {
        return this.f23122e;
    }

    public int getMinimumValue() {
        return this.f23121d;
    }

    public boolean isLeap(long j11) {
        return getWrappedField().isLeap(j11);
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
        e.m(this, i11, this.f23121d, this.f23122e);
        return super.set(j11, i11 - this.f23120c);
    }

    public f(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i11) {
        this(dateTimeField, dateTimeFieldType, i11, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public f(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i11, int i12, int i13) {
        super(dateTimeField, dateTimeFieldType);
        if (i11 != 0) {
            this.f23120c = i11;
            if (i12 < dateTimeField.getMinimumValue() + i11) {
                this.f23121d = dateTimeField.getMinimumValue() + i11;
            } else {
                this.f23121d = i12;
            }
            if (i13 > dateTimeField.getMaximumValue() + i11) {
                this.f23122e = dateTimeField.getMaximumValue() + i11;
            } else {
                this.f23122e = i13;
            }
        } else {
            throw new IllegalArgumentException("The offset cannot be zero");
        }
    }

    public long add(long j11, long j12) {
        long add = super.add(j11, j12);
        e.m(this, get(add), this.f23121d, this.f23122e);
        return add;
    }
}
