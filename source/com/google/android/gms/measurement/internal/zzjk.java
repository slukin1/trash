package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcf;

final class zzjk implements Runnable {
    public final /* synthetic */ zzau zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzcf zzc;
    public final /* synthetic */ zzjz zzd;

    public zzjk(zzjz zzjz, zzau zzau, String str, zzcf zzcf) {
        this.zzd = zzjz;
        this.zza = zzau;
        this.zzb = str;
        this.zzc = zzcf;
    }

    public final void run() {
        zzgd zzgd;
        byte[] bArr = null;
        try {
            zzjz zzjz = this.zzd;
            zzej zzh = zzjz.zzb;
            if (zzh == null) {
                zzjz.zzt.zzaA().zzd().zza("Discarding data. Failed to send event to service to bundle");
                zzgd = this.zzd.zzt;
            } else {
                bArr = zzh.zzu(this.zza, this.zzb);
                this.zzd.zzQ();
                zzgd = this.zzd.zzt;
            }
        } catch (RemoteException e11) {
            this.zzd.zzt.zzaA().zzd().zzb("Failed to send event to the service to bundle", e11);
            zzgd = this.zzd.zzt;
        } catch (Throwable th2) {
            this.zzd.zzt.zzv().zzT(this.zzc, bArr);
            throw th2;
        }
        zzgd.zzv().zzT(this.zzc, bArr);
    }
}
