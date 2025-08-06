package com.google.android.gms.internal.p041authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbg  reason: invalid package */
final class zbg extends zbm {
    public final /* synthetic */ CredentialRequest zba;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zbg(zbl zbl, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        super(googleApiClient);
        this.zba = credentialRequest;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zbe(status, (Credential) null);
    }

    public final void zba(Context context, zbt zbt) throws RemoteException {
        zbt.zbd(new zbf(this), this.zba);
    }
}
