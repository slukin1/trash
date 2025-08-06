package com.iproov.sdk.p028strictfp;

import java.util.Calendar;
import java.util.TimeZone;

/* renamed from: com.iproov.sdk.strictfp.case  reason: invalid class name and invalid package */
public final class Ccase {

    /* renamed from: do  reason: not valid java name */
    public static final Ccase f1964do = new Ccase();

    private Ccase() {
    }

    /* renamed from: do  reason: not valid java name */
    public final long m1837do() {
        return Calendar.getInstance(TimeZone.getTimeZone(UtcDates.UTC)).getTimeInMillis();
    }
}
