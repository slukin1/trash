package com.huawei.hms.common.api.internal;

import android.os.Looper;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import java.util.concurrent.TimeUnit;

@Deprecated
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {

    /* renamed from: a  reason: collision with root package name */
    private final PendingResult<R> f37885a;

    public OptionalPendingResultImpl(PendingResult<R> pendingResult) {
        this.f37885a = pendingResult;
    }

    public final void addStatusListener() {
    }

    public final R await() {
        return this.f37885a.await();
    }

    public final void cancel() {
    }

    public final R get() {
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    public final boolean isCanceled() {
        return false;
    }

    public final boolean isDone() {
        return false;
    }

    public final void setResultCallback(ResultCallback<R> resultCallback) {
        this.f37885a.setResultCallback(resultCallback);
    }

    public final R await(long j11, TimeUnit timeUnit) {
        return this.f37885a.await(j11, timeUnit);
    }

    public void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        this.f37885a.setResultCallback(looper, resultCallback);
    }

    public final void setResultCallback(ResultCallback<R> resultCallback, long j11, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }
}
