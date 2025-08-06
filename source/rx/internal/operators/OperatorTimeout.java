package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.operators.OperatorTimeoutBase;

public final class OperatorTimeout<T> extends OperatorTimeoutBase<T> {
    public OperatorTimeout(final long j11, final TimeUnit timeUnit, Observable<? extends T> observable, Scheduler scheduler) {
        super(new OperatorTimeoutBase.FirstTimeoutStub<T>() {
            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long l11, Scheduler.Worker worker) {
                return worker.schedule(new Action0() {
                    public void call() {
                        timeoutSubscriber.onTimeout(l11.longValue());
                    }
                }, j11, timeUnit);
            }
        }, new OperatorTimeoutBase.TimeoutStub<T>() {
            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long l11, T t11, Scheduler.Worker worker) {
                return worker.schedule(new Action0() {
                    public void call() {
                        timeoutSubscriber.onTimeout(l11.longValue());
                    }
                }, j11, timeUnit);
            }
        }, observable, scheduler);
    }

    public /* bridge */ /* synthetic */ Subscriber call(Subscriber subscriber) {
        return super.call(subscriber);
    }
}
