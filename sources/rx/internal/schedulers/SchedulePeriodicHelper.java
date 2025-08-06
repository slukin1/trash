package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.subscriptions.SequentialSubscription;

public final class SchedulePeriodicHelper {
    public static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public interface NowNanoSupplier {
        long nowNanos();
    }

    private SchedulePeriodicHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription schedulePeriodically(Scheduler.Worker worker, Action0 action0, long j11, long j12, TimeUnit timeUnit, NowNanoSupplier nowNanoSupplier) {
        long j13 = j11;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j12);
        long nowNanos = nowNanoSupplier != null ? nowNanoSupplier.nowNanos() : TimeUnit.MILLISECONDS.toNanos(worker.now());
        SequentialSubscription sequentialSubscription = new SequentialSubscription();
        SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
        SequentialSubscription sequentialSubscription3 = sequentialSubscription2;
        AnonymousClass1 r15 = r3;
        AnonymousClass1 r32 = new Action0(nowNanos, timeUnit2.toNanos(j13) + nowNanos, action0, sequentialSubscription2, nowNanoSupplier, worker, nanos) {
            public long count;
            public long lastNowNanos;
            public long startInNanos;
            public final /* synthetic */ Action0 val$action;
            public final /* synthetic */ long val$firstNowNanos;
            public final /* synthetic */ long val$firstStartInNanos;
            public final /* synthetic */ SequentialSubscription val$mas;
            public final /* synthetic */ NowNanoSupplier val$nowNanoSupplier;
            public final /* synthetic */ long val$periodInNanos;
            public final /* synthetic */ Scheduler.Worker val$worker;

            {
                this.val$firstNowNanos = r1;
                this.val$firstStartInNanos = r3;
                this.val$action = r5;
                this.val$mas = r6;
                this.val$nowNanoSupplier = r7;
                this.val$worker = r8;
                this.val$periodInNanos = r9;
                this.lastNowNanos = r1;
                this.startInNanos = r3;
            }

            public void call() {
                long j11;
                this.val$action.call();
                if (!this.val$mas.isUnsubscribed()) {
                    NowNanoSupplier nowNanoSupplier = this.val$nowNanoSupplier;
                    long nowNanos = nowNanoSupplier != null ? nowNanoSupplier.nowNanos() : TimeUnit.MILLISECONDS.toNanos(this.val$worker.now());
                    long j12 = SchedulePeriodicHelper.CLOCK_DRIFT_TOLERANCE_NANOS;
                    long j13 = this.lastNowNanos;
                    if (nowNanos + j12 >= j13) {
                        long j14 = this.val$periodInNanos;
                        if (nowNanos < j13 + j14 + j12) {
                            long j15 = this.startInNanos;
                            long j16 = this.count + 1;
                            this.count = j16;
                            j11 = j15 + (j16 * j14);
                            this.lastNowNanos = nowNanos;
                            this.val$mas.replace(this.val$worker.schedule(this, j11 - nowNanos, TimeUnit.NANOSECONDS));
                        }
                    }
                    long j17 = this.val$periodInNanos;
                    long j18 = nowNanos + j17;
                    long j19 = this.count + 1;
                    this.count = j19;
                    this.startInNanos = j18 - (j17 * j19);
                    j11 = j18;
                    this.lastNowNanos = nowNanos;
                    this.val$mas.replace(this.val$worker.schedule(this, j11 - nowNanos, TimeUnit.NANOSECONDS));
                }
            }
        };
        sequentialSubscription.replace(worker.schedule(r15, j13, timeUnit2));
        return sequentialSubscription3;
    }
}
