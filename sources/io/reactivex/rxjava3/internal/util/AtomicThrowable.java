package io.reactivex.rxjava3.internal.util;

import h00.f;
import h00.k;
import h00.m;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;
import z20.c;

public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean isTerminated() {
        return get() == ExceptionHelper.f55703a;
    }

    public Throwable terminate() {
        return ExceptionHelper.e(this);
    }

    public boolean tryAddThrowable(Throwable th2) {
        return ExceptionHelper.a(this, th2);
    }

    public boolean tryAddThrowableOrReport(Throwable th2) {
        if (tryAddThrowable(th2)) {
            return true;
        }
        a.n(th2);
        return false;
    }

    public void tryTerminateAndReport() {
        Throwable terminate = terminate();
        if (terminate != null && terminate != ExceptionHelper.f55703a) {
            a.n(terminate);
        }
    }

    public void tryTerminateConsumer(c<?> cVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            cVar.onComplete();
        } else if (terminate != ExceptionHelper.f55703a) {
            cVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(k<?> kVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            kVar.onComplete();
        } else if (terminate != ExceptionHelper.f55703a) {
            kVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(f<?> fVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            fVar.onComplete();
        } else if (terminate != ExceptionHelper.f55703a) {
            fVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(m<?> mVar) {
        Throwable terminate = terminate();
        if (terminate != null && terminate != ExceptionHelper.f55703a) {
            mVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(h00.a aVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            aVar.onComplete();
        } else if (terminate != ExceptionHelper.f55703a) {
            aVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(h00.c<?> cVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            cVar.onComplete();
        } else if (terminate != ExceptionHelper.f55703a) {
            cVar.onError(terminate);
        }
    }
}
