package rx.observers;

import rx.CompletableSubscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.plugins.RxJavaHooks;

public final class SafeCompletableSubscriber implements CompletableSubscriber, Subscription {
    public final CompletableSubscriber actual;
    public boolean done;

    /* renamed from: s  reason: collision with root package name */
    public Subscription f47814s;

    public SafeCompletableSubscriber(CompletableSubscriber completableSubscriber) {
        this.actual = completableSubscriber;
    }

    public boolean isUnsubscribed() {
        return this.done || this.f47814s.isUnsubscribed();
    }

    public void onCompleted() {
        if (!this.done) {
            this.done = true;
            try {
                this.actual.onCompleted();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                throw new OnCompletedFailedException(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        RxJavaHooks.onError(th2);
        if (!this.done) {
            this.done = true;
            try {
                this.actual.onError(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                throw new OnErrorFailedException(new CompositeException(th2, th3));
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        this.f47814s = subscription;
        try {
            this.actual.onSubscribe(this);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            subscription.unsubscribe();
            onError(th2);
        }
    }

    public void unsubscribe() {
        this.f47814s.unsubscribe();
    }
}
