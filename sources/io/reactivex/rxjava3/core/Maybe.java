package io.reactivex.rxjava3.core;

import h00.f;
import h00.g;
import java.util.Objects;
import o00.a;

public abstract class Maybe<T> implements g<T> {
    public final void a(f<? super T> fVar) {
        Objects.requireNonNull(fVar, "observer is null");
        f<? super Object> r11 = a.r(this, fVar);
        Objects.requireNonNull(r11, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(r11);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void b(f<? super T> fVar);
}
