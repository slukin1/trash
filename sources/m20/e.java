package m20;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.a;
import org.joda.time.f;
import org.joda.time.format.b;
import org.joda.time.h;

public abstract class e implements h, Comparable<h> {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (size() != hVar.size()) {
            return false;
        }
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (getValue(i11) != hVar.getValue(i11) || getFieldType(i11) != hVar.getFieldType(i11)) {
                return false;
            }
        }
        return org.joda.time.field.e.a(getChronology(), hVar.getChronology());
    }

    public int get(DateTimeFieldType dateTimeFieldType) {
        return getValue(indexOfSupported(dateTimeFieldType));
    }

    public DateTimeField getField(int i11) {
        return getField(i11, getChronology());
    }

    public abstract DateTimeField getField(int i11, Chronology chronology);

    public DateTimeFieldType getFieldType(int i11) {
        return getField(i11, getChronology()).getType();
    }

    public DateTimeFieldType[] getFieldTypes() {
        int size = size();
        DateTimeFieldType[] dateTimeFieldTypeArr = new DateTimeFieldType[size];
        for (int i11 = 0; i11 < size; i11++) {
            dateTimeFieldTypeArr[i11] = getFieldType(i11);
        }
        return dateTimeFieldTypeArr;
    }

    public DateTimeField[] getFields() {
        int size = size();
        DateTimeField[] dateTimeFieldArr = new DateTimeField[size];
        for (int i11 = 0; i11 < size; i11++) {
            dateTimeFieldArr[i11] = getField(i11);
        }
        return dateTimeFieldArr;
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
        int i11 = 157;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = (((i11 * 23) + getValue(i12)) * 23) + getFieldType(i12).hashCode();
        }
        return i11 + getChronology().hashCode();
    }

    public int indexOf(DateTimeFieldType dateTimeFieldType) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (getFieldType(i11) == dateTimeFieldType) {
                return i11;
            }
        }
        return -1;
    }

    public int indexOfSupported(DateTimeFieldType dateTimeFieldType) {
        int indexOf = indexOf(dateTimeFieldType);
        if (indexOf != -1) {
            return indexOf;
        }
        throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
    }

    public boolean isAfter(h hVar) {
        if (hVar != null) {
            return compareTo(hVar) > 0;
        }
        throw new IllegalArgumentException("Partial cannot be null");
    }

    public boolean isBefore(h hVar) {
        if (hVar != null) {
            return compareTo(hVar) < 0;
        }
        throw new IllegalArgumentException("Partial cannot be null");
    }

    public boolean isEqual(h hVar) {
        if (hVar != null) {
            return compareTo(hVar) == 0;
        }
        throw new IllegalArgumentException("Partial cannot be null");
    }

    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        return indexOf(dateTimeFieldType) != -1;
    }

    public DateTime toDateTime(f fVar) {
        Chronology g11 = a.g(fVar);
        return new DateTime(g11.set(this, a.h(fVar)), g11);
    }

    public String toString(b bVar) {
        if (bVar == null) {
            return toString();
        }
        return bVar.l(this);
    }

    public int compareTo(h hVar) {
        if (this == hVar) {
            return 0;
        }
        if (size() == hVar.size()) {
            int size = size();
            int i11 = 0;
            while (i11 < size) {
                if (getFieldType(i11) == hVar.getFieldType(i11)) {
                    i11++;
                } else {
                    throw new ClassCastException("ReadablePartial objects must have matching field types");
                }
            }
            int size2 = size();
            for (int i12 = 0; i12 < size2; i12++) {
                if (getValue(i12) > hVar.getValue(i12)) {
                    return 1;
                }
                if (getValue(i12) < hVar.getValue(i12)) {
                    return -1;
                }
            }
            return 0;
        }
        throw new ClassCastException("ReadablePartial objects must have matching field types");
    }

    public int indexOf(DurationFieldType durationFieldType) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (getFieldType(i11).getDurationType() == durationFieldType) {
                return i11;
            }
        }
        return -1;
    }

    public int indexOfSupported(DurationFieldType durationFieldType) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            return indexOf;
        }
        throw new IllegalArgumentException("Field '" + durationFieldType + "' is not supported");
    }
}
