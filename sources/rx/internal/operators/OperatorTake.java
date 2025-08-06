package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public final class OperatorTake<T> implements Observable.Operator<T, T> {
    public final int limit;

    public OperatorTake(int i11) {
        if (i11 >= 0) {
            this.limit = i11;
            return;
        }
        throw new IllegalArgumentException("limit >= 0 required but it was " + i11);
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        AnonymousClass1 r02 = new Subscriber<T>() {
            public boolean completed;
            public int count;

            public void onCompleted() {
                if (!this.completed) {
                    this.completed = true;
                    subscriber.onCompleted();
                }
            }

            public void onError(Throwable th2) {
                if (!this.completed) {
                    this.completed = true;
                    try {
                        subscriber.onError(th2);
                    } finally {
                        unsubscribe();
                    }
                }
            }

            public void onNext(T t11) {
                if (!isUnsubscribed()) {
                    int i11 = this.count;
                    int i12 = i11 + 1;
                    this.count = i12;
                    int i13 = OperatorTake.this.limit;
                    if (i11 < i13) {
                        boolean z11 = i12 == i13;
                        subscriber.onNext(t11);
                        if (z11 && !this.completed) {
                            this.completed = true;
                            try {
                                subscriber.onCompleted();
                            } finally {
                                unsubscribe();
                            }
                        }
                    }
                }
            }

            public void setProducer(final Producer producer) {
                subscriber.setProducer(new Producer() {
                    public final AtomicLong requested = new AtomicLong(0);

                    public void request(long j11) {
                        long j12;
                        long min;
                        if (j11 > 0 && !AnonymousClass1.this.completed) {
                            do {
                                j12 = this.requested.get();
                                min = Math.min(j11, ((long) OperatorTake.this.limit) - j12);
                                if (min == 0) {
                                    return;
                                }
                            } while (!this.requested.compareAndSet(j12, j12 + min));
                            producer.request(min);
                        }
                    }
                });
            }
        };
        if (this.limit == 0) {
            subscriber.onCompleted();
            r02.unsubscribe();
        }
        subscriber.add(r02);
        return r02;
    }
}
