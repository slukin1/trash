package rx.internal.operators;

import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.exceptions.AssemblyStackTraceException;

public final class OnSubscribeOnAssemblyCompletable<T> implements Completable.OnSubscribe {
    public static volatile boolean fullStackTrace;
    public final Completable.OnSubscribe source;
    public final String stacktrace = OnSubscribeOnAssembly.createStacktrace();

    public static final class OnAssemblyCompletableSubscriber implements CompletableSubscriber {
        public final CompletableSubscriber actual;
        public final String stacktrace;

        public OnAssemblyCompletableSubscriber(CompletableSubscriber completableSubscriber, String str) {
            this.actual = completableSubscriber;
            this.stacktrace = str;
        }

        public void onCompleted() {
            this.actual.onCompleted();
        }

        public void onError(Throwable th2) {
            new AssemblyStackTraceException(this.stacktrace).attachTo(th2);
            this.actual.onError(th2);
        }

        public void onSubscribe(Subscription subscription) {
            this.actual.onSubscribe(subscription);
        }
    }

    public OnSubscribeOnAssemblyCompletable(Completable.OnSubscribe onSubscribe) {
        this.source = onSubscribe;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        this.source.call(new OnAssemblyCompletableSubscriber(completableSubscriber, this.stacktrace));
    }
}
