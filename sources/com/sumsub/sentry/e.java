package com.sumsub.sentry;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f30319a;

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<SimpleDateFormat> f30320b;

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f30321c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f30322d = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /* renamed from: e  reason: collision with root package name */
    public static final Date f30323e;

    static {
        e eVar = new e();
        f30319a = eVar;
        ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
        f30320b = threadLocal;
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            threadLocal.set(simpleDateFormat);
        }
        f30321c = simpleDateFormat;
        f30323e = a(eVar, (Long) null, 1, (Object) null);
    }

    public final Date a() {
        return f30323e;
    }

    public final Date a(String str) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US).parse(str);
    }

    public static /* synthetic */ Date a(e eVar, Long l11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = null;
        }
        return eVar.a(l11);
    }

    public final Date a(Long l11) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        if (l11 != null) {
            l11.longValue();
            instance.getTimeInMillis();
        }
        return instance.getTime();
    }

    public final String a(Date date) {
        return f30321c.format(date);
    }
}
