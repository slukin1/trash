package org.joda.time.base;

import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.a;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.f;
import org.joda.time.field.e;
import org.joda.time.h;
import org.joda.time.i;

public abstract class BaseSingleFieldPeriod implements i, Comparable<BaseSingleFieldPeriod>, Serializable {
    private static final long START_1972 = 63072000000L;
    private static final long serialVersionUID = 9386874258972L;
    private volatile int iPeriod;

    public BaseSingleFieldPeriod(int i11) {
        this.iPeriod = i11;
    }

    public static int between(f fVar, f fVar2, DurationFieldType durationFieldType) {
        if (fVar != null && fVar2 != null) {
            return durationFieldType.getField(a.g(fVar)).getDifference(fVar2.getMillis(), fVar.getMillis());
        }
        throw new IllegalArgumentException("ReadableInstant objects must not be null");
    }

    public static int standardPeriodIn(i iVar, long j11) {
        if (iVar == null) {
            return 0;
        }
        ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
        long j12 = 0;
        for (int i11 = 0; i11 < iVar.size(); i11++) {
            int value = iVar.getValue(i11);
            if (value != 0) {
                DurationField field = iVar.getFieldType(i11).getField(instanceUTC);
                if (field.isPrecise()) {
                    j12 = e.e(j12, e.h(field.getUnitMillis(), value));
                } else {
                    throw new IllegalArgumentException("Cannot convert period to duration as " + field.getName() + " is not precise in the period " + iVar);
                }
            }
        }
        return e.l(j12 / j11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (iVar.getPeriodType() == getPeriodType() && iVar.getValue(0) == getValue()) {
            return true;
        }
        return false;
    }

    public int get(DurationFieldType durationFieldType) {
        if (durationFieldType == getFieldType()) {
            return getValue();
        }
        return 0;
    }

    public abstract DurationFieldType getFieldType();

    public DurationFieldType getFieldType(int i11) {
        if (i11 == 0) {
            return getFieldType();
        }
        throw new IndexOutOfBoundsException(String.valueOf(i11));
    }

    public abstract PeriodType getPeriodType();

    public int getValue() {
        return this.iPeriod;
    }

    public int hashCode() {
        return ((459 + getValue()) * 27) + getFieldType().hashCode();
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        return durationFieldType == getFieldType();
    }

    public void setValue(int i11) {
        this.iPeriod = i11;
    }

    public int size() {
        return 1;
    }

    public MutablePeriod toMutablePeriod() {
        MutablePeriod mutablePeriod = new MutablePeriod();
        mutablePeriod.add((i) this);
        return mutablePeriod;
    }

    public Period toPeriod() {
        return Period.ZERO.withFields(this);
    }

    public int compareTo(BaseSingleFieldPeriod baseSingleFieldPeriod) {
        if (baseSingleFieldPeriod.getClass() == getClass()) {
            int value = baseSingleFieldPeriod.getValue();
            int value2 = getValue();
            if (value2 > value) {
                return 1;
            }
            return value2 < value ? -1 : 0;
        }
        throw new ClassCastException(getClass() + " cannot be compared to " + baseSingleFieldPeriod.getClass());
    }

    public int getValue(int i11) {
        if (i11 == 0) {
            return getValue();
        }
        throw new IndexOutOfBoundsException(String.valueOf(i11));
    }

    public static int between(h hVar, h hVar2, i iVar) {
        if (hVar == null || hVar2 == null) {
            throw new IllegalArgumentException("ReadablePartial objects must not be null");
        } else if (hVar.size() == hVar2.size()) {
            int size = hVar.size();
            int i11 = 0;
            while (i11 < size) {
                if (hVar.getFieldType(i11) == hVar2.getFieldType(i11)) {
                    i11++;
                } else {
                    throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
                }
            }
            if (a.n(hVar)) {
                Chronology withUTC = a.c(hVar.getChronology()).withUTC();
                return withUTC.get(iVar, withUTC.set(hVar, START_1972), withUTC.set(hVar2, START_1972))[0];
            }
            throw new IllegalArgumentException("ReadablePartial objects must be contiguous");
        } else {
            throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
        }
    }
}
