package org.joda.time;

import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.chrono.ISOChronology;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final b f23030a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile C0204a f23031b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicReference<Map<String, DateTimeZone>> f23032c = new AtomicReference<>();

    /* renamed from: org.joda.time.a$a  reason: collision with other inner class name */
    public interface C0204a {
        long getMillis();
    }

    public static class b implements C0204a {
        public long getMillis() {
            return System.currentTimeMillis();
        }
    }

    static {
        b bVar = new b();
        f23030a = bVar;
        f23031b = bVar;
    }

    public static Map<String, DateTimeZone> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DateTimeZone dateTimeZone = DateTimeZone.UTC;
        linkedHashMap.put("UT", dateTimeZone);
        linkedHashMap.put(UtcDates.UTC, dateTimeZone);
        linkedHashMap.put("GMT", dateTimeZone);
        o(linkedHashMap, "EST", "America/New_York");
        o(linkedHashMap, "EDT", "America/New_York");
        o(linkedHashMap, "CST", "America/Chicago");
        o(linkedHashMap, "CDT", "America/Chicago");
        o(linkedHashMap, "MST", "America/Denver");
        o(linkedHashMap, "MDT", "America/Denver");
        o(linkedHashMap, "PST", "America/Los_Angeles");
        o(linkedHashMap, "PDT", "America/Los_Angeles");
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static final long b() {
        return f23031b.getMillis();
    }

    public static final Chronology c(Chronology chronology) {
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final DateFormatSymbols d(Locale locale) {
        try {
            return (DateFormatSymbols) DateFormatSymbols.class.getMethod("getInstance", new Class[]{Locale.class}).invoke((Object) null, new Object[]{locale});
        } catch (Exception unused) {
            return new DateFormatSymbols(locale);
        }
    }

    public static final Map<String, DateTimeZone> e() {
        AtomicReference<Map<String, DateTimeZone>> atomicReference = f23032c;
        Map<String, DateTimeZone> map = atomicReference.get();
        if (map != null) {
            return map;
        }
        Map<String, DateTimeZone> a11 = a();
        return !atomicReference.compareAndSet((Object) null, a11) ? atomicReference.get() : a11;
    }

    public static final long f(e eVar) {
        if (eVar == null) {
            return 0;
        }
        return eVar.getMillis();
    }

    public static final Chronology g(f fVar) {
        if (fVar == null) {
            return ISOChronology.getInstance();
        }
        Chronology chronology = fVar.getChronology();
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final long h(f fVar) {
        if (fVar == null) {
            return b();
        }
        return fVar.getMillis();
    }

    public static final Chronology i(f fVar, f fVar2) {
        Chronology chronology;
        if (fVar != null) {
            chronology = fVar.getChronology();
        } else {
            chronology = fVar2 != null ? fVar2.getChronology() : null;
        }
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final Chronology j(g gVar) {
        if (gVar == null) {
            return ISOChronology.getInstance();
        }
        Chronology chronology = gVar.getChronology();
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final PeriodType k(PeriodType periodType) {
        return periodType == null ? PeriodType.standard() : periodType;
    }

    public static final g l(g gVar) {
        if (gVar != null) {
            return gVar;
        }
        long b11 = b();
        return new Interval(b11, b11);
    }

    public static final DateTimeZone m(DateTimeZone dateTimeZone) {
        return dateTimeZone == null ? DateTimeZone.getDefault() : dateTimeZone;
    }

    public static final boolean n(h hVar) {
        if (hVar != null) {
            DurationFieldType durationFieldType = null;
            for (int i11 = 0; i11 < hVar.size(); i11++) {
                DateTimeField field = hVar.getField(i11);
                if (i11 > 0 && (field.getRangeDurationField() == null || field.getRangeDurationField().getType() != durationFieldType)) {
                    return false;
                }
                durationFieldType = field.getDurationField().getType();
            }
            return true;
        }
        throw new IllegalArgumentException("Partial must not be null");
    }

    public static void o(Map<String, DateTimeZone> map, String str, String str2) {
        try {
            map.put(str, DateTimeZone.forID(str2));
        } catch (RuntimeException unused) {
        }
    }
}
