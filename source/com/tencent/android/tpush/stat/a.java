package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.android.tpush.stat.b.c;
import java.lang.Thread;

public final class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static c f69921a = b.b();

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f69922b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f69923c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f69924d = false;

    /* renamed from: e  reason: collision with root package name */
    private Context f69925e = null;

    private a(Context context) {
        this.f69925e = context;
    }

    public static a a(Context context) {
        if (f69922b == null) {
            synchronized (a.class) {
                if (f69922b == null) {
                    f69922b = new a(context);
                }
            }
        }
        return f69922b;
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        if (this.f69924d) {
            c cVar = f69921a;
            cVar.f("already handle the uncaugth exception:" + th2);
            return;
        }
        this.f69924d = true;
        f69921a.h("catch app crash");
        StatServiceImpl.a(this.f69925e, th2);
        if (f69923c != null) {
            f69921a.h("Call the original uncaught exception handler.");
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f69923c;
            if (!(uncaughtExceptionHandler instanceof a)) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        }
    }

    public void a() {
        if (f69923c == null) {
            f69923c = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(f69922b);
            c cVar = f69921a;
            cVar.h("set up java crash handler:" + f69922b);
        }
    }
}
