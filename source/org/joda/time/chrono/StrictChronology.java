package org.joda.time.chrono;

import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.StrictDateTimeField;

public final class StrictChronology extends AssembledChronology {
    private static final long serialVersionUID = 6633006628097111960L;
    private transient Chronology iWithUTC;

    private StrictChronology(Chronology chronology) {
        super(chronology, (Object) null);
    }

    private static final DateTimeField convertField(DateTimeField dateTimeField) {
        return StrictDateTimeField.getInstance(dateTimeField);
    }

    public static StrictChronology getInstance(Chronology chronology) {
        if (chronology != null) {
            return new StrictChronology(chronology);
        }
        throw new IllegalArgumentException("Must supply a chronology");
    }

    public void assemble(AssembledChronology.a aVar) {
        aVar.E = convertField(aVar.E);
        aVar.F = convertField(aVar.F);
        aVar.G = convertField(aVar.G);
        aVar.H = convertField(aVar.H);
        aVar.I = convertField(aVar.I);
        aVar.f23056x = convertField(aVar.f23056x);
        aVar.f23057y = convertField(aVar.f23057y);
        aVar.f23058z = convertField(aVar.f23058z);
        aVar.D = convertField(aVar.D);
        aVar.A = convertField(aVar.A);
        aVar.B = convertField(aVar.B);
        aVar.C = convertField(aVar.C);
        aVar.f23045m = convertField(aVar.f23045m);
        aVar.f23046n = convertField(aVar.f23046n);
        aVar.f23047o = convertField(aVar.f23047o);
        aVar.f23048p = convertField(aVar.f23048p);
        aVar.f23049q = convertField(aVar.f23049q);
        aVar.f23050r = convertField(aVar.f23050r);
        aVar.f23051s = convertField(aVar.f23051s);
        aVar.f23053u = convertField(aVar.f23053u);
        aVar.f23052t = convertField(aVar.f23052t);
        aVar.f23054v = convertField(aVar.f23054v);
        aVar.f23055w = convertField(aVar.f23055w);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrictChronology)) {
            return false;
        }
        return getBase().equals(((StrictChronology) obj).getBase());
    }

    public int hashCode() {
        return (getBase().hashCode() * 7) + 352831696;
    }

    public String toString() {
        return "StrictChronology[" + getBase().toString() + ']';
    }

    public Chronology withUTC() {
        if (this.iWithUTC == null) {
            if (getZone() == DateTimeZone.UTC) {
                this.iWithUTC = this;
            } else {
                this.iWithUTC = getInstance(getBase().withUTC());
            }
        }
        return this.iWithUTC;
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == DateTimeZone.UTC) {
            return withUTC();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        return getInstance(getBase().withZone(dateTimeZone));
    }
}
