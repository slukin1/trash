package rx.internal.operators;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.FuncN;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class SingleOperatorZip {
    private SingleOperatorZip() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> Single<R> zip(final Single<? extends T>[] singleArr, final FuncN<? extends R> funcN) {
        return Single.create(new Single.OnSubscribe<R>() {
            public void call(SingleSubscriber<? super R> singleSubscriber) {
                if (singleArr.length == 0) {
                    singleSubscriber.onError(new NoSuchElementException("Can't zip 0 Singles."));
                    return;
                }
                AtomicInteger atomicInteger = new AtomicInteger(singleArr.length);
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                Object[] objArr = new Object[singleArr.length];
                CompositeSubscription compositeSubscription = new CompositeSubscription();
                singleSubscriber.add(compositeSubscription);
                int i11 = 0;
                while (i11 < singleArr.length && !compositeSubscription.isUnsubscribed() && !atomicBoolean.get()) {
                    final Object[] objArr2 = objArr;
                    final int i12 = i11;
                    final AtomicInteger atomicInteger2 = atomicInteger;
                    final SingleSubscriber<? super R> singleSubscriber2 = singleSubscriber;
                    final AtomicBoolean atomicBoolean2 = atomicBoolean;
                    AnonymousClass1 r22 = new SingleSubscriber<T>() {
                        public void onError(Throwable th2) {
                            if (atomicBoolean2.compareAndSet(false, true)) {
                                singleSubscriber2.onError(th2);
                            } else {
                                RxJavaHooks.onError(th2);
                            }
                        }

                        public void onSuccess(T t11) {
                            objArr2[i12] = t11;
                            if (atomicInteger2.decrementAndGet() == 0) {
                                try {
                                    singleSubscriber2.onSuccess(funcN.call(objArr2));
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    onError(th2);
                                }
                            }
                        }
                    };
                    compositeSubscription.add(r22);
                    if (!compositeSubscription.isUnsubscribed() && !atomicBoolean.get()) {
                        singleArr[i11].subscribe(r22);
                        i11++;
                    } else {
                        return;
                    }
                }
            }
        });
    }
}
