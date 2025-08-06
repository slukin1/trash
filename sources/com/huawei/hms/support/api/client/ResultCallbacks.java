package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.Releasable;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.log.HMSLog;

@Deprecated
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    private static final String TAG = "ResultCallbacks";

    public abstract void onFailure(Status status);

    public abstract void onSuccess(R r11);

    public final void onResult(R r11) {
        try {
            Status status = r11.getStatus();
            if (status.isSuccess()) {
                onSuccess(r11);
                return;
            }
            onFailure(status);
            if (r11 instanceof Releasable) {
                ((Releasable) r11).release();
            }
        } catch (Exception e11) {
            HMSLog.w(TAG, "Failed to release " + r11 + ", reason: " + e11);
        }
    }
}
