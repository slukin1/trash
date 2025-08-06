package org.joda.time;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.Comparator;
import n20.d;
import n20.h;

public class DateTimeComparator implements Comparator<Object>, Serializable {
    private static final DateTimeComparator ALL_INSTANCE = new DateTimeComparator((DateTimeFieldType) null, (DateTimeFieldType) null);
    private static final DateTimeComparator DATE_INSTANCE = new DateTimeComparator(DateTimeFieldType.dayOfYear(), (DateTimeFieldType) null);
    private static final DateTimeComparator TIME_INSTANCE = new DateTimeComparator((DateTimeFieldType) null, DateTimeFieldType.dayOfYear());
    private static final long serialVersionUID = -6097339773320178364L;
    private final DateTimeFieldType iLowerLimit;
    private final DateTimeFieldType iUpperLimit;

    public DateTimeComparator(DateTimeFieldType dateTimeFieldType, DateTimeFieldType dateTimeFieldType2) {
        this.iLowerLimit = dateTimeFieldType;
        this.iUpperLimit = dateTimeFieldType2;
    }

    public static DateTimeComparator getDateOnlyInstance() {
        return DATE_INSTANCE;
    }

    public static DateTimeComparator getInstance() {
        return ALL_INSTANCE;
    }

    public static DateTimeComparator getTimeOnlyInstance() {
        return TIME_INSTANCE;
    }

    private Object readResolve() {
        return getInstance(this.iLowerLimit, this.iUpperLimit);
    }

    public int compare(Object obj, Object obj2) {
        h c11 = d.b().c(obj);
        Chronology a11 = c11.a(obj, (Chronology) null);
        long k11 = c11.k(obj, a11);
        h c12 = d.b().c(obj2);
        Chronology a12 = c12.a(obj2, (Chronology) null);
        long k12 = c12.k(obj2, a12);
        DateTimeFieldType dateTimeFieldType = this.iLowerLimit;
        if (dateTimeFieldType != null) {
            k11 = dateTimeFieldType.getField(a11).roundFloor(k11);
            k12 = this.iLowerLimit.getField(a12).roundFloor(k12);
        }
        DateTimeFieldType dateTimeFieldType2 = this.iUpperLimit;
        if (dateTimeFieldType2 != null) {
            k11 = dateTimeFieldType2.getField(a11).remainder(k11);
            k12 = this.iUpperLimit.getField(a12).remainder(k12);
        }
        int i11 = (k11 > k12 ? 1 : (k11 == k12 ? 0 : -1));
        if (i11 < 0) {
            return -1;
        }
        return i11 > 0 ? 1 : 0;
    }

    public boolean equals(Object obj) {
        DateTimeFieldType dateTimeFieldType;
        DateTimeFieldType dateTimeFieldType2;
        if (!(obj instanceof DateTimeComparator)) {
            return false;
        }
        DateTimeComparator dateTimeComparator = (DateTimeComparator) obj;
        if (this.iLowerLimit != dateTimeComparator.getLowerLimit() && ((dateTimeFieldType2 = this.iLowerLimit) == null || !dateTimeFieldType2.equals(dateTimeComparator.getLowerLimit()))) {
            return false;
        }
        if (this.iUpperLimit == dateTimeComparator.getUpperLimit() || ((dateTimeFieldType = this.iUpperLimit) != null && dateTimeFieldType.equals(dateTimeComparator.getUpperLimit()))) {
            return true;
        }
        return false;
    }

    public DateTimeFieldType getLowerLimit() {
        return this.iLowerLimit;
    }

    public DateTimeFieldType getUpperLimit() {
        return this.iUpperLimit;
    }

    public int hashCode() {
        DateTimeFieldType dateTimeFieldType = this.iLowerLimit;
        int i11 = 0;
        int hashCode = dateTimeFieldType == null ? 0 : dateTimeFieldType.hashCode();
        DateTimeFieldType dateTimeFieldType2 = this.iUpperLimit;
        if (dateTimeFieldType2 != null) {
            i11 = dateTimeFieldType2.hashCode();
        }
        return hashCode + (i11 * 123);
    }

    public String toString() {
        String str = "";
        if (this.iLowerLimit == this.iUpperLimit) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DateTimeComparator[");
            DateTimeFieldType dateTimeFieldType = this.iLowerLimit;
            if (dateTimeFieldType != null) {
                str = dateTimeFieldType.getName();
            }
            sb2.append(str);
            sb2.append("]");
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("DateTimeComparator[");
        DateTimeFieldType dateTimeFieldType2 = this.iLowerLimit;
        sb3.append(dateTimeFieldType2 == null ? str : dateTimeFieldType2.getName());
        sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        DateTimeFieldType dateTimeFieldType3 = this.iUpperLimit;
        if (dateTimeFieldType3 != null) {
            str = dateTimeFieldType3.getName();
        }
        sb3.append(str);
        sb3.append("]");
        return sb3.toString();
    }

    public static DateTimeComparator getInstance(DateTimeFieldType dateTimeFieldType) {
        return getInstance(dateTimeFieldType, (DateTimeFieldType) null);
    }

    public static DateTimeComparator getInstance(DateTimeFieldType dateTimeFieldType, DateTimeFieldType dateTimeFieldType2) {
        if (dateTimeFieldType == null && dateTimeFieldType2 == null) {
            return ALL_INSTANCE;
        }
        if (dateTimeFieldType == DateTimeFieldType.dayOfYear() && dateTimeFieldType2 == null) {
            return DATE_INSTANCE;
        }
        if (dateTimeFieldType == null && dateTimeFieldType2 == DateTimeFieldType.dayOfYear()) {
            return TIME_INSTANCE;
        }
        return new DateTimeComparator(dateTimeFieldType, dateTimeFieldType2);
    }
}
