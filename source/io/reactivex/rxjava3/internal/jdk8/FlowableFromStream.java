package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import k00.a;
import k00.d;
import z20.c;

public final class FlowableFromStream<T> extends Flowable<T> {

    public static abstract class AbstractStreamSubscription<T> extends AtomicLong implements d<T> {
        private static final long serialVersionUID = -9082954702547571853L;
        public volatile boolean cancelled;
        public AutoCloseable closeable;
        public Iterator<T> iterator;
        public boolean once;

        public AbstractStreamSubscription(Iterator<T> it2, AutoCloseable autoCloseable) {
            this.iterator = it2;
            this.closeable = autoCloseable;
        }

        public void cancel() {
            this.cancelled = true;
            request(1);
        }

        public void clear() {
            this.iterator = null;
            AutoCloseable autoCloseable = this.closeable;
            this.closeable = null;
            if (autoCloseable != null) {
                FlowableFromStream.m(autoCloseable);
            }
        }

        public boolean isEmpty() {
            Iterator<T> it2 = this.iterator;
            if (it2 == null) {
                return true;
            }
            if (!this.once || it2.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        public boolean offer(T t11) {
            throw new UnsupportedOperationException();
        }

        public T poll() {
            Iterator<T> it2 = this.iterator;
            if (it2 == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it2.hasNext()) {
                clear();
                return null;
            }
            T next = this.iterator.next();
            Objects.requireNonNull(next, "The Stream's Iterator.next() returned a null value");
            return next;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11) && b.a(this, j11) == 0) {
                run(j11);
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            lazySet(Long.MAX_VALUE);
            return 1;
        }

        public abstract void run(long j11);

        public boolean offer(T t11, T t12) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class StreamConditionalSubscription<T> extends AbstractStreamSubscription<T> {
        private static final long serialVersionUID = -9082954702547571853L;
        public final a<? super T> downstream;

        public StreamConditionalSubscription(a<? super T> aVar, Iterator<T> it2, AutoCloseable autoCloseable) {
            super(it2, autoCloseable);
            this.downstream = aVar;
        }

        public void run(long j11) {
            Iterator<T> it2 = this.iterator;
            a<? super T> aVar = this.downstream;
            long j12 = 0;
            while (!this.cancelled) {
                try {
                    T next = it2.next();
                    Objects.requireNonNull(next, "The Stream's Iterator returned a null value");
                    if (aVar.tryOnNext(next)) {
                        j12++;
                    }
                    if (this.cancelled) {
                        continue;
                    } else {
                        try {
                            if (!it2.hasNext()) {
                                aVar.onComplete();
                                this.cancelled = true;
                            } else if (j12 != j11) {
                                continue;
                            } else {
                                j11 = get();
                                if (j12 != j11) {
                                    continue;
                                } else if (!compareAndSet(j11, 0)) {
                                    j11 = get();
                                } else {
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            io.reactivex.rxjava3.exceptions.a.b(th2);
                            aVar.onError(th2);
                            this.cancelled = true;
                        }
                    }
                } catch (Throwable th3) {
                    io.reactivex.rxjava3.exceptions.a.b(th3);
                    aVar.onError(th3);
                    this.cancelled = true;
                }
            }
            clear();
        }
    }

    public static final class StreamSubscription<T> extends AbstractStreamSubscription<T> {
        private static final long serialVersionUID = -9082954702547571853L;
        public final c<? super T> downstream;

        public StreamSubscription(c<? super T> cVar, Iterator<T> it2, AutoCloseable autoCloseable) {
            super(it2, autoCloseable);
            this.downstream = cVar;
        }

        public void run(long j11) {
            Iterator<T> it2 = this.iterator;
            c<? super T> cVar = this.downstream;
            long j12 = 0;
            while (!this.cancelled) {
                try {
                    T next = it2.next();
                    Objects.requireNonNull(next, "The Stream's Iterator returned a null value");
                    cVar.onNext(next);
                    if (this.cancelled) {
                        continue;
                    } else {
                        try {
                            if (!it2.hasNext()) {
                                cVar.onComplete();
                                this.cancelled = true;
                            } else {
                                j12++;
                                if (j12 != j11) {
                                    continue;
                                } else {
                                    j11 = get();
                                    if (j12 != j11) {
                                        continue;
                                    } else if (!compareAndSet(j11, 0)) {
                                        j11 = get();
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            io.reactivex.rxjava3.exceptions.a.b(th2);
                            cVar.onError(th2);
                            this.cancelled = true;
                        }
                    }
                } catch (Throwable th3) {
                    io.reactivex.rxjava3.exceptions.a.b(th3);
                    cVar.onError(th3);
                    this.cancelled = true;
                }
            }
            clear();
        }
    }

    public static void m(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            o00.a.n(th2);
        }
    }
}
