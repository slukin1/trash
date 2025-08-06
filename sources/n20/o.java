package n20;

import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.a;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.f;

public class o extends a implements h, l {

    /* renamed from: a  reason: collision with root package name */
    public static final o f22985a = new o();

    public Chronology a(Object obj, Chronology chronology) {
        return chronology == null ? a.c(((f) obj).getChronology()) : chronology;
    }

    public Chronology b(Object obj, DateTimeZone dateTimeZone) {
        Chronology chronology = ((f) obj).getChronology();
        if (chronology == null) {
            return ISOChronology.getInstance(dateTimeZone);
        }
        if (chronology.getZone() == dateTimeZone) {
            return chronology;
        }
        Chronology withZone = chronology.withZone(dateTimeZone);
        return withZone == null ? ISOChronology.getInstance(dateTimeZone) : withZone;
    }

    public Class<?> e() {
        return f.class;
    }

    public long k(Object obj, Chronology chronology) {
        return ((f) obj).getMillis();
    }
}
