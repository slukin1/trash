package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class OperatorOnErrorResumeNextViaFunction<T> implements Observable.Operator<T, T> {
    public final Func1<? super Throwable, ? extends Observable<? extends T>> resumeFunction;

    public OperatorOnErrorResumeNextViaFunction(Func1<? super Throwable, ? extends Observable<? extends T>> func1) {
        this.resumeFunction = func1;
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withException(final Observable<? extends T> observable) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() {
            public Observable<? extends T> call(Throwable th2) {
                if (th2 instanceof Exception) {
                    return observable;
                }
                return Observable.error(th2);
            }
        });
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withOther(final Observable<? extends T> observable) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() {
            public Observable<? extends T> call(Throwable th2) {
                return observable;
            }
        });
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withSingle(final Func1<? super Throwable, ? extends T> func1) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() {
            public Observable<? extends T> call(Throwable th2) {
                return Observable.just(func1.call(th2));
            }
        });
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final ProducerArbiter producerArbiter = new ProducerArbiter();
        final SerialSubscription serialSubscription = new SerialSubscription();
        AnonymousClass4 r22 = new Subscriber<T>() {
            private boolean done;
            public long produced;

            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    subscriber.onCompleted();
                }
            }

            public void onError(Throwable th2) {
                if (this.done) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaHooks.onError(th2);
                    return;
                }
                this.done = true;
                try {
                    unsubscribe();
                    AnonymousClass1 r02 = new Subscriber<T>() {
                        public void onCompleted() {
                            subscriber.onCompleted();
                        }

                        public void onError(Throwable th2) {
                            subscriber.onError(th2);
                        }

                        public void onNext(T t11) {
                            subscriber.onNext(t11);
                        }

                        public void setProducer(Producer producer) {
                            producerArbiter.setProducer(producer);
                        }
                    };
                    serialSubscription.set(r02);
                    long j11 = this.produced;
                    if (j11 != 0) {
                        producerArbiter.produced(j11);
                    }
                    ((Observable) OperatorOnErrorResumeNextViaFunction.this.resumeFunction.call(th2)).unsafeSubscribe(r02);
                } catch (Throwable th3) {
                    Exceptions.throwOrReport(th3, (Observer<?>) subscriber);
                }
            }

            public void onNext(T t11) {
                if (!this.done) {
                    this.produced++;
                    subscriber.onNext(t11);
                }
            }

            public void setProducer(Producer producer) {
                producerArbiter.setProducer(producer);
            }
        };
        serialSubscription.set(r22);
        subscriber.add(serialSubscription);
        subscriber.setProducer(producerArbiter);
        return r22;
    }
}
