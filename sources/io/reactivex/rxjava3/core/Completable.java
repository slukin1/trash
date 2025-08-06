package io.reactivex.rxjava3.core;

import h00.a;
import h00.b;
import java.util.Objects;

public abstract class Completable implements b {
    public static NullPointerException c(Throwable th2) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th2);
        return nullPointerException;
    }

    public final void a(a aVar) {
        Objects.requireNonNull(aVar, "observer is null");
        try {
            a q11 = o00.a.q(this, aVar);
            Objects.requireNonNull(q11, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(q11);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            o00.a.n(th2);
            throw c(th2);
        }
    }

    public abstract void b(a aVar);
}
