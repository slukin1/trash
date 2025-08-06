package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

final class zacy implements Runnable {
    public final /* synthetic */ Result zaa;
    public final /* synthetic */ zada zab;

    public zacy(zada zada, Result result) {
        this.zab = zada;
        this.zaa = result;
    }

    public final void run() {
        GoogleApiClient googleApiClient;
        try {
            ThreadLocal<Boolean> threadLocal = BasePendingResult.zaa;
            threadLocal.set(Boolean.TRUE);
            PendingResult onSuccess = ((ResultTransform) Preconditions.checkNotNull(this.zab.zaa)).onSuccess(this.zaa);
            zada zada = this.zab;
            zada.zah.sendMessage(zada.zah.obtainMessage(0, onSuccess));
            threadLocal.set(Boolean.FALSE);
            zada.zan(this.zaa);
            googleApiClient = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient == null) {
                return;
            }
        } catch (RuntimeException e11) {
            zada zada2 = this.zab;
            zada2.zah.sendMessage(zada2.zah.obtainMessage(1, e11));
            BasePendingResult.zaa.set(Boolean.FALSE);
            zada.zan(this.zaa);
            googleApiClient = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient == null) {
                return;
            }
        } catch (Throwable th2) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zada.zan(this.zaa);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zap(this.zab);
            }
            throw th2;
        }
        googleApiClient.zap(this.zab);
    }
}
