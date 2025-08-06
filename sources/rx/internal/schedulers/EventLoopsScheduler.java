package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class EventLoopsScheduler extends Scheduler implements SchedulerLifecycle {
    public static final String KEY_MAX_THREADS = "rx.scheduler.max-computation-threads";
    public static final int MAX_THREADS;
    public static final FixedSchedulerPool NONE = new FixedSchedulerPool((ThreadFactory) null, 0);
    public static final PoolWorker SHUTDOWN_WORKER;
    public final AtomicReference<FixedSchedulerPool> pool = new AtomicReference<>(NONE);
    public final ThreadFactory threadFactory;

    public static final class FixedSchedulerPool {
        public final int cores;
        public final PoolWorker[] eventLoops;

        /* renamed from: n  reason: collision with root package name */
        public long f53418n;

        public FixedSchedulerPool(ThreadFactory threadFactory, int i11) {
            this.cores = i11;
            this.eventLoops = new PoolWorker[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                this.eventLoops[i12] = new PoolWorker(threadFactory);
            }
        }

        public PoolWorker getEventLoop() {
            int i11 = this.cores;
            if (i11 == 0) {
                return EventLoopsScheduler.SHUTDOWN_WORKER;
            }
            PoolWorker[] poolWorkerArr = this.eventLoops;
            long j11 = this.f53418n;
            this.f53418n = 1 + j11;
            return poolWorkerArr[(int) (j11 % ((long) i11))];
        }

        public void shutdown() {
            for (PoolWorker unsubscribe : this.eventLoops) {
                unsubscribe.unsubscribe();
            }
        }
    }

    public static final class PoolWorker extends NewThreadWorker {
        public PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger(KEY_MAX_THREADS, 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        MAX_THREADS = intValue;
        PoolWorker poolWorker = new PoolWorker(RxThreadFactory.NONE);
        SHUTDOWN_WORKER = poolWorker;
        poolWorker.unsubscribe();
    }

    public EventLoopsScheduler(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
        start();
    }

    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get().getEventLoop());
    }

    public Subscription scheduleDirect(Action0 action0) {
        return this.pool.get().getEventLoop().scheduleActual(action0, -1, TimeUnit.NANOSECONDS);
    }

    public void shutdown() {
        FixedSchedulerPool fixedSchedulerPool;
        FixedSchedulerPool fixedSchedulerPool2;
        do {
            fixedSchedulerPool = this.pool.get();
            fixedSchedulerPool2 = NONE;
            if (fixedSchedulerPool == fixedSchedulerPool2) {
                return;
            }
        } while (!this.pool.compareAndSet(fixedSchedulerPool, fixedSchedulerPool2));
        fixedSchedulerPool.shutdown();
    }

    public void start() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(this.threadFactory, MAX_THREADS);
        if (!this.pool.compareAndSet(NONE, fixedSchedulerPool)) {
            fixedSchedulerPool.shutdown();
        }
    }

    public static final class EventLoopWorker extends Scheduler.Worker {
        private final SubscriptionList both;
        private final PoolWorker poolWorker;
        private final SubscriptionList serial;
        private final CompositeSubscription timed;

        public EventLoopWorker(PoolWorker poolWorker2) {
            SubscriptionList subscriptionList = new SubscriptionList();
            this.serial = subscriptionList;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.timed = compositeSubscription;
            this.both = new SubscriptionList(subscriptionList, compositeSubscription);
            this.poolWorker = poolWorker2;
        }

        public boolean isUnsubscribed() {
            return this.both.isUnsubscribed();
        }

        public Subscription schedule(final Action0 action0) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            return this.poolWorker.scheduleActual((Action0) new Action0() {
                public void call() {
                    if (!EventLoopWorker.this.isUnsubscribed()) {
                        action0.call();
                    }
                }
            }, 0, (TimeUnit) null, this.serial);
        }

        public void unsubscribe() {
            this.both.unsubscribe();
        }

        public Subscription schedule(final Action0 action0, long j11, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            return this.poolWorker.scheduleActual((Action0) new Action0() {
                public void call() {
                    if (!EventLoopWorker.this.isUnsubscribed()) {
                        action0.call();
                    }
                }
            }, j11, timeUnit, this.timed);
        }
    }
}
