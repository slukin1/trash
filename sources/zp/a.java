package zp;

import com.huobi.pandoraBox.crashKiller.c;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J\t\u0010\u000b\u001a\u00020\tH\u0001J\u001e\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002¨\u0006\u0012"}, d2 = {"Lzp/a;", "Lcom/huobi/pandoraBox/crashKiller/c;", "", "throwable", "", "a", "isSafeMode", "Ljava/lang/Thread;", "thread", "", "c", "b", "f", "d", "e", "exHandler", "<init>", "(Lcom/huobi/pandoraBox/crashKiller/c;)V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f85102a;

    /* renamed from: b  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f85103b = Thread.getDefaultUncaughtExceptionHandler();

    public a(c cVar) {
        this.f85102a = cVar;
    }

    public boolean a(Throwable th2) {
        return this.f85102a.a(th2);
    }

    public void b() {
        this.f85102a.b();
    }

    public void c(boolean z11, Thread thread, Throwable th2) {
        this.f85102a.c(z11, thread, th2);
    }

    public final void d() {
        try {
            b();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void e(Thread thread, Throwable th2) {
        try {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f85103b;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public final void f(boolean z11, Thread thread, Throwable th2) {
        try {
            if (a(th2)) {
                if (!(th2 instanceof Error)) {
                    c(z11, thread, new Throwable(x.i("CrashKiller-", th2.getMessage()), th2));
                    return;
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f85103b;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }
}
