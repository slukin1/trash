package com.sumsub.sns.internal.log;

import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.l;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Integer, String> f34871a = MapsKt__MapsKt.l(l.a(6, "E"), l.a(5, "W"), l.a(3, "D"), l.a(4, "I"), l.a(2, "V"));

    public static final Map<Integer, String> a() {
        return f34871a;
    }

    public static /* synthetic */ void b(a aVar, String str, String str2, Throwable th2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        if ((i11 & 4) != 0) {
            th2 = null;
        }
        b(aVar, str, str2, th2);
    }

    public static /* synthetic */ void c(a aVar, String str, String str2, Throwable th2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        if ((i11 & 4) != 0) {
            th2 = null;
        }
        c(aVar, str, str2, th2);
    }

    public static /* synthetic */ void d(a aVar, String str, String str2, Throwable th2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        if ((i11 & 4) != 0) {
            th2 = null;
        }
        d(aVar, str, str2, th2);
    }

    public static /* synthetic */ void a(a aVar, String str, String str2, Throwable th2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        if ((i11 & 4) != 0) {
            th2 = null;
        }
        a(aVar, str, str2, th2);
    }

    public static final void b(a aVar, String str, String str2, Throwable th2) {
        aVar.a(LoggerType.KIBANA).e(str, str2, th2);
    }

    public static final void c(a aVar, String str, String str2, Throwable th2) {
        aVar.a(LoggerType.KIBANA).i(str, str2, th2);
    }

    public static final void d(a aVar, String str, String str2, Throwable th2) {
        aVar.a(LoggerType.KIBANA).w(str, str2, th2);
    }

    public static final void a(a aVar, String str, String str2, Throwable th2) {
        aVar.a(LoggerType.KIBANA).d(str, str2, th2);
    }

    public static final void a(a aVar, List<? extends LoggerType> list, String str, d10.l<? super com.sumsub.sns.internal.log.logger.b, Unit> lVar) {
        com.sumsub.sns.internal.log.logger.b a11 = aVar.a(str);
        try {
            lVar.invoke(a11);
        } finally {
            a11.a(list);
            a11.flush();
            aVar.b(str);
        }
    }
}
