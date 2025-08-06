package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import java.util.Objects;

public abstract class a<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f55511c;

    public a(Flowable<T> flowable) {
        Objects.requireNonNull(flowable, "source is null");
        this.f55511c = flowable;
    }
}
