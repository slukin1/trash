package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.SchedulePeriodicHelper;
import rx.internal.schedulers.SchedulerWhen;

public abstract class Scheduler {

    public static abstract class Worker implements Subscription {
        public long now() {
            return System.currentTimeMillis();
        }

        public abstract Subscription schedule(Action0 action0);

        public abstract Subscription schedule(Action0 action0, long j11, TimeUnit timeUnit);

        public Subscription schedulePeriodically(Action0 action0, long j11, long j12, TimeUnit timeUnit) {
            return SchedulePeriodicHelper.schedulePeriodically(this, action0, j11, j12, timeUnit, (SchedulePeriodicHelper.NowNanoSupplier) null);
        }
    }

    public abstract Worker createWorker();

    public long now() {
        return System.currentTimeMillis();
    }

    public <S extends Scheduler & Subscription> S when(Func1<Observable<Observable<Completable>>, Completable> func1) {
        return new SchedulerWhen(func1, this);
    }
}
