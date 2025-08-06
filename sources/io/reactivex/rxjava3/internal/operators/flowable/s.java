package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import z20.c;

public final class s<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final FlowableProcessor<T> f55528c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f55529d = new AtomicBoolean();

    public s(FlowableProcessor<T> flowableProcessor) {
        this.f55528c = flowableProcessor;
    }

    public void j(c<? super T> cVar) {
        this.f55528c.subscribe(cVar);
        this.f55529d.set(true);
    }

    public boolean m() {
        return !this.f55529d.get() && this.f55529d.compareAndSet(false, true);
    }
}
