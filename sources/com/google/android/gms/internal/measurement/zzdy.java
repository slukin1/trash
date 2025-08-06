package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzdy extends zzdu {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ zzee zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdy(zzee zzee, Activity activity) {
        super(zzee.zza, true);
        this.zzb = zzee;
        this.zza = activity;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzb.zza.zzj)).onActivityStarted(ObjectWrapper.wrap(this.zza), this.zzi);
    }
}
