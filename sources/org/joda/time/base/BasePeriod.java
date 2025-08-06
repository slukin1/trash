package org.joda.time.base;

import java.io.Serializable;
import m20.f;
import m20.g;
import n20.d;
import n20.m;
import org.joda.time.Chronology;
import org.joda.time.Duration;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.PeriodType;
import org.joda.time.c;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.e;
import org.joda.time.h;
import org.joda.time.i;

public abstract class BasePeriod extends f implements Serializable {
    private static final i DUMMY_PERIOD = new a();
    private static final long serialVersionUID = -2110953284060001145L;
    private final PeriodType iType;
    private final int[] iValues;

    public static class a extends f {
        public PeriodType getPeriodType() {
            return PeriodType.time();
        }

        public int getValue(int i11) {
            return 0;
        }
    }

    public BasePeriod(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, PeriodType periodType) {
        this.iType = checkPeriodType(periodType);
        this.iValues = setPeriodInternal(i11, i12, i13, i14, i15, i16, i17, i18);
    }

    private void checkAndUpdate(DurationFieldType durationFieldType, int[] iArr, int i11) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            iArr[indexOf] = i11;
        } else if (i11 != 0) {
            throw new IllegalArgumentException("Period does not support field '" + durationFieldType.getName() + "'");
        }
    }

    private void setPeriodInternal(i iVar) {
        int[] iArr = new int[size()];
        int size = iVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            checkAndUpdate(iVar.getFieldType(i11), iArr, iVar.getValue(i11));
        }
        setValues(iArr);
    }

    public void addField(DurationFieldType durationFieldType, int i11) {
        addFieldInto(this.iValues, durationFieldType, i11);
    }

    public void addFieldInto(int[] iArr, DurationFieldType durationFieldType, int i11) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            iArr[indexOf] = e.d(iArr[indexOf], i11);
        } else if (i11 != 0 || durationFieldType == null) {
            throw new IllegalArgumentException("Period does not support field '" + durationFieldType + "'");
        }
    }

    public void addPeriod(i iVar) {
        if (iVar != null) {
            setValues(addPeriodInto(getValues(), iVar));
        }
    }

    public int[] addPeriodInto(int[] iArr, i iVar) {
        int size = iVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            DurationFieldType fieldType = iVar.getFieldType(i11);
            int value = iVar.getValue(i11);
            if (value != 0) {
                int indexOf = indexOf(fieldType);
                if (indexOf != -1) {
                    iArr[indexOf] = e.d(getValue(indexOf), value);
                } else {
                    throw new IllegalArgumentException("Period does not support field '" + fieldType.getName() + "'");
                }
            }
        }
        return iArr;
    }

    public PeriodType checkPeriodType(PeriodType periodType) {
        return org.joda.time.a.k(periodType);
    }

    public PeriodType getPeriodType() {
        return this.iType;
    }

    public int getValue(int i11) {
        return this.iValues[i11];
    }

    public void mergePeriod(i iVar) {
        if (iVar != null) {
            setValues(mergePeriodInto(getValues(), iVar));
        }
    }

    public int[] mergePeriodInto(int[] iArr, i iVar) {
        int size = iVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            checkAndUpdate(iVar.getFieldType(i11), iArr, iVar.getValue(i11));
        }
        return iArr;
    }

    public void setField(DurationFieldType durationFieldType, int i11) {
        setFieldInto(this.iValues, durationFieldType, i11);
    }

    public void setFieldInto(int[] iArr, DurationFieldType durationFieldType, int i11) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            iArr[indexOf] = i11;
        } else if (i11 != 0 || durationFieldType == null) {
            throw new IllegalArgumentException("Period does not support field '" + durationFieldType + "'");
        }
    }

    public void setPeriod(i iVar) {
        if (iVar == null) {
            setValues(new int[size()]);
        } else {
            setPeriodInternal(iVar);
        }
    }

    public void setValue(int i11, int i12) {
        this.iValues[i11] = i12;
    }

    public void setValues(int[] iArr) {
        int[] iArr2 = this.iValues;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
    }

    public Duration toDurationFrom(org.joda.time.f fVar) {
        long h11 = org.joda.time.a.h(fVar);
        return new Duration(h11, org.joda.time.a.g(fVar).add((i) this, h11, 1));
    }

    public Duration toDurationTo(org.joda.time.f fVar) {
        long h11 = org.joda.time.a.h(fVar);
        return new Duration(org.joda.time.a.g(fVar).add((i) this, h11, -1), h11);
    }

    public void setPeriod(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        setValues(setPeriodInternal(i11, i12, i13, i14, i15, i16, i17, i18));
    }

    public BasePeriod(long j11, long j12, PeriodType periodType, Chronology chronology) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        Chronology c11 = org.joda.time.a.c(chronology);
        this.iType = checkPeriodType;
        this.iValues = c11.get(this, j11, j12);
    }

    private int[] setPeriodInternal(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int[] iArr = new int[size()];
        checkAndUpdate(DurationFieldType.years(), iArr, i11);
        checkAndUpdate(DurationFieldType.months(), iArr, i12);
        checkAndUpdate(DurationFieldType.weeks(), iArr, i13);
        checkAndUpdate(DurationFieldType.days(), iArr, i14);
        checkAndUpdate(DurationFieldType.hours(), iArr, i15);
        checkAndUpdate(DurationFieldType.minutes(), iArr, i16);
        checkAndUpdate(DurationFieldType.seconds(), iArr, i17);
        checkAndUpdate(DurationFieldType.millis(), iArr, i18);
        return iArr;
    }

    public BasePeriod(org.joda.time.f fVar, org.joda.time.f fVar2, PeriodType periodType) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        if (fVar == null && fVar2 == null) {
            this.iType = checkPeriodType;
            this.iValues = new int[size()];
            return;
        }
        long h11 = org.joda.time.a.h(fVar);
        long h12 = org.joda.time.a.h(fVar2);
        Chronology i11 = org.joda.time.a.i(fVar, fVar2);
        this.iType = checkPeriodType;
        this.iValues = i11.get(this, h11, h12);
    }

    public BasePeriod(h hVar, h hVar2, PeriodType periodType) {
        if (hVar == null || hVar2 == null) {
            throw new IllegalArgumentException("ReadablePartial objects must not be null");
        } else if ((hVar instanceof g) && (hVar2 instanceof g) && hVar.getClass() == hVar2.getClass()) {
            PeriodType checkPeriodType = checkPeriodType(periodType);
            long localMillis = ((g) hVar).getLocalMillis();
            long localMillis2 = ((g) hVar2).getLocalMillis();
            Chronology c11 = org.joda.time.a.c(hVar.getChronology());
            this.iType = checkPeriodType;
            this.iValues = c11.get(this, localMillis, localMillis2);
        } else if (hVar.size() == hVar2.size()) {
            int i11 = 0;
            int size = hVar.size();
            while (i11 < size) {
                if (hVar.getFieldType(i11) == hVar2.getFieldType(i11)) {
                    i11++;
                } else {
                    throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
                }
            }
            if (org.joda.time.a.n(hVar)) {
                this.iType = checkPeriodType(periodType);
                Chronology withUTC = org.joda.time.a.c(hVar.getChronology()).withUTC();
                this.iValues = withUTC.get(this, withUTC.set(hVar, 0), withUTC.set(hVar2, 0));
                return;
            }
            throw new IllegalArgumentException("ReadablePartial objects must be contiguous");
        } else {
            throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
        }
    }

    public BasePeriod(org.joda.time.f fVar, org.joda.time.e eVar, PeriodType periodType) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        long h11 = org.joda.time.a.h(fVar);
        long e11 = e.e(h11, org.joda.time.a.f(eVar));
        Chronology g11 = org.joda.time.a.g(fVar);
        this.iType = checkPeriodType;
        this.iValues = g11.get(this, h11, e11);
    }

    public BasePeriod(org.joda.time.e eVar, org.joda.time.f fVar, PeriodType periodType) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        long f11 = org.joda.time.a.f(eVar);
        long h11 = org.joda.time.a.h(fVar);
        long k11 = e.k(h11, f11);
        Chronology g11 = org.joda.time.a.g(fVar);
        this.iType = checkPeriodType;
        this.iValues = g11.get(this, k11, h11);
    }

    public BasePeriod(long j11) {
        this.iType = PeriodType.standard();
        int[] iArr = ISOChronology.getInstanceUTC().get(DUMMY_PERIOD, j11);
        int[] iArr2 = new int[8];
        this.iValues = iArr2;
        System.arraycopy(iArr, 0, iArr2, 4, 4);
    }

    public BasePeriod(long j11, PeriodType periodType, Chronology chronology) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        Chronology c11 = org.joda.time.a.c(chronology);
        this.iType = checkPeriodType;
        this.iValues = c11.get((i) this, j11);
    }

    public BasePeriod(Object obj, PeriodType periodType, Chronology chronology) {
        m f11 = d.b().f(obj);
        PeriodType checkPeriodType = checkPeriodType(periodType == null ? f11.h(obj) : periodType);
        this.iType = checkPeriodType;
        if (this instanceof c) {
            this.iValues = new int[size()];
            f11.d((c) this, obj, org.joda.time.a.c(chronology));
            return;
        }
        this.iValues = new MutablePeriod(obj, checkPeriodType, chronology).getValues();
    }

    public BasePeriod(int[] iArr, PeriodType periodType) {
        this.iType = periodType;
        this.iValues = iArr;
    }
}
