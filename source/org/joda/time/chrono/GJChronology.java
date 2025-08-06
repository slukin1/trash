package org.joda.time.chrono;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.f;
import org.joda.time.field.DecoratedDurationField;
import org.joda.time.format.i;
import org.joda.time.h;

public final class GJChronology extends AssembledChronology {
    public static final Instant DEFAULT_CUTOVER = new Instant(-12219292800000L);
    private static final ConcurrentHashMap<h, GJChronology> cCache = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -2545574827706931671L;
    private Instant iCutoverInstant;
    private long iCutoverMillis;
    /* access modifiers changed from: private */
    public long iGapDuration;
    /* access modifiers changed from: private */
    public GregorianChronology iGregorianChronology;
    private JulianChronology iJulianChronology;

    public static class LinkedDurationField extends DecoratedDurationField {
        private static final long serialVersionUID = 4097975388007713084L;
        private final b iField;

        public LinkedDurationField(DurationField durationField, b bVar) {
            super(durationField, durationField.getType());
            this.iField = bVar;
        }

        public long add(long j11, int i11) {
            return this.iField.add(j11, i11);
        }

        public int getDifference(long j11, long j12) {
            return this.iField.getDifference(j11, j12);
        }

        public long getDifferenceAsLong(long j11, long j12) {
            return this.iField.getDifferenceAsLong(j11, j12);
        }

        public long add(long j11, long j12) {
            return this.iField.add(j11, j12);
        }
    }

    public class a extends org.joda.time.field.b {

        /* renamed from: b  reason: collision with root package name */
        public final DateTimeField f23061b;

        /* renamed from: c  reason: collision with root package name */
        public final DateTimeField f23062c;

        /* renamed from: d  reason: collision with root package name */
        public final long f23063d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f23064e;

        /* renamed from: f  reason: collision with root package name */
        public DurationField f23065f;

        /* renamed from: g  reason: collision with root package name */
        public DurationField f23066g;

        public a(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, long j11) {
            this(gJChronology, dateTimeField, dateTimeField2, j11, false);
        }

        public long add(long j11, int i11) {
            return this.f23062c.add(j11, i11);
        }

        public long b(long j11) {
            if (this.f23064e) {
                return GJChronology.this.gregorianToJulianByWeekyear(j11);
            }
            return GJChronology.this.gregorianToJulianByYear(j11);
        }

        public long c(long j11) {
            if (this.f23064e) {
                return GJChronology.this.julianToGregorianByWeekyear(j11);
            }
            return GJChronology.this.julianToGregorianByYear(j11);
        }

        public int get(long j11) {
            if (j11 >= this.f23063d) {
                return this.f23062c.get(j11);
            }
            return this.f23061b.get(j11);
        }

        public String getAsShortText(long j11, Locale locale) {
            if (j11 >= this.f23063d) {
                return this.f23062c.getAsShortText(j11, locale);
            }
            return this.f23061b.getAsShortText(j11, locale);
        }

        public String getAsText(long j11, Locale locale) {
            if (j11 >= this.f23063d) {
                return this.f23062c.getAsText(j11, locale);
            }
            return this.f23061b.getAsText(j11, locale);
        }

        public int getDifference(long j11, long j12) {
            return this.f23062c.getDifference(j11, j12);
        }

        public long getDifferenceAsLong(long j11, long j12) {
            return this.f23062c.getDifferenceAsLong(j11, j12);
        }

        public DurationField getDurationField() {
            return this.f23065f;
        }

        public int getLeapAmount(long j11) {
            if (j11 >= this.f23063d) {
                return this.f23062c.getLeapAmount(j11);
            }
            return this.f23061b.getLeapAmount(j11);
        }

        public DurationField getLeapDurationField() {
            return this.f23062c.getLeapDurationField();
        }

        public int getMaximumShortTextLength(Locale locale) {
            return Math.max(this.f23061b.getMaximumShortTextLength(locale), this.f23062c.getMaximumShortTextLength(locale));
        }

        public int getMaximumTextLength(Locale locale) {
            return Math.max(this.f23061b.getMaximumTextLength(locale), this.f23062c.getMaximumTextLength(locale));
        }

        public int getMaximumValue() {
            return this.f23062c.getMaximumValue();
        }

        public int getMinimumValue() {
            return this.f23061b.getMinimumValue();
        }

        public DurationField getRangeDurationField() {
            return this.f23066g;
        }

        public boolean isLeap(long j11) {
            if (j11 >= this.f23063d) {
                return this.f23062c.isLeap(j11);
            }
            return this.f23061b.isLeap(j11);
        }

        public boolean isLenient() {
            return false;
        }

        public long roundCeiling(long j11) {
            if (j11 >= this.f23063d) {
                return this.f23062c.roundCeiling(j11);
            }
            long roundCeiling = this.f23061b.roundCeiling(j11);
            return (roundCeiling < this.f23063d || roundCeiling - GJChronology.this.iGapDuration < this.f23063d) ? roundCeiling : c(roundCeiling);
        }

        public long roundFloor(long j11) {
            if (j11 < this.f23063d) {
                return this.f23061b.roundFloor(j11);
            }
            long roundFloor = this.f23062c.roundFloor(j11);
            if (roundFloor >= this.f23063d || GJChronology.this.iGapDuration + roundFloor >= this.f23063d) {
                return roundFloor;
            }
            return b(roundFloor);
        }

        public long set(long j11, int i11) {
            long j12;
            if (j11 >= this.f23063d) {
                j12 = this.f23062c.set(j11, i11);
                if (j12 < this.f23063d) {
                    if (GJChronology.this.iGapDuration + j12 < this.f23063d) {
                        j12 = b(j12);
                    }
                    if (get(j12) != i11) {
                        throw new IllegalFieldValueException(this.f23062c.getType(), (Number) Integer.valueOf(i11), (Number) null, (Number) null);
                    }
                }
            } else {
                j12 = this.f23061b.set(j11, i11);
                if (j12 >= this.f23063d) {
                    if (j12 - GJChronology.this.iGapDuration >= this.f23063d) {
                        j12 = c(j12);
                    }
                    if (get(j12) != i11) {
                        throw new IllegalFieldValueException(this.f23061b.getType(), (Number) Integer.valueOf(i11), (Number) null, (Number) null);
                    }
                }
            }
            return j12;
        }

        public a(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, long j11, boolean z11) {
            this(dateTimeField, dateTimeField2, (DurationField) null, j11, z11);
        }

        public long add(long j11, long j12) {
            return this.f23062c.add(j11, j12);
        }

        public int getMaximumValue(long j11) {
            if (j11 >= this.f23063d) {
                return this.f23062c.getMaximumValue(j11);
            }
            int maximumValue = this.f23061b.getMaximumValue(j11);
            long j12 = this.f23061b.set(j11, maximumValue);
            long j13 = this.f23063d;
            if (j12 < j13) {
                return maximumValue;
            }
            DateTimeField dateTimeField = this.f23061b;
            return dateTimeField.get(dateTimeField.add(j13, -1));
        }

        public int getMinimumValue(h hVar) {
            return this.f23061b.getMinimumValue(hVar);
        }

        public a(DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, long j11, boolean z11) {
            super(dateTimeField2.getType());
            this.f23061b = dateTimeField;
            this.f23062c = dateTimeField2;
            this.f23063d = j11;
            this.f23064e = z11;
            this.f23065f = dateTimeField2.getDurationField();
            if (durationField == null && (durationField = dateTimeField2.getRangeDurationField()) == null) {
                durationField = dateTimeField.getRangeDurationField();
            }
            this.f23066g = durationField;
        }

        public int[] add(h hVar, int i11, int[] iArr, int i12) {
            if (i12 == 0) {
                return iArr;
            }
            if (!org.joda.time.a.n(hVar)) {
                return super.add(hVar, i11, iArr, i12);
            }
            long j11 = 0;
            int size = hVar.size();
            for (int i13 = 0; i13 < size; i13++) {
                j11 = hVar.getFieldType(i13).getField(GJChronology.this).set(j11, iArr[i13]);
            }
            return GJChronology.this.get(hVar, add(j11, i12));
        }

        public int getMinimumValue(h hVar, int[] iArr) {
            return this.f23061b.getMinimumValue(hVar, iArr);
        }

        public String getAsShortText(int i11, Locale locale) {
            return this.f23062c.getAsShortText(i11, locale);
        }

        public String getAsText(int i11, Locale locale) {
            return this.f23062c.getAsText(i11, locale);
        }

        public int getMinimumValue(long j11) {
            if (j11 < this.f23063d) {
                return this.f23061b.getMinimumValue(j11);
            }
            int minimumValue = this.f23062c.getMinimumValue(j11);
            long j12 = this.f23062c.set(j11, minimumValue);
            long j13 = this.f23063d;
            return j12 < j13 ? this.f23062c.get(j13) : minimumValue;
        }

        public int getMaximumValue(h hVar) {
            return getMaximumValue(GJChronology.getInstanceUTC().set(hVar, 0));
        }

        public int getMaximumValue(h hVar, int[] iArr) {
            GJChronology instanceUTC = GJChronology.getInstanceUTC();
            int size = hVar.size();
            long j11 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                DateTimeField field = hVar.getFieldType(i11).getField(instanceUTC);
                if (iArr[i11] <= field.getMaximumValue(j11)) {
                    j11 = field.set(j11, iArr[i11]);
                }
            }
            return getMaximumValue(j11);
        }

        public long set(long j11, String str, Locale locale) {
            if (j11 >= this.f23063d) {
                long j12 = this.f23062c.set(j11, str, locale);
                if (j12 >= this.f23063d || GJChronology.this.iGapDuration + j12 >= this.f23063d) {
                    return j12;
                }
                return b(j12);
            }
            long j13 = this.f23061b.set(j11, str, locale);
            return (j13 < this.f23063d || j13 - GJChronology.this.iGapDuration < this.f23063d) ? j13 : c(j13);
        }
    }

    public final class b extends a {
        public b(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, long j11) {
            this(dateTimeField, dateTimeField2, (DurationField) null, j11, false);
        }

        public long add(long j11, int i11) {
            if (j11 >= this.f23063d) {
                long add = this.f23062c.add(j11, i11);
                if (add >= this.f23063d || GJChronology.this.iGapDuration + add >= this.f23063d) {
                    return add;
                }
                if (this.f23064e) {
                    if (GJChronology.this.iGregorianChronology.weekyear().get(add) <= 0) {
                        add = GJChronology.this.iGregorianChronology.weekyear().add(add, -1);
                    }
                } else if (GJChronology.this.iGregorianChronology.year().get(add) <= 0) {
                    add = GJChronology.this.iGregorianChronology.year().add(add, -1);
                }
                return b(add);
            }
            long add2 = this.f23061b.add(j11, i11);
            return (add2 < this.f23063d || add2 - GJChronology.this.iGapDuration < this.f23063d) ? add2 : c(add2);
        }

        public int getDifference(long j11, long j12) {
            long j13 = this.f23063d;
            if (j11 >= j13) {
                if (j12 >= j13) {
                    return this.f23062c.getDifference(j11, j12);
                }
                return this.f23061b.getDifference(b(j11), j12);
            } else if (j12 < j13) {
                return this.f23061b.getDifference(j11, j12);
            } else {
                return this.f23062c.getDifference(c(j11), j12);
            }
        }

        public long getDifferenceAsLong(long j11, long j12) {
            long j13 = this.f23063d;
            if (j11 >= j13) {
                if (j12 >= j13) {
                    return this.f23062c.getDifferenceAsLong(j11, j12);
                }
                return this.f23061b.getDifferenceAsLong(b(j11), j12);
            } else if (j12 < j13) {
                return this.f23061b.getDifferenceAsLong(j11, j12);
            } else {
                return this.f23062c.getDifferenceAsLong(c(j11), j12);
            }
        }

        public int getMaximumValue(long j11) {
            if (j11 >= this.f23063d) {
                return this.f23062c.getMaximumValue(j11);
            }
            return this.f23061b.getMaximumValue(j11);
        }

        public int getMinimumValue(long j11) {
            if (j11 >= this.f23063d) {
                return this.f23062c.getMinimumValue(j11);
            }
            return this.f23061b.getMinimumValue(j11);
        }

        public b(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, long j11) {
            this(dateTimeField, dateTimeField2, durationField, j11, false);
        }

        public b(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, DurationField durationField2, long j11) {
            this(dateTimeField, dateTimeField2, durationField, j11, false);
            this.f23066g = durationField2;
        }

        public b(DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, long j11, boolean z11) {
            super(GJChronology.this, dateTimeField, dateTimeField2, j11, z11);
            this.f23065f = durationField == null ? new LinkedDurationField(this.f23065f, this) : durationField;
        }

        public long add(long j11, long j12) {
            if (j11 >= this.f23063d) {
                long add = this.f23062c.add(j11, j12);
                if (add >= this.f23063d || GJChronology.this.iGapDuration + add >= this.f23063d) {
                    return add;
                }
                if (this.f23064e) {
                    if (GJChronology.this.iGregorianChronology.weekyear().get(add) <= 0) {
                        add = GJChronology.this.iGregorianChronology.weekyear().add(add, -1);
                    }
                } else if (GJChronology.this.iGregorianChronology.year().get(add) <= 0) {
                    add = GJChronology.this.iGregorianChronology.year().add(add, -1);
                }
                return b(add);
            }
            long add2 = this.f23061b.add(j11, j12);
            return (add2 < this.f23063d || add2 - GJChronology.this.iGapDuration < this.f23063d) ? add2 : c(add2);
        }
    }

    private GJChronology(JulianChronology julianChronology, GregorianChronology gregorianChronology, Instant instant) {
        super((Chronology) null, new Object[]{julianChronology, gregorianChronology, instant});
    }

    private static long convertByWeekyear(long j11, Chronology chronology, Chronology chronology2) {
        return chronology2.millisOfDay().set(chronology2.dayOfWeek().set(chronology2.weekOfWeekyear().set(chronology2.weekyear().set(0, chronology.weekyear().get(j11)), chronology.weekOfWeekyear().get(j11)), chronology.dayOfWeek().get(j11)), chronology.millisOfDay().get(j11));
    }

    private static long convertByYear(long j11, Chronology chronology, Chronology chronology2) {
        return chronology2.getDateTimeMillis(chronology.year().get(j11), chronology.monthOfYear().get(j11), chronology.dayOfMonth().get(j11), chronology.millisOfDay().get(j11));
    }

    public static GJChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), (f) DEFAULT_CUTOVER, 4);
    }

    public static GJChronology getInstanceUTC() {
        return getInstance(DateTimeZone.UTC, (f) DEFAULT_CUTOVER, 4);
    }

    private Object readResolve() {
        return getInstance(getZone(), (f) this.iCutoverInstant, getMinimumDaysInFirstWeek());
    }

    public void assemble(AssembledChronology.a aVar) {
        Object[] objArr = (Object[]) getParam();
        JulianChronology julianChronology = (JulianChronology) objArr[0];
        GregorianChronology gregorianChronology = (GregorianChronology) objArr[1];
        Instant instant = (Instant) objArr[2];
        this.iCutoverMillis = instant.getMillis();
        this.iJulianChronology = julianChronology;
        this.iGregorianChronology = gregorianChronology;
        this.iCutoverInstant = instant;
        if (getBase() == null) {
            if (julianChronology.getMinimumDaysInFirstWeek() == gregorianChronology.getMinimumDaysInFirstWeek()) {
                long j11 = this.iCutoverMillis;
                this.iGapDuration = j11 - julianToGregorianByYear(j11);
                aVar.a(gregorianChronology);
                if (gregorianChronology.millisOfDay().get(this.iCutoverMillis) == 0) {
                    aVar.f23045m = new a(this, julianChronology.millisOfSecond(), aVar.f23045m, this.iCutoverMillis);
                    aVar.f23046n = new a(this, julianChronology.millisOfDay(), aVar.f23046n, this.iCutoverMillis);
                    aVar.f23047o = new a(this, julianChronology.secondOfMinute(), aVar.f23047o, this.iCutoverMillis);
                    aVar.f23048p = new a(this, julianChronology.secondOfDay(), aVar.f23048p, this.iCutoverMillis);
                    aVar.f23049q = new a(this, julianChronology.minuteOfHour(), aVar.f23049q, this.iCutoverMillis);
                    aVar.f23050r = new a(this, julianChronology.minuteOfDay(), aVar.f23050r, this.iCutoverMillis);
                    aVar.f23051s = new a(this, julianChronology.hourOfDay(), aVar.f23051s, this.iCutoverMillis);
                    aVar.f23053u = new a(this, julianChronology.hourOfHalfday(), aVar.f23053u, this.iCutoverMillis);
                    aVar.f23052t = new a(this, julianChronology.clockhourOfDay(), aVar.f23052t, this.iCutoverMillis);
                    aVar.f23054v = new a(this, julianChronology.clockhourOfHalfday(), aVar.f23054v, this.iCutoverMillis);
                    aVar.f23055w = new a(this, julianChronology.halfdayOfDay(), aVar.f23055w, this.iCutoverMillis);
                }
                aVar.I = new a(this, julianChronology.era(), aVar.I, this.iCutoverMillis);
                b bVar = new b(this, julianChronology.year(), aVar.E, this.iCutoverMillis);
                aVar.E = bVar;
                aVar.f23042j = bVar.getDurationField();
                aVar.F = new b(this, julianChronology.yearOfEra(), aVar.F, aVar.f23042j, this.iCutoverMillis);
                b bVar2 = new b(this, julianChronology.centuryOfEra(), aVar.H, this.iCutoverMillis);
                aVar.H = bVar2;
                aVar.f23043k = bVar2.getDurationField();
                aVar.G = new b(this, julianChronology.yearOfCentury(), aVar.G, aVar.f23042j, aVar.f23043k, this.iCutoverMillis);
                b bVar3 = new b(this, julianChronology.monthOfYear(), aVar.D, (DurationField) null, aVar.f23042j, this.iCutoverMillis);
                aVar.D = bVar3;
                aVar.f23041i = bVar3.getDurationField();
                b bVar4 = new b(julianChronology.weekyear(), aVar.B, (DurationField) null, this.iCutoverMillis, true);
                aVar.B = bVar4;
                aVar.f23040h = bVar4.getDurationField();
                aVar.C = new b(this, julianChronology.weekyearOfCentury(), aVar.C, aVar.f23040h, aVar.f23043k, this.iCutoverMillis);
                aVar.f23058z = new a(julianChronology.dayOfYear(), aVar.f23058z, aVar.f23042j, gregorianChronology.year().roundCeiling(this.iCutoverMillis), false);
                aVar.A = new a(julianChronology.weekOfWeekyear(), aVar.A, aVar.f23040h, gregorianChronology.weekyear().roundCeiling(this.iCutoverMillis), true);
                a aVar2 = new a(this, julianChronology.dayOfMonth(), aVar.f23057y, this.iCutoverMillis);
                aVar2.f23066g = aVar.f23041i;
                aVar.f23057y = aVar2;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GJChronology)) {
            return false;
        }
        GJChronology gJChronology = (GJChronology) obj;
        if (this.iCutoverMillis == gJChronology.iCutoverMillis && getMinimumDaysInFirstWeek() == gJChronology.getMinimumDaysInFirstWeek() && getZone().equals(gJChronology.getZone())) {
            return true;
        }
        return false;
    }

    public long getDateTimeMillis(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        Chronology base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i11, i12, i13, i14);
        }
        long dateTimeMillis = this.iGregorianChronology.getDateTimeMillis(i11, i12, i13, i14);
        if (dateTimeMillis < this.iCutoverMillis) {
            dateTimeMillis = this.iJulianChronology.getDateTimeMillis(i11, i12, i13, i14);
            if (dateTimeMillis >= this.iCutoverMillis) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
        }
        return dateTimeMillis;
    }

    public Instant getGregorianCutover() {
        return this.iCutoverInstant;
    }

    public int getMinimumDaysInFirstWeek() {
        return this.iGregorianChronology.getMinimumDaysInFirstWeek();
    }

    public DateTimeZone getZone() {
        Chronology base = getBase();
        if (base != null) {
            return base.getZone();
        }
        return DateTimeZone.UTC;
    }

    public long gregorianToJulianByWeekyear(long j11) {
        return convertByWeekyear(j11, this.iGregorianChronology, this.iJulianChronology);
    }

    public long gregorianToJulianByYear(long j11) {
        return convertByYear(j11, this.iGregorianChronology, this.iJulianChronology);
    }

    public int hashCode() {
        return 25025 + getZone().hashCode() + getMinimumDaysInFirstWeek() + this.iCutoverInstant.hashCode();
    }

    public long julianToGregorianByWeekyear(long j11) {
        return convertByWeekyear(j11, this.iJulianChronology, this.iGregorianChronology);
    }

    public long julianToGregorianByYear(long j11) {
        return convertByYear(j11, this.iJulianChronology, this.iGregorianChronology);
    }

    public String toString() {
        org.joda.time.format.b bVar;
        StringBuffer stringBuffer = new StringBuffer(60);
        stringBuffer.append("GJChronology");
        stringBuffer.append('[');
        stringBuffer.append(getZone().getID());
        if (this.iCutoverMillis != DEFAULT_CUTOVER.getMillis()) {
            stringBuffer.append(",cutover=");
            if (withUTC().dayOfYear().remainder(this.iCutoverMillis) == 0) {
                bVar = i.c();
            } else {
                bVar = i.h();
            }
            bVar.u(withUTC()).q(stringBuffer, this.iCutoverMillis);
        }
        if (getMinimumDaysInFirstWeek() != 4) {
            stringBuffer.append(",mdfw=");
            stringBuffer.append(getMinimumDaysInFirstWeek());
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public Chronology withUTC() {
        return withZone(DateTimeZone.UTC);
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        return getInstance(dateTimeZone, (f) this.iCutoverInstant, getMinimumDaysInFirstWeek());
    }

    private GJChronology(Chronology chronology, JulianChronology julianChronology, GregorianChronology gregorianChronology, Instant instant) {
        super(chronology, new Object[]{julianChronology, gregorianChronology, instant});
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, (f) DEFAULT_CUTOVER, 4);
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, f fVar) {
        return getInstance(dateTimeZone, fVar, 4);
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, f fVar, int i11) {
        Instant instant;
        GJChronology gJChronology;
        DateTimeZone m11 = org.joda.time.a.m(dateTimeZone);
        if (fVar == null) {
            instant = DEFAULT_CUTOVER;
        } else {
            instant = fVar.toInstant();
            if (new LocalDate(instant.getMillis(), (Chronology) GregorianChronology.getInstance(m11)).getYear() <= 0) {
                throw new IllegalArgumentException("Cutover too early. Must be on or after 0001-01-01.");
            }
        }
        h hVar = new h(m11, instant, i11);
        ConcurrentHashMap<h, GJChronology> concurrentHashMap = cCache;
        GJChronology gJChronology2 = concurrentHashMap.get(hVar);
        if (gJChronology2 != null) {
            return gJChronology2;
        }
        DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
        if (m11 == dateTimeZone2) {
            gJChronology = new GJChronology(JulianChronology.getInstance(m11, i11), GregorianChronology.getInstance(m11, i11), instant);
        } else {
            GJChronology instance = getInstance(dateTimeZone2, (f) instant, i11);
            gJChronology = new GJChronology(ZonedChronology.getInstance(instance, m11), instance.iJulianChronology, instance.iGregorianChronology, instance.iCutoverInstant);
        }
        GJChronology putIfAbsent = concurrentHashMap.putIfAbsent(hVar, gJChronology);
        return putIfAbsent != null ? putIfAbsent : gJChronology;
    }

    public long getDateTimeMillis(int i11, int i12, int i13, int i14, int i15, int i16, int i17) throws IllegalArgumentException {
        long j11;
        Chronology base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i11, i12, i13, i14, i15, i16, i17);
        }
        try {
            j11 = this.iGregorianChronology.getDateTimeMillis(i11, i12, i13, i14, i15, i16, i17);
            int i18 = i12;
            int i19 = i13;
        } catch (IllegalFieldValueException e11) {
            if (i12 == 2 && i13 == 29) {
                j11 = this.iGregorianChronology.getDateTimeMillis(i11, i12, 28, i14, i15, i16, i17);
                if (j11 >= this.iCutoverMillis) {
                    throw e11;
                }
            } else {
                throw e11;
            }
        }
        if (j11 < this.iCutoverMillis) {
            j11 = this.iJulianChronology.getDateTimeMillis(i11, i12, i13, i14, i15, i16, i17);
            if (j11 >= this.iCutoverMillis) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
        }
        return j11;
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, long j11, int i11) {
        Instant instant;
        if (j11 == DEFAULT_CUTOVER.getMillis()) {
            instant = null;
        } else {
            instant = new Instant(j11);
        }
        return getInstance(dateTimeZone, (f) instant, i11);
    }
}
