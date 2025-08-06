package com.google.android.gms.internal.p041authapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbag  reason: invalid package */
public abstract class zbag extends zbb implements zbah {
    public zbag() {
        super("com.google.android.gms.auth.api.identity.internal.ISavePasswordCallback");
    }

    public final boolean zba(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zbc.zbb(parcel);
        zbb((Status) zbc.zba(parcel, Status.CREATOR), (SavePasswordResult) zbc.zba(parcel, SavePasswordResult.CREATOR));
        return true;
    }
}
