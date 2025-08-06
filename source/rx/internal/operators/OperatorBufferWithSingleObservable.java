package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;

public final class OperatorBufferWithSingleObservable<T, TClosing> implements Observable.Operator<List<T>, T> {
    public final Func0<? extends Observable<? extends TClosing>> bufferClosingSelector;
    public final int initialCapacity;

    public final class BufferingSubscriber extends Subscriber<T> {
        public final Subscriber<? super List<T>> child;
        public List<T> chunk;
        public boolean done;

        public BufferingSubscriber(Subscriber<? super List<T>> subscriber) {
            this.child = subscriber;
            this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
        }

        public void emit() {
            synchronized (this) {
                if (!this.done) {
                    List<T> list = this.chunk;
                    this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
                    try {
                        this.child.onNext(list);
                    } catch (Throwable th2) {
                        unsubscribe();
                        synchronized (this) {
                            if (!this.done) {
                                this.done = true;
                                Exceptions.throwOrReport(th2, (Observer<?>) this.child);
                            }
                        }
                    }
                }
            }
        }

        public void onCompleted() {
            try {
                synchronized (this) {
                    if (!this.done) {
                        this.done = true;
                        List<T> list = this.chunk;
                        this.chunk = null;
                        this.child.onNext(list);
                        this.child.onCompleted();
                        unsubscribe();
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwOrReport(th2, (Observer<?>) this.child);
            }
        }

        public void onError(Throwable th2) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    this.chunk = null;
                    this.child.onError(th2);
                    unsubscribe();
                }
            }
        }

        public void onNext(T t11) {
            synchronized (this) {
                if (!this.done) {
                    this.chunk.add(t11);
                }
            }
        }
    }

    public OperatorBufferWithSingleObservable(Func0<? extends Observable<? extends TClosing>> func0, int i11) {
        this.bufferClosingSelector = func0;
        this.initialCapacity = i11;
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        try {
            Observable observable = (Observable) this.bufferClosingSelector.call();
            final BufferingSubscriber bufferingSubscriber = new BufferingSubscriber(new SerializedSubscriber(subscriber));
            AnonymousClass2 r22 = new Subscriber<TClosing>() {
                public void onCompleted() {
                    bufferingSubscriber.onCompleted();
                }

                public void onError(Throwable th2) {
                    bufferingSubscriber.onError(th2);
                }

                public void onNext(TClosing tclosing) {
                    bufferingSubscriber.emit();
                }
            };
            subscriber.add(r22);
            subscriber.add(bufferingSubscriber);
            observable.unsafeSubscribe(r22);
            return bufferingSubscriber;
        } catch (Throwable th2) {
            Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
            return Subscribers.empty();
        }
    }

    public OperatorBufferWithSingleObservable(final Observable<? extends TClosing> observable, int i11) {
        this.bufferClosingSelector = new Func0<Observable<? extends TClosing>>() {
            public Observable<? extends TClosing> call() {
                return observable;
            }
        };
        this.initialCapacity = i11;
    }
}
