package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public abstract class ImpreciseDateTimeField extends b {

    /* renamed from: b  reason: collision with root package name */
    public final long f23111b;

    /* renamed from: c  reason: collision with root package name */
    public final DurationField f23112c;

    public final class LinkedDurationField extends BaseDurationField {
        private static final long serialVersionUID = -203813474600094134L;

        public LinkedDurationField(DurationFieldType durationFieldType) {
            super(durationFieldType);
        }

        public long add(long j11, int i11) {
            return ImpreciseDateTimeField.this.add(j11, i11);
        }

        public int getDifference(long j11, long j12) {
            return ImpreciseDateTimeField.this.getDifference(j11, j12);
        }

        public long getDifferenceAsLong(long j11, long j12) {
            return ImpreciseDateTimeField.this.getDifferenceAsLong(j11, j12);
        }

        public long getMillis(int i11, long j11) {
            return ImpreciseDateTimeField.this.add(j11, i11) - j11;
        }

        public long getUnitMillis() {
            return ImpreciseDateTimeField.this.f23111b;
        }

        public int getValue(long j11, long j12) {
            return ImpreciseDateTimeField.this.getDifference(j11 + j12, j12);
        }

        public long getValueAsLong(long j11, long j12) {
            return ImpreciseDateTimeField.this.getDifferenceAsLong(j11 + j12, j12);
        }

        public boolean isPrecise() {
            return false;
        }

        public long add(long j11, long j12) {
            return ImpreciseDateTimeField.this.add(j11, j12);
        }

        public long getMillis(long j11, long j12) {
            return ImpreciseDateTimeField.this.add(j12, j11) - j12;
        }
    }

    public ImpreciseDateTimeField(DateTimeFieldType dateTimeFieldType, long j11) {
        super(dateTimeFieldType);
        this.f23111b = j11;
        this.f23112c = new LinkedDurationField(dateTimeFieldType.getDurationType());
    }

    public abstract long add(long j11, int i11);

    public abstract long add(long j11, long j12);

    public int getDifference(long j11, long j12) {
        return e.l(getDifferenceAsLong(j11, j12));
    }

    public abstract long getDifferenceAsLong(long j11, long j12);

    public final DurationField getDurationField() {
        return this.f23112c;
    }
}
