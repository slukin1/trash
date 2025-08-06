package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.plugins.RxJavaHooks;

public class OperatorOnBackpressureDrop<T> implements Observable.Operator<T, T> {
    public final Action1<? super T> onDrop;

    public static final class Holder {
        public static final OperatorOnBackpressureDrop<Object> INSTANCE = new OperatorOnBackpressureDrop<>();
    }

    public OperatorOnBackpressureDrop() {
        this((Action1) null);
    }

    public static <T> OperatorOnBackpressureDrop<T> instance() {
        return Holder.INSTANCE;
    }

    public OperatorOnBackpressureDrop(Action1<? super T> action1) {
        this.onDrop = action1;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final AtomicLong atomicLong = new AtomicLong();
        subscriber.setProducer(new Producer() {
            public void request(long j11) {
                BackpressureUtils.getAndAddRequest(atomicLong, j11);
            }
        });
        return new Subscriber<T>(subscriber) {
            public boolean done;

            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    subscriber.onCompleted();
                }
            }

            public void onError(Throwable th2) {
                if (!this.done) {
                    this.done = true;
                    subscriber.onError(th2);
                    return;
                }
                RxJavaHooks.onError(th2);
            }

            public void onNext(T t11) {
                if (!this.done) {
                    if (atomicLong.get() > 0) {
                        subscriber.onNext(t11);
                        atomicLong.decrementAndGet();
                        return;
                    }
                    Action1<? super T> action1 = OperatorOnBackpressureDrop.this.onDrop;
                    if (action1 != null) {
                        try {
                            action1.call(t11);
                        } catch (Throwable th2) {
                            Exceptions.throwOrReport(th2, (Observer<?>) this, (Object) t11);
                        }
                    }
                }
            }

            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
    }
}
