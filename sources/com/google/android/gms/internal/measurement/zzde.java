package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzde extends zzdu {
    public final /* synthetic */ zzbz zza;
    public final /* synthetic */ zzef zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzde(zzef zzef, zzbz zzbz) {
        super(zzef, true);
        this.zzb = zzef;
        this.zza = zzbz;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzb.zzj)).getCurrentScreenClass(this.zza);
    }

    public final void zzb() {
        this.zza.zze((Bundle) null);
    }
}
