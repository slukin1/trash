package com.google.android.gms.auth.api.accounttransfer;

final class zzf extends zzj {
    public final /* synthetic */ zzg zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzf(zzg zzg, zzl zzl) {
        super(zzl);
        this.zza = zzg;
    }

    public final void zzc(DeviceMetaData deviceMetaData) {
        this.zza.zzb.setResult(deviceMetaData);
    }
}
