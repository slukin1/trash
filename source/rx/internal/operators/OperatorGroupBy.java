package rx.internal.operators;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.UtilityFunctions;
import rx.observables.GroupedObservable;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.Subscriptions;

public final class OperatorGroupBy<T, K, V> implements Observable.Operator<GroupedObservable<K, V>, T> {
    public final int bufferSize;
    public final boolean delayError;
    public final Func1<? super T, ? extends K> keySelector;
    public final Func1<Action1<K>, Map<K, Object>> mapFactory;
    public final Func1<? super T, ? extends V> valueSelector;

    public static final class GroupByProducer implements Producer {
        public final GroupBySubscriber<?, ?, ?> parent;

        public GroupByProducer(GroupBySubscriber<?, ?, ?> groupBySubscriber) {
            this.parent = groupBySubscriber;
        }

        public void request(long j11) {
            this.parent.requestMore(j11);
        }
    }

    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        public final State<T, K> state;

        public GroupedUnicast(K k11, State<T, K> state2) {
            super(k11, state2);
            this.state = state2;
        }

        public static <T, K> GroupedUnicast<K, T> createWith(K k11, int i11, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z11) {
            return new GroupedUnicast<>(k11, new State(i11, groupBySubscriber, k11, z11));
        }

        public void onComplete() {
            this.state.onComplete();
        }

        public void onError(Throwable th2) {
            this.state.onError(th2);
        }

        public void onNext(T t11) {
            this.state.onNext(t11);
        }
    }

    public static final class State<T, K> extends AtomicInteger implements Producer, Subscription, Observable.OnSubscribe<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        public final AtomicReference<Subscriber<? super T>> actual;
        public final AtomicBoolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final K key;
        public final AtomicBoolean once;
        public final GroupBySubscriber<?, K, T> parent;
        public final Queue<Object> queue = new ConcurrentLinkedQueue();
        public final AtomicLong requested;

        public State(int i11, GroupBySubscriber<?, K, T> groupBySubscriber, K k11, boolean z11) {
            this.parent = groupBySubscriber;
            this.key = k11;
            this.delayError = z11;
            this.cancelled = new AtomicBoolean();
            this.actual = new AtomicReference<>();
            this.once = new AtomicBoolean();
            this.requested = new AtomicLong();
        }

        public boolean checkTerminated(boolean z11, boolean z12, Subscriber<? super T> subscriber, boolean z13) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!z13) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        subscriber.onError(th2);
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        subscriber.onCompleted();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        subscriber.onError(th3);
                    } else {
                        subscriber.onCompleted();
                    }
                    return true;
                }
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Queue<Object> queue2 = this.queue;
                boolean z11 = this.delayError;
                Subscriber subscriber = this.actual.get();
                int i11 = 1;
                while (true) {
                    if (subscriber != null) {
                        if (!checkTerminated(this.done, queue2.isEmpty(), subscriber, z11)) {
                            long j11 = this.requested.get();
                            long j12 = 0;
                            while (j12 != j11) {
                                boolean z12 = this.done;
                                Object poll = queue2.poll();
                                boolean z13 = poll == null;
                                if (!checkTerminated(z12, z13, subscriber, z11)) {
                                    if (z13) {
                                        break;
                                    }
                                    subscriber.onNext(NotificationLite.getValue(poll));
                                    j12++;
                                } else {
                                    return;
                                }
                            }
                            if (j12 != 0) {
                                if (j11 != Long.MAX_VALUE) {
                                    BackpressureUtils.produced(this.requested, j12);
                                }
                                this.parent.f53411s.request(j12);
                            }
                        } else {
                            return;
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 != 0) {
                        if (subscriber == null) {
                            subscriber = this.actual.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean isUnsubscribed() {
            return this.cancelled.get();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            drain();
        }

        public void onNext(T t11) {
            if (t11 == null) {
                this.error = new NullPointerException();
                this.done = true;
            } else {
                this.queue.offer(NotificationLite.next(t11));
            }
            drain();
        }

        public void request(long j11) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i11 < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j11);
            } else if (i11 != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j11);
                drain();
            }
        }

        public void unsubscribe() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.parent.cancel(this.key);
            }
        }

        public void call(Subscriber<? super T> subscriber) {
            if (this.once.compareAndSet(false, true)) {
                subscriber.add(this);
                subscriber.setProducer(this);
                this.actual.lazySet(subscriber);
                drain();
                return;
            }
            subscriber.onError(new IllegalStateException("Only one Subscriber allowed!"));
        }
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1) {
        this(func1, UtilityFunctions.identity(), RxRingBuffer.SIZE, false, (Func1) null);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(func1, func12, RxRingBuffer.SIZE, false, (Func1) null);
    }

    public Subscriber<? super T> call(Subscriber<? super GroupedObservable<K, V>> subscriber) {
        try {
            final GroupBySubscriber groupBySubscriber = new GroupBySubscriber(subscriber, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, this.mapFactory);
            subscriber.add(Subscriptions.create(new Action0() {
                public void call() {
                    groupBySubscriber.cancel();
                }
            }));
            subscriber.setProducer(groupBySubscriber.producer);
            return groupBySubscriber;
        } catch (Throwable th2) {
            Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
            Subscriber<? super T> empty = Subscribers.empty();
            empty.unsubscribe();
            return empty;
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends Subscriber<T> {
        public static final Object NULL_KEY = new Object();
        public final Subscriber<? super GroupedObservable<K, V>> actual;
        public final int bufferSize;
        public final AtomicBoolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final Queue<K> evictedKeys;
        public final AtomicInteger groupCount;
        public final Map<Object, GroupedUnicast<K, V>> groups;
        public final Func1<? super T, ? extends K> keySelector;
        public final GroupByProducer producer;
        public final Queue<GroupedObservable<K, V>> queue = new ConcurrentLinkedQueue();
        public final AtomicLong requested;

        /* renamed from: s  reason: collision with root package name */
        public final ProducerArbiter f53411s;
        public final Func1<? super T, ? extends V> valueSelector;
        public final AtomicInteger wip;

        public static class EvictionAction<K> implements Action1<K> {
            public final Queue<K> evictedKeys;

            public EvictionAction(Queue<K> queue) {
                this.evictedKeys = queue;
            }

            public void call(K k11) {
                this.evictedKeys.offer(k11);
            }
        }

        public GroupBySubscriber(Subscriber<? super GroupedObservable<K, V>> subscriber, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, int i11, boolean z11, Func1<Action1<K>, Map<K, Object>> func13) {
            this.actual = subscriber;
            this.keySelector = func1;
            this.valueSelector = func12;
            this.bufferSize = i11;
            this.delayError = z11;
            ProducerArbiter producerArbiter = new ProducerArbiter();
            this.f53411s = producerArbiter;
            producerArbiter.request((long) i11);
            this.producer = new GroupByProducer(this);
            this.cancelled = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.groupCount = new AtomicInteger(1);
            this.wip = new AtomicInteger();
            if (func13 == null) {
                this.groups = new ConcurrentHashMap();
                this.evictedKeys = null;
                return;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            this.evictedKeys = concurrentLinkedQueue;
            this.groups = createMap(func13, new EvictionAction(concurrentLinkedQueue));
        }

        private Map<Object, GroupedUnicast<K, V>> createMap(Func1<Action1<K>, Map<K, Object>> func1, Action1<K> action1) {
            return func1.call(action1);
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) && this.groupCount.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        public boolean checkTerminated(boolean z11, boolean z12, Subscriber<? super GroupedObservable<K, V>> subscriber, Queue<?> queue2) {
            if (!z11) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                errorAll(subscriber, queue2, th2);
                return true;
            } else if (!z12) {
                return false;
            } else {
                this.actual.onCompleted();
                return true;
            }
        }

        public void drain() {
            if (this.wip.getAndIncrement() == 0) {
                Queue<GroupedObservable<K, V>> queue2 = this.queue;
                Subscriber<? super GroupedObservable<K, V>> subscriber = this.actual;
                int i11 = 1;
                while (!checkTerminated(this.done, queue2.isEmpty(), subscriber, queue2)) {
                    long j11 = this.requested.get();
                    long j12 = 0;
                    while (j12 != j11) {
                        boolean z11 = this.done;
                        GroupedObservable poll = queue2.poll();
                        boolean z12 = poll == null;
                        if (!checkTerminated(z11, z12, subscriber, queue2)) {
                            if (z12) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j12++;
                        } else {
                            return;
                        }
                    }
                    if (j12 != 0) {
                        if (j11 != Long.MAX_VALUE) {
                            BackpressureUtils.produced(this.requested, j12);
                        }
                        this.f53411s.request(j12);
                    }
                    i11 = this.wip.addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void errorAll(Subscriber<? super GroupedObservable<K, V>> subscriber, Queue<?> queue2, Throwable th2) {
            queue2.clear();
            ArrayList<GroupedUnicast> arrayList = new ArrayList<>(this.groups.values());
            this.groups.clear();
            Queue<K> queue3 = this.evictedKeys;
            if (queue3 != null) {
                queue3.clear();
            }
            for (GroupedUnicast onError : arrayList) {
                onError.onError(th2);
            }
            subscriber.onError(th2);
        }

        public void onCompleted() {
            if (!this.done) {
                for (GroupedUnicast<K, V> onComplete : this.groups.values()) {
                    onComplete.onComplete();
                }
                this.groups.clear();
                Queue<K> queue2 = this.evictedKeys;
                if (queue2 != null) {
                    queue2.clear();
                }
                this.done = true;
                this.groupCount.decrementAndGet();
                drain();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                RxJavaHooks.onError(th2);
                return;
            }
            this.error = th2;
            this.done = true;
            this.groupCount.decrementAndGet();
            drain();
        }

        public void onNext(T t11) {
            Object obj;
            if (!this.done) {
                Queue<GroupedObservable<K, V>> queue2 = this.queue;
                Subscriber<? super GroupedObservable<K, V>> subscriber = this.actual;
                try {
                    Object call = this.keySelector.call(t11);
                    boolean z11 = false;
                    if (call != null) {
                        obj = call;
                    } else {
                        obj = NULL_KEY;
                    }
                    GroupedUnicast groupedUnicast = this.groups.get(obj);
                    if (groupedUnicast == null) {
                        if (!this.cancelled.get()) {
                            groupedUnicast = GroupedUnicast.createWith(call, this.bufferSize, this, this.delayError);
                            this.groups.put(obj, groupedUnicast);
                            this.groupCount.getAndIncrement();
                            z11 = true;
                        } else {
                            return;
                        }
                    }
                    try {
                        groupedUnicast.onNext(this.valueSelector.call(t11));
                        if (this.evictedKeys != null) {
                            while (true) {
                                K poll = this.evictedKeys.poll();
                                if (poll == null) {
                                    break;
                                }
                                GroupedUnicast groupedUnicast2 = this.groups.get(poll);
                                if (groupedUnicast2 != null) {
                                    groupedUnicast2.onComplete();
                                }
                            }
                        }
                        if (z11) {
                            queue2.offer(groupedUnicast);
                            drain();
                        }
                    } catch (Throwable th2) {
                        unsubscribe();
                        errorAll(subscriber, queue2, th2);
                    }
                } catch (Throwable th3) {
                    unsubscribe();
                    errorAll(subscriber, queue2, th3);
                }
            }
        }

        public void requestMore(long j11) {
            if (j11 >= 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j11);
                drain();
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j11);
        }

        public void setProducer(Producer producer2) {
            this.f53411s.setProducer(producer2);
        }

        public void cancel(K k11) {
            if (k11 == null) {
                k11 = NULL_KEY;
            }
            if (this.groups.remove(k11) != null && this.groupCount.decrementAndGet() == 0) {
                unsubscribe();
            }
        }
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func1<Action1<K>, Map<K, Object>> func13) {
        this(func1, func12, RxRingBuffer.SIZE, false, func13);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, int i11, boolean z11, Func1<Action1<K>, Map<K, Object>> func13) {
        this.keySelector = func1;
        this.valueSelector = func12;
        this.bufferSize = i11;
        this.delayError = z11;
        this.mapFactory = func13;
    }
}
