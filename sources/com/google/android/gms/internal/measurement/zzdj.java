package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdj extends zzdu {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzbz zzb;
    public final /* synthetic */ zzef zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdj(zzef zzef, String str, zzbz zzbz) {
        super(zzef, true);
        this.zzc = zzef;
        this.zza = str;
        this.zzb = zzbz;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzc.zzj)).getMaxUserProperties(this.zza, this.zzb);
    }

    public final void zzb() {
        this.zzb.zze((Bundle) null);
    }
}
