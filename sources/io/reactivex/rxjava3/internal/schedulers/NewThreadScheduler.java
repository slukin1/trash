package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.ThreadFactory;

public final class NewThreadScheduler extends Scheduler {

    /* renamed from: d  reason: collision with root package name */
    public static final RxThreadFactory f55655d = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));

    /* renamed from: c  reason: collision with root package name */
    public final ThreadFactory f55656c;

    public NewThreadScheduler() {
        this(f55655d);
    }

    public Scheduler.Worker a() {
        return new b(this.f55656c);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f55656c = threadFactory;
    }
}
