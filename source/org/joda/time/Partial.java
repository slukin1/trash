package org.joda.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import m20.e;
import org.joda.time.field.a;
import org.joda.time.format.b;
import org.joda.time.format.i;

public final class Partial extends e implements Serializable {
    private static final long serialVersionUID = 12324121189002L;
    private final Chronology iChronology;
    private transient b[] iFormatter;
    private final DateTimeFieldType[] iTypes;
    private final int[] iValues;

    public Partial() {
        this((Chronology) null);
    }

    public Chronology getChronology() {
        return this.iChronology;
    }

    public DateTimeField getField(int i11, Chronology chronology) {
        return this.iTypes[i11].getField(chronology);
    }

    public DateTimeFieldType getFieldType(int i11) {
        return this.iTypes[i11];
    }

    public DateTimeFieldType[] getFieldTypes() {
        return (DateTimeFieldType[]) this.iTypes.clone();
    }

    public b getFormatter() {
        b[] bVarArr = this.iFormatter;
        if (bVarArr == null) {
            if (size() == 0) {
                return null;
            }
            bVarArr = new b[2];
            try {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.iTypes));
                bVarArr[0] = i.j(arrayList, true, false);
                if (arrayList.size() == 0) {
                    bVarArr[1] = bVarArr[0];
                }
            } catch (IllegalArgumentException unused) {
            }
            this.iFormatter = bVarArr;
        }
        return bVarArr[0];
    }

    public int getValue(int i11) {
        return this.iValues[i11];
    }

    public int[] getValues() {
        return (int[]) this.iValues.clone();
    }

    public boolean isMatch(f fVar) {
        long h11 = a.h(fVar);
        Chronology g11 = a.g(fVar);
        int i11 = 0;
        while (true) {
            DateTimeFieldType[] dateTimeFieldTypeArr = this.iTypes;
            if (i11 >= dateTimeFieldTypeArr.length) {
                return true;
            }
            if (dateTimeFieldTypeArr[i11].getField(g11).get(h11) != this.iValues[i11]) {
                return false;
            }
            i11++;
        }
    }

    public Partial minus(i iVar) {
        return withPeriodAdded(iVar, -1);
    }

    public Partial plus(i iVar) {
        return withPeriodAdded(iVar, 1);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    public int size() {
        return this.iTypes.length;
    }

    public String toString() {
        b[] bVarArr = this.iFormatter;
        if (bVarArr == null) {
            getFormatter();
            bVarArr = this.iFormatter;
            if (bVarArr == null) {
                return toStringList();
            }
        }
        b bVar = bVarArr[1];
        if (bVar == null) {
            return toStringList();
        }
        return bVar.l(this);
    }

    public String toStringList() {
        int size = size();
        StringBuilder sb2 = new StringBuilder(size * 20);
        sb2.append('[');
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 > 0) {
                sb2.append(',');
                sb2.append(' ');
            }
            sb2.append(this.iTypes[i11].getName());
            sb2.append('=');
            sb2.append(this.iValues[i11]);
        }
        sb2.append(']');
        return sb2.toString();
    }

    public Partial with(DateTimeFieldType dateTimeFieldType, int i11) {
        int i12;
        int compareTo;
        if (dateTimeFieldType != null) {
            int indexOf = indexOf(dateTimeFieldType);
            if (indexOf == -1) {
                int length = this.iTypes.length + 1;
                DateTimeFieldType[] dateTimeFieldTypeArr = new DateTimeFieldType[length];
                int[] iArr = new int[length];
                DurationField field = dateTimeFieldType.getDurationType().getField(this.iChronology);
                if (field.isSupported()) {
                    i12 = 0;
                    while (true) {
                        DateTimeFieldType[] dateTimeFieldTypeArr2 = this.iTypes;
                        if (i12 >= dateTimeFieldTypeArr2.length) {
                            break;
                        }
                        DateTimeFieldType dateTimeFieldType2 = dateTimeFieldTypeArr2[i12];
                        DurationField field2 = dateTimeFieldType2.getDurationType().getField(this.iChronology);
                        if (field2.isSupported() && ((compareTo = field.compareTo(field2)) > 0 || (compareTo == 0 && (dateTimeFieldType.getRangeDurationType() == null || (dateTimeFieldType2.getRangeDurationType() != null && dateTimeFieldType.getRangeDurationType().getField(this.iChronology).compareTo(dateTimeFieldType2.getRangeDurationType().getField(this.iChronology)) > 0))))) {
                            break;
                        }
                        i12++;
                    }
                } else {
                    i12 = 0;
                }
                System.arraycopy(this.iTypes, 0, dateTimeFieldTypeArr, 0, i12);
                System.arraycopy(this.iValues, 0, iArr, 0, i12);
                dateTimeFieldTypeArr[i12] = dateTimeFieldType;
                iArr[i12] = i11;
                int i13 = i12 + 1;
                int i14 = (length - i12) - 1;
                System.arraycopy(this.iTypes, i12, dateTimeFieldTypeArr, i13, i14);
                System.arraycopy(this.iValues, i12, iArr, i13, i14);
                Partial partial = new Partial(dateTimeFieldTypeArr, iArr, this.iChronology);
                this.iChronology.validate(partial, iArr);
                return partial;
            } else if (i11 == getValue(indexOf)) {
                return this;
            } else {
                return new Partial(this, getField(indexOf).set(this, indexOf, getValues(), i11));
            }
        } else {
            throw new IllegalArgumentException("The field type must not be null");
        }
    }

    public Partial withChronologyRetainFields(Chronology chronology) {
        Chronology withUTC = a.c(chronology).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        Partial partial = new Partial(withUTC, this.iTypes, this.iValues);
        withUTC.validate(partial, this.iValues);
        return partial;
    }

    public Partial withField(DateTimeFieldType dateTimeFieldType, int i11) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i11 == getValue(indexOfSupported)) {
            return this;
        }
        return new Partial(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i11));
    }

    public Partial withFieldAddWrapped(DurationFieldType durationFieldType, int i11) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i11 == 0) {
            return this;
        }
        return new Partial(this, getField(indexOfSupported).addWrapPartial(this, indexOfSupported, getValues(), i11));
    }

    public Partial withFieldAdded(DurationFieldType durationFieldType, int i11) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i11 == 0) {
            return this;
        }
        return new Partial(this, getField(indexOfSupported).add(this, indexOfSupported, getValues(), i11));
    }

    public Partial withPeriodAdded(i iVar, int i11) {
        if (iVar == null || i11 == 0) {
            return this;
        }
        int[] values = getValues();
        for (int i12 = 0; i12 < iVar.size(); i12++) {
            int indexOf = indexOf(iVar.getFieldType(i12));
            if (indexOf >= 0) {
                values = getField(indexOf).add(this, indexOf, values, org.joda.time.field.e.g(iVar.getValue(i12), i11));
            }
        }
        return new Partial(this, values);
    }

    public Partial without(DateTimeFieldType dateTimeFieldType) {
        int indexOf = indexOf(dateTimeFieldType);
        if (indexOf == -1) {
            return this;
        }
        int size = size() - 1;
        DateTimeFieldType[] dateTimeFieldTypeArr = new DateTimeFieldType[size];
        int size2 = size() - 1;
        int[] iArr = new int[size2];
        System.arraycopy(this.iTypes, 0, dateTimeFieldTypeArr, 0, indexOf);
        int i11 = indexOf + 1;
        System.arraycopy(this.iTypes, i11, dateTimeFieldTypeArr, indexOf, size - indexOf);
        System.arraycopy(this.iValues, 0, iArr, 0, indexOf);
        System.arraycopy(this.iValues, i11, iArr, indexOf, size2 - indexOf);
        Partial partial = new Partial(this.iChronology, dateTimeFieldTypeArr, iArr);
        this.iChronology.validate(partial, iArr);
        return partial;
    }

    public Partial(Chronology chronology) {
        this.iChronology = a.c(chronology).withUTC();
        this.iTypes = new DateTimeFieldType[0];
        this.iValues = new int[0];
    }

    public static class Property extends a implements Serializable {
        private static final long serialVersionUID = 53278362873888L;
        private final int iFieldIndex;
        private final Partial iPartial;

        public Property(Partial partial, int i11) {
            this.iPartial = partial;
            this.iFieldIndex = i11;
        }

        public Partial addToCopy(int i11) {
            return new Partial(this.iPartial, getField().add(this.iPartial, this.iFieldIndex, this.iPartial.getValues(), i11));
        }

        public Partial addWrapFieldToCopy(int i11) {
            return new Partial(this.iPartial, getField().addWrapField(this.iPartial, this.iFieldIndex, this.iPartial.getValues(), i11));
        }

        public int get() {
            return this.iPartial.getValue(this.iFieldIndex);
        }

        public DateTimeField getField() {
            return this.iPartial.getField(this.iFieldIndex);
        }

        public Partial getPartial() {
            return this.iPartial;
        }

        public h getReadablePartial() {
            return this.iPartial;
        }

        public Partial setCopy(int i11) {
            return new Partial(this.iPartial, getField().set(this.iPartial, this.iFieldIndex, this.iPartial.getValues(), i11));
        }

        public Partial withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public Partial withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public Partial setCopy(String str, Locale locale) {
            return new Partial(this.iPartial, getField().set(this.iPartial, this.iFieldIndex, this.iPartial.getValues(), str, locale));
        }

        public Partial setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    public Partial(DateTimeFieldType dateTimeFieldType, int i11) {
        this(dateTimeFieldType, i11, (Chronology) null);
    }

    public boolean isMatch(h hVar) {
        if (hVar != null) {
            int i11 = 0;
            while (true) {
                DateTimeFieldType[] dateTimeFieldTypeArr = this.iTypes;
                if (i11 >= dateTimeFieldTypeArr.length) {
                    return true;
                }
                if (hVar.get(dateTimeFieldTypeArr[i11]) != this.iValues[i11]) {
                    return false;
                }
                i11++;
            }
        } else {
            throw new IllegalArgumentException("The partial must not be null");
        }
    }

    public Partial(DateTimeFieldType dateTimeFieldType, int i11, Chronology chronology) {
        Chronology withUTC = a.c(chronology).withUTC();
        this.iChronology = withUTC;
        if (dateTimeFieldType != null) {
            this.iTypes = new DateTimeFieldType[]{dateTimeFieldType};
            int[] iArr = {i11};
            this.iValues = iArr;
            withUTC.validate(this, iArr);
            return;
        }
        throw new IllegalArgumentException("The field type must not be null");
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).l(this);
    }

    public String toString(String str, Locale locale) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).v(locale).l(this);
    }

    public Partial(DateTimeFieldType[] dateTimeFieldTypeArr, int[] iArr) {
        this(dateTimeFieldTypeArr, iArr, (Chronology) null);
    }

    public Partial(DateTimeFieldType[] dateTimeFieldTypeArr, int[] iArr, Chronology chronology) {
        Chronology withUTC = a.c(chronology).withUTC();
        this.iChronology = withUTC;
        if (dateTimeFieldTypeArr == null) {
            throw new IllegalArgumentException("Types array must not be null");
        } else if (iArr == null) {
            throw new IllegalArgumentException("Values array must not be null");
        } else if (iArr.length != dateTimeFieldTypeArr.length) {
            throw new IllegalArgumentException("Values array must be the same length as the types array");
        } else if (dateTimeFieldTypeArr.length == 0) {
            this.iTypes = dateTimeFieldTypeArr;
            this.iValues = iArr;
        } else {
            int i11 = 0;
            int i12 = 0;
            while (i12 < dateTimeFieldTypeArr.length) {
                if (dateTimeFieldTypeArr[i12] != null) {
                    i12++;
                } else {
                    throw new IllegalArgumentException("Types array must not contain null: index " + i12);
                }
            }
            DurationField durationField = null;
            while (i11 < dateTimeFieldTypeArr.length) {
                DateTimeFieldType dateTimeFieldType = dateTimeFieldTypeArr[i11];
                DurationField field = dateTimeFieldType.getDurationType().getField(this.iChronology);
                if (i11 > 0) {
                    if (field.isSupported()) {
                        int compareTo = durationField.compareTo(field);
                        if (compareTo < 0) {
                            throw new IllegalArgumentException("Types array must be in order largest-smallest: " + dateTimeFieldTypeArr[i11 - 1].getName() + " < " + dateTimeFieldType.getName());
                        } else if (compareTo != 0) {
                            continue;
                        } else if (durationField.equals(field)) {
                            int i13 = i11 - 1;
                            DurationFieldType rangeDurationType = dateTimeFieldTypeArr[i13].getRangeDurationType();
                            DurationFieldType rangeDurationType2 = dateTimeFieldType.getRangeDurationType();
                            if (rangeDurationType == null) {
                                if (rangeDurationType2 == null) {
                                    throw new IllegalArgumentException("Types array must not contain duplicate: " + dateTimeFieldTypeArr[i13].getName() + " and " + dateTimeFieldType.getName());
                                }
                            } else if (rangeDurationType2 != null) {
                                DurationField field2 = rangeDurationType.getField(this.iChronology);
                                DurationField field3 = rangeDurationType2.getField(this.iChronology);
                                if (field2.compareTo(field3) < 0) {
                                    throw new IllegalArgumentException("Types array must be in order largest-smallest: " + dateTimeFieldTypeArr[i13].getName() + " < " + dateTimeFieldType.getName());
                                } else if (field2.compareTo(field3) == 0) {
                                    throw new IllegalArgumentException("Types array must not contain duplicate: " + dateTimeFieldTypeArr[i13].getName() + " and " + dateTimeFieldType.getName());
                                }
                            } else {
                                throw new IllegalArgumentException("Types array must be in order largest-smallest: " + dateTimeFieldTypeArr[i13].getName() + " < " + dateTimeFieldType.getName());
                            }
                        } else if (durationField.isSupported() && durationField.getType() != DurationFieldType.YEARS_TYPE) {
                            throw new IllegalArgumentException("Types array must be in order largest-smallest, for year-based fields, years is defined as being largest: " + dateTimeFieldTypeArr[i11 - 1].getName() + " < " + dateTimeFieldType.getName());
                        }
                    } else if (durationField.isSupported()) {
                        throw new IllegalArgumentException("Types array must be in order largest-smallest: " + dateTimeFieldTypeArr[i11 - 1].getName() + " < " + dateTimeFieldType.getName());
                    } else {
                        throw new IllegalArgumentException("Types array must not contain duplicate unsupported: " + dateTimeFieldTypeArr[i11 - 1].getName() + " and " + dateTimeFieldType.getName());
                    }
                }
                i11++;
                durationField = field;
            }
            this.iTypes = (DateTimeFieldType[]) dateTimeFieldTypeArr.clone();
            withUTC.validate(this, iArr);
            this.iValues = (int[]) iArr.clone();
        }
    }

    public Partial(h hVar) {
        if (hVar != null) {
            this.iChronology = a.c(hVar.getChronology()).withUTC();
            this.iTypes = new DateTimeFieldType[hVar.size()];
            this.iValues = new int[hVar.size()];
            for (int i11 = 0; i11 < hVar.size(); i11++) {
                this.iTypes[i11] = hVar.getFieldType(i11);
                this.iValues[i11] = hVar.getValue(i11);
            }
            return;
        }
        throw new IllegalArgumentException("The partial must not be null");
    }

    public Partial(Partial partial, int[] iArr) {
        this.iChronology = partial.iChronology;
        this.iTypes = partial.iTypes;
        this.iValues = iArr;
    }

    public Partial(Chronology chronology, DateTimeFieldType[] dateTimeFieldTypeArr, int[] iArr) {
        this.iChronology = chronology;
        this.iTypes = dateTimeFieldTypeArr;
        this.iValues = iArr;
    }
}
