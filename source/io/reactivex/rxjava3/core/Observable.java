package io.reactivex.rxjava3.core;

import h00.j;
import h00.k;
import java.util.Objects;
import o00.a;

public abstract class Observable<T> implements j<T> {
    public static int a() {
        return Flowable.b();
    }

    public abstract void b(k<? super T> kVar);

    public final void subscribe(k<? super T> kVar) {
        Objects.requireNonNull(kVar, "observer is null");
        try {
            k<? super Object> s11 = a.s(this, kVar);
            Objects.requireNonNull(s11, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(s11);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            a.n(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }
}
