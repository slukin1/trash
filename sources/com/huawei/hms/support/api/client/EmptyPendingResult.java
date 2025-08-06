package com.huawei.hms.support.api.client;

import android.os.Looper;
import com.huawei.hms.support.api.client.Result;
import java.util.concurrent.TimeUnit;

public class EmptyPendingResult<R extends Result> extends PendingResult<R> {
    private R result;

    public R await() {
        return this.result;
    }

    public void cancel() {
    }

    public R getResult() {
        return this.result;
    }

    public boolean isCanceled() {
        return false;
    }

    public void setResult(R r11) {
        this.result = r11;
    }

    public void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
    }

    public void setResultCallback(ResultCallback<R> resultCallback) {
    }

    public void setResultCallback(ResultCallback<R> resultCallback, long j11, TimeUnit timeUnit) {
    }

    public R await(long j11, TimeUnit timeUnit) {
        return this.result;
    }
}
