package org.joda.time.chrono;

import java.util.HashMap;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.BaseDurationField;
import org.joda.time.field.b;
import org.joda.time.h;

public final class ZonedChronology extends AssembledChronology {
    private static final long serialVersionUID = -1079258847191166848L;

    public static class ZonedDurationField extends BaseDurationField {
        private static final long serialVersionUID = -485345310999208286L;
        public final DurationField iField;
        public final boolean iTimeField;
        public final DateTimeZone iZone;

        public ZonedDurationField(DurationField durationField, DateTimeZone dateTimeZone) {
            super(durationField.getType());
            if (durationField.isSupported()) {
                this.iField = durationField;
                this.iTimeField = ZonedChronology.useTimeArithmetic(durationField);
                this.iZone = dateTimeZone;
                return;
            }
            throw new IllegalArgumentException();
        }

        private long addOffset(long j11) {
            return this.iZone.convertUTCToLocal(j11);
        }

        private int getOffsetFromLocalToSubtract(long j11) {
            int offsetFromLocal = this.iZone.getOffsetFromLocal(j11);
            long j12 = (long) offsetFromLocal;
            if (((j11 - j12) ^ j11) >= 0 || (j11 ^ j12) >= 0) {
                return offsetFromLocal;
            }
            throw new ArithmeticException("Subtracting time zone offset caused overflow");
        }

        private int getOffsetToAdd(long j11) {
            int offset = this.iZone.getOffset(j11);
            long j12 = (long) offset;
            if (((j11 + j12) ^ j11) >= 0 || (j11 ^ j12) < 0) {
                return offset;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        public long add(long j11, int i11) {
            int offsetToAdd = getOffsetToAdd(j11);
            long add = this.iField.add(j11 + ((long) offsetToAdd), i11);
            if (!this.iTimeField) {
                offsetToAdd = getOffsetFromLocalToSubtract(add);
            }
            return add - ((long) offsetToAdd);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ZonedDurationField)) {
                return false;
            }
            ZonedDurationField zonedDurationField = (ZonedDurationField) obj;
            if (!this.iField.equals(zonedDurationField.iField) || !this.iZone.equals(zonedDurationField.iZone)) {
                return false;
            }
            return true;
        }

        public int getDifference(long j11, long j12) {
            int offsetToAdd = getOffsetToAdd(j12);
            return this.iField.getDifference(j11 + ((long) (this.iTimeField ? offsetToAdd : getOffsetToAdd(j11))), j12 + ((long) offsetToAdd));
        }

        public long getDifferenceAsLong(long j11, long j12) {
            int offsetToAdd = getOffsetToAdd(j12);
            return this.iField.getDifferenceAsLong(j11 + ((long) (this.iTimeField ? offsetToAdd : getOffsetToAdd(j11))), j12 + ((long) offsetToAdd));
        }

        public long getMillis(int i11, long j11) {
            return this.iField.getMillis(i11, addOffset(j11));
        }

        public long getUnitMillis() {
            return this.iField.getUnitMillis();
        }

        public int getValue(long j11, long j12) {
            return this.iField.getValue(j11, addOffset(j12));
        }

        public long getValueAsLong(long j11, long j12) {
            return this.iField.getValueAsLong(j11, addOffset(j12));
        }

        public int hashCode() {
            return this.iField.hashCode() ^ this.iZone.hashCode();
        }

        public boolean isPrecise() {
            if (this.iTimeField) {
                return this.iField.isPrecise();
            }
            return this.iField.isPrecise() && this.iZone.isFixed();
        }

        public long getMillis(long j11, long j12) {
            return this.iField.getMillis(j11, addOffset(j12));
        }

        public long add(long j11, long j12) {
            int offsetToAdd = getOffsetToAdd(j11);
            long add = this.iField.add(j11 + ((long) offsetToAdd), j12);
            if (!this.iTimeField) {
                offsetToAdd = getOffsetFromLocalToSubtract(add);
            }
            return add - ((long) offsetToAdd);
        }
    }

    public static final class a extends b {

        /* renamed from: b  reason: collision with root package name */
        public final DateTimeField f23073b;

        /* renamed from: c  reason: collision with root package name */
        public final DateTimeZone f23074c;

        /* renamed from: d  reason: collision with root package name */
        public final DurationField f23075d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f23076e;

        /* renamed from: f  reason: collision with root package name */
        public final DurationField f23077f;

        /* renamed from: g  reason: collision with root package name */
        public final DurationField f23078g;

        public a(DateTimeField dateTimeField, DateTimeZone dateTimeZone, DurationField durationField, DurationField durationField2, DurationField durationField3) {
            super(dateTimeField.getType());
            if (dateTimeField.isSupported()) {
                this.f23073b = dateTimeField;
                this.f23074c = dateTimeZone;
                this.f23075d = durationField;
                this.f23076e = ZonedChronology.useTimeArithmetic(durationField);
                this.f23077f = durationField2;
                this.f23078g = durationField3;
                return;
            }
            throw new IllegalArgumentException();
        }

        public long add(long j11, int i11) {
            if (this.f23076e) {
                long b11 = (long) b(j11);
                return this.f23073b.add(j11 + b11, i11) - b11;
            }
            return this.f23074c.convertLocalToUTC(this.f23073b.add(this.f23074c.convertUTCToLocal(j11), i11), false, j11);
        }

        public long addWrapField(long j11, int i11) {
            if (this.f23076e) {
                long b11 = (long) b(j11);
                return this.f23073b.addWrapField(j11 + b11, i11) - b11;
            }
            return this.f23074c.convertLocalToUTC(this.f23073b.addWrapField(this.f23074c.convertUTCToLocal(j11), i11), false, j11);
        }

        public final int b(long j11) {
            int offset = this.f23074c.getOffset(j11);
            long j12 = (long) offset;
            if (((j11 + j12) ^ j11) >= 0 || (j11 ^ j12) < 0) {
                return offset;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f23073b.equals(aVar.f23073b) || !this.f23074c.equals(aVar.f23074c) || !this.f23075d.equals(aVar.f23075d) || !this.f23077f.equals(aVar.f23077f)) {
                return false;
            }
            return true;
        }

        public int get(long j11) {
            return this.f23073b.get(this.f23074c.convertUTCToLocal(j11));
        }

        public String getAsShortText(long j11, Locale locale) {
            return this.f23073b.getAsShortText(this.f23074c.convertUTCToLocal(j11), locale);
        }

        public String getAsText(long j11, Locale locale) {
            return this.f23073b.getAsText(this.f23074c.convertUTCToLocal(j11), locale);
        }

        public int getDifference(long j11, long j12) {
            int b11 = b(j12);
            return this.f23073b.getDifference(j11 + ((long) (this.f23076e ? b11 : b(j11))), j12 + ((long) b11));
        }

        public long getDifferenceAsLong(long j11, long j12) {
            int b11 = b(j12);
            return this.f23073b.getDifferenceAsLong(j11 + ((long) (this.f23076e ? b11 : b(j11))), j12 + ((long) b11));
        }

        public final DurationField getDurationField() {
            return this.f23075d;
        }

        public int getLeapAmount(long j11) {
            return this.f23073b.getLeapAmount(this.f23074c.convertUTCToLocal(j11));
        }

        public final DurationField getLeapDurationField() {
            return this.f23078g;
        }

        public int getMaximumShortTextLength(Locale locale) {
            return this.f23073b.getMaximumShortTextLength(locale);
        }

        public int getMaximumTextLength(Locale locale) {
            return this.f23073b.getMaximumTextLength(locale);
        }

        public int getMaximumValue() {
            return this.f23073b.getMaximumValue();
        }

        public int getMinimumValue() {
            return this.f23073b.getMinimumValue();
        }

        public final DurationField getRangeDurationField() {
            return this.f23077f;
        }

        public int hashCode() {
            return this.f23073b.hashCode() ^ this.f23074c.hashCode();
        }

        public boolean isLeap(long j11) {
            return this.f23073b.isLeap(this.f23074c.convertUTCToLocal(j11));
        }

        public boolean isLenient() {
            return this.f23073b.isLenient();
        }

        public long remainder(long j11) {
            return this.f23073b.remainder(this.f23074c.convertUTCToLocal(j11));
        }

        public long roundCeiling(long j11) {
            if (this.f23076e) {
                long b11 = (long) b(j11);
                return this.f23073b.roundCeiling(j11 + b11) - b11;
            }
            return this.f23074c.convertLocalToUTC(this.f23073b.roundCeiling(this.f23074c.convertUTCToLocal(j11)), false, j11);
        }

        public long roundFloor(long j11) {
            if (this.f23076e) {
                long b11 = (long) b(j11);
                return this.f23073b.roundFloor(j11 + b11) - b11;
            }
            return this.f23074c.convertLocalToUTC(this.f23073b.roundFloor(this.f23074c.convertUTCToLocal(j11)), false, j11);
        }

        public long set(long j11, int i11) {
            long j12 = this.f23073b.set(this.f23074c.convertUTCToLocal(j11), i11);
            long convertLocalToUTC = this.f23074c.convertLocalToUTC(j12, false, j11);
            if (get(convertLocalToUTC) == i11) {
                return convertLocalToUTC;
            }
            IllegalInstantException illegalInstantException = new IllegalInstantException(j12, this.f23074c.getID());
            IllegalFieldValueException illegalFieldValueException = new IllegalFieldValueException(this.f23073b.getType(), Integer.valueOf(i11), illegalInstantException.getMessage());
            illegalFieldValueException.initCause(illegalInstantException);
            throw illegalFieldValueException;
        }

        public int getMaximumValue(long j11) {
            return this.f23073b.getMaximumValue(this.f23074c.convertUTCToLocal(j11));
        }

        public int getMinimumValue(long j11) {
            return this.f23073b.getMinimumValue(this.f23074c.convertUTCToLocal(j11));
        }

        public String getAsShortText(int i11, Locale locale) {
            return this.f23073b.getAsShortText(i11, locale);
        }

        public String getAsText(int i11, Locale locale) {
            return this.f23073b.getAsText(i11, locale);
        }

        public int getMaximumValue(h hVar) {
            return this.f23073b.getMaximumValue(hVar);
        }

        public int getMinimumValue(h hVar) {
            return this.f23073b.getMinimumValue(hVar);
        }

        public int getMaximumValue(h hVar, int[] iArr) {
            return this.f23073b.getMaximumValue(hVar, iArr);
        }

        public int getMinimumValue(h hVar, int[] iArr) {
            return this.f23073b.getMinimumValue(hVar, iArr);
        }

        public long add(long j11, long j12) {
            if (this.f23076e) {
                long b11 = (long) b(j11);
                return this.f23073b.add(j11 + b11, j12) - b11;
            }
            return this.f23074c.convertLocalToUTC(this.f23073b.add(this.f23074c.convertUTCToLocal(j11), j12), false, j11);
        }

        public long set(long j11, String str, Locale locale) {
            return this.f23074c.convertLocalToUTC(this.f23073b.set(this.f23074c.convertUTCToLocal(j11), str, locale), false, j11);
        }
    }

    private ZonedChronology(Chronology chronology, DateTimeZone dateTimeZone) {
        super(chronology, dateTimeZone);
    }

    private DurationField convertField(DurationField durationField, HashMap<Object, Object> hashMap) {
        if (durationField == null || !durationField.isSupported()) {
            return durationField;
        }
        if (hashMap.containsKey(durationField)) {
            return (DurationField) hashMap.get(durationField);
        }
        ZonedDurationField zonedDurationField = new ZonedDurationField(durationField, getZone());
        hashMap.put(durationField, zonedDurationField);
        return zonedDurationField;
    }

    public static ZonedChronology getInstance(Chronology chronology, DateTimeZone dateTimeZone) {
        if (chronology != null) {
            Chronology withUTC = chronology.withUTC();
            if (withUTC == null) {
                throw new IllegalArgumentException("UTC chronology must not be null");
            } else if (dateTimeZone != null) {
                return new ZonedChronology(withUTC, dateTimeZone);
            } else {
                throw new IllegalArgumentException("DateTimeZone must not be null");
            }
        } else {
            throw new IllegalArgumentException("Must supply a chronology");
        }
    }

    private long localToUTC(long j11) {
        DateTimeZone zone = getZone();
        int offsetFromLocal = zone.getOffsetFromLocal(j11);
        long j12 = j11 - ((long) offsetFromLocal);
        if (offsetFromLocal == zone.getOffset(j12)) {
            return j12;
        }
        throw new IllegalInstantException(j11, zone.getID());
    }

    public static boolean useTimeArithmetic(DurationField durationField) {
        return durationField != null && durationField.getUnitMillis() < 43200000;
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedChronology)) {
            return false;
        }
        ZonedChronology zonedChronology = (ZonedChronology) obj;
        if (!getBase().equals(zonedChronology.getBase()) || !getZone().equals(zonedChronology.getZone())) {
            return false;
        }
        return true;
    }

    public long getDateTimeMillis(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        return localToUTC(getBase().getDateTimeMillis(i11, i12, i13, i14));
    }

    public DateTimeZone getZone() {
        return (DateTimeZone) getParam();
    }

    public int hashCode() {
        return (getZone().hashCode() * 11) + 326565 + (getBase().hashCode() * 7);
    }

    public String toString() {
        return "ZonedChronology[" + getBase() + ", " + getZone().getID() + ']';
    }

    public Chronology withUTC() {
        return getBase();
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getParam()) {
            return this;
        }
        if (dateTimeZone == DateTimeZone.UTC) {
            return getBase();
        }
        return new ZonedChronology(getBase(), dateTimeZone);
    }

    public long getDateTimeMillis(int i11, int i12, int i13, int i14, int i15, int i16, int i17) throws IllegalArgumentException {
        return localToUTC(getBase().getDateTimeMillis(i11, i12, i13, i14, i15, i16, i17));
    }

    public long getDateTimeMillis(long j11, int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        return localToUTC(getBase().getDateTimeMillis(((long) getZone().getOffset(j11)) + j11, i11, i12, i13, i14));
    }

    private DateTimeField convertField(DateTimeField dateTimeField, HashMap<Object, Object> hashMap) {
        if (dateTimeField == null || !dateTimeField.isSupported()) {
            return dateTimeField;
        }
        if (hashMap.containsKey(dateTimeField)) {
            return (DateTimeField) hashMap.get(dateTimeField);
        }
        a aVar = new a(dateTimeField, getZone(), convertField(dateTimeField.getDurationField(), hashMap), convertField(dateTimeField.getRangeDurationField(), hashMap), convertField(dateTimeField.getLeapDurationField(), hashMap));
        hashMap.put(dateTimeField, aVar);
        return aVar;
    }
}
