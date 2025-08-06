package rx.internal.operators;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.FuncN;
import rx.observers.SerializedSubscriber;
import rx.plugins.RxJavaHooks;

public final class OperatorWithLatestFromMany<T, R> implements Observable.OnSubscribe<R> {
    public final FuncN<R> combiner;
    public final Observable<T> main;
    public final Observable<?>[] others;
    public final Iterable<Observable<?>> othersIterable;

    public static final class WithLatestMainSubscriber<T, R> extends Subscriber<T> {
        public static final Object EMPTY = new Object();
        public final Subscriber<? super R> actual;
        public final FuncN<R> combiner;
        public final AtomicReferenceArray<Object> current;
        public boolean done;
        public final AtomicInteger ready;

        public WithLatestMainSubscriber(Subscriber<? super R> subscriber, FuncN<R> funcN, int i11) {
            this.actual = subscriber;
            this.combiner = funcN;
            AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(i11 + 1);
            for (int i12 = 0; i12 <= i11; i12++) {
                atomicReferenceArray.lazySet(i12, EMPTY);
            }
            this.current = atomicReferenceArray;
            this.ready = new AtomicInteger(i11);
            request(0);
        }

        public void innerComplete(int i11) {
            if (this.current.get(i11) == EMPTY) {
                onCompleted();
            }
        }

        public void innerError(int i11, Throwable th2) {
            onError(th2);
        }

        public void innerNext(int i11, Object obj) {
            if (this.current.getAndSet(i11, obj) == EMPTY) {
                this.ready.decrementAndGet();
            }
        }

        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                unsubscribe();
                this.actual.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                RxJavaHooks.onError(th2);
                return;
            }
            this.done = true;
            unsubscribe();
            this.actual.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.done) {
                if (this.ready.get() == 0) {
                    AtomicReferenceArray<Object> atomicReferenceArray = this.current;
                    int length = atomicReferenceArray.length();
                    atomicReferenceArray.lazySet(0, t11);
                    Object[] objArr = new Object[atomicReferenceArray.length()];
                    for (int i11 = 0; i11 < length; i11++) {
                        objArr[i11] = atomicReferenceArray.get(i11);
                    }
                    try {
                        this.actual.onNext(this.combiner.call(objArr));
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        onError(th2);
                    }
                } else {
                    request(1);
                }
            }
        }

        public void setProducer(Producer producer) {
            super.setProducer(producer);
            this.actual.setProducer(producer);
        }
    }

    public static final class WithLatestOtherSubscriber extends Subscriber<Object> {
        public final int index;
        public final WithLatestMainSubscriber<?, ?> parent;

        public WithLatestOtherSubscriber(WithLatestMainSubscriber<?, ?> withLatestMainSubscriber, int i11) {
            this.parent = withLatestMainSubscriber;
            this.index = i11;
        }

        public void onCompleted() {
            this.parent.innerComplete(this.index);
        }

        public void onError(Throwable th2) {
            this.parent.innerError(this.index, th2);
        }

        public void onNext(Object obj) {
            this.parent.innerNext(this.index, obj);
        }
    }

    public OperatorWithLatestFromMany(Observable<T> observable, Observable<?>[] observableArr, Iterable<Observable<?>> iterable, FuncN<R> funcN) {
        this.main = observable;
        this.others = observableArr;
        this.othersIterable = iterable;
        this.combiner = funcN;
    }

    public void call(Subscriber<? super R> subscriber) {
        int i11;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        Observable<?>[] observableArr = this.others;
        int i12 = 0;
        if (observableArr != null) {
            i11 = observableArr.length;
        } else {
            observableArr = new Observable[8];
            int i13 = 0;
            for (Observable<?> next : this.othersIterable) {
                if (i13 == observableArr.length) {
                    observableArr = (Observable[]) Arrays.copyOf(observableArr, (i13 >> 2) + i13);
                }
                observableArr[i13] = next;
                i13++;
            }
            i11 = i13;
        }
        WithLatestMainSubscriber withLatestMainSubscriber = new WithLatestMainSubscriber(subscriber, this.combiner, i11);
        serializedSubscriber.add(withLatestMainSubscriber);
        while (i12 < i11) {
            if (!serializedSubscriber.isUnsubscribed()) {
                int i14 = i12 + 1;
                WithLatestOtherSubscriber withLatestOtherSubscriber = new WithLatestOtherSubscriber(withLatestMainSubscriber, i14);
                withLatestMainSubscriber.add(withLatestOtherSubscriber);
                observableArr[i12].unsafeSubscribe(withLatestOtherSubscriber);
                i12 = i14;
            } else {
                return;
            }
        }
        this.main.unsafeSubscribe(withLatestMainSubscriber);
    }
}
