package rx.subjects;

import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedObserver;

public class SerializedSubject<T, R> extends Subject<T, R> {
    private final Subject<T, R> actual;
    private final SerializedObserver<T> observer;

    public SerializedSubject(final Subject<T, R> subject) {
        super(new Observable.OnSubscribe<R>() {
            public void call(Subscriber<? super R> subscriber) {
                Subject.this.unsafeSubscribe(subscriber);
            }
        });
        this.actual = subject;
        this.observer = new SerializedObserver<>(subject);
    }

    public boolean hasObservers() {
        return this.actual.hasObservers();
    }

    public void onCompleted() {
        this.observer.onCompleted();
    }

    public void onError(Throwable th2) {
        this.observer.onError(th2);
    }

    public void onNext(T t11) {
        this.observer.onNext(t11);
    }
}
