package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzco extends zzdu {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ zzef zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzco(zzef zzef, String str, String str2, Bundle bundle) {
        super(zzef, true);
        this.zzd = zzef;
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzd.zzj)).clearConditionalUserProperty(this.zza, this.zzb, this.zzc);
    }
}
