package org.joda.time.chrono;

import java.util.HashMap;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.MutableDateTime;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.d;
import org.joda.time.field.DecoratedDurationField;
import org.joda.time.field.c;
import org.joda.time.field.e;
import org.joda.time.format.b;
import org.joda.time.format.i;

public final class LimitChronology extends AssembledChronology {
    private static final long serialVersionUID = 7670866536893052522L;
    public final DateTime iLowerLimit;
    public final DateTime iUpperLimit;
    private transient LimitChronology iWithUTC;

    public class LimitException extends IllegalArgumentException {
        private static final long serialVersionUID = -5924689995607498581L;
        private final boolean iIsLow;

        public LimitException(String str, boolean z11) {
            super(str);
            this.iIsLow = z11;
        }

        public String getMessage() {
            StringBuffer stringBuffer = new StringBuffer(85);
            stringBuffer.append("The");
            String message = super.getMessage();
            if (message != null) {
                stringBuffer.append(' ');
                stringBuffer.append(message);
            }
            stringBuffer.append(" instant is ");
            b u11 = i.h().u(LimitChronology.this.getBase());
            if (this.iIsLow) {
                stringBuffer.append("below the supported minimum of ");
                u11.q(stringBuffer, LimitChronology.this.getLowerLimit().getMillis());
            } else {
                stringBuffer.append("above the supported maximum of ");
                u11.q(stringBuffer, LimitChronology.this.getUpperLimit().getMillis());
            }
            stringBuffer.append(" (");
            stringBuffer.append(LimitChronology.this.getBase());
            stringBuffer.append(')');
            return stringBuffer.toString();
        }

        public String toString() {
            return "IllegalArgumentException: " + getMessage();
        }
    }

    private LimitChronology(Chronology chronology, DateTime dateTime, DateTime dateTime2) {
        super(chronology, (Object) null);
        this.iLowerLimit = dateTime;
        this.iUpperLimit = dateTime2;
    }

    private DurationField convertField(DurationField durationField, HashMap<Object, Object> hashMap) {
        if (durationField == null || !durationField.isSupported()) {
            return durationField;
        }
        if (hashMap.containsKey(durationField)) {
            return (DurationField) hashMap.get(durationField);
        }
        LimitDurationField limitDurationField = new LimitDurationField(durationField);
        hashMap.put(durationField, limitDurationField);
        return limitDurationField;
    }

    public static LimitChronology getInstance(Chronology chronology, d dVar, d dVar2) {
        if (chronology != null) {
            DateTime dateTime = null;
            DateTime dateTime2 = dVar == null ? null : dVar.toDateTime();
            if (dVar2 != null) {
                dateTime = dVar2.toDateTime();
            }
            if (dateTime2 == null || dateTime == null || dateTime2.isBefore(dateTime)) {
                return new LimitChronology(chronology, dateTime2, dateTime);
            }
            throw new IllegalArgumentException("The lower limit must be come before than the upper limit");
        }
        throw new IllegalArgumentException("Must supply a chronology");
    }

    public void assemble(AssembledChronology.a aVar) {
        HashMap hashMap = new HashMap();
        aVar.f23044l = convertField(aVar.f23044l, (HashMap<Object, Object>) hashMap);
        aVar.f23043k = convertField(aVar.f23043k, (HashMap<Object, Object>) hashMap);
        aVar.f23042j = convertField(aVar.f23042j, (HashMap<Object, Object>) hashMap);
        aVar.f23041i = convertField(aVar.f23041i, (HashMap<Object, Object>) hashMap);
        aVar.f23040h = convertField(aVar.f23040h, (HashMap<Object, Object>) hashMap);
        aVar.f23039g = convertField(aVar.f23039g, (HashMap<Object, Object>) hashMap);
        aVar.f23038f = convertField(aVar.f23038f, (HashMap<Object, Object>) hashMap);
        aVar.f23037e = convertField(aVar.f23037e, (HashMap<Object, Object>) hashMap);
        aVar.f23036d = convertField(aVar.f23036d, (HashMap<Object, Object>) hashMap);
        aVar.f23035c = convertField(aVar.f23035c, (HashMap<Object, Object>) hashMap);
        aVar.f23034b = convertField(aVar.f23034b, (HashMap<Object, Object>) hashMap);
        aVar.f23033a = convertField(aVar.f23033a, (HashMap<Object, Object>) hashMap);
        aVar.E = convertField(aVar.E, (HashMap<Object, Object>) hashMap);
        aVar.F = convertField(aVar.F, (HashMap<Object, Object>) hashMap);
        aVar.G = convertField(aVar.G, (HashMap<Object, Object>) hashMap);
        aVar.H = convertField(aVar.H, (HashMap<Object, Object>) hashMap);
        aVar.I = convertField(aVar.I, (HashMap<Object, Object>) hashMap);
        aVar.f23056x = convertField(aVar.f23056x, (HashMap<Object, Object>) hashMap);
        aVar.f23057y = convertField(aVar.f23057y, (HashMap<Object, Object>) hashMap);
        aVar.f23058z = convertField(aVar.f23058z, (HashMap<Object, Object>) hashMap);
        aVar.D = convertField(aVar.D, (HashMap<Object, Object>) hashMap);
        aVar.A = convertField(aVar.A, (HashMap<Object, Object>) hashMap);
        aVar.B = convertField(aVar.B, (HashMap<Object, Object>) hashMap);
        aVar.C = convertField(aVar.C, (HashMap<Object, Object>) hashMap);
        aVar.f23045m = convertField(aVar.f23045m, (HashMap<Object, Object>) hashMap);
        aVar.f23046n = convertField(aVar.f23046n, (HashMap<Object, Object>) hashMap);
        aVar.f23047o = convertField(aVar.f23047o, (HashMap<Object, Object>) hashMap);
        aVar.f23048p = convertField(aVar.f23048p, (HashMap<Object, Object>) hashMap);
        aVar.f23049q = convertField(aVar.f23049q, (HashMap<Object, Object>) hashMap);
        aVar.f23050r = convertField(aVar.f23050r, (HashMap<Object, Object>) hashMap);
        aVar.f23051s = convertField(aVar.f23051s, (HashMap<Object, Object>) hashMap);
        aVar.f23053u = convertField(aVar.f23053u, (HashMap<Object, Object>) hashMap);
        aVar.f23052t = convertField(aVar.f23052t, (HashMap<Object, Object>) hashMap);
        aVar.f23054v = convertField(aVar.f23054v, (HashMap<Object, Object>) hashMap);
        aVar.f23055w = convertField(aVar.f23055w, (HashMap<Object, Object>) hashMap);
    }

    public void checkLimits(long j11, String str) {
        DateTime dateTime = this.iLowerLimit;
        if (dateTime == null || j11 >= dateTime.getMillis()) {
            DateTime dateTime2 = this.iUpperLimit;
            if (dateTime2 != null && j11 >= dateTime2.getMillis()) {
                throw new LimitException(str, false);
            }
            return;
        }
        throw new LimitException(str, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitChronology)) {
            return false;
        }
        LimitChronology limitChronology = (LimitChronology) obj;
        if (!getBase().equals(limitChronology.getBase()) || !e.a(getLowerLimit(), limitChronology.getLowerLimit()) || !e.a(getUpperLimit(), limitChronology.getUpperLimit())) {
            return false;
        }
        return true;
    }

    public long getDateTimeMillis(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        long dateTimeMillis = getBase().getDateTimeMillis(i11, i12, i13, i14);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    public DateTime getLowerLimit() {
        return this.iLowerLimit;
    }

    public DateTime getUpperLimit() {
        return this.iUpperLimit;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = (getLowerLimit() != null ? getLowerLimit().hashCode() : 0) + 317351877;
        if (getUpperLimit() != null) {
            i11 = getUpperLimit().hashCode();
        }
        return hashCode + i11 + (getBase().hashCode() * 7);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LimitChronology[");
        sb2.append(getBase().toString());
        sb2.append(", ");
        String str = "NoLimit";
        sb2.append(getLowerLimit() == null ? str : getLowerLimit().toString());
        sb2.append(", ");
        if (getUpperLimit() != null) {
            str = getUpperLimit().toString();
        }
        sb2.append(str);
        sb2.append(']');
        return sb2.toString();
    }

    public Chronology withUTC() {
        return withZone(DateTimeZone.UTC);
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        LimitChronology limitChronology;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
        if (dateTimeZone == dateTimeZone2 && (limitChronology = this.iWithUTC) != null) {
            return limitChronology;
        }
        DateTime dateTime = this.iLowerLimit;
        if (dateTime != null) {
            MutableDateTime mutableDateTime = dateTime.toMutableDateTime();
            mutableDateTime.setZoneRetainFields(dateTimeZone);
            dateTime = mutableDateTime.toDateTime();
        }
        DateTime dateTime2 = this.iUpperLimit;
        if (dateTime2 != null) {
            MutableDateTime mutableDateTime2 = dateTime2.toMutableDateTime();
            mutableDateTime2.setZoneRetainFields(dateTimeZone);
            dateTime2 = mutableDateTime2.toDateTime();
        }
        LimitChronology instance = getInstance(getBase().withZone(dateTimeZone), dateTime, dateTime2);
        if (dateTimeZone == dateTimeZone2) {
            this.iWithUTC = instance;
        }
        return instance;
    }

    public class LimitDurationField extends DecoratedDurationField {
        private static final long serialVersionUID = 8049297699408782284L;

        public LimitDurationField(DurationField durationField) {
            super(durationField, durationField.getType());
        }

        public long add(long j11, int i11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long add = getWrappedField().add(j11, i11);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        public int getDifference(long j11, long j12) {
            LimitChronology.this.checkLimits(j11, "minuend");
            LimitChronology.this.checkLimits(j12, "subtrahend");
            return getWrappedField().getDifference(j11, j12);
        }

        public long getDifferenceAsLong(long j11, long j12) {
            LimitChronology.this.checkLimits(j11, "minuend");
            LimitChronology.this.checkLimits(j12, "subtrahend");
            return getWrappedField().getDifferenceAsLong(j11, j12);
        }

        public long getMillis(int i11, long j11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            return getWrappedField().getMillis(i11, j11);
        }

        public int getValue(long j11, long j12) {
            LimitChronology.this.checkLimits(j12, (String) null);
            return getWrappedField().getValue(j11, j12);
        }

        public long getValueAsLong(long j11, long j12) {
            LimitChronology.this.checkLimits(j12, (String) null);
            return getWrappedField().getValueAsLong(j11, j12);
        }

        public long getMillis(long j11, long j12) {
            LimitChronology.this.checkLimits(j12, (String) null);
            return getWrappedField().getMillis(j11, j12);
        }

        public long add(long j11, long j12) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long add = getWrappedField().add(j11, j12);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }
    }

    public class a extends c {

        /* renamed from: c  reason: collision with root package name */
        public final DurationField f23069c;

        /* renamed from: d  reason: collision with root package name */
        public final DurationField f23070d;

        /* renamed from: e  reason: collision with root package name */
        public final DurationField f23071e;

        public a(DateTimeField dateTimeField, DurationField durationField, DurationField durationField2, DurationField durationField3) {
            super(dateTimeField, dateTimeField.getType());
            this.f23069c = durationField;
            this.f23070d = durationField2;
            this.f23071e = durationField3;
        }

        public long add(long j11, int i11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long add = getWrappedField().add(j11, i11);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        public long addWrapField(long j11, int i11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long addWrapField = getWrappedField().addWrapField(j11, i11);
            LimitChronology.this.checkLimits(addWrapField, "resulting");
            return addWrapField;
        }

        public int get(long j11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            return getWrappedField().get(j11);
        }

        public String getAsShortText(long j11, Locale locale) {
            LimitChronology.this.checkLimits(j11, (String) null);
            return getWrappedField().getAsShortText(j11, locale);
        }

        public String getAsText(long j11, Locale locale) {
            LimitChronology.this.checkLimits(j11, (String) null);
            return getWrappedField().getAsText(j11, locale);
        }

        public int getDifference(long j11, long j12) {
            LimitChronology.this.checkLimits(j11, "minuend");
            LimitChronology.this.checkLimits(j12, "subtrahend");
            return getWrappedField().getDifference(j11, j12);
        }

        public long getDifferenceAsLong(long j11, long j12) {
            LimitChronology.this.checkLimits(j11, "minuend");
            LimitChronology.this.checkLimits(j12, "subtrahend");
            return getWrappedField().getDifferenceAsLong(j11, j12);
        }

        public final DurationField getDurationField() {
            return this.f23069c;
        }

        public int getLeapAmount(long j11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            return getWrappedField().getLeapAmount(j11);
        }

        public final DurationField getLeapDurationField() {
            return this.f23071e;
        }

        public int getMaximumShortTextLength(Locale locale) {
            return getWrappedField().getMaximumShortTextLength(locale);
        }

        public int getMaximumTextLength(Locale locale) {
            return getWrappedField().getMaximumTextLength(locale);
        }

        public int getMaximumValue(long j11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            return getWrappedField().getMaximumValue(j11);
        }

        public int getMinimumValue(long j11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            return getWrappedField().getMinimumValue(j11);
        }

        public final DurationField getRangeDurationField() {
            return this.f23070d;
        }

        public boolean isLeap(long j11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            return getWrappedField().isLeap(j11);
        }

        public long remainder(long j11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long remainder = getWrappedField().remainder(j11);
            LimitChronology.this.checkLimits(remainder, "resulting");
            return remainder;
        }

        public long roundCeiling(long j11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long roundCeiling = getWrappedField().roundCeiling(j11);
            LimitChronology.this.checkLimits(roundCeiling, "resulting");
            return roundCeiling;
        }

        public long roundFloor(long j11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long roundFloor = getWrappedField().roundFloor(j11);
            LimitChronology.this.checkLimits(roundFloor, "resulting");
            return roundFloor;
        }

        public long roundHalfCeiling(long j11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long roundHalfCeiling = getWrappedField().roundHalfCeiling(j11);
            LimitChronology.this.checkLimits(roundHalfCeiling, "resulting");
            return roundHalfCeiling;
        }

        public long roundHalfEven(long j11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long roundHalfEven = getWrappedField().roundHalfEven(j11);
            LimitChronology.this.checkLimits(roundHalfEven, "resulting");
            return roundHalfEven;
        }

        public long roundHalfFloor(long j11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long roundHalfFloor = getWrappedField().roundHalfFloor(j11);
            LimitChronology.this.checkLimits(roundHalfFloor, "resulting");
            return roundHalfFloor;
        }

        public long set(long j11, int i11) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long j12 = getWrappedField().set(j11, i11);
            LimitChronology.this.checkLimits(j12, "resulting");
            return j12;
        }

        public long add(long j11, long j12) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long add = getWrappedField().add(j11, j12);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        public long set(long j11, String str, Locale locale) {
            LimitChronology.this.checkLimits(j11, (String) null);
            long j12 = getWrappedField().set(j11, str, locale);
            LimitChronology.this.checkLimits(j12, "resulting");
            return j12;
        }
    }

    public long getDateTimeMillis(int i11, int i12, int i13, int i14, int i15, int i16, int i17) throws IllegalArgumentException {
        long dateTimeMillis = getBase().getDateTimeMillis(i11, i12, i13, i14, i15, i16, i17);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    public long getDateTimeMillis(long j11, int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        checkLimits(j11, (String) null);
        long dateTimeMillis = getBase().getDateTimeMillis(j11, i11, i12, i13, i14);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    private DateTimeField convertField(DateTimeField dateTimeField, HashMap<Object, Object> hashMap) {
        if (dateTimeField == null || !dateTimeField.isSupported()) {
            return dateTimeField;
        }
        if (hashMap.containsKey(dateTimeField)) {
            return (DateTimeField) hashMap.get(dateTimeField);
        }
        a aVar = new a(dateTimeField, convertField(dateTimeField.getDurationField(), hashMap), convertField(dateTimeField.getRangeDurationField(), hashMap), convertField(dateTimeField.getLeapDurationField(), hashMap));
        hashMap.put(dateTimeField, aVar);
        return aVar;
    }
}
