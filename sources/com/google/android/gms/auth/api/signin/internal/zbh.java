package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

final class zbh extends zba {
    public final /* synthetic */ zbi zba;

    public zbh(zbi zbi) {
        this.zba = zbi;
    }

    public final void zbc(Status status) throws RemoteException {
        this.zba.setResult(status);
    }
}
