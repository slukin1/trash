package com.google.android.gms.internal.p041authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbi  reason: invalid package */
final class zbi extends zbm {
    public final /* synthetic */ Credential zba;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zbi(zbl zbl, GoogleApiClient googleApiClient, Credential credential) {
        super(googleApiClient);
        this.zba = credential;
    }

    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final void zba(Context context, zbt zbt) throws RemoteException {
        zbt.zbc(new zbk(this), new zbp(this.zba));
    }
}
