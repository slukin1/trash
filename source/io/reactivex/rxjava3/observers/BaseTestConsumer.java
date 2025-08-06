package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.internal.util.VolatileSizeArrayList;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> {

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f55714b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public final List<T> f55715c = new VolatileSizeArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final List<Throwable> f55716d = new VolatileSizeArrayList();

    /* renamed from: e  reason: collision with root package name */
    public long f55717e;

    /* renamed from: f  reason: collision with root package name */
    public Thread f55718f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55719g;
}
