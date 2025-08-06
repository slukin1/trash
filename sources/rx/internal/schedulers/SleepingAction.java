package rx.internal.schedulers;

import rx.Scheduler;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

class SleepingAction implements Action0 {
    private final long execTime;
    private final Scheduler.Worker innerScheduler;
    private final Action0 underlying;

    public SleepingAction(Action0 action0, Scheduler.Worker worker, long j11) {
        this.underlying = action0;
        this.innerScheduler = worker;
        this.execTime = j11;
    }

    public void call() {
        if (!this.innerScheduler.isUnsubscribed()) {
            long now = this.execTime - this.innerScheduler.now();
            if (now > 0) {
                try {
                    Thread.sleep(now);
                } catch (InterruptedException e11) {
                    Thread.currentThread().interrupt();
                    Exceptions.propagate(e11);
                }
            }
            if (!this.innerScheduler.isUnsubscribed()) {
                this.underlying.call();
            }
        }
    }
}
