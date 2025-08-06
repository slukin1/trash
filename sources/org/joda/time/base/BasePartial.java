package org.joda.time.base;

import java.io.Serializable;
import java.util.Locale;
import m20.e;
import n20.d;
import n20.l;
import org.joda.time.Chronology;
import org.joda.time.a;
import org.joda.time.format.b;
import org.joda.time.h;

public abstract class BasePartial extends e implements Serializable {
    private static final long serialVersionUID = 2353678632973660L;
    private final Chronology iChronology;
    private final int[] iValues;

    public BasePartial() {
        this(a.b(), (Chronology) null);
    }

    public Chronology getChronology() {
        return this.iChronology;
    }

    public int getValue(int i11) {
        return this.iValues[i11];
    }

    public int[] getValues() {
        return (int[]) this.iValues.clone();
    }

    public void setValue(int i11, int i12) {
        int[] iArr = getField(i11).set(this, i11, this.iValues, i12);
        int[] iArr2 = this.iValues;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
    }

    public void setValues(int[] iArr) {
        getChronology().validate(this, iArr);
        int[] iArr2 = this.iValues;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
    }

    public abstract /* synthetic */ int size();

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).l(this);
    }

    public BasePartial(Chronology chronology) {
        this(a.b(), chronology);
    }

    public BasePartial(long j11) {
        this(j11, (Chronology) null);
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).v(locale).l(this);
    }

    public BasePartial(long j11, Chronology chronology) {
        Chronology c11 = a.c(chronology);
        this.iChronology = c11.withUTC();
        this.iValues = c11.get((h) this, j11);
    }

    public BasePartial(Object obj, Chronology chronology) {
        l e11 = d.b().e(obj);
        Chronology c11 = a.c(e11.a(obj, chronology));
        this.iChronology = c11.withUTC();
        this.iValues = e11.i(this, obj, c11);
    }

    public BasePartial(Object obj, Chronology chronology, b bVar) {
        l e11 = d.b().e(obj);
        Chronology c11 = a.c(e11.a(obj, chronology));
        this.iChronology = c11.withUTC();
        this.iValues = e11.f(this, obj, c11, bVar);
    }

    public BasePartial(int[] iArr, Chronology chronology) {
        Chronology c11 = a.c(chronology);
        this.iChronology = c11.withUTC();
        c11.validate(this, iArr);
        this.iValues = iArr;
    }

    public BasePartial(BasePartial basePartial, int[] iArr) {
        this.iChronology = basePartial.iChronology;
        this.iValues = iArr;
    }

    public BasePartial(BasePartial basePartial, Chronology chronology) {
        this.iChronology = chronology.withUTC();
        this.iValues = basePartial.iValues;
    }
}
