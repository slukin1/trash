package com.huobi.pandoraBox.crashKiller;

import android.os.Looper;
import com.huobi.pandoraBox.crashKiller.core.cleaner.PageCleaner;
import kotlin.Metadata;
import kotlin.jvm.internal.x;
import zp.a;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f8G@BX\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/huobi/pandoraBox/crashKiller/CrashKiller;", "", "Lcom/huobi/pandoraBox/crashKiller/c;", "handler", "", "d", "h", "Ljava/lang/Thread;", "t", "", "e", "f", "", "b", "Z", "isInstalled", "<set-?>", "c", "g", "()Z", "isSafeMode", "<init>", "()V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
public final class CrashKiller {

    /* renamed from: a  reason: collision with root package name */
    public static final CrashKiller f80297a = new CrashKiller();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f80298b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f80299c;

    /* renamed from: d  reason: collision with root package name */
    public static a f80300d;

    public static final void d(c cVar) {
        if (!f80298b) {
            f80298b = true;
            if (cVar != null) {
                f80300d = new a(cVar);
            }
            PageCleaner.f80302c.b().j(CrashKiller$install$2.INSTANCE);
            Thread.setDefaultUncaughtExceptionHandler(a.f80301b);
        }
    }

    public static final void e(Thread thread, Throwable th2) {
        a aVar = f80300d;
        if (aVar != null) {
            aVar.f(f80299c, thread, th2);
        }
        if (thread == Looper.getMainLooper().getThread()) {
            CrashKiller crashKiller = f80297a;
            crashKiller.f(thread, th2);
            crashKiller.h();
        }
    }

    public static final boolean g() {
        return f80299c;
    }

    public final void f(Thread thread, Throwable th2) {
        if (th2 != null) {
            if ((f80300d != null ? th2 : null) != null) {
                StackTraceElement[] stackTrace = th2.getStackTrace();
                int length = stackTrace.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i11 = length - 1;
                        if (stackTrace.length - length <= 20) {
                            StackTraceElement stackTraceElement = stackTrace[length];
                            if (x.b("android.view.Choreographer", stackTraceElement.getClassName()) && x.b("Choreographer.java", stackTraceElement.getFileName()) && x.b("doFrame", stackTraceElement.getMethodName())) {
                                a aVar = f80300d;
                                if (aVar != null) {
                                    aVar.e(thread, th2);
                                    return;
                                }
                                return;
                            } else if (i11 >= 0) {
                                length = i11;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void h() {
        if (!f80299c) {
            f80299c = true;
            a aVar = f80300d;
            if (aVar != null) {
                aVar.d();
            }
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th2) {
                    a aVar2 = f80300d;
                    if (aVar2 != null) {
                        aVar2.f(f80299c, Looper.getMainLooper().getThread(), th2);
                    }
                    f(Looper.getMainLooper().getThread(), th2);
                }
            }
        }
    }
}
