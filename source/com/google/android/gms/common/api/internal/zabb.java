package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class zabb implements ResultCallback<Status> {
    public final /* synthetic */ StatusPendingResult zaa;
    public final /* synthetic */ boolean zab;
    public final /* synthetic */ GoogleApiClient zac;
    public final /* synthetic */ zabe zad;

    public zabb(zabe zabe, StatusPendingResult statusPendingResult, boolean z11, GoogleApiClient googleApiClient) {
        this.zad = zabe;
        this.zaa = statusPendingResult;
        this.zab = z11;
        this.zac = googleApiClient;
    }

    public final /* bridge */ /* synthetic */ void onResult(Result result) {
        Status status = (Status) result;
        Storage.getInstance(this.zad.zan).zac();
        if (status.isSuccess() && this.zad.isConnected()) {
            zabe zabe = this.zad;
            zabe.disconnect();
            zabe.connect();
        }
        this.zaa.setResult(status);
        if (this.zab) {
            this.zac.disconnect();
        }
    }
}
