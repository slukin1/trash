package n20;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.JulianChronology;

public final class b extends a implements h, l {

    /* renamed from: a  reason: collision with root package name */
    public static final b f22970a = new b();

    public Chronology a(Object obj, Chronology chronology) {
        DateTimeZone dateTimeZone;
        if (chronology != null) {
            return chronology;
        }
        Calendar calendar = (Calendar) obj;
        try {
            dateTimeZone = DateTimeZone.forTimeZone(calendar.getTimeZone());
        } catch (IllegalArgumentException unused) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return b(calendar, dateTimeZone);
    }

    public Chronology b(Object obj, DateTimeZone dateTimeZone) {
        if (obj.getClass().getName().endsWith(".BuddhistCalendar")) {
            return BuddhistChronology.getInstance(dateTimeZone);
        }
        if (!(obj instanceof GregorianCalendar)) {
            return ISOChronology.getInstance(dateTimeZone);
        }
        long time = ((GregorianCalendar) obj).getGregorianChange().getTime();
        if (time == Long.MIN_VALUE) {
            return GregorianChronology.getInstance(dateTimeZone);
        }
        if (time == Long.MAX_VALUE) {
            return JulianChronology.getInstance(dateTimeZone);
        }
        return GJChronology.getInstance(dateTimeZone, time, 4);
    }

    public Class<?> e() {
        return Calendar.class;
    }

    public long k(Object obj, Chronology chronology) {
        return ((Calendar) obj).getTime().getTime();
    }
}
