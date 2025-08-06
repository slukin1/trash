package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.q;

final class av extends at {

    /* renamed from: c  reason: collision with root package name */
    private final q f66809c = new q("OnWarmUpIntegrityTokenCallback");

    public av(ax axVar, TaskCompletionSource taskCompletionSource) {
        super(axVar, taskCompletionSource);
    }

    public final void e(Bundle bundle) throws RemoteException {
        super.e(bundle);
        this.f66809c.c("onWarmUpExpressIntegrityToken", new Object[0]);
        int i11 = bundle.getInt("error");
        if (i11 != 0) {
            this.f66806a.trySetException(new StandardIntegrityException(i11, (Throwable) null));
        } else {
            this.f66806a.trySetResult(Long.valueOf(bundle.getLong("warm.up.sid")));
        }
    }
}
