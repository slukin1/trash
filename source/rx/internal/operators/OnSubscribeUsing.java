package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observers.Subscribers;

public final class OnSubscribeUsing<T, Resource> implements Observable.OnSubscribe<T> {
    private final Action1<? super Resource> dispose;
    private final boolean disposeEagerly;
    private final Func1<? super Resource, ? extends Observable<? extends T>> observableFactory;
    private final Func0<Resource> resourceFactory;

    public static final class DisposeAction<Resource> extends AtomicBoolean implements Action0, Subscription {
        private static final long serialVersionUID = 4262875056400218316L;
        private Action1<? super Resource> dispose;
        private Resource resource;

        public DisposeAction(Action1<? super Resource> action1, Resource resource2) {
            this.dispose = action1;
            this.resource = resource2;
            lazySet(false);
        }

        public void call() {
            if (compareAndSet(false, true)) {
                try {
                    this.dispose.call(this.resource);
                } finally {
                    this.resource = null;
                    this.dispose = null;
                }
            }
        }

        public boolean isUnsubscribed() {
            return get();
        }

        public void unsubscribe() {
            call();
        }
    }

    public OnSubscribeUsing(Func0<Resource> func0, Func1<? super Resource, ? extends Observable<? extends T>> func1, Action1<? super Resource> action1, boolean z11) {
        this.resourceFactory = func0;
        this.observableFactory = func1;
        this.dispose = action1;
        this.disposeEagerly = z11;
    }

    private Throwable dispose(Action0 action0) {
        try {
            action0.call();
            return null;
        } catch (Throwable th2) {
            return th2;
        }
    }

    public void call(Subscriber<? super T> subscriber) {
        DisposeAction disposeAction;
        Observable observable;
        try {
            Resource call = this.resourceFactory.call();
            disposeAction = new DisposeAction(this.dispose, call);
            subscriber.add(disposeAction);
            try {
                Observable observable2 = (Observable) this.observableFactory.call(call);
                if (this.disposeEagerly) {
                    observable = observable2.doOnTerminate(disposeAction);
                } else {
                    observable = observable2.doAfterTerminate(disposeAction);
                }
                observable.unsafeSubscribe(Subscribers.wrap(subscriber));
            } catch (Throwable th2) {
                Throwable dispose2 = dispose(disposeAction);
                Exceptions.throwIfFatal(th2);
                Exceptions.throwIfFatal(dispose2);
                if (dispose2 != null) {
                    subscriber.onError(new CompositeException(th2, dispose2));
                    return;
                }
                subscriber.onError(th2);
            }
        } catch (Throwable th3) {
            Exceptions.throwOrReport(th3, (Observer<?>) subscriber);
        }
    }
}
