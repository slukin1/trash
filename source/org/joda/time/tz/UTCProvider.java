package org.joda.time.tz;

import java.util.Collections;
import java.util.Set;
import org.joda.time.DateTimeZone;

public final class UTCProvider implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f25407a = Collections.singleton(UtcDates.UTC);

    public DateTimeZone a(String str) {
        if (UtcDates.UTC.equalsIgnoreCase(str)) {
            return DateTimeZone.UTC;
        }
        return null;
    }

    public Set<String> b() {
        return f25407a;
    }
}
