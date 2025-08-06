package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzds extends zzdu {
    public final /* synthetic */ Long zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ Bundle zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ boolean zzf;
    public final /* synthetic */ zzef zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzds(zzef zzef, Long l11, String str, String str2, Bundle bundle, boolean z11, boolean z12) {
        super(zzef, true);
        this.zzg = zzef;
        this.zza = l11;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bundle;
        this.zze = z11;
        this.zzf = z12;
    }

    public final void zza() throws RemoteException {
        long j11;
        Long l11 = this.zza;
        if (l11 == null) {
            j11 = this.zzh;
        } else {
            j11 = l11.longValue();
        }
        ((zzcc) Preconditions.checkNotNull(this.zzg.zzj)).logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, j11);
    }
}
