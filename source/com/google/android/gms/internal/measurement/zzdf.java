package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzdf extends zzdu {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ zzbz zzd;
    public final /* synthetic */ zzef zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdf(zzef zzef, String str, String str2, boolean z11, zzbz zzbz) {
        super(zzef, true);
        this.zze = zzef;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z11;
        this.zzd = zzbz;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zze.zzj)).getUserProperties(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public final void zzb() {
        this.zzd.zze((Bundle) null);
    }
}
