package com.google.android.gms.internal.p041authapi;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;

/* renamed from: com.google.android.gms.internal.auth-api.zbz  reason: invalid package */
public final class zbz extends zba {
    public zbz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ICredentialSavingService");
    }

    public final void zbc(zbaf zbaf, SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbaf);
        zbc.zbc(zba, saveAccountLinkingTokenRequest);
        zbb(1, zba);
    }

    public final void zbd(zbah zbah, SavePasswordRequest savePasswordRequest) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbah);
        zbc.zbc(zba, savePasswordRequest);
        zbb(2, zba);
    }
}
