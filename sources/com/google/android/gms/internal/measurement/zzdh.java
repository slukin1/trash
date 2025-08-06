package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdh extends zzdu {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzbz zzb;
    public final /* synthetic */ zzef zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdh(zzef zzef, Bundle bundle, zzbz zzbz) {
        super(zzef, true);
        this.zzc = zzef;
        this.zza = bundle;
        this.zzb = zzbz;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzc.zzj)).performAction(this.zza, this.zzb, this.zzh);
    }

    public final void zzb() {
        this.zzb.zze((Bundle) null);
    }
}
