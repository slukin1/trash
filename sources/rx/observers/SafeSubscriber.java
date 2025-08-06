package rx.observers;

import java.util.Arrays;
import java.util.Collection;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;
import rx.plugins.RxJavaHooks;
import rx.plugins.RxJavaPlugins;

public class SafeSubscriber<T> extends Subscriber<T> {
    private final Subscriber<? super T> actual;
    public boolean done;

    public SafeSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber);
        this.actual = subscriber;
    }

    public void _onError(Throwable th2) {
        RxJavaPlugins.getInstance().getErrorHandler().handleError(th2);
        try {
            this.actual.onError(th2);
            try {
                unsubscribe();
            } catch (Throwable th3) {
                RxJavaHooks.onError(th3);
                throw new OnErrorFailedException(th3);
            }
        } catch (OnErrorNotImplementedException e11) {
            unsubscribe();
            throw e11;
        } catch (Throwable th4) {
            RxJavaHooks.onError(th4);
            throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th2, th4})));
        }
    }

    public Subscriber<? super T> getActual() {
        return this.actual;
    }

    public void onCompleted() {
        if (!this.done) {
            this.done = true;
            try {
                this.actual.onCompleted();
                try {
                    unsubscribe();
                } catch (Throwable th2) {
                    RxJavaHooks.onError(th2);
                    throw new UnsubscribeFailedException(th2.getMessage(), th2);
                }
            } catch (Throwable th3) {
                try {
                    unsubscribe();
                    throw th3;
                } catch (Throwable th4) {
                    RxJavaHooks.onError(th4);
                    throw new UnsubscribeFailedException(th4.getMessage(), th4);
                }
            }
        }
    }

    public void onError(Throwable th2) {
        Exceptions.throwIfFatal(th2);
        if (!this.done) {
            this.done = true;
            _onError(th2);
        }
    }

    public void onNext(T t11) {
        try {
            if (!this.done) {
                this.actual.onNext(t11);
            }
        } catch (Throwable th2) {
            Exceptions.throwOrReport(th2, (Observer<?>) this);
        }
    }
}
