package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;

public abstract class zai {
    public final int zac;

    public zai(int i11) {
        this.zac = i11;
    }

    public static /* bridge */ /* synthetic */ Status zah(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + l.f34627b + remoteException.getLocalizedMessage());
    }

    public abstract void zad(Status status);

    public abstract void zae(Exception exc);

    public abstract void zaf(zabq<?> zabq) throws DeadObjectException;

    public abstract void zag(zaad zaad, boolean z11);
}
