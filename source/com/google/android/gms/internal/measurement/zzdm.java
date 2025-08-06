package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdm extends zzdu {
    public final /* synthetic */ zzbz zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzef zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdm(zzef zzef, zzbz zzbz, int i11) {
        super(zzef, true);
        this.zzc = zzef;
        this.zza = zzbz;
        this.zzb = i11;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzc.zzj)).getTestFlag(this.zza, this.zzb);
    }

    public final void zzb() {
        this.zza.zze((Bundle) null);
    }
}
