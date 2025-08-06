package rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

public final class TrampolineScheduler extends Scheduler {
    public static final TrampolineScheduler INSTANCE = new TrampolineScheduler();

    public static final class InnerCurrentThreadScheduler extends Scheduler.Worker {
        public final AtomicInteger counter = new AtomicInteger();
        private final BooleanSubscription innerSubscription = new BooleanSubscription();
        public final PriorityBlockingQueue<TimedAction> queue = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();

        private Subscription enqueue(Action0 action0, long j11) {
            if (this.innerSubscription.isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            final TimedAction timedAction = new TimedAction(action0, Long.valueOf(j11), this.counter.incrementAndGet());
            this.queue.add(timedAction);
            if (this.wip.getAndIncrement() != 0) {
                return Subscriptions.create(new Action0() {
                    public void call() {
                        InnerCurrentThreadScheduler.this.queue.remove(timedAction);
                    }
                });
            }
            do {
                TimedAction poll = this.queue.poll();
                if (poll != null) {
                    poll.action.call();
                }
            } while (this.wip.decrementAndGet() > 0);
            return Subscriptions.unsubscribed();
        }

        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }

        public Subscription schedule(Action0 action0) {
            return enqueue(action0, now());
        }

        public void unsubscribe() {
            this.innerSubscription.unsubscribe();
        }

        public Subscription schedule(Action0 action0, long j11, TimeUnit timeUnit) {
            long now = now() + timeUnit.toMillis(j11);
            return enqueue(new SleepingAction(action0, this, now), now);
        }
    }

    public static final class TimedAction implements Comparable<TimedAction> {
        public final Action0 action;
        public final int count;
        public final Long execTime;

        public TimedAction(Action0 action0, Long l11, int i11) {
            this.action = action0;
            this.execTime = l11;
            this.count = i11;
        }

        public int compareTo(TimedAction timedAction) {
            int compareTo = this.execTime.compareTo(timedAction.execTime);
            return compareTo == 0 ? TrampolineScheduler.compare(this.count, timedAction.count) : compareTo;
        }
    }

    private TrampolineScheduler() {
    }

    public static int compare(int i11, int i12) {
        if (i11 < i12) {
            return -1;
        }
        return i11 == i12 ? 0 : 1;
    }

    public Scheduler.Worker createWorker() {
        return new InnerCurrentThreadScheduler();
    }
}
