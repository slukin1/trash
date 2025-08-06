package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.SchedulePeriodicHelper;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

public class TestScheduler extends Scheduler {
    public static long counter;
    public final Queue<TimedAction> queue = new PriorityQueue(11, new CompareActionsByTime());
    public long time;

    public static final class CompareActionsByTime implements Comparator<TimedAction> {
        public int compare(TimedAction timedAction, TimedAction timedAction2) {
            long j11 = timedAction.time;
            long j12 = timedAction2.time;
            if (j11 == j12) {
                if (timedAction.count < timedAction2.count) {
                    return -1;
                }
                if (timedAction.count > timedAction2.count) {
                    return 1;
                }
                return 0;
            } else if (j11 < j12) {
                return -1;
            } else {
                if (j11 > j12) {
                    return 1;
                }
                return 0;
            }
        }
    }

    public static final class TimedAction {
        public final Action0 action;
        /* access modifiers changed from: private */
        public final long count;
        public final Scheduler.Worker scheduler;
        public final long time;

        public TimedAction(Scheduler.Worker worker, long j11, Action0 action0) {
            long j12 = TestScheduler.counter;
            TestScheduler.counter = 1 + j12;
            this.count = j12;
            this.time = j11;
            this.action = action0;
            this.scheduler = worker;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", new Object[]{Long.valueOf(this.time), this.action.toString()});
        }
    }

    public void advanceTimeBy(long j11, TimeUnit timeUnit) {
        advanceTimeTo(this.time + timeUnit.toNanos(j11), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j11, TimeUnit timeUnit) {
        triggerActions(timeUnit.toNanos(j11));
    }

    public Scheduler.Worker createWorker() {
        return new InnerTestScheduler();
    }

    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.time);
    }

    public void triggerActions() {
        triggerActions(this.time);
    }

    private void triggerActions(long j11) {
        while (!this.queue.isEmpty()) {
            TimedAction peek = this.queue.peek();
            long j12 = peek.time;
            if (j12 > j11) {
                break;
            }
            if (j12 == 0) {
                j12 = this.time;
            }
            this.time = j12;
            this.queue.remove();
            if (!peek.scheduler.isUnsubscribed()) {
                peek.action.call();
            }
        }
        this.time = j11;
    }

    public final class InnerTestScheduler extends Scheduler.Worker implements SchedulePeriodicHelper.NowNanoSupplier {

        /* renamed from: s  reason: collision with root package name */
        private final BooleanSubscription f47816s = new BooleanSubscription();

        public InnerTestScheduler() {
        }

        public boolean isUnsubscribed() {
            return this.f47816s.isUnsubscribed();
        }

        public long now() {
            return TestScheduler.this.now();
        }

        public long nowNanos() {
            return TestScheduler.this.time;
        }

        public Subscription schedule(Action0 action0, long j11, TimeUnit timeUnit) {
            final TimedAction timedAction = new TimedAction(this, TestScheduler.this.time + timeUnit.toNanos(j11), action0);
            TestScheduler.this.queue.add(timedAction);
            return Subscriptions.create(new Action0() {
                public void call() {
                    TestScheduler.this.queue.remove(timedAction);
                }
            });
        }

        public Subscription schedulePeriodically(Action0 action0, long j11, long j12, TimeUnit timeUnit) {
            return SchedulePeriodicHelper.schedulePeriodically(this, action0, j11, j12, timeUnit, this);
        }

        public void unsubscribe() {
            this.f47816s.unsubscribe();
        }

        public Subscription schedule(Action0 action0) {
            final TimedAction timedAction = new TimedAction(this, 0, action0);
            TestScheduler.this.queue.add(timedAction);
            return Subscriptions.create(new Action0() {
                public void call() {
                    TestScheduler.this.queue.remove(timedAction);
                }
            });
        }
    }
}
