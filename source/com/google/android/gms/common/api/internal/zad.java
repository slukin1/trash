package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zad<T> extends zac {
    public final TaskCompletionSource<T> zaa;

    public zad(int i11, TaskCompletionSource<T> taskCompletionSource) {
        super(i11);
        this.zaa = taskCompletionSource;
    }

    public abstract void zac(zabq<?> zabq) throws RemoteException;

    public final void zad(Status status) {
        this.zaa.trySetException(new ApiException(status));
    }

    public final void zae(Exception exc) {
        this.zaa.trySetException(exc);
    }

    public final void zaf(zabq<?> zabq) throws DeadObjectException {
        try {
            zac(zabq);
        } catch (DeadObjectException e11) {
            zad(zai.zah(e11));
            throw e11;
        } catch (RemoteException e12) {
            zad(zai.zah(e12));
        } catch (RuntimeException e13) {
            this.zaa.trySetException(e13);
        }
    }

    public void zag(zaad zaad, boolean z11) {
    }
}
