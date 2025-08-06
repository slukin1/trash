package m20;

import org.joda.convert.ToString;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.format.j;
import org.joda.time.format.n;
import org.joda.time.i;

public abstract class f implements i {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (size() != iVar.size()) {
            return false;
        }
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (getValue(i11) != iVar.getValue(i11) || getFieldType(i11) != iVar.getFieldType(i11)) {
                return false;
            }
        }
        return true;
    }

    public int get(DurationFieldType durationFieldType) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf == -1) {
            return 0;
        }
        return getValue(indexOf);
    }

    public DurationFieldType getFieldType(int i11) {
        return getPeriodType().getFieldType(i11);
    }

    public DurationFieldType[] getFieldTypes() {
        int size = size();
        DurationFieldType[] durationFieldTypeArr = new DurationFieldType[size];
        for (int i11 = 0; i11 < size; i11++) {
            durationFieldTypeArr[i11] = getFieldType(i11);
        }
        return durationFieldTypeArr;
    }

    public int[] getValues() {
        int size = size();
        int[] iArr = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = getValue(i11);
        }
        return iArr;
    }

    public int hashCode() {
        int size = size();
        int i11 = 17;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = (((i11 * 27) + getValue(i12)) * 27) + getFieldType(i12).hashCode();
        }
        return i11;
    }

    public int indexOf(DurationFieldType durationFieldType) {
        return getPeriodType().indexOf(durationFieldType);
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        return getPeriodType().isSupported(durationFieldType);
    }

    public int size() {
        return getPeriodType().size();
    }

    public MutablePeriod toMutablePeriod() {
        return new MutablePeriod((Object) this);
    }

    public Period toPeriod() {
        return new Period((Object) this);
    }

    @ToString
    public String toString() {
        return j.a().i(this);
    }

    public String toString(n nVar) {
        if (nVar == null) {
            return toString();
        }
        return nVar.i(this);
    }
}
