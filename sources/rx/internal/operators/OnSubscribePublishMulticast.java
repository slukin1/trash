package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements Observable.OnSubscribe<T>, Observer<T>, Subscription {
    public static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
    public static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
    private static final long serialVersionUID = -3741892510772238743L;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final ParentSubscriber<T> parent;
    public final int prefetch;
    public volatile Producer producer;
    public final Queue<T> queue;
    public volatile PublishProducer<T>[] subscribers;

    public static final class ParentSubscriber<T> extends Subscriber<T> {
        public final OnSubscribePublishMulticast<T> state;

        public ParentSubscriber(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.state = onSubscribePublishMulticast;
        }

        public void onCompleted() {
            this.state.onCompleted();
        }

        public void onError(Throwable th2) {
            this.state.onError(th2);
        }

        public void onNext(T t11) {
            this.state.onNext(t11);
        }

        public void setProducer(Producer producer) {
            this.state.setProducer(producer);
        }
    }

    public static final class PublishProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = 960704844171597367L;
        public final Subscriber<? super T> actual;
        public final AtomicBoolean once = new AtomicBoolean();
        public final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(Subscriber<? super T> subscriber, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.actual = subscriber;
            this.parent = onSubscribePublishMulticast;
        }

        public boolean isUnsubscribed() {
            return this.once.get();
        }

        public void request(long j11) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i11 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j11);
            } else if (i11 != 0) {
                BackpressureUtils.getAndAddRequest(this, j11);
                this.parent.drain();
            }
        }

        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }

    public OnSubscribePublishMulticast(int i11, boolean z11) {
        if (i11 > 0) {
            this.prefetch = i11;
            this.delayError = z11;
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(i11);
            } else {
                this.queue = new SpscAtomicArrayQueue(i11);
            }
            this.subscribers = EMPTY;
            this.parent = new ParentSubscriber<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i11);
    }

    public boolean add(PublishProducer<T> publishProducer) {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        PublishProducer<?>[] publishProducerArr2 = TERMINATED;
        if (publishProducerArr == publishProducerArr2) {
            return false;
        }
        synchronized (this) {
            PublishProducer<T>[] publishProducerArr3 = this.subscribers;
            if (publishProducerArr3 == publishProducerArr2) {
                return false;
            }
            int length = publishProducerArr3.length;
            PublishProducer<T>[] publishProducerArr4 = new PublishProducer[(length + 1)];
            System.arraycopy(publishProducerArr3, 0, publishProducerArr4, 0, length);
            publishProducerArr4[length] = publishProducer;
            this.subscribers = publishProducerArr4;
            return true;
        }
    }

    public boolean checkTerminated(boolean z11, boolean z12) {
        int i11 = 0;
        if (z11) {
            if (!this.delayError) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    PublishProducer[] terminate = terminate();
                    int length = terminate.length;
                    while (i11 < length) {
                        terminate[i11].actual.onError(th2);
                        i11++;
                    }
                    return true;
                } else if (z12) {
                    PublishProducer[] terminate2 = terminate();
                    int length2 = terminate2.length;
                    while (i11 < length2) {
                        terminate2[i11].actual.onCompleted();
                        i11++;
                    }
                    return true;
                }
            } else if (z12) {
                PublishProducer[] terminate3 = terminate();
                Throwable th3 = this.error;
                if (th3 != null) {
                    int length3 = terminate3.length;
                    while (i11 < length3) {
                        terminate3[i11].actual.onError(th3);
                        i11++;
                    }
                } else {
                    int length4 = terminate3.length;
                    while (i11 < length4) {
                        terminate3[i11].actual.onCompleted();
                        i11++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void drain() {
        int i11;
        if (getAndIncrement() == 0) {
            Queue<T> queue2 = this.queue;
            int i12 = 0;
            do {
                long j11 = Long.MAX_VALUE;
                PublishProducer<T>[] publishProducerArr = this.subscribers;
                int length = publishProducerArr.length;
                for (PublishProducer<T> publishProducer : publishProducerArr) {
                    j11 = Math.min(j11, publishProducer.get());
                }
                if (length != 0) {
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        }
                        boolean z11 = this.done;
                        T poll = queue2.poll();
                        boolean z12 = poll == null;
                        if (!checkTerminated(z11, z12)) {
                            if (z12) {
                                break;
                            }
                            for (PublishProducer<T> publishProducer2 : publishProducerArr) {
                                publishProducer2.actual.onNext(poll);
                            }
                            j12++;
                        } else {
                            return;
                        }
                    }
                    if (i11 == 0 && checkTerminated(this.done, queue2.isEmpty())) {
                        return;
                    }
                    if (j12 != 0) {
                        Producer producer2 = this.producer;
                        if (producer2 != null) {
                            producer2.request(j12);
                        }
                        for (PublishProducer<T> produced : publishProducerArr) {
                            BackpressureUtils.produced(produced, j12);
                        }
                    }
                }
                i12 = addAndGet(-i12);
            } while (i12 != 0);
        }
    }

    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    public void onCompleted() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        if (!this.queue.offer(t11)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(rx.internal.operators.OnSubscribePublishMulticast.PublishProducer<T> r7) {
        /*
            r6 = this;
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<T>[] r0 = r6.subscribers
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r1 = TERMINATED
            if (r0 == r1) goto L_0x0044
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r2 = EMPTY
            if (r0 != r2) goto L_0x000b
            goto L_0x0044
        L_0x000b:
            monitor-enter(r6)
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<T>[] r0 = r6.subscribers     // Catch:{ all -> 0x0041 }
            if (r0 == r1) goto L_0x003f
            if (r0 != r2) goto L_0x0013
            goto L_0x003f
        L_0x0013:
            r1 = -1
            int r2 = r0.length     // Catch:{ all -> 0x0041 }
            r3 = 0
            r4 = r3
        L_0x0017:
            if (r4 >= r2) goto L_0x0022
            r5 = r0[r4]     // Catch:{ all -> 0x0041 }
            if (r5 != r7) goto L_0x001f
            r1 = r4
            goto L_0x0022
        L_0x001f:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0022:
            if (r1 >= 0) goto L_0x0026
            monitor-exit(r6)     // Catch:{ all -> 0x0041 }
            return
        L_0x0026:
            r7 = 1
            if (r2 != r7) goto L_0x002c
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r7 = EMPTY     // Catch:{ all -> 0x0041 }
            goto L_0x003b
        L_0x002c:
            int r4 = r2 + -1
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer[] r4 = new rx.internal.operators.OnSubscribePublishMulticast.PublishProducer[r4]     // Catch:{ all -> 0x0041 }
            java.lang.System.arraycopy(r0, r3, r4, r3, r1)     // Catch:{ all -> 0x0041 }
            int r3 = r1 + 1
            int r2 = r2 - r1
            int r2 = r2 - r7
            java.lang.System.arraycopy(r0, r3, r4, r1, r2)     // Catch:{ all -> 0x0041 }
            r7 = r4
        L_0x003b:
            r6.subscribers = r7     // Catch:{ all -> 0x0041 }
            monitor-exit(r6)     // Catch:{ all -> 0x0041 }
            return
        L_0x003f:
            monitor-exit(r6)     // Catch:{ all -> 0x0041 }
            return
        L_0x0041:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0041 }
            throw r7
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribePublishMulticast.remove(rx.internal.operators.OnSubscribePublishMulticast$PublishProducer):void");
    }

    public void setProducer(Producer producer2) {
        this.producer = producer2;
        producer2.request((long) this.prefetch);
    }

    public Subscriber<T> subscriber() {
        return this.parent;
    }

    public PublishProducer<T>[] terminate() {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        PublishProducer<?>[] publishProducerArr2 = TERMINATED;
        if (publishProducerArr != publishProducerArr2) {
            synchronized (this) {
                publishProducerArr = this.subscribers;
                if (publishProducerArr != publishProducerArr2) {
                    this.subscribers = publishProducerArr2;
                }
            }
        }
        return publishProducerArr;
    }

    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    public void call(Subscriber<? super T> subscriber) {
        PublishProducer publishProducer = new PublishProducer(subscriber, this);
        subscriber.add(publishProducer);
        subscriber.setProducer(publishProducer);
        if (!add(publishProducer)) {
            Throwable th2 = this.error;
            if (th2 != null) {
                subscriber.onError(th2);
            } else {
                subscriber.onCompleted();
            }
        } else if (publishProducer.isUnsubscribed()) {
            remove(publishProducer);
        } else {
            drain();
        }
    }
}
