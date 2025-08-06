package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.internal.producers.ProducerArbiter;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

class OperatorTimeoutBase<T> implements Observable.Operator<T, T> {
    public final FirstTimeoutStub<T> firstTimeoutStub;
    public final Observable<? extends T> other;
    public final Scheduler scheduler;
    public final TimeoutStub<T> timeoutStub;

    public interface FirstTimeoutStub<T> extends Func3<TimeoutSubscriber<T>, Long, Scheduler.Worker, Subscription> {
    }

    public interface TimeoutStub<T> extends Func4<TimeoutSubscriber<T>, Long, T, Scheduler.Worker, Subscription> {
    }

    public static final class TimeoutSubscriber<T> extends Subscriber<T> {
        public long actual;
        public final ProducerArbiter arbiter = new ProducerArbiter();
        public final Scheduler.Worker inner;
        public final Observable<? extends T> other;
        public final SerialSubscription serial;
        public final SerializedSubscriber<T> serializedSubscriber;
        public boolean terminated;
        public final TimeoutStub<T> timeoutStub;

        public TimeoutSubscriber(SerializedSubscriber<T> serializedSubscriber2, TimeoutStub<T> timeoutStub2, SerialSubscription serialSubscription, Observable<? extends T> observable, Scheduler.Worker worker) {
            this.serializedSubscriber = serializedSubscriber2;
            this.timeoutStub = timeoutStub2;
            this.serial = serialSubscription;
            this.other = observable;
            this.inner = worker;
        }

        public void onCompleted() {
            boolean z11;
            synchronized (this) {
                z11 = true;
                if (!this.terminated) {
                    this.terminated = true;
                } else {
                    z11 = false;
                }
            }
            if (z11) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            boolean z11;
            synchronized (this) {
                z11 = true;
                if (!this.terminated) {
                    this.terminated = true;
                } else {
                    z11 = false;
                }
            }
            if (z11) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onError(th2);
            }
        }

        public void onNext(T t11) {
            boolean z11;
            long j11;
            synchronized (this) {
                if (!this.terminated) {
                    j11 = this.actual + 1;
                    this.actual = j11;
                    z11 = true;
                } else {
                    j11 = this.actual;
                    z11 = false;
                }
            }
            if (z11) {
                this.serializedSubscriber.onNext(t11);
                this.serial.set((Subscription) this.timeoutStub.call(this, Long.valueOf(j11), t11, this.inner));
            }
        }

        public void onTimeout(long j11) {
            boolean z11;
            synchronized (this) {
                z11 = true;
                if (j11 != this.actual || this.terminated) {
                    z11 = false;
                } else {
                    this.terminated = true;
                }
            }
            if (!z11) {
                return;
            }
            if (this.other == null) {
                this.serializedSubscriber.onError(new TimeoutException());
                return;
            }
            AnonymousClass1 r32 = new Subscriber<T>() {
                public void onCompleted() {
                    TimeoutSubscriber.this.serializedSubscriber.onCompleted();
                }

                public void onError(Throwable th2) {
                    TimeoutSubscriber.this.serializedSubscriber.onError(th2);
                }

                public void onNext(T t11) {
                    TimeoutSubscriber.this.serializedSubscriber.onNext(t11);
                }

                public void setProducer(Producer producer) {
                    TimeoutSubscriber.this.arbiter.setProducer(producer);
                }
            };
            this.other.unsafeSubscribe(r32);
            this.serial.set(r32);
        }

        public void setProducer(Producer producer) {
            this.arbiter.setProducer(producer);
        }
    }

    public OperatorTimeoutBase(FirstTimeoutStub<T> firstTimeoutStub2, TimeoutStub<T> timeoutStub2, Observable<? extends T> observable, Scheduler scheduler2) {
        this.firstTimeoutStub = firstTimeoutStub2;
        this.timeoutStub = timeoutStub2;
        this.other = observable;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(serialSubscription);
        TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(serializedSubscriber, this.timeoutStub, serialSubscription, this.other, createWorker);
        serializedSubscriber.add(timeoutSubscriber);
        serializedSubscriber.setProducer(timeoutSubscriber.arbiter);
        serialSubscription.set((Subscription) this.firstTimeoutStub.call(timeoutSubscriber, 0L, createWorker));
        return timeoutSubscriber;
    }
}
