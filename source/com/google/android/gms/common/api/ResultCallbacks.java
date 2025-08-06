package com.google.android.gms.common.api;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(Status status);

    @KeepForSdk
    public final void onResult(R r11) {
        Status status = r11.getStatus();
        if (status.isSuccess()) {
            onSuccess(r11);
            return;
        }
        onFailure(status);
        if (r11 instanceof Releasable) {
            try {
                ((Releasable) r11).release();
            } catch (RuntimeException e11) {
                Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(r11)), e11);
            }
        }
    }

    public abstract void onSuccess(R r11);
}
