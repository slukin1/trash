package o00;

import h00.f;
import h00.m;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import j00.c;
import j00.e;
import j00.g;
import j00.h;
import j00.k;
import java.util.Objects;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g<? super Throwable> f58771a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile h<? super Runnable, ? extends Runnable> f58772b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile h<? super k<Scheduler>, ? extends Scheduler> f58773c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile h<? super k<Scheduler>, ? extends Scheduler> f58774d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile h<? super k<Scheduler>, ? extends Scheduler> f58775e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile h<? super k<Scheduler>, ? extends Scheduler> f58776f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile h<? super Scheduler, ? extends Scheduler> f58777g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile h<? super Flowable, ? extends Flowable> f58778h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile h<? super Single, ? extends Single> f58779i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile c<? super Flowable, ? super z20.c, ? extends z20.c> f58780j;

    /* renamed from: k  reason: collision with root package name */
    public static volatile c<? super Maybe, ? super f, ? extends f> f58781k;

    /* renamed from: l  reason: collision with root package name */
    public static volatile c<? super Observable, ? super h00.k, ? extends h00.k> f58782l;

    /* renamed from: m  reason: collision with root package name */
    public static volatile c<? super Single, ? super m, ? extends m> f58783m;

    /* renamed from: n  reason: collision with root package name */
    public static volatile c<? super Completable, ? super h00.a, ? extends h00.a> f58784n;

    /* renamed from: o  reason: collision with root package name */
    public static volatile e f58785o;

    /* renamed from: p  reason: collision with root package name */
    public static volatile boolean f58786p;

    public static <T, U, R> R a(c<T, U, R> cVar, T t11, U u11) {
        try {
            return cVar.apply(t11, u11);
        } catch (Throwable th2) {
            throw ExceptionHelper.g(th2);
        }
    }

    public static <T, R> R b(h<T, R> hVar, T t11) {
        try {
            return hVar.apply(t11);
        } catch (Throwable th2) {
            throw ExceptionHelper.g(th2);
        }
    }

    public static Scheduler c(h<? super k<Scheduler>, ? extends Scheduler> hVar, k<Scheduler> kVar) {
        Object b11 = b(hVar, kVar);
        Objects.requireNonNull(b11, "Scheduler Supplier result can't be null");
        return (Scheduler) b11;
    }

    public static Scheduler d(k<Scheduler> kVar) {
        try {
            Scheduler scheduler = kVar.get();
            Objects.requireNonNull(scheduler, "Scheduler Supplier result can't be null");
            return scheduler;
        } catch (Throwable th2) {
            throw ExceptionHelper.g(th2);
        }
    }

    public static Scheduler e(k<Scheduler> kVar) {
        Objects.requireNonNull(kVar, "Scheduler Supplier can't be null");
        h<? super k<Scheduler>, ? extends Scheduler> hVar = f58773c;
        if (hVar == null) {
            return d(kVar);
        }
        return c(hVar, kVar);
    }

    public static Scheduler f(k<Scheduler> kVar) {
        Objects.requireNonNull(kVar, "Scheduler Supplier can't be null");
        h<? super k<Scheduler>, ? extends Scheduler> hVar = f58775e;
        if (hVar == null) {
            return d(kVar);
        }
        return c(hVar, kVar);
    }

    public static Scheduler g(k<Scheduler> kVar) {
        Objects.requireNonNull(kVar, "Scheduler Supplier can't be null");
        h<? super k<Scheduler>, ? extends Scheduler> hVar = f58776f;
        if (hVar == null) {
            return d(kVar);
        }
        return c(hVar, kVar);
    }

    public static Scheduler h(k<Scheduler> kVar) {
        Objects.requireNonNull(kVar, "Scheduler Supplier can't be null");
        h<? super k<Scheduler>, ? extends Scheduler> hVar = f58774d;
        if (hVar == null) {
            return d(kVar);
        }
        return c(hVar, kVar);
    }

    public static boolean i(Throwable th2) {
        if (!(th2 instanceof OnErrorNotImplementedException) && !(th2 instanceof MissingBackpressureException) && !(th2 instanceof IllegalStateException) && !(th2 instanceof NullPointerException) && !(th2 instanceof IllegalArgumentException) && !(th2 instanceof CompositeException)) {
            return false;
        }
        return true;
    }

    public static boolean j() {
        return f58786p;
    }

    public static <T> Flowable<T> k(Flowable<T> flowable) {
        h<? super Flowable, ? extends Flowable> hVar = f58778h;
        return hVar != null ? (Flowable) b(hVar, flowable) : flowable;
    }

    public static <T> Single<T> l(Single<T> single) {
        h<? super Single, ? extends Single> hVar = f58779i;
        return hVar != null ? (Single) b(hVar, single) : single;
    }

    public static boolean m() {
        e eVar = f58785o;
        if (eVar == null) {
            return false;
        }
        try {
            return eVar.getAsBoolean();
        } catch (Throwable th2) {
            throw ExceptionHelper.g(th2);
        }
    }

    public static void n(Throwable th2) {
        g<? super Throwable> gVar = f58771a;
        if (th2 == null) {
            th2 = ExceptionHelper.b("onError called with a null Throwable.");
        } else if (!i(th2)) {
            th2 = new UndeliverableException(th2);
        }
        if (gVar != null) {
            try {
                gVar.accept(th2);
                return;
            } catch (Throwable th3) {
                th3.printStackTrace();
                v(th3);
            }
        }
        th2.printStackTrace();
        v(th2);
    }

    public static Scheduler o(Scheduler scheduler) {
        h<? super Scheduler, ? extends Scheduler> hVar = f58777g;
        if (hVar == null) {
            return scheduler;
        }
        return (Scheduler) b(hVar, scheduler);
    }

    public static Runnable p(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        h<? super Runnable, ? extends Runnable> hVar = f58772b;
        if (hVar == null) {
            return runnable;
        }
        return (Runnable) b(hVar, runnable);
    }

    public static h00.a q(Completable completable, h00.a aVar) {
        c<? super Completable, ? super h00.a, ? extends h00.a> cVar = f58784n;
        return cVar != null ? (h00.a) a(cVar, completable, aVar) : aVar;
    }

    public static <T> f<? super T> r(Maybe<T> maybe, f<? super T> fVar) {
        c<? super Maybe, ? super f, ? extends f> cVar = f58781k;
        return cVar != null ? (f) a(cVar, maybe, fVar) : fVar;
    }

    public static <T> h00.k<? super T> s(Observable<T> observable, h00.k<? super T> kVar) {
        c<? super Observable, ? super h00.k, ? extends h00.k> cVar = f58782l;
        return cVar != null ? (h00.k) a(cVar, observable, kVar) : kVar;
    }

    public static <T> m<? super T> t(Single<T> single, m<? super T> mVar) {
        c<? super Single, ? super m, ? extends m> cVar = f58783m;
        return cVar != null ? (m) a(cVar, single, mVar) : mVar;
    }

    public static <T> z20.c<? super T> u(Flowable<T> flowable, z20.c<? super T> cVar) {
        c<? super Flowable, ? super z20.c, ? extends z20.c> cVar2 = f58780j;
        return cVar2 != null ? (z20.c) a(cVar2, flowable, cVar) : cVar;
    }

    public static void v(Throwable th2) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }
}
