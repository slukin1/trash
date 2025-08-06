package com.google.android.gms.internal.p041authapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbae  reason: invalid package */
public abstract class zbae extends zbb implements zbaf {
    public zbae() {
        super("com.google.android.gms.auth.api.identity.internal.ISaveAccountLinkingTokenCallback");
    }

    public final boolean zba(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zbc.zbb(parcel);
        zbb((Status) zbc.zba(parcel, Status.CREATOR), (SaveAccountLinkingTokenResult) zbc.zba(parcel, SaveAccountLinkingTokenResult.CREATOR));
        return true;
    }
}
