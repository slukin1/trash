package n20;

import com.iproov.sdk.bridge.OptionsBridge;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.b;
import org.joda.time.h;

public abstract class a implements c {
    public Chronology a(Object obj, Chronology chronology) {
        return org.joda.time.a.c(chronology);
    }

    public Chronology b(Object obj, DateTimeZone dateTimeZone) {
        return ISOChronology.getInstance(dateTimeZone);
    }

    public boolean c(Object obj, Chronology chronology) {
        return false;
    }

    public int[] f(h hVar, Object obj, Chronology chronology, b bVar) {
        return i(hVar, obj, chronology);
    }

    public PeriodType h(Object obj) {
        return PeriodType.standard();
    }

    public int[] i(h hVar, Object obj, Chronology chronology) {
        return chronology.get(hVar, k(obj, chronology));
    }

    public long k(Object obj, Chronology chronology) {
        return org.joda.time.a.b();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Converter[");
        sb2.append(e() == null ? OptionsBridge.NULL_VALUE : e().getName());
        sb2.append("]");
        return sb2.toString();
    }
}
