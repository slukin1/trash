package f00;

import io.reactivex.rxjava3.core.Scheduler;
import j00.h;
import java.util.Objects;
import java.util.concurrent.Callable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h<Callable<Scheduler>, Scheduler> f54460a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile h<Scheduler, Scheduler> f54461b;

    public static <T, R> R a(h<T, R> hVar, T t11) {
        try {
            return hVar.apply(t11);
        } catch (Throwable th2) {
            throw io.reactivex.rxjava3.exceptions.a.a(th2);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j00.h<java.util.concurrent.Callable<io.reactivex.rxjava3.core.Scheduler>, io.reactivex.rxjava3.core.Scheduler>, j00.h] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.reactivex.rxjava3.core.Scheduler b(j00.h<java.util.concurrent.Callable<io.reactivex.rxjava3.core.Scheduler>, io.reactivex.rxjava3.core.Scheduler> r0, java.util.concurrent.Callable<io.reactivex.rxjava3.core.Scheduler> r1) {
        /*
            java.lang.Object r0 = a(r0, r1)
            io.reactivex.rxjava3.core.Scheduler r0 = (io.reactivex.rxjava3.core.Scheduler) r0
            java.lang.String r1 = "Scheduler Callable returned null"
            java.util.Objects.requireNonNull(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f00.a.b(j00.h, java.util.concurrent.Callable):io.reactivex.rxjava3.core.Scheduler");
    }

    public static Scheduler c(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th2) {
            throw io.reactivex.rxjava3.exceptions.a.a(th2);
        }
    }

    public static Scheduler d(Callable<Scheduler> callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        h<Callable<Scheduler>, Scheduler> hVar = f54460a;
        if (hVar == null) {
            return c(callable);
        }
        return b(hVar, callable);
    }

    public static Scheduler e(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler == null");
        h hVar = f54461b;
        if (hVar == null) {
            return scheduler;
        }
        return (Scheduler) a(hVar, scheduler);
    }
}
