package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdq extends zzdu {
    public final /* synthetic */ zzdw zza;
    public final /* synthetic */ zzef zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdq(zzef zzef, zzdw zzdw) {
        super(zzef, true);
        this.zzb = zzef;
        this.zza = zzdw;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzb.zzj)).registerOnMeasurementEventListener(this.zza);
    }
}
