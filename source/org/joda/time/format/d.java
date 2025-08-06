package org.joda.time.format;

import java.util.Arrays;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Chronology f23206a;

    /* renamed from: b  reason: collision with root package name */
    public final long f23207b;

    /* renamed from: c  reason: collision with root package name */
    public final Locale f23208c;

    /* renamed from: d  reason: collision with root package name */
    public final int f23209d;

    /* renamed from: e  reason: collision with root package name */
    public final DateTimeZone f23210e;

    /* renamed from: f  reason: collision with root package name */
    public final Integer f23211f;

    /* renamed from: g  reason: collision with root package name */
    public DateTimeZone f23212g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f23213h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f23214i;

    /* renamed from: j  reason: collision with root package name */
    public a[] f23215j;

    /* renamed from: k  reason: collision with root package name */
    public int f23216k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f23217l;

    /* renamed from: m  reason: collision with root package name */
    public Object f23218m;

    public static class a implements Comparable<a> {

        /* renamed from: b  reason: collision with root package name */
        public DateTimeField f23219b;

        /* renamed from: c  reason: collision with root package name */
        public int f23220c;

        /* renamed from: d  reason: collision with root package name */
        public String f23221d;

        /* renamed from: e  reason: collision with root package name */
        public Locale f23222e;

        /* renamed from: a */
        public int compareTo(a aVar) {
            DateTimeField dateTimeField = aVar.f23219b;
            int j11 = d.j(this.f23219b.getRangeDurationField(), dateTimeField.getRangeDurationField());
            if (j11 != 0) {
                return j11;
            }
            return d.j(this.f23219b.getDurationField(), dateTimeField.getDurationField());
        }

        public void b(DateTimeField dateTimeField, int i11) {
            this.f23219b = dateTimeField;
            this.f23220c = i11;
            this.f23221d = null;
            this.f23222e = null;
        }

        public void c(DateTimeField dateTimeField, String str, Locale locale) {
            this.f23219b = dateTimeField;
            this.f23220c = 0;
            this.f23221d = str;
            this.f23222e = locale;
        }

        public long e(long j11, boolean z11) {
            long j12;
            String str = this.f23221d;
            if (str == null) {
                j12 = this.f23219b.set(j11, this.f23220c);
            } else {
                j12 = this.f23219b.set(j11, str, this.f23222e);
            }
            return z11 ? this.f23219b.roundFloor(j12) : j12;
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public final DateTimeZone f23223a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f23224b;

        /* renamed from: c  reason: collision with root package name */
        public final a[] f23225c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23226d;

        public b() {
            this.f23223a = d.this.f23212g;
            this.f23224b = d.this.f23213h;
            this.f23225c = d.this.f23215j;
            this.f23226d = d.this.f23216k;
        }

        public boolean a(d dVar) {
            if (dVar != d.this) {
                return false;
            }
            DateTimeZone unused = dVar.f23212g = this.f23223a;
            Integer unused2 = dVar.f23213h = this.f23224b;
            a[] unused3 = dVar.f23215j = this.f23225c;
            if (this.f23226d < dVar.f23216k) {
                boolean unused4 = dVar.f23217l = true;
            }
            int unused5 = dVar.f23216k = this.f23226d;
            return true;
        }
    }

    public d(long j11, Chronology chronology, Locale locale, Integer num, int i11) {
        Chronology c11 = org.joda.time.a.c(chronology);
        this.f23207b = j11;
        DateTimeZone zone = c11.getZone();
        this.f23210e = zone;
        this.f23206a = c11.withUTC();
        this.f23208c = locale == null ? Locale.getDefault() : locale;
        this.f23209d = i11;
        this.f23211f = num;
        this.f23212g = zone;
        this.f23214i = num;
        this.f23215j = new a[8];
    }

    public static void A(a[] aVarArr, int i11) {
        if (i11 > 10) {
            Arrays.sort(aVarArr, 0, i11);
            return;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            for (int i13 = i12; i13 > 0; i13--) {
                int i14 = i13 - 1;
                if (aVarArr[i14].compareTo(aVarArr[i13]) <= 0) {
                    break;
                }
                a aVar = aVarArr[i13];
                aVarArr[i13] = aVarArr[i14];
                aVarArr[i14] = aVar;
            }
        }
    }

    public static int j(DurationField durationField, DurationField durationField2) {
        if (durationField == null || !durationField.isSupported()) {
            return (durationField2 == null || !durationField2.isSupported()) ? 0 : -1;
        }
        if (durationField2 == null || !durationField2.isSupported()) {
            return 1;
        }
        return -durationField.compareTo(durationField2);
    }

    public long k(boolean z11, CharSequence charSequence) {
        a[] aVarArr = this.f23215j;
        int i11 = this.f23216k;
        if (this.f23217l) {
            aVarArr = (a[]) aVarArr.clone();
            this.f23215j = aVarArr;
            this.f23217l = false;
        }
        A(aVarArr, i11);
        if (i11 > 0) {
            DurationField field = DurationFieldType.months().getField(this.f23206a);
            DurationField field2 = DurationFieldType.days().getField(this.f23206a);
            DurationField durationField = aVarArr[0].f23219b.getDurationField();
            if (j(durationField, field) >= 0 && j(durationField, field2) <= 0) {
                v(DateTimeFieldType.year(), this.f23209d);
                return k(z11, charSequence);
            }
        }
        long j11 = this.f23207b;
        int i12 = 0;
        while (i12 < i11) {
            try {
                j11 = aVarArr[i12].e(j11, z11);
                i12++;
            } catch (IllegalFieldValueException e11) {
                if (charSequence != null) {
                    e11.prependMessage("Cannot parse \"" + charSequence + '\"');
                }
                throw e11;
            }
        }
        if (z11) {
            int i13 = 0;
            while (i13 < i11) {
                j11 = aVarArr[i13].e(j11, i13 == i11 + -1);
                i13++;
            }
        }
        Integer num = this.f23213h;
        if (num != null) {
            return j11 - ((long) num.intValue());
        }
        DateTimeZone dateTimeZone = this.f23212g;
        if (dateTimeZone == null) {
            return j11;
        }
        int offsetFromLocal = dateTimeZone.getOffsetFromLocal(j11);
        long j12 = j11 - ((long) offsetFromLocal);
        if (offsetFromLocal == this.f23212g.getOffset(j12)) {
            return j12;
        }
        String str = "Illegal instant due to time zone offset transition (" + this.f23212g + ')';
        if (charSequence != null) {
            str = "Cannot parse \"" + charSequence + "\": " + str;
        }
        throw new IllegalInstantException(str);
    }

    public long l(boolean z11, String str) {
        return k(z11, str);
    }

    public long m(k kVar, CharSequence charSequence) {
        int parseInto = kVar.parseInto(this, charSequence, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= charSequence.length()) {
            return k(true, charSequence);
        }
        throw new IllegalArgumentException(h.h(charSequence.toString(), parseInto));
    }

    public Chronology n() {
        return this.f23206a;
    }

    public Locale o() {
        return this.f23208c;
    }

    public Integer p() {
        return this.f23213h;
    }

    public Integer q() {
        return this.f23214i;
    }

    public DateTimeZone r() {
        return this.f23212g;
    }

    public final a s() {
        a[] aVarArr = this.f23215j;
        int i11 = this.f23216k;
        if (i11 == aVarArr.length || this.f23217l) {
            a[] aVarArr2 = new a[(i11 == aVarArr.length ? i11 * 2 : aVarArr.length)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, i11);
            this.f23215j = aVarArr2;
            this.f23217l = false;
            aVarArr = aVarArr2;
        }
        this.f23218m = null;
        a aVar = aVarArr[i11];
        if (aVar == null) {
            aVar = new a();
            aVarArr[i11] = aVar;
        }
        this.f23216k = i11 + 1;
        return aVar;
    }

    public boolean t(Object obj) {
        if (!(obj instanceof b) || !((b) obj).a(this)) {
            return false;
        }
        this.f23218m = obj;
        return true;
    }

    public void u(DateTimeField dateTimeField, int i11) {
        s().b(dateTimeField, i11);
    }

    public void v(DateTimeFieldType dateTimeFieldType, int i11) {
        s().b(dateTimeFieldType.getField(this.f23206a), i11);
    }

    public void w(DateTimeFieldType dateTimeFieldType, String str, Locale locale) {
        s().c(dateTimeFieldType.getField(this.f23206a), str, locale);
    }

    public Object x() {
        if (this.f23218m == null) {
            this.f23218m = new b();
        }
        return this.f23218m;
    }

    public void y(Integer num) {
        this.f23218m = null;
        this.f23213h = num;
    }

    public void z(DateTimeZone dateTimeZone) {
        this.f23218m = null;
        this.f23212g = dateTimeZone;
    }
}
